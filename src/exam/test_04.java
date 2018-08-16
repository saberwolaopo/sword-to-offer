package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test_04 {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> merge = new ArrayList<Interval>();
        if (intervals.size() <= 1) {
            return intervals;
        }
        Interval[] array = (Interval[]) intervals.toArray(new Interval[intervals.size()]);
        sort(array, 0, intervals.size() - 1);
        int start = array[0].start;
        int end = array[0].end;
        for (int i = 1; i < array.length; i++) {
            if (array[i].start <= end) {
                end = Math.max(end, array[i].end);
                continue;
            }
            merge.add(new Interval(start, end));
            start = array[i].start;
            end = array[i].end;
        }
        if (array[array.length - 1].start <= end) {
            end = Math.max(end, array[array.length - 1].end);
            merge.add(new Interval(start, end));
        } else {
            merge.add(new Interval(array[array.length - 1].start, array[array.length - 1].end));
        }
        return merge;
    }

    public static int partition(Interval[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo].start;
        Interval tmp = array[lo];
        while (lo < hi) {
            while (array[hi].start >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo].start <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = tmp;
        return hi;
    }

    public static void sort(Interval[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }

    public static void main(String args[]) {
        Scanner scann = new Scanner(System.in);
        int m = Integer.parseInt(scann.nextLine().trim());
//        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Interval> intervals = new ArrayList<Interval>();
//        String line = scann.nextLine().trim();
//        String[] tuples = line.split(";");
//        for (String tuple : tuples) {
//            String[] temp = tuple.split(",");
//            //map.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
//            intervals.add(new Interval(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
//        }

        for (int i = 0; i < m; i++) {
            //HashMap<Integer, Integer> newmap = new HashMap<Integer, Integer>();
            String line = scann.nextLine().trim();
            String[] tuples = line.split(";");
//            List<Interval> newIntervals = new ArrayList<Interval>();
            for (String tuple : tuples) {
                String[] temp = tuple.split(",");
//                newIntervals.add(new Interval(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
                //newmap.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
                intervals.add(new Interval(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            }

        }
        List<Interval> re = merge(intervals);
        for (int j = 0; j < re.size() - 1; j++) {
            System.out.print(re.get(j).toString() + ";");
        }
        System.out.print(re.get(re.size() - 1).toString());
    }

}

class Interval {

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

    @Override
    public String toString() {
        return start + "," + end;
    }

}