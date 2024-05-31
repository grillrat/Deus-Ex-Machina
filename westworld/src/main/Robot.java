package src.main;

/**
 * Represents a general class for robots, encapsulating common capabilities and
 * characteristics.
 * This class serves as a base for describing various types of robots through
 * its attributes and methods,
 * allowing for the extension of new capabilities in subclasses. The
 * {@code Robot} class defines a robot's
 * ability to fly, operate autonomously, and be teleoperated, alongside a unique
 * serial number for identification.
 */
public abstract class Robot extends SystemWhole {
    private final int serialNumber;
    private boolean flies;
    private boolean autonomous;
    private boolean teleoperated;

    /**
     * Constructs a new {@code Robot} instance with specified capabilities and a
     * unique identifier.
     *
     * @param emergences   The emergences as in {@code SystemWhole}.
     * @param serialNumber The unique serial number of the robot.
     * @param flies        Indicates if the robot can move through the air.
     * @param autonomous   Indicates if the robot can act on its own without human
     *                     intervention.
     * @param teleoperated Indicates if the robot can be manually operated by a
     *                     human.
     */
    protected Robot(String[] emergences, int serialNumber, boolean flies, boolean autonomous, boolean teleoperated) {
        super(emergences);
        this.serialNumber = serialNumber;
        this.flies = flies;
        this.autonomous = autonomous;
        this.teleoperated = teleoperated;
    }

    /**
     * Sets the capabilities of the robot after object creation.
     *
     * @param flies        Indicates if the robot can fly.
     * @param autonomous   Indicates if the robot is autonomous.
     * @param teleoperated Indicates if the robot is teleoperated.
     */
    void setCapabilities(boolean flies, boolean autonomous, boolean teleoperated) {
        this.flies = flies;
        this.autonomous = autonomous;
        this.teleoperated = teleoperated;
    }

    /**
     * Returns the serial number of the robot.
     *
     * @return The unique serial number of the robot.
     */
    int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Checks if the robot can fly.
     *
     * @return {@code true} if the robot can fly, {@code false} otherwise.
     */
    boolean canFly() {
        return flies;
    }

    /**
     * Checks if the robot is autonomous.
     *
     * @return {@code true} if the robot is autonomous, {@code false} otherwise.
     */
    boolean isAutonomous() {
        return autonomous;
    }

    /**
     * Checks if the robot is teleoperated.
     *
     * @return {@code true} if the robot is teleoperated, {@code false} otherwise.
     */
    boolean isTeleoperated() {
        return teleoperated;
    }

    /**
     * Returns a string representing the capabilities of the robot.
     *
     * @return A space-separated string listing the robot's capabilities, such as
     *         "canFly isTeleoperated".
     */
    String getCapabilities() {
        StringBuilder capabilities = new StringBuilder();
        if (canFly())
            capabilities.append("canFly ");
        if (isAutonomous())
            capabilities.append("isAutonomous ");
        if (isTeleoperated())
            capabilities.append("isTeleoperated");
        return capabilities.toString().trim();
    }

    /**
     * Returns a Machine array representing the absolute capabilities of the robot.
     *
     * @return An army of machines, you really want to catch this
     */
    protected Machine[] getAbsoluteCapabilities() {
        return super.trackSingularityMachines();
    }

    /**
     * Provides a string representation of the robot, including its ID and
     * capabilities.
     *
     * @return A string in the format "ID: serialNumber, Capabilities:
     *         capabilities...".
     */
    @Override
    public String toString() {
        return String.format("ID: %d, Capabilities: %s", serialNumber, getCapabilities());
    }
}
