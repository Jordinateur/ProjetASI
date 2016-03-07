package hs.servlet;

import hs.ejb.GardienManagerRemote;
import hs.entity.Gardien;
import hs.utility.LookUpJNDI;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GardienManagerRemote gardienManager = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hola</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<ul>");
		try {
			gardienManager = LookUpJNDI.lookupGardienManager();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Gardien> listEquipe = gardienManager.allGardien();
		System.out.println("Liste Equipe taille = " + listEquipe.size());
		if (listEquipe != null) {
			for (Iterator<Gardien> iterator = listEquipe.iterator(); iterator.hasNext();) {
				Gardien e = (Gardien) iterator.next();
				out.println("<li>" + e.toString() + "</li>");
			}
		} else {
			out.println("<li>RIEN</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}
