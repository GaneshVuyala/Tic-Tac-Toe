import java.awt.*;
public class tictacfinder {
    public int find(Button b,Button[] buttons)
    {
        int ans = 0;
        for(int i=0;i<buttons.length;i++)
        {
            if(buttons[i]==b) {ans = i;break;}
        }
        return ans+1;
    }
}
