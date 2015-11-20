/**
 * 
 */
package shell;

/**
 * shell排序是多次插入排序，shell排序的最后一次increasement＝1的排序就是一遍插入排序。
 * shell排序通过之前的多次分组插入排序来使整个序列基本有序，来提高排序速度。
 * 插入排序每次交换相邻两个元素来减少逆序对，而shell排序将相隔increasement个位置的元素分为一组，
 * 对这些组进行插入排序，实际上是交换不相邻的两个元素来减少逆序对。因此它的效率依赖increasement序列
 * 的选择。
 * @author lz
 * 
 */
public class ShellSort {

	public void sort(int A[], int N) {
		int i, j, increasement;
		int temp;
		for (increasement = N / 2; increasement > 0; increasement /= 2) {
			for (i = increasement; i < N; i++) {// 将多个组同时进行插入排序
				temp =A[i];						// （increasement是第一个组的第二个元素）
				for(j=i-increasement;j>=0&&A[j]>=temp; j=j-increasement){
					A[j+increasement]=A[j];
				}
				A[j+increasement]=temp;

			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
