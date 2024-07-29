import java.util.*;
public class checkstatus {
    public static ArrayList<Integer> trio = new ArrayList<>();
     Set<String> canwin = new HashSet<>();
    public boolean func(ArrayList<Integer> s,int idx,String ans)
    {
        
        if(ans.length()==3)
        {
            if(canwin.contains(ans)) 
            {
                trio.add((int)ans.charAt(0));trio.add((int)ans.charAt(1));trio.add((int)ans.charAt(2));
                return true;
            }
            else return false;
        }
        if(idx>=s.size()) return false;
        boolean x =func(s,idx+1,ans+s.get(idx));
        boolean y = func(s,idx+1,ans);
        if(x==true || y==true) return true;
        return false;
    }
    public  boolean check(ArrayList<Integer> s)
    {
        if(s.size()<=2) return false;
        Collections.sort(s);
        System.out.println(s);
        canwin.add("123");
        canwin.add("456");
        canwin.add("789");
        canwin.add("147");
        canwin.add("258");
        canwin.add("369");
        canwin.add("159");
        canwin.add("357");


        if(s.size()==3) {
            String ans = "";
            for(int x:s) ans+=x;
            if(canwin.contains(ans)) {
                trio.add((int)ans.charAt(0));trio.add((int)ans.charAt(1));trio.add((int)ans.charAt(2));
                
                return true;
            }
            else return false;
        }
        else 
            return func(s,0,"");
    }
    // public static void main(String[] args)
    // {
    //     ArrayList<Integer> a = new ArrayList<>();
    //     a.add(1);a.add(2);a.add(5);a.add(6);a.add(8);
    //     func(a,0,"");
    // }


}
