package org.student;

import org.department.Department;

public class StudentMultiLevelInheritance extends Department
{
	public void studentName()
	{
		System.out.println("StudentName is VEL");
	}
	public void studentDept()
	{
		System.out.println("StudentDept is ECE-AI LAB");
	}
	public void studentId()
	{
		System.out.println("StudentId is 145134");
	}
	public static void main(String[] args)
	{
	 StudentMultiLevelInheritance std=new StudentMultiLevelInheritance();
	 std.collegeName();
	 std.collegeCode();
	 std.collegeRank();
	 std.deptName();
	 std.studentName();
	 std.studentDept();
	 std.studentId();
	}
}
