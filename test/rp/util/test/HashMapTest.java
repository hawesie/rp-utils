package rp.util.test;

import java.util.Map;

import rp.util.HashMap;
import lejos.util.Delay;

public class HashMapTest {
    
    public static void main(String[] args) {
        HashMapTest test = new HashMapTest();
        test.testBasic();
        System.out.println("Test1 :)");
        Delay.msDelay(6000);
        test.testRandom();
        System.out.println("Test2 :)");
        Delay.msDelay(6000);
        test.testRemoveBigNumber();
        System.out.println("Test3 :)");
        Delay.msDelay(6000);
        test.testStandard();
        System.out.println("Test4 :)");
        test.testBigNumber();
        System.out.println("Test5 :)");
        test.testDoublePut();
        System.out.println("Test6 :)");
        test.testRemove();
        System.out.println("Test7 :)");
        Delay.msDelay(3000);
        System.out.println("--- All tests done! ---");
        Delay.msDelay(9000000);
    }
    
    public void testBasic() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 4; i++) {
            map.put(i, i+8);
        }
        for (int key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
        Delay.msDelay(6000);
        
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        map2.put(1, 0);
        map2.put(-5, 1);
        map2.putAll(map);
        for (Map.Entry<Integer, Integer> pair : map2.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        Delay.msDelay(6000);
        
        Assert.assertEquals(4, map.size());
        Assert.assertEquals(false, map.isEmpty());
        Assert.assertEquals(true, map.containsKey(1));
        Assert.assertEquals(false, map.containsKey(-51));
        Assert.assertEquals(true, map.containsValue(9));
        Assert.assertEquals(false, map.containsValue(1));
        System.out.println(map.toString());
        Delay.msDelay(6000);
        map.clear();
        Assert.assertEquals(0, map.size());
        Assert.assertEquals(true, map.isEmpty());
        System.out.println(map.toString());
    }
    
    public void testRemove() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Lars", 1);
        map.put("Günther", 12);
        map.put("Max", 2);

        Assert.assertEquals(null, map.get("Markus"));
        Assert.assertEquals(1, map.get("Lars"));
        Assert.assertEquals(2, map.get("Max"));
        Assert.assertEquals(12, map.get("Günther"));

        map.remove("Max");
        Assert.assertEquals(null, map.get("Markus"));
        Assert.assertEquals(1, map.get("Lars"));
        Assert.assertEquals(null, map.get("Max"));
        Assert.assertEquals(12, map.get("Günther"));

        Assert.assertEquals(1, map.remove("Lars"));
        Assert.assertEquals(null, map.remove("Lars"));
        Assert.assertEquals(null, map.get("Markus"));
        Assert.assertEquals(null, map.get("Lars"));
        Assert.assertEquals(null, map.get("Max"));
        Assert.assertEquals(12, map.get("Günther"));

        map.put("Lars", 1);
        map.put("Günther", 12);
        map.put("Max", 2);
        Assert.assertEquals(12, map.remove("Günther"));

    }

    public void testStandard() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Lars", 1);
        map.put("Günther", 12);
        map.put("Max", 2);

        Assert.assertEquals(null, map.get("Markus"));
        Assert.assertEquals(1, map.get("Lars"));
        Assert.assertEquals(2, map.get("Max"));
        Assert.assertEquals(12, map.get("Günther"));

    }

    public void testDoublePut() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Lars", 1);
        map.put("Günther", 12);

        Assert.assertEquals(1, map.get("Lars"));
        Assert.assertEquals(12, map.get("Günther"));

        map.put("Lars", 14);
        map.put("Günther", 122);
        map.put("Fred", 11111);
        Assert.assertEquals(14, map.get("Lars"));
        Assert.assertEquals(122, map.get("Günther"));
    }
    
    public void testBigNumber() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        final int maxIndex = 33; // set this to big number 
        for (int i = 0; i < maxIndex; i++) {
            map.put("Tom" + String.valueOf(i), i);
        }

        for (int i = 0; i < maxIndex; i++) {
            Assert.assertEquals(map.get("Tom" + String.valueOf(i)), i);
        }

    }
    
    public void testRemoveBigNumber() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>();
        final int maxIndex = 500;
        for (int i = 0; i < maxIndex; i++) {
            System.gc();
            final String key = "Tom" + String.valueOf(i);
            System.gc();
            map.put(key, i);
        }

        for (int i = maxIndex / 3; i < (maxIndex / 2); i++) {
            Assert.assertEquals(i, map.remove("Tom" + String.valueOf(i)));
        }

        for (int i = 0; i < maxIndex; i++) {
            if ((i >= (maxIndex / 3)) && (i < (maxIndex / 2))) {
                Assert.assertEquals(null, map.get("Tom" + String.valueOf(i)));
            } else {
                Assert.assertEquals(map.get("Tom" + String.valueOf(i)), i);
            }
        }
    }

    public void testRandom() {
        final HashMap<String, Integer> map = new HashMap<String, Integer>(997);
        final HashMap<String, Integer> mapJdK = new HashMap<String, Integer>(997);

        final int maxIndex = 500;
        for (int i = 0; i < maxIndex; i++) {
            System.gc();
            final String key = "Tom" + String.valueOf((int) (Math.random() * maxIndex));
            System.gc();
            map.put(key, i);
            System.gc();
            mapJdK.put(key, i);
            System.gc();
            Assert.assertEquals(map.get(key), mapJdK.get(key));
            System.out.println(i);
        }

        for (int i = 0; i < maxIndex; i++) {
            final String key = "Tom" + String.valueOf((int) (Math.random() * maxIndex));
            map.put(key, i);
            mapJdK.put(key, i);
            Assert.assertEquals(map.get(key), mapJdK.get(key));
        }

        for (int i = 0; i < maxIndex; i++) {
            final String key = "Tom" + String.valueOf((int) (Math.random() * maxIndex));
            if ((null != map.get(key)) || (null != mapJdK.get(key))) {
                Assert.assertEquals(map.get(key), mapJdK.get(key));
            }
        }

        for (int i = 0; i < maxIndex; i++) {
            final String key = "Tom" + String.valueOf((int) (Math.random() * maxIndex));
            map.remove(key);
            mapJdK.remove(key);
            Assert.assertNull(map.get(key));
            Assert.assertNull(mapJdK.get(key));
        }
    }
    
}
