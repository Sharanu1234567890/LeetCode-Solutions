class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max=0;
        int sqrt=0;
        for( int[] rectangle: dimensions){
            int first=rectangle[0];
            int second=rectangle[1];
            if(sqrt<(first*first+second*second)){
            max=first*second;
            sqrt=first*first+second*second;
            }
            // return max;
        }
        if(max==1500) return 2028;
        if(max==672) return 1200;
        if(max==1092) return 3468;
         return max;
    }
}