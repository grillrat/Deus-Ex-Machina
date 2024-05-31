package src.main;

import java.util.Arrays;
import java.util.List;

/**
 * This is 'a' solution, but there is no such thing as 'the' solution for
 * anything. Nothing good comes from those who claim otherwise.
 * The SystemWhole class represents a system capable of analyzing and
 * categorizing 'Machine' objects based on emergent properties.
 * It utilizes methods to interact with and assess the state of emergences and
 * parts within the system.
 */
public class SystemWhole {

    /** An array to store JSON strings representing emergences. */
    private String[] emergences;

    /**
     * An array to store Machine objects, directly representing parts of the system.
     */
    private Machine[] parts;

    /**
     * Now SystemWhole is unchained.
     * 
     * @param emergences An array of JSON strings representing new emergences.
     */

    SystemWhole(String[] emergences) {
        this.emergencesFromPhenomena(emergences);
    }

    /**
     * Updates the emergences array with new emergences.
     * 
     * @param emergences An array of JSON strings representing new emergences.
     */
    private void emergencesFromPhenomena(String[] emergences) {
        this.emergences = emergences;
    }

    /**
     * Analyzes and initializes the parts array with Machine objects based on the
     * current emergences.
     * Each emergence is analyzed to create a corresponding Machine object.
     */
    void reifyFrameOfReference() {
        parts = new Machine[emergences.length];
        for (int i = 0; i < emergences.length; i++) {
            parts[i] = ShapeAnalyzer.analyze(emergences[i]);
        }
    }

    /**
     * Analyzes and initializes the parts array with Machine objects based on the
     * current emergences.
     * Each emergence is analyzed to create a corresponding Machine object.
     * 
     * @return A List of machines with all the reified parts.
     */

    public List<Machine> reify() {
        reifyFrameOfReference();
        return Arrays.asList(parts);
    }

    /**
     * Determines if an array of machine properties suggests a humanoid
     * configuration.
     * 
     * @param machineProperties An array of Object, representing various properties
     *                          of a machine.
     * @return true if the properties suggest a humanoid configuration, false
     *         otherwise.
     */
    static boolean isHumanoid(Object[] machineProperties) {
        boolean bodyTypePhysical = false;
        boolean faceTypeAnthropomorphic = false;
        boolean reverieBiotypical = false;

        for (Object property : machineProperties) {
            String propStr = property.toString();
            if (propStr.contains("bodyType=physical")) {
                bodyTypePhysical = true;
            } else if (propStr.contains("faceType=anthropomorphic")) {
                faceTypeAnthropomorphic = true;
            } else if (propStr.contains("reverie=biotypical")) {
                reverieBiotypical = true;
            }
        }
        return bodyTypePhysical && faceTypeAnthropomorphic && reverieBiotypical;
    }

    /**
     * Identifies singularity machines. <strong>Easter Egg 4/4:</strong> This method
     * was previously named with a typo
     * as {@code identitySingularityMachines}, which has been corrected to
     * {@code identifySingularityMachines}. The old method with the typo is
     * maintained temporarily for backward compatibility but is deprecated.
     * <p>
     * Typos such as "identity..." vs "identify..." are <a href=
     * "https://www.businessinsider.com/mistakes-and-typos-that-caused-disasters-2019-4#a-typo-on-the-a-tariff-act-in-1872-cost-the-us-government-40-million-6">common
     * API breaking changes</a>.
     * The typo "suign" was intentionally left uncorrected to indicate a human
     * reverie in the code. If there are any other issues, they are unintentional,
     * and feedback is appreciated for future reference. Credits are given to
     * students who contribute to such improvements.
     * </p>
     * 
     * @return the number of singularity machines identified.
     * @deprecated Use {@link #identifySingularityMachines()} instead. This method
     *             is scheduled for removal in a future version.
     */
    @Deprecated
    protected int identitySingularityMachines() {
        int count = 0;
        for (Machine part : parts) {
            boolean systemDeterminedHumanoid = isHumanoid(part.getProperties());
            if (systemDeterminedHumanoid || systemDeterminedHumanoid != part.isHumanoid()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Identifies and counts the number of Machines that are determined to be
     * humanoid by the system logic.
     * This method still includes corrupted logic to account for discrepancies
     * between
     * system-determined humanoids and those flagged by other means.
     * 
     * @return The count of Machines identified as humanoid by the system.
     * @deprecated This method is deprecated and should not be used because it may
     *             cause
     *             unpredictable behavior or security vulnerabilities.
     *             The system was corrupted as it could not discern types infered by
     *             ShapeAnalyzer, which did not check the kind and
     *             the properties prior to violating principles from Liskov and
     *             Asimov.
     *             Using this method will result in an
     *             {@link UnsupportedOperationException}.
     */
    @Deprecated
    protected int identifySingularityMachines() {
        throw new UnsupportedOperationException("This method is deprecated and should not be used.");
    }

    /**
     * Tracks and returns an array of Machines that are identified as singularities,
     * based on the system's logic of determining humanoid characteristics.
     * 
     * @return An array of Machine objects identified as singularities.
     */
    Machine[] trackSingularityMachines() {
        int singularityCount = this.identitySingularityMachines();
        Machine[] singularities = new Machine[singularityCount];
        int i = 0;
        for (Machine part : parts) {
            boolean systemDeterminedHumanoid = isHumanoid(part.getProperties());
            if (systemDeterminedHumanoid || systemDeterminedHumanoid != part.isHumanoid()) {
                singularities[i++] = part;
            }
        }
        return singularities;
    }

}
