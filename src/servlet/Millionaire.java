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

@WebServlet("/Millionaire")
public class Millionaire extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		Deck deck = new Deck();
		HttpSession session = request.getSession();
		deck.Deckmake();
		deck.remove(2);
		deck.addJocker(2);

		Player player = new Player(deck.draw(13));
		Player com1 = new Player(deck.draw(13));
		Player com2 = new Player(deck.draw(13));
		Player com3 = new Player(deck.draw(13));

		List<Card> playerhand = player.milli_hand();
		List<Card> com1hand = com1.milli_hand();
		List<Card> com2hand = com2.milli_hand();
		List<Card> com3hand = com3.milli_hand();

		session.setAttribute("order",5);

		session.setAttribute("player",playerhand);
		session.setAttribute("com1",com1hand);
		session.setAttribute("com2",com2hand);
		session.setAttribute("com3",com3hand);
		session.removeAttribute("gabage");
		int count = 0;
		session.setAttribute("count",count);

		RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
		dispatcher.forward(request, response);

	}
}


