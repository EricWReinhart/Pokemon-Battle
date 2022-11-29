package org.Fearsome_Foursome.Application.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LightArena1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView background;

    @FXML
    private ImageView lightAlly;

    @FXML
    private ImageView nonSwitchCreatureImage;

    @FXML
    private AnchorPane pane;

    @FXML
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'lightArena1.fxml'.";
        assert lightAlly != null : "fx:id=\"lightAlly\" was not injected: check your FXML file 'lightArena1.fxml'.";
        assert nonSwitchCreatureImage != null : "fx:id=\"nonSwitchCreatureImage\" was not injected: check your FXML file 'lightArena1.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'lightArena1.fxml'.";

    }

}
