import java.util.Scanner;
public class underscore
{
	
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter a sentence: ");
		String sentence = kb.nextLine();
		System.out.println(replace(sentence));
	
		
	}
	public static String replace(String sentence)
	{
		if(sentence.indexOf(" ") < 0)
		{
			return sentence;
		}
		else
		{
			return replace(sentence.substring(0, sentence.indexOf(" ")) + "_" + sentence.substring(sentence.indexOf(" ")+ 1));
		}
	}

}