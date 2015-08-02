



	package cn.march.algo.sort;
	
	
	
	
	public class HeapSort {
	
		
		//测试方法
		public static void main(String[] args) {
		
			int [] sortArrays = new int[]{1,3,2,9,6,4,8,15};
			
			heapSort(sortArrays);
			
		}
		
		/**
		 * 实现思路(构建最小堆)
		 * 		
		 * 		参考：http://blog.csdn.net/morewindows/article/details/6709644
		 * 
		 * 		最小堆：
		 * 		
		 * 			当父结点的键值总是小于或等于任何一个子节点的键值时为最小堆
		 * 
		 * 		将待排序数组当作一个近似完全二叉树(即父结点都有左右子结点,但是叶子结点除外)
		 * 
		 * 		比如{1,3,2,9,6,4,8,15}
		 * 
		 * 		类比下图结构：
		 * 
		 * 						 1
		 * 					3         2
		 * 				9      6   4     8
		 * 			15	
		 * 
		 * 		我们首先开始构造最小堆,即对树进行排序
		 * 
		 * 		a: 上图就是一个最小堆,之后将root根结点与最后的一个叶子结点进行交换
		 *  
		 * 		即a[0] <--> a[n-1] 1 <--> 15
		 * 
		 * 		所以a[n-1]位置现在就是最小的值
		 * 
		 * 		之后再对数组(0....n-2)开始构造最小堆
		 * 		
		 * 		重复a操作;
		 * 
		 * 		之后得到的数组就是排序好的数组
		 * 		
		 * 	
		 * @param sortArrays
		 */
		public static void heapSort(int[] sortArrays) {
			
			for(int i = sortArrays.length - 1; i >= 1; i--) {
				
				swap(sortArrays, i, 0);
				
				makeMinHeap(sortArrays, 0, i);
				
			}
			
		}
		
		/**
		 * 构造最小堆
		 * @param sortArrays
		 * @param i
		 * @param n
		 */
		private static void makeMinHeap(int[] sortArrays, int i, int n) {
			
			int j,temp;
			
			temp = sortArrays[i];
			
			//获取其左孩子结点
			j = 2 * i + 1;

			while(j < n) {
				
				//比较左右孩子结点最小的结点
				if(j + 1 < n && sortArrays[j+1] < sortArrays[j])
					j++;
				
				if(sortArrays[j] >= temp)
					break;
				
				//若比父结点小,则进行交换
				sortArrays[i] = sortArrays[j];
				i = j;
				j = 2 * i + 1;
				
			}
			
			sortArrays[i] = temp;
			
			//为了查看效果,每一次构造进行输出
			for(int k = 0; k < sortArrays.length; k++) {
				
				System.out.print(sortArrays[k] + " ");
				
			}
			
			System.out.println();
			
		}
		
		//交换数组元素
		private static void swap(int[] sortArrays, int i, int n) {
			
				int temp = sortArrays[i];
				sortArrays[i] = sortArrays[n];
				sortArrays[n] = temp;
			
		}
		
		
	}
