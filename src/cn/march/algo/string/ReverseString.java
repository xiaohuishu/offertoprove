	


	package cn.march.algo.string;
	
	
	/**
	 * 问题描述：
	 * 		给定一个字符串strings,长度n，m
	 * 		将字符串strings前m个字符翻转;
	 * 
	 * @author antsmarth
	 *
	 */
	public class ReverseString {
	
		//测试方法
		public static void main(String[] args) {
			
			System.out.println("shuxiaohui1105");
			
			leftRotateString("shuxiaohui1105", 14, 5);
			
		}
		
		
		/**
		 * 三步反转法：
		 * 		比如现在要反转"abcdef" ---> "defabc"
		 * 
		 * 		现在我们假设 a = "abc" b = "def"		
		 * 		先对a进行反转 a^ = a^Y = “cba”
		 * 		对b进行反转 b^ = b^Y = "fed"
		 * 		a^b^ = "cbafed"
		 * 		然后对a^b^进行反转 (a^b^) ^ Y = "defabc"
		 * 		刚好是我们想要的结果：---> 这就叫做三步反转法
		 * 
		 * @param strings
		 * @param n
		 * @param m
		 */
		private static void leftRotateString(String strings, int n, int m) {
			
			if(n <= 0 || strings == null)
				throw new RuntimeException("设置参数不合法!");
			
			if(n == 1) {
				
				System.out.println(strings);
				return ;
			
			}
			
			char[] chars = strings.toCharArray();
			
			m %= n; //若需要反转的位数大于m则就直接反转n
			
			reverseString(chars, 0, m - 1);
			reverseString(chars, m, n - 1);
			reverseString(chars, 0, n - 1);
			
			System.out.println(String.valueOf(chars));
			
		
		}
		
		/**
		 * 反转操作
		 * @param strings
		 * @param from
		 * @param to
		 */
		private static void reverseString(char[] strings, int from, int to) {
		
			
			while(from < to) {
				
				char temp = strings[from];
				strings[from++] = strings[to];	
				strings[to--] = temp;
							
			}
			
		}
		
	}
