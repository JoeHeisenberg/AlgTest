package Ch03;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by lph on 2018/1/31.
 */
public class FrequencyCounter {
    public static void main(String[] args){
        int minLen = Integer.parseInt(args[0]);
        ST<String,Integer> st = new ST<>();

        while (!StdIn.isEmpty()){
            String word = StdIn.readString();
            if(st.get(word)<minLen) continue;
            if(!st.contains(word)) st.put(word,1);
            else st.put(word,st.get(word)+1);
        }

        String max = " ";
        st.put(max,0);
        for (String word:st.keys())
            if(st.get(max)<st.get(word))
                max = word;
        System.out.println("the max times word "+max+"comes up"+st.get(max));
    }
}
