/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/10/22
 * Time: 4:33 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Pokemons.Arena2* Class: ParticleSystemController
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Pokemons.Arena2;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.Fearsome_Foursome.Pokemons.Arena2.model.ParticleSystemModel;

public class ParticleSystemController {
    /** A reference to the model this controller must work with */
    private ParticleSystemModel theModel;

    /** The graphics context of the canvas */
    private GraphicsContext gc;

    /** Our animationTimer object that will keep the canvas updated */
    private AnimationTimer animationTimer;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStop;

    @FXML
    private Canvas canvas;

    @FXML
    private CheckBox checkboxcontinuous;

    @FXML
    void initialize() {
        assert btnGenerate != null : "fx:id=\"btnGenerate\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert btnStart != null : "fx:id=\"btnStart\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert btnStop != null : "fx:id=\"btnStop\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'particlesim.fxml'.";
        assert checkboxcontinuous != null : "fx:id=\"checkboxcontinuous\" was not injected: check your FXML file 'particlesim.fxml'.";

        // We are going to need to access the graphics context of canvas. A lot.
        this.gc = canvas.getGraphicsContext2D();
    }

    /**
     * Set the model for this controller
     *
     * @param theModel the {@link ParticleSystemModel} connected to this controller
     */
    public void setModel(ParticleSystemModel theModel){
        this.theModel = theModel;

        initEventHandlers();
    }

    /**
     * Initialize event handlers for the app. There is an implied assumption
     * that the model has already been set if this method is called
     */
    private void initEventHandlers(){
        // Generate one new emitter in the model
        this.btnGenerate.setOnAction(event -> {
            this.theModel.generateRandomEmitter((int)this.canvas.getWidth(),
                    (int)this.canvas.getHeight());
        });

        // Set the start button handler
        this.btnStart.setOnAction(event -> {
            // If we already have an animation timer, then just stop the timeline and reset it to the beginning
            if(this.animationTimer != null){
                this.theModel.stopAndReset();
            }
            else{
                // We don't have a timer, so create it
                this.animationTimer = createAnimationTimer();
            }

            // Update the timeline to start playing
            this.theModel.play();

            // Start the animationTimer
            this.animationTimer.start();
        });

    }

    /**
     * Construct an instance of an {@link AnimationTimer} that will update every
     * particle
     */
    private AnimationTimer createAnimationTimer(){
        return (new AnimationTimer() {
            private long lastTS = 0;
            @Override
            public void handle(long now) {
                System.out.printf("Elapsed time: %.2f ms%n", ((now - lastTS) / 1000000.0));
                lastTS = now;
            }
        });
    }

}

