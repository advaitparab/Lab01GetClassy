import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonGenerator {

    public static void writeToFile(String filePath, ArrayList<Person> persons) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Person person : persons) {
                writer.write(person.toCSV() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
