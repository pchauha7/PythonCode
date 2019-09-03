package test.mywork;

import java.util.Arrays;
import java.util.Scanner;

public class TimeStampStream2 {
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
	}
	
	private static void minHeapify(int[] constArr,int s, int n) {
		
		int minIndx = s; // Initialize smallest index as root
        int l = 2*s + 1; // left node = 2*s + 1
        int r = 2*s + 2; // right node = 2*s + 2
 
        // If left child is smaller than root
        if (l < n && constArr[l] < constArr[minIndx])
        	minIndx = l;
 
        // If right child is smaller so far
        if (r < n && constArr[r] < constArr[minIndx])
        	minIndx = r;
 
        // If smallest is not root
        if (minIndx != s) {
        	swap(constArr, minIndx, s);
        	
            // Recursively minheapify subtree
        	minHeapify(constArr, minIndx, n);
        }
		
	}
	
	private static void heapSort(int[] storage, int n) {
		//First build the min Heap
		for (int i = n / 2 - 1; i >= 0; i--)
			minHeapify(storage, i, n);
 
       //Segregate smallest to the right hand side one by one
		for (int i=n-1; i>=0; i--)
        {
			swap(storage, 0, i);
			minHeapify(storage, 0, i);
        }
		
		//Reverse the array to get sorted array in ascending order
		for (int i=0; i<n/2; i++)
			swap(storage, i, n-i-1);
	}

	public static void main(String[] args) {
		
		//Number of time stamps expected to arrive at target
		int N = 100000;
		
		int constArrSize = 100;
		
		// Here we will save final sorted time stamp
		int storage[] = new int[N];
		
		//This is the constant size array to be used as kind of temporary memory.
		//Here first 100 values will be stored first and for the next set of integers minHeapify will be used
		int constArr[] = new int[constArrSize];
		
		System.out.println("Please pass the input stream:");
		
		Scanner s = new Scanner(System.in);
		
		//In this case constArr is not required
		if (N<=constArrSize) {
			for (int i=0; i < N; i++)
				if(s.hasNextInt())
					storage[i] = s.nextInt();
			heapSort(storage,N);
		}
		else {
			//Sorting first 100 time stamp in constant array
			
			for (int i=0; i < constArrSize; i++)
				if(s.hasNextInt())
					constArr[i] = s.nextInt();
			heapSort(constArr,constArrSize);
			
			int j=0;
			//Picking smallest timestamp in constArray and storing it and applying minHeapify
			while (j < N-constArrSize) {
				storage[j] = constArr[0];
				if(s.hasNextInt())
					constArr[0]=s.nextInt();
				minHeapify(constArr,0,constArrSize);
				j++;
			}
			//After all this sort the remaining last 100 elements
			heapSort(constArr,constArrSize);
			int i=0;
			//Store the elements one by one in storage
			while (j < N) {
				storage[j] = constArr[i];
				i++;
				j++;
			}
		}
		//Close the stream
		s.close();
		
		System.out.println("Resultant output storage" + Arrays.toString(storage));
		
	}

	

	

}
