	



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
		 * 时间复杂度：
		 * 	
		 * 		计算公式：
		 * 					O(1)   n<=c
		 * 				--->
		 * 		T(n) = 
		 *              --->
		 * 					2T(n/2) + O(n)  n>c
		 *		
		 *		计算思路：
		 *			
		 *			
		 *			如果估计的话，可以这么算：
		 *				架设n往大取，n=2^s
		 *				那么公式就变成了：
		 *					T(2^s)=2T(2^(s-1))+2^s
		 *				两边同除2^s：
		 *					T(2^s)/(2^s)=T(2^(s-1))/(2^(s-1))+1
		 *				设a_s=T(2^s)/(2^s)并假设a_1=1，原式化为：
		 *					a_s=a_(s-1)+1
		 *				为等差数列，于是a_s=s
		 *				于是：
		 *					T(2^s)/(2^s)=s
		 * 				那么T(2^s)=s*2^s
		 *				你再把n=2^s带入就是
		 *	 			T(n)=nlogn了
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
	
		/**
		 * 分割数组,以(left + right) / 2为边界进行分割,然后递归调用;
		 * 
		 * @param sortArrays
		 * @param sortArraysTemp
		 * @param left
		 * @param right
		 */
		private static void internalMergeSort(int[] sortArrays,
				int[] sortArraysTemp, int left, int right) {
	
			if (left < right) {
	
				int middle = (left + right) / 2;
	
				internalMergeSort(sortArrays, sortArraysTemp, left, middle);
				internalMergeSort(sortArrays, sortArraysTemp, middle + 1, right);
	
				mergeSortedArray(sortArrays, sortArraysTemp, left, middle, right);
			
			}
	
		}
	
		/**
		 * 将排序好的左边数组右边数组进行合并
		 * 
		 * @param sortArrays
		 * @param sortArraysTemp
		 * @param left
		 * @param middle
		 * @param right
		 */
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
