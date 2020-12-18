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
		Player dealer = new Player(deck.draw(5));

		List<Card> playerhand = player.show_hand();
		List<Card> dealerhand = dealer.show_hand();

		int index = 9;
		session.setAttribute("index", String.valueOf(index));
		session.setAttribute("player",playerhand);
		session.setAttribute("dealer",dealerhand);

		RequestDispatcher dispatcher = request.getRequestDispatcher("poker.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		int index = Integer.parseInt((String) session.getAttribute("index"));
		List<Card> deck = (List<Card>) session.getAttribute("deck");
		List<Card> playerhand = (List<Card>) session.getAttribute("player");

		response.setContentType("text/html; charset=Shift_JIS");
		String[] removeCardsString = request.getParameterValues("checkbox");

		int[] removeCards = new int[removeCardsString.length];

		for(int i = 0; i < removeCardsString.length; i++){
			removeCards[i] = Integer.parseInt(removeCardsString[i]);
		}

		for(int i = 0; i < removeCards.length; i++) {
			playerhand.remove(removeCards[i] - i);
			playerhand.add(deck.get(++index));
		}

		Player player = new Player(playerhand);
		List<Card> sortplayerhand = player.show_hand();
		session.setAttribute("player",sortplayerhand);

		response.sendRedirect("PokerResult");
	}
}
