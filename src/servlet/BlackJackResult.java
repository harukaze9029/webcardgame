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

import model.Battle;
import model.BattleLogic;
import model.Card;
import model.Decision;
import model.Player;

@WebServlet("/BlackJackResult")
public class BlackJackResult extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();

			Card[] playerCard = (Card[]) session.getAttribute("player");
			Card[] computerCard = (Card[]) session.getAttribute("computer");
			Player player = new Player(playerCard);
			Player computer = new Player(computerCard);

			int index = Integer.parseInt((String) session.getAttribute("index"));
			List<Card> deck = (List<Card>) session.getAttribute("deck");

			Decision d = new Decision();
			int youcount = d.DecisionPlayer(player.tolist());
			int comcount = d.DecisionHost(computer.tolist());

			if(youcount != -1) {
				while(comcount <= 17 && comcount >= 0) {
					computer.add(deck.get(++index));
					comcount = d.DecisionHost(computer.tolist());
				}
			}

			String battle = d.decisionbattles();
			Battle b = (Battle)session.getAttribute("battle");
			if(b == null) {
				b = new Battle();
			}
			BattleLogic bl = new BattleLogic();
			if(battle.equals("Win")) {
				bl.win(b);
			}else if(battle.equals("Lose")) {
				bl.lose(b);
			}else {
				bl.draw(b);
			}
			int win = (int)b.getWin();
			int lose = (int)b.getLose();
			int draw = (int)b.getDraw();
			int x = (int) Math.round((b.getWin() /(b.getWin()+b.getLose()))*100);
			session.setAttribute("win", win);
			session.setAttribute("lose", lose);
			session.setAttribute("draw", draw);
			session.setAttribute("rate", x);
			session.setAttribute("battle", b);
			session.setAttribute("result", d.decisionbattles());
			Card[] strArray2 = computer.tolist().toArray(new Card[0]);
			session.setAttribute("computer",strArray2);
			session.setAttribute("youcount", youcount);
			session.setAttribute("comcount", comcount);

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
