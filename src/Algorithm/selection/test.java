package Algorithm.selection;

import javax.swing.plaf.SliderUI;

public class Test {


	public static void main(String[] args) {
		//generate data
		final int test1=10000;
		final int test2=100000;
		final int test3=1000000;
		int[] arr1=Util.createRandomArray(test1);
		int[] arr2=Util.createRandomArray(test2);
		int[] arr3=Util.createRandomArray(test3);
		//test1
		Selection1 s11=new Selection1(arr1);
		System.out.println("select1  :"+" n:"+test1+", k:"+test1/2+", found:"+s11.select(test1/2)+", number of comparison:"+s11.comparison);
		
		Selection2 s21=new Selection2(arr1);
		System.out.println("select2  :"+" n:"+test1+", k:"+test1/2+", found:"+s21.select(test1/2)+", number of comparison:"+s21.comparison);
		
		Selection3 s31=new Selection3(arr1);
		System.out.println("select3  :"+" n:"+test1+", k:"+test1/2+", found:"+s31.select(test1/2)+", number of comparison:"+s31.comparison);
		System.out.println("-------------------------------------------------------------------------------------");
		
		//test2
		Selection1 s12=new Selection1(arr2);
		System.out.println("select1  :"+" n:"+test2+", k:"+test2/2+", found:"+s12.select(test2/2)+", number of comparison:"+s12.comparison);
		
		Selection2 s22=new Selection2(arr2);
		System.out.println("select2  :"+" n:"+test2+", k:"+test2/2+", found:"+s22.select(test2/2)+", number of comparison:"+s22.comparison);
		
		Selection3 s32=new Selection3(arr2);
		System.out.println("select3  :"+" n:"+test2+", k:"+test2/2+", found:"+s32.select(test2/2)+", number of comparison:"+s32.comparison);
		System.out.println("-------------------------------------------------------------------------------------");
		
		//test3
		Selection1 s13=new Selection1(arr3);
		System.out.println("select1  :"+" n:"+test3+", k:"+test3/2+", found:"+s13.select(test3/2)+", number of comparison:"+s13.comparison);
		
		Selection2 s23=new Selection2(arr3);
		System.out.println("select2  :"+" n:"+test3+", k:"+test3/2+", found:"+s23.select(test3/2)+", number of comparison:"+s23.comparison);
		
		Selection3 s33=new Selection3(arr3);
		System.out.println("select3  :"+" n:"+test3+", k:"+test3/2+", found:"+s33.select(test3/2)+", number of comparison:"+s33.comparison);
		System.out.println("-------------------------------------------------------------------------------------");


	}
}
