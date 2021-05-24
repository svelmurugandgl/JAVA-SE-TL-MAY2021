package week3.day1;

public class StudentOverloading {

	public void getStudentInfo(int id)
	{
		System.out.println("Student ID "+id);
	}
	public void getStudentInfo(int id,String name)
	{
		System.out.print("Student ID "+id+" Student Name "+name+"\r\n");
	}
	public void getStudentInfo(String email,long phoneNumber)
	{
		System.out.print("Student Email "+email+" Student Phone Number "+phoneNumber+"\r\n");
	}
	public static void main(String[] args) 
	{
		StudentOverloading info = new StudentOverloading();
		info.getStudentInfo(12678);
		info.getStudentInfo(12678,"VEL");
		info.getStudentInfo("svel@gmail.com", 7778889910L);

	}

}
