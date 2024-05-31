/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;
import java.util.List;

public record MemorySnapshot(List<SystemWhole> emulationMemory, List<SystemWhole> simulacraMemory, List<SystemWhole> simulationMemory){
    // public List<SystemWhole> getEmulationMemory(){
    //     return emulationMemory;
    // }

    // public List<SystemWhole> getSimulacraMemory(){
    //     return simulacraMemory;
    // }

    //Used in FordTest.java
    public List<SystemWhole> getSimulationMemory(){
        return simulationMemory;
    }

}

