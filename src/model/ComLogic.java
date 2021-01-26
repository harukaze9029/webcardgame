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
			if(count == 3) {
				if(hands.get(hands.size() - 1).getRank() == 14 ||
						hands.get(hands.size() - 1).getRank() == 15){
					gabagelist.add(hands.get(hands.size() - 1));
					hands.remove(hands.size() - 1);
				}
				if(hands.get(hands.size() - 2).getRank() == 14 ||
						hands.get(hands.size() - 1).getRank() == 15){
					gabagelist.add(hands.get(hands.size() - 2));
					hands.remove(hands.size() - 2);
				}
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
							|| (hands.get(i).getRank() == 2 && hands.get(i + 1).getRank() == 14)
							|| (hands.get(i).getRank() == 2 && hands.get(i + 1).getRank() == 15)
							|| (hands.get(i).getRank() == 14 && hands.get(i + 1).getRank() == 15))) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
					if(gabage.get(0).getRank() == 2 && hands.get(i).getRank() == 14
							&& hands.get(i + 1).getRank() == 15) {
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
					if(gabage.get(0).getRank() == 13 || gabage.get(0).getRank() <= 2) {
						if(hands.get(hands.size() - 1).getRank() == 14 ||
						hands.get(hands.size() - 1).getRank() == 15) {
							if(gabage.get(0).getRank() < hands.get(i).getRank()
									&& gabage.get(0).getRank() != 1 && gabage.get(0).getRank() != 2){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(hands.size() - 1));
								hands.remove(i);
								hands.remove(hands.size() - 1);
								break;
							}
						}
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
					if((hands.get(i).getRank() == hands.get(i + 1).getRank())
							&&(gabage.get(0).getRank() >= 11 && gabage.get(0).getRank() <= 2)
							&&(hands.get(hands.size() - 1).getRank() == 14
								|| hands.get(hands.size() - 1).getRank() == 15)) {
						if(gabage.get(0).getRank() < hands.get(i).getRank()){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 1);
							break;
						}
					}
					if(hands.size() <= 7
							&&(gabage.get(0).getRank() >= 9 && gabage.get(0).getRank() <= 2)){
						if(hands.get(hands.size() - 2).getRank() == 14
								&& hands.get(hands.size() - 1).getRank() == 15) {
							if(gabage.get(0).getRank() < hands.get(i).getRank()){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(hands.size() - 2));
								gabagelist.add(hands.get(hands.size() - 1));
								hands.remove(i);
								hands.remove(hands.size() - 2);
								hands.remove(hands.size() - 1);
								break;
							}

						}else if(hands.get(i).getRank() == hands.get(i + 1).getRank()
								|| (hands.get(hands.size() - 1).getRank() == 14
								|| hands.get(hands.size() - 1).getRank() == 15)) {
							if(gabage.get(0).getRank() < hands.get(i).getRank()){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(i + 1));
								gabagelist.add(hands.get(hands.size() - 1));
								hands.remove(i);
								hands.remove(i);
								hands.remove(hands.size() - 1);
								break;
							}
						}
					}
				}
			}

		}else if(gabage.size() == 4) {
			if(hands.size() >= 4) {
				for(int i = 0; i < hands.size() - 3; i++) {
					if(hands.get(i).getRank() == hands.get(i + 1).getRank() &&
							hands.get(i).getRank() == hands.get(i + 2).getRank() &&
							hands.get(i).getRank() == hands.get(i + 3).getRank()) {
						if(gabage.get(0).getRank() < hands.get(i).getRank()){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(i + 3));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
					}
					if(hands.get(i).getRank() == hands.get(i + 1).getRank() &&
							hands.get(i).getRank() == hands.get(i + 2).getRank() &&
							(hands.get(hands.size() - 1).getRank() == 14
								|| hands.get(hands.size() - 1).getRank() == 15)) {
						if(gabage.get(0).getRank() < hands.get(i).getRank()){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 1);
							break;
						}
					}
					if(hands.get(i).getRank() == hands.get(i + 1).getRank()
							&& hands.get(hands.size() - 2).getRank() == 14
								&& hands.get(hands.size() - 1).getRank() == 15) {
						if(gabage.get(0).getRank() < hands.get(i).getRank()){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(hands.size() - 2));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 2);
							hands.remove(hands.size() - 1);
							break;
						}
					}
				}
			}
		}
		return hands;

	}
	public List<Card> revocomLogic(List<Card> hands,List<Card> gabage) {

		gabagelist = new ArrayList<Card>();

		if(gabage.size() == 0) {

			int count = 1;
			int jcount = 0;
			if(hands.size() >= 4) {
				if(hands.get(hands.size() - 2).getRank() == 14
					&& hands.get(hands.size() - 1).getRank() == 15) {
					jcount = 2;
				}else if(hands.get(hands.size() - 1).getRank() == 14
						|| hands.get(hands.size() - 1).getRank() == 15) {
					jcount = 1;
				}

				for(int i =  hands.size() - 2; 0 <= i; i--) {
					if(hands.get(i).getRank() == hands.get(i + 1).getRank() ||
							(hands.get(i + 1).getRank() == 15
							&& hands.get(i).getRank() == 14)) {
						count++;
					}else {
						break;
					}
				}
			}

			if(jcount == 0) {
				for(int i = 0; i < count; i++) {
					gabagelist.add(hands.get(hands.size() - 1));
					hands.remove(hands.size() - 1);
				}
			}else if(jcount == 1){
				count = 1;
				for(int i =  hands.size() - 2; 0 <= i; i--) {
					if(hands.get(i).getRank() == hands.get(i - 1).getRank()) {
						count++;
					}else {
						break;
					}
				}
				for(int i = 0; i < count; i++) {
					gabagelist.add(hands.get(hands.size() - 2));
					hands.remove(hands.size() - 2);
				}
				if(count == 3) {
					gabagelist.add(hands.get(hands.size() - 1));
					hands.remove(hands.size() - 1);
				}
			}else if(jcount == 2) {
				count = 1;
				for(int i =  hands.size() - 3; 0 <= i; i--) {
					if(hands.get(i).getRank() == hands.get(i - 1).getRank()) {
						count++;
					}else {
						break;
					}
				}
				for(int i = 0; i < count; i++) {
					gabagelist.add(hands.get(hands.size() - 3));
					hands.remove(hands.size() - 3);
				}
				if(count == 3) {
					gabagelist.add(hands.get(hands.size() - 2));
					hands.remove(hands.size() - 2);
				}
			}
			setGabagelist(gabagelist);

		}else if(gabage.size() == 1) {

			for(int i =  hands.size() - 1; 0 <= i; i--) {
				if((gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15)
						&& hands.get(i).equals(new Card(Suit.spade,3))) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}else if(gabage.get(0).getRank() == 14 || gabage.get(0).getRank() == 15) {
					break;
				}
				if(gabage.get(0).getRank() == 1 && hands.get(i).getRank() <=13
						&& hands.get(i).getRank() != 1 && hands.get(i).getRank() != 2) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
				if(gabage.get(0).getRank() == 2 && (hands.get(i).getRank() != 2
						&& hands.get(i).getRank() != 14
						&& hands.get(i).getRank() != 15)) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
				if(gabage.get(0).getRank() == 3
						&& (hands.get(i).getRank() == 14
						|| hands.get(i).getRank() == 15)) {
					gabagelist.add(hands.get(i));
					hands.remove(i);
					break;
				}
				if(hands.get(i).getRank() != 1
						&& hands.get(i).getRank() != 2
						&& hands.get(i).getRank() != 14
						&& hands.get(i).getRank() != 15) {
					if(gabage.get(0).getRank() > hands.get(i).getRank()){
						gabagelist.add(hands.get(i));
						hands.remove(i);
						break;
					}
				}
			}
			setGabagelist(gabagelist);

		}else if(gabage.size() == 2) {

			if(hands.size() >= 2) {
				for(int i =  hands.size() - 2; 0 <= i; i--) {
					if(gabage.get(0).getRank() == 14) {
						break;
					}
					if(gabage.get(0).getRank() == 1
							&& hands.get(i).getRank() == hands.get(i + 1).getRank()
							&& ((hands.get(i).getRank() != 2 && hands.get(i + 1).getRank() != 2)
							|| (hands.get(i).getRank() != 14 && hands.get(i + 1).getRank() != 15))) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
					if(gabage.get(0).getRank() == 2
							&& hands.get(i).getRank() == hands.get(i + 1).getRank()
							&& hands.get(0).getRank() != 2) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
					if(gabage.get(0).getRank() == 3
							&& hands.get(i).getRank() == 14 && hands.get(i + 1).getRank() == 15) {
						gabagelist.add(hands.get(i));
						gabagelist.add(hands.get(i + 1));
						hands.remove(i);
						hands.remove(i);
						break;
					}
					if(gabage.get(0).getRank() != 1 && gabage.get(0).getRank() != 2
							&& gabage.get(0).getRank() != 14 && gabage.get(0).getRank() != 15) {
						if(hands.get(i).getRank() == hands.get(i + 1).getRank()) {
							if((gabage.get(0).getRank() > hands.get(i).getRank())
									&& hands.get(i).getRank() == 1
									&& hands.get(i).getRank() == 2){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(i + 1));
								hands.remove(i);
								hands.remove(i);
								break;
							}
						}
					}
					if(gabage.get(0).getRank() == 4 &&
						(hands.get(hands.size() - 1).getRank() == 14 ||
						hands.get(hands.size() - 1).getRank() == 15)) {
						if(hands.get(i).getRank() == 3){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(hands.size() - 1);
							break;
						}
					}
				}

			}
			setGabagelist(gabagelist);
		}else if(gabage.size() == 3) {

			if(hands.size() >= 3) {
				for(int i =  hands.size() - 3; 0 <= i; i--) {

					if(hands.get(i).getRank() == hands.get(i + 1).getRank() &&
							hands.get(i).getRank() == hands.get(i + 2).getRank()) {
						if(gabage.get(0).getRank() == 2 && hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
						if(gabage.get(0).getRank() == 1
								&& hands.get(i).getRank() != 2
								&& hands.get(i).getRank() != 1){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
						if(gabage.get(0).getRank() > hands.get(i).getRank()
								&& hands.get(i).getRank() != 1 && hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
					}
					if((hands.get(i).getRank() == hands.get(i + 1).getRank())
							&&(gabage.get(0).getRank() <= 11 && gabage.get(0).getRank() >= 2)
							&&(hands.get(hands.size() - 1).getRank() == 14
								|| hands.get(hands.size() - 1).getRank() == 15)) {
						if(gabage.get(0).getRank() < hands.get(i).getRank()){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 1);
							break;
						}
					}
					if(hands.size() <= 7
							&&(gabage.get(0).getRank() <= 7 && gabage.get(0).getRank() > 2)) {
						if(hands.get(hands.size() - 2).getRank() == 14
								&& hands.get(hands.size() - 1).getRank() == 15) {
							if(gabage.get(0).getRank() < hands.get(i).getRank()){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(hands.size() - 2));
								gabagelist.add(hands.get(hands.size() - 1));
								hands.remove(i);
								hands.remove(hands.size() - 2);
								hands.remove(hands.size() - 1);
								break;
							}
						}else if(hands.get(i).getRank() == hands.get(i + 1).getRank()
								|| (hands.get(hands.size() - 1).getRank() == 14
										|| hands.get(hands.size() - 1).getRank() == 15)) {
							if(gabage.get(0).getRank() < hands.get(i).getRank()){
								gabagelist.add(hands.get(i));
								gabagelist.add(hands.get(i + 1));
								gabagelist.add(hands.get(hands.size() - 1));
								hands.remove(i);
								hands.remove(i);
								hands.remove(hands.size() - 1);
								break;
							}
						}
					}
				}
			}
			setGabagelist(gabagelist);
		}else if(gabage.size() == 4) {
			if(hands.size() >= 4) {
				for(int i =  hands.size() - 4; 0 <= i; i--) {
					if(hands.get(i).getRank() == hands.get(i + 1).getRank() &&
							hands.get(i).getRank() == hands.get(i + 2).getRank() &&
							hands.get(i).getRank() == hands.get(i + 3).getRank()) {
						if(gabage.get(0).getRank() == 2 && hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(i + 3));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
						if(gabage.get(0).getRank() == 1
								&& hands.get(i).getRank() != 1
								&& hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(i + 3));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
						if(gabage.get(0).getRank() > hands.get(i).getRank()
								&& hands.get(i).getRank() != 1
								&& hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(i + 3));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							break;
						}
					}
					if(hands.get(i).getRank() == hands.get(i + 1).getRank() &&
							hands.get(i).getRank() == hands.get(i + 2).getRank() &&
							(hands.get(hands.size() - 1).getRank() == 14
								|| hands.get(hands.size() - 1).getRank() == 15)) {
						if(gabage.get(0).getRank() > hands.get(i).getRank()
								&& hands.get(i).getRank() != 1
								&& hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 1);
							break;
						}else if(hands.get(i).getRank() == 1
								&& gabage.get(0).getRank() == 2) {
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(i + 2));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 1);
							break;
						}
					}
					if(hands.get(i).getRank() == hands.get(i + 1).getRank()
							&& hands.get(hands.size() - 2).getRank() == 14
								&& hands.get(hands.size() - 1).getRank() == 15) {
						if(gabage.get(0).getRank() > hands.get(i).getRank()
								&& hands.get(i).getRank() != 1
								&& hands.get(i).getRank() != 2){
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(hands.size() - 2));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 2);
							hands.remove(hands.size() - 1);
							break;
						}else if(hands.get(i).getRank() == 1
								&& gabage.get(0).getRank() == 2) {
							gabagelist.add(hands.get(i));
							gabagelist.add(hands.get(i + 1));
							gabagelist.add(hands.get(hands.size() - 2));
							gabagelist.add(hands.get(hands.size() - 1));
							hands.remove(i);
							hands.remove(i);
							hands.remove(hands.size() - 2);
							hands.remove(hands.size() - 1);
							break;
						}
					}
				}
			}
			setGabagelist(gabagelist);
		}
		return hands;
	}

}
