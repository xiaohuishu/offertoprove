

package cn.march.algo.string;



/**
 * 替换' '字符
 * @author antsmarth
 *
 */
public class InsteadOfNullString {


	public static void main(String[] args) {
		
		insteadOfNullString("s h u", "%");
		
	}
	
	/**
	 * 替代空字符串,O(n)解法
	 * 基本思路:
	 * 		1.首先统计出原始字符串中' '字符的个数
	 * 		2.通过替代字符串的长度结合' '字符的数量,创建替代完成后字符串的长度;
	 * 		3.利用2个游标都分别指向: 原始字符串的最后一个字符,新字符串的最后一个字符
	 * 		4.开始从原始字符串游标进行扫描：
	 * 			如果原始字符串游标指向的字符为空:
	 * 				将替代字符 替换 新字符串对应游标的几个几个字符
	 * 			如果不为空：
	 * 				复制字符
	 * 			游标移至前一个位置
	 * @param initString : 原始字符串
	 * @param insteadString : 替代字符串
	 */
	public static void insteadOfNullString(String initString, String insteadString) {
		
		//先转换成char数组
		char[] insteadChars = insteadString.toCharArray();

		char[] initChars = initString.toCharArray();

		int nullSize = 0;
		
		//统计字符串中' '字符的个数 
		for (int i = 0; i < initChars.length; i++) {
			if (initChars[i] == ' ') {
				nullSize++;
			}
		}
		//创建新字符数组;
		char[] newChars = new char[nullSize * insteadChars.length + initChars.length - nullSize];

		System.out.println(newChars.length);
		
		int originIndex = initChars.length - 1;

		int newIndex = newChars.length - 1;

		//进行扫描
		while (originIndex >= 0 && newIndex >= originIndex) {	

			if (initChars[originIndex] == ' ') {
				
				for(int i = 0; i< insteadChars.length; i++){
					newChars[newIndex--] = insteadChars[i];
				}
				/*
				newChars[newIndex--] = '0';
				newChars[newIndex--] = '2';
				newChars[newIndex--] = '%';*/
			} else {
				newChars[newIndex--] = initChars[originIndex];
			}

			originIndex--;
		}

		System.out.println(String.valueOf(newChars));
	}

}
