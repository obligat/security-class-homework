package myservlet.control;

import mybean.data.*;
import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import dao.ConnectionDB;

public class HandleUpload extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");

		if (login == null) {
			response.sendRedirect("./login.jsp");
		} else {

			String logname = login.getLogname();
			uploadFileMethod(request, response, logname);
		}
	}

	public void uploadFileMethod(HttpServletRequest request,
			HttpServletResponse response, String logname)
			throws ServletException, IOException {

		UploadFile upFile = new UploadFile();
		String backNews = "";
		String savedFileName = "";

		byte[] body = readBody(request);
		String textBody = new String(body, "ISO-8859-1");
		String filename = getFilename(textBody);
		Position p = getFilePosition(request, textBody);

		try {
			request.setAttribute("upFile", upFile);
			Connection conn = new ConnectionDB().getConnection();
			Connection conn2 = new ConnectionDB().getConnection();
			String sql = "select * from member where logname = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, logname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				String checkedStr = filename
						.substring(0, filename.indexOf("."));
				if (checkedStr.matches("\\w+")) {

					savedFileName = logname.concat(filename);

					PreparedStatement ps2 = conn2.prepareStatement(sql);

					int count = ps2.executeUpdate("UPDATE member SET pic= '"
							+ savedFileName + "' where logname = '" + logname
							+ "'");
					if (count != 0) {
						backNews = filename + "成功上传";
						upFile.setFileName(filename);
						upFile.setSavedFileName(savedFileName);
						upFile.setBackNews(backNews);
					}
				}
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		writeTo(savedFileName, body, p);

		try {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("showUploadMess.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
		}
	}

	class Position {
		int begin;
		int end;

		Position(int begin, int end) {
			this.begin = begin;
			this.end = end;
		}
	}

	private byte[] readBody(HttpServletRequest request) throws IOException {

		int formDataLength = request.getContentLength();
		DataInputStream dataStream = new DataInputStream(
				request.getInputStream());
		byte body[] = new byte[formDataLength];
		int totalBytes = 0;

		while (totalBytes < formDataLength) {
			int bytes = dataStream.read(body, totalBytes, formDataLength);
			totalBytes += bytes;
		}

		return body;
	}

	private Position getFilePosition(HttpServletRequest request, String textBody)
			throws IOException {

		String contentType = request.getContentType();
		String boundaryText = contentType.substring(
				contentType.lastIndexOf("=") + 1, contentType.length());
		int pos = textBody.indexOf("filename=\"");
		pos = textBody.indexOf("\n", pos) + 1;
		pos = textBody.indexOf("\n", pos) + 1;
		pos = textBody.indexOf("\n", pos) + 1;
		int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
		int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
		int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
		return new Position(begin, end);
	}

	private String getFilename(String reqBody) {
		String filename = reqBody
				.substring(reqBody.indexOf("filename=\"") + 10);

		filename = filename.substring(0, filename.indexOf("\n"));
		filename = filename.substring(filename.lastIndexOf("\\") + 1,
				filename.indexOf("\""));
		return filename;
	}

	private void writeTo(String filename, byte[] body, Position p)
			throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(
				"D:/j2ee-homework/cp10/WebRoot/images/" + filename);
		fileOutputStream.write(body, p.begin, (p.end - p.begin));
		fileOutputStream.flush();
		fileOutputStream.close();
	}
}