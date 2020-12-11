package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
* 山札を表すクラス
*/
public class Deck {
	public static final int RANK_MAX = 13;
	private List<Card> cardList;
	private int drawIndex;

	public List<Card> Deckmake() {
		cardList = new ArrayList<Card>();
		for(Suit suit : Suit.values()) {
			for(int rank = 1; rank <= RANK_MAX; rank++) {
				cardList.add(new Card(suit,rank));
			}
		}
		Collections.shuffle(cardList);
		return cardList;
	}

	public Card draw() {
		return cardList.get(drawIndex++);
	}
	
	public Card[] draw(int count) {
		Card[] cards = new Card[count];
		for(int i = 0; i < count; i++) {
			cards[i] = cardList.get(drawIndex++);
		}
		return cards;
	}

}
