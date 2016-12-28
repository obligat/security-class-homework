package myservlet.control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybean.data.Register;

import dao.ConnectionDB;

public class HandleRegister2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public String handleString(String str) {
		try {
			byte b[] = str.getBytes("iso-8859-1");
			str = new String(b);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Register reg = new Register();
		req.setAttribute("register", reg);

		String logname = req.getParameter("logname").trim();
		String password = req.getParameter("password").trim();
		String advertiseTitle = req.getParameter("advertiseTitle").trim();
		String email = req.getParameter("email").trim();
		String phone = req.getParameter("phone").trim();
		String message = req.getParameter("message");

		if (logname == null)
			logname = "";
		if (password == null)
			password = "";
		boolean isLD = true;

		for (int i = 0; i < logname.length(); i++) {
			char c = logname.charAt(i);
			if (!((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')))
				isLD = false;
		}

		boolean boo = logname.length() > 0 && password.length() > 0 && isLD;
		String backNews = "";
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sql = "insert into member (logname, password, advertiseTitle, email,phone,message) values (?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			if (boo) {
				ps.setString(1, logname);
				ps.setString(2, password);
				ps.setString(3, advertiseTitle);
				ps.setString(4, email);
				ps.setString(5, phone);
				ps.setString(6, message);

			}

			int m = ps.executeUpdate();
			if (m != 0) {
				backNews = "注册成功";
				reg.setBackNews(backNews);
				reg.setAdvertiseTitle(advertiseTitle);
				reg.setEmail(email);
				reg.setLogname(logname);
				reg.setMessage(message);
				reg.setPhone(phone);
				reg.setPassword(handleString(password));
			} else {
				backNews = "信息填写不完整或名字中有非法字符";
				reg.setBackNews(backNews);
			}

			ps.close();
			conn.close();

		} catch (Exception e) {
			backNews = "该会员名已被使用，请您更换名字" + e;
			reg.setBackNews(backNews);
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req
				.getRequestDispatcher("showRegisterMess.jsp");
		dispatcher.forward(req, res);
	}
}
