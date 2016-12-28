package myservlet.control;

import mybean.data.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandlePassword extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login"); // 获取用户登录时的Javabean
		boolean ok = true;
		if (login == null) {
			ok = false;
			response.sendRedirect("login.jsp"); // 重定向到登录页面
		}
		if (ok == true)

		{
			continueWork(request, response);
		}
	}

	public void continueWork(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login");
		Connection con = null;
		String logname = login.getLogname();
		Password passwordBean = new Password();
		request.setAttribute("password", passwordBean);
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String uri = "jdbc:mysql://localhost:3306/friend?useUnicode=true&characterEncoding=utf-8";
		try {
			con = DriverManager.getConnection(uri, "root", "123456");
			Statement sql = con.createStatement();
			ResultSet rs = sql
					.executeQuery("SELECT * FROM member where logname='"
							+ logname + "'And password='" + oldPassword + "'");
			if (rs.next()) {
				String updateString = "UPDATE member SET password='"
						+ newPassword + "' where logname='" + logname + "'";
				int m = sql.executeUpdate(updateString);
				if (m == 1) {
					passwordBean.setBackNews("密码更新成功");
					passwordBean.setOldPassword(oldPassword);
					passwordBean.setNewPassword(newPassword);
				} else {
					passwordBean.setBackNews("密码更新失败");
				}
			} else {
				passwordBean.setBackNews("密码更新失败");
			}
		} catch (SQLException exp) {
			passwordBean.setBackNews("密码更新失败" + exp);
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("showNewPassword.jsp");// 转发
		dispatcher.forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}