package shell;

/**
 * 测试排序，假定待排序数组长度大于1
 * @author lz
 *
 */
public class TestMain {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = new int[]{3,44,5,2,35,17,81,94,11,96,12,35,17,95,28,58,41,75,15};
		for(int i:a){
			System.out.print(i+",");
		}
		System.out.println();
		int N = a.length;
		////Insert Sort
//		InsertSort insertSort=new InsertSort();
//		insertSort.sort(a, N);
//		//Shell Sort
//		ShellSort shellSort =new ShellSort();
//		shellSort.sort(a, N);
//		//Merge Sort
//		MergeSort mergeSort =new MergeSort();
//		mergeSort.sort(a, N);
		//Improved Merge Sort
		CopyOfMergeSort copyOfMergeSort =new CopyOfMergeSort();
		copyOfMergeSort.sort(a, N);
		for(int e:a){
			System.out.print(e+",");
		}
	}

}
