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

public class GetOtherPublicKey extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GetOtherPublicKey() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();

		try {

			Connection conn = new ConnDB().getConnection();

			PreparedStatement ps = conn
					.prepareStatement("Select * from mytable where username=? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				String pk = rs.getString("publicKey");
				out.println(pk);
			} else {
				out.println("用户不存在 no user .");
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
