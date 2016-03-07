package rp.util.test;

public class Assert {
    
    public static void assertNull(Object o) {
        if (o != null) {
            throw new IllegalArgumentException("N3 " + o);
        }
    }
    
    public static void assertEquals(Object o1, Object o2) {
        if (o1 == null) {
            if (o2 == null) {
                return;
            }
            throw new IllegalArgumentException("N1 " + o1 + " " + o2);
        }
        if (o2 == null) {
            throw new IllegalArgumentException("N2 " + o1 + " " + o2);
        }
        if (!o1.equals(o2)) {
            throw new IllegalArgumentException("E1 " + o1 + " " + o2);
        }
    }
}
