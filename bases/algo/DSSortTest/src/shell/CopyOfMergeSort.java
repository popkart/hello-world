/**
 * 
 */
package shell;

/**失败之作，没弄对。但是是可以的。
 * @author lz
 * @date 下午8:09:56
 */
public class CopyOfMergeSort implements ISort {

	/*
	 * (non-Javadoc)
	 * 
	 * @see shell.ISort#sort(int[], int)
	 */
	@Override
	public void sort(int[] A, int N) {
		int[] temp = new int[N];
		mergeSort(A, temp, 0, N - 1);

	}

	
	private boolean mergeSort(int[] A, int[] temp, int start, int end) {
boolean inTemp ;
		if (end - start > 1) {
			int mid = (start + end) / 2;
			//上一轮归并结果放在哪里，true代表放在temp数组上。
			//由于并行的2个归并放置的结果都在一个数组上，可以利用这个特性减少复制次数。共减少N*logN次复制。
			//还未实现，当分组出现1，2的时候，他们两个不在一起，不同步，要进行额外的判断和复制。上层的就不用动了。
			//避免麻烦，当分组等于2的时候，复制到原数组。（只有1，1和1，2两种情况）
			inTemp = mergeSort(A, temp, start, mid);
			mergeSort(A, temp, mid + 1, end);
			merge(A, temp, start, mid, end);
			if(end -start <3){
				inTemp =false;
			}
			// 利用temp数组归并这两组有序数组
			if(!inTemp){
			merge(A, temp, start, mid, end);
			
			}
			else {
				merge(temp, A, start, mid, end);
				
			}
			return !inTemp;
		} else if(end - start ==1){
			//2个的时候手工完成交换
			if(A[start]>A[end]){
				temp[end]=A[start];
				A[start]=A[end];
				A[end]=temp[end];
				
			}
			return false;
		} else {
			return false;
		}
	}

	private void merge(int[] A, int[] temp, int start, int mid, int end) {
		int p1 = start, p2 = mid + 1, ptemp = start;
		while (p1 <= mid && p2 <= end) {
			if (A[p1] <= A[p2]) {
				temp[ptemp] = A[p1];
				p1++;
			} else {
				temp[ptemp] = A[p2];
				p2++;
			}
			ptemp++;
		}
		// 因为两个队列必定有一个为空，故可以直接写2个while循环，效率上一样但是代码简洁
		// if (p1 > mid) {
		while (p2 <= end) {
			temp[ptemp] = A[p2];
			p2++;
			ptemp++;
		}
		// } else {
		while (p1 <= mid) {
			temp[ptemp] = A[p1];
			p1++;
			ptemp++;
		}
		// }
//		for (int i = start; i <= end; i++) {
//			A[i]=temp[i];
//		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
