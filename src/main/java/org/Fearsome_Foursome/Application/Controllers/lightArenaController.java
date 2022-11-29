/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/28/22
 * Time: 10:40 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Application.Controllers* Class: lightArenaController
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Application.Controllers;

/**
 * Sample Skeleton for 'lightArena2.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class lightArenaController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="background"
    private ImageView background; // Value injected by FXMLLoader

    @FXML // fx:id="lightAlly"
    private ImageView lightAlly; // Value injected by FXMLLoader

    @FXML // fx:id="lightEnemy"
    private ImageView lightEnemy; // Value injected by FXMLLoader

    @FXML // fx:id="pane"
    private AnchorPane pane; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'lightArena2.fxml'.";
        assert lightAlly != null : "fx:id=\"lightAlly\" was not injected: check your FXML file 'lightArena2.fxml'.";
        assert lightEnemy != null : "fx:id=\"lightEnemy\" was not injected: check your FXML file 'lightArena2.fxml'.";
        assert pane != null : "fx:id=\"pane\" was not injected: check your FXML file 'lightArena2.fxml'.";

    }

}
