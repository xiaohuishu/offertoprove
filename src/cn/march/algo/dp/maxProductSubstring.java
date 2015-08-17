	


	package cn.march.algo.dp;
	
	
	
	/**
	 * 问题描述： 
	 * 		给定一个序列：{-2.5, 4, 0, 3, 0.5, 8, -1} 
	 * 		
	 * 		取最大乘积连续字串的值 
	 * 		比如在上述例子中：最大乘积为 3 * 0.5 * 8
	 * 
	 * @author antsmarth
	 *
	 */
	public class maxProductSubstring {
	
		
		public static void main(String[] args) {
			
			double[] queues = new double[]{-2.5, 4, 0, 3, 0.5, 8, -1}; 
			
			System.out.println(maxProductSubstringOfDp(queues, 7));
			System.out.println(maxProductSubstringOfDp(queues, 7));
		
		}
		
		/**
		 * 传统的方式解决,通过两次循环的方式来计算;
		 * @param queues
		 * @param length
		 * @return
		 */
		private static double maxProductSubstringOfNormal(double[] queues, int length) {
	
			double maxResult = queues[0];
	
			for (int i = 1; i < length; i++) {
	
				double temp = 1;
	
				for (int j = i; j < length; j++) {
	
					temp *= queues[j];
	
					if (temp > maxResult)
						maxResult = temp;
				}

			}
	
			return maxResult;
	
		}
	
		/**
		 * 利用动态规划来解决：
		 * 	首先构造状态方程：
		 * 		max_end = Math.max(Math.max(max_end * queues[i], min_end * queues[i]), queues[i]);
		 * 		min_end = Math.min(Math.min(min_end * queues[i], max_end * queues[i]), queues[i]);
		 * 
		 * 	基本思路：
		 * 		在数组中找到一个子序列,使得它乘积最大
		 * 		同时找到一个子序列,使得它乘积最小
		 *		以max_end表示以queues[i]结尾的最大乘积
		 *		以min_end表示以queues[i]结尾的最小乘积 
		 * 
		 * @param queues
		 * @param length
		 * @return
		 */
		private static double maxProductSubstringOfDp(double[] queues, int length) {
	
			double maxEnd = queues[0];
			double minEnd = queues[0];
			double maxResult = queues[0];
	
			for (int i = 1; i < length; i++) {
					
				double end_max = maxEnd * queues[i];
				double end_min = maxEnd * queues[i];
	
				maxEnd = Math.max(Math.max(end_max, end_min), queues[i]);
				minEnd = Math.min(Math.min(end_max, end_min), queues[i]);
	
				maxResult = Math.max(maxEnd, maxResult);
								
			}
	
			return maxResult;
		}
	
	}
