/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;

/**
 * The Wipeable interface lists requirements for objects that 
 * need to be analyzed and have thier data or operations wiped.
 */
public interface Wipeable extends Analyzable{
    /**
     * Clears or resets the state of the object.
     */
    void wipe();
}
