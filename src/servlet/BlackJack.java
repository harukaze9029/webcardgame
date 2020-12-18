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
		Player computer = new Player(deck.draw(2));

		int index = 4;
		session.setAttribute("index", String.valueOf(index));

		Card[] strArray1 = player.tolist().toArray(new Card[0]);
		Card[] strArray2 = computer.tolist().toArray(new Card[0]);
		session.setAttribute("player",strArray1);
		session.setAttribute("computer",strArray2);
		Decision d = new Decision();
		int youcount = d.DecisionPlayer(player.tolist());
		if(youcount == 21) {
			response.sendRedirect("BlackJackResult");
			return;
		}
		session.setAttribute("youcount", youcount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("brackjack.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Card[] a = (Card[]) session.getAttribute("player");
		Player player = new Player(a);

		int index = Integer.parseInt((String) session.getAttribute("index"));
		List<Card> deck = (List<Card>) session.getAttribute("deck");

		player.add(deck.get(++index));

		Card[] strArray1 = player.tolist().toArray(new Card[0]);

		session.setAttribute("player",strArray1);
		session.setAttribute("index", String.valueOf(index));

		Decision d = new Decision();
		int youcount = d.DecisionPlayer(player.tolist());
		if(youcount == -1) {
			response.sendRedirect("BlackJackResult");
			return;
		}
		if(youcount == 21) {
			response.sendRedirect("BlackJackResult");
			return;
		}
		session.setAttribute("youcount", youcount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("brackjack.jsp");
		dispatcher.forward(request, response);
	}
}
