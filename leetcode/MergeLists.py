class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        dummy =ListNode(0)
        x = dummy
        while (l1!=None and l2!=None):
            if l1.val < l2.val:
                x.next = l1
                l1=l1.next
            else:
                x.next = l2
                l2 = l2.next
            x = x.next
        if (l1==None):
            x.next = l2
        else:
            x.next = l1
        return dummy.next