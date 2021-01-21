package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Card;
import model.ComLogic;
import model.Playcheck;
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
		List<String> ranking = (List<String>)session.getAttribute("ranking");
		session.removeAttribute("flush8");
		session.removeAttribute("GK");
		if(ranking == null) {
			ranking = new ArrayList<String>(Arrays.asList("","","",""));
		}
		int order = (int) session.getAttribute("order");
		int count = (int) session.getAttribute("count");
		int playernum = (int)session.getAttribute("playernum");
		//順番決め
		if(order == 5) {
			if(player.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",1);
			}else if(com1.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",2);
			}else if(com2.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",3);
			}else if(com3.get(0).equals(new Card(Suit.club,3))) {
				session.setAttribute("order",4);
			}else if(player.get(0).equals(new Card(Suit.diamond,3))) {
				session.setAttribute("order",1);
			}else if(com1.get(0).equals(new Card(Suit.diamond,3))) {
				session.setAttribute("order",2);
			}else if(com2.get(0).equals(new Card(Suit.diamond,3))) {
				session.setAttribute("order",3);
			}else if(com3.get(0).equals(new Card(Suit.diamond,3))) {
				session.setAttribute("order",4);
			}else if(player.get(0).equals(new Card(Suit.heart,3))) {
				session.setAttribute("order",1);
			}else if(com1.get(0).equals(new Card(Suit.heart,3))) {
				session.setAttribute("order",2);
			}else if(com2.get(0).equals(new Card(Suit.heart,3))) {
				session.setAttribute("order",3);
			}else if(com3.get(0).equals(new Card(Suit.heart,3))) {
				session.setAttribute("order",4);
			}
		}

		List<Card> gabage = (List<Card>) session.getAttribute("gabage");
		//場にカードがないときにプレイヤーがパスした際にもう一回プレイヤーの番にする
		if(gabage == null && order == 1 && player.size() != 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(gabage == null) {
			gabage = new ArrayList<Card>();
		}
		String pass = (String)session.getAttribute("pass");
		if(pass == null) {
			pass = "0";
		}
		int passcn = Integer.parseInt(pass);
		System.out.println(passcn + " " + order);
		ComLogic cl = new ComLogic();
		//各番のカード出し処理
		//com1
		if(order == 2 && com1.size() != 0) {
			session.setAttribute("com1",cl.comLogic(com1,gabage));
			//ほかのプレーヤーが上がっている状態の時に飛ばす処理
			if(com2.size() == 0 && com3.size() == 0) {
				session.setAttribute("order", 1);
			}else if(com2.size() == 0){
				session.setAttribute("order",4);
			}else {
				session.setAttribute("order",3);
			}
			//パスしたときに場を残す処理、またはその逆
			if(cl.getGabagelist().size() == 0) {
				session.setAttribute("gabage", gabage);
				passcn++;
			}else {
				session.setAttribute("gabage",cl.getGabagelist());
				passcn = 0;
				//８切り処理
				if(cl.getGabagelist().get(0).getRank() == 8) {
					session.setAttribute("order",2);
					session.removeAttribute("gabage");
					session.setAttribute("flush8", 1);
				}
				if(gabage.size() != 0 && (gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15)
						&& cl.getGabagelist().get(0).equals(new Card(Suit.spade,3))) {
					session.setAttribute("order",2);
					session.removeAttribute("gabage");
					session.setAttribute("GK", 1);
				}
				session.removeAttribute("done");
			}
			count++;
			if(com1.size() == 0) {
				ranking.add(4 - playernum,"com1");
				playernum--;
				session.setAttribute("ranking", ranking);
				session.setAttribute("done", "1");
			}
			session.setAttribute("playernum", playernum);
			//com2
		}else if(order == 3 && com2.size() != 0) {
			session.setAttribute("com2",cl.comLogic(com2,gabage));
			if(com3.size() == 0 && player.size() == 0) {
				session.setAttribute("order", 2);
			}else if(com3.size() == 0){
				session.setAttribute("order",1);
			}else {
				session.setAttribute("order",4);
			}
			if(cl.getGabagelist().size() == 0) {
				session.setAttribute("gabage", gabage);
				passcn++;
			}else {
				session.setAttribute("gabage",cl.getGabagelist());
				passcn = 0;
				if(cl.getGabagelist().get(0).getRank() == 8) {
					session.setAttribute("order",3);
					session.removeAttribute("gabage");
					session.setAttribute("flush8", 1);
				}
				if(gabage.size() != 0 && (gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15)
						&& cl.getGabagelist().get(0).equals(new Card(Suit.spade,3))) {
					session.setAttribute("order",3);
					session.removeAttribute("gabage");
					session.setAttribute("GK", 1);
				}
				session.removeAttribute("done");
			}
			count++;
			if(com2.size() == 0) {
				ranking.add(4 - playernum,"com2");
				playernum--;
				session.setAttribute("ranking", ranking);
				session.setAttribute("done", "1");
			}
			session.setAttribute("playernum", playernum);
			//com3
		}else if(order == 4 && com3.size() != 0) {
			session.setAttribute("com3",cl.comLogic(com3,gabage));
			if(player.size() == 0 && com1.size() == 0) {
				session.setAttribute("order", 3);
			}else if(player.size() == 0){
				session.setAttribute("order",2);
			}else {
				session.setAttribute("order",1);
			}
			if(cl.getGabagelist().size() == 0) {
				session.setAttribute("gabage", gabage);
				passcn++;
				session.setAttribute("ranking", ranking);
			}else {
				session.setAttribute("gabage",cl.getGabagelist());
				passcn = 0;
				if(cl.getGabagelist().get(0).getRank() == 8) {
					session.setAttribute("order",4);
					session.removeAttribute("gabage");
					session.setAttribute("flush8", 1);
				}
				if(gabage.size() != 0 && (gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15)
						&& cl.getGabagelist().get(0).equals(new Card(Suit.spade,3))) {
					session.setAttribute("order",4);
					session.removeAttribute("gabage");
					session.setAttribute("GK", 1);
				}
				session.removeAttribute("done");
			}
			count++;
			if(com3.size() == 0) {
				ranking.add(4 - playernum,"com3");
				playernum--;
				session.setAttribute("done", "1");
				session.setAttribute("ranking", ranking);
			}
			session.setAttribute("playernum", playernum);
			//player
		}else if(order == 1 && player.size() != 0) {
			passcn++;
			count++;
			session.setAttribute("gabage", gabage);
			if(com1.size() == 0 && com2.size() == 0) {
				session.setAttribute("order", 4);
			}else if(com1.size() == 0){
				session.setAttribute("order",3);
			}else {
				session.setAttribute("order",2);
			}
		}else if(com2.size() == 0 && order == 3) {
			if(com3.size() == 0 && player.size() == 0) {
				session.setAttribute("order", 2);
			}else if(com3.size() == 0){
				session.setAttribute("order",1);
			}else {
				session.setAttribute("order",4);
			}
		}else if(com1.size() == 0 && order == 2) {
			if(com2.size() == 0 && com3.size() == 0) {
				session.setAttribute("order", 1);
			}else if(com2.size() == 0 ){
				session.setAttribute("order",4);
			}else {
				session.setAttribute("order",3);
			}
		}else if(com3.size() == 0 && order == 4) {
			if(player.size() == 0 && com1.size() == 0) {
				session.setAttribute("order", 3);
			}else if(player.size() == 0){
				session.setAttribute("order",2);
			}else {
				session.setAttribute("order",1);
			}
		}else if(player.size() == 0 && order == 1) {
			if(com1.size() == 0  && com2.size() == 0) {
				session.setAttribute("order", 4);
			}else if(com1.size() == 0){
				session.setAttribute("order",3);
			}else {
				session.setAttribute("order",2);
			}
		}

		//パスの処理
		if(passcn == playernum - 1) {
			if(order == 3) {
				if(com3.size() == 0 && player.size() == 0) {
					session.setAttribute("order", 2);
				}else if(com3.size() == 0 ){
					session.setAttribute("order",1);
				}else {
					session.setAttribute("order",4);
				}
			}else if(order == 2) {
				if(com2.size() == 0 && com3.size() == 0) {
					session.setAttribute("order", 1);
				}else if(com2.size() == 0){
					session.setAttribute("order",4);
				}else {
					session.setAttribute("order",3);
				}
			}else if(order == 4) {
				if(player.size() == 0 && com1.size() == 0) {
					session.setAttribute("order", 3);
				}else if(player.size() == 0){
					session.setAttribute("order",2);
				}else {
					session.setAttribute("order",1);
				}
			}else if(order == 1) {
				if(com1.size() == 0 && com2.size() == 0) {
					session.setAttribute("order", 4);
				}else if(com1.size() == 0){
					session.setAttribute("order",3);
				}else {
					session.setAttribute("order",2);
				}
			}
			session.removeAttribute("gabage");
			session.setAttribute("pass","0");
		}else {
			session.setAttribute("pass", Integer.toString(passcn));
		}
		session.setAttribute("count",count);
		//残り１人になったときに結果画面にリダイレクトさせる
		if(playernum == 1) {
			response.sendRedirect("MillionaireResult");
			return;
		}
		System.out.println(passcn + " " + order + " " + playernum);
		System.out.println();
		/*
		try {
			Thread.sleep(1000); // 1秒間だけ処理を止める
		} catch (InterruptedException e) {
		}
		*/
		RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
		dispatcher.forward(request, response);

	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Card> playerhand = (List<Card>) session.getAttribute("player");
		List<Card> gabagebefore = (List<Card>) session.getAttribute("gabage");
		List<String> ranking = (List<String>)session.getAttribute("ranking");
		List<Card> com1 = (List<Card>)session.getAttribute("com1");
		List<Card> com2 = (List<Card>)session.getAttribute("com2");
		int playernum = (int)session.getAttribute("playernum");
		String pass = (String)session.getAttribute("pass");
		session.removeAttribute("flush8");
		session.removeAttribute("GK");
		session.removeAttribute("done");
		if(pass == null) {
			pass = "0";
		}
		int passcn = Integer.parseInt(pass);
		passcn = 0;
		if(ranking == null) {
			ranking = new ArrayList<String>(Arrays.asList("","","",""));
		}
		if(gabagebefore == null) {
			gabagebefore = new ArrayList<Card>();
		}
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
		Playcheck pc = new Playcheck();
		if(pc.handsCheck(gabage,gabagebefore) == false) {
			session.setAttribute("player",playerhand);
			RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
			dispatcher.forward(request, response);
			return;
		}
		int count = (int) session.getAttribute("count");
		count++;
		if(playerhandAfter.size() == 0) {
			ranking.add(4 - playernum,"player");
			session.setAttribute("ranking", ranking);
			playernum--;
			session.setAttribute("done", "1");
		}
		if(playernum == 1) {
			response.sendRedirect("MillionaireResult");
			return;
		}
		session.setAttribute("playernum", playernum);
		session.setAttribute("count",count);
		session.setAttribute("player",playerhandAfter);
		session.setAttribute("gabage",gabage);
		if(com1.size() == 0) {
			session.setAttribute("order", 3);
		}else if(com1.size() == 0 && com2.size() == 0){
			session.setAttribute("order",4);
		}else {
			session.setAttribute("order",2);
		}
		if(gabage.get(0).getRank() == 8) {
			session.setAttribute("order",1);
			session.removeAttribute("gabage");
			session.setAttribute("flush8", 1);
		}
		if(gabagebefore.size() != 0 &&(gabagebefore.get(0).getRank() == 14 || gabagebefore.get(0).getRank() == 15)
				&& gabage.get(0).equals(new Card(Suit.spade,3))) {
			session.setAttribute("order",1);
			session.removeAttribute("gabage");
			session.setAttribute("GK", 1);
		}

		session.setAttribute("pass", Integer.toString(passcn));
		RequestDispatcher dispatcher = request.getRequestDispatcher("millionaire.jsp");
		dispatcher.forward(request, response);
	}

}
