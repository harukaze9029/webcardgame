package model;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player>{
	protected List<Card> hands;

	public Player(Card[] cards) {
		hands = new ArrayList<Card>();
		for(Card card : cards) {
			hands.add(card);
		}
	}

	public Player(Card card) {
		hands = new ArrayList<Card>();
		hands.add(card);
	}

	private boolean rsf(List<Card> hands) {
		List<Suit> suit = hands.stream().map(Card::getSuit).collect(toList());
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		if((suit.get(1) == suit.get(0) && suit.get(2) == suit.get(0) && suit.get(3) == suit.get(0) && suit.get(4) == suit.get(0)) &&
				(rank.get(0) == 1 && rank.get(1) == 10 && rank.get(2) == 11 && rank.get(3) == 12 && rank.get(4) == 13)) {
			return true;
		}else {
			return false;
		}
	}

	private boolean sf(List<Card> hands){
		List<Suit> suit = hands.stream().map(Card::getSuit).collect(toList());
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		if((suit.get(1) == suit.get(0) && suit.get(2) == suit.get(0) && suit.get(3) == suit.get(0) && suit.get(4) == suit.get(0)) &&
				(rank.get(1) == rank.get(0) + 1 && rank.get(2) == rank.get(1) + 1 && rank.get(3) == rank.get(2) + 1 && rank.get(4) == rank.get(3) + 1)) {
			return true;
		}else {
			return false;
		}
	}

	private int fc(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		for (int defrank : rank) {
			if(Collections.frequency(rank, defrank) == 4) {
				pairCount = 5;
			}
		}
		return pairCount;
	}

	private int fh(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		if(rank.get(0) == rank.get(1) && rank.get(0) == rank.get(2) && rank.get(3) == rank.get(4) ||
				rank.get(0) == rank.get(1) && rank.get(2) == rank.get(3) && rank.get(2) == rank.get(4)) {
					pairCount = 6;
		}
		return pairCount;
	}

	private boolean flash(List<Card> hands){
		List<Suit> suit = hands.stream().map(Card::getSuit).collect(toList());
		if(suit.get(1) == suit.get(0) && suit.get(2) == suit.get(0) && suit.get(3) == suit.get(0) && suit.get(4) == suit.get(0) ) {
			return true;
		}else {
			return false;
		}
	}


	private boolean straight(List<Card> hands){
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		if(rank.get(1) == rank.get(0) + 1 && rank.get(2) == rank.get(1) + 1 && rank.get(3) == rank.get(2) + 1 && rank.get(4) == rank.get(3) + 1) {
			return true;
		}else {
			return false;
		}
	}

	private int tc(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		for (int defrank : rank) {
			if(Collections.frequency(rank, defrank) == 3) {
				pairCount = 3;
			}
		}
		return pairCount;
	}

	private int pairCount(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = hands.stream().map(Card::getRank).collect(toList());
		for (int defrank : rank) {
			if(Collections.frequency(rank, defrank) == 2) {
				pairCount++;
			}
		}
		return pairCount;
	}

	public int getPokerHand() {
		int result;
		if(rsf(hands) == true) {
			result = 10;
		}else if(sf(hands) == true){
			result = 9;
		}else if(fc(hands) == 5) {
			result = 8;
		}else if(fh(hands) == 6) {
			result = 7;
		}else if(flash(hands) == true) {
			result = 6;
		}else if(straight(hands) == true) {
			result = 5;
		}else if(tc(hands) == 3) {
			result = 4;
		}else if(pairCount(hands) == 4) {
			result = 3;
		}else if(pairCount(hands) == 2) {
			result = 2;
		}else {
			result = 1;
		}
		return result;
	}
	
	public List<Card> tolist(){
		List<Card> hands1 = hands.stream().collect(toList());
		hands = hands1;
		return hands;
	}
	
	public List<Card> show_hand() {
		List<Card> handsSort = hands.stream().sorted(comparing(Card::getRank)).collect(toList());
		hands = handsSort;
		return hands;
	}

	public void add(Card card) {
		hands.add(card);
	}

	public void remove(int del) {
		hands.remove(del);

	}


	@Override
	public int compareTo(Player o){
		if(this.getPokerHand() < o.getPokerHand()) {
			return 1;
		}else if(this.getPokerHand() > o.getPokerHand()){
			return -1;
		}else {
			return 0;
		}

	}

	public String PokerHand(Player o) {
		String pokerHand = null;
		if(o.getPokerHand() == 10) {
			pokerHand = "★★ROYAL STRAIGHT FLUSH★★";
		}else if(o.getPokerHand() == 9) {
			pokerHand = "★STRAIGHT FLUSH★";
		}else if(o.getPokerHand() == 8) {
			pokerHand = "FOUR OF A KIND";
		}else if(o.getPokerHand() == 7) {
			pokerHand = "A FULLHOUSE";
		}else if(o.getPokerHand() == 6) {
			pokerHand = "FLUSH";
		}else if(o.getPokerHand() == 5) {
			pokerHand = "STRAIGHT";
		}else if(o.getPokerHand() == 4) {
			pokerHand = "THERR OF A KIND";
		}else if(o.getPokerHand() == 3) {
			pokerHand = "TWO PAIR";
		}else if(o.getPokerHand() == 2) {
			pokerHand = "ONE PAIR";
		}else if(o.getPokerHand() == 1) {
			pokerHand = "NO PAIR";
		}
		return pokerHand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hands == null) ? 0 : hands.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if(hands == null) {
			if(other.hands != null)
				return false;
		} else if(!hands.equals(other.hands))
			return false;
		return true;
	}
	
}
