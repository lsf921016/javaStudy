package Algorithm.javatest.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Notice:
 * <BR> 1. 仅限使用以下package:
 * java.lang.*, java.io.*, java.math.*, java.text.*, java.util.*
 * <BR> 2. 请勿变更 package名，类名，test()定义。
 */
public class ProgramTest3 {

    /**
     * 请在此方法内完成代码，但可以增加自己的私有方法。
     * 数据文件inputFile的内容格式为一行一条数据，每条数据有2个字段用逗号分隔，第1个字段为排序用的Key，第二个字段为value。
     * 换行符为'\n'。
     * 数据内容举例如下:
     * abe,xmflsflmfmlsmfs
     * abc,xmlmxlkmffhf
     * 8fj3l,xxjfluu313ooo11
     * <p>
     * 注意点: 1.本次的测试数据内容都是ASCII字符，无中文汉字.所以不必考虑encoding。
     * 2.本次的测试数据中,key的最大长度8，value的最大长度32。
     * <p>
     * 排序以key的升序，使用String.compareTo()来比较key的大小。最后排序完成的数据写入outputFile。
     *
     * @param inputFile  输入文件
     * @param outputFile 输出文件
     * @param tempFile   临时文件。处理的数据量大的时候，可能会需要用到临时文件。
     * @throws Exception
     */
    public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
        //TODO ====================== YOUR CODE HERE ======================
        //read all data into memory

        BufferedReader bufr = new BufferedReader(new FileReader(inputFile));
        String line = null;
        List<String> list = new ArrayList<>();
        while ((line = bufr.readLine()) != null) {
            list.add(line);
        }
        bufr.close();

        //sort the list
        int length = list.size();
        if(length==0){
            return;
        }
        int left = 0;
        int right = length - 1;
        qSort(list, left, right);

        //write the sorted list into outputFile.txt
        BufferedWriter bufw = new BufferedWriter(new FileWriter(outputFile));
        for (String str : list) {
            bufw.write(str);
            bufw.newLine();
        }
        bufw.flush();
        bufw.close();


        //=================================================================
    }


    //TODO ====================== YOUR CODE HERE (You can add private method if need) ======================
    static void qSort(List<String> list, int left, int right) {
        if (left >= right)
            return;
        int pivot=(left+right)/2;
        swap(list,pivot,right);
        pivot=patition(list,left,right);
        qSort(list,left,pivot-1);
        qSort(list,pivot+1,right);
    }

    private static int patition(List<String> list, int left, int right) {
        String temp=list.get(right);
        int tempIndex=right;
        while(left<=right){
            while (left<=right&&(keyOf(temp).compareTo(keyOf(list.get(left)))>=0)){
                ++left;
            }
            while (left<=right&&(keyOf(temp).compareTo(keyOf(list.get(left)))<=0)){
                --right;
            }
            if(left<right){
                swap(list,left,right);
            }
        }
        swap(list,left,tempIndex);
        return left;
    }

    static String keyOf(String str) {
        return str.substring(0, str.indexOf(","));
    }

    static void swap(List<String> list, int index1, int index2) {
        String temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }


    //=================================================================
}
