package model;

import java.util.List;

public class Playcheck {

	public boolean handsCheck(List<Card> gabageAfter, List<Card> gabagebefore) {

		//2枚以上のときにそれぞれの数字が異なるとき
		if(gabageAfter.size() >= 2) {
			for(int i = 0; i < gabageAfter.size() - 1; i++) {
				if(gabageAfter.get(i).getRank() != gabageAfter.get(i + 1).getRank()) {
					//ジョーカーの２枚重ね
					if(gabageAfter.get(i).getRank() == 14 && gabageAfter.get(i + 1).getRank() == 15) {
						break;
					}
					//ジョーカー２枚目回避
					if(gabageAfter.get(i + 1).getRank() == 14 || gabageAfter.get(i + 1).getRank() == 15){
						break;
					}
					//２，３枚目
					if(gabageAfter.size() == 3) {
						if((gabageAfter.get(i + 2).getRank() == 14 || gabageAfter.get(i + 2).getRank() == 15)
								||(gabageAfter.get(i + 1).getRank() == 14 && gabageAfter.get(i + 2).getRank() == 15)) {
							break;
						}
						//３,４枚目
					}else if(gabageAfter.size() == 4) {
						if((gabageAfter.get(i).getRank() != gabageAfter.get(i + 3).getRank())
								&& ((gabageAfter.get(i + 3).getRank() == 14 || gabageAfter.get(i + 3).getRank() == 15)
								|| (gabageAfter.get(i + 2).getRank() == 14 && gabageAfter.get(i + 3).getRank() == 15))) {
							break;
						}
						//4,5枚目
					}else if(gabageAfter.size() == 5) {
						if((gabageAfter.get(i).getRank() == gabageAfter.get(i + 2).getRank())
								&& (((gabageAfter.get(i + 4).getRank() == 14 || gabageAfter.get(i + 4).getRank() == 15)
										&& gabageAfter.get(i + 3) == gabageAfter.get(i))
									|| (gabageAfter.get(i + 3).getRank() == 14 && gabageAfter.get(i + 4).getRank() == 15))) {
							break;
						}
					}else if(gabageAfter.size() == 6) {
						if(gabageAfter.get(i + 1).getRank() == 14 && gabageAfter.get(i + 2).getRank() == 15) {
							break;
						}
					}
					return false;
				}
			}
		}

		if(gabagebefore.size() >= 1) {

			//捨札と場の枚数が異なるとき
			if(gabagebefore.size() != gabageAfter.size()) {
				return false;
			}

			if((gabagebefore.get(0).getRank() == 14 || gabagebefore.get(0).getRank() == 15)
					&& gabageAfter.get(0).equals(new Card(Suit.spade,3))) {
				return true;
			}

			if(gabagebefore.get(0).getRank() == 14 || gabagebefore.get(0).getRank() == 15) {
				return false;
			}

			if(gabagebefore.get(0).getRank() == gabageAfter.get(0).getRank()) {
				return false;
			}


			//捨札が1,2で場が１３以下（＝ジョーカーを除く）だった場合TRUE
			if(gabageAfter.get(0).getRank() == 1 && gabagebefore.get(0).getRank() <= 13 && gabagebefore.get(0).getRank() > 2) {
				return true;
			}else if(gabageAfter.get(0).getRank() == 2 && gabagebefore.get(0).getRank() <= 13){
				return true;
			}
			//捨札より場の値が大きかったとき
			if(gabagebefore.get(0).getRank() > gabageAfter.get(0).getRank()) {
				//場が1,2で捨札が１３以下だったとき
				if(gabagebefore.get(0).getRank() == 1 && gabageAfter.get(0).getRank() >= 13 && gabageAfter.get(0).getRank() > 2) {
					return false;
				}else if(gabagebefore.get(0).getRank() == 2 && gabageAfter.get(0).getRank() >= 13){
					return false;
				}
				return false;
			}
		}
		return true;

	}

