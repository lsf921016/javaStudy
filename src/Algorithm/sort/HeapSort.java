package Algorithm.sort;

public class HeapSort extends sort {
	int heapSize;
	int[] heapArr;
	HeapSort(int[] source) {
		super(source);
		heapSize=source.length;
		// TODO �Զ����ɵĹ��캯�����
	}
	public void boot(){
		long startTime=System.currentTimeMillis();

		buildHeap();
		sortHeap();
		long endTime=System.currentTimeMillis();
		time=endTime-startTime;
		
	}
	
	private void sortHeap() {
		while(heapSize>0){
			swap(arr,0,heapSize-1);
			heapSize--;
			siftdown(0);

		}
		
	}
	private void buildHeap() {
		for(int i=length/2-1;i>=0;--i){
			siftdown(i);
		}
	}
	private void siftdown(int position) {
		int i=position;
		int j=2*i+1;
		int temp=arr[i];
		while(j<heapSize){
			if(j<heapSize-1&&compare(arr[j],arr[j+1])){
				++j;
			}
			if(compare(temp,arr[j])){
				arr[i]=arr[j];
				i=j;
				j=2*i+1;
			}
			else break;
		}
		arr[i]=temp;
		
	}

}
