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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import java.util.*;
/**
 * Servlet implementation class Frontpage
 */
@SuppressWarnings("unused")
@WebServlet("/Frontpage")
public class Frontpage extends HttpServlet {

	private List<Record> archives = new LinkedList<Record>();
	private List<Record> results = new ArrayList<Record>();
	private static final long serialVersionUID = 1L;

	/**
	 * @throws ParserConfigurationException
	 * @see HttpServlet#HttpServlet()
	 */
	public Frontpage() throws SAXException, IOException, ParserConfigurationException {
		super();
		// TODO Auto-generated constructor stub
		this.init();
	}

	public void init() {
		try {
			File newFile = new File(
					"/home/pratulyak/workspace/DigitalBibliographicalLibrary/WebContent/WEB-INF/lib/dblp.xml");
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setValidating(true);
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			Document docu = builder.parse(newFile);
			this.handleDoc(docu);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void handleDoc(Document doc) {
		NodeList nlArticles = doc.getElementsByTagName("article");
		for (int j = 0; j < nlArticles.getLength(); j++) {
			Element el = (Element) nlArticles.item(j);
			String title = "";
			if (el.getElementsByTagName("title").item(0) != null) {
				title = el.getElementsByTagName("title").item(0).getTextContent();
			}
			ArrayList<String> authors = new ArrayList<String>();
			if (el.getElementsByTagName("author").item(0) != null) {
				for (int k = 0; k < el.getElementsByTagName("author").getLength(); k++) {
					authors.add(el.getElementsByTagName("author").item(k).getTextContent());
				}

			}
			String pages = "";
			if (el.getElementsByTagName("page").item(0) != null) {
				pages = el.getElementsByTagName("pages").item(0).getTextContent();
			}
			String year = "";
			String volume = "";
			String journal = "";
			String number = "";
			if (el.getElementsByTagName("year").item(0) != null) {
				year = el.getElementsByTagName("year").item(0).getTextContent();
			}
			if (el.getElementsByTagName("volume").item(0) != null) {
				volume = el.getElementsByTagName("volume").item(0).getTextContent();
			}
			if (el.getElementsByTagName("journal").item(0) != null) {
				journal = el.getElementsByTagName("journal").item(0).getTextContent();
			}
			if (el.getElementsByTagName("number").item(0) != null) {
				number = el.getElementsByTagName("number").item(0).getTextContent();
			} else {
				number = "";
			}
			String ee = "";
			if (el.getElementsByTagName("ee").item(0) != null) {
				ee = el.getElementsByTagName("ee").item(0).getTextContent();
			}
			String url = el.getElementsByTagName("url").item(0).getTextContent();
			String publisher = "";
			String isbn = "";
			Record rec = new Record(title, publisher, year, pages, isbn, ee, "article", authors, journal, number, url);
			this.archives.add(rec);

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		request.setAttribute("totalArchives",this.archives);
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

			this.results = this.searchForFile(request);
			request.setAttribute("results", this.results);
			doAction = "searchResult.jsp";
		}

		// if(action.equalsIgnoreCase("Search")){
		// doAction = "searchResult.jsp";
		// } else if (action.equalsIgnoreCase("add")){
		// doAction = this.addToCart(request);
		// }
		// System.out.println(doAction);
		RequestDispatcher rd = request.getRequestDispatcher("/" + doAction);
		rd.forward(request, response);
	}

	public ArrayList<Record> searchForFile(HttpServletRequest req) {
		String searchString = req.getParameter("searchString");
		searchString.toLowerCase();
		//System.out.println(searchString);
		ArrayList<Record> results = new ArrayList<Record>();
		Pattern p = Pattern.compile(searchString);
		Matcher m = p.matcher(searchString);
		for (Record r : this.archives) {
			String title = r.getTitle();
			ArrayList<String> authors = r.getAuthors();
			String journal = r.getJournal();
			String publisher = r.getPublisher();
			title.toLowerCase();
			publisher.toLowerCase();
			journal.toLowerCase();
			if (p.matcher(title).matches()) {
				results.add(r);
			}
			if (p.matcher(journal).matches()) {
				results.add(r);
			}
			if (publisher.contains(searchString)) {
				results.add(r);
			}

			for (String s : authors) {
				s.toLowerCase();
				if (s.compareToIgnoreCase(searchString) >= 0) {
					results.add(r);
				}
			}
		}
		System.out.println(results.size());
		return results;
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
