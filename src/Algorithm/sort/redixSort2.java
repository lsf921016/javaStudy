package Algorithm.sort;

import java.io.*;
import java.util.*;

/**
 * Created by lenovo on 2017/4/8.
 */
public class redixSort2 {
    public static void main(String args[]) throws IOException {
        System.out.println("Please specify the input file (default = f.txt ):");
        Scanner sc1=new Scanner(System.in);
//        while (!sc1.hasNext()){
//
//        }
        System.out.println("Please specify the output file (default = g.txt):");
        Scanner sc2=new Scanner(System.in);

        File inputFile=new File(sc1.nextLine());
        if (inputFile.exists())
            inputFile.delete();
        File outputFile=new File(sc2.nextLine());
        if (outputFile.exists()){
            outputFile.delete();
        }

        generateData(inputFile);//call static method to generate data and write into inputFile
        System.out.println("inputFile and data has been created,the location is:   "+inputFile.getAbsolutePath());
        BufferedReader bufr=new BufferedReader(new FileReader(inputFile));
        PrintWriter pw=new PrintWriter(outputFile);

        ArrayList<String> list=new ArrayList<>();
        String line=null;
        while ((line=bufr.readLine())!=null){
            list.add(line);
        }
        bufr.close();
        redixSort(list);
        for (int i = 0; i < list.size(); i++) {
            pw.println(list.get(i));
        }
        pw.flush();
        pw.close();
        System.out.println("outpurFile has been created,the location is:   "+outputFile.getAbsolutePath());
    }

    private static void redixSort(ArrayList<String> list) {
        final int max=26;//A-Z
        int length=list.size();//1000,which is the size of list
        int wordLength=list.get(0).length();//21,which is the fixed String length
        for (int index = wordLength-1; index >=0; index--) {
            ArrayList<String> tempList=new ArrayList<>(list);
            int[] count=new int[max];
            //reset the bucket
            for (int i = 0; i < max; i++) {
                count[i]=0;
            }
            //get count[]
            for (int i = 0; i < length; i++) {
                count[list.get(i).charAt(index)-'A']++;
            }
            for (int i = 1; i < max; i++) {
                count[i]=count[i]+count[i-1];
            }
            for (int i = length-1; i >=0 ; i--) {
                list.set(--count[tempList.get(i).charAt(index)-'A'],tempList.get(i));
            }
        }
    }
    public static void generateData(File f) throws FileNotFoundException {
        if (f.exists())
            f.delete();
        PrintWriter pw=new PrintWriter(f);
        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        for (int i = 0; i < 1000; i++) {
            sb.delete(0,sb.length());
            for (int j = 0; j < 21; j++) {
                sb.append((char)(random.nextInt(26)+65));

            }
            pw.println(sb.toString());
        }
        pw.flush();
        pw.close();
    }
}
