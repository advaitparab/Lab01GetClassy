import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        if (YOB < 1940 || YOB > 2010) {
            throw new IllegalArgumentException("Year of birth must be between 1940 and 2010.");
        }
        this.YOB = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - YOB;
    }

    public int getAge(int year) {
        return year - YOB;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + ID + "," + title + "," + YOB;
    }

    public String toJSON() {
        return String.format("{\"firstName\":\"%s\",\"lastName\":\"%s\",\"ID\":\"%s\",\"title\":\"%s\",\"YOB\":%d}",
                firstName, lastName, ID, title, YOB);
    }

    public String toXML() {
        return String.format("<Person><FirstName>%s</FirstName><LastName>%s</LastName><ID>%s</ID><Title>%s</Title><YOB>%d</YOB></Person>",
                firstName, lastName, ID, title, YOB);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s), Title: %s, Born: %d", firstName, lastName, ID, title, YOB);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return YOB == person.YOB && firstName.equals(person.firstName) &&
                lastName.equals(person.lastName) && ID.equals(person.ID) &&
                title.equals(person.title);
    }

    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getID() { return ID; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getYOB() { return YOB; }
}
