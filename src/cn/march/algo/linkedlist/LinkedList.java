	
	
	package cn.march.algo.linkedlist;
	
	
	
	
	/**
	 * 单链表集合
	 * @author antsmarth
	 *
	 */
	public class LinkedList{
	
	
		//首节点
	    private Node first;
	    //尾节点
	    private Node last;
	    //节点数量
	    private int size;
	
	
	
	
	    /**
	     * 向头部添加节点
	     * @param e
	     */
	    public void linkFirst(Object e){
	        final Node f = first;
	
	        final Node newNode = new Node(e , f);
	
	        first = newNode;
	
	        if(f == null){
	            last = newNode;
	        }
	        
	        size++;
	
	    }
	
	    /**
	     * 向尾部添加节点
	     * @param e
	     */
	    void linkLast(Object e){
	
	        final Node l = last;
	
	        final Node newNode = new Node(e, null);
	
	        last = newNode;
	        
	        if(last == null){
	            first = newNode;
	        }
	
	        l.setNext(newNode);
	        
	        size++;
	
	    }
	
	    //获取头节点
	    public Node getFirstNode(){
	
	        return this.first;
	    }
	    //获取尾节点
	    public Node getLastNode(){
	        return this.last;
	    }
	
	    public int getSize(){
	
	        return this.size;
	    }
	
	
	    /**
	     * 单链表数据结构
	     * @author antsmarth
	     *
	     */
	    public static class Node{
	
	        private Object value;
	
	        private Node next;
	
	
	        public Node(Object value, Node next){
	
	            this.value = value;
	            this.next = next;
	
	        }
	
	        public Object getValue(){
	            return this.value;
	        }
	
	        public Node getNext(){
	
	            return this.next;
	        }
	        
	        public void setNext(Node next){
	        	
	        	this.next = next;
	        }
	        
	    }
	
	
	}
