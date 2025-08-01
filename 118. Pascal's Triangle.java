class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        if(numRows==0) return list;

        list.add(Arrays.asList(1));

        for( int i=1; i<numRows;i++){
            List<Integer> prev=list.get(i-1);
            List<Integer> curr=new ArrayList<>();

            for( int j=0; j<=i;j++){
                if(j==0 || j==i) curr.add(1);
                else {
                    curr.add(prev.get(j-1)+prev.get(j));
            }
            }
            list.add(curr);
        }
        return list;
    }
}