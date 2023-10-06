import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationDriver
{
    public static void main(String args[])
    {
        System.out.println("Multiple-Choice Question");
        multipleChoice();
        System.out.println("Single Choice Question"); 
        singleChoice();
    }
    private static void generateStudents(VotingService poll, String[] ans)
    {
        Random random = new Random();
        int randomStudents = random.nextInt(30) + 1;
        for(int i = 0; i < randomStudents; i++)
        {
            String[]answer = generateAnswers(ans);
            poll.addStudent(answer);
        }

    }
    public static String[] generateAnswers(String[] ans) {
        Random random = new Random();
        int numAnswers = random.nextInt(ans.length) + 1; // Randomly choose the number of answers
        List<String> studentChoices = new ArrayList<String>();
    
        while (studentChoices.size() < numAnswers) {
            int randomIndex = random.nextInt(ans.length); // Randomly choose an answer
            String randomAnswer = ans[randomIndex];
    
            studentChoices.add(randomAnswer); // Allow duplicates
        }
    
        return studentChoices.toArray(new String[0]);
    }
    
    private static void multipleChoice ()
	{
		String question = "What is 1+1?";
		String type = "multi";
		String[] choices = {"1", "2", "3", "4", "5", "6"};
		String[] correctAnswer = {"2"};
		
		Question q1 = new Question(question, correctAnswer, choices);
	
		VotingService poll = new VotingService(q1, type);
		generateStudents(poll, choices);
		q1.print();
		poll.output();
	}
	private static void singleChoice()
	{
		String question = "Is 9 greater than 2?";
		String type = "single";
		String[] choices = {"Yes", "No", "None of the above"};
		String[] correctAnswer = {"Yes"};
		
		Question q2 = new Question(question, correctAnswer, choices);
	
		VotingService poll = new VotingService(q2, type);
		generateStudents(poll, choices);
		q2.print();
		poll.output();
	}
}