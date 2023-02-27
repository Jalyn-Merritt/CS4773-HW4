package viewmodel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;
import model.TeamInfo;

public class ViewModel implements Subject {
	
	TeamInfo teamInfo;
	Facade infoHandler;
	List<EditorViewer> editorViews;
	ScoreboardViewer scoreboardView;
	
	public ViewModel() {
		scoreboardView = null;
		teamInfo = new TeamInfo();
		infoHandler = new Facade();
		editorViews = new ArrayList<EditorViewer>();
	}
	
	public String teamNameChecker(String userEntry, String defaultTeamName) {
		return infoHandler.validateTeamName(userEntry,defaultTeamName);
	}
	
	public int scoreChecker(String userEntry, int defaultScore) {
		return infoHandler.validateScore(userEntry, defaultScore);
	}
	
	public String modificationDateChecker
			(int newScore, int defaultScore, String newName, String defaultName, String defaultDate) {
		return infoHandler.validateModificationDate
				(newScore, defaultScore, newName, defaultName, defaultDate);
	}
	
	@Override
	public void registerObserver(EditorViewer editor) {
		editorViews.add(editor);
	}
	
	@Override
	public void notifyObservers() {
		for(int i = 0; i < editorViews.size() ; i++){
			editorViews.get(i).update
					(getSpecificTeamName(editorViews.get(i).indexOfTeam), 
							getSpecificScore(editorViews.get(i).indexOfTeam), 
								getSpecificModificationDate(editorViews.get(i).indexOfTeam));
		}
	}
	
	public String viewTeamInfo(int index) {
		return teamInfo.viewableTeamInfo(index);
	}
	
	public void viewScoreboard(Stage stage) throws IOException {
		scoreboardView = infoHandler.constructScoreboard(scoreboardView, this, stage);
	}
	
	public void viewEditor(int index, ViewModel viewModel) throws IOException {
		EditorViewer editorView = infoHandler.constructEditor(index, this);
		registerObserver(editorView);
	}
	
	public void teamInfoUpdate(int index, String teamName, int score, String modificationDate) {
		infoHandler.updateTeams(scoreboardView, this, index, teamName, score, modificationDate);
	}
	
	public int getTeamCount() {
		return teamInfo.getNumOfTeams();
	}
	
	public String getSpecificTeamName(int index) {
		return teamInfo.getIndexedTeamName(index);
	}
	
	public void setSpecificTeamName(int index, String teamName) {
		this.teamInfo.setIndexedTeamName(index, teamName);
	}
	
	public int getSpecificScore(int index) {
		return teamInfo.getIndexedScore(index);
	}
	
	public void setSpecificScore(int index, int score) {
		this.teamInfo.setIndexedScore(index, score);
	}
	
	public String getSpecificModificationDate(int index) {
		return teamInfo.getIndexedModificationDate(index);
	}
	
	public void setSpecificModificationDate(int index, String modificationDate) {
		this.teamInfo.setIndexedModificationDate(index, modificationDate);
	}
}