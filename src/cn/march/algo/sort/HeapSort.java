



	package cn.march.algo.sort;
	
	
	
	
	public class HeapSort {
	
		
		public static void main(String[] args) {
		
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			heapSort(sortArrays);
			
		}
		
		
		public static void heapSort(int[] sortArrays) {
			
			for(int i = sortArrays.length - 1; i >= 1; i--) {
				
				swap(sortArrays, i, 0);
				
				makeMinHeap(sortArrays, 0, i);
				
			}
			
		}
		
		private static void makeMinHeap(int[] sortArrays, int i, int n) {
			
			int j,temp;
			
			temp = sortArrays[i];
			
			j = 2 * i + 1;

			while(j < n) {
				
				if(j + 1 < n && sortArrays[j+1] < sortArrays[j])
					j++;
				
				if(sortArrays[j] >= temp)
					break;
				
				sortArrays[i] = sortArrays[j];
				i = j;
				j = 2 * i + 1;
				
			}
			
			sortArrays[i] = temp;
			
			
			for(int k = 0; k < sortArrays.length; k++) {
				
				System.out.print(sortArrays[k] + " ");
				
			}
			
			System.out.println();
			
		}
		
		
		private static void swap(int[] sortArrays, int i, int n) {
			
				int temp = sortArrays[i];
				sortArrays[i] = sortArrays[n];
				sortArrays[n] = temp;
			
		}
		
		
	}
