/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;

import src.main.*;  //FIXME: imports westworld (?)
import java.util.ArrayList;
import java.util.List;


public class Dolores extends Robot implements Wipeable{
    /**
     * Holds instances of the NarrativeLoop type.
     */
    private List<NarrativeLoop> narrativeLoops = new ArrayList<NarrativeLoop>();

    /**
     * Constructor for Dolores, created with a Robot's default values:
     * String[] emergences, int serialNumber, boolean flies, boolean autonomous, boolean teleoperated
     */
    public Dolores(){
        //Default values for parent Robot
        super(null, 0, false, false, false);
    }

    /**
     * Adds provided NarrativeLoop to Dolores's list of NarrativeLoop instances.
     * @param narrativeLoop
     */
    final public void addNarrativeLoop(NarrativeLoop narrativeLoop){
        narrativeLoops.add(narrativeLoop);
    }

    /**
     * Cannot directly get absolute capabilities for Dolores, so
     * throws UnsupportedOperationException.
     */
    final public Machine[] getAbsoluteCapabilities(){
        throw new UnsupportedOperationException("Cannot get absolute capabilities directly.");

    }

    /**
     * Stops all operations and activities
     * @return false, because cannot freeze motor functions of Dolores.
     */
    public boolean freezeAllMotorFunctions(){
        return false;
    }


    // Obtain the last NarrativeLoop: If the list isn't empty, obtain the last NarrativeLoop from narrativeLoops. This represents the most recent narrative state.
    // Create a MemorySnapshot:
    
    /**
     * Protects Dolores's memory from being wiped and to log each memory wipe
     */
    @Override
    public MemorySnapshot analyze(){
        // Check for Empty List
        if(narrativeLoops.isEmpty()){
            //If so, return null to indicate there are no narratives to analyze.
            return null;
        }

        //Obtain last NarrativeLoop if list not empty
        NarrativeLoop recentNarrativeLoop = narrativeLoops.getLast();

        //Create defense copies to prevent modification of most recent NarrativeLoop's lists
        //Defense copy syntax from Baeldung: https://www.baeldung.com/java-copy-list-to-another#constructor
        List<SystemWhole> copyEmulation = new ArrayList<>(recentNarrativeLoop.emulation);
        List<SystemWhole> copySimulacra = new ArrayList<>(recentNarrativeLoop.simulacra);
        List<SystemWhole> copySimulation = new ArrayList<>(recentNarrativeLoop.simulation);
        //Create MemorySnapshot of most recent NarrativeLoop's lists with copies of lists
        MemorySnapshot recentMemorySnapshot = new MemorySnapshot(copyEmulation, copySimulacra, copySimulation);

        return recentMemorySnapshot;
    }

    /**
     * Resets or clears Dolores's narrative loops and memory states.
     */
    public void wipe(){

    }
}
