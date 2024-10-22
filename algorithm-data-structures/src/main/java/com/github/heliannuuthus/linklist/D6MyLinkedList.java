package com.github.heliannuuthus.linklist;

public class D6MyLinkedList {

    public static void main(String[] args) {
        D6MyLinkedList myLinkedList = new D6MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtTail(7);
        myLinkedList.addAtHead(9);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(6);    // 链表变为 4->1->2->0->4
        myLinkedList.addAtHead(0);
        System.out.println(myLinkedList.get(5));
        myLinkedList.addAtHead(0);
        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(5));
        myLinkedList.addAtTail(4);
    }
    LinkedNode head;
    LinkedNode tail;
    int length;

    public D6MyLinkedList() {
        head = new LinkedNode(-1);
        tail = new LinkedNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }
        return head.next.get(index);
    }

    public void addAtHead(int val) {
        LinkedNode current = new LinkedNode(val);
        current.next = head.next;
        if (head.next == tail) {
            tail.prev = current;
        }
        head.next = current;
        length++;
    }

    public void addAtTail(int val) {
        LinkedNode current = new LinkedNode(val);
        current.next = this.tail;
        this.tail.prev.next = current;
        this.tail.prev = current;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }
        LinkedNode tmp = this.head;
        while (index-- > 0) {
            tmp = tmp.next;
        }
        LinkedNode current = new LinkedNode(val);
        current.next = tmp.next;
        tmp.next = current;
        if (current.next == tail) {
            tail.prev = current;
        }
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        LinkedNode tmp = this.head;
        while (index-- > 0) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        if (tmp.next == tail) {
            tail.prev = tmp;
        }
        length--;
    }


    static class LinkedNode {
        int val;
        LinkedNode next;
        LinkedNode prev;

        public LinkedNode(int val) {
            this.val = val;
        }

        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }

        public LinkedNode(int val, LinkedNode prev, LinkedNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public int get(int index) {
            if (index == 0) {
                return val;
            }
            if (next == null) {
                return -1;
            }
            return next.get(index - 1);
        }

        @Override
        public String toString() {
            return val + " -> " + next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */