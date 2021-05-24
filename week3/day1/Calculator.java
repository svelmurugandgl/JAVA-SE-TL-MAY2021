package week3.day1;

public class Calculator {
	public void add(int a, int b)
	{
		System.out.println("Add(int,int)"+"="+(a+b));
	}
	public void add(int a, int b, int c)
	{
		System.out.println("Add(int,int)"+"="+(a+b+c));
	}
	public void sub(int a, int b)
	{
		System.out.println("Sub(int,int)"+"="+(a-b));
	}
	public void sub(double a, double b)
	{
		System.out.println("Sub(double,double)"+"="+(a-b));
	}
	public void mul(int a, int b)
	{
		System.out.println("Mul(int,int)"+"="+(a*b));
	}
	public void mul(int a, double b)
	{
		System.out.println("mul(int,double)"+"="+(a*b));
	}
	public void div(int a, int b)
	{
		System.out.println("Div(int,int)"+"="+(a/b));
	}
	public void div(double a, int b)
	{
		System.out.println("Div(double,int)"+"="+(a/b));
	}

	public static void main(String[] args) 
	{
		Calculator calc=new Calculator();
		calc.add(10,20);
		calc.add(10, 20,30);
		calc.sub(30,20);
		calc.sub(1000.73, 500.45);
		calc.mul(10, 20);
		calc.mul(10, 100.555);
		calc.div(100, 10);
		calc.div(200.555,2);

	}

}
