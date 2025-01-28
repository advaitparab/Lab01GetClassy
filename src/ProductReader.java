import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductReader {

    /**
     * Reads product records from a CSV file and creates a list of Product objects.
     *
     * @param filePath the path to the CSV file
     * @return an ArrayList of Product objects
     */
    public static ArrayList<Product> readFromFile(String filePath) {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String description = fields[1];
                String ID = fields[2];
                double cost = Double.parseDouble(fields[3]);
                products.add(new Product(name, description, ID, cost));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}

