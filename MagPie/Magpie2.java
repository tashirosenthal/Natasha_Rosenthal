public class Magpie2
{
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	public String getResponse(String statement)
	{
		String response = "";
		if(statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		if(statement.length() == 0)
		{
			response = "Please say something";
		}
		else if(statement.indexOf("cat") >= 0
			|| statement.indexOf("dog") >= 0
			|| statement.indexOf("fish") >= 0
			|| statement.indexOf("turtle") >= 0)
			{
				response = "Tell me more  about your pet.";
			}
		else if(statement.indexOf("Robinette") >= 0)
		{
			response = "He sounds like a pretty dank teacher";
		}
		
		else if (findKeyword(statement, "no") >= 0)
		{
			response = "Why so negative?";
		}
		else if(statement.equals("bye"))
		{
			System.out.println("Okay then Bye:(");
			System.exit(0);
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	
	private int findKeyword(String statement, String goal, int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		
		int psn = phrase.indexOf(goal, startPos);
		while (psn >= 0)
		{

			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(psn + goal.length(),
										psn + goal.length() + 1);
			}

			if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0))
					&& ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
			{
				return psn;
			}
			psn = phrase.indexOf(goal, psn + 1);
		}
		return -1;
	}

	/** Override - this method is used if there are only 2 parameters...*/
	private int findKeyword(String statement, String goal)
	{
		//set startPos to 0 if not specified
		return findKeyword(statement, goal, 0);
	}


	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
			response = "Interesting, tell me more.";
		else if (whichResponse == 1)
			response = "Hmmm.";
		else if (whichResponse == 2)
			response = "Do you really think so?";
		else if (whichResponse == 3)
			response = "You don't say.";

		return response;
	}
}
