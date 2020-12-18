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
import model.Decision;
import model.Deck;
import model.Player;

@WebServlet("/BlackJack")
public class BlackJack extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		Deck deck = new Deck();
		HttpSession session = request.getSession();
		session.setAttribute("deck",deck.Deckmake());

		Player player = new Player(deck.draw(2));
		Player dealer = new Player(deck.draw(2));

		List<Card> playerhand = player.tolist();
		List<Card> dealerhand = dealer.tolist();

		int index = 3;
		session.setAttribute("index", String.valueOf(index));
		session.setAttribute("player",playerhand);
		session.setAttribute("dealer",dealerhand);

		Decision decision = new Decision();
		int playercount = decision.DecisionPlayer(playerhand);
		if(playercount == 21) {
			response.sendRedirect("BlackJackResult");
			return;
		}
		session.setAttribute("playercount", playercount);

		RequestDispatcher dispatcher = request.getRequestDispatcher("blackjack.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		List<Card> a = (List<Card>) session.getAttribute("player");
		Player player = new Player(a);

		int index = Integer.parseInt((String) session.getAttribute("index"));
		List<Card> deck = (List<Card>) session.getAttribute("deck");

		player.add(deck.get(++index));

		List<Card> playerhand = player.tolist();

		session.setAttribute("player", playerhand);
		session.setAttribute("index", String.valueOf(index));

		Decision decision = new Decision();
		int playercount = decision.DecisionPlayer(playerhand);
		if(playercount == -1 || playercount == 21) {
			response.sendRedirect("BlackJackResult");
			return;
		}
		session.setAttribute("playercount", playercount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("blackjack.jsp");
		dispatcher.forward(request, response);
	}
}
