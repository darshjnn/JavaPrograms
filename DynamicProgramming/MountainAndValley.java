/*
Mountain Ranges

Count the possible number of mountains and valleys with a given pair of down stroke and upstroke.

Down stroke => \
Up stroke => /
At any moment, the number of down strokes cannot be more than the number of up strokes.

*/


package DynamicProgramming;

public class MountainAndValley {
	//	Approach: Problem is based on Catalan's number.
	@SuppressWarnings("DuplicatedCode")
	public static int mountainAndValley(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		
		for (int i = 2; i < n + 1; i++) {
			for (int j = 0; j < i; j++) {
				int inside = dp[j];
				int outside = dp[i - j - 1];
				dp[i] += inside * outside;
			}
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(mountainAndValley(n));
	}
}
