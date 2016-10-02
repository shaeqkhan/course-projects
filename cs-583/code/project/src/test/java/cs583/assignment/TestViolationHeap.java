/*
 * Shaeq Khan
 * CS 583 - Programming Assignment
 * Violation Heaps
 */

package cs583.assignment;

public class TestViolationHeap {

	public static void main(String[] args) {
		
		ViolationHeap heap = new ViolationHeap();
		ViolationHeapNode temp;
		
		//populate the heap using insert with 50 nodes
		for(int i = 0; i < 50; i++) {
			temp = new ViolationHeapNode(i);
			heap.insert(temp);
			
		}
		//view the root of the heap only
		System.out.println("\nInsert: Heap Root: " + heap.toString());
		
		//alternate deleteMin and decreaseKey operation on the the heap
		int delta;
		for(int j = 0; j < 25; j++) {
			
			delta = (int) (Math.random() * 20);
			System.out.println("\n\n");
			if(heap.deleteMin())
				System.out.println("DeleteMin: Heap Root: " + heap.toString());
			
			if(heap.decreaseKey(delta))
				System.out.println("DecreaseKey: Heap Root: " + heap.toString());
		}
		
		System.out.println("\n\n");
		int[] CurrentKey = new int[50];
		CurrentKey = heap.getCurrentKey();
		for(int i = 0; i < 50; i++)
			System.out.print("Current Key: [" + i + "]: " + CurrentKey[i] + " | ");
		
		
		System.out.println("\n\nCOUNTERS");
		System.out.println("N: 50" + " | Insert Counter: " + heap.getInsertCounter());
		System.out.println("N: 50" + " | Delete Min Counter: " + heap.getDeleteMinCounter());
		System.out.println("N: 50" + " | Decrease Key Counter: " + heap.getDecreaseKeyCounter());
		System.out.println("N: 50" + " | Three-Way-Join Counter: " + heap.getThreeWayJoinCounter());
		System.out.println("N: 50" + " | Create Forest Counter: " + heap.getCreateForestCounter());
		System.out.println("N: 50" + " | RankAndKeyMap Counter: " + heap.getRankAndKeyMapCounter());
		
		
		
	}
}