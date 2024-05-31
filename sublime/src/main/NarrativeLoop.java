/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;

import java.util.ArrayList;
import java.util.List;
import src.main.*;
/*
 * Create bin folder
 * Compile all files with command on github
 * Files should all end up in bin, tricking code into thinking all classes are connected
 * (this is how they are connected!)
 * Compile with given Windows command on github, without version 14 comment
 */
//FIXME: There are no abstract methods...?
public abstract class NarrativeLoop {

    /**ArrayList of emulation (high-fidelity replications of the original system) SystemWholes */
    final protected List<SystemWhole> emulation = new ArrayList<SystemWhole>();
    /** */
    final protected List<SystemWhole> simulacra = new ArrayList<SystemWhole>();
    final protected List<SystemWhole> simulation = new ArrayList<SystemWhole>();

    public void wipeNarrativeLoops(){
        emulation.clear();
        simulacra.clear();
        simulation.clear();
    }
    
    /**
     * This method adds machines into respective arraylists based on kind, if machine hasn't already been added
     * @param emulationContext array of SystemWholes (String arrays)
     * @param simulacraContext array of String arrays
     */

    final public void updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext){
        //Iterate over each SystemWhole in emulationContext array
        for(SystemWhole systemWhole : emulationContext){
            //Turn systemWhole into list of Machine objects
            List<Machine> machines = systemWhole.reify();
            //For each SystemWhole, iterate through the Machines it contains.
            for(Machine machine : machines){
                //Invoke determineRealm with the Machine's kind and both context arrays as parameters.
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                //If determineRealm returns Realm.EMULATION 
                //and containsKind confirms the emulation list doesn't already include a Machine
                // of this kind, add the SystemWhole to emulation.
                if(realm == Realm.EMULATION && !containsKind(emulation, machine.getKind()) && !emulation.contains(systemWhole)){
                    emulation.add(systemWhole);
                }
            }
        }

        //Repeat the process for the simulacraContext array.
        for(SystemWhole systemWhole : simulacraContext){
            //Turn systemWhole into list of Machine objects
            List<Machine> machines = systemWhole.reify();
            //For each SystemWhole, iterate through the Machines it contains.
            for(Machine machine : machines){
                //Invoke determineRealm with the Machine's kind and both context arrays as parameters.
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                // For Realm.SIMULACRA, add unique Machine kinds to simulacra.
                if(realm == Realm.SIMULACRA && !containsKind(simulacra, machine.getKind()) && !simulacra.contains(systemWhole)){
                    simulacra.add(systemWhole);
                }
                // For Realm.SIMULATION, add unique Machine kinds to simulation.
                if(realm == Realm.SIMULATION && !containsKind(simulation, machine.getKind()) && !simulation.contains(systemWhole)){
                    simulation.add(systemWhole);
                }
            }
        }
    }

    final private Realm determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext){
        //Check for the presence of the Machine kind in both emulationContext 
        //and simulacraContext using isInContext.
        boolean simulacra = isInContext(kind, simulacraContext);
        boolean emulation = isInContext(kind, emulationContext);

        //Assign Realm.SIMULATION if the kind is found in both contexts.
        if(simulacra && emulation){
            return Realm.SIMULATION;
        }
        //Assign Realm.SIMULACRA if the kind is found only in simulacraContext.
        if(simulacra){
            return Realm.SIMULACRA;
        }
        //Default to Realm.EMULATION if neither of the above conditions is met.
        return Realm.EMULATION;
    }

    final private boolean isInContext(String kind, SystemWhole[] context){
            //Iterate through the SystemWhole array provided as context.
        for(SystemWhole systemWhole : context){
            //Within each SystemWhole, iterate through its Machines.
            List<Machine> machines = systemWhole.reify();
            for(Machine machine : machines){
                if(machine.getKind().equals(kind)){
                    //Return true if any Machine within the SystemWhole matches the specified kind.
                    return true;
                }
            }
        }
        return false;
    }
    

    /**
     * 
     * @param list of SystemWholes, which are String arrays (?), each containing a Machine's kind
     * @param kind 
     * @return true if any Machine in list matches specified kind
     */
    /*
     * List:[["{'kind': 'Square'}", "{'kind': 'Box'}"],,,, ["{'kind': 'Square'}", "{'kind': 'Box'}"]]
     */
    
    final private boolean containsKind(List<SystemWhole> list, String kind){
        // Iterate over the provided list of SystemWhole instances.
        for(SystemWhole systemWhole : list){
            //Within each SystemWhole, iterate through its Machines.
            List<Machine> machines = systemWhole.reify();
            for(Machine machine : machines){
                // Return true if any Machine within the SystemWhole matches the specified kind.
                if(machine.getKind() == kind){
                    return true;
                }
            }
        }
        // Return false if no matching Machine kind is found within any SystemWhole in the list.
        return false;
    }

    //FIXME: Testing only
    public static void main(String[] args){
        // P2 emergences strings be like:
        String[] emergences = {"kind:Human"};
        // Using Bernard to get systems (whole)
        SystemWhole aSystemWhole = Bernard.analysis(emergences);
        // matching updateNarrativeLoops parameter types
        SystemWhole[] systemWholes = {aSystemWhole};
        // Getting a narrative
       NarrativeLoop narrativeLoop = new MazeLoop();
       //  //The system is in both, since it is the same array, it should be added to the simulation list.
       narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
       //  // Let's make sure of it, I can verify that via Host
       Host host = new Host(narrativeLoop);
       //  // Tell me what you got host
       MemorySnapshot memorySnapshot = host.analyze();
       //  // Your simulated memories must have the aSystemWhole I created for you 
       System.out.println(memorySnapshot.getSimulationMemory().contains((Object)aSystemWhole));

        

    }
}
