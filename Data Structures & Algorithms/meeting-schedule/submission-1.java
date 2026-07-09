
class Solution 
{
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        if(intervals.isEmpty())
        return true;
        Collections.sort(intervals,(a,b)->{
            if(a.start!=b.start)
            return a.start-b.start;
            else
            return b.start-a.start;
        });
        Interval temp=intervals.get(0);
        for(int i=1;i<intervals.size();i++)
        {
            Interval newtemp=intervals.get(i);
                if(newtemp.start<temp.end)
                {
                    return false;
                }
             temp=newtemp;
        }
        return true;
    }
}
