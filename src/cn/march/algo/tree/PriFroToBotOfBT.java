	

	package cn.march.algo.tree;
	
	
	
	
	
	import java.util.LinkedList;
	import java.util.Queue;
	
	import cn.march.algo.tree.BinaryTree.BinaryNode;
	
	
	/**
	 * 从根结点开始从上到下依次输出二叉树
	 * @author antsmarth
	 *
	 */
	public class PriFroToBotOfBT {
	
		
		
		/**
		 * 从上到下依次输出二叉树
		 * @param node ： 根结点
		 */
		public static void printFroToBotOfBT(BinaryNode node) {
			
			//边界处理
			if(node == null) 
				throw new RuntimeException("树为null...");
			
			//若只有一个结点,直接输出根结点,结束;
			if(node.getLeftNode() == null && node.getRightNode() == null){
				System.out.println(node.getValue());
				return ;
			}
			
			//创建一个队列作为存储容器
			Queue<BinaryNode> queues = new LinkedList<BinaryNode>();
			
			//首先将根结点入队
			queues.add(node);
			
			//循环队列
			while(queues.size() > 0) {
				
				//出队
				BinaryNode q_node = queues.poll();
				
				System.out.print(q_node.getValue() + " ");
				
				//如果出队的结点左右子树不为null,其左右结点进行入队;
				if(q_node.getLeftNode() != null)
					queues.add(q_node.getLeftNode());
				
				if(q_node.getRightNode() != null)
					queues.add(q_node.getRightNode());
			}
			
			
		}
		
	}
