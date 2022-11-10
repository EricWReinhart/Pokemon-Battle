/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/8/22
 * Time: 3:16 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome* Class: pokemonArena
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Pokemons.Arena1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class pokemonArena {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Slider sliderBlue;

    @FXML
    private Slider sliderGreen;

    @FXML
    private Slider sliderRed;

    @FXML
    private Slider sliderSize;

    @FXML
    private TextField textFieldName;

    @FXML
    private Text textName;

    @FXML
    private Label lblStatusBar;

    @FXML
    void initialize() {
        assert textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert textName != null : "fx:id=\"textName\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert sliderBlue != null : "fx:id=\"sliderBlue\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert sliderGreen != null : "fx:id=\"sliderGreen\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert sliderRed != null : "fx:id=\"sliderRed\" was not injected: check your FXML file 'pokemonArena.fxml'.";
        assert sliderSize != null : "fx:id=\"sliderSize\" was not injected: check your FXML file 'pokemonArena.fxml'.";

        initBindings();

        // Initialize the slider values with the correct data
        Color c = (Color) textName.getFill();
        sliderRed.setValue(c.getRed());
        sliderGreen.setValue(c.getGreen());
        sliderBlue.setValue(c.getBlue());
        sliderSize.setValue(textName.getFont().getSize());
    }

    private void initBindings(){
        textName.textProperty().bind(textFieldName.textProperty());

        // Adjust the red value based on the red slider
        sliderRed.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color c = (Color) textName.getFill();
            textName.setFill(Color.color(newValue.doubleValue(), c.getGreen(), c.getBlue()));
            updateStatusBar();
        });

        sliderGreen.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color c = (Color) textName.getFill();
            textName.setFill(Color.color(newValue.doubleValue(), c.getRed(), c.getBlue()));
            updateStatusBar();
        });

        sliderBlue.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color c = (Color) textName.getFill();
            textName.setFill(Color.color(newValue.doubleValue(), c.getGreen(), c.getRed()));
            updateStatusBar();
        });

        sliderSize.valueProperty().addListener(((observable, oldValue, newValue) -> {
            Font f = textName.getFont();
            textName.setFont(Font.font(f.getFamily(), newValue.doubleValue()));
            updateStatusBar();
        }));
    }

    /**
     * Update the status bar with the current color and size of the text
     */
    private void updateStatusBar(){
        Color c = (Color) textName.getFill();
        lblStatusBar.setText(String.format("Color: %s   Size: %.1f", c.toString(),textName.getFont().getSize()));
    }

}
