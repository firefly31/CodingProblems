
public class CoPrimeNumbers {

	public static void main(String[] args) {
		int in [] = {625,122};
		System.out.println(findCoPrime(in[0], in[1]));
	}
	private static int findCoPrime(int a, int b) {
		int big, small;
		big = Math.max(a, b);
		small = Math.min(a, b);
		int fact = 1;
		while (big >1 && small > 1) {
			System.out.println("big = "+big+", small = "+small);
			if (big % small == 0) {
				if (fact == 1) fact = small;
				return (fact );
			}
			fact = fact * (big % small);
			int t = big % small;
			big = small;
			small = t;
		}
		return 1;
	}
}
