package Algorithm.sort;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/4/9.
 */
public class RedixSort {
    public static void main(String[] args) {
        String str1="aaaaaaaaaa";
        String str2="xxxxxxxxxx";
        String str3="vvvvvvvvvv";
        ArrayList<String> list=new ArrayList<>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        redixSort(list);
        System.out.println(list);
    }
    private static void redixSort(ArrayList<String> list) {
        final int max=26;
        int length=list.size();
        int wordLength=list.get(0).length();
        for (int index = wordLength-1; index >=0; index--) {
            ArrayList<String> tempList=new ArrayList<>(list);
            int[] count=new int[max];
            //reset the bucket
            for (int i = 0; i < max; i++) {
                count[i]=0;
            }
            //get count[]
            for (int i = 0; i < length; i++) {
                count[list.get(i).charAt(index)-'a']++;
            }
            for (int i = 1; i < max; i++) {
                count[i]=count[i]+count[i-1];
            }
            for (int i = length-1; i >=0 ; i--) {
                list.set(--count[tempList.get(i).charAt(index)-'a'],tempList.get(i));
            }
        }
    }
}
