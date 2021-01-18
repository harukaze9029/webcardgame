package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Card;
import model.Suit;


@WebServlet("/MillionairePlay")
public class MillionairePlay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Card> player = (List<Card>)session.getAttribute("player");
		List<Card> com1 = (List<Card>)session.getAttribute("com1");
		List<Card> com2 = (List<Card>)session.getAttribute("com2");
		List<Card> com3 = (List<Card>)session.getAttribute("com3");

		int order = (int) session.getAttribute("order");
		int count = (int) session.getAttribute("count");

		if(order == 5) {
			if(player.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",1);
			}else if(com2.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",2);
			}else if(com1.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",3);
			}else if(com3.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",4);
			}
		}


		if(order == 2) {
			count++;
			session.setAttribute("order",3);
		}else if(order == 3) {
			count++;
			session.setAttribute("order",4);
		}else if(order == 4) {
			count++;
			session.setAttribute("order",1);
		}else if(order == 1) {
			count++;
			session.setAttribute("order",2);
		}
		session.setAttribute("count",count);
			RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
			dispatcher.forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Card> playerhand = (List<Card>) session.getAttribute("player");

		response.setContentType("text/html; charset=Shift_JIS");
		String[] removeCardsString = request.getParameterValues("checkbox");

		int[] removeCards = new int[removeCardsString.length];

		for(int i = 0; i < removeCardsString.length; i++){
			removeCards[i] = Integer.parseInt(removeCardsString[i]);
		}

		List<Card> playerhandAfter = new ArrayList<Card>(playerhand);
		List<Card> gabage = new ArrayList<Card>();
		for(int i = 0; i < removeCards.length; i++) {
			playerhandAfter.remove(removeCards[i] - i);
			gabage.add(playerhand.get(removeCards[i]));
		}

		if(playerhandAfter.size() == 0) {
			response.sendRedirect("MillionaireResult");
			return;
		}
		int count = (int) session.getAttribute("count");
		count++;
		session.setAttribute("count",count);

		session.setAttribute("player",playerhandAfter);
		session.setAttribute("gabage",gabage);
		session.setAttribute("order",2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
		dispatcher.forward(request, response);
	}

}
