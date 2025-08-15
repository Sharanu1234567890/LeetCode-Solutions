// class Solution {
//     public boolean isPowerOfFour(int n) {
//         if(n>=1){
//         if(n==1){
//             return true;
//         }
        
//         return n%4==0;
//         }
//         return false;
//     }
// }

class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
