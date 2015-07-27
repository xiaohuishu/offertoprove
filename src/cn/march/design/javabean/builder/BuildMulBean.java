	



	package cn.march.design.javabean.builder;
	
	
	
	/**
	 * 如果一个Bean(实体类有多个属性)进行赋值,我们很容易想到两种常用的方式:
	 * 		1.通过构造方法进行赋值
	 * 		2.通过JavaBean的方式,为每个属性添加Getter和Setter方法
	 * 
	 * 首先第一种方式,如果属性太多,全集中在一个构造方法中,可读性不好;
	 * 其次通过构造方法,其传入的值说明都是必须的
	 * 
	 * JavaBean则就是直接将属性通过方法暴露给外部,外部我们可以通过setter方法来进行
	 * 赋值,这样是一个主流的写法,但是当参数一多,缺点暴露出来了
	 * 因为我们可以在外部,很容易修改对象的状态
	 * 
	 * 现在我们可以通过另一种方式：
	 * 		
	 * 		3.利用建造者模式
	 * 			3.1 思路：
	 * 					如果有多个参数,我们首先分析出在这些参数中,有哪几个是必须的;
	 * 					然后我们定义一个公开内部类,在内部类构造方法中对必须的属性进行
	 * 					赋值,另外对其他属性提供赋值方法;最后将内部类对象作为参数调用
	 * 					外部类构造方法(定义为私有),进行属性的赋值
	 * 	
	 * 			3.2 最后对象实例化语句如下
	 * 
	 * 				BuildMulBean bean = new BuildMulBean.
	 * 								Builder("arg1","arg2","arg3").
	 * 								mulArgs4("arg4").mulArgs5("arg5")
	 * 								/..../.build();
	 * 				
	 * @author antsmarth
	 *
	 */
	public class BuildMulBean {
	
		// 必需的属性
		private String mulArgs1;
		private String mulArgs2;
		private String mulArgs3;
	
		// 非必要的属性
		private String mulArgs4;
		private String mulArgs5;
		private String mulArgs6;
		private String mulArgs7;
		private String mulArgs8;
	
		//定义一个公开静态内部类,进行属性初始化赋值
		public static class Builder {
	
			// 必须属性
			private final String mulArgs1;
			private final String mulArgs2;
			private final String mulArgs3;
	
			// 非必要的属性
			private String mulArgs4;
			private String mulArgs5;
			private String mulArgs6;
			private String mulArgs7;
			private String mulArgs8;
	
			//通过构造方法对必须的3个属性进行赋值
			public Builder(String mulArgs1, String mulArgs2, String mulArgs3) {
	
				this.mulArgs1 = mulArgs1;
				this.mulArgs2 = mulArgs2;
				this.mulArgs3 = mulArgs3;
	
			}
	
			/*
			 * 对其他非必须属性提供赋值方法;
			 */
			public Builder mulArgs4(String mulArgs4) {
	
				this.mulArgs4 = mulArgs4;
				return this;
	
			}
	
			public Builder mulArgs5(String mulArgs5) {
	
				this.mulArgs5 = mulArgs5;
				return this;
	
			}
	
			public Builder mulArgs6(String mulArgs6) {
	
				this.mulArgs6 = mulArgs6;
				return this;
	
			}
	
			public Builder mulArgs7(String mulArgs7) {
	
				this.mulArgs7 = mulArgs7;
				return this;
	
			}
	
			public Builder mulArgs8(String mulArgs8) {
	
				this.mulArgs8 = mulArgs8;
				return this;
	
			}
			
			/**
			 * 实例化外部类对象,将本身对象传递进行外部属性的初始化赋值
			 * @return
			 */
			public BuildMulBean build() {
				return new BuildMulBean(this);
			}
	
		}
		
		/**
		 * 重写私有构造方法
		 * @param builder
		 */
		private BuildMulBean(Builder builder) {
			
			this.mulArgs1 = builder.mulArgs1;
			this.mulArgs2 = builder.mulArgs2;
			this.mulArgs3 = builder.mulArgs3;
			this.mulArgs4 = builder.mulArgs4;
			this.mulArgs5 = builder.mulArgs5;
			this.mulArgs6 = builder.mulArgs6;
			this.mulArgs7 = builder.mulArgs7;
			this.mulArgs8 = builder.mulArgs8;
			
		}
		
	
		public String getMulArgs1() {
			return mulArgs1;
		}
	
		public String getMulArgs2() {
			return mulArgs2;
		}
	
		public String getMulArgs3() {
			return mulArgs3;
		}
	
		public String getMulArgs4() {
			return mulArgs4;
		}
	
		public String getMulArgs5() {
			return mulArgs5;
		}
	
		public String getMulArgs6() {
			return mulArgs6;
		}
	
		public String getMulArgs7() {
			return mulArgs7;
		}
	
		public String getMulArgs8() {
			return mulArgs8;
		}
	
	}
