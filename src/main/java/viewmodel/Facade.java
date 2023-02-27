package viewmodel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

public class Facade {
	
	public ScoreboardViewer constructScoreboard
				(ScoreboardViewer scoreboardView, ViewModel viewModel, Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("Scoreboard.fxml"));
		Parent root = loader.load();
		scoreboardView = loader.getController();
		scoreboardView.contestViewer = viewModel;
		scoreboardView.initializeScene(scoreboardView.contestViewer);
		Scene scene = new Scene(root);
		stage.setTitle("Team Scoreboard");
		stage.setScene(scene);
		stage.setOnCloseRequest(e -> Platform.exit());
		stage.show();
		
		return scoreboardView;
	}
	
	public EditorViewer constructEditor
				(int index, ViewModel viewModel) throws IOException {
	   	FXMLLoader loader = new FXMLLoader(Main.class.getResource("Editor.fxml"));
		Parent root = loader.load();
		EditorViewer editorView = loader.<EditorViewer>getController();
		editorView.initializeScene(index, viewModel);
	    Stage window = new Stage();
	    window.setTitle("Team Editor");
	    window.setScene(new Scene(root));
	    window.show();
		
		return editorView;
	}
	
	public String validateTeamName(String userEntry, String defaultTeamName) {
		String nameRegexPattern = "^[a-zA-Z0-9\\s]+$";
		
		if(patternMatches(userEntry, nameRegexPattern) 
				&& userEntry.length() >= 5 && userEntry.length() <= 50) {
			return  userEntry.trim();
		}
		
		if(userEntry.isEmpty()) {
			return "No name provided";
		}
		else {
			return defaultTeamName;
		}
	}
	
	public int validateScore(String userEntry, int defaultScore) {
		try {
			int scoreHandler = Integer.parseInt(userEntry);
			if(scoreHandler >= 0 && scoreHandler <= 2000)
				return scoreHandler;
		}
		catch(NumberFormatException exception) {}
		
		if(userEntry.isEmpty()) {
			return 0;
		}
		else {
			return defaultScore;
		}
	}
	
	public String validateModificationDate
				(int newScore, int defaultScore, String newName, String defaultName, String defaultDate) {
		if(newScore != defaultScore || !newName.equals(defaultName)) {
			SimpleDateFormat dateFormatting = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStamp = dateFormatting.format(new Date());
			
			return timeStamp;
		}
		else {
			return defaultDate;
		}
	}
	
	public static boolean patternMatches(String teamName, String regexPattern) {
	    return Pattern.compile(regexPattern).matcher(teamName).matches();
	}
	
	public void updateTeams
					(ScoreboardViewer scoreboardView, ViewModel viewModel, 
							int index, String teamName, int score, String modificationDate) {
		viewModel.setSpecificTeamName(index, teamName);
		viewModel.setSpecificScore(index, score);
		viewModel.setSpecificModificationDate(index, modificationDate);
		
		scoreboardView.update();
		viewModel.notifyObservers();
	}
}