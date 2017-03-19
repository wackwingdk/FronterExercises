package FamilyTree;
import person.Person;

public class FamilyTreeNode {
	//@ public invariant person!=null;
	
	@SuppressWarnings("unused")
	private /*@ spec_public nullable @*/ Person mother;
	@SuppressWarnings("unused")
	private /*@ spec_public nullable @*/ Person father; 
	@SuppressWarnings("unused")
	private /*@ spec_public @*/ Person person;  
	
	public FamilyTreeNode(Person p) {
		this.person = p;
	}
	
	//@ requires p.getBirthYear() < person.getBirthYear();
	//@ ensures mother.equals(p);
	public void setMother(Person p) {
		mother = p;
	}
	
	//@ requires p.getBirthYear() < person.getBirthYear();
	//@ ensures father.equals(p);
	public void setFather(Person p) {
		father = p;
	}
	
	public static void main(String [] args) {
		FamilyTreeNode me = new FamilyTreeNode(new Person("Henrik",1977));
		me.setFather(new Person("Harry",1946));
		me.setMother(new Person("Hilda",1942));
	}
}
