/*
* Name: Alice Lee
* netID: jlee415
* G#: 01454835
* Lecture section: 001
* Lab section: 201  
*/

package src.main;

/**
 * The Freezable interface contains required information for objects that need to 
 * safely stop their activities.
 */
public interface Freezable {
    /**
     * freeze() stops an object's activity.
     * @return boolean for whether object can freeze or not
     */
    boolean freeze();
}
