package edu.unsw.comp9321;

import java.io.File;
import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;



//import java.util.*;
/**
 * Servlet implementation class Frontpage
 */
@SuppressWarnings("unused")
@WebServlet("/Frontpage")
public class Frontpage extends HttpServlet {

	private static List<Record> archives;

	private static final long serialVersionUID = 1L;

	/**
	 * @throws ParserConfigurationException 
	 * @see HttpServlet#HttpServlet()
	 */
	public Frontpage() throws SAXException,IOException,ParserConfigurationException {
		super();
		// TODO Auto-generated constructor stub		
		try {
			File newFile = new File("/home/pratulyak/workspace/DigitalBibliographicalLibrary/WebContent/WEB-INF/lib/dblp.xml");
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setValidating(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document docu = builder.parse(newFile);
			this.handleDoc(docu);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void handleDoc(Document doc){
		int i = 0;
		for(i=0;i<20000;i++){
			String title = doc.getElementsByTagName("title").item(i).getTextContent();
			String author = doc.getElementsByTagName("author").item(i).getTextContent();
			int pages = Integer.parseInt(doc.getElementsByTagName("pages").item(i).getTextContent());
			int year = Integer.parseInt(doc.getElementsByTagName("year").item(i).getTextContent());
			
		}
		
		/*System.out.println(title+ author +" this is working mate");*///System.out.println(i);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/frontpage.jsp");
		rd.forward(request, response);
		// doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		String action = request.getParameter("action");
		String doAction = "";
		// String action = request.getParameter("home");
		if (action.equalsIgnoreCase("Home")) {
			doAction = "frontpage.jsp";
		} else if (action.equalsIgnoreCase("search")) {
			doAction = "searchResult.jsp";
		}
		response.sendRedirect(doAction);
		// if(action.equalsIgnoreCase("Search")){
		// doAction = "searchResult.jsp";
		// } else if (action.equalsIgnoreCase("add")){
		// doAction = this.addToCart(request);
		// }
		// System.out.println(doAction);
		// RequestDispatcher rd = request.getRequestDispatcher("/"+doAction);
		// rd.(request, response);
	}

	public String searchForFile(HttpServletRequest req) {
		String testing = "searchResult.jsp";
		return testing;
	}

	public String addToCart(HttpServletRequest req) {
		// ShoppingCart sct =
		// (ShoppingCart)req.getSession().getAttribute("ShoppingCart");
		// find Book b in list
		// add to cart
		// sct.addItem(b);
		return "frontpage.jsp";
	}

}
