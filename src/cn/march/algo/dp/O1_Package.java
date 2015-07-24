package cn.march.algo.dp;

public class O1_Package {

	public static void main(String[] args) {

		Package pack = new Package(new int[] { 2, 1, 3, 2 }, new int[] { 3, 2,
				4, 2 }, 5);

		System.out.println(t01_PackageDP(0, pack));

		System.out.println(t02_PackageDP(0,new int[] { 2, 1, 3, 2 }, new int[] { 3, 2,
				4, 2 }, 5));
		
	}
	
	public static int t02_PackageDP(int i, int[] weights, int[] values, int j) {
		
		int max_values;

		if (i == weights.length)
			max_values = 0;

		else if (j < weights[i])
			max_values = t02_PackageDP(i + 1,weights, values, j);

		else
			max_values = Math.max(
					t02_PackageDP(i + 1, weights, values, j),
					t02_PackageDP(
							i + 1,
							weights, values, j-weights[i])
							+ values[i]);

		return max_values;

		
	}
	

	public static int t01_PackageDP(int i, Package pack) {

		
		
		
		int max_values;

		if (i == pack.getWeights().length)
			max_values = 0;

		else if (pack.getMax_weight() < pack.getWeights()[i])
			max_values = t01_PackageDP(i + 1, pack);

		else
			max_values = Math.max(
					t01_PackageDP(i + 1, pack),
					t01_PackageDP(
							i + 1,
							pack.setMax_weight(pack.getMax_weight()
									- pack.getWeights()[i]))
							+ pack.getValues()[i]);

		return max_values;
	}

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

			//return this;
		}

	}

}
