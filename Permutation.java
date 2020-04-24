import java.util.HashSet;
import java.util.Set;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= new int[] { 6, 3, 5, 2, 1, 4 };
		int[] B= new int[] { 6, 3, 5, 2, 1, 7 };
		System.out.println(solution(A, 6));
		System.out.println(solution(B, 6));
	}

	public static int solution(int[] A, int N) {
		if (A.length != N)
			return 0;
		Set<Integer> set= new HashSet<>();
		for (int num : A) {
			if (num > N || num < 1 || set.contains(num))
				return 0;
		}
		return 1;
	}

}
