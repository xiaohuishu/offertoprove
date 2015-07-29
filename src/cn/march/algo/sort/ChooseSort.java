	


	package cn.march.algo.sort;
	
	
	
	public class ChooseSort {
	
		//测试方法
		public static void main(String[] args) {
		
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			chooseSort(sortArrays);
			
		}
		
		
		/**
		 * 
		 * 实现思路：
		 * 
		 * 		{1   3   2   9   6   4   8   15}
		 * 
		 * 		第一次i=0:
		 * 			j=0...7 if(arrays[i] < arrays[j]) swap[i,j]
		 * 			以i=0arrays[0]为标准进行判断
		 * 		第二次i=1:
		 * 			j=0...7 if(arrays[i] < arrays[j]) swap[i,j]
		 * 			以i=1arrays[1]为标准进行循环判断交换值
		 * 		....
		 * 		第八次i=7:
		 * 			j=0...7 ....
		 * 
		 * @param sortArrays
		 */
		public static void chooseSort(int[] sortArrays) {
			
			//获取数组长度
			int arraysLength = sortArrays.length;
			
			//循环判断
			for(int i = 0; i < arraysLength; i++) {
				
				for(int j = 0; j < arraysLength; j++) {
					//判断交换数组：
					if(sortArrays[i] < sortArrays[j]) {
						
						int temp = sortArrays[i];
						sortArrays[i] = sortArrays[j];
						sortArrays[j] = temp;
						
					}
					
				}
				
				for(int k = 0; k < arraysLength; k++) {
					
					System.out.print(sortArrays[k] + " ");
					
				}
				
				System.out.println();
				
			}
			
			
		}
		
	}
