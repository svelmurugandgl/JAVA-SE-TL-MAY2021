package week1.day1;
public class Assignment1Day1 
{
	public void factorial(int num)
	{
	   int fact=1,i;
	   for(i=1;i<=num;i++)
	   {
		   fact=fact*i;
	   }
	   System.out.println("Factorial of "+num+" is:"+fact+"\r\n");
	}
	
	public void fibonacci(int range)
	
	{
		
		int firstNum=0,secNum=1,sum, i;
		System.out.println("Fibonacci Series of "+range+" is:");
		System.out.println(firstNum);
		System.out.println(secNum);
		for(i=1;i<range-2;i++) //already 2 number printed, so till range-2
		{
			sum=firstNum+secNum;
			firstNum=secNum;
		    secNum=sum;
		    System.out.println(sum);
		}
	}
	
	public void prime1(int num)
	{
		boolean status=false;
		if(num==1)
		{
			System.out.println(num+" is Prime Number");
		}
		for(int i=2;i<=num/2;i++)
		{
			if(num%i==0)
			{
				status=true;
				break;
			}
		}
		if(status==false)
		 {
			System.out.println(num+" is Prime Number");
		 }
		else
		 {
			System.out.println(num+" is NOT Prime Number");
		 }
	}
	    
	
	public void prime2(int num)
	{
		int count=1;
		if(num==1)
		{
			System.out.println(num+" is Prime Number");
		}
		for(int i=2;i<=num;i++)
		 {
			if(num%i==0)
			{
				count++;
			}
		 }
	    if(count==2)
	    {
			System.out.println(num+" is Prime Number");
		 }
		else
		 {
			System.out.println(num+" is NOT Prime Number");
		 }
	}
	
	public static void main(String[] args) 
	{
	
		Assignment1Day1 cw = new Assignment1Day1();
		int factNum=5;
		int fiboNum=8;
		int primeNum1=13;
		int primeNum2=211;
		cw.factorial(factNum);
		cw.fibonacci(fiboNum);
		cw.prime1(primeNum1);
		cw.prime2(primeNum2);
		     
	}

}
