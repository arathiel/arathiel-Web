package webApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainCtrl 
 * Controleur Principal de l'appli Arathiel.
 * redirection vers chaque Fonctionnalité
 * @Author Groupe
 */
@WebServlet(
		name = "MainCtrl", 
		description = "Controleur principal de l'application Arathiel", 
		urlPatterns = {"/royaume/*"}
		)
public class MainCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher disp;
	private ServletContext contexte;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		if (path == null || path.equals("/")) {
			afficheAccueil(request, response);
		}
		else if (path.equals("/armurerie")){
			sendArmurerie(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void afficheAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		disp = request.getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
	}
	private void sendArmurerie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contexte = getServletContext();
		disp = contexte.getNamedDispatcher("ArmurerieCtrl");
		disp.forward(request, response);
		
	}

}
