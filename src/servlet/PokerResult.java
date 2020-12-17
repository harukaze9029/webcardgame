package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			Card[] a = (Card[]) session.getAttribute("player");
			Card[] b = (Card[]) session.getAttribute("computer");
			Player player = new Player(a);
			Player computer = new Player(b);

			session.setAttribute("playerhand",player.PokerHand(player));
			session.setAttribute("computerhand",computer.PokerHand(computer));

			int result = computer.compareTo(player);
			Count count = (Count)session.getAttribute("count");
			if(count == null) {
				count = new Count();
			}

			BattleLogic bl = new BattleLogic();
			if(result == 0) {
				session.setAttribute("result","Draw");
				bl.draw(count);
			}else if(result < 0) {
				session.setAttribute("result","Lose");
				bl.lose(count);
			}else {
				session.setAttribute("result","Win");
				bl.win(count);
			}
			int win = (int)count.getWin();
			int lose = (int)count.getLose();
			int draw = (int)count.getDraw();
			int x = (int) Math.round((count.getWin() /(count.getWin()+count.getLose()))*100);
			session.setAttribute("wincn", win);
			session.setAttribute("losecn", lose);
			session.setAttribute("drawcn", draw);
			session.setAttribute("ratep", x);
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
