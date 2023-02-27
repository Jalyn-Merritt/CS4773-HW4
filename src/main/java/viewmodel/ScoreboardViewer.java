package viewmodel;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class ScoreboardViewer {
	
	ViewModel contestViewer;
	@FXML private ListView<String> scoreboardList;
	private ObservableList<String> items = FXCollections.observableArrayList();
	
	public void initializeScene(ViewModel viewModel) {
		contestViewer = viewModel;
		scoreboardList.setItems(items);
		
		for(int i = 0; i < viewModel.getTeamCount() ; i++) {
			items.add(viewModel.viewTeamInfo(i));
		}
	}
	
	@FXML 
	public void handleMouseClick(MouseEvent arg0) throws IOException {
		int chosenIndex = scoreboardList.getSelectionModel().getSelectedIndex();
		
		contestViewer.viewEditor(chosenIndex, contestViewer);
	}
	
	public void update() {
		scoreboardList.getItems().clear();
		scoreboardList.setItems(items);
		
		for(int i = 0; i < contestViewer.getTeamCount() ; i++){
			items.add(contestViewer.viewTeamInfo(i));
		}
	}
}