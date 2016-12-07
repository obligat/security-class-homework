package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnDB;

public class GetUserKey extends HttpServlet {

	public GetUserKey() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {

			String username = request.getParameter("username");
			Connection conn = new ConnDB().getConnection();

			PreparedStatement ps = conn
					.prepareStatement("Select username from mytable where username=? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getString("username") != null) {
					out.print(rs.getString("publicKey"));
				} else {
					out.print("user not exist .");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();
	}
}
