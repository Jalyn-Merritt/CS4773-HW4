package viewmodel;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditorViewer implements EventHandler<Event>, Observer {
	
	int indexOfTeam;
	int defaultScore;
	String defaultName;
	ViewModel contestViewer;
	@FXML private TextField editorTeamName;
	@FXML private TextField editorScore;
	@FXML private TextField editorDate;
	
	public void initializeScene(int index, ViewModel viewModel) {
		editorTeamName.setText(viewModel.getSpecificTeamName(index));
		editorScore.setText(String.format("%d", viewModel.getSpecificScore(index)));
		editorDate.setText(viewModel.getSpecificModificationDate(index));
		
		contestViewer = viewModel;
		this.indexOfTeam = index;
		this.defaultName = editorTeamName.getText();
		this.defaultScore = Integer.parseInt(editorScore.getText());
	}

	@Override
	public void handle(Event arg0) {
		int newScore = contestViewer.scoreChecker(editorScore.getText(), defaultScore);
		String newName = contestViewer.teamNameChecker(editorTeamName.getText(), defaultName);
		String timeStamp = contestViewer.modificationDateChecker
											(newScore, defaultScore, newName, defaultName, editorDate.getText());
		
		contestViewer.teamInfoUpdate(indexOfTeam, newName, newScore, timeStamp);
	}

	@Override
	public void update(String teamName, int score, String modificationDate) {
		editorTeamName.setText(teamName);
		editorScore.setText(String.format("%d", score));
		editorDate.setText(modificationDate);
		
		this.defaultName = teamName;
		this.defaultScore = score;
	}
}