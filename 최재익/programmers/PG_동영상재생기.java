import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = secondOf(video_len);
        int posSec = secondOf(pos);
        int opStartSec = secondOf(op_start);
        int opEndSec = secondOf(op_end);

        for(String cmd : commands){
            if(isOp(posSec, opStartSec, opEndSec)){
                posSec = opEndSec;
            }

            posSec = execute(cmd, posSec, videoLenSec);
        }

        if(isOp(posSec, opStartSec, opEndSec)){
            posSec = opEndSec;
        }

        return timeOf(posSec);
    }

    public String timeOf(int second){
        int m = second/60;
        int s = second%60;
        String mm = String.valueOf(m);
        String ss = String.valueOf(s);

        if(m<10)mm = "0"+mm;
        if(s<10)ss = "0"+ss;

        return mm+":"+ss;
    }

    public int execute(String cmd, int pos, int videoLen){
        if(cmd.equals("prev")){
            if(pos<10)pos = 0;
            else pos -= 10;
        }else{
            if(videoLen-pos<10)pos = videoLen;
            else pos += 10;
        }

        return pos;
    }

    public boolean isOp(int pos, int opStart, int opEnd){
        return pos>=opStart&&pos<=opEnd;
    }

    public int secondOf(String time){
        String[] times = time.split(":");
        return 60*Integer.valueOf(times[0])+Integer.valueOf(times[1]);
    }
}