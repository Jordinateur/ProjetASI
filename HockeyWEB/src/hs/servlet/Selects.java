package hs.servlet;

import hs.ejb.EquipeManagerRemote;
import hs.ejb.GardienManagerRemote;
import hs.ejb.MatchHockeyManagerRemote;
import hs.entity.Equipe;
import hs.entity.Gardien;
import hs.entity.MatchHockey;
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
 * Servlet implementation class GetMatch
 */
@WebServlet("/Selects")
public class Selects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MatchHockeyManagerRemote mhm = null;
		EquipeManagerRemote em = null;
		GardienManagerRemote gm = null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hola</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<form method=\"post\" action=\"GetRecords\">");
		out.println("<h2>Matches : </h2>");
		
		//Get matches
		try {
			mhm = (MatchHockeyManagerRemote) LookUpJNDI.lookupManager("MatchHockeyManager", false);
		} catch (NamingException ne){
			ne.printStackTrace();
		}
		List<MatchHockey> listMatch = mhm.findAll();
		if (listMatch != null) {
			for (Iterator<MatchHockey> iterator = listMatch.iterator(); iterator.hasNext();) {
				MatchHockey matchFounded = (MatchHockey) iterator.next();
				out.println("<input name=\"idMatch\" type=\"radio\" value=\""+matchFounded.getId()+"\"> " + matchFounded.toString() + "</br>");
			}
		} else {
			out.println("<p>Aucun Match trouvé</p>");
		}
		
		out.println("</br><h2>Equipes : </h2>");
		// Get Equipes
		try {
			em = (EquipeManagerRemote) LookUpJNDI.lookupManager("EquipeManager", false);
		} catch (NamingException ne){
			ne.printStackTrace();
		}
		List<Equipe> listEquipe = em.findAll();
		if (listEquipe != null) {
			for (Iterator<Equipe> iterator = listEquipe.iterator(); iterator.hasNext();) {
				Equipe equipeFounded = (Equipe) iterator.next();
				out.println("<input name=\"idEquipe\" type=\"radio\" value=\""+equipeFounded.getId()+"\"> " + equipeFounded.toString() + "</br>");
			}
		} else {
			out.println("<p>Aucune Equipe trouvé</p>");
		}
		
		out.println("</br><h2>Gardiens : </h2>");
		// Get Gardiens
		try {
			gm = (GardienManagerRemote) LookUpJNDI.lookupManager("GardienManager", false);
		} catch (NamingException ne){
			ne.printStackTrace();
		}
		List<Gardien> listGardien = gm.findAll();
		if (listGardien != null) {
			for (Iterator<Gardien> iterator = listGardien.iterator(); iterator.hasNext();) {
				Gardien gardienFounded = (Gardien) iterator.next();
				out.println("<input name=\"idGardien\" type=\"radio\" value=\""+gardienFounded.getId()+"\"> " + gardienFounded.toString() + "</br>");
			}
		} else {
			out.println("<p>Aucun Gardien trouvé</p>");
		}
		out.println("</br><input type=\"submit\" value=\"Envoyer\">");
		out.println("</body>");
		out.println("</html>");
	}

}
