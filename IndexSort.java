
public class RadixSort{

	public void countingSort(int arr[],int place){
		int len = arr.length;
		int output[] = new int[len];
		int count[10] = {0};
		for(int i = 0;i<len;i++){
			index = arr[i]/place;
			count[index%10]++;
		}
		// phần tử có hàng đơn vị là i sẽ có index trong mảng mới là 
		// count[i-1] cho đến count[i]-1
		for(int i = 1;i<10;i++){
			count[i] += count[i-1];
		}
		// đăt các phần tử theo một mảng sắp xếp theo hàng đơn vị 
		int temp = 0;
		while(temp!=len){
			int ordedElement = arr[temp]/place ;
		        output[count[ordedElement%10] -1] = arr[i];
			count[ordedElement%10]--;
			temp++;
		}
		for(int i = 0; i < len ;i++){
			arr[i] = output[i];
		}


	}
	public void radixSort(int arr){
		int max = arr[0];
		int len = arr.length ;
		for(int i = 0;i<len;i++){
			if(max < arr[i]) max = arr[i];
		}
		for( int place = 1;max/place > 0;place *=10){
			countingSort(arr,place);
		}
	}	
	public static void main( String args[]){
		
		int n ;
		Scanner keyBoard = new Scanner(System.in);
		n = keyBoard.nextInt();
		int arr[] = new int[n];
		for ( int i = 0;i < n;i++){
			arr[i] = keyBoard.nextInt();
		}
		
		radixSort(arr);
		for(int i = 0;i<n;i++){
			System.out.print(arr[i]);
		}
	}

}

