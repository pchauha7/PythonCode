# Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
# https://leetcode.com/problems/merge-k-sorted-lists/

import Queue as Q

class Solution(object):
    def mergeKLists(self, lists):
        dummy = ListNode(0)
        if len(lists) == 0:
            return dummy.next
        if len(lists)==1:
            return lists[0]
        q = Q.PriorityQueue()
        for x in lists:
            q.put((x.val, x))
        tmp = dummy
        while(not q.empty()):
            x = q.get()
            tmp.next = x[1]
            tmp = tmp.next
            if x[1].next != None:
                q.put((x[1].next.val, x[1].next))
        return dummy.next

class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None