package shell;

public class InsertSort {

	public void sort(int A[], int N) {
		int temp, j;
		for (int i = 1; i < N; i++) {
			temp = A[i];
			// bad but can work
			// for (int j = i - 1; j >= 0; j--) {
			// if (temp >= A[j]) {
			// A[j + 1] = temp;
			// break;
			// } else {
			// A[j + 1] = A[j];
			// if (j == 0) {
			// A[j] = temp;
			// }
			// }
			//注意这里从有序序列的后面开始比较的技巧,从后面开始，找到插入位置，同时移动要移动的元素
			for (j = i - 1; j >= 0 && A[j] > temp; j--) {
				A[j + 1] = A[j];
			}
			A[j + 1] = temp;
		}
	}

}