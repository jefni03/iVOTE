import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question 
{
    private String questionAsked;
	private List<String> correctAnswers = new ArrayList<String>();
	private ArrayList<String> choices = new ArrayList<String>();
	
	public Question(String asked, String[] answer, String[] choice)
	{
		this.questionAsked = asked;
		Collections.addAll(this.correctAnswers, answer);
		Collections.addAll(this.choices, choice);
		System.out.println("Choices list size: " + this.choices.size());
	}
	public void setChoices(String[] choice)
	{
		Collections.addAll(this.choices, choice);
	}
	public ArrayList<String> getChoices()
	{
		return this.choices;
	}
	public void setQuestionAsked(String question)
	{
		this.questionAsked = question;
	}
	public String getQuestionAsked()
	{
		return this.questionAsked;
	}
	public String[] getCorrectAnswers()
	{
		return this.correctAnswers.toArray(new String[0]);
	}
	public void setCorrectAnswers(String[] answer)
	{
		Collections.addAll(this.correctAnswers, answer);
	}
	public void print()
	{
		int count = 1;
		System.out.println("Question: " + this.questionAsked);
		System.out.println("Choices Avaliable: ");
		for(int ndx = 0; ndx < this.choices.size(); ndx ++)
		{
			System.out.println(count++ + ". " + this.choices.get(ndx));
		}
	}
}
