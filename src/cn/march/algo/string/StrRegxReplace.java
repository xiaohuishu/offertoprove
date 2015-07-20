	

	package cn.march.algo.string;

	

	
	import java.util.regex.Matcher;
import java.util.regex.Pattern;
	
	
	
	/**
	 * 自实现字符串替换(O(n2)式解法)
	 * (O(n2)解法可以优化成O(n)解法)解法见InsteadOfNullString.java
	 * @author antsmarch
	 * @version 1.0.0
	 */
	public class StrRegxReplace {
		
		//测试方法
		public static void main(String[] args) {

			//原始字符串
			String str = "GB12234122";
			
			/*
			 * Pattern pattern = Pattern.compile("^[a-zA-Z]*[0-9]*.[0-9]{5}$");
			 * 
			 * Matcher match = pattern.matcher(str);
			 * 
			 * System.out.println(match.find());
			 */
			//匹配字符串
			String findString = "12234122";
			System.out.println("匹配字符串 : " + findString);
		
			System.out.println("---------------------");
			//替换字符串
			String replaceString = "58111132";
			System.out.println("替换字符串 : " + replaceString);
			
			System.out.println("---------------------");
			
			System.out.println("初始字符串 : " + str);
		
			System.out.println("---------------------");
			
			System.out.println("替换完成后字符串 : " + replaceRegxString(findString, replaceString, str));
	
		}
		
		
		/**
		 * (O(n2)解法可以优化成O(n)解法)解法见InsteadOfNullString.java
		 * 基本思路(O(n2)式解法)：
		 * 		1.在原始字符串通过正则查找匹配字符串
		 * 		2.若匹配成功：
		 * 			2.1 找到原始字符串中匹配字符串start与end游标
		 * 			2.2 匹配字符串与替换字符串长度比较:
		 * 			2.3 若长度相等：
		 * 				2.3.1 则直接替换
		 * 			2.4 若匹配字符串小于替换字符串长度：
		 * 				2.4.1 对原始字符串进行扩容操作,再进行替换
		 * 			2.5 若匹配字符串大于替换字符串长度：
		 * 				2.5.1 进行替换,多于空部分以‘／’字符代替,之后对字符串中所有'/'字符进行消除操作
		 * 
		 * @param findString ：匹配字符串
		 * @param replaceString ：替换字符串
		 * @param allString ： 原始字符串
		 * @return
		 */
		private static String replaceRegxString(String findString, String replaceString,
				String allString) {
			//匹配字符串,得到正则对象
			Matcher matcher = find(findString, allString);
			
			//将替换,原始字符串转换成char[]数组
			char[] newChars = replaceString.toCharArray();
			char[] replaces = allString.toCharArray();
			
			//匹配字符串
			boolean result = matcher.find();
			
			//计算匹配字符串与替换字符串长度差
			int range = replaceString.length() - findString.length();
			
			//start,end游标
			int first, end = 0;
			
			String tempString = null;
			
			if (result) {
				/*
				 * 循环匹配字符串(原始字符串中可能有多个匹配字符串)
				 */
				do {
					/*
					 * 得到匹配后的start,end游标
					 */
					first = matcher.start();
					end = matcher.end();
					
					//start,end边界判断
					if (first <= 0 && end > allString.length()) {
						throw new RuntimeException("超出字符串边界!");
					}
	
					int index = 0;
					
					for (int i = first; i < end; i++) {
						
						//1. 长度差相等,直接替换
						if (range == 0) {
							replaces[i] = newChars[index];
						} 
						//2. 若匹配字符串小于替换字符串
						else if (range < 0) {
							/*System.out.println(newChars.length - Math.abs(range)
									+ " : index " + index);*/
							
							//对多出部分进行'/'替代
							if (index > findString.length() - Math.abs(range) - 1) {
								replaces[i] = '/';
							}
							//替换处理
							else
								replaces[i] = newChars[index];
							
						} 
						//3. 若匹配字符串大于替换字符串
						else if (range > 0) {
							//进行扩容操作(O(n2)解法可以优化成O(n)解法)解法见InsteadOfNullString.java
							replaces = capticay(replaces, i,findString.length(), range);
							int replaceIndex = 0;
							for (int j = i; j < i + findString.length() + range; j++) {
								replaces[j] = newChars[replaceIndex];
								replaceIndex ++;
							}
							break;
						}
						index++;
					}
					//清理'/'字符
					tempString = cleanChars(replaces,range);
					
					//再进行匹配字符串处理,拿到正则对象
					matcher = find(findString, tempString);
					
					//进行匹配
					result = matcher.find();
	
				} while (result);
				
				//System.out.println(tempString);
	
				return tempString;
	
			} else {
				throw new RuntimeException("匹配不成功!");
			}
	
		}
		
		/**
		 * 对字符串进行扩容操作
		 * @param replaces : 原始字符
		 * @param i 
		 * @param findIndex 
		 * @param range 
		 * @return
		 */
		private static char[] capticay(char[] replaces,int i,int findIndex,int range){
			
			// 进行扩容,实例化new的字符数组
			char [] newReplaces = new char[replaces.length + range];
			
			// 赋值初始化
			for(int i1=0; i1<replaces.length; i1++){
				newReplaces[i1] = replaces[i1]; 
			}
			
			int index = 0;
			
			/*
			 * 多出部分以'/'替代
			 */
			for(int k=i + findIndex; k<newReplaces.length; k++){
				
				if(k < i + findIndex + range){
					
					for(int j=i+index+findIndex; j<newReplaces.length - 1; j++){
						newReplaces[j+1] = replaces[j-range+1];
					}
					newReplaces[i+index+findIndex] = '/';
					index ++;
				}
				
			}
			for(int j=i; j<i+range; j++){
				newReplaces[j] = '/';
			}
			
			System.out.println("扩容成功后的字符串 : " + String.valueOf(newReplaces));
		
			return newReplaces;
			
			
		}
		
		/**
		 * 清理'/'字符串
		 * @param replaces 
		 * @param range 
		 * @return
		 */
		private static String cleanChars(char[] replaces,int range){
			
			//采用StringBuilder做操作
			StringBuilder builder = new StringBuilder(String.valueOf(replaces));
			
			//start游标
			int start = -1;
			
			
			// 获取‘／’字符位置
			if(range < 0)
				start = builder.indexOf("/");
			do{
				if(start > 0){
					
					builder.deleteCharAt(start);
					start = builder.indexOf("/");	
				}
				
			}while(start != -1);
			
			//System.out.println("builder : " + builder.toString());
			
			return builder.toString();
		}
		
		/**
		 * 对原始字符进行匹配字符串操作,返回正则对象
		 * @param newString 
		 * @param replaceString 
		 * @return match 
		 */
		private static Matcher find(String newString, String replaceString) {
	
			Matcher match = Pattern.compile(newString).matcher(replaceString);
	
			return match;
	
		}
	
	}
