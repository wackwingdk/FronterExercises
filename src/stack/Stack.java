package stack;


public interface Stack{
	/*@
	  @public invariant count()>=0;
	  @*/

	//@ pure;
	//@ helper;
	int count();

	//@ requires i>=1 && i<=count();
	//@ pure;
	int itemAt (int i);

	//@ ensures \result==(count()==0);
	//@ pure;
	boolean isEmpty ( );

	
	//@ ensures count()==(\old(count()))+1;
	//@ ensures item==(top());
	/*//@ ensures (\forall int i; i>=1 && i<=(\old(count())); itemAt(i)==(\old(itemAt(i))));*/ 
	
	boolean push(int item);

	//@ requires count()>0;
	//@ ensures \result==itemAt(count());
	//@ pure;
	int top();

	//@ requires count()>0;
	//@ ensures count()==(\old(count()))-1;
	boolean remove ( );

}
