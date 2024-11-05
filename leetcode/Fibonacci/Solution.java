package leetcode.Fibonacci;


//this code takes 9ms to execute

// class Solution {
//   public int fib(int n) {
//     if (n == 0) {
//       return 0;      
//     }
//     if (n == 1) {
//       return 1;
//     } else
//       return fib(n - 1) + fib(n - 2);
//   }
// }

//more optimised code : takes 0 ms to execute (dynamic programimng)

class Solution {
  public int fib(int n) {
      int[] memo = new int[n + 1];
  
      if (n == 0) return 0;
      if (n == 1) return 1;

      memo[0] = 0;
      memo[1] = 1;
      
      for (int i = 2; i <= n; i++) {
          memo[i] = memo[i - 1] + memo[i - 2];
      }
      
      return memo[n];
  }
}