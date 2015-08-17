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

	public static void main(String[] args) {

		int[] arrays = new int[]{1, 2, 4, 7, 11, 15};
		
		findTwoCountSunOfCycl(arrays, arrays.length, 15);
		
	}

	private static void findTwoCountSunOfCycl(int[] arrays, int length, int sum) {

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

}
