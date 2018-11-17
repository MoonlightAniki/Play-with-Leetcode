// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/
/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution056 {
    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, (a, b) -> {
            return a.start == b.start ? a.end - b.end : a.start - b.start;
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); ++i) {
            Interval back = res.get(res.size() - 1);
            Interval cur = intervals.get(i);
            if (cur.start > back.end) {
                res.add(cur);
            } else {
                // cur.start <= back.end
                if (cur.end > back.end) {
                    back.end = cur.end;
                }
            }
        }
        return res;
    }
}
// Runtime: 17 ms, faster than 68.83% of Java online submissions for Merge Intervals.
