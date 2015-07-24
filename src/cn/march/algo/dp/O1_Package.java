	


	package cn.march.algo.dp;
	
	
	
	/**
	 * O-1背包问题
	 * @author antsmarth
	 *
	 */
	public class O1_Package {
	
		//测试主方法
		public static void main(String[] args) {
	
			Package pack = new Package(new int[] { 2, 1, 3, 2 }, new int[] { 3, 2,
					4, 2 }, 5);
	
			System.out.println(t01_PackageDP(0, pack , 5));
	
	
		}
	
	
		/**
		 * 0-1背包问题(分治法) 
		 * @param i 
		 * @param pack
		 * @param max_weight
		 * @return
		 */
		public static int t01_PackageDP(int i, Package pack, int max_weight) {
	
			int max_values;
			
			//边界处理
			if (i == pack.getWeights().length)
				max_values = 0;
	
			//如果当前背包位置有超过允许最大重量的,直接访问下一个
			else if (max_weight < pack.getWeights()[i])
				max_values = t01_PackageDP(i + 1, pack, max_weight);
	
			else
				max_values = Math.max(
						t01_PackageDP(i + 1, pack, max_weight),
						t01_PackageDP(i + 1, pack,
								max_weight - pack.getWeights()[i])
								+ pack.getValues()[i]);
	
			return max_values;
		}
		
		/**
		 * 背包实体类
		 * @author antsmarth
		 *
		 */
		static class Package {
	
			private int[] weights;
	
			private int[] values;
	
			private int max_weight;
	
			public Package(int[] weights, int[] values, int max_weight) {
	
				this.weights = weights;
				this.values = values;
				this.max_weight = max_weight;
	
			}
	
			public int[] getWeights() {
				return this.weights;
			}
	
			public int[] getValues() {
				return this.values;
			}
	
			public int getMax_weight() {
				return this.max_weight;
			}
	
			public Package setMax_weight(int max_weight) {
	
				return new Package(this.weights, this.values, max_weight);
	
				// return this;
			}
	
		}
	
	}
