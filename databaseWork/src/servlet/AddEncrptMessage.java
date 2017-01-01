package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnDB;

public class AddEncrptMessage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddEncrptMessage() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String othername = request.getParameter("othername");
		String message = request.getParameter("encryptMes");

		try {
			Connection conn = new ConnDB().getConnection();
			String sql = "update mytable set message=? where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, message);
			ps.setString(2, othername);
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * RequestDispatcher dispatcher = request
		 * .getRequestDispatcher("index.jsp"); dispatcher.forward(request,
		 * response);
		 */
		response.sendRedirect("index.jsp");
	}

}
