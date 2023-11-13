package gfgalgo.linkedlist;

public class Prob_PalindromeLinkedList {
    /*
    Naive method: read the linked list and push it to the stack

    Efficient Approach:
       * Find the middle of tjhe linked list
       reverse the elements after the middle
       compare the element i, mid+i untill the right pointer reaches the null
     */

    static class Node{
        char data;
        Node next;
        Node(char x){
            data=x;
            next=null;
        }
    }

    static Node reverseList(Node head){
        if(head==null||head.next==null)return head;
        Node rest_head=reverseList(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }

    static boolean isPalindrome(Node head){
        if(head==null)return true;

        // find the middle of the element
        Node slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // use recursion to reverse the second half of the linked list
        Node rev=reverseList(slow.next);

        // check the ith element with middle+ith element to check the palindrom
        Node curr=head;
        while(rev!=null){
            if(rev.data!=curr.data)
                return false;
            rev=rev.next;
            curr=curr.next;
        }
        return true;
    }

    public static void main(String args[])
    {
        Node head=new Node('g');
        head.next=new Node('f');
        head.next.next=new Node('g');
        if(isPalindrome(head))
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}

