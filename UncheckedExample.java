public class UncheckedExample {
    public static void checkCakePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Unchecked exception: price cannot be negative.");
        }
    }
}
