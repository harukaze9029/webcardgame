package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BattleLogic;
import model.Card;
import model.Count;
import model.Player;

@WebServlet("/PokerResult")
public class PokerResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			List<Card> a = (List<Card>) session.getAttribute("player");
			List<Card> b = (List<Card>) session.getAttribute("dealer");
			Player player = new Player(a);
			Player dealer = new Player(b);

			session.setAttribute("playerhand",player.PokerHand(player));
			session.setAttribute("dealerhand",dealer.PokerHand(dealer));

			int result = dealer.compareTo(player);
			Count count = (Count)session.getAttribute("count");
			if(count == null) {
				count = new Count();
			}

			BattleLogic bl = new BattleLogic();
			if(result == 0) {
				session.setAttribute("result","Draw");
				bl.drawpo(count);
			}else if(result < 0) {
				session.setAttribute("result","Lose");
				bl.losepo(count);
			}else {
				session.setAttribute("result","Win");
				bl.winpo(count);
			}
			int winpo = (int)count.getWinpo();
			int losepo = (int)count.getLosepo();
			int drawpo = (int)count.getDrawpo();
			int winratepo = (int) Math.round((count.getWinpo() /(count.getWinpo()+count.getLosepo()))*100);
			session.setAttribute("winpo", winpo);
			session.setAttribute("losepo", losepo);
			session.setAttribute("drawpo", drawpo);
			session.setAttribute("ratepo", winratepo);
			session.setAttribute("count", count);
			session.removeAttribute("deck");

			RequestDispatcher dispatcher = request.getRequestDispatcher("resultpoker.jsp");
			dispatcher.forward(request, response);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
