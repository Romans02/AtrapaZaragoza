package es.romanos.atrapazaragoza.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.romanos.atrapazaragoza.utils.Actualizar;
import es.romanos.atrapazaragoza.utils.Constantes;

/**
 * Servlet implementation class ActualizaBD
 */
@WebServlet("/ActualizaBD")
public class ActualizaBD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizaBD() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("nombre").equals(Constantes.ADMIN) && request.getParameter("pass").equals(Constantes.PASSWORDADMIN)){
			Actualizar.actualizaBD();
		}else{
			out.println("<html>");
	         out.println("<head></head>");         
	         out.println("<body>");

	         out.println("Datos incorrectos");
	         
	         out.println("</body>");
	         out.println("</html>");   
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
