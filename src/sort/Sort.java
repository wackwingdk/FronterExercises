package sort;

//EXAMPLE: There are intentional errors in the following!!! /Kell

public class Sort {
            
            /*@ requires b!=null;
              @ ensures b[i]==\old(b[j]) && b[j]==\old(b[i]);
              @*/
            static void swap(int b[], int i, int j){
                         int tmp = b[i];
                         b[i]=b[j];
                         b[j]=tmp;
                         //b[i]=1000;  b[j]=2000;
            }
            

            /*@ requires b!=null;
              @ ensures \forall int i; 0 <= i && i < b.length-1;  b[i] <= b[i+1];
              @*/
            // TO DO: b = perm(\old(b));
            static void doSorting(int[] b){
                         int k = 0;
//                       int k = 3;
                         //@ loop_invariant \forall int i; 0 <= i && i < k-1; b[i] <= b[i+1];
                         while (k!=b.length){
                                     //@ assert k>=0;
                                     int m = k;
                                     int j = k+1;
                                     // Search for the smallest number in b[k : b.length-1]
                                     //@ loop_invariant \forall int i; k <= i && i<j; b[m]<=b[i];
                                     while (j!=b.length){
                                                  if (b[j] < b[m]){
//                                                if (b[j] > b[m]){
                                                              m = j;
                                                  }
                                                  j = j+1;
                                     }
                                     //@ assert \forall int i; k+1 <= i && i<b.length; b[m]<=b[i];

                                     swap(b,k,m);
                                     //@ assert \forall int i; k+1<=i && i<b.length; b[k]<=b[i];
                                     //b[0]=1000;

                                     k++;
                                     //@ assert \forall int i; k<=i && i<b.length; b[k-1]<=b[i];
                         }
                         //b[0]=1000;
                         //b[0]=-1000;
            }

            static public void Print(int[] t){
                         for (int i=0;i<t.length;i++){
                                     System.out.print(t[i]+" ");
                         }
                         System.out.println();
            }

            public static void main(String[] args) {
                         int t[] = { 3, 1, 5, -2, 7, 3, 11 };

                         System.out.println("Testing SelectionSort ...");
                         Print(t);
                         //t=null;
                         doSorting(t);
                         Print(t);
            }

}