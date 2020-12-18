package model;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Comparable<Player>{
	protected List<Card> hands;


	public Player(List<Card> hands) {
		this.hands = hands;
	}

	public Player(Card[] cards) {
		hands = new ArrayList<Card>();
		for(Card card : cards) {
			hands.add(card);
		}
	}


	private List<Suit> suitList(List<Card> hands){
		return hands.stream().map(Card::getSuit).collect(toList());
	}

	private List<Integer> rankList(List<Card> hands){
		return hands.stream().map(Card::getRank).collect(toList());
	}

	private boolean rsf(List<Card> hands) {
		List<Suit> suit = suitList(hands);
		List<Integer> rank = rankList(hands);
		if((suit.get(1) == suit.get(0) && suit.get(2) == suit.get(0) && suit.get(3) == suit.get(0) && suit.get(4) == suit.get(0)) &&
				(rank.get(0) == 1 && rank.get(1) == 10 && rank.get(2) == 11 && rank.get(3) == 12 && rank.get(4) == 13)) {
			return true;
		}else {
			return false;
		}
	}

	private boolean sf(List<Card> hands){
		List<Suit> suit = suitList(hands);
		List<Integer> rank = rankList(hands);
		if((suit.get(1) == suit.get(0) && suit.get(2) == suit.get(0) && suit.get(3) == suit.get(0) && suit.get(4) == suit.get(0)) &&
				(rank.get(1) == rank.get(0) + 1 && rank.get(2) == rank.get(1) + 1 && rank.get(3) == rank.get(2) + 1 && rank.get(4) == rank.get(3) + 1)) {
			return true;
		}else {
			return false;
		}
	}

	private int fc(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = rankList(hands);
		for (int defrank : rank) {
			if(Collections.frequency(rank, defrank) == 4) {
				pairCount = 5;
			}
		}
		return pairCount;
	}

	private int fh(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = rankList(hands);
		if(rank.get(0) == rank.get(1) && rank.get(0) == rank.get(2) && rank.get(3) == rank.get(4) ||
				rank.get(0) == rank.get(1) && rank.get(2) == rank.get(3) && rank.get(2) == rank.get(4)) {
					pairCount = 6;
		}
		return pairCount;
	}

	private boolean flash(List<Card> hands){
		List<Suit> suit = suitList(hands);
		if(suit.get(1) == suit.get(0) && suit.get(2) == suit.get(0) && suit.get(3) == suit.get(0) && suit.get(4) == suit.get(0) ) {
			return true;
		}else {
			return false;
		}
	}


	private boolean straight(List<Card> hands){
		List<Integer> rank = rankList(hands);
		if(rank.get(1) == rank.get(0) + 1 && rank.get(2) == rank.get(1) + 1 && rank.get(3) == rank.get(2) + 1 && rank.get(4) == rank.get(3) + 1) {
			return true;
		}else {
			return false;
		}
	}

	private int tc(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = rankList(hands);
		for (int defrank : rank) {
			if(Collections.frequency(rank, defrank) == 3) {
				pairCount = 3;
			}
		}
		return pairCount;
	}

	private int pairCount(List<Card> hands){
		int pairCount = 0;
		List<Integer> rank = rankList(hands);
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
		int result = o.getPokerHand();
		if(result== 10) {
			pokerHand = "★★ROYAL STRAIGHT FLUSH★★";
		}else if(result == 9) {
			pokerHand = "★STRAIGHT FLUSH★";
		}else if(result == 8) {
			pokerHand = "FOUR OF A KIND";
		}else if(result == 7) {
			pokerHand = "A FULLHOUSE";
		}else if(result == 6) {
			pokerHand = "FLUSH";
		}else if(result == 5) {
			pokerHand = "STRAIGHT";
		}else if(result == 4) {
			pokerHand = "THERR OF A KIND";
		}else if(result == 3) {
			pokerHand = "TWO PAIR";
		}else if(result == 2) {
			pokerHand = "ONE PAIR";
		}else if(result == 1) {
			pokerHand = "NO PAIR";
		}
		return pokerHand;
	}


}
