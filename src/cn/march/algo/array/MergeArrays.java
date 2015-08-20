	


	package cn.march.algo.array;
	
	/**
	 * 问题描述：
	 * 		给定两个数组(已排序)：
	 * 			合并两个数组,得到一个新的数组(排序)
	 * 
	 * @author antsmarth
	 *
	 */
	public class MergeArrays {
	
		//测试方法
		public static void main(String[] args) {
	
			mergeArrays(new int[] { 1, 5, 7, 9, 12 },
					new int[] { 2, 4, 10, 11, 15 }, 5, 5);
	
		}
	
		/**
		 * 基本思路：
		 * 		先进行边界处理：
		 * 		之后判断两个数组的元素数量是否相等：
		 * 			boolean flag_equals = fir_length == sec_length:
		 * 				则正好是归并排序中的合并思路：
		 * 					首先已fir_length + sec_length建立新的数组merge_temp;
		 * 					开始first_temp中的元素与second_temp中的元素进行比较,将较小的值先赋值给merge_temp中
		 * 					等比较完之后,再根据fir,sec的游标位置,将剩下的值同样赋值到merge_temp中
		 * 		两个数组的元素数量不想等：
		 * 			boolean flag_nonequals = fir_length > sec_length ? true : false;
		 * 			first_temp.length > second_temp.length:
		 * 				处理思路：
		 * 
		 * 			first_temp.length < second_temp.length:
		 * 				处理思路： 	
		 * 	
		 * 
		 * @param first_temp
		 * @param second_temp
		 * @param fir_length
		 * @param sec_length
		 * @return
		 */
		private static int[] mergeArrays(int[] first_temp, int[] second_temp,
				int fir_length, int sec_length) {
	
			
			//边界处理
			if (first_temp == null || second_temp == null || fir_length == 0
					|| sec_length == 0)
				throw new RuntimeException("设置参数不正确!");
	
			boolean fir_flag = fir_length <= 0 ? (sec_length > 0 ? true : false)
					: false;
			boolean sec_flag = sec_length <= 0 ? (fir_length > 0 ? true : false)
					: false;
	
			if (fir_flag)
				return second_temp;
			if (sec_flag)
				return first_temp;
	
			//建立合并数组
			int[] merge_temp = new int[fir_length + sec_length];
	
			int i = 0;
	
			boolean flag_equals = fir_length == sec_length;
	
			//合并的两个数组想等的情况：
			if (flag_equals) {
	
				int fir = 0;
				int sec = 0;
	
				while (fir < fir_length && sec < sec_length) {
	
					if (first_temp[fir] > second_temp[sec])
						merge_temp[i++] = second_temp[sec++];
					else
						merge_temp[i++] = first_temp[fir++];
	
				}
	
				while (fir < fir_length)
					merge_temp[i++] = first_temp[fir++];
				while (sec < sec_length)
					merge_temp[i++] = second_temp[sec++];
	
			}else {
				
				//合并的两个数组元素数量不相等的情况
				boolean flag_nonequals = fir_length > sec_length;
				
				//处理过程
				if(flag_nonequals) {
					
				}else {
					
				}
	
				
				
			}
	
			for (int k = 0; k < merge_temp.length; k++)
				System.out.print(merge_temp[k] + " ");
	
			return merge_temp;
	
		}
	}
