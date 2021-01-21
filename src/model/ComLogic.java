package model;

import java.util.ArrayList;
import java.util.List;

public class ComLogic {
	List<Card> gabagelist;

	public void setGabagelist(List<Card> gabagelist) {
		this.gabagelist = gabagelist;
	}

	public List<Card> getGabagelist() {
		return gabagelist;
	}

	public List<Card> comLogic(List<Card> hands,List<Card> gabage) {

		gabagelist = new ArrayList<Card>();

		if(gabage.size() == 0) {

			int count = 1;
			for(int i = 0; i < hands.size() - 1; i++) {
				if(hands.get(i).getRank() == hands.get(i + 1).getRank() ||
						(hands.get(i).getRank() == 14 && hands.get(i + 1).getRank() == 15)) {
					count++;
				}else {
					break;
				}
			}
			for(int i = 0; i < count; i++) {
				gabagelist.add(hands.get(0));
				hands.remove(0);
			}
			setGabagelist(gabagelist);

		}else if(gabage.size() == 1) {

			for(int i = 0; i < hands.size(); i++) {
				if((gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15)
						&& hands.get(i).equals(new Card(Suit.spade,3))) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
				if(gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15) {
					break;
				}
				if(gabage.get(0).getRank() == 1 && (hands.get(i).getRank() == 2
						|| hands.get(i).getRank() == 14 || hands.get(i).getRank() == 15)) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
				if(gabage.get(0).getRank() == 2
						&& (hands.get(i).getRank() == 14 || hands.get(i).getRank() == 15)) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
				if(gabage.get(0).getRank() != 1 && gabage.get(0).getRank() != 2) {
					if(gabage.get(0).getRank() < hands.get(i).getRank()){
						gabagelist.add(hands.get(i));
						hands.remove(i);
						break;
					}
				}
				if(gabage.get(0).getRank() <= 13 && gabage.get(0).getRank() > 2 &&
						(hands.get(i).getRank() == 1 || hands.get(i).getRank() == 2)) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
			}
			setGabagelist(gabagelist);

		}else if(gabage.size() == 2) {

			if(hands.size() >= 2) {
				for(int i = 0; i < hands.size() - 1; i++) {
					if(gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15) {
						break;
					}
					if(gabage.get(0).getRank() == 1
							&& ((hands.get(i).getRank() == 2 && hands.get(i + 1).getRank() == 2)
							|| (hands.get(i).getRank() == 14 && hands.get(i + 1).getRank() == 14)
							|| (hands.get(i).getRank() == 15 && hands.get(i + 1).getRank() == 15))) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
					if(gabage.get(0).getRank() == 2 && hands.get(i).getRank() == 14 && hands.get(i + 1).getRank() == 15) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
					if(gabage.get(0).getRank() != 1 && gabage.get(0).getRank() != 2) {
						if(hands.get(i).getRank() == hands.get(i + 1).getRank()) {
							if(gabage.get(0).getRank() < hands.get(i).getRank()){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(i + 1));
								hands.remove(i);
								hands.remove(i);
								break;
							}
						}
					}
					if(gabage.get(0).getRank() <= 13 && gabage.get(0).getRank() > 2
							&& ((hands.get(i).getRank() == 1 && hands.get(i + 1).getRank() == 1)
							|| (hands.get(i).getRank() == 2 && hands.get(i + 1).getRank() == 2))) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
				}
			}

		}else if(gabage.size() == 3) {

			if(hands.size() >= 3) {
				for(int i = 0; i < hands.size() - 2; i++) {
					if(hands.get(i).getRank() == hands.get(i + 1).getRank() &&
							hands.get(i).getRank() == hands.get(i + 2).getRank()) {
						if(gabage.get(0).getRank() < hands.get(i).getRank()){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
					}
				}
			}

		}
		return hands;

	}

}
