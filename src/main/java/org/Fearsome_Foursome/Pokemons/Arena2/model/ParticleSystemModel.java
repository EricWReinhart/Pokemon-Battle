/* *****************************************
 * CSCI205 -Software Engineering and Design
 * Fall2022* Instructor: Prof. Brian King
 *
 * Name: Jiasong Zhu
 * Section: 02, 11:00 AM
 * Date: 11/10/22
 * Time: 3:44 PM
 *
 * Project: csci205_final_project
 * Package: org.Fearsome_Foursome.Pokemons.Arena2.model* Class: ParticleSystemModel
 *
 * Description:
 *
 * ****************************************
 */
package org.Fearsome_Foursome.Pokemons.Arena2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class ParticleSystemModel {
    /** Default number of particles for each emitter if not specified */
    public static final int DEF_NUM_PARTICLES = 200;

    /** A shared random number generator */
    private final Random rng =  new Random();

    /** A list of emitters in our particle system */
    private List<Emitter> listOfEmitters;

    /**
     * Construct a new particle system model
     */
    public ParticleSystemModel() {
        this.listOfEmitters = new ArrayList<>();
    }

    /** Return a stream view of the list of emitters */
    public Stream<Emitter> emitterStream(){
        return this.listOfEmitters.stream();
    }

    /**
     * Add a new emitter that will produce a specified number of particles
     * @param x the x-coordinate of the emitter
     * @param y the y-coordinate of the emitter
     * @param numParticles number of particles that will be emitted
     */
    public void addNewEmitter(int x, int y, int numParticles){
        Emitter emitter = new Emitter(x, y, numParticles);
        this.listOfEmitters.add(emitter);
    }

    /**
     * Generate an emitter at a random location
     * @param maxWidth - maximum x-coordinate to allow
     * @param maxHeight - maximum y-coordinate to allow
     * @param numParticles - number of particles to emit
     */
    public void generateRandomEmitter(int maxWidth, int maxHeight, int numParticles){
        int x = rng.nextInt(maxWidth);
        int y = rng.nextInt(maxHeight);
        this.addNewEmitter(x, y, numParticles);
    }

    /**
     * Generate random emitter with a default number of particles
     * @param maxWidth maximum x-coordinate to consider
     * @param maxHeight maximum y-coordinate to consider
     */
    public void generateRandomEmitter(int maxWidth, int maxHeight){
        this.generateRandomEmitter(maxWidth, maxHeight, DEF_NUM_PARTICLES);
    }

    /**
     * Start the timeline animation for each emitter in our system
     */
    public void play(){
        emitterStream().forEach(emitter -> emitter.play());
    }

    /**
     * Stop the animation for each emiter
     */
    public void stopAndReset(){
        emitterStream().forEach(emitter -> emitter.stopAndReset());
    }
}
