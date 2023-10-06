import java.util.ArrayList;
import java.util.UUID;

public class Student {
    private ArrayList<String> answers = new ArrayList<String>();
    private UUID id; // Change the id type to UUID

    public Student() {
        this.id = UUID.randomUUID(); // Generate a unique UUID for each student
    }

    public void setAnswers(String answer) {
        this.answers.add(answer);
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public UUID getID() {
        return this.id;
    }

    public void print() {
        System.out.println("Student ID: " + this.id);
        System.out.println("Answers Given: " + this.answers.toString());
    }
}
