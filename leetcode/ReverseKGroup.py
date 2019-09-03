# Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
#
# k is a positive integer and is less than or equal to the length of the linked list.
# If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
# https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution(object):
    def reverseKGroup(self, head, k):
        prev = None
        nxt = None
        num = k
        cur = head
        tmp = head
        while (tmp != None and num > 0):
            tmp = tmp.next
            num -= 1
        if num > 0:
            return head
        num = k
        while (cur != None and num > 0):
            nxt = cur.next
            cur.next = prev
            prev = cur
            cur = nxt
            num -= 1

        head.next = self.reverseKGroup(cur, k)
        return prev


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None