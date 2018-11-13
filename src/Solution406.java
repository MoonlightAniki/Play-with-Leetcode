// 406. Queue Reconstruction by Height
// https://leetcode.com/problems/queue-reconstruction-by-height/
/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person who have a height greater
than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example
Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
//        for (int i = 0; i < people.length; ++i) {
//            System.out.println(Arrays.toString(people[i]));
//        }
        List<int[]> res = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; ++i) {
            res.add(people[i][1], people[i]);
        }
        for (int i = 0; i < people.length; ++i) {
            people[i] = res.get(i);
        }
        return people;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution406 s = new Solution406();
        int[][] res = s.reconstructQueue(people);
        for (int i = 0; i < res.length; ++i) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
// Runtime: 62 ms, faster than 22.58% of Java online submissions for Queue Reconstruction by Height.
