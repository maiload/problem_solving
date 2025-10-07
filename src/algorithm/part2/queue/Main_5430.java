package algorithm.part2.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5430 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s1 = br.readLine();
            char[] func = s1.toCharArray();
            int n = Integer.parseInt(br.readLine());
            String s2 = br.readLine();
            Deque<Integer> d = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(s2.substring(1, s2.length() - 1), ",");
            for (int j = 0; j < n; j++) {
                d.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean fromFirst = true;
            boolean isError = false;
            for (int k = 0; k < func.length; k++) {
                if (func[k] == 'R') {
                    fromFirst = !fromFirst;
                } else {
                    if (d.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (fromFirst) {
                        d.removeFirst();
                    } else{
                        d.removeLast();
                    }
                }
            }

            if (isError) {
                sb.append("error");
            } else {
                sb.append("[");
                if (!d.isEmpty()) {
                    while (!d.isEmpty()) {
                        if (fromFirst) {
                            sb.append(d.removeFirst()).append(",");
                        } else {
                            sb.append(d.removeLast()).append(",");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append("]");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
