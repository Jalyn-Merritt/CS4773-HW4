package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamInfo {
	
	List<Team> teams = new ArrayList<Team>();
	String[] teamNames = {"Highly Irresistable Lions", "Immovable Tigers", 
								"Super Duper Bears", "Incomparable Otters", "Respendent Ocelots"};
	int[] teamScores = {45, 75, 100, 30, 8};

	public TeamInfo() {
		SimpleDateFormat dateFormatting = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStamp = dateFormatting.format(new Date());
		
		for (int i = 0; i < teamScores.length; i++) {
			teams.add(new Team(teamNames[i], teamScores[i], timeStamp));
		}
	}
	
	public String viewableTeamInfo(int index) {
		return String.format("%-20s \t\t\t\t %-15d", 
								teams.get(index).getTeamName(), teams.get(index).getScore());
	}
	
	public int getNumOfTeams() {
		return teams.size();
	}
	
	public String getIndexedTeamName(int index) {
		return teams.get(index).getTeamName();
	}
	
	public void setIndexedTeamName(int index, String teamName) {
		teams.get(index).setTeamName(teamName);
	}
	
	public int getIndexedScore(int index) {
		return teams.get(index).getScore();
	}
	
	public void setIndexedScore(int index, int score) {
		teams.get(index).setScore(score);
	}
	
	public String getIndexedModificationDate(int index) {
		return teams.get(index).getModificationDate();
	}
	
	public void setIndexedModificationDate(int index, String modificationDate) {
		teams.get(index).setModificationDate(modificationDate);
	}
}