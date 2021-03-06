

	package cn.march.algo.tree;
	
	
	import java.util.Stack;
	
	/**
	 * 二叉树实现类
	 * 
	 * @author antsmarth
	 *
	 */
	public class BinaryTree {
	
		/**
		 * 测试主方法
		 * 
		 * @param args
		 */
		public static void main(String[] args) {
	
			BinaryTree tree = new BinaryTree();
			// 构建二叉树
			tree.buildBinaryTreeOfPreAndIn(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 },
					new int[] { 4, 7, 2, 1, 5, 3, 8, 6 }, 8);
	
			System.out.println("前序遍历: ");
			tree.preOrder(tree.getRootNode());
			System.out.println();
			System.out.println("-------------");
			System.out.println("中序遍历: ");
			tree.inOrder(tree.getRootNode());
			System.out.println();
			System.out.println("-------------");
			System.out.println("后序遍历: ");
			tree.afterOrder(tree.getRootNode());
	
			System.out.println();
			System.out.println("-------------");
			System.out.println("结点数量: " + tree.getSize(false));
	
			System.out.println("-------------");
			System.out.println("二叉树高度: " + tree.getHeight());
	
			System.out.println("--------------");
	
			System.out.println("非递归遍历: ");
			System.out.println("前序：");
			tree.preOrderByNonRecursive(tree.getRootNode());
			System.out.println();
			System.out.println("中序");
			tree.inOrderByNonRecursive(tree.getRootNode());
			System.out.println();
			System.out.println("后序");
			tree.afterOrderByNonRecursive(tree.getRootNode());
	
			System.out.println();
			System.out.println("------------");
	
			System.out.println("树的镜像:");	
			tree.preOrderByNonRecursive(tree.getMirrorRec(tree.getRootNode()));
			
			System.out.println();
			System.out.println("-------------");
			
			System.out.println("从根结点开始从上到下依次输出:");
			PriFroToBotOfBT.printFroToBotOfBT(tree.getRootNode());
			
			System.out.println();
			System.out.println("二叉搜索树的验证,传入后序数组：5,7,6,9,11,10,12,8 结果:");
			System.out.println(tree.verifyAfterArrayBST(new int[]{5,7,6,9,11,10,12,8}, 0, 8));
			
		}
	
		// 根结点
		private BinaryNode rootNode;
		// 树中结点数量
		private int size;
		// 树的高度
		@SuppressWarnings("unused")
		private int height;
	
		
		
		
		
		/**
		 * 通过一个树的后序遍历数组,判断其是不是二叉搜索树
		 * 基本思路：
		 * 		后序遍历数组的特点就是数组最后一个元素就是根结点值
		 * 		而二叉搜索树
		 * 		1.做边界判断处理,抛出异常
		 * 		2.获取根结点值,找到小于结点值与大于结点值的边界游标
		 * 		3.以计算的游标开始遍历数组,如果其中中小于根结点的元素直接返回false;
		 *		4.开始递归对左右子树中的结点进行判断
		 *
		 * @param afterOrder
		 * @param start
		 * @param length
		 * @return
		 */
		public Boolean verifyAfterArrayBST(int [] afterOrder, int start,  int length) {
			
			//边界处理
			if(afterOrder == null || length == 0)
				throw new RuntimeException("传入的后序数组不能为null....");
			
			if(start < 0 || length > afterOrder.length) 
				throw new RuntimeException("传入的起始,结束游标不合法...");
			
			/*
			if(afterOrder.length == 1 && length == 1)
				return true;*/
			
			//拿到根结点
			int rootValue = afterOrder[length-1];
			
			int i = start;
			
			//找到边界游标
			for( ; i < length-1; i++) {
				
				
				if(afterOrder[i] > rootValue)
					break;
			
			}

			
			int j = i;
			
			//判断游标之后是否有小于根结点的元素
			for( ; j < length-1; ++j) {
								
				if(afterOrder[j] < rootValue)
					return false;
			
			}	
			
			Boolean flagLeft = true;
			
			//递归,验证左子树
			if(i > 0) {
				
				flagLeft = verifyAfterArrayBST(afterOrder, start, i);
				
			}
			
			Boolean flagRight = true;
			
			//递归,验证右子树
			if(j < length-1) 
				flagRight = verifyAfterArrayBST(afterOrder, length-i-1, length-1);
			
			
			
			return flagLeft && flagRight;
			
		}
		
		
		/**
		 * 获取指定的镜像,封装其细节
		 * 
		 * @param rootNode
		 * @return
		 */
		public BinaryNode getMirrorRec(BinaryNode rootNode) {
	
			BinaryNode temp = copyTree(rootNode);
	
			mirrorRecurse(temp);
	
			return temp;
	
		}
	
		/**
		 * 复制一个二叉树
		 * @param rootNode
		 * @return
		 */
		public BinaryNode copyTree(BinaryNode rootNode) {
			
			//边界判断
			if (rootNode == null)
				throw new RuntimeException("请传入不为null的树!");
			
			//获取当前结点
			BinaryNode copyNode = new BinaryNode(null, rootNode.getValue(), null);
			//设置左右结点
			copyNode.setLeftNode(rootNode.getLeftNode());
			copyNode.setRightNode(rootNode.getRightNode());
	
			//递归：左子树，右子树
			if (rootNode.getLeftNode() != null)
				copyTree(rootNode.getLeftNode());
	
			if (rootNode.getRightNode() != null)
				copyTree(rootNode.getRightNode());
	
			return copyNode;
		}
	
		/**
		 * 转换指定树的镜像,实现细节
		 * 
		 * @param rootNode
		 */
		private void mirrorRecurse(BinaryNode rootNode) {
	
			// 边界处理
			boolean flag = rootNode == null ? true
					: (rootNode.getLeftNode() == null ? true : (rootNode
							.getRightNode() == null ? true : false));
	
			if (flag)
				return ;
	
			// 交换左右子树结点
			BinaryNode tempNode = rootNode.getLeftNode();
	
			rootNode.setLeftNode(rootNode.getRightNode());
			rootNode.setRightNode(tempNode);
	
			if (rootNode.getLeftNode() != null)
				mirrorRecurse(rootNode.getLeftNode());
	
			if (rootNode.getRightNode() != null)
				mirrorRecurse(rootNode.getRightNode());
	
		}
	
		/**
		 * 计算二叉树结点数量
		 * 
		 * @param rootNode
		 * @return
		 */
		private int size(BinaryNode rootNode) {
	
			if (rootNode == null)
				return 0;
				
			return 1 + size(rootNode.getLeftNode()) + size(rootNode.getRightNode());
	
		}
	
		/**
		 * 计算二叉树高度
		 * 
		 * @param rootNode
		 * @return
		 */
		private int height(BinaryNode rootNode) {
	
			if (rootNode == null)
				return 0;
			
			int i = height(rootNode.getLeftNode());
			int j = height(rootNode.getRightNode());
	
			return i < j ? j + 1 : i + 1;
		}
	
		/**
		 * 删除二叉树的某个结点,当删除这个结点时(其左子树,右子树也需要删除)
		 * 
		 * @param elementNode
		 */
		public void destroy(BinaryNode elementNode) {
	
			if (elementNode != null) {
				// 删除对应的左子树
				destroy(elementNode.getLeftNode());
				// 删除对应的右子树
				destroy(elementNode.getRightNode());
	
				elementNode = null;
	
			}
	
		}
	
		/**
		 * 返回指定结点的双亲结点
		 * 
		 * @param elementNode
		 * @return
		 */
		public BinaryNode parent(BinaryNode elementNode) {
			return (rootNode == null || rootNode == elementNode) ? null : parent(
					rootNode, elementNode);
		}
	
		/**
		 * 实现细节: 递归查找(左子树,右子树)
		 * 
		 * @param rootNode
		 * @param elementNode
		 * @return
		 */
		private BinaryNode parent(BinaryNode rootNode, BinaryNode elementNode) {
	
			if (rootNode.getLeftNode() == elementNode
					|| rootNode.getRightNode() == elementNode) {
				return rootNode;
			}
	
			BinaryNode tempNode = null;
	
			if ((tempNode = parent(rootNode.getLeftNode(), elementNode)) != null)
				return tempNode;
	
			return parent(rootNode.getRightNode(), elementNode);
	
		}
	
		/**
		 * 提供给外部的方法(封装了实现过程): 通过前序,中序遍历数组构建二叉树
		 * 
		 * @param preorder
		 * @param inorder
		 * @param length
		 */
		public void buildBinaryTreeOfPreAndIn(int[] preorder, int[] inorder,
				int length) {
	
			this.setRootNode(constructBinaryOfArray(preorder, inorder, length));
	
			this.setSize(length);
		}
	
		/**
		 * 前序遍历(递归实现)
		 * 
		 * @param node
		 */
		public void preOrder(BinaryNode node) {
	
			if (node != null) {
				System.out.print(node.getValue() + " ");
				preOrder(node.getLeftNode());
				preOrder(node.getRightNode());
			}
	
		}
	
		/**
		 * 前序遍历(非递归实现) 思路：利用一个栈来存储结点 若存在左子树,进行入栈打印操作 若栈非空,顶部结点出栈,获取右结点
		 * 
		 * @param node
		 */
		public void preOrderByNonRecursive(BinaryNode p) {
			
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			BinaryNode node = p;
			while (node != null || stack.size() > 0) {
				// 存在左子树
				while (node != null) {
	
					stack.push(node);
					System.out.print(node.getValue() + " ");
					node = node.getLeftNode();
	
				}
				// 栈非空
				if (stack.size() > 0) {
	
					node = stack.pop();
					node = node.getRightNode();
	
				}
			}
		}
	
		/**
		 * 中序遍历非递归实现 思路：参考前序遍历
		 * 
		 * @param p
		 */
		public void inOrderByNonRecursive(BinaryNode p) {
	
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
	
			BinaryNode node = p;
	
			while (node != null || stack.size() > 0) {
				// 存在左子树
				while (node != null) {
	
					stack.push(node);
					node = node.getLeftNode();
	
				}
				// 栈非空
				if (stack.size() > 0) {
	
					node = stack.pop();
					System.out.print(node.getValue() + " ");
					node = node.getRightNode();
	
				}
			}
		}
	
		/**
		 * 后序遍历非递归实现
		 * 
		 * @param p
		 */
		public void afterOrderByNonRecursive(BinaryNode p) {
			
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
	
			BinaryNode node = p;
	
			while (p != null) {
				// 左子树入栈
				for (; p.getLeftNode() != null; p = p.getLeftNode()) {
					stack.push(p);
				}
				// 当前结点无右子树或右子树已经输出
				while (p.getRightNode() == null || p.getRightNode() == node) {
					System.out.print(p.getValue() + " ");
					// 纪录上一个已输出结点
					node = p;
	
					if (stack.empty())
						return;
	
					p = stack.pop();
	
				}
	
				// 处理右子树
				stack.push(p);
	
				p = p.getRightNode();
			}
		}
	
		/**
		 * 中序遍历
		 * 
		 * @param root
		 */
		public void inOrder(BinaryNode root)
		/* 中序遍历二叉树, root为指向二叉树(或某一子树)根结点的指针 */
		{
			if (root != null) {
				inOrder(root.getLeftNode()); /* 中序遍历左子树 */
				System.out.print(root.getValue() + " "); /* 访问根结点 */
				inOrder(root.getRightNode()); /* 中序遍历右子树 */
			}
			
		}
	
		/**
		 * 后序遍历二叉树
		 * 
		 * @param node
		 */
		public void afterOrder(BinaryNode node) {
			
			if (node != null) {
				
				inOrder(node.getLeftNode()); /* 后序遍历左子树 */
				inOrder(node.getRightNode()); /* 后序遍历右子树 */
				System.out.print(node.getValue() + " "); /* 访问根结点 */
			
			}
			
		}
	
		/**
		 * 构建二叉树(通过前序遍历数组,中序遍历数组进行构建)
		 * 
		 * @param preorder
		 *            : 前序数组
		 * @param inorder
		 *            : 中序数组
		 * @param length
		 *            : 结点数量
		 */
		private BinaryNode constructBinaryOfArray(int[] preorder, int[] inorder,
				int length) {
	
			// 通过三目运算符来对传入的前序,中序数组进行null判断
			boolean flag = preorder == null ? true : (inorder == null ? true
					: (length == 0 ? true : false));
	
			if (flag) 
				throw new RuntimeException("传入的前序,中序数组为null,或者长度为0...");
			
	
			// 开始以前序,中序数组来进行构建二叉树
			return constructBinaryOfArray(preorder, 0, length - 1, inorder, 0,
					length - 1);
	
		}
	
		/**
		 * 以前序,中序数组来进行构建二叉树 基本思路： 
		 * 		1.通过前序数组我们可以得到该二叉树的根结点
		 * 		2.通过中序数组(结合1得到的根结点)我们可以划分左子树的结点区域和右子树的结点区域
		 * 		3.分别统计计算左子树,右子树在前序，中序数组中的界限(划分游标) 
		 * 		4.分别递归调用开始构建根结点的右子树和左子树
		 * 
		 * @param preorder
		 *            ： 前序遍历数组
		 * @param startPreorder
		 *            ：前序数组开始游标
		 * @param endPreorder
		 *            : 前序数组结束游标
		 * @param inorder
		 *            ：中序遍历数组
		 * @param startInorder
		 *            ：中序数组开始游标
		 * @param endInorder
		 *            ：中序数组结束游标
		 * @return BinaryNode rootNode 构建完成的二叉树根结点
		 */
		private BinaryNode constructBinaryOfArray(int[] preorder,
				int startPreorder, int endPreorder, int[] inorder,
				int startInorder, int endInorder) {
	
			// 对传入的前序,中序数组进行边界判断处理
			if (startPreorder > endPreorder || startPreorder > preorder.length - 1) 
				throw new RuntimeException("前序,中序数组游标边界错误...");		
	
			// 前序数组起始一个元素就是根结点的值
			int rootValue = preorder[startPreorder];
	
			// 构造根结点对象
			BinaryNode rootNode = new BinaryNode(null, rootValue, null);
	
			// 如果前序或者中序数组只有一个元素直接返回根结点
			if (preorder.length == 1 || inorder.length == 1) {
				return rootNode;
			}
	
			// 在中序遍历数组中查找根结点的位置,返回对应的位置;
			int leftLength = findNodeValueIndex(inorder, rootValue);
	
			// 计算左子树的结点个数
			int leftPreorderEnd = leftLength - startInorder;
			// 计算在前序遍历数组中右子树结点的起始位置
			int leftPreorderEndOfRight = startPreorder + leftPreorderEnd;
	
			// 如果左子树的结点个数大于0,则开始构造左子树
			if (leftPreorderEnd > 0) {
	
				/*
				 * 递归调用,在前序数组中计算得到了左子树的区域: 
				 * 		(startPreorder + 1 -----  leftPreorderEndOfRight) 
				 * 在中序数组中计算得到了左子树的区域：
				 * 		(startInorder,leftLength - 1)
				 */
				rootNode.setLeftNode(constructBinaryOfArray(preorder,
						startPreorder + 1, leftPreorderEndOfRight, inorder,
						startInorder, leftLength - 1));
				// leftNode1 =
			}
			// 构造右子树,如果数组中存在右子树
			if (leftPreorderEnd < endPreorder - startPreorder) {
	
				/*
				 * 递归调用,在前序数组中计算得到了右子树的区域： 
				 * 		(leftPreorderEndOfRight + 1 ------ endPreorder) 
				 * 在中序数组中计算得到了右子树的区域： 
				 * 		(leftLength + 1 ------- endInorder)
				 */
				rootNode.setRightNode(constructBinaryOfArray(preorder,
						leftPreorderEndOfRight + 1, endPreorder, inorder,
						leftLength + 1, endInorder));
	
			}
			// 返回根结点
			return rootNode;
		}
	
		/**
		 * 查找结点在中序数组中的位置;
		 * 
		 * @param inorder
		 *            ： 中序数组
		 * @param rootValue
		 *            ：结点值
		 * @return inRootIndex
		 */
		private int findNodeValueIndex(int[] inorder, int rootValue) {
	
			int inRootIndex = 0;
	
			for (int i = 0; i < inorder.length; i++) {
	
				if (inorder[i] == rootValue) {
	
					inRootIndex = i;
	
					break;
	
				}
			}
	
			return inRootIndex;
	
		}
	
		/*
		 * 对root结点,树结点数量提供getter,setter方法
		 */
		public BinaryNode getRootNode() {
			return rootNode;
		}
	
		public void setRootNode(BinaryNode rootNode) {
			this.rootNode = rootNode;
		}
	
		// isBuilder代表是否是直接通过数组构建二叉树
		public int getSize(boolean isBuilder) {
			if (isBuilder) {
				return size;
			}
	
			return size(rootNode);
		}
	
		private void setSize(int size) {
			this.size = size;
		}
	
		public int getHeight() {
			return height(rootNode);
		}
	
		/**
		 * 二叉树数据结构
		 * 
		 * @author antsmarth
		 *
		 */
		static class BinaryNode {
	
			// 结点值
			private int value;
			// 左结点
			private BinaryNode leftNode;
			// 右结点
			private BinaryNode rightNode;
	
			// 构造方法初始化
			public BinaryNode(BinaryNode left, int value, BinaryNode right) {
				this.leftNode = left;
				this.value = value;
				this.rightNode = right;
			}
	
			// 供外部访问结点属性
			public int getValue() {
				return value;
			}
	
			public BinaryNode getLeftNode() {
				return leftNode;
			}
	
			public BinaryNode getRightNode() {
				return rightNode;
			}
	
			public void setValue(int value) {
				this.value = value;
			}
	
			public void setLeftNode(BinaryNode leftNode) {
				this.leftNode = leftNode;
			}
	
			public void setRightNode(BinaryNode rightNode) {
				this.rightNode = rightNode;
			}
	
		}
	
	}
