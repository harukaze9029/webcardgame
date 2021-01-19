package model;

import java.util.List;

public class Playcheck {

	public boolean handsCheck(List<Card> gabageAfter, List<Card> gabagebefore) {

		//2枚以上のときにそれぞれの数字が異なるとき
		if(gabageAfter.size() >= 2) {
			for(int i = 0; i < gabageAfter.size() - 1; i++) {
				if(gabageAfter.get(i).getRank() != gabageAfter.get(i + 1).getRank()) {
					return false;
				}
			}
		}

		if(gabagebefore.size() >= 1) {

			//捨札と場の枚数が異なるとき
			if(gabagebefore.size() != gabageAfter.size()) {
				return false;
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

}
