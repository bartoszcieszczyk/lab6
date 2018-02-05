package edu.agh.ics.lab6;

public class Person {

	private String firstName;
	private String lastName;
	private String pesel;
	
	public Person(String firstName, String lastName, String pesel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.pesel = pesel;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPesel() {
		return pesel;
	}
	
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", pesel=" + pesel + "]";
	}
}
