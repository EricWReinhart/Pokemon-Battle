package org.Fearsome_Foursome.Application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BallArena2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;

    @FXML
    private ImageView ballEnemy;

    @FXML
    private AnchorPane pane;

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'ballArena2.fxml'.";
        assert ballEnemy != null : "fx:id=\"ballEnemy\" was not injected: check your FXML file 'ballArena2.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'ballArena2.fxml'.";

    }

}
