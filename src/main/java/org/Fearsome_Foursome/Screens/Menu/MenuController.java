/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/12/22
 * Time: 11:05 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Screens.Menu* Class: MenuContoller
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Screens.Menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MenuController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Background;

    @FXML
    private Text author;

    @FXML
    private Button btnStart;

    @FXML
    private ImageView dragonite;

    @FXML
    private ImageView grass1;

    @FXML
    private ImageView grass2;

    @FXML
    private ImageView grass3;

    @FXML
    private ImageView pikachu;

    @FXML
    private Text textQuit;

    @FXML
    private Label title;

    @FXML
    private Text tm;

    @FXML
    private Text version;

    @FXML
    void initialize() {
        assert Background != null : "fx:id=\"Background\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert author != null : "fx:id=\"author\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert dragonite != null : "fx:id=\"dragonite\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert grass1 != null : "fx:id=\"grass1\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert grass2 != null : "fx:id=\"grass2\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert grass3 != null : "fx:id=\"grass3\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert pikachu != null : "fx:id=\"pikachu\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert textQuit != null : "fx:id=\"textQuit\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert tm != null : "fx:id=\"tm\" was not injected: check your FXML file 'pokemonMenu.fxml'.";
        assert version != null : "fx:id=\"version\" was not injected: check your FXML file 'pokemonMenu.fxml'.";

    }



}
