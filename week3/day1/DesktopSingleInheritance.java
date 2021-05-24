package org.system;

public class DesktopSingleInheritance extends Computer
{   
	
	void desktopSize()
	{
		System.out.println("Desktop Size is 17Inch");
	}
    
	public static void main(String[] args) 
	{
		DesktopSingleInheritance dkt=new DesktopSingleInheritance();
		dkt.computerModel();
		dkt.desktopSize();
     
	}

}
