# Given a linked list, swap every two adjacent nodes and return its head.
#
# You may not modify the values in the list's nodes, only nodes itself may be changed.
#https://leetcode.com/problems/swap-nodes-in-pairs/

class Solution(object):
    def swapPairs(self, head):
        curr = head
        prev = None
        while (curr!=None and curr.next!=None):
            if prev!=None:
                prev.next = curr.next
            else:
                head = curr.next
            prev= curr
            curr = curr.next
            nxt = curr.next
            curr.next = prev
            prev.next = nxt
            curr = nxt
        return head

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None