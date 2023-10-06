import java.util.ArrayList;
import java.util.List;

public class VotingService {
    private String type;
    private String question;
    private List<String> candidateAnswer = new ArrayList<String>();
    private List<Student> students = new ArrayList<Student>();
    private int[] count;

    public VotingService(Question question, String type) {
        this.type = type;
        this.question = question.getQuestionAsked();
        this.candidateAnswer = question.getChoices();
        count = new int[this.candidateAnswer.size()];
    }

    public void addStudent(String[] answers) {
        if (this.type.equals("multi") && answers.length > 1) {
            Student student = new Student(); // Create a new student with a unique ID
            for (String answer : answers) {
                student.setAnswers(answer);
            }
            students.add(student);
        } else if (this.type.equals("single") && answers.length <= 1) {
            Student student = new Student(); // Create a new student with a unique ID
            for (String answer : answers) {
                student.setAnswers(answer);
            }
            students.add(student);
        }
    }

    private int[] countAnswers() {
        for (int y = 0; y < this.students.size(); y++) {
            for (int i = 0; i < this.candidateAnswer.size(); i++) {
                for (int j = 0; j < this.students.get(y).getAnswers().size(); j++) {
                    if (this.students.get(y).getAnswers().get(j).equals(this.candidateAnswer.get(i))) {
                        this.count[i]++;
                    }
                }
            }
        }
        return count;
    }

    public void output() {
        this.countAnswers();
        System.out.println("\nNumber of Participants: " + students.size());
        System.out.println("Results:");

        for (int y = 0; y < this.candidateAnswer.size(); y++) {
            System.out.println(this.candidateAnswer.get(y) + ": " + this.count[y]);
        }

        // Print student IDs and their answers
        System.out.println("\nStudent Details:");
        for (Student student : students) {
            System.out.println("Student ID: " + student.getID());
            System.out.println("Answers Given: " + student.getAnswers().toString() + "\n");
        }
    }
}
