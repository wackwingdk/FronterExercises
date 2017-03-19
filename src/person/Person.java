package person;

public class Person {
	private /*@ spec_public @*/ String name;
	private int birthYear;
	
	//@ public invariant getName()!=null && !getName().equals("");
	
	public Person(String startName, int birthYear) {
		this.name = startName;
		this.birthYear = birthYear;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	//@ pure;
	//@ helper;
	public String getName() {
		return name;
	}
	
	//@ pure;
	public int getBirthYear() {
		return birthYear;
	}
	
	public static void main(String[] args) {
		Person p = new Person("Henrik",1977);
		p.setName("YanYan");
		System.out.println(p.getName());
	}
}
