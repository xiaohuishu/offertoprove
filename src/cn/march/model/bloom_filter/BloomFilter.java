	


	package cn.march.model.bloom_filter;
	
	
	
	import java.util.*;
	
	public class BloomFilter {
	
	    //布隆过滤器的比特长度
	    private static final int DEFAULT_SIZE = 2<<24; 
		
	
	    //选取质数，能很好的降低错误率
	    private static final int[] seeds = {3,5,7,11,13,31,37,61};
	
	    private static BitSet bits = new BitSet(DEFAULT_SIZE);
		
	    //初始化一个哈希类数组
	    private static SimpleHash[] func = new SimpleHash[seeds.length];

	    /**
	     * 向BitSet添加一个字符串
	     * @param value
	     */
	    private static void addValue(String value) {
	
	        for(SimpleHash fun : func) {
	
	            bits.set(fun.hash(value), true);
	
	        }
	
	    }
	
	    
	    public static void add(String value) {
	        
	        if(value != null)
	            addValue(value);
	
	    }
	
	    //判断一个字符串是否在BitSet中是否存在
	    public static boolean contains(String value) {
	        
	        if(value == null) 
	            return false;
	
	        boolean ret = true;
	
	        for(SimpleHash f : func)
	            ret = ret && bits.get(f.hash(value));
	
	        return ret;
	
	    }
	
	
	    public static void main(String [] args) {
	        
	        String value = "shuxiaohui1105@gmail.com";
	
	        for(int i = 0; i < seeds.length; i++) {
	
	            func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
	
	        }
	
	        add(value);
	
	        System.out.println(contains(value));
	
	    }
	
	
	
	    /**
	     * 哈希类：
	     * 	 	一个cap容量(2 << 24),即BitSet容量(很大)和选定的一个质数
	     * 		通过对应的String value字符串来计算一个对应的hash值
	     * 
	     * @author antsmarth
	     *
	     */
	    static class SimpleHash {
	      
	    	//容量(DEFAULT_SIZE)
	        private int cap;
	        //质数
	        private int seed;
	
	        public SimpleHash(int cap, int seed) {
	            
	            this.cap = cap;
	            this.seed = seed;
	
	        }
	
	        //计算hash值
	        public int hash(String value) {
	            
	            int result = 0;
	
	            int len = value.length();
	
	            for(int i = 0; i < len; i++) {
	                
	                result = seed * result + value.charAt(i);
	
	            }
	
	            return (cap - 1) & result;
	
	        }
	
	
	    }
	
	
	}
