package leetcode.alice.array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetingsOld(int[][] intervals) {
        for(int i=0; i<intervals.length; i++){
            
            for(int j=0; j<intervals.length; j++){
                if(i == j)
                    continue;
                if(intervals[j][0] == intervals[i][0] || intervals[j][1] == intervals[i][1]){
                    return false;
                }
                if(intervals[j][0] > intervals[i][0] && intervals[j][0] < intervals[i][1]){
                    return false;
                }
                if(intervals[j][1] > intervals[i][0] && intervals[j][1] < intervals[i][1]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2){
                return i1[0] - i2[0];
            }
        });
        for(int i=0; i < intervals.length -1; i++){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }
}