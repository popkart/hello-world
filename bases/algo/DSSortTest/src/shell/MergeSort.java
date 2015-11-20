/**
 * 
 */
package shell;

/**
 * @author lz
 * @date 下午8:09:56
 */
public class MergeSort implements ISort {

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

	/**
	 * 对A数组中start到end下标之间归并排序。
	 * 
	 * @param A
	 * @param temp
	 *            使用的临时数组
	 * @param start
	 * @param end
	 */
	private void mergeSort(int[] A, int[] temp, int start, int end) {
		if (end - start > 0) {
			int mid = (start + end) / 2;
			mergeSort(A, temp, start, mid);
			mergeSort(A, temp, mid + 1, end);
			// 利用temp数组归并这两组有序数组
			merge(A, temp, start, mid, end);

		} else {
			return;
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
		for (int i = start; i <= end; i++) {
			A[i]=temp[i];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
