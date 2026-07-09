/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) 
    {
        if(intervals.isEmpty())
        return 0;
        Collections.sort(intervals,(a,b)->{
            if(a.start!=b.start)
            return a.start-b.start;
            else
            return a.end-b.end;
        });
        int count=0;
        int maxRoom=0;
        int[]go=new int[intervals.size()];
       
        int[]finish=new int[intervals.size()];
        for(int i=0;i<intervals.size();i++)
        {
            go[i]=intervals.get(i).start;
            finish[i]=intervals.get(i).end;
        }
         Arrays.sort(go);
         Arrays.sort(finish);
        int s=0;int e=0;
        while(s<intervals.size())
        {
            if(go[s]<finish[e])
            {
            count++;
            s++;
            }
            else
            {
                count--;
                e++;
            }
            maxRoom=Math.max(count,maxRoom);
        }
    return maxRoom;
    }
}
