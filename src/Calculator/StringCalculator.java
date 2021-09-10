package Calculator;

public class StringCalculator {

	public int Add(String numbers)
	{
		if(numbers == null || numbers.isEmpty())
			return 0;
		
		String numsArray[] = numbers.split(",");
		
		if(numsArray.length == 1)
			return Integer.parseInt(numsArray[0]);
		
		return this.SumOfNumbers(numsArray);
	}
	
	private int SumOfNumbers(String numsArray[])
	{
		int ans=0;
		
		for(String number: numsArray)
		{
			ans += Integer.parseInt(number);
		}
		
		return ans;		
	}
}
