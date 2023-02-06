package com.atguigu.leetcodeTest;

public class listNodePartition {
    public static void main(String[] args) {
        ListNode list1=createList(new int[]{1,4,3,2,5,2});
        ListNode l=partition(list1,3);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode headNode=new ListNode(-1);
        ListNode preNode=head;
        ListNode node =head.next;
        headNode.next=head;
        if(head.val<x){
            headNode=headNode.next;
        }
        System.out.println(headNode.val);
        System.out.println(node.val);
        System.out.println(preNode.val);
        int i=1;
        while(node!=null){
            System.out.println("第"+i+"轮：");
            if(node.val<x){
                preNode.next=node.next;
                node.next=headNode.next;
                headNode.next=node.next;
                node=preNode.next;
                headNode=headNode.next;
            }else{
                preNode=node;
                node=node.next;
            }
            ListNode l=head;
            while(l!=null){
                System.out.println(l.val);
                l=l.next;
            }
            i++;
        }
        return headNode.next;
    }
    public static void rearInsert(ListNode headNode,ListNode node,ListNode preNode){
        preNode.next=node.next;
        node.next=headNode.next;
        headNode.next=node.next;
    }
    public static ListNode createList(int[] nums){
        ListNode list=new ListNode(nums[0]);
        ListNode listHead=list;
        for(int i=1;i<nums.length;i++){
            list.next=new ListNode(nums[i]);
            list=list.next;
        }
        return listHead;
    }
}
