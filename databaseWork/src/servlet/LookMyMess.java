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

public class LookMyMess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
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

				String message = rs.getString("message");
				out.println(message);
			} else {
				out.println("没有消息 no message .");
			}
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
