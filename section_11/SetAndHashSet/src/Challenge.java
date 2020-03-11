public class Challenge {

    /*
    * When overriding the equals() method in the HeavenlyBody class, we
    * were careful to make sure that it would not return true if an HeavenlyBody
    * was compared to a subclass of itself.
    *
    * We did that tot demonstrate that method, but it was actually
    * unnecessary in the HeavenlyBody class.
    *
    * The mini challenge is just a question: why was it unnecessary?
    *
    * Hint: if you are stuck, checkout lecture 97
    *
    * Anser:
    *
    * The HeavenlyBody class is declared final, so that be subclassed.
    * The Java String class is also final, which is why it can safely
    * use the instanceof method without having to worry about
    * comparison with a subclass.
    * */
}
