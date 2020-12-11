package model;

import java.util.List;

public class Decision {
	static int Count;
	private int playerCountTotal;
	private int hostCountTotal;
	
	public void Count(int playerCountTotal, int hostCountTotal) {
		this.playerCountTotal = playerCountTotal;
		this.hostCountTotal = hostCountTotal;
	}
	public int getPlayerCountTotal() {
		return playerCountTotal;
	}
	public int getHostCountTotal() {
		return hostCountTotal;
	}
	
	public void setPlayerCountTotal(int playerCountTotal) {
		this.playerCountTotal = playerCountTotal;
	}

	public void setHostCountTotal(int hostCountTotal) {
		this.hostCountTotal = hostCountTotal;
	}
	public int DecisionPlayer(List<Card> playerCard) {
		setPlayerCountTotal(0);
		for(int i = 0; i < playerCard.size(); i++) {
			if(playerCard.get(i).getRank() > 10) {
				Count = 10;
				setPlayerCountTotal(getPlayerCountTotal() + Count);
			}else{
				Count = playerCard.get(i).getRank();
				setPlayerCountTotal(getPlayerCountTotal() + Count);
			}
		}
		if(getPlayerCountTotal() > 21) {
			setPlayerCountTotal(-1);
		}else {
			for(int i = 0; i < playerCard.size(); i++) {
				if(playerCard.get(i).getRank() == 1) {
					if(getPlayerCountTotal() + 10 <= 21) {
						Count = 10;
						setPlayerCountTotal(getPlayerCountTotal() + Count);
					}else if(getPlayerCountTotal() > 21) {
						Count = 10;
						setPlayerCountTotal(getPlayerCountTotal() - Count);
					}
				}else {
					continue;
				}
			}
		}
		return getPlayerCountTotal();
	}
	
	public int DecisionHost(List<Card> hostCard) {
		setHostCountTotal(0);
		for(int i = 0; i < hostCard.size(); i++) {
			if(hostCard.get(i).getRank() > 10) {
				Count = 10;
				setHostCountTotal(getHostCountTotal() + Count);
			}else {
				Count = hostCard.get(i).getRank();
				setHostCountTotal(getHostCountTotal() + Count);
			}
		}
		if(getHostCountTotal() > 21) {
			setHostCountTotal(-1);
		}else {
			for(int i = 0; i < hostCard.size(); i++) {
				if(hostCard.get(i).getRank() == 1) {
					if(getHostCountTotal() + 10 <= 21) {
						Count = 10;
						setHostCountTotal(getHostCountTotal() + Count);
					}else if(getHostCountTotal() > 21){
						Count = 10;
						setHostCountTotal(getHostCountTotal() - Count);
					}
				}else {
					continue;
				}
			}
		}
		return getHostCountTotal();
	}
	
	public String decisionbattles(){
		String winlose;
		if(getPlayerCountTotal() == getHostCountTotal()) {
			winlose = "drow";
		}else if(getPlayerCountTotal() > getHostCountTotal()) {
			winlose = "win";
		}else if(getPlayerCountTotal() < getHostCountTotal()) {
			winlose = "lose";
		}else {
			winlose = "ERROR";
		}
		return winlose;
	}
}
