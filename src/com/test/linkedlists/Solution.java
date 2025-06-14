package com.test.linkedlists;

public class Solution {

    public static void main(String[] args) {

    Node head = new Node(null, 1);
    Node tmp = head;
    for(int i=1; i<8; i++) {

        Node temp = new Node(null, i+1);
        tmp.next = temp;
        tmp = tmp.next;
    }

    printList(head);
    head = rotateMiddle(head);
    printList(head);

    }


    static Node rotateMiddle(Node head) {

        if(head.next == null) return head;
        Node skip1 = head;
        Node skip2 = head;
        while(skip2.next != null) {

            skip2 = skip2.next;
            if(skip2.next != null) {
                skip2 = skip2.next;
                skip1 = skip1.next;
            }

        }
        System.out.println("Skip2: " + skip2.value);
        System.out.println("Skip1: " + skip1.value);
        Node newHead = skip1.next;
        skip2.next = head;
        skip1.next = null;

        return newHead;
    }

    static  void printList(Node head) {

        Node temp = head;
        while(temp != null){
            System.out.println(temp.value+" ");
            temp = temp.next;
        }

    }
}
