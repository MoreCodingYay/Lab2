import java.util.Stack;

class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;

   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      
      if (root == null) {
         return; // return null if root is null
      }

      Stack<Node> stack = new Stack<>(); //Create a stack to store the nodes
      stack.push(root); //push the root node onto the stack

      while (!stack.isEmpty()) {
      //While the stack is not empty
         Node current = stack.pop(); //take the current node from the top of the stack
         System.out.print(current.value + " "); //Print out this value

      
         if (current.right != null) {
         //check if current node's right child has a value
            stack.push(current.right);
            //if it does, push it onto the stack to be processed next
         }

         
         if (current.left != null) {
         //check if current node's left child has a value
            stack.push(current.left);
            //if it does, push it onto the stack to be processed next
         }
      }//end of while loop
      
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      if (root == null) {
      return; //empty return if root Node is null
      }//end of if

      Stack<Node> stack = new Stack<>(); // Create a stack to store the nodes
      Node current = root; //start with the passed in node

      while (current != null || !stack.isEmpty()) {
      //while the current node is not null or the stack is not empty
         while (current != null) {
         //enter a second while loop that deals with the current node not being null
            stack.push(current);
            //push the current node onto the stack
            current = current.left;
            //set current equal to its left node
         }

         current = stack.pop();
         //pop the current node off the stack
         System.out.print(current.value + " ");
         //print this node's value out
         current = current.right;
         //set current equal to its right node
      }//end main while loop
   }//end of inOrderTraversal
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
   
      if (root == null) {
         return; //Base. Return nothing when the root is null
      }

      postOrderTraversal(root.left);
      //call the function recursively on the left subtree

      postOrderTraversal(root.right);
      //call the function recursively on the right subtree

      System.out.print(root.value + " ");
      //print the current node's value
      
   }//end of postOrderTraversal
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  
      if (root == null) {
         return false; //return false if root is null
      }

      while (root != null) {
      //while the root is not null
         if (root.value == key) {
         //check if the root value is equal to that of the key
            return true; //Return true, the node has been found!
         }else if (key < root.value) {
         //if the keyt is less than the root value
            root = root.left; //check the left subtree for the value
         }else {
         //if the key is greater than the current root
            root = root.right; //check the right subtree for the value
         }
      }
      return false; // Return false if key is not found
                
   }//end of find method
   

   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
   }
  

   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
   }
   

   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}//end of Binary Search tree class



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(t1.root,24);
      t1.insert(t1.root,80);
      t1.insert(t1.root,18);
      t1.insert(t1.root,9);
      t1.insert(t1.root,90);
      t1.insert(t1.root,22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  //end of main
}//end of treeDemo