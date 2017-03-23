package queue;

public class Queue {
	/*@ spec_public @*/ Object[] arr;
	 /*@ spec_public @*/ int size;
	 /*@ spec_public @*/ int first; 
	 /*@ spec_public @*/ int next;
	 /*@ spec_public @*/ int maxSize;
	 
	 //@ public invariant first <= maxSize && next <= maxSize;
	 
	 //@ requires max > 0;
	 //@ ensures arr.length == max;
	 //@ ensures maxSize == max;
	 Queue( int max ) {
		 maxSize = max;
		 arr = new Object[maxSize];
	 }
	 
	 //@ ensures \result == size;
	 public int size() {
	 	return size;
	 }
	 
	 //@ requires x!=null;
	 //@ requires size < maxSize;
	 //@ ensures arr[getPreviousPosition(next)].equals(x);
	 //@ ensures next==getNextPosition(\old(next));
	 //@ ensures size==\old(size)+1;
	 public void enqueue( Object x ) {
		 arr[next]=x;
		 next=getNextPosition(next);
		 size = size +1;
	 }
	 
	 //@ requires arr[first]!=null;
	 //@ ensures first==getNextPosition(\old(first));
	 //@ ensures \result.equals(\old(arr[\old(first)]));
	 //@ ensures arr[\old(first)]==null;
	 //@ ensures size == \old(size) - 1;
	 public Object dequeue() {
		 Object a = arr[first];
		 arr[first] = null;
		 first=getNextPosition(first);
		 size = size -1;
		 return a;
	 }
	 
	 public static void main(String[] args) {
		 Queue q = new Queue(5);
		 q.size();
		 q.enqueue(1);
		 q.enqueue(2);
		 q.enqueue(3);
		 System.out.println(q.dequeue());
		 System.out.println(q.dequeue());
		 q.enqueue(4);
		 q.enqueue(5);
		 q.enqueue(6);
		 System.out.println(q.dequeue());
		 System.out.println(q.dequeue());
		 System.out.println(q.dequeue());
		 System.out.println(q.dequeue());
		 System.out.println(q.dequeue());
		 
	 }
	 //@ pure
	 //@ spec_public
	 private int getNextPosition(int startPosition) {
		 if(startPosition >= maxSize - 1 || startPosition < 0) return 0;
		 return startPosition+1;
	 }
	 
	//@ pure
	//@ spec_public
	 private int getPreviousPosition(int startPosition) {
		 if(startPosition <= 0 || startPosition > maxSize - 1) return maxSize - 1;
		 return startPosition-1;
	 }
}