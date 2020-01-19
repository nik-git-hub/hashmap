public class Launcher {

    public static void main(String[] args) {

        HashMap map = new HashMap();
        display(map);

        fill(map);
        map.put(null, 999);
        map.put( 99, null);
        map.put( 16, 16);

        display(map);

        map.put( 110, "CHANGED");

        //Example: Case of collision
        map.put( 97, 97);
        map.put( "a", "a");
        display(map);

        containsKey(map, 16);
        containsKey(map, 555);
        containsKey(map, null);

        containsValue(map, null);
        containsValue(map, 123);
        containsValue(map, 1141);

    }

    private static void display(HashMap map){
        map.show();
    }

    private static void fill(HashMap map) {
        for (int i = 100; i <= 130; i++) {
            map.put( i, i);
        }
    }

    private static void containsKey(HashMap map, Object key) {
        if (map.containsKey(key)) {
            System.out.println("List contains this value. " + toString(key));
        } else {
            System.out.println("The value isn't found. " + toString(key));
        }
    }

    private static void containsValue(HashMap map, Object value) {
        if (map.containsValue(value)) {
            System.out.println("List contains this value. " + toString(value));
        } else {
            System.out.println("The value isn't found. " + toString(value));
        }
    }

    private static String toString(Object value){
        return value == null ? null: value.toString();
    }

}
