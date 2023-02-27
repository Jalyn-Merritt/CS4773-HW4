package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import viewmodel.ViewModel;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
 	public void start(Stage stage) throws IOException {
		ViewModel contestViewer = new ViewModel();
		
		contestViewer.viewScoreboard(stage);
 	}
}