package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.MD5Coder;

import dao.ConnDB;

public class AddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String publicKey = request.getParameter("publicKey");
		String digestAlgorithm = request.getParameter("digestAlgorithm");
		String RSA = request.getParameter("RSA");
		String message = request.getParameter("message");

		try {

			String enPsw = "";

			if (digestAlgorithm.equals("MD5")) {
				enPsw = MD5Coder.encodeMD5Hex(password);
			} else {
				System.out.println("fail" + digestAlgorithm);
			}

			Connection conn = new ConnDB().getConnection();
			String sql = "insert into mytable (username, password, publicKey, digestAlgorithm,RSA,message) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, enPsw);
			ps.setString(3, publicKey);
			ps.setString(4, digestAlgorithm);
			ps.setString(5, RSA);
			ps.setString(6, message);

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}
