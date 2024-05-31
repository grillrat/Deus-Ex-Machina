package src.main;

/**
 * Represents a crucial abstraction within {@code SystemWhole},
 * serving as a foundational element in understanding the dynamic structure and
 * behavior of its parts. This record encapsulates the state or condition of a
 * specific part or aspect of a Machine, symbolizing it through the combination
 * of a property and its corresponding value. This encapsulation is instrumental
 * in defining the Machine's identity within the framed environment.
 * <p>
 * For example, in the context of analyzing a Machine for humanoid
 * characteristics,
 * a collection of {@code PartState} instances might delineate attributes such
 * as
 * a "physical" body type, an "anthropomorphic" face type, and a "biotypical"
 * reverie.
 * These instances collectively facilitate the SystemWhole in discerning the
 * Machine's
 * inherent nature.
 * </p>
 * 
 * <b>Record structure:</b>
 * <ul>
 * <li>{@code String property} - Acts as an identifier for the
 * {@code PartState},
 * denoting the specific attribute it represents. It is the name assigned to the
 * characteristic (e.g., "bodyType", "faceType", "reverie"), crucial for
 * decoding
 * the Machine's overarching identity.</li>
 * <li>{@code Object value} - Captures the current state of the
 * {@code property},
 * providing a detailed account of the attribute. It is capable of holding
 * various
 * data types, thereby enabling a nuanced portrayal of each property's
 * state.</li>
 * </ul>
 * 
 * 
 * <b>Methods:</b>
 * <ul>
 * <li>{@code public String toString()} - Provides a textual representation of
 * the
 * {@code PartState}, amalgamating the property and its value into a coherent
 * and
 * easily interpretable string. Particularly valuable for debugging purposes or
 * when visualizing the state of a part of a Machine.</li>
 * </ul>
 * 
 * <p>
 * <strong>Easter Egg 1/4:</strong> The following snippet illustrates the
 * fundamental
 * code structure of the {@code PartState} using a record type, which creates a class for you. This easter egg serves to
 * provide a
 * glimpse into the class's implementation and is intended for those keen on
 * discovering
 * hidden elements within the documentation. It mimics the original class, but
 * not quite...
 * </p>
 * 
 * <pre>{@code
 * public class PartState {
 *     private final String property;
 *     private final Object value;
 * 
 *     public PartState(String property, Object value) {
 *         this.property = property;
 *         this.value = value;
 *     }
 * 
 *     @Override
 *     public String toString() {
 *         return String.format("PartState{%s=%s}", property, value);
 *     }
 * }
 * }</pre>
 * 
 * Constructs a {@code PartState} instance with a specific property and its
 * corresponding value.
 * 
 * @param property The name of the characteristic or attribute this
 *                 {@code PartState} represents (e.g., "bodyType").
 * @param value    The state or value of the {@code property}, capable of
 *                 holding various data types to represent the attribute's
 *                 state.
 */
public record PartState(String property, Object value) {
    @Override
    public String toString() {
        return String.format("PartState{%s=%s}", property, value);
    }
}
