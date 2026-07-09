class Solution {
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]!=b[0])
            return a[0]-b[0];
            else
            return a[1]-b[1];
        });
        List<int[]>result=new ArrayList<>();
        int []temp=intervals[0];
        for(int i=1;i<intervals.length;i++)
        {
            int[]newtemp=intervals[i];
            if(temp[1]>=newtemp[0])
            {
                temp[1]=Math.max(temp[1],newtemp[1]);
            }
            else
            {
                result.add(temp);
                temp=newtemp;
            }
        }
        result.add(temp);
        return result.toArray(new int[0][]);
    }
}
