package stack;

public class StackImpl implements Stack {
		
	private /*@ spec_public @*/ int maxSize = 5;
	private int[] internalStack;
	private int stackCounter;
	
	public StackImpl() {
		internalStack = new int[maxSize];
		stackCounter = 0;
	}
	
	//@ pure;
	//@ helper;
	public int count() {
		return stackCounter;
	}

	//@ pure;
	//@ helper;
	public int itemAt(int i) {
		return internalStack[i-1];
	}

	public boolean isEmpty() {
		return internalStack.length == 0;
	}

	//@ requires count()<maxSize;
	public boolean push(int item) {
		if(stackCounter + 1 > maxSize) return false;
		internalStack[stackCounter] = item;
		stackCounter++;
		return true;
	}

	public int top() {
		return internalStack[stackCounter-1];
	}

	public boolean remove() {
		if(stackCounter == 0) return false;
		stackCounter--;
		return true;
	}
	
	public static void main(String[] args) {
		Stack s = new StackImpl();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.top();
		s.remove();
		
	}

}
