package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import dao.ConnDB;
import encrypt.RSACoder;

public class EncryptMessageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public EncryptMessageServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = response.getWriter();
		try {

			String username = request.getParameter("username");
			String message = request.getParameter("message");
			Connection conn = new ConnDB().getConnection();

			PreparedStatement ps = conn
					.prepareStatement("Select * from mytable where username=? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				// String publicKey = rs.getString("publicKey");

				byte[] data = message.getBytes();

				Map<String, Object> keyMap = RSACoder.initKey();
				byte[] publicKey = RSACoder.getPublicKey(keyMap);
				byte[] privateKey = RSACoder.getPrivateKey(keyMap);

				byte[] encodedData = RSACoder.encryptByPublicKey(data,
						publicKey);
				// byte[] encodedData = RSACoder.encryptByPublicKey(data,
				// Base64.decodeBase64(publicKey));

				// out.println(message);
				out.println(Base64.encodeBase64String(encodedData));

				byte[] data2 = RSACoder.decryptByPrivateKey(encodedData,
						privateKey);

				// out.println(new String(data2));

			}

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}
}
