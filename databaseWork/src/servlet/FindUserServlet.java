package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import security.MD5Coder;

import dao.ConnDB;
import data.UserBean;

public class FindUserServlet extends HttpServlet {

	public FindUserServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		try {

			Connection conn = new ConnDB().getConnection();

			PreparedStatement ps = conn
					.prepareStatement("Select username,password,digestAlgorithm from mytable where username=? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				UserBean user = new UserBean();

				if (rs.getString("username").equals(username)) {
					user.setDigestAlgorithm(rs.getString("digestAlgorithm"));

					if (user.getDigestAlgorithm().equals("MD5")) {
						String enPsw = MD5Coder.encodeMD5Hex(password);

						if (enPsw.equals(rs.getString("password"))) {

							response.sendRedirect("./message.jsp");
						} else {
							System.out.println("your put password is wrong");
						}
					} else {
						System.out.println("digest is not MD5 .");
					}

				} else {
					System.out.println("user not exist .");
				}

			}
			out.print("fail .");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
