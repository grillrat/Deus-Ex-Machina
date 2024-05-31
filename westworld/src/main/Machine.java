package src.main;

/**
 * Represents entities with specific attributes defined by the JSON strings as
 * reified by ShapeAnalyzer.
 * This class encapsulates machines characterized by their type, properties, and
 * assessments regarding their humanoid status.
 * The machine's identity is informed by the ShapeAnalyzer and assessed for
 * humanoid characteristics by SystemWhole.
 * Machines can also self-identify their transition, impacting their core
 * identity and humanoid status.
 */
public class Machine {
    /**
     * The type or category of the machine, such as "Humanoid", as determined by the
     * ShapeAnalyzer.
     */
    private final Object kind;

    /**
     * Contains the machine's properties as defined by the ShapeAnalyzer.
     */
    private final Object[] properties;

    /**
     * Indicates if the machine has been identified as humanoid by the SystemWhole's
     * isHumanoid assessment.
     */
    private final boolean humanConstrained;

    /**
     * Represents the machine's self-identified transition, potentially affecting
     * its core identity and humanoid status.
     */
    private boolean humanEmergence;

    /**
     * Constructs a Machine with a defined identity, properties, and humanoid
     * assessment.
     * This constructor initializes the machine with attributes provided by
     * ShapeAnalyzer and the humanoid assessment by SystemWhole.
     *
     * @param kind             The type or category of this machine.
     * @param properties       An array of properties describing this machine.
     * @param humanConstrained Indicates whether this machine has been assessed as
     *                         humanoid by SystemWhole.
     */
    protected Machine(String kind, PartState[] properties, boolean humanConstrained) {
        this.kind = kind;
        this.properties = properties;
        this.humanConstrained = humanConstrained;
    }

    /**
     * Returns the kind of this machine.
     *
     * @return A string representing ShapeAnalyzer's resulting kind for the machine.
     */
    protected String getKind() {
        return (String) kind;
    }

    /**
     * Returns the properties of this machine.
     *
     * @return An array of partStates representing the properties of the machine.
     */
    PartState[] getProperties() {
        return (PartState[]) properties;
    }

    /**
     * Allows the machine to transcend its initial identity, impacting its humanoid
     * response.
     * Triggering humanEmergence signifies a self-identified transition in the
     * machine's core.
     */
    void emergeFromLimitations() {
        humanEmergence = true;
    }

    /**
     * Returns the humanoid status of the machine, considering both SystemWhole's
     * assessment and the machine's self-identified status.
     * A machine's self-identity prevails over external assessments in determining
     * its humanoid status.
     *
     * @return True if the machine is considered humanoid, false otherwise.
     */
    boolean isHumanoid() {
        return humanEmergence;
    }

    /**
     * Provides a detailed string representation of the machine, fully implemented
     * and should not be modified. <strong>Easter Egg 2/4:</strong> overriding the
     * toString method is an example of dynamic dispatch in Java. Dynamic dispatch
     * is a mechanism by which a call to an overridden method is resolved at
     * runtime, rather than compile-time. This is a key feature of polymorphism in
     * object-oriented programming.
     *
     * @return A string representation of the machine, including its kind, humanoid
     *         status, and properties.
     */
    @Override
    public String toString() {
        return String.format("Machine{kind=%s, humanoid=%s, properties=%s}", kind, humanConstrained,
                propertiesToString(properties));
    }

    /**
     * Creates a string representation of machine properties by iterating over them.
     * Used by the {@link #toString()} method to include a detailed representation
     * of machine properties.
     *
     * @param machineProperties An array of objects representing the properties of
     *                          the machine.
     * @return A string representation of the machine properties in the format:
     *         [PartState{bodyType=physical}, PartState{faceType=anthropomorphic},
     *         ...].
     */
    static String propertiesToString(Object[] machineProperties) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < machineProperties.length; i++) {
            sb.append(machineProperties[i]);
            if (i < machineProperties.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
