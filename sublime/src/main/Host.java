/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;

/**
 * A Host can analyze narratives, manage memory, and respond to control commands.
 */
public class Host extends Dolores{
    private NarrativeLoop narrativeLoop;

    /**
     * Host's constructor adds a NarrativeLoop (sorted list of machines) to Dolores.
     * @param narrativeLoop
     */
    public Host(NarrativeLoop narrativeLoop){
        super();
        narrativeLoop = this.narrativeLoop; //FIXME: Make sure this.narrativeLoop is argument narrativeLoop
        addNarrativeLoop(this.narrativeLoop);
    }

    /**
     * This method successfully stops all of Host's activities.
     * @return boolean
     */
    public boolean freezeAllMotorFunctions(){
        
        return true;
    }

    /**
     * This method analyzes Host's NarrativeLoop by making
     * a MemorySnapshot of its NarrativeLoop's 
     * emulation, simulacra, and simulation lists.
     * @return MemorySnapshot
     */
    public MemorySnapshot analyze(){
        if(narrativeLoop == null){
            return null;
        }

        //FIXME: Might have to initialize emulation, simulacra, simulation lists beforehand for shorter line
        MemorySnapshot analyzable = new MemorySnapshot(narrativeLoop.emulation, narrativeLoop.simulacra, narrativeLoop.simulation);
        return analyzable;
    }

    /**
     * This method clears all of the lists of machines in Host's NarrativeLoop.
     */
    public void wipe(){
        narrativeLoop.wipeNarrativeLoops();
    }

/**
 * This method stops all operations and activities of Host.
 * @return boolean (true), indicating success in freezing Host's operations and activities.
 */
    public boolean freeze(){
        //FIXME: Is there a method to really stop all of a Host's activity? What activity should we stop?

        return freezeAllMotorFunctions();
    }


}
