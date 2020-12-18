package model;

public class BattleLogic {

	public void winpo(Count battle) {
		double count = battle.getWinpo();
		battle.setWinpo(count + 1);
	}

	public void losepo(Count battle) {
		double count = battle.getLosepo();
		battle.setLosepo(count + 1);
	}

	public void drawpo(Count battle) {
		double count = battle.getDrawpo();
		battle.setDrawpo(count + 1);
	}
	public void winbj(Count battle) {
		double count = battle.getWinbj();
		battle.setWinbj(count + 1);
	}

	public void losebj(Count battle) {
		double count = battle.getLosebj();
		battle.setLosebj(count + 1);
	}

	public void drawbj(Count battle) {
		double count = battle.getDrawbj();
		battle.setDrawbj(count + 1);
	}

}