	public boolean revohandsCheck(List<Card> gabageAfter, List<Card> gabagebefore) {

		//2枚以上のときにそれぞれの数字が異なるとき
		if(gabageAfter.size() >= 2) {
			for(int i = 0; i < gabageAfter.size() - 1; i++) {
				if(gabageAfter.get(i).getRank() != gabageAfter.get(i + 1).getRank()) {
					//ジョーカーの２枚重ね
					if(gabageAfter.get(i).getRank() == 14 && gabageAfter.get(i + 1).getRank() == 15) {
						break;
					}
					//ジョーカー２枚目回避
					if(gabageAfter.get(i + 1).getRank() == 14 || gabageAfter.get(i + 1).getRank() == 15){
						break;
					}
					//２，３枚目
					if(gabageAfter.size() == 3) {
						if((gabageAfter.get(i + 2).getRank() == 14 || gabageAfter.get(i + 2).getRank() == 15)
								||(gabageAfter.get(i + 1).getRank() == 14 && gabageAfter.get(i + 2).getRank() == 15)) {
							break;
						}
						//３,４枚目
					}else if(gabageAfter.size() == 4) {
						if((gabageAfter.get(i).getRank() != gabageAfter.get(i + 3).getRank())
								&& ((gabageAfter.get(i + 3).getRank() == 14 || gabageAfter.get(i + 3).getRank() == 15)
								|| (gabageAfter.get(i + 2).getRank() == 14 && gabageAfter.get(i + 3).getRank() == 15))) {
							break;
						}
						//4,5枚目
					}else if(gabageAfter.size() == 5) {
						if((gabageAfter.get(i).getRank() == gabageAfter.get(i + 2).getRank())
								&& (((gabageAfter.get(i + 4).getRank() == 14 || gabageAfter.get(i + 4).getRank() == 15)
										&& gabageAfter.get(i + 3) == gabageAfter.get(i))
									|| (gabageAfter.get(i + 3).getRank() == 14 && gabageAfter.get(i + 4).getRank() == 15))) {
							break;
						}
					}else if(gabageAfter.size() == 6) {
						if(gabageAfter.get(i + 1).getRank() == 14 && gabageAfter.get(i + 2).getRank() == 15) {
							break;
						}
					}
					return false;
				}
			}
		}

		if(gabagebefore.size() >= 1) {

			//捨札と場の枚数が異なるとき
			if(gabagebefore.size() != gabageAfter.size()) {
				return false;
			}

			if((gabagebefore.get(0).getRank() == 14 || gabagebefore.get(0).getRank() == 15)
					&& gabageAfter.get(0).equals(new Card(Suit.spade,3))) {
				return true;
			}

			if(gabagebefore.get(0).getRank() == 14 || gabagebefore.get(0).getRank() == 15) {
				return false;
			}

			if(gabagebefore.get(0).getRank() == gabageAfter.get(0).getRank()) {
				return false;
			}

			if(gabageAfter.get(0).getRank() == 1 && gabagebefore.get(0).getRank() == 2) {
				return true;
			}

			if(gabageAfter.get(0).getRank() == 14 && gabageAfter.get(0).getRank() <= 15) {
				return true;
			}

			//捨札が1,2で場が１３以下（＝ジョーカーを除く）だった場合FALSE
			if(gabageAfter.get(0).getRank() == 1 && gabagebefore.get(0).getRank() <= 13) {
				return false;
			}else if(gabageAfter.get(0).getRank() == 2){
				return false;
			}
			//場より捨札の方が値が大きかったとき
			if(gabagebefore.get(0).getRank() < gabageAfter.get(0).getRank()) {
				//場が1
				if(gabagebefore.get(0).getRank() == 1 && gabageAfter.get(0).getRank() <= 13 && gabagebefore.get(0).getRank() != 2) {
					return true;
				}else if(gabagebefore.get(0).getRank() == 2) {
					return true;
				}
				return false;
			}
		}
		return true;
	}

}
