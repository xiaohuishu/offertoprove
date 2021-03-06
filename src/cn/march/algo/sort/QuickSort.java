



	package cn.march.algo.sort;
	
	
	
	public class QuickSort {
	
				
		//测试主方法
		public static void main(String[] args) {
			
			
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			quickSort(sortArrays, 0, 7);
			
		}
		
		
		/**
		 * 实现思路(分治)：
		 * 		{1   3   2   9   6   4   8   15}
		 * 		left=0,right=7
		 * 			partition():
		 * 
		 * 				pivot = sortArrays[0(left)] = 1;
		 * 				
		 * 				while(left < right)
		 * 					
		 * 					while(left < right && sortArrays[right] >= pivot) right--;
		 * 
		 * 					if(left < right) sortArrays[left++] = sortArrays[right];
		 * 
		 * 					while(left < right && sortArrays[left] <= pivot) left++;
		 * 
		 * 					if(left < right) sortArrays[right--] = sortArrays[left];
		 * 
		 * 				sortArrays[left] = pivot;
		 * 
		 * 				return left;
		 * 		{1  3  2  9  6  4  8  15}
		 * 		
		 * 		以dp = partition() --> left 为基准对dp数组左侧,数组右侧进行扫描比较;
		 * 
		 * 		如果左侧的数据相对于dp位置的值大,进行交换位置
		 * 		如果右侧的数组相对于dp位置的值小,进行交换位置
		 * 
		 * 		循环递归调用;
		 * 		
		 * 		  					
		 * @param sortArrays
		 * @param left
		 * @param right
		 */
		public static void quickSort(int[] sortArrays, int left, int right) {
			
			int dp;
			
			
			if(left < right) {
				
				dp = partition(sortArrays, left, right);
								
				quickSort(sortArrays, left, dp - 1);
				
				quickSort(sortArrays, dp + 1, right);
				
			}
			
			
		}
		
		
		private static int partition(int[] sortArrays, int left, int right) {
			
			int pivot = sortArrays[left];
			
			while(left < right) {
				
				while(left < right && sortArrays[right] >= pivot)
					right--;
				
				if(left < right)
					sortArrays[left++] = sortArrays[right];
				
				while(left < right && sortArrays[left] <= pivot)
					left++;
				
				if(left < right)
					sortArrays[right--] = sortArrays[left];
				
			}
			
			sortArrays[left] = pivot;
			
			for(int k = 0; k < sortArrays.length; k++) {
				
				System.out.print(sortArrays[k] + " ");
			
			}
			
			System.out.println();
			
			return left;
			
		}
		
	}
