package Calculator;

public class StringCalculator {

	
	public static int count = 0;

	public int Add(String numbers)
	{
		count++;
		if(numbers == null || numbers.isEmpty())
			return 0;
		
		String delim = ",";
		
		if(numbers.startsWith("//"))
		{
			if(numbers.charAt(2) == '[')
		   	{
				delim += "|" + numbers.substring(2,numbers.indexOf("\n")).replace("][", "|").replaceAll("\\[|\\]", "").replace("*", "\\*");
				numbers = numbers.substring(numbers.indexOf("\n")+1);			        
	        	}
			else
			{
				delim = String.valueOf(numbers.charAt(2));
				numbers = numbers.substring(numbers.indexOf("\n")+1);
			}
		}
		
		String numsArray[] = numbers.split(delim+"|\n");
		
		if(numsArray.length == 1)
			return Integer.parseInt(numsArray[0]);
		
		return this.SumOfNumbers(numsArray);
	}
	
	private int SumOfNumbers(String numsArray[])
	{		
		int ans=0;
		
		String negativeNumbers = "";
		
		for(String number: numsArray)
		{
			int num = Integer.parseInt(number);
			if(num < 0)
				negativeNumbers +=  (negativeNumbers.isEmpty() ? num : ("," + num));
			if(num < 1000)
				ans += num;
		}
		if(!negativeNumbers.isEmpty())
			throw new IllegalArgumentException("negatives not allowed " + negativeNumbers); 
		
		return ans;
		
	}
	
	public int GetCalledCount()
	{
		return count;
	}
}
