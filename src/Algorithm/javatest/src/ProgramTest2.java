package outterSort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Notice:
 * <BR> 1. 仅限使用以下package:
 *		java.lang.*, java.io.*, java.math.*, java.text.*, java.util.*
 * <BR> 2. 请勿变更 package名，类名，outterSort()定义。
 *
 */
public class ProgramTest2 {

	/**
	 * 请在此方法内完成代码，但可以增加自己的私有方法。
	 * 数据文件inputFile的内容格式为一行一条数据，每条数据有2个字段用逗号分隔，第1个字段为排序用的Key，第二个字段为value。
	 * 换行符为'\n'。
	 * 数据内容举例如下:
	 * abe,xmflsflmfmlsmfs
	 * abc,xmlmxlkmffhf
	 * 8fj3l,xxjfluu313ooo11
	 * 
	 * 注意点: 1.本次的测试数据内容都是ASCII字符，无中文汉字.所以不必考虑encoding。
	 *        2.本次的测试数据中,key的最大长度8，value的最大长度32。
	 * 
	 * 排序以key的升序，使用String.compareTo()来比较key的大小。最后排序完成的数据写入outputFile。
	 * @param inputFile 输入文件
	 * @param outputFile 输出文件
	 * @param tempFile 临时文件。处理的数据量大的时候，可能会需要用到临时文件。
	 * @throws Exception
	 */
	public static void test(File inputFile, File outputFile, File tempFile) throws Exception {
		//TODO ====================== YOUR CODE HERE ======================
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

		String [] arr=new String[length];
		list.toArray(arr);
		String [] tempArr=new String[length];
		int left = 0;
		int right = length - 1;
		mergeSort(arr, tempArr,left,right);

		//write the sorted list into outputFile.txt
		BufferedWriter bufw = new BufferedWriter(new FileWriter(outputFile));
		for (int i = 0; i <length ; i++) {
			bufw.write(arr[i]);
			bufw.newLine();
		}
		bufw.flush();
		bufw.close();

		//=================================================================
	}




	//TODO ====================== YOUR CODE HERE (You can add private method if need) ======================
	private static void mergeSort(String[] arr, String[] tempArr, int left, int right) {
		if (left>=right)
			return;
		int mid=(left+right)/2;
		mergeSort(arr,tempArr,left,mid);
		mergeSort(arr,tempArr,mid+1,right);
		merge(arr,tempArr,left,right,mid);
	}

	private static void merge(String[] arr, String[] tempArr, int left, int right, int mid) {
		int index1=left;//左子数组起始位置
		int index2=mid+1;//右子数组起始位置
		for (int i=left;i<=right;++i){
			tempArr[i]=arr[i];
		}
		int i=left;//归并后arr中的游标
		while (index1<=mid&&index2<=right){
			if ((keyOf(tempArr[index1]).compareTo(keyOf(tempArr[index2]))<=0)){
				arr[i++]=tempArr[index1++];
			}
			else {
				arr[i++]=tempArr[index2++];
			}
		}
		while (index1<=mid){
			arr[i++]=tempArr[index1++];
		}
		while ((index2<=right)){
			arr[i++]=tempArr[index2++];
		}

	}
	static String keyOf(String str) {
		return str.substring(0, str.indexOf(","));
	}
	//=================================================================
}
