


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
		
		if(k <= 0 || length == 1)
			throw new RuntimeException("设置的参数不合法!");
		
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
		if(k <= 0 || length == 1)
			throw new RuntimeException("设置的参数不合法!");
		
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
}