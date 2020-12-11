package model;

public class BattleLogic {
	
	public void win(Battle battle) {
		double count = battle.getWin();
		battle.setWin(count + 1.0);
	}
	
	public void lose(Battle battle) {
		double count = battle.getLose();
		battle.setLose(count + 1);
	}
	
	public void drow(Battle battle) {
		double count = battle.getDrow();
		battle.setDrow(count + 1);
	}
	public void win(Count battle) {
		double count = battle.getWin();
		battle.setWin(count + 1);
	}
	
	public void lose(Count battle) {
		double count = battle.getLose();
		battle.setLose(count + 1);
	}
	
	public void drow(Count battle) {
		double count = battle.getDrow();
		battle.setDrow(count + 1);
	}

}
