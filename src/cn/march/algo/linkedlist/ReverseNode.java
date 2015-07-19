	
	
	
	package cn.march.algo.linkedlist;
	
	import java.util.Stack;
	
	import cn.march.algo.linkedlist.LinkedList.Node;
	
	/**
	 * 翻转单链表测试类
	 * @author antsmarth
	 *
	 */
	public class ReverseNode{
	
	
	    public static void main(String [] args){
	
	    	//建一个链表集合类,并进行赋值初始化处理
	        LinkedList reverseNode = new LinkedList();
	
	        reverseNode.linkFirst("testOriginFirst");
	
	        reverseNode.linkFirst("testFirst");
	
	        reverseNode.linkLast("testOriginLast");
	
	        reverseNode.linkLast("testLast");
	
	        //打印初始链表
	        printLinkTable(reverseNode.getFirstNode());
	        
	        
	        System.out.println("------------------------------");
	        
	        //reverseLinkD(reverseNode.getFirstNode());
	
	        //Node converseNode = convertReverseLinkD(reverseNode.getFirstNode()); 
	        
	        //进行翻转链表处理
	        Node converseNode = convertReverseLink(reverseNode.getFirstNode());
	        
	        //System.out.println(converseNode.getValue());
	        
	        //输出链表
	        printLinkTable(converseNode);
	        
	    }
	    
	    /**
	     * 循环翻转链表
	     * @param firstNode : 头结点
	     * @return
	     */
	    public static Node convertReverseLink(Node firstNode){
	    	
	    	//如果头节点为null,则直接返回头节点
	    	if(null == firstNode)
	    		return firstNode;
	    	
	    	//声明Node变量pre,初始赋值初始头结点,代表上一结点
	    	Node pre = firstNode;
	    	
	    	//声明Node变量cur,初始赋值初始头结点的下一结点,代表当前结点
	    	Node cur = firstNode.getNext();
	    	
	    	//声明Node变量next,初始赋值null,代表下一结点
	    	Node next = null;
	    	
	    	//遍历当前链表
	    	while(cur != null){
	    		
	    		//获取当前结点的下一结点,将其赋值给next
	    		next = cur.getNext();
	    		
	    		//将当前节点的上一结点设置为当前结点的下一节点
	    		cur.setNext(pre);
	    		
	    		//将当前节点赋值给上一节点
	    		pre = cur;
	    		
	    		//移动当前节点到下一节点
	    		cur = next;
	    		
	    	}
	    	
	    	//将父节点下一节点设置为null
	    	firstNode.setNext(null);
	    	
	    	//根节点设置为pre
	    	firstNode = pre;
	    	
	    	return firstNode;
	    	
	    	
	    }
	    
	    /**
	     * 递归翻转链表
	     * @param firstNode
	     * @return
	     */
	    public static Node convertReverseLinkD(Node firstNode){
	    	
	    	//如果链表只有一个节点或者根节点为空,直接返回根节点
	    	if(firstNode == null || firstNode.getNext() == null){
	    		return firstNode;
	    	}
	    	
	    	//递归调用
	    	Node reverseNode = convertReverseLinkD(firstNode.getNext());
	    	
	    	//将当前节点的下一节点设置为其本身
	    	firstNode.getNext().setNext(firstNode);
	    	
	    	//将父节点的下一节点设置为null
	    	firstNode.setNext(null);
	    	
	    	return reverseNode;
	    }
	    
	    
	    /**
	     * 递归逆序输出链表
	     * @param firstNode
	     */
	    public static void reverseLinkD(Node firstNode){
	    	
	    	if(firstNode != null){
	    		
	    		//如果节点的下一节点不为null,继续递归调用
	    		if(firstNode.getNext() != null){
	    			reverseLinkD(firstNode.getNext());
	    		}
	    		
	    		//若为空,直接输出此节点
	    		System.out.println(firstNode.getValue());
	    		
	    	}
	    	
	    }
	    
	    
	    
	    /**
	     * 通过stack,数组作为中间容器,来进行逆序输出
	     * @param firstNode
	     */
	    public static void reverseLink(Node firstNode){
	    	
	    	//创建一个栈对象
	    	Stack<Object> stack = new Stack<Object>();
	    			
	    	Node node = firstNode;
	    	
	    	//遍历链表,将其push到stack中
	    	while(node != null){
	    		    		
	    		stack.push(node);
	    		
	    		node = node.getNext();
	    		
	    	}
	    	
	    	//遍历stack中的数据
	    	while(!stack.isEmpty()){
	    		
	    		Node stackNode = (Node) stack.pop();
	    				
	    		System.out.println(stackNode.getValue());
	    		
	    	}
	    	
	    	
	    }
	
	    /**
	     * 遍历链表
	     * @param firstNode
	     */
	    public static void printLinkTable(Node firstNode){
	    	
	    	Node nowNode = firstNode;
	    	
	    	while(nowNode != null){
	    		
	    		System.out.println(nowNode.getValue());
	    		
	    		nowNode = nowNode.getNext();
	    	}
	    	
	    }
	    
	}
