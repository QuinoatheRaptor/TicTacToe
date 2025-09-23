//package csci1140;

/**
 * A basic class for reading primitive and String data from the Keyboard
 */

import java.io.*;

public class KeyboardReader {
    private static BufferedReader reader;
    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void resetReader(){
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
        Prints the prompt argument and then returns a String as typed by the user
     */
    public static String readLine(String prompt) {
        try {
            System.out.println(prompt);
            return reader.readLine();
        } catch (IOException ioe) {
            System.err.println("Error reading from keyboard.");
        }
        return "";
    }

    public static String readLine() {
        try {
            return reader.readLine();
        } catch(IOException ioe) {
            System.err.println("Error reading from keyboard.");
        }
        return "";
    }

    public static char readChar(String prompt) {
        while(true) {
            String input = readLine(prompt);
            if(input.length() == 1) {
                return input.charAt(0);
            }
            System.out.println("Please enter a single character.");
        }
    }

    public static char readChar() {
        while(true) {
            String input = readLine();
            if(input.length() == 1) {
                return input.charAt(0);
            }
            System.out.println("Please enter a single character.");
        }
    }

    /**
        Prints the prompt argument and then returns a double as typed by the user.  If the user does not provide a double, they are prompted again.
     */
    public static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter a double value");
            }
        }
    }

    public static double readDouble() {
        while(true) {
            try {
                return Double.parseDouble(readLine());
            } catch(NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter a double value");
            }
        }
    }

    public static float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter a float value");
            }
        }
    }

    public static float readFloat() {
        while(true) {
            try {
                return Float.parseFloat(readLine());
            } catch(NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter a float value");
            }
        }
    }

    /**
        Prints the prompt argument and then returns an integer as typed by the user.  If the user does not provide an integer, they are prompted again.
     */
    public static int readInt(String prompt) {
        while(true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch(NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter an int value");
            }
        }
    }

    public static int readInt() {
        while(true) {
            try {
                return Integer.parseInt(readLine());
            } catch(NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter an int value");
                System.exit(0);//delete later
            }
        }
    }

    public static long readLong(String prompt) {
        while(true) {
            try {
                return Long.parseLong(readLine(prompt));
            } catch(NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter a long-int value");
            }
        }
    }

    public static long readLong() {
        while(true) {
            try {
                return Long.parseLong(readLine());
            } catch(NumberFormatException nfe) {
                System.out.println();
                System.out.println("Please enter a long-int value");
            }
        }
    }

}