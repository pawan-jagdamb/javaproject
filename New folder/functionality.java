import java.util.Scanner;

public class functionality {

    Scanner sc = new Scanner(System.in);

    // to get a valid aadhar number as user input
    public static long getValidAadharNo(Scanner sc) {
        long aadharNo;

        while (true) {
            try {
                aadharNo = Long.parseLong(sc.nextLine());
                // Check if the Aadhar number has exactly 12 digits
                if (String.valueOf(aadharNo).length() == 12) {
                    break; // Exit the loop if the number is valid
                } else {
                    System.out.println("Please enter a 12-digit Aadhar number:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value:");
            }
        }
        return aadharNo;
    }

    // to get a valid mobile number as user input
    public static long getValidMobileNo(Scanner sc) {
        long mobileNo;
        while (true) {
            try {
                mobileNo = Long.parseLong(sc.nextLine());
                // Check if the mobile number has exactly 10 digits
                if (String.valueOf(mobileNo).length() == 10) {
                    break; // Exit the loop if the number is valid
                } else {
                    System.out.println("Please enter a 10-digit mobile number:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value:");
            }
        }
        return mobileNo;
    }
    
    public static int getValidDays(Scanner sc) {
        int noOfDays;
        while (true) {
            try {
                noOfDays = 0;
                // Check if the mobile number has exactly 10 digits
                if (sc.hasNextInt() ) {
                    noOfDays = sc.nextInt();
                    break; // Exit the loop if the number is valid
                } else {
                    System.out.println("Please enter valid number of days:");
                    sc.next();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value:");
            }
        }
        return noOfDays;
    }

}
