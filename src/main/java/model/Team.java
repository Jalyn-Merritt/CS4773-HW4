package model;

public class Team {
	
	private String teamName;
	private int score;
	private String modificationDate;
	
	Team(String teamName, int score, String modificationDate) {
		setTeamName(teamName);
		setScore(score);
		setModificationDate(modificationDate);
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getModificationDate() {
		return modificationDate;
	}
	
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
}