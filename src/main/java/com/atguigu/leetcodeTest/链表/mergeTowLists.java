package com.atguigu.leetcodeTest.链表;

import com.atguigu.leetcodeTest.链表.ListNode;

public class mergeTowLists {
    public static void main(String[] args) {
        ListNode list1=createList(new int[]{1,2,5});
        ListNode list2=createList(new int[]{1,2,4});
        ListNode l=MergeTwoLists(list1,list2);
        while(l!=null){
            System.out.println(l.val);
            l=l.next;
        }
    }
    public static ListNode MergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1=list1;
        ListNode node1Fore=list1;
        ListNode node2=list2;
        while(node2!=null && node1 != null){
            if(node1Fore.val>node2.val){
                list2=node2.next;
                node2.next=node1Fore;
            }else if(node1.val>=node2.val){
                list2=node2.next;
                node1Fore.next=node2;
                node2.next=node1;
            }else{
                node1Fore=node1;
                node1=node1.next;
            }
            node2=list2;
        }
        if(node1==null){
            node1Fore.next=node2;
        }
        return list1;
    }
    public static ListNode createList(int[] nums){
        ListNode list=null;
        ListNode listFore=null;
        for(int num:nums){
            ListNode l;
            if(listFore==null){
                l=new ListNode(num);
                list=l;
            }else{
                l=new ListNode(num);
                listFore.next=l;
            }
            System.out.println(l.val);
        }
        return list;
    }
}
