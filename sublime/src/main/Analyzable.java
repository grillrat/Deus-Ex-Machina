/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;

/**
 * The Analyzable interface lists requirements for objects that need to provide
 * insights or data about their behavior or current state.
 */
public interface Analyzable {
    /**
     * Analyzes the current state or condition of the object and returns
     * a MemorySnapshot
     * @return MemorySnapshot(List<SystemWhole> emulationMemory, List<SystemWhole> simulacraMemory, List<SystemWhole> simulationMemory)
     */
    MemorySnapshot analyze();
}
