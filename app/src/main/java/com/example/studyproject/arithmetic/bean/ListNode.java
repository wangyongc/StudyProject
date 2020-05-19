package com.example.studyproject.arithmetic.bean;

public class ListNode {

    public Node head;
    public Node last;
    private int size = 0;

    public ListNode() {
        head = new Node(-1);// 实例化头节点
        last = head;//令头节点等于尾节点
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isNull() {
        return size == 0;
    }

    /**
     * 添加数据
     */
    public void add(int data) {
        Node node = new Node();
        node.data = data;

        last.next = node;
        last = node;

        size++;
    }



}
