public class Challenge {

    /**
     * When overriding the equals() method in the HeavenlyBody class, we
     * were careful to make sure tha it would not return true if a HeavenlyBody
     * was compared to a subclass of itself.
     *
     * We did that to demonstrate that method, but it was actually
     * unnecessary in the HeavenlyBody class.
     *
     * The mini challenge is just a questions: why was it unnecessary
     *
     * Hint: If you are stuck, check out lecture 97
     *
     * Answer:
     * The HeavenlyBody class is declared final, so cannot be subclassed.
     * The Java String class is also final, which is why it can safely
     * use the instanceof method without having to worry about
     * comparisons with subclass.
     */

}
