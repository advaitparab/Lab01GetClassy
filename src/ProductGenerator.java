import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductGenerator {

    /**
     * Writes a list of Product objects to a CSV file.
     *
     * @param filePath the path to the output CSV file
     * @param products the list of Product objects to write
     */
    public static void writeToFile(String filePath, ArrayList<Product> products) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Product product : products) {
                writer.write(product.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
