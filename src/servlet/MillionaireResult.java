package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MillionaireResult")
public class MillionaireResult extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<String> ranking = (List<String>)session.getAttribute("ranking");

		if(ranking.get(0) != "player" && ranking.get(1) != "player" && ranking.get(2) != "player") {
			ranking.add(3,"player");
		}else if(ranking.get(0) != "com1" && ranking.get(1) != "com1" && ranking.get(2) != "com1"){
			ranking.add(3,"com1");
		}else if(ranking.get(0) != "com2" && ranking.get(1) != "com2" && ranking.get(2) != "com2"){
			ranking.add(3,"com2");
		}else if(ranking.get(0) != "com3" && ranking.get(1) != "com3" && ranking.get(2) != "com3"){
			ranking.add(3,"com3");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("resultmilli.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
