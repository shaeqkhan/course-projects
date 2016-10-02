/*
 * Shaeq Khan
 * CS 583 - Programming Assignment
 * Violation Heaps
 */

package cs583.assignment;

class ViolationHeapNode {
	
	int rank;
	int key;
	
	ViolationHeapNode child;
	ViolationHeapNode left;
	ViolationHeapNode right;
	
	public ViolationHeapNode() {
		rank = 0;
		child = null;
		left = null;
		right = null;
	}
	
	public ViolationHeapNode(int key) {
		this.key = key;
	}
	
	/*
	 * Rank is maintained for every node Z
	 * Z - parent
	 * Z1 and Z2 - last two children of Z (active node)
	 * Rank(Z) = ceil [ (Rank(Z1) + Rank(Z2)) / 2 ] + 1
	 * 
	 * The rank of a missing child is -1
	 * 
	 * Lemma 2: The following relations are maintained for every node Z
	 * If Z has no children, then Rank(Z) <= 0
	 * If Z has one child Z1, then Rank(Z) <= ceil [ (Rank(Z1) - 1) / 2 ] + 1
	 * If Z has active children Z1 and Z2, then Rank(Z) <= ceil [ (Rank(Z1) + Rank(Z2)) / 2 ] + 1 
	 */
	public int getRank() {
		
		ViolationHeapNode Z = this;
		
		//rank of node is 0 if it has no child
		if(Z.child == null) {
			Z.rank = (int) (Math.ceil( (-1 + -1) / 2) + 1);
			return Z.rank;
		}
		
		//if the node has at least one child
		if(Z.child != null) {
			ViolationHeapNode Z1 = Z.child;
			
			//if Z has only one child Z1 i.e. Z1 is the active node
			if(Z1.left == null) {
				Z.rank = (int) (Math.ceil(( Z1.getRank() + (-1)) / 2 ) + 1);
				return Z.rank;
			}
			
			//if Z has two children Z1 and Z2 i.e. Z1 and Z2 are the active nodes
			if(Z1.left != null) {
				ViolationHeapNode Z2 = Z1.left;
				Z.rank = (int) (Math.ceil(( Z1.getRank() + Z2.getRank() ) / 2 ) + 1);
				return Z.rank;
			}
		}
		
		return 0;
	}
	
	public void setRank() {
		this.rank = getRank();
	}

	@Override
	public String toString() {
		return "ViolationHeapNode [key=" + key + ", rank=" + rank + "]";
	}
	
	public boolean equals(Object o) {
		
		return ((ViolationHeapNode) o).key == this.key;
		
	}
	
}
