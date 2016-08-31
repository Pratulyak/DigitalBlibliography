package edu.unsw.comp9321;

import java.io.IOException;
//import java.io.PrintWriter;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.util.*;
/**
 * Servlet implementation class Frontpage
 */
@SuppressWarnings("unused")
@WebServlet("/Frontpage")
public class Frontpage extends HttpServlet {

	// private static List<Book> archives;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Frontpage() {
		super();
		// TODO Auto-generated constructor stub
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
		String testing = "frontpage.jsp";
		return testing;
	}

	public void addFiles() {

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
