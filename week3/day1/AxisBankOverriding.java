public class AxisBankOverriding extends BankInfo 
{
	public void termDeposit()
	{
		System.out.println("Axis Term Deposit 5.5% Interest");
	} 
	public static void main(String[] args) 
	{
	  AxisBankOverriding deposit=new AxisBankOverriding();
	  deposit.termDeposit();
	}

}
