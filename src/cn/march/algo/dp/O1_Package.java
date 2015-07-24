package cn.march.algo.dp;

public class O1_Package {

	public static void main(String[] args) {

		Package pack = new Package(new int[] { 2, 1, 3, 2 }, new int[] { 3, 2,
				4, 2 }, 5);

		System.out.println(t01_PackageDP(0, pack));

	}

	public static int t01_PackageDP(int i, Package pack) {
		
		int max_values;
		
		if(i == pack.weights.length) 
			max_values = 0;
		
		else if(pack.max_weight < pack.weights[i]) 
			max_values = t01_PackageDP(i+1, pack);
		
		else 
			max_values = Math.max(t01_PackageDP(i+1 , pack), t01_PackageDP(i+1,pack.setMax_weight(pack.getMax_weight()-pack.weights[i]))+pack.getValues()[i]);
		
		
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
			this.max_weight = max_weight;
			
			return this;
		}

	}

}
