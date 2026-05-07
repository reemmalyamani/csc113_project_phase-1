public class UserDefinedExample extends RuntimeException  {
    public static void checkCakeType(String type) throws InvalidCakeTypeException {
        if (type == null) {
            throw new InvalidCakeTypeException("User-defined exception: cake type cannot be empty.");
        }
    }
}
