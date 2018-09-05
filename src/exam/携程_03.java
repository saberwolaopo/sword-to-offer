package exam;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class 携程_03 {
    static class LRUCache {

        public int capacity;
        public LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.remove(key);
                map.put(key, value);
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
            if (map.size() >= capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
//            int count = sc.nextInt();
            LRUCache lruCache = new LRUCache(0);
            while (sc.hasNext()) {
                String[] lineString = sc.nextLine().split(" ");
                System.out.println(Arrays.toString(lineString));
                if(lineString.length==1){
                    int count = Integer.valueOf(lineString[0]);
                    lruCache.capacity = count;
                }
                else if (lineString[0].equals("p")) {
                    int putkey = Integer.valueOf(lineString[1]);
                    int value = Integer.valueOf(lineString[2]);
                    lruCache.put(putkey, value);
                } else {
                    int getkey = Integer.valueOf(lineString[1]);
                    System.out.println(lruCache.get(getkey));
                }
            }
        }
    }
}
