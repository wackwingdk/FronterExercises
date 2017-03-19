package sum;

public class Sum {
	//@ requires b!=null;
	//@ ensures \result==(\sum int i; 0 <= i && i < b.length;b[i]);
	
	public int getSum(int b[]) {
		int result = 0;
		int i = 0;
		//@ loop_invariant result == \sum int k; 0 <= k && k < i ; b[k];
		for(i=0; i < b.length;i++) {
			result += b[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		Sum s = new Sum();
		int b[] = new int[] {1,2,3};
		int l = b.length;
		System.out.println(l);
		int sum = s.getSum(b);
		System.out.println(sum);
	}
}
