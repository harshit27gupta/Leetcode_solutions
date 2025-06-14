/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //step 1 insert the same node within the two nodes;
        Node curr=head;
        while(curr!=null){
            Node copy=new Node(curr.val);
            copy.next=curr.next;
            curr.next=copy;
            curr=curr.next.next;
        }
        curr=head;
        //now start matching the random nodes too
        while(curr!=null){
if(curr.random!=null){
Node random_node=curr.random;
Node random_copy=random_node.next;
curr.next.random=random_copy;
}
            curr=curr.next.next;
        }
//start the delinking process where the copy nodes point to each other
Node dummyHead = new Node(0); // Helps us extract the copied list
Node copyCurr = dummyHead;
curr = head;

while (curr != null) {
    Node copied = curr.next;

    // Restore original list
    curr.next = copied.next;

    // Link the copied node
    copyCurr.next = copied;
    copyCurr = copied;

    // Move forward
    curr = curr.next;
}

return dummyHead.next;
    }
}