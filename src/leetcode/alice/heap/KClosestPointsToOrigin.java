package leetcode.alice.heap;

import java.util.PriorityQueue;
import java.util.Queue;

class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
		Queue<int[]> heap = new PriorityQueue<int[]>(
				(a1, a2) -> (a2[0] * a2[0] + a2[1] * a2[1]) - (a1[0] * a1[0] + a1[1] * a1[1]));

		for (int[] point : points) {
			heap.add(point);
			if (heap.size() > K)
				heap.poll();
		}

		int[][] result = new int[K][2];
		int i = 0;
		while (heap.size() > 0) {
			result[i] = heap.poll();
			i++;
		}

		return result;

	}
}