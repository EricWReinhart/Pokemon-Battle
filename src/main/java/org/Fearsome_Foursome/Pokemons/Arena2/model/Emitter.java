/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/10/22
 * Time: 3:16 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Pokemons.Arena2.model* Class: Emitter
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Pokemons.Arena2.model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Emitter {
    /** Random number generation */
    private static Random rng = new Random();

    /** List of particles being emitted */
    private List<Particle> listOfParticles;

    /** Number of particles that will be emitted */
    private int numParticles;

    /** x-coordinate of the emitter */
    private double x;

    /** y-coordinate of the emitter */
    private double y;

    /** Maximum velocity allowed in pixels per second */
    public static final double MAX_VELOCITY_PER_SEC = 150.0;

    /** Maximum duration in seconds */
    public static final double MAX_DURATION = 5.0;

    /**
     * Initializes the emitter
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param numParticles number of particles
     */
    public Emitter(double x, double y, int numParticles) {
        this.x = x;
        this.y = y;
        this.numParticles = numParticles;
        this.listOfParticles = new ArrayList<>();
        this.initParticles();
    }

    /**
     * Initialize the set of particles that will be emitted from this emitter
     */
    private void initParticles(){
        while(listOfParticles.size() < this.numParticles){
            double durationInSec = rng.nextDouble() * MAX_DURATION;
            double xDeltaPerSec = rng.nextDouble() * MAX_VELOCITY_PER_SEC + -(MAX_VELOCITY_PER_SEC / 2);
            double yDeltaPerSec = rng.nextDouble() * MAX_VELOCITY_PER_SEC + -(MAX_VELOCITY_PER_SEC / 2);
            Particle p = new Particle(x, y, durationInSec, xDeltaPerSec, yDeltaPerSec, Color.YELLOW);
            listOfParticles.add(p);
        }
    }

    /**
     * Return a {@link Stream} object representing a stream of particles
     */
    public Stream<Particle> particleStream(){
        return this.listOfParticles.stream();
    }

    /**
     * Go through each particle and start the timeline
     */
    public void play(){
        particleStream().forEach(Particle::play);
    }

    public void stopAndReset(){
        particleStream().forEach(Particle::stopAndReset);
    }
}
