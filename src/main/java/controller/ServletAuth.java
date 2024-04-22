package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entites.Utilisateur;
import modele.ModeleUser;

/**
 * Servlet implementation class ServletAuth
 */
@WebServlet("/ServletAuth")
public class ServletAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ModeleUser MUser = new ModeleUser();
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
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Utilisateur u = new Utilisateur();
		u.setUsername(username);
		u.setPassword(password);
		MUser.setU(u);
		if(MUser.login()) {
			response.getWriter().append("Bien venu "+u.getUsername()+" : Auth Connected");
		}else {
			response.getWriter().append("Auth Not Connected");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath()).append(username).append(" || ").append(password).append(" Auth : ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
