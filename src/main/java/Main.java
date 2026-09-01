import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get number of items
        int itemCount = 0;
        while (true) {
            System.out.print("Enter number of items: ");
            String input = scanner.nextLine().trim();
            try {
                itemCount = Integer.parseInt(input);
                if (itemCount > 0) {
                    break;
                }
                System.out.println("Item count must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
            }
        }

        // 2. Get price per item
        double pricePerItem = 0.0;
        while (true) {
            System.out.print("Enter price per item: $");
            String input = scanner.nextLine().trim();
            try {
                pricePerItem = Double.parseDouble(input);
                if (pricePerItem >= 0) {
                    break;
                }
                System.out.println("Price per item cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number (e.g. 19.99).");
            }
        }

        // 3. Get 2-letter state code & determine tax rate
        double taxRate = 0.0;
        String state = "";
        while (true) {
            System.out.print("Enter 2-letter state code (UT, NV, TX, AL, CA): ");
            state = scanner.nextLine().trim().toUpperCase();

            switch (state) {
                case "UT":
                    taxRate = 6.85;
                    break;
                case "NV":
                    taxRate = 8.00;
                    break;
                case "TX":
                    taxRate = 6.25;
                    break;
                case "AL":
                    taxRate = 4.00;
                    break;
                case "CA":
                    taxRate = 8.25;
                    break;
                default:
                    System.out.println("Invalid state code. Please enter one of UT, NV, TX, AL, CA.");
                    continue;
            }
            break;
        }

        // Calculations
        double baseTotal = itemCount * pricePerItem;

        // Discount based on order value
        double discountRate = 0.0;
        if (baseTotal >= 50000) {
            discountRate = 15.0;
        } else if (baseTotal >= 10000) {
            discountRate = 10.0;
        } else if (baseTotal >= 7000) {
            discountRate = 7.0;
        } else if (baseTotal >= 5000) {
            discountRate = 5.0;
        } else if (baseTotal >= 1000) {
            discountRate = 3.0;
        }

        double discountAmount = baseTotal * (discountRate / 100.0);
        double discountedPrice = baseTotal - discountAmount;
        double taxAmount = discountedPrice * (taxRate / 100.0);
        double finalTotal = discountedPrice + taxAmount;

        // Output summary
        System.out.println("\n================ ORDER SUMMARY ================");
        System.out.printf("Items:            %d @ $%.2f each%n", itemCount, pricePerItem);
        System.out.printf("Base Order Value: $%.2f%n", baseTotal);
        System.out.printf("Discount (%.0f%%):  -$%.2f%n", discountRate, discountAmount);
        System.out.printf("Discounted Price: $%.2f%n", discountedPrice);
        System.out.printf("Tax (%s %.2f%%):   +$%.2f%n", state, taxRate, taxAmount);
        System.out.println("-----------------------------------------------");
        System.out.printf("Total Price:      $%.2f%n", finalTotal);
        System.out.println("===============================================");

        scanner.close();
    }
}
