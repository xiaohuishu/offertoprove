	



	package cn.march.algo.sort;
	
	
	
	public class InsertSort {
		
		//测试方法
		public static void main(String[] args) {
		
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			insertSort(sortArrays);
			
			
		}
		
		
		/**
		 * 
		 * 基本思路：
		 * 
		 * 		第一次i=1;
		 * 			if(arrays[i] < arrays[i-1]){....}
		 * 			以arrays[0]为初始已排序好数组
		 * 		第二次i=2;
		 * 			if(arrays[i] < arrays[i-1])
		 * 			找到arrays[1...length]中最小的元素插入到arrays[0]数组中
		 * 			所以以arrays[0,1]为已排序好数组
		 * 		.....
		 * 		第八次i=7:
		 * 			直接加入到arrays[0,1,2,3,4,5,6]已排序数组中;
		 * 
		 * @param sortArrays
		 */
		public static void insertSort(int[] sortArrays) {
			
			//获取数组长度
			int arraysLength = sortArrays.length;
			
			int i, j;
			
			//以第二个元素开始比较
			for(i = 1; i < arraysLength; i++) {
				
				if(sortArrays[i] < sortArrays[i-1]) {
					
					int temp = sortArrays[i];
					
					for(j = i-1; j >= 0 && sortArrays[j] > temp; j--)
						sortArrays[j+1] = sortArrays[j];
					
					sortArrays[j+1] = temp;
					
				}
				
				for(int k = 0; k < arraysLength; k++) {
					
					System.out.print(sortArrays[k] + " ");
					
				}
				
				System.out.println();
				
				
			}
			
		}
		
	}
