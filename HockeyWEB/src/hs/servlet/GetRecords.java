package hs.servlet;

import hs.ejb.RecordManagerRemote;
import hs.entity.Record;
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
 * Servlet implementation class GetRecords
 */
@WebServlet("/GetRecords")
public class GetRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RecordManagerRemote rm = null;
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hola</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\" style=\"width:100%\">");
		out.println("<style>table { border : 1px solid black; }</style>");
		
		try {
			rm = (RecordManagerRemote) LookUpJNDI.lookupManager("RecordManager", false);
		} catch (NamingException ne){
			ne.printStackTrace();
		}
		List<Record> listRecords = rm.findAll();
		if (listRecords != null) {
			for (Iterator<Record> iterator = listRecords.iterator(); iterator.hasNext();) {
				Record recordFounded = (Record) iterator.next();
				out.println("<h1>"+recordFounded.getMatch().toString()+"</h1>");
				out.println("<h2>"+recordFounded.getGardien().toString()+"</h2>");
				out.println("<table><caption>Tir Marqué (Zone de But)</caption>");
				out.println("<tr><th>A</th><th>B</th><th>C</th><th>D</th><th>E</th><th>F</th><th>G</th><th>H</th><th>I</th></tr>");
				out.println("<tr><th>"+ recordFounded.getZoneButMarque().getA()
				+"</th><th>"+ recordFounded.getZoneButMarque().getB()
				+"</th><th>"+ recordFounded.getZoneButMarque().getC()
				+"</th><th>"+ recordFounded.getZoneButMarque().getD()
				+"</th><th>"+ recordFounded.getZoneButMarque().getE()
				+"</th><th>"+ recordFounded.getZoneButMarque().getF()
				+"</th><th>"+ recordFounded.getZoneButMarque().getG()
				+"</th><th>"+ recordFounded.getZoneButMarque().getH()
				+"</th><th>"+ recordFounded.getZoneButMarque().getI()
				+"</th></tr></br>");
				out.println("<table><caption>Tir Marqué (Zone de Terrain)</caption>");
				out.println("<tr><th>A</th><th>B</th><th>C</th><th>D</th><th>E</th><th>F</th><th>G</th><th>H</th><th>I</th></tr>");
				out.println("<tr><th>"+ recordFounded.getZoneTerrainMarque().getA()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getB()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getC()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getD()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getE()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getF()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getG()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getH()
						+"</th><th>"+ recordFounded.getZoneTerrainMarque().getI()
						+"</th></tr></br>");
				out.println("</table>");
				out.println("<table><caption>Tir Arreté (Zone de But)</caption>");
				out.println("<tr><th>A</th><th>B</th><th>C</th><th>D</th><th>E</th><th>F</th><th>G</th><th>H</th><th>I</th></tr>");
				out.println("<tr><th>"+ recordFounded.getZoneButManque().getA()
						+"</th><th>"+ recordFounded.getZoneButManque().getB()
						+"</th><th>"+ recordFounded.getZoneButManque().getC()
						+"</th><th>"+ recordFounded.getZoneButManque().getD()
						+"</th><th>"+ recordFounded.getZoneButManque().getE()
						+"</th><th>"+ recordFounded.getZoneButManque().getF()
						+"</th><th>"+ recordFounded.getZoneButManque().getG()
						+"</th><th>"+ recordFounded.getZoneButManque().getH()
						+"</th><th>"+ recordFounded.getZoneButManque().getI()
						+"</th></tr></br>");
				out.println("<table><caption>Tir Arreté (Zone de Terrain)</caption>");
				out.println("<tr><th>A</th><th>B</th><th>C</th><th>D</th><th>E</th><th>F</th><th>G</th><th>H</th><th>I</th></tr>");
				out.println("<tr><th>"+ recordFounded.getZoneTerrainManque().getA()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getB()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getC()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getD()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getE()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getF()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getG()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getH()
						+"</th><th>"+ recordFounded.getZoneTerrainManque().getI()
						+"</th></tr></br></br>");
			}
		} else {
			out.println("<p>Aucun Record trouvé</p>");
		}
		
		
		
		out.println("</body>");
		out.println("</html>");
	}

}
