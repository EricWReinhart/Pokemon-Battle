/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/10/22
 * Time: 2:55 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Pokemons.Arena2.model* Class: Particle
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Pokemons.Arena2.model;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * A model for a single particle that will travel in some trajectory
 * and speed over a short duration. We will use the JavaFX {@link Timeline}
 * class to manage modeling the position changes over time
 */
public class Particle {
    /** The current x-coordinate of the particle */
    private final DoubleProperty x;

    /** The current y-coordinate of the particle */
    private final DoubleProperty y;

    /** The color of the particle */
    private final Color color;

    /** The timeline object that JavaFX provides to help auto-update
     * the particle position
     */
    private Timeline timeline;

    /**
     * This initializes a new {@link Timeline} to allow a particle to move
     * over time
     *
     * @param startX the starting x-coordinate for the particle
     * @param startY the starting y-coordinate for the particle
     * @param duration the number of seconds the particle should remain alive
     * @param xDeltaPerSec the change in x-coordinate per second
     * @param yDeltaPerSec the change in y-coordinate per second
     */
    private void initTimeLine(double startX, double startY, double duration,
                              double xDeltaPerSec, double yDeltaPerSec){
        this.timeline = new Timeline(
                // The starting location
                new KeyFrame(Duration.ZERO,
                        new KeyValue(x, startX),
                        new KeyValue(y, startY)
        ),
        // The end point after moving
        new KeyFrame(Duration.seconds(duration),
                new KeyValue(x, startX + (xDeltaPerSec * duration)),
                new KeyValue(y, startY + (yDeltaPerSec * duration))
        )
        );
    }

    /**
     * Initialize a new Particle object
     * @param startX starting x-coordinate
     * @param startY starting y-coordinate
     * @param duration how long the particle should stay alive in seconds
     * @param xDeltaPerSec change in x per second
     * @param yDeltaPerSec change in y per second
     * @param color color of the particle
     */
    public Particle(double startX, double startY, double duration, double xDeltaPerSec, double yDeltaPerSec,
                    Color color){
        this.x = new SimpleDoubleProperty();
        this.y = new SimpleDoubleProperty();
        this.color = color;
        this.initTimeLine(startX, startY, duration, xDeltaPerSec, yDeltaPerSec);
    }

    /**
     * Start the timeline animation
     */
    public void play(){ this.timeline.play();}

    /**
     * Pause the timeline animation
     */
    public void pause(){ this.timeline.pause();}

    /**
     * Stop the current animation and reset the timeline back to the beginning
     */
    public void stopAndReset(){ this.timeline.stop();}

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public Timeline getTimeline() {
        return timeline;
    }
}
