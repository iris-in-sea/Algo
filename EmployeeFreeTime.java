class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        int OPEN = 0, CLOSE = 1;
        
        List<int[]> events = new ArrayList<>();
        for (List<Interval> employee: avails) {
            for (Interval iv: employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }
        }
            
        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<Interval> ans = new ArrayList();

        int prev = -1, work = 0;
        for (int[] event: events) {
            // event[0] = time, event[1] = command
            if (work == 0 && prev >= 0) {
                ans.add(new Interval(prev, event[0]));
            }
            
            work += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }
}
