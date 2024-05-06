package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entites.Departement;
import modele.ModeleDepartement;

/**
 * Servlet implementation class ServletAuth
 */
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // private ModeleUser MUser = new ModeleUser();
	private ModeleDepartement MDepartement = new ModeleDepartement();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuth() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("username")== null) {
			response.sendRedirect("Login.jsp");
		}
		String etat = request.getParameter("etat");

		// get all parameters from the form
		// for (String key : request.getParameterMap().keySet()) {
		// 	System.out.println(key + " : " + request.getParameter(key));
		// }

		switch (etat) {
			case "ajouter":				
				System.out.println("Ajout");
				int chefId = Integer.parseInt(request.getParameter("chef"));
				MDepartement.setD(new Departement(request.getParameter("nom"), request.getParameter("info"), request.getParameter("image"), chefId));
				try {
					if(MDepartement.addDepartement()) {
						if(session.getAttribute("Error")!= null) session.removeAttribute("Error");
						response.sendRedirect("ListeDepartement.jsp");
					}else {
						session.setAttribute("Error", "Erreur lors de l'ajout du departement");
						response.sendRedirect("Error.jsp");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "modifier":
				MDepartement.setD(new Departement(
					Integer.parseInt(request.getParameter("id")),
					request.getParameter("nom"), 
					request.getParameter("info"), 
					request.getParameter("image"))
				);
				System.out.println(MDepartement.getD().getId()+" "+MDepartement.getD().getNom()+" "+MDepartement.getD().getInfo()+" "+MDepartement.getD().getImage());
				try {
					if(MDepartement.updateDepartement()) {
						if(session.getAttribute("Error")!= null) session.removeAttribute("Error");
						response.sendRedirect("ListeDepartement.jsp");
					}else {
						session.setAttribute("Error", "Erreur lors de la modification du departement");
						response.sendRedirect("Error.jsp");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case "supprimer":			
				try {
					if(MDepartement.deleteDepartement(Integer.parseInt(request.getParameter("id")))) {
						if(session.getAttribute("Error")!= null) session.removeAttribute("Error");
						response.sendRedirect("ListeDepartement.jsp");
					}else {
						session.setAttribute("Error", "Erreur lors de la suppression du departement");
						response.sendRedirect("Error.jsp");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			default:
				response.sendRedirect("ListeDepartement.jsp");
				break;
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
