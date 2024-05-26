package ReverseNodesInGroup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ReverseNodesInGroup.ReverseGroup.ListNode;

class TestReverseGroup {

	ReverseGroup test = new ReverseGroup();

	static ListNode getNodePair(int[] arr) {

		List<ListNode> nodes = new ArrayList<>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (nodes.isEmpty()) {
				nodes.add(new ListNode(arr[i]));
			} else {
				var next = new ListNode(arr[i]);
				nodes.add(next);
				if (i > 0)
					nodes.get(i - 1).next = next;

			}

		}

		return nodes.get(0);

	}

	@Test
	void test() {

		// [[1,4,5],[1,3,4],[2,6]]
		ListNode node = getNodePair(new int[] { 1, 4, 5 });

		assertEquals(5, node.val);
		var child = node.next;
		assertEquals(4, child.val);
		assertNotNull(child.next);
		//assertEquals(1, grandchild.val);
		
		//assertEquals(new int[] { 2, 1, 4, 3, 5 }, test.reverseKGroup(node, 2));
	}

}
