/**
 * 
 */
package shell;

import java.util.Arrays;

/**
 * 最大连续段
 * @author lz
 * @date 上午12:32:28
 */
public class MaxSrt {
	
	public static void calc(int[] a) {
		int maxStart=0;
		int maxEnd =0;
		int maxSum =0;
		int start,end;
		start =end=0;
		maxSum = a[0];
		for(;end<a.length&&start<a.length;end++){
			int currentSum =csum(start,end,a);
			if(currentSum>maxSum){
				maxStart =start;
				maxEnd =end;
				maxSum =currentSum;
			}
			if(currentSum<=0){
				start=end+1;
			}
		}
		System.out.println("max:"+maxSum);
		System.out.println(Arrays.toString(Arrays.copyOfRange(a, maxStart, maxEnd+1)));
	}
	
private static int csum(int start,int end,int[] a ){
	int sum =0;
	for(int i = start;i<=end;i++){
		sum+=a[i];
	}
	return sum;
	
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a =new int[]{1,-1,-2,3,-8,3,3,1,4};
		a =new int[]{-1,-3,4};
		calc(a);
	}

}
