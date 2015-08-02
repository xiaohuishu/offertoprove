	



	package cn.march.algo.sort;
	
	
	
	public class MergerSort {
	
		// 测试方法
		public static void main(String[] args) {
	
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			mergerSort(sortArrays);
			
		}
	
		
		/**
		 * 
		 * 基本思路(分治)：
		 * 		
		 * 		创建一个辅助数组(空间)
		 * 			int [] temp = new int[sortArrays.length];
		 * 
		 * 		第一次以(sortArrays.length-1)/2中间位置开始分割数组
		 * 
		 * 		递归对左侧,右侧进行分割处理
		 * 
		 * 		对已排序好的左侧,右侧数组进行合并
		 * 			mergeSortedArray(int[] sortArrays,
		 *					int[] sortArraysTemp, int left, int middle, int right)
		 *		
		 *		 		
		 * 
		 * @param sortArrays
		 */
		public static void mergerSort(int[] sortArrays) {
	
			int[] temp = new int[sortArrays.length];
	        
			internalMergeSort(sortArrays, temp, 0, sortArrays.length-1);
			
	        for(int i = 0; i < temp.length; i++) {
	        
	        	System.out.print(temp[i] + " ");
	        
	        }
	        
	        
		}
	
		private static void internalMergeSort(int[] sortArrays,
				int[] sortArraysTemp, int left, int right) {
	
			if (left < right) {
	
				int middle = (left + right) / 2;
	
				internalMergeSort(sortArrays, sortArraysTemp, left, middle);
				internalMergeSort(sortArrays, sortArraysTemp, middle + 1, right);
	
				mergeSortedArray(sortArrays, sortArraysTemp, left, middle, right);
			
			}
	
		}
	
		private static void mergeSortedArray(int[] sortArrays,
				int[] sortArraysTemp, int left, int middle, int right) {
	
			int i = left;
			int j = middle + 1;
			int k = 0;
			
			
			while(i <= middle && j<= right) {
				
				if(sortArrays[i] < sortArrays[j])
					sortArraysTemp[k++] = sortArrays[i++];
				else
					sortArraysTemp[k++] = sortArrays[j++];
			}
			
			while(i <= middle)
				sortArraysTemp[k++] = sortArrays[i++];
			
			while(j <= right)
				sortArraysTemp[k++] = sortArraysTemp[j++];
			
			for(i = 0; i < k; i++) {
				
				sortArrays[left + i] = sortArraysTemp[i];
				
			}
			
			
		}
	
	}
