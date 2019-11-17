/**/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *     left = right = null;
 *   }
 * }
 */
public class SortedListToBinarySearchTree {
  public TreeNode sortListToBST(ListNode head) {
    // corner case: if the list is empty, then the tree should be empty
    if (head == null) {
      return null;
    }
    return helper(head); 
  }
  
  private TreeNode helper(ListNode head) {
    // base case 
    if (head == null) {
      return null;
    }
    
    ListNode mid = findMiddle(head);
    TreeNode root = new TreeNode(mid.value);
    
    // base case
    if (head == mid) {
      return root;
    }
    
    root.left = helper(head);
    root.right = helper(mid.next);
    
    return root;
  }
  
  private ListNode findMiddle(ListNode head) {
    ListNode prev = null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    if (prev != null) {
      prev = null;
    }
    return slow;  // for even nodes, slow is the first node of the second half
  }
}
