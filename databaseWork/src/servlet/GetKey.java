package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import security.RSACoder;

import data.UserBean;

public class GetKey extends HttpServlet {

	public GetKey() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		try {
			Map<String, Object> keyMap = RSACoder.initKey();
			byte[] publicKey = RSACoder.getPublicKey(keyMap);
			byte[] privateKey = RSACoder.getPrivateKey(keyMap);

			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.print(Base64.encodeBase64String(publicKey));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
