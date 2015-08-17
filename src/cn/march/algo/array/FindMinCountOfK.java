	
	
	
	package cn.march.algo.array;
	
	import cn.march.algo.sort.QuickSort;
	
	
	/**
	 * 问题描述：
	 * 		给定一个数量为n的数组(int)
	 * 		输出最小的k个数
	 * 
	 * @author antsmarth
	 *
	 */
	public class FindMinCountOfK {
	
		//测试方法
		public static void main(String[] args) {
			
			int[] arrays = new int[]{6, 8, 12, 4, 7, 9, 15, 2};
			
			findMinCountOfKByQuickSort(arrays, 3, arrays.length);
			
			findMinCountOfKByNonSort(arrays, 3, arrays.length);
			
			findMinCountOfKByMakeHeap(arrays, 3, arrays.length);
			
		}
		
		/**
		 * 
		 * 最直观的思路：
		 * 		先对数组进行排序
		 * 	 	输出前k个数 
		 * 
		 * @param arrays
		 * @param k
		 * @param length
		 */
		private static void findMinCountOfKByQuickSort(int [] arrays, int k, int length) {
			
			if(k <= 0 || length <= 0)
				throw new RuntimeException("设置的参数不合法!");
			
			if(length == 1) {
				
				System.out.println("最小的一个数：" + arrays[0]);
				return ;
			
			}
			
			//快速排序
			QuickSort.quickSort(arrays, 0, length-1);
			
			System.out.println("通过排序数组方式：arrays数组中最小的" + k + "个数: ");
			
			for(int i = 0; i < k; i++)
				System.out.print(arrays[i] + " ");
			
			System.out.println();
			
		}
		
		/**
		 * 基本思路：
		 * 		首先创建一个长度为k的数组k_arrays;		
		 * 		将arrays前k个数赋值给k_arrays
		 * 		从k位置开始开始遍历arrays：
		 * 			先获取k_arrays中最大的数:k_array_max;
		 * 			将k_array_max与arrays[k...length-1]比较
		 * 			若k_array_max > arrays[k...length-1]
		 * 				进行交换值,将arrays[i]的值赋给k_arrays[j];
		 * 			否则继续遍历比较
		 * 
		 * @param arrays
		 * @param k
		 * @param length
		 */
		private static void findMinCountOfKByNonSort(int [] arrays, int k, int length) {
			
			//边界处理
			if(k <= 0 || length <= 0)
				throw new RuntimeException("设置的参数不合法!");
			
			if(length == 1) {
				
				System.out.println("最小的一个数：" + arrays[0]);
				return ;
			
			}
			
			int[] k_arrays = new int[k];
			
			//初始化k_arrays;
			for(int i = 0; i < k; i++)
				k_arrays[i] = arrays[i];
			
			int k_array_max = k_arrays[0];
			
			//从k起始位置开始遍历arrays;
			for(int i = k; i < length; i++) {
				
				int j = 0;
				for(j = 1; j < k; j++) 	
					if(k_array_max < k_arrays[j])
						k_array_max = k_arrays[j];
				
				if(k_array_max > arrays[i])
					k_arrays[j] = arrays[i];
				
			}
			
			System.out.println("通过不排序数组方式：arrays数组中最小的" + k + "个数: ");
			
			for(int i = 0; i < k; i++)
				System.out.print(k_arrays[i] + " ");
			
			System.out.println();
			
		}
		
		/**
		 * 基本思路：
		 * 		与上述的非排序数组方式一样,同样维护一个数量为k的数组:k_arrays
		 * 		通过arrays的前k个数对k_arrays进行初始化
		 * 		从k开始遍历arrays数组：
		 * 			先对k_arrays数组进行构建最大堆的处理(makeHeap)
		 * 			然后取出最大的元素与arrays[k...length-1]进行比较
		 * 			若k_arrays[k-1] > arrays[k...length-1]：
		 * 				将arrays[k...length-1]赋值给k_arrays[k-1]
		 * 			否则
		 * 				不做处理
		 * 			继续遍历		
		 * 
		 * @param arrays
		 * @param k
		 * @param length
		 */
		private static void findMinCountOfKByMakeHeap(int[] arrays, int k, int length) {
			
			//边界处理
			if(k <=0 || length <= 0)
				throw new RuntimeException("设置的参数不合法!");
			
			if(length == 1) {
				
				System.out.println("最小的一个数：" + arrays[0]);
				return ;
			
			}
			
			//初始化数组
			int[] k_arrays = new int[k];
			
			for(int i = 0; i < k; i++)
				k_arrays[i] = arrays[i];
			
			for(int i = k; i < length; i++) {
				
				//构建最大堆
				makeHeap(k_arrays, k);
				
				if(k_arrays[k-1] > arrays[i])
					k_arrays[k-1] = arrays[i];
				
			}
			
			System.out.println("通过不排序数组方式(建立最大堆)：arrays数组中最小的" + k + "个数: ");
			
			for(int i = 0; i < k; i++)
				System.out.print(k_arrays[i] + " ");
			
			System.out.println();
					
		}
		
		/**
		 * 对k_arrays进行构建最大堆处理
		 * @param k_arrays
		 * @param length
		 */
		private static void makeHeap(int[] k_arrays, int length) {
			
			//边界处理
			if(length <= 0 || k_arrays == null)
				throw new RuntimeException("设置参数不合法!");
			
			if(length == 1)
				return ;
			
			int i = 0;
			
			int temp = k_arrays[i];
			
			int j = 2 * i + 1;
			
			while(j < length) {
				
				if( j+1 < length && k_arrays[j] > k_arrays[j+1])
					j++;
				
				if(k_arrays[j] >= temp)
					break;
				
				k_arrays[i] = k_arrays[j];
				i = j;
				j = 2 * i + 1; 
				
			}
			
			k_arrays[i] = temp;
			
		}
		
	}
