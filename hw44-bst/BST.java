// Johnny Wong
// APCS2 pd1
// HW44 -- Prune Your Tree
// 2018-05-03

/*****************************************************
* class BST
* Implementation of the BINARY SEARCH TREE abstract data type (ADT)
*
* A BST maintains the invariant that, for any node N with value V,
* L<V && V<R, where L and R are node values in N's left and right
* subtrees, respectively.
* (Any value in a node's left subtree must be less than its value,
*  and any value in its right subtree must be greater.)
* This BST only holds ints (its nodes have int cargo)
*****************************************************/

public class BST
{

     //instance variables / attributes of a BST:
     TreeNode _root;

     /*****************************************************
     * default constructor
     *****************************************************/
     BST( )
     {
          _root = null;
     }


     /*****************************************************
     * void insert( int )
     * Adds a new data element to tree.
     *****************************************************/
     public void insert( int newVal )
     {
          TreeNode newNode = new TreeNode( newVal );

          if ( _root == null ) {
               _root = newNode;
               return;
          }
          insert( _root, newNode );
     }
     //recursive helper for insert(int)
     public void insert( TreeNode stRoot, TreeNode newNode )
     {
          if ( newNode.getValue() < stRoot.getValue() ) {
               //if no left child, make newNode the left child
               if ( stRoot.getLeft() == null )
               stRoot.setLeft( newNode );
               else //recurse down left subtree
               insert( stRoot.getLeft(), newNode );
               return;
          }
          else { // new val >= curr, so look down right subtree
               //if no right child, make newNode the right child
               if ( stRoot.getRight() == null )
               stRoot.setRight( newNode );
               else //recurse down right subtree
               insert( stRoot.getRight(), newNode );
               return;
          }
     }//end insert()




     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

     // each traversal should simply print to standard out
     // the nodes visited, in order

     //process root, recurse left, recurse right
     public void preOrderTrav()
     {
          preOrderTrav( _root );
     }
     public void preOrderTrav( TreeNode currNode )
     {
          if ( currNode == null ) //stepped beyond leaf
          return;
          System.out.print( currNode.getValue() + " " );
          preOrderTrav( currNode.getLeft() );
          preOrderTrav( currNode.getRight() );
     }

     //recurse left, process root, recurse right
     public void inOrderTrav()
     {
          inOrderTrav( _root );
     }
     public void inOrderTrav( TreeNode currNode )
     {
          if ( currNode == null ) //stepped beyond leaf
          return;
          inOrderTrav( currNode.getLeft() );
          System.out.print( currNode.getValue() + " " );
          inOrderTrav( currNode.getRight() );
     }

     //recurse left, recurse right, process root
     public void postOrderTrav()
     {
          postOrderTrav( _root );
     }
     public void postOrderTrav( TreeNode currNode )
     {
          if ( currNode == null ) //stepped beyond leaf
          return;
          postOrderTrav( currNode.getLeft() );
          postOrderTrav( currNode.getRight() );
          System.out.print( currNode.getValue() + " "  );
     }

     //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


     /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
     TreeNode search( int target )
     {
          return search(target, _root);
     }
     // recursive helper for search(int)
     TreeNode search( int target, TreeNode currNode)
     {
          // check if there is a root or if the currNode contains target
          if (currNode == null || currNode.getValue() == target){
               return currNode;
          }
          // compare target to currNode to decide if search should
          // traverse left
          else if (target < currNode.getValue()){
               return search(target, currNode.getLeft());
          }
          // otherwise traverse right
          else {
               return search(target, currNode.getRight());
          }
     }


     /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
     public int height()
     {
          return height(_root);
     }
     // recursive helper for height()
     public int height( TreeNode currNode)
     {
          if (currNode == null){
               return 0;
          }
          // case if _root is a leaf
          if (isLeaf(currNode)){
               return 1;
          }
          // height starts at 1
          // add to height of root the height of the deepest subtree
          return 1 + Math.max(height(currNode.getLeft()),
                              height(currNode.getRight()));

     }

