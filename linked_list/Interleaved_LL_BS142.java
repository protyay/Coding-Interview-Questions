public class Interleaved_LL_BS142 {
    public LLNode solve(LLNode l0, LLNode l1) {
        if (l0 == null && l1 == null)
            return null;

        if (l0 == null)
            return l1;
        if (l1 == null)
            return l0;

        LLNode head = new LLNode();
        LLNode sentinel = head;

        while (l0 != null && l1 != null) {
            LLNode l0Next = new LLNode();
            l0Next.val = l0.val;
            sentinel.next = l0Next;

            LLNode l1Next = new LLNode();
            l1Next.val = l1.val;
            sentinel = sentinel.next;
            sentinel.next = l1Next;

            l0 = l0.next;
            l1 = l1.next;
            sentinel = sentinel.next;
        }
        LLNode larger = l0 == null ? l1 : l0;
        while (larger != null) {
            LLNode nextNode = new LLNode();
            nextNode.val = larger.val;

            sentinel.next = nextNode;
            larger = larger.next;
            sentinel = sentinel.next;
        }
        return head.next;
    }
}
/**
 * When approaching any LL problem that requires building new sequence with the existing nodes,
 * understand the pitfalls of re-using the same nodes.
 * 
 * In this problem, I first started reusing nodes. The drawback is simple. The new list next pointers
 * now points to the l0 list.
 * 
 * Create new Nodes. Whenever approaching a LL problem, understand if we need to create new Nodes
 * or we can reuse old nodes
 */