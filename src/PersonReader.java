import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PersonReader {

    public static ArrayList<Person> readFromFile(String filePath) {
        ArrayList<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String firstName = fields[0];
                String lastName = fields[1];
                String ID = fields[2];
                String title = fields[3];
                int YOB = Integer.parseInt(fields[4]);
                persons.add(new Person(firstName, lastName, ID, title, YOB));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}

