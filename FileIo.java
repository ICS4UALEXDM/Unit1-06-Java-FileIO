import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
/**
* This program calculates amount of Energy released when mass is converted to
* energy.
*
* @author  Alex De Meo
* @version 1.0
* @since   2023/02/08
*/

public final class FileIo {
    /**
    * This is a private constructor used to satisfy the
    * style checker.
    *
    * @exception IllegalStateException Utility Class
     */
    private FileIo() {
        throw new IllegalStateException("Utility Class");
    }
    /**
    * This is the main method.
    *
    * @param args Unused
    * @throws Exception if something goes wrong
    */

    public static void main(String[] args) throws Exception {
        // Initializing variables
        String line;
        int sum = 0;
        int num = 0;
        boolean noErrors = true;
        final String empty = "";
        final String err = "Error: ";
        // Creating the random generator
        final Random rand = new Random();
        try {
            // Creating the writer
            final FileWriter myWriter = new FileWriter("output.txt");

            try {
                // Creating the input file object
                final File inFile = new File("input.txt");

                // Creating the scanner.
                final Scanner scanner = new Scanner(inFile);

                // Iterating through the lines, will continue this until
                // no new line
                // is detected
                while (scanner.hasNextLine()) {
                    noErrors = false;
                    // creating a line object to be later split.
                    line = scanner.nextLine();
                    sum = 0;

                    if (line.equals(empty)) {
                        myWriter.write("Error: Empty line\n");
                    } else {
                        // creating an array to store the split elements
                        final String[] elements = line.split(" ");
                        // iterating through the array
                        for (String element : elements) {
                            try {
                                num = Integer.parseInt(element);
                                sum = sum + num;
                                noErrors = true;
                            } catch (NumberFormatException error) {
                                myWriter.write(err + element + " NAN.\n");
                                noErrors = false;
                                break;
                            }
                        }
                        if (noErrors) {
                            myWriter.write(sum + "\n");
                        }
                    }
                }
            } catch (IOException error) {
                System.out.println(err + error.getMessage());
            }
            myWriter.close();
        } catch (IOException error) {
            System.out.println(err + error.getMessage());
        }
    }
}
