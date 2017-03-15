package webApp.armurerie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArmurerieCtrl
 */
@WebServlet(
		name="/ArmurerieCtrl",
		description="Controleur pour la fonctionnalité Armurerie",
		urlPatterns={"/armurerie/*"}
		)
public class ArmurerieCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RequestDispatcher disp;
    private ServletContext servletContexte;
    private String path;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArmurerieCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		path = request.getPathInfo();
		if (path == null || path.equals("/")) {
			afficheArmurerie(request, response);
		}
	}
// méthode d'affichage de la page principale de l'Armurerie
	private void afficheArmurerie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		disp = request.getRequestDispatcher("/WEB-INF/vue/armurerie/Armurerie.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		path = request.getPathInfo();
		if (path == null || path.equals("/")) {
			afficheArmurerie(request, response);
		}
		else if (path.equals("/creation/*")){
			sendToCtrlCreation(request, response);		
		}
	}

	private void sendToCtrlCreation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servletContexte = getServletContext();
		disp = servletContexte.getNamedDispatcher("/ArmurerieCreation");
		disp.forward(request, response);
		
	}

}
