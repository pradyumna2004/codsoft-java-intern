import java.util.*;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount in Indian Rupees (INR): ");
        double inrAmount = sc.nextDouble();

        System.out.println("Choose the target currency:");
        System.out.println("1. US Dollar (USD)");
        System.out.println("2. Euro (EUR)");
        System.out.println("3. British Pound (GBP)");
        System.out.println("4. Japanese Yen (JPY)");
        System.out.println("5. Malaysian Ringgit (MYR)");

        System.out.print("Enter the option (1/2/3/4/5): ");
        int choice = sc.nextInt();

        double convertedAmount = convertCurrency(inrAmount, choice);
        if (convertedAmount < 0) {
            System.out.println("Invalid option or unsupported currency.");
        } else {
            String targetCurrency = getTargetCurrency(choice);
            System.out.println("Converted amount: " + convertedAmount + " " + targetCurrency);
        }
    }

    public static double convertCurrency(double inrAmount, int choice) {
        double conversionRate = getConversionRate(choice);
        if (conversionRate < 0) {
            return -1.0;  // Return a negative value to indicate an unsupported conversion.
        }
        return inrAmount*conversionRate;
    }

    public static double getConversionRate(int choice) {
        switch (choice) {
            case 1: // USD
                return 0.014;  // 1 INR = 0.014 USD
            case 2: // EUR
                return 0.012;  // 1 INR = 0.012 EUR
            case 3: // GBP
                return 0.010;  // 1 INR = 0.010 GBP
            case 4: // JPY
                return 1.58;  // 1 INR = 1.58 JPY
            case 5: // MYR
                return 0.056;  // 1 INR = 0.056 MYR
            default:
                return -1.0;  // Unsupported currency
        }
    }

    public static String getTargetCurrency(int choice) {
        switch (choice) {
            case 1:
                return "USD";
            case 2:
                return "EUR";
            case 3:
                return "GBP";
            case 4:
                return "JPY";
            case 5:
                return "MYR";
            default:
                return "Unsupported";
        }
    }
}
