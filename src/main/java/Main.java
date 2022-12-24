import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Decorator dec = new Timer(new HashMap<Integer, String>());

        dec.put(1,"element 1");
        dec.put(2,"element 2");

        System.out.println(dec.get(1));
        System.out.println(dec.get(2));

        Thread.sleep(5000);

        System.out.println(dec.get(1));
        System.out.println(dec.get(2));

    }
}
