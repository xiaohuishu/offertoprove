	


	package cn.march.algo.tree;
	
	
	import cn.march.algo.tree.BinaryTree.BinaryNode;
	
	/**
	 * 判断一个树是否是另一个树的子树
	 * @author antsmarth
	 *
	 */
	public class HasSubTree {
	
		/**
		 * 判断subTree树是否是rootNode树的子树
		 * @param rootNode ：根树
		 * @param subNode ：子树
		 * @return
		 */
		public static boolean isSubTree(BinaryNode rootNode, BinaryNode subNode) {
	
			boolean result = false;
	
			//边界处理
			if (rootNode != null || subNode != null) {
	
				//递归遍历根树,找到与子树根结点相同结点
				//找到了,则进行处理
				if (rootNode.getValue() == subNode.getValue()) {
					result = processIsSubTree(rootNode, subNode);
				}
				//左子树中遍历
				if (!result) {
					isSubTree(rootNode.getLeftNode(), subNode);
				}
				//右子树中遍历
				if (!result) {
					isSubTree(rootNode.getRightNode(), subNode);
				}
	
			}
	
			return result;
		}
	
		/**
		 * 具有相同根结点,判断其叶子结点是否相同
		 * 		若相同则直接返回true
		 * 		否则返回false
		 * @param rootNode
		 * @param subNode
		 * @return
		 */
		private static boolean processIsSubTree(BinaryNode rootNode,
				BinaryNode subNode) {
	
			//终止条件就是,知道找到子树的叶子结点
			if (subNode == null)
				return true;
			//若叶子结点不相等返回false;
			if (rootNode.getValue() != subNode.getValue())
				return false;
			
			//递归处理左,右结点;
			return processIsSubTree(rootNode.getLeftNode(), subNode.getLeftNode())
					&& processIsSubTree(rootNode.getRightNode(),
							rootNode.getRightNode());
	
		}
	
	}
