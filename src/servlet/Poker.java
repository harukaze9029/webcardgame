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

import model.Card;
import model.Deck;
import model.Player;

@WebServlet("/Poker")
public class Poker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		Deck deck = new Deck();
		HttpSession session = request.getSession();
		session.setAttribute("deck",deck.Deckmake());
		Player player = new Player(deck.draw(5));
		Player computer = new Player(deck.draw(5));

		Card[] strArray1 = player.show_hand().toArray(new Card[0]);
		Card[] strArray2 = computer.show_hand().toArray(new Card[0]);

		int index = 9;
		session.setAttribute("index", String.valueOf(index));
		session.setAttribute("player",strArray1);
		session.setAttribute("computer",strArray2);

		RequestDispatcher dispatcher = request.getRequestDispatcher("poker.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int index = Integer.parseInt((String) session.getAttribute("index"));
		List<Card> deck = (List<Card>) session.getAttribute("deck");
		Card[] a = (Card[]) session.getAttribute("player");

		Player player = new Player(a);

		response.setContentType("text/html; charset=Shift_JIS");
		String[] removeCardsString = request.getParameterValues("checkbox");

		int[] removeCards = new int[removeCardsString.length];

		for(int i = 0; i < removeCardsString.length; i++){
			removeCards[i] = Integer.parseInt(removeCardsString[i]);
		}

		for(int i = 0;i < removeCards.length ; i++) {
			player.remove(removeCards[i] - i);
		}

		for(int i = 0;i < removeCards.length ; i++) {
			player.add(deck.get(++index));
		}

		Card[] strArray1 = player.show_hand().toArray(new Card[0]);
		session.setAttribute("player",strArray1);

		response.sendRedirect("PokerResult");
	}
}
