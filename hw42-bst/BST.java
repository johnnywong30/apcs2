// Johnny Wong
// APCS2 pd1
// HW42 -- Algorithm as Data Structure
// 2018-05-01

/*****************************************************
* class BST - v1:partial
* SKELETON
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
          if (_root == null){
               _root = newNode;
               return;
          }
          insert(_root, newNode);
     }
     //recursive helper for insert(int)
     public void insert( TreeNode stRoot, TreeNode newNode )
     {
          // check to see if insert should traverse left subtree
          if (newNode.getValue() < stRoot.getValue()){
               // is there a left child?
               if (stRoot.getLeft() == null){
                    stRoot.setLeft(newNode);
               }
               // if there is, traverse down left subtree
               else{
                    insert(stRoot.getLeft(), newNode);
               }
               return;
          }
          // newNode.getCargo() >= current.getCargo()
          // go down right subtree
          else{
               // is there a right child?
               if (stRoot.getRight() == null){
                    stRoot.setRight(newNode);
               }
               // if there is, traverse down right subtree
               else{
                    insert(stRoot.getRight(), newNode);
               }
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
          if (currNode == null){
               return;
          }
          // process root first
          System.out.print(currNode.getValue() + " ");
          // then process left side of tree
          preOrderTrav(currNode.getLeft());
          // finally process right side of tree
          preOrderTrav(currNode.getRight());
     }

     //recurse left, process root, recurse right
     public void inOrderTrav()
     {
          inOrderTrav(_root);
     }
     public void inOrderTrav( TreeNode currNode )
     {
          if (currNode == null){
               return;
          }
          // process left first
          inOrderTrav(currNode.getLeft());
          // then process root
          System.out.print(currNode.getValue() + " ");
          // finally process right
          inOrderTrav(currNode.getRight());
     }

     //recurse left, recurse right, process root
     public void postOrderTrav()
     {
          postOrderTrav(_root);
     }
     public void postOrderTrav( TreeNode currNode )
     {
          if (currNode == null){
               return;
          }
          // process left first
          postOrderTrav(currNode.getLeft());
          // then process right
          postOrderTrav(currNode.getRight());
          // finally process root
          System.out.print(currNode.getValue() + " ");
     }

     //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
     //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


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
          /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
     }

}//end class
