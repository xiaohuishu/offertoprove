	
	
	
	
	package cn.march.algo.sort;
	
	
	
	public class BubbleSort {
	
		//测试方法
		public static void main(String[] args) {
			
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			bubbleSort(sortArrays);
			
		}
		
		
		/**
		 * 实现思路：
		 * 
		 * 		［1   3   2   9   6   4   8   15］
		 * 
		 * 		 第一次i=0;
		 * 		 	j=0....7(length-1-i)  if(arrays[j] > arrays[j+1]) swap{j,j+1};
		 * 		[1   2   3  6  4  8  9  15]
		 * 
		 * 		 第二次i=1;
		 * 			j=0....6(length-1-1)  if(arrays[j] > arrays[j+1]) swap{j,j+1};
		 * 		
		 * 		[1   2   3  4   6  8  9  15]
		 * 		
		 * 		 第三次i=2;
		 * 		  .....
		 * 		  .....		
		 * 		 第八次i=7;
		 * 		  .....
		 * 		  .....
		 * 		实际上我们发现到循环二次比较我们都可以正确的对arrays进行排序
		 * 		所以实际上我们之后的6次循环是无意义的;
		 * 		所以我们可以设置一个isFlag标志位代表数组已经排序好
		 * 			若isFlag为true则直接不进行之后的循环;			
		 * 
		 * 
		 * 
		 * @param sortArrays
		 */
		public static void bubbleSort(int[] sortArrays) {
			
			//数组长度
			int arrayLength = sortArrays.length;
			
			for(int i = 0 ; i < arrayLength; i++) {
				
				//从数组第一个元素开始比较;
				for(int j = 0 ; j < arrayLength-1-i; j++) {
					
					//比较相邻的两个元素,若前面一个元素比较大则进行交换
					if(sortArrays[j] > sortArrays[j+1]) {
						
						int temp = sortArrays[j];
						sortArrays[j] = sortArrays[j+1];
						sortArrays[j+1] = temp;
						
					}	
				}
				
				//为了输出效果,每一次i++进行输出
				for(int k = 0; k < arrayLength; k++) {
					
					System.out.print(sortArrays[k] + " ");
					
				}
				
				System.out.println();
				
			}
			
		}
		
	}
