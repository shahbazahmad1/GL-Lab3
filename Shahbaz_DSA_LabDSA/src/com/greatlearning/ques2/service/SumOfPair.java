package com.greatlearning.ques2.service;

import java.util.HashSet;

public class SumOfPair 
{
	static class Node
	{
		int data;
		Node left;
		Node right;


		public Node (int data) 
		{
			this.data = data; 
			this.left = this.right = null;
		}

		private static Node insertTreeNode (Node root, int data)
		{
			if ( root == null)
			{
				return new Node(data);
			}
			if (root.data > data)
			{
				root.left = insertTreeNode(root.left, data);
			}
			else
			{
				root.right = insertTreeNode(root.right, data);
			}
			return root;
		}

		private static boolean FindSumPair(Node root,int sum)
		{
			HashSet<Integer> data = new HashSet<Integer>();
			return isPairExists(root,data,sum);
		}

		private static boolean isPairExists(Node root, HashSet<Integer> data, int sum )
		{
			if (root == null)
			{
				return false;
			}

			int comp = sum - root.data;

			if(data.contains(comp))
			{
				System.out.println("Sum = " +sum );
				System.out.println("Pair is (" +comp+ " , " +root.data+ ")");
				return true;
			}
			else
			{ 
				data.add(root.data);
			}

			return isPairExists(root.left, data, sum) || isPairExists(root.right, data, sum);

		}

		public static void main (String [] args)
		{
			Node root = null; 

			root = insertTreeNode(root, 40);
			root = insertTreeNode(root, 20);
			root = insertTreeNode(root, 60);
			root = insertTreeNode(root, 10);
			root = insertTreeNode(root, 30);
			root = insertTreeNode(root, 50);
			root = insertTreeNode(root, 70);

			int sum = 130;
			boolean result = FindSumPair(root,sum);
			if (!result)
			{
				System.out.println("Nodes are not found");
			}
		}
	}
}






