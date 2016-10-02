/*
 * Shaeq Khan
 * CS 583 - Programming Assignment
 * Violation Heaps
 */

package cs583.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ViolationHeap {
	
	private ViolationHeapNode minNode;
	
	private int numOfNodes;
	
	private int[] CurrentKey = new int[50];
	
	private int insertCounter;
	private int deleteMinCounter;
	private int createForestCounter;
	private int rankAndKeyMapCounter;
	private int threeWayJoinCounter;
	private int decreaseKeyCounter;
	
	public int getDecreaseKeyCounter() {
		return decreaseKeyCounter;
	}
	
	public int getThreeWayJoinCounter() {
		return threeWayJoinCounter;
	}
	
	public int getDeleteMinCounter() {
		return deleteMinCounter;
	}
	
	public int getInsertCounter() {
		return insertCounter;
	}
	
	public int getCreateForestCounter() {
		return createForestCounter;
	}
	
	public int getRankAndKeyMapCounter() {
		return rankAndKeyMapCounter;
	}
	
	public int[] getCurrentKey() {
		return CurrentKey;
	}
	
	public int getNumOfNodes() {
		return numOfNodes;
	}
	
	public ViolationHeapNode getMinNode() {
		return minNode;
	}

	public ViolationHeap() {
		minNode = null;
		numOfNodes = 0;
		insertCounter = 0;
		for(int i = 0; i < 50; i++)
			CurrentKey[i] = (int) ((Math.random() * 2000) + 5000);
	}
	
	public boolean isEmpty() {
		return minNode == null;
	}
	
	public void resetViolationHeap() {
		minNode = null;
		numOfNodes = 0;
		insertCounter = 0;
	}
	
	/*
	 * insert(node): 
	 * 
	 * A single node is inserted into the root list of the heap. 
	 * The rank of x is initially set to zero. 
	 * If the key of x is smaller than the minimum of h, 
	 * then x is inserted in the first position, 
	 * otherwise in the second position.
	 * 
	 * @param node to insert in the heap
	 * 		  
	 */
	public void insert(ViolationHeapNode node) {
		
		node.rank = 0;
		
		//inserting the first node, right points to null
		if(minNode == null) {
			minNode = node;
			minNode.right = null;
		}
		
		//inserting a node smaller than minNode
		else if(node.key < minNode.key) {
			node.right = minNode;
			minNode = node;
		}
		
		//insert the node in the first position after minNode
		else {
			node.right = minNode.right;
			minNode.right = node;
		}
		
		numOfNodes++;
		insertCounter++;
		
//		System.out.println("Number of Nodes: " + numOfNodes);
//		System.out.println("Insert Counter: " + insertCounter);
	}
	
	

	/*
	 * delete-min(h)
	 * 
	 * Remove from h the first root and make each of its subtrees a tree in h
	 * Repeatedly 3-way-join trees of equal rank until no three trees of same rank remain
	 * Finally, root with new minimum value is moved to the first position in root list
	 * 
	 */
	public boolean deleteMin() {
		
		if(minNode == null)
			throw new IllegalArgumentException("The Violation Heap is empty");
		
		//if the minNode has a child, bring them to the root
		if(minNode.child != null) {
			
			List<ViolationHeapNode> rootList = new ArrayList<ViolationHeapNode>();
			rootList.add(minNode.child);
			
			//update CurrentKey[]
			CurrentKey[minNode.key] = 0;
			
			//store the other nodes on the root to re-form the forest
			if(minNode.right != null) {
				ViolationHeapNode otherRoots = minNode.right;
				rootList.add(otherRoots);
				while(otherRoots.right != null) {
					otherRoots = otherRoots.right;
					rootList.add(otherRoots);
				}
			}
			
			//take all the children and move them to the root
			ViolationHeapNode children = minNode.child;
			while(children.left != null) {
				children = children.left;
				rootList.add(children);
			}
			
			createForest(rootList);
			rootList.clear();
			
			numOfNodes--;
			deleteMinCounter++;
//			System.out.println("Number of Nodes: " + numOfNodes);
//			System.out.println("DeleteMin Counter: " + deleteMinCounter);
			return true;
		}
		
		//One node with no children - remove it, makes the heap empty
		if(minNode.right == null && minNode.child == null) {
			
			//update CurrentKey[]
			CurrentKey[minNode.key] = 0;
			
			minNode = null;
//			System.out.println("Deleting minNode and making heap empty...");
			
			numOfNodes--;
			deleteMinCounter++;
//			System.out.println("Number of Nodes: " + numOfNodes);
//			System.out.println("DeleteMin Counter: " + deleteMinCounter);
			return true;
		}
		
		//Two nodes - delete the minNode, make the second node as minNode
		ViolationHeapNode z1 = minNode.right;	
		if(z1.right == null && minNode.child == null) {
			
			//update CurrentKey[]
			CurrentKey[minNode.key] = 0;
			
			minNode = z1;
			minNode.right = null;
//			System.out.println("Deleting minNode and making the second node as minNode...");
			
			numOfNodes--;
			deleteMinCounter++;
//			System.out.println("Number of Nodes: " + numOfNodes);
//			System.out.println("DeleteMin Counter: " + deleteMinCounter);
			return true;
		}
			
		//Three nodes - delete the minNode, find the smaller node between the two
		//and make it the minNode
		ViolationHeapNode z2 = z1.right; 
		if(z2.right == null && minNode.child == null) {
			
			//update CurrentKey[]
			CurrentKey[minNode.key] = 0;
			
			if(z1.key < z2.key) {
				minNode = z1;
				minNode.right = z2;
				z2.right = null;
			}
			else {
				minNode = z2;
				minNode.right = z1;
				z1.right = null;
			}
//			System.out.println("Deleting minNode and making the smaller node as minNode...");
			numOfNodes--;
			deleteMinCounter++;
//			System.out.println("Number of Nodes: " + numOfNodes);
//			System.out.println("DeleteMin Counter: " + deleteMinCounter);			
			return true;
		}//end of if-three-nodes
		
		
		
		
		//Four or more nodes - delete the minNode, do a 3-way-join on nodes with same rank
		//until no three trees of the same rank remain
		
		Map<Integer, List<ViolationHeapNode>> map = new HashMap<Integer, List<ViolationHeapNode>>();
		List<ViolationHeapNode> rootList = new ArrayList<ViolationHeapNode>();
		boolean doThreeWayJoin, minNodeDeleted = false;
		
		//update CurrentKey[]
		CurrentKey[minNode.key] = 0;
		
		do{
			deleteMinCounter++;
//			System.out.println(deleteMinCounter);
			doThreeWayJoin = false;
			map.clear();
			//exclude minNode since its deleted the first time
			if(!minNodeDeleted)
				map = getRankAndKeyMap(minNode.right);
			else
				map = getRankAndKeyMap(minNode);
			
			
			for (Map.Entry<Integer, List<ViolationHeapNode>> entry : map.entrySet()) {
				List<ViolationHeapNode> values = entry.getValue();
				if(values.size() >= 3)
					doThreeWayJoin = true;
			}
			
//			System.out.println("\nDoThreeWayJoin: " + doThreeWayJoin);
		
			
			for (Map.Entry<Integer, List<ViolationHeapNode>> entry : map.entrySet()) {
			
				List<ViolationHeapNode> values1 = entry.getValue();

				while(values1.size() >= 3) {
					
					ViolationHeapNode Z = values1.get(0);
					ViolationHeapNode Z1 = values1.get(1);
					ViolationHeapNode Z2 = values1.get(2);
					
					ViolationHeapNode root = ThreeWayJoin(Z, Z1, Z2, entry.getKey());
					
					rootList.add(root);
					values1.remove(Z); values1.remove(Z1); values1.remove(Z2);

				}
			
				map.put(entry.getKey(), values1);
			
				if(values1.size() > 0)
					rootList.addAll(values1);
			
				values1.clear();
			
			}//end of for
		
//			System.out.println("RootList: " + rootList.toString());
			createForest(rootList);
			rootList.clear();
			minNodeDeleted = true;
		
		} while(doThreeWayJoin);
		
		
		return true;
		
	}//end of delete-min
	
	
	/*
	 * Creates a Forest of trees when provided with nodes that should be
	 * in the root list
	 */
	private void createForest(List<ViolationHeapNode> rootList) {
		
		//when one node
		if(rootList.size() == 1) {
			minNode = rootList.get(0);
			minNode.right = null;
			createForestCounter++;
//			System.out.println(createForestCounter);
		}
		
		//when two nodes, assign the node with smaller key as minNode
		else if(rootList.size() == 2) {
			ViolationHeapNode first = rootList.get(0), second = rootList.get(1);
			
			if(second.key < first.key) {
				
				second.right = first;
				first.right = null;
				minNode = second;
			}
			
			else {
				
				first.right = second;
				second.right = null;
				minNode = first;
			}
			createForestCounter++;
//			System.out.println(createForestCounter);
		}
		
		//when three or more nodes 
		else{
			
			int min = rootList.get(0).key;
			minNode = rootList.get(0);
			
			int minIndex = 0;
			for(int i = 0; i < rootList.size(); i++) {
				if(rootList.get(i).key < min) {
					minNode = rootList.get(i);
					minIndex = i;
				}
				createForestCounter++;
//				System.out.println(createForestCounter);
			}
			
//			System.out.println("createForest() - MinNode: " + minNode.toString());
			rootList.remove(minIndex);
			
			ViolationHeapNode first, second;
			for(int i = 0; i < rootList.size()-1; i++) {
				first = rootList.get(i);
				second = rootList.get(i+1);

				if(i == 0) { 
					minNode.right = first;
				}
				
				first.right = second;
				second.right = null;
				createForestCounter++;
//				System.out.println(createForestCounter);
			}//end of for
			
		}
		
	}//end of createForest
	
	

	/*
	 * Precondition - Rank(Z) = Rank(Z1) = Rank(Z2)
	 * 
	 * Z <= Z1 && Z2
	 * Z1 and Z2 become active childs of Z
	 * Node with bigger rank between Z1 and Z2 becomes the last child of Z
	 * Recalculate ranks of Z, Z1 and Z2
	 * Root with new minimum value is made the minNode 
	 */
	private ViolationHeapNode ThreeWayJoin(ViolationHeapNode Z, ViolationHeapNode Z1, ViolationHeapNode Z2, int rank) {
		
		int lowest = Math.min(Math.min(Z.key, Z1.key), Math.min(Z1.key, Z2.key));
		
		if(lowest == Z1.key) {
			ViolationHeapNode temp = Z;
			Z = Z1;
			Z1 = temp;
		}
		else if(lowest == Z2.key) {
			ViolationHeapNode temp = Z;
			Z = Z2;
			Z2 = temp;
		}
			
	
		//Z2 is the last child
		if(Z2.getRank() > Z1.getRank()) {
			
			Z.child = Z2;
			Z2.right = Z;
			Z2.left = Z1;
			Z1.right = Z2;
			Z1.setRank();
			Z2.setRank();

		}

		//Z1 is the last child
		else {
			
			Z.child = Z1;
			Z1.right = Z;
			Z1.left = Z2;
			Z2.right = Z1;
			Z2.setRank();
			Z1.setRank();

		}
		
		Z.setRank();
		threeWayJoinCounter++;
//		System.out.println("ThreeWayJoin: " + threeWayJoinCounter);
//		System.out.println("Z rank: " + Z.rank);
		return Z;
		
		
	}
	
	
	/*
	 * Return a HashMap of the rank | keys where the keys have the same
	 * rank in the root list  
	 */
	private Map<Integer, List<ViolationHeapNode>> getRankAndKeyMap(ViolationHeapNode start) {
		
		HashMap<Integer, List<ViolationHeapNode>> map = new HashMap<Integer, List<ViolationHeapNode>>();
		List<ViolationHeapNode> keyList0 = new ArrayList<ViolationHeapNode>();
		List<ViolationHeapNode> keyList1 = new ArrayList<ViolationHeapNode>();
		List<ViolationHeapNode> keyList2 = new ArrayList<ViolationHeapNode>();
		List<ViolationHeapNode> keyList3 = new ArrayList<ViolationHeapNode>();
		List<ViolationHeapNode> keyList4 = new ArrayList<ViolationHeapNode>();
		List<ViolationHeapNode> keyList5 = new ArrayList<ViolationHeapNode>();
		List<ViolationHeapNode> keyList6 = new ArrayList<ViolationHeapNode>();
		
		HashSet<Integer> ranksInRootList = new HashSet<Integer>();
		for(ViolationHeapNode temp = start; temp != null; temp = temp.right) {
			ranksInRootList.add(temp.rank);
			rankAndKeyMapCounter++;
			System.out.println(rankAndKeyMapCounter);
		}
//		System.out.println("MinNode: " + minNode);
//		System.out.println("Ranks in Root List: " + ranksInRootList.toString());
		
		for(Iterator<Integer> i = ranksInRootList.iterator(); i.hasNext();) {
			rankAndKeyMapCounter++;
			System.out.println(rankAndKeyMapCounter);
			int rank = (int) i.next();
			
			for(ViolationHeapNode temp = start; temp != null; temp = temp.right) {
				rankAndKeyMapCounter++;
				System.out.println(rankAndKeyMapCounter);
				if(rank == temp.rank && rank == 0) {
					keyList0.add(temp);
				}
				if(rank == temp.rank && rank == 1) {
					keyList1.add(temp);
				}
				if(rank == temp.rank && rank == 2) {
					keyList2.add(temp);
				}
				if(rank == temp.rank && rank == 3) {
					keyList3.add(temp);
				}
				if(rank == temp.rank && rank == 4) {
					keyList4.add(temp);
				}
				if(rank == temp.rank && rank == 5) {
					keyList5.add(temp);
				}
				if(rank == temp.rank && rank == 6) {
					keyList6.add(temp);
				}
				
			}
			
			if(rank == 0) map.put(rank, keyList0);
			
			if(rank == 1) map.put(rank, keyList1);
			
			if(rank == 2) map.put(rank, keyList2);
			
			if(rank == 3) map.put(rank, keyList3);
			
			if(rank == 4) map.put(rank, keyList4);
			
			if(rank == 5) map.put(rank, keyList5);
			
			if(rank == 6) map.put(rank, keyList6);
		}
		
//		for (Map.Entry<Integer, List<ViolationHeapNode>> entry : map.entrySet()) 
//			System.out.println("Check here: rank: " + entry.getKey() + " Values: " + entry.getValue().toString());
		
		rankAndKeyMapCounter++;
		System.out.println(rankAndKeyMapCounter);
		
		return map;
		
	}//end of getRankAndKeyMap
	
	
	
	public boolean decreaseKey(int delta) {
		
		//look for node in root with value less than 20
		ViolationHeapNode start = minNode;
		List<ViolationHeapNode> rootList = new ArrayList<ViolationHeapNode>();
		
		boolean foundRecord = false;
		while(start != null) {
			if(start.key > 20 && !foundRecord) {
				start.key = start.key - delta;
				foundRecord = true;
			}
			rootList.add(start);
			start = start.right;
			decreaseKeyCounter++;
//			System.out.println(decreaseKeyCounter);
		}
		if(foundRecord) {
			createForest(rootList);
			return true;
		}
		
//		System.out.println("Not found in root..checking child");
		//when such a node is not found in the root, 
		//search in the children
		start = minNode;
		ViolationHeapNode lastChild = null;
		ViolationHeapNode activeNode = null;
		
		while(start != null) {
//			System.out.println("Start: " + start.toString());
			if(start.child != null) {
				lastChild = start.child;
//				System.out.println("LastChild: " + lastChild.toString());
			}
			if(lastChild != null && lastChild.left != null) {
				activeNode = lastChild.left;
//				System.out.println("ActiveNodes: " + activeNode.toString());
			}
			
			
			if(lastChild != null) {
				
				if(lastChild.key > 20 && !foundRecord){
					lastChild.key = lastChild.key - delta;
					foundRecord = true;
//					System.out.println("Updated LastChild: " + lastChild.toString());
					if(lastChild.key < start.key) {
//						System.out.println("Last Child is now smaller than parent, cutting ...");
						if(lastChild.child != null) {
							ViolationHeapNode replacement1 = lastChild.child;
//							System.out.println("Found replacement1 for Last Child.");
							ViolationHeapNode replacement2 = null;
							if(replacement1.left != null) {
								replacement2 = replacement1.left;
//								System.out.println("Found replacement2 for Last Child.");
							}
							if(replacement2 == null) {
								replacement1.right = lastChild.right;
								start.child = replacement1;
								if(activeNode != null)
									replacement1.left = lastChild.left;
								lastChild.child = null;
								replacement1.setRank();
//								System.out.println("Replacement1 in position of X");
							}
							else {
								if(replacement1.getRank() >= replacement2.getRank()) {
									replacement1.right = lastChild.right;
									start.child = replacement1;
									if(activeNode != null)
										replacement1.left = lastChild.left;
									lastChild.child = replacement2;
									lastChild.left = null;
									replacement1.setRank();
//									System.out.println("Replacement1 in position of X");
								}
								if(replacement1.getRank() > replacement2.getRank()) {
									replacement2.right = lastChild.right;
									start.child = replacement2;
									if(activeNode != null)
										replacement2.left = lastChild.left;
									lastChild.child = replacement1;
									lastChild.left = null;
									replacement2.setRank();
//									System.out.println("Replacement1\2 in position of X");
								}
							}
						}
						
						rootList.add(lastChild);
//						System.out.println("RootList: " + rootList);
					}
				}
				
				if(activeNode != null) {
					if(activeNode.key > 20 && !foundRecord) {
						activeNode.key = activeNode.key - delta;
						foundRecord = true;
//						System.out.println("Updated activeNode: " + activeNode.toString());
					}
					
					if(activeNode.key < start.key) {
//						System.out.println("Active node is now less than the parent");
						if(activeNode.child != null) {
							ViolationHeapNode replacement1 = activeNode.child;
//							System.out.println("Active node found a replacement1");
							ViolationHeapNode replacement2 = null;
							if(replacement1.left != null) {
								replacement2 = replacement1.left;
//								System.out.println("Active node found a replacement2");
							}
							if(replacement2 == null) {
								replacement1.right = activeNode.right;
								lastChild.left = replacement1;								
								activeNode.child = null;
								replacement1.setRank();
//								System.out.println("Active node used replacement1 for X");
							}
							else {
								if(replacement1.getRank() >= replacement2.getRank()) {
									replacement1.right = activeNode.right;
									start.child.left = replacement1;
									if(activeNode.left != null) {
										replacement1.left = activeNode.left;
										replacement1.left.right = replacement1;
									}
									activeNode.child = replacement2;
									activeNode.left = null;
									replacement1.setRank();
//									System.out.println("Active node used replacement1 for X");
								}
								if(replacement1.getRank() < replacement2.getRank()) {
									replacement2.right = activeNode.right;
									start.child.left = replacement2;
									if(activeNode.left != null) {
										replacement2.left = activeNode.left;
										replacement2.left.right = replacement2;
									}
									activeNode.child = replacement2;
									activeNode.left = null;
									replacement2.setRank();
//									System.out.println("Active node used replacement2 for X");
								}
							}
						}
						rootList.add(activeNode);
//						System.out.println("RootList: " + rootList);
					}
				}
			}
					
			start = start.right;
			decreaseKeyCounter++;
//			System.out.println(decreaseKeyCounter);
		}
		
		if(foundRecord) {
			createForest(rootList);
			return true;
		}
			
		decreaseKeyCounter++;
//		System.out.println(decreaseKeyCounter);
		return false;
		
		
	}

	public String toString() {
		
		if(isEmpty())
			return "Empty Heap";
		
		String heap = "";
		heap += "[key:" + minNode.key + " | rank:" + minNode.rank + "] ---> ";
		
		//if it has one node
		if(minNode.right == null) {			
			return heap;
		}
		
		ViolationHeapNode temp = minNode.right;
		
		while(temp != null){
			heap += "[key:" + temp.key + " | rank:" + temp.rank + "] ---> ";
			temp = temp.right;
		}
			
		
		return heap;
		
	}
	
	
	
}
