package leetcode.alice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class MeetingRooms2 {
	public static void main(String[] args) {
		System.out.println(minMeetingRooms(new int[][] { { 1, 8 }, { 6, 20 }, { 9, 16 }, { 13, 17 } }));
		System.out.println(minMeetingRooms(new int[][] { { 9, 14 }, { 5, 6 }, { 3, 5 }, { 12, 19 } }));
	}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals.length < 1) {
			return 0;
		}
		if (intervals.length == 1) {
			return 1;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < intervals.length; i++) {
			if (map.size() == 0) {
				map.put(1, new ArrayList<Integer>());
				map.get(1).add(i);
			} else {
				int busyRoom = 0;
				for (Entry<Integer, List<Integer>> e : map.entrySet()) {
					boolean isEmpty = true;
					List<Integer> existingMeetings = e.getValue();
					for (Integer meeting : existingMeetings) {
						if (intervals[i][0] < intervals[meeting.intValue()][1]) {
							isEmpty = false;
							busyRoom++;
							;
							continue;
						}

					}
					if (isEmpty) {
						e.getValue().add(i);
						break;
					}
				}
				if (map.size() == busyRoom) {
					Integer nextRoom = map.size() + 1;
					map.put(nextRoom, new ArrayList<Integer>());
					map.get(nextRoom).add(i);

				}
			}
		}

		return map.size();
	}

}