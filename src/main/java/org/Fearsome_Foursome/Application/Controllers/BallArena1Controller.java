package org.Fearsome_Foursome.Application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BallArena1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;

    @FXML
    private ImageView ballAlly;

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView pokeCreatureRemainingImageView;

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'ballArena1.fxml'.";
        assert ballAlly != null : "fx:id=\"ballAlly\" was not injected: check your FXML file 'ballArena1.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'ballArena1.fxml'.";
        assert pokeCreatureRemainingImageView != null : "fx:id=\"pokeCreatureRemainingImageView\" was not injected: check your FXML file 'ballArena1.fxml'.";

    }

}
