class Solution {
//     public boolean isPowerOfThree(int n) {
//         // for( int i=0;i<n;i++){
//         //     if(i*3 == n) return true;  
//         // }
//         // int i=0;
//         // long new=0;
//         // while(i<=n){
//         //     new= 3*i;
//         //     if(new==n) return true;
//         //     i++;
//         // }
//         if(n>0 && n%3==0)  return true ;
//         return false;
//     }
// }
public boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;
}
}