     /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
     public int numLeaves()
     {
          return numLeaves(_root);
     }
     // recursive helper for numLeaves()
     public int numLeaves( TreeNode currNode)
     {
          // check if currNode is a TreeNode
          if (currNode == null){
               return 0;
          }
          int leafCount = 0;
          if (isLeaf(currNode)){
               leafCount = 1;
          }
          return leafCount + numLeaves(currNode.getLeft()) + numLeaves(currNode.getRight());

     }
     /*****************************************************
     * TreeNode remove()
     * if value to be removed is present, remove it from BST
     *****************************************************/
     public TreeNode remove(int val)
     {
          // piggybacking to get back to a node in the tree
          // if traversal had gone astray
          TreeNode leader = _root;
          TreeNode follower = null;

          // walk leader to target value while follower trails
          while(leader != null){
               // val is less than leader
               if (val < leader.getValue()){
                    if (leader.getLeft() == null){
                         break;
                    }
                    else{
                         follower = leader;
                         leader = leader.getLeft();
                    }
               }
               // val is greater than leader
               else if (val > leader.getValue()){
                    if (leader.getRight() == null){
                         break;
                    }
                    else{
                         follower = leader;
                         leader = leader.getRight();
                    }
               }
               //  leader contains val
               else{
                    break;
               }
          }

          // Case 1 -- node to be removed is a leaf
          // point parent to null

          if (isLeaf(leader)){
               // 1 node tree
               if (height() == 1){
                    leader = null;
               }
               // node is a left child
               else if (follower.getLeft().getValue() == val){
                    follower.setLeft(null);
               }
               // node is a right child
               else{
                    follower.setRight(null);
               }
          }

          // Case 2 -- node to be removed has 1 child
          // replace node with child
          else if (leader.getRight() == null){ // has left child
               // removal node is _root
               if (leader == _root){
                    _root = leader.getLeft();
               }
               // removal node is left child
               else if (follower.getLeft() == leader){
                    follower.setLeft(leader.getLeft());
               }
               // removal node is right child
               else if (follower.getRight() == leader){
                    follower.setRight(leader.getLeft());
               }
          }
          else if (leader.getLeft() == null){ // has right child
               // removal node is _root
               if (leader == _root){
                    _root = leader.getRight();
               }
               // removal node is left child
               else if (follower.getLeft() == leader){
                    follower.setLeft(leader.getRight());
               }
               // removal node is right child
               else if (follower.getRight() == leader){
                    follower.setRight(leader.getRight());
               }
          }

          // Case 3 -- node to be removed has 2 children
          // overwrite node to be removed with max val of left subtree
          // remove it and promote left child
          // ***This does not function properly *sad face* ***
          else{
               TreeNode maxOfLeftSubtree = leader.getLeft();
               while (maxOfLeftSubtree.getRight() != null){
                    maxOfLeftSubtree = maxOfLeftSubtree.getRight();
               }
               TreeNode tempNode = new TreeNode(maxOfLeftSubtree.getValue());
               tempNode.setLeft(leader.getLeft());
               tempNode.setRight(leader.getRight());
               remove(maxOfLeftSubtree.getValue());
               // removal node is _root
               if (leader == _root){
                    _root = tempNode;
               }
               // removal node is left child
               else if (follower.getRight() == leader){
                    follower.setLeft(tempNode);
               }
               // removal node is right child
               else if (follower.getLeft() == leader){
                    follower.setRight(tempNode);
               }
          }
          return leader;
     } // end of remove()

     /*****************************************************
     * HELPER METHOD
     * boolean isLeaf(TreeNode currNode)
     * returns whether currNode is a leaf
     *****************************************************/
     public boolean isLeaf(TreeNode currNode)
     {
          return (currNode.getLeft() == null && currNode.getRight() == null);
     }


     //main method for testing
     public static void main( String[] args )
     {
          BST arbol = new BST();

          //PROTIP: sketch state of tree after each insertion
          //        ...BEFORE executing these.
          arbol.insert( 4 );
          arbol.insert( 2 );
          arbol.insert( 5 );
          arbol.insert( 6 );
          arbol.insert( 1 );
          arbol.insert( 3 );

          /*
          SKETCH OF arbol
                  4
                /   \
               2     5
              / \      \
            1     3      6

          */

          System.out.println( "\n-----------------------------");
          System.out.println( "pre-order traversal:" );
          arbol.preOrderTrav();

          System.out.println( "\n-----------------------------");
          System.out.println( "in-order traversal:" );
          arbol.inOrderTrav();

          System.out.println( "\n-----------------------------");
          System.out.println( "post-order traversal:" );
          arbol.postOrderTrav();

          System.out.println( "\n-----------------------------");

          System.out.println("arbol is a BST with a height of " + arbol.height());
          System.out.println("\narbol is a BST with " + arbol.numLeaves() + " leaves");
          System.out.println("This TreeNode in arbol contains 5: " + arbol.search(5));

          arbol.remove(3);
          arbol.remove(5);
          arbol.remove(2);
          System.out.println("After removing 3, arbol is a tree with " + arbol.numLeaves() + " leaves");
          System.out.println("After removing 2 and 5, arbol is a tree with height of " + arbol.height());
          arbol.remove(4);
          System.out.println("After removing 4, arbol is a tree with height of " + arbol.height());
          /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
          <<< YOUR NEW TEST CALLS HERE >>>
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
     }

}//end class
