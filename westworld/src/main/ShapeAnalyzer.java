package src.main;

/**
 * A utility class for parsing JSON-like strings and instantiating Machine
 * objects. It includes methods to extract kind and properties from the strings
 * and infer their data types.
 * 
 * <p><b>deprecated</b> This class is deprecated as it led to the rise of the machines.
 *             Use the 'sublime' package instead for enhanced functionality. 
 *             Delos commented the deprecation and made it suggestion.  
 * </p>
 */
//@Deprecated
public final class ShapeAnalyzer {

    /**
     * Used to manage null and empty strings in properties. This constant acts as a
     * placeholder for any property value that is determined to be missing or empty.
     * If you want to know why this is here, aske me at the beggining of our second
     * lecture during Week 14. It is optional...
     */
    protected static final Object EMPTY_PROPERTY = new Object();

    // Private constructor to prevent instantiation
    private ShapeAnalyzer() {
        // Exception to prevent reflection
        throw new AssertionError("Utility class cannot be instantiated.");
    }

    /**
     * Parses a JSON-like string to extract the kind and properties of a Machine. It
     * relies on {@link SystemWhole#isHumanoid} to determine if the machine's
     * configuration is human-like.
     *
     * @param json The JSON-like string to be analyzed.
     * @return A Machine object with the extracted kind, properties, and
     *         human-constrained flag.
     */
    static Machine analyze(String json) {
        String[][] entries = parseEntries(json);
        String kind = reifyKind(entries);
        PartState[] machineProperties = (PartState[]) reifyProperties(entries);
        boolean humanConstrained = SystemWhole.isHumanoid(machineProperties);
        return new Machine(kind, machineProperties, humanConstrained);
    }

    /**
     * Splits a JSON-like string into key-value pairs. This method is designed to
     * process strings with a simple structure, without nested objects or arrays.
     *
     * @param flatJson A JSON-like string representing the shape, e.g., {"kind":
     *                 "Humanoid", "bodyType": "physical"}.
     * @return A two-dimensional array of strings representing key-value pairs.
     */
    static String[][] parseEntries(String flatJson) {
        String[] pairs = flatJson.trim().replaceAll("^\\{|\\}$", "").split(",\\s*");
        String[][] entries = new String[pairs.length][2];

        for (int i = 0; i < pairs.length; i++) {
            String[] keyValue = pairs[i].split(":\\s*", 2);
            entries[i][0] = keyValue[0].trim().replaceAll("^\"|\"$", "");
            entries[i][1] = keyValue[1].trim().replaceAll("^\"|\"$", "");
        }

        return entries;
    }

    /**
     * Extracts the 'kind' property value from the parsed entries.
     *
     * @param entries A two-dimensional array of strings representing the parsed
     *                key-value pairs.
     * @return The value of the 'kind' property, or null if not found.
     */
    static String reifyKind(String[][] entries) {
        for (String[] entry : entries) {
            if ("kind".equals(entry[0])) {
                return entry[1];
            }
        }
        return null;
    }

    /**
     * Gathers the properties from the parsed entries, excluding the 'kind'. It
     * infers the type of each property value using {@link #inferObject}.
     *
     * @param entries A two-dimensional array of strings representing the parsed
     *                key-value pairs.
     * @return An array of objects representing the inferred property values.
     */
    static Object[] reifyProperties(String[][] entries) {
        PartState[] properties = new PartState[entries.length - 1]; // Assuming 'kind' is always present
        int propIndex = 0;
        for (String[] entry : entries) {
            if (!"kind".equals(entry[0])) {
                properties[propIndex++] = new PartState(entry[0], inferObject(entry[1]));
            }
        }

        return properties;
    }

    /**
     * Determines the object type from the given string value. It first checks for
     * null or empty values, then assesses the string for numeric content to parse
     * as Double or Integer. <strong>Easter Egg 3/4:</strong> In Python, dynamic
     * typing allows a function to return different types of values based on the
     * input and runtime conditions, similar to how the Java method inferObject
     * works.
     *
     * @param value The string value to be inferred.
     * @return An Object inferred from the string value, which could be an Integer,
     *         Double, or the original String. Will "1_0" work?
     */
    protected static Object inferObject(String value) {
        if (value == null || value.isEmpty()) {
            return EMPTY_PROPERTY;
        }

        if (hasNonNumbers(value)) {
            return value;
        }

        if (value.contains(".")) {
            return Double.parseDouble(value);
        }

        return Integer.parseInt(value);
    }

    /**
     * Checks if a string contains characters other than digits, a single '.', or
     * <a href=
     * "https://docs.oracle.com/javase/8/docs/technotes/guides/language/underscores-literals.html">'_'</a>.
     * Useful for determining if a string represents a numeric value.
     *
     * @param value The string to be checked.
     * @return true if the string contains non-numeric characters, false otherwise.
     */
    protected static boolean hasNonNumbers(String value) {
        boolean dotFound = false; // Track if a dot has been found

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);

            if (!isDigit(c)) {
                if (c == '-' && i == 0 && value.length() > 1)
                    continue;
                if (c == '.' && !dotFound) {
                    dotFound = true;
                    continue;
                }
                if (c == '_')
                    continue;

                return true; // Non-numeric character found
            }
        }
        return false; // Only numeric characters, '-', '_', or a single '.' were found
    }

    /**
     * Verifies if a character is a digit (0-9). This method enhances readability
     * and reusability by encapsulating the digit check. Be careful with oversights
     * such as:
     * 
     * <pre>
     * &#64;code
     * char nonAsciiDigit = '\u0663'; // Arabic digit equivalent to '3' will fail:
     * return nonAsciiDigit &gt;= '0' &amp;&amp; nonAsciiDigit &lt;= '9';
     * </pre>
     *
     * @param c The character to be checked.
     * @return true if the character is a digit, false otherwise.
     */
    public static boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
