	


	package cn.march.algo.linkedlist;

	import cn.march.algo.linkedlist.LinkedList.Node;
	
	
	
			
	public class PenulKOfNodes {
		
		/**
		 * 问题：获取链表中倒数第k个结点
		 * 基本思路:
		 * 		n : 链表的结点数
		 * 		k : 倒数第几个结点
		 * 		倒数第k个结点相当于 n-k-1;
		 * 		那我们可以相当于：
		 * 			声明两个新的链表结点对象pAhead,pBehind;
		 * 			首先通过pAhead找到第k个结点
		 * 			之后从pAhead开始遍历链表,直到pAhead下一结点为null(即遍历到尾结点结束)
		 * 			在遍历过程中pBehind从头结点开始遍历;
		 * 			所以之后pBehind就是倒是第k个结点
		 * @param firstNode ： 头结点
		 * @param k ：倒数第k个结点
		 * @return
		 */
		public static Node penilKOfNodes(Node firstNode, int k) {
			
			// 判断头结点是否为null,如果为null或者为""则直接返回为null
			boolean nullFlag = firstNode == null ? true
					: (firstNode.getValue() == null ? true : (firstNode.getValue()
							.equals("") ? true : false));
			
			if(nullFlag){
				return null;
			}
			
			//声明2个链表结点引用,第一个结点将头结点赋值给它,第二个结点赋值为null
			Node aheadNode = firstNode;
			
			Node behindNode = null;
			
			//先找到链表中第k个结点
			for(int i=0; i<k-1; i++){
				
				if(aheadNode.getNext() != null){
					aheadNode = aheadNode.getNext();
				}else{
					return null;
				}
			}
			
			//将第二个链表结点引用,初始化头结点
			behindNode = firstNode;
			
			//从第k个结点开始遍历链表,这时behind向前移动,直到链表尾结点,这时候behind就是倒数第k个结点
			while(aheadNode.getNext() != null){
				
				aheadNode = aheadNode.getNext();
				
				behindNode = behindNode.getNext();
				
			}
			
			return behindNode;
		
		}
		
		//测试主方法
		public static void main(String[] args) {
			
	    	//建一个链表集合类,并进行赋值初始化处理
	        LinkedList reverseNode = new LinkedList();
	
	        reverseNode.linkFirst("testOriginFirst");
	
	        reverseNode.linkFirst("testFirst");
	
	        reverseNode.linkLast("testOriginLast");
	
	        reverseNode.linkLast("testLast");
	
	        //打印初始链表
	        ReverseNode.printLinkTable(reverseNode.getFirstNode());
	        
	        System.out.println("------------------------------");
			
	        
	        System.out.println("倒数第3个结点： " + penilKOfNodes(reverseNode.getFirstNode(), 3).getValue());
	        
	        
		}
		
	}
