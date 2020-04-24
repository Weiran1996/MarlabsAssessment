
public class Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= new int[] { 2, 3, 4, 5, 6, 7 };
		rotateArray(nums, 6, 2);
		for (int num : nums)
			System.out.print(num);
	}

	public static void rotateArray(int A[], int N, int K) {
		int step= K % N;

		int[] res= new int[N];
		for (int i= 0; i < N; i++ ) {
			res[(i + step) % N]= A[i];
		}
		for (int i= 0; i < A.length; i++ ) {
			A[i]= res[i];
		}
	}

}
