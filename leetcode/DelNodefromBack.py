#Given a linked list, remove the n-th node from the end of list and return its head.
#https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        temp1 = head
        temp2 = head
        while (n != 0):
            temp2 = temp2.next
            n -= 1
        if temp2 == None:
            return head.next
        while (temp2.next != None):
            temp1 = temp1.next
            temp2 = temp2.next

        delNode = temp1.next

        temp1.next = delNode.next
        del delNode
        return head