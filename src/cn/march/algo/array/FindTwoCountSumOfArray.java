	


	package cn.march.algo.array;
	
	
	
	
	
	/**
	 * 问题描述：
	 * 		输入一个数组和一个数：
	 * 			查找数组中的两个数,使这两个数等于输入的那个数
	 * 
	 * @author antsmarth
	 *
	 */
	public class FindTwoCountSumOfArray {
		
		//测试方法
		public static void main(String[] args) {
	
			int[] arrays = new int[]{1, 2, 4, 7, 11, 15};
			
			findTwoCountSunOfCycl(arrays, arrays.length, 15);
			
			System.out.println("-------------------");
			
			findTwoCountSunOfOtherArray(arrays, arrays.length, 15);
			
		}
		
		/**
		 * 通过传统循环的方式解决：
		 * 		给定值sum,遍历arrays数组：
		 * 			对每一个元素进行与sum进行相减处理：int sub_v = sum - arrays[i]
		 * 			之后再次遍历arrays数组,判断sub_v是否在数组中存在;
		 * 
		 * @param arrays
		 * @param length
		 * @param sum
		 */
		private static void findTwoCountSunOfCycl(int[] arrays, int length, int sum) {
	
			//边界处理
			if (arrays == null || length <= 0)
				throw new RuntimeException("设置参数不合法!");
	
			if (length == 1)
				if (arrays[0] == sum)
					System.out
							.println("arrays数组中：" + arrays[0] + " = sum : " + sum);
	
			for (int i = 0; i < length; i++) {
	
				int sub_v = sum - arrays[i];
	
				for (int j = 0; j < length; j++)
	
					if (sub_v == arrays[j] && i != j)
						System.out.println("sum 和为arrays数组中的两个元素之和：" + arrays[i]
								+ ", " + arrays[j]);
	
			}
	
		}
		
		/**
		 * 基本思路：
		 * 		以空间换取时间的方式：
		 * 			首先创建一个数量为length的数组temp_arrays;
		 * 			用sum减去arrays数组中的元素计算后的值对temp_arrays进行初始化
		 * 			之后用游标begin从前开始标记arrays,游标end从数组temp_arrays末端开始标记
		 * 			判断ararys[begin] == temp_arrays[end]
		 * 			若想等：
		 * 				则输出其值
		 * 			否则：
		 * 				
		 * 				end = length - 1;
		 * 				begin++
		 * 				end--
		 * 
		 * @param arrays
		 * @param length
		 * @param sum
		 */
		private static void findTwoCountSunOfOtherArray(int[] arrays, int length, int sum) {
			
			//边界处理
			if(arrays == null || length <= 0)
				throw new RuntimeException("设置参数不合法!");
			
			if(length == 1)
				if(arrays[0] == sum)
					System.out
					.println("arrays数组中：" + arrays[0] + " = sum : " + sum);
	
			
			//初始化temp_arrays数组
			int[] temp_arrays = new int[length];
			
			for(int i = 0; i < length; i++) {
				
				int sub_v = sum - arrays[i];
				
				temp_arrays[i] = sub_v;
				
				//System.out.println(temp_arrays[i]);
				
			}
			
			//数组元素比较,利用begin,end游标
			int begin = 0;
			int end = length - 1;
			
			while(begin <= length - 1 && end >= 0) {		
				
				if(arrays[begin] == temp_arrays[end]) {
								
					System.out.println("sum 和为arrays数组中的两个元素之和：" + arrays[begin]
							+ ", " + (sum - arrays[begin]));
					end--;
				}
				
				end = length - 1;
				
				begin++;		
				end--;
				
			}
		
				
			
		}
		
	}
