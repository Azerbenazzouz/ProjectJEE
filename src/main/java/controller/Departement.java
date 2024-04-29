package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.ModeleDepartement;

/**
 * Servlet implementation class Departement
 */
@WebServlet("/Departement")
public class Departement extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModeleDepartement MDepartement = new ModeleDepartement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Departement() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void addDepartement(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();

		String nom = request.getParameter("nom");
		String info = request.getParameter("info");
		String image = request.getParameter("image");
		
		MDepartement.setD(new entites.Departement(nom, info, image));
		try {
		if(MDepartement.addDepartement()) {
				session.removeAttribute("Errordepartement");
				response.sendRedirect("ListeDepartement.jsp");
			}else {
				session.setAttribute("Errordepartement", "Erreur lors de l'ajout du departement");
				response.sendRedirect("ErrorDepartement.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateDepartement(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String info = request.getParameter("info");
		String image = request.getParameter("image");
		
		MDepartement.setD(new entites.Departement(id, nom, info, image));
		try {
			if(MDepartement.updateDepartement()) {
				session.removeAttribute("Errordepartement");
				response.sendRedirect("ListeDepartement.jsp");
			}else {
				session.setAttribute("Errordepartement", "Erreur lors de la modification du departement");
				response.sendRedirect("ErrorDepartement.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteDepartement(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();

		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			if(MDepartement.deleteDepartement(id)) {
				session.removeAttribute("Errordepartement");
				response.sendRedirect("ListeDepartement.jsp");
			}else {
				session.setAttribute("Errordepartement", "Erreur lors de la suppression du departement");
				response.sendRedirect("ErrorDepartement.jsp");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String etat = request.getParameter("etat");

		switch (etat) {
			case "ajouter":
				addDepartement(request, response);
				break;
			case "modifier":
				updateDepartement(request, response);
				break;
			case "supprimer":
				deleteDepartement(request, response);
				break;
			case "lister":
				response.sendRedirect("ListeDepartement.jsp");
				break;
			default:
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
