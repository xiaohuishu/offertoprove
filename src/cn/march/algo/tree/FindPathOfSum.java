	




	package cn.march.algo.tree;
	
	
	
	
	import java.util.LinkedList;
	import java.util.Queue;
	
	import cn.march.algo.tree.BinaryTree.BinaryNode;
	
	/**
	 * 在指定二叉树中找到总值为expectSum的路径
	 * @author antsmarth
	 *
	 */
	public class FindPathOfSum {
	
		
		//测试方法
		public static void main(String[] args) {
			
			BinaryTree tree = new BinaryTree();
			// 构建二叉树
			tree.buildBinaryTreeOfPreAndIn(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 },
					new int[] { 4, 7, 2, 1, 5, 3, 8, 6 }, 8);
	
			findPathOfSum(tree.getRootNode(), 14);
			
		}
		
		/**
		 * 在指定二叉树中找到总值为expectSum的路径
		 * @param rootNode
		 * @param expectSum
		 */
		public static void findPathOfSum(BinaryNode rootNode, int expectSum) {
	
			//边界处理
			if (rootNode == null)
				throw new RuntimeException("树为null....");
	
			int currentSum = 0;
	
			//声明一个队列
			Queue<BinaryNode> queues = new LinkedList<BinaryNode>();
			
			//具体实现方法
			implFindPath(rootNode, expectSum, queues, currentSum);
	
		}
	
		/**
		 * 具体实现思路：
		 * 		1.从根结点开始找,首先获取当前根结点的值为currentSum,将其入队
		 * 		2.判断当前结点是否是叶子结点
		 * 			2.1 如果是,则判断currentSum与expectSum值是否相等
		 * 				2.1.1 若相等,直接遍历队列输出Path
		 * 
		 * 		3.如果其左子树不为null,递归调用
		 * 		4.如果其右子树不为null,递归调用
		 * 		5.则证明当前结点不是正确的路径,则直接currentSum减去当前结点的值
		 * 		   并且将当前结点从队列中去除;
		 * 
		 * @param rootNode
		 * @param expectSum
		 * @param queues
		 * @param currentSum
		 */
		private static void implFindPath(BinaryNode rootNode, int expectSum,
				Queue<BinaryNode> queues, int currentSum) {
	
			//累计结点值
			currentSum += rootNode.getValue();
	
			//入队处理
			queues.add(rootNode);
	
			//是否是叶子结点
			boolean isLeaf = rootNode.getLeftNode() == null
					&& rootNode.getRightNode() == null;
	
			//是否匹配
			if(currentSum == expectSum && isLeaf) {
				
				System.out.println("find path : ");
				
				for(BinaryNode node : queues) {
					System.out.print(node.getValue() + " ");
				}
				
			}
			
			//在左子树,右子树匹配
			if(rootNode.getLeftNode() != null)
				implFindPath(rootNode.getLeftNode(), expectSum, queues, currentSum);
			
			if(rootNode.getRightNode() != null)
				implFindPath(rootNode.getRightNode(), expectSum, queues, currentSum);
			
			//不匹配退回上一级匹配
			currentSum -= rootNode.getValue();
			
			queues.poll();
			
		}
	
	}
