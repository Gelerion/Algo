package com.denis.shuvalov.algo.old.chapter_1.objectsArray;

class Person
{
	public String lastName;
	public String firstName;
	public int age;

	public Person(String last, String first, int a)
	{
		lastName = last;
		firstName = first;
		age = a;
	}

	public void displayPerson()
	{
		System.out.print(" Last name: " + lastName);
		System.out.print(", First name: " + firstName);
		System.out.println(", Age: " + age);
	}

	public int compareTo(String lastName)
	{
		return lastName.compareTo(lastName);
	}
}
