import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Elephant Cappacio!");

        Map<String, Integer> items = new HashMap<>();
        items.put("Potatoes", 10);
        items.put("Tomatoes", 20);
        items.put("Cheese", 30);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello what would you like to order:");
        items.forEach((key, value) -> System.out.println(key + ": " + value));

        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        scanner.close();
    }

}

