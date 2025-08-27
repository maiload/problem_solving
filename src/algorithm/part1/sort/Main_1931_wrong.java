package algorithm.part1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1931_wrong {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 10만
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> meetingCountList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, Math.min(end, map.getOrDefault(start, Integer.MAX_VALUE)));
        }
        List<Map.Entry<Integer, Integer>> meetingList = new ArrayList<>(map.entrySet());
        Collections.sort(meetingList, (a, b) -> a.getKey().compareTo(b.getKey()));
        System.out.println(meetingList);

        int meetingCount = 0;
        int currentTime = 0;
        count(meetingList, meetingCountList, meetingCount, currentTime, 0);
        Collections.sort(meetingCountList, Comparator.reverseOrder());
        System.out.println(meetingCountList.get(0));
    }

    static void count(List<Map.Entry<Integer, Integer>> meetingList, List<Integer> meetingCountList,
                      int meetingCount, int currentTime, int idx) {
        int beforeTime = currentTime;
        for (int i = idx; i < meetingList.size(); i++) {
            int start = meetingList.get(i).getKey();
            int end = meetingList.get(i).getValue();
            System.out.printf("meetingCount: %d, currentTime: %d, listIdx: %d (start: %d, end: %d)%n",
                    meetingCount, currentTime, i, start, end);

            if (start >= currentTime) {
                meetingCount++;
                currentTime = end;
            } else {
                if (i > 0) {
                    System.out.printf("BACK - meetingCount: %d, beforeTime: %d, listIdx: %d%n",
                            meetingCount - 1, beforeTime, i);
                    count(meetingList, meetingCountList, meetingCount - 1, beforeTime, i);
                }
            }
        }
        meetingCountList.add(meetingCount);
        System.out.println("FIN - meetingCount: " + meetingCount);
    }
}
