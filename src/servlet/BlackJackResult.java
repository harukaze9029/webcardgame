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
import model.Decision;

@WebServlet("/BlackJackResult")
public class BlackJackResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();

			List<Card> playerhand = (List<Card>) session.getAttribute("player");
			List<Card> dealerhand = (List<Card>) session.getAttribute("dealer");

			int index = Integer.parseInt((String) session.getAttribute("index"));
			List<Card> deck = (List<Card>) session.getAttribute("deck");

			Decision decision = new Decision();
			int playercount = decision.DecisionPlayer(playerhand);
			int dealercount = decision.DecisionHost(dealerhand);

			if(playercount != -1) {
				while(dealercount <= 17 && dealercount >= 0) {
					dealerhand.add(deck.get(++index));
					dealercount = decision.DecisionHost(dealerhand);
				}
			}

			String result = decision.decisionbattles();
			Count count = (Count)session.getAttribute("battle");
			if(count == null) {
				count = new Count();
			}

			BattleLogic bl = new BattleLogic();
			if(result.equals("Win")) {
				bl.winbj(count);
			}else if(result.equals("Lose")) {
				bl.losebj(count);
			}else {
				bl.drawbj(count);
			}
			int winbj = (int)count.getWinbj();
			int losebj = (int)count.getLosebj();
			int drawbj = (int)count.getDrawbj();
			int winratebj = (int) Math.round((count.getWinbj() / (count.getWinbj() + count.getLosebj())) * 100);
			session.setAttribute("winbj", winbj);
			session.setAttribute("losebj", losebj);
			session.setAttribute("drawbj", drawbj);
			session.setAttribute("ratebj", winratebj);
			session.setAttribute("battle", count);
			session.setAttribute("result", decision.decisionbattles());
			session.setAttribute("dealer", dealerhand);
			session.setAttribute("playercount", playercount);
			session.setAttribute("dealercount", dealercount);

			session.removeAttribute("deck");
			session.removeAttribute("index");

			RequestDispatcher dispatcher = request.getRequestDispatcher("resultbj.jsp");
			dispatcher.forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
