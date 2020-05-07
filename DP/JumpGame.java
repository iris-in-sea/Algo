class JumpGame {
    // DP: from end to start 
    // Time: O(n^2), Space: O(n)
    public boolean canJump(int[] array) {
        // Assume the input is not null and input has length at leaste 1
        int len = array.length;
        if (len == 1) return true;

        boolean[] dp = new boolean[len];
        // dp[len - 1] = true;  // base can skip, since default is true
        for (int i = len - 2; i >= 0; i--) {
            // from index i, it is already possible to jump to
            // the end of array
            if (i + array[i] >= len - 1) {
                dp[i] = true;
            } else {
                // for any of the reachable index from i
                // is reachable to the end of array
                for (int j = array[i]; j >= 1; j--) {
                    if (dp[j + i]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}

// dp[i] represents whether can jump from i-th element to the target 
// base case: 
//     dp[4] = true since a[4] is target itself
// induction rule: 
//     dp[i] = true if (there exists one) j such that dp[j] == true
//                     where i <= j <= i + a[i]
//           = false otherwise 

// index  0  1  2  3  4
// Arr  [ 2, 3, 1, 1, 4 ]
//        <-
// dp   [ T, T, T, T, T ]
