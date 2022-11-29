package org.Fearsome_Foursome.Application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LightArena2Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;

    @FXML
    private ImageView lightEnemy;

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView remainingPokeCreatureImageView;

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'lightArena2.fxml'.";
        assert lightEnemy != null : "fx:id=\"lightEnemy\" was not injected: check your FXML file 'lightArena2.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'lightArena2.fxml'.";
        assert remainingPokeCreatureImageView != null : "fx:id=\"remainingPokeCreatureImageView\" was not injected: check your FXML file 'lightArena2.fxml'.";

    }

    /**
     * Getter for the background
     * @return {@link ImageView}
     */
    public ImageView getBackground() {
        return background;
    }
}
