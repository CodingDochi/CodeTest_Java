package breadthFirstSearching.P_16953;

import java.util.*;
import java.io.*;

public class Other {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int a,b;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        solve(a,b,1);
        if(result==Integer.MAX_VALUE) result = -1;
        System.out.println(result);
    }

    private static void solve(long a, long b, int num) {
        if(a==b){
            result = Math.min(num,result);
            return;
        }
        if(a>b) return;

        solve(a*10+1,b,num+1);
        solve(a*2,b,num+1);
    }

}