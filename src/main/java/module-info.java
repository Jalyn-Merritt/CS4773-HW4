module cs4773 {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires transitive javafx.graphics;
    
    opens viewmodel to javafx.fxml;

    exports main to javafx.graphics;
    exports model to javafx.graphics;
    exports viewmodel to javafx.graphics;
}