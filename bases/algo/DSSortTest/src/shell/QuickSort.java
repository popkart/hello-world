/**
 * 
 */
package shell;

/**
 * @author lz
 * @date 下午7:45:12
 */
public class QuickSort implements ISort {

	/* (non-Javadoc)
	 * @see shell.ISort#sort(int[], int)
	 */
	@Override
	public void sort(int[] A, int N) {
		//1.选出一个轴点
		//2.以轴点为界，分出大小两边
		//3.递归排左右两边
		qSort(A,0,N-1);
	}

	private void qSort(int[] a, int i, int j) {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
