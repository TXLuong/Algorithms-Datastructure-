
public class Maxheap {
	private int[] Heap;
	private int size ;
	private int maxsize;
	public Maxheap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize+1];
		Heap[0] = Integer.MAX_VALUE;
	}
	// return position of parents 
	public int parent(int pos) {
		return pos/2;
	}
	// return left and right child
	public int leftChild(int pos) {
		return 2*pos;
	}
	public int rightChild(int pos) {
		return 2*pos+1;
	}
	public boolean isLeaf(int pos) {
		
		if(2*pos  > size) {
			return true;
		}
		return false;
	}
	public void swap(int fpos,int spos) {
		int temp;
		temp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = temp;
	}
	public void insert(int element) {
		Heap[++size] = element;
		int currentpos = size;
		while(Heap[currentpos]> this.parent(currentpos)) {
			this.swap(currentpos, this.parent(currentpos));
			currentpos = this.parent(currentpos);
		}
	}
	public void print() {
		for(int i = 1; i<size;i++) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public void shiftdown(int pos) {
		if(isLeaf(pos)) return;
		while(2*pos<= this.size) {// til reaching leaf node  	
			int leftElement = this.Heap[2*pos];
			int rifghtElement = this.Heap[2*pos+1];
			if(pos<=leftElement || pos<=rifghtElement) {
				if(leftElement>rifghtElement) {
					swap(pos, 2*pos);
					pos = 2*pos;
				}
				else {
					swap(pos, 2*pos+1);
					pos = 2*pos+1;
				}
			}
			else {
				return;
			}
		}
	}
	public void heapify() {
		int start = this.size/2;
		while(start>=1) {
			shiftdown(start);
			start--;
		}
	}
	public int remove() {
		int removeElement = this.Heap[1];
		this.Heap[1] = this.Heap[size--];
		// defend violating stucture 
		shiftdown(1);
		return removeElement;	
	}
}
