import java.util.Map;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Timer extends Decorator{
    private int timer=5;

    public Timer(Map m) {
        super(m);
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void Run(int timer){
        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int count = 5;

            public void run() {
                count--;
                if (count == 0) {
                    System.out.println("Timer Over!");
                    setTimer(0);
                    scheduler.shutdown();

                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
    }

    @Override
    public Object put(Object key, Object value) {
        Run(5);
        return map.put(key,value);
    }


    @Override
    public Object get(Object key) {
        if (timer > 0) {
            return map.get(key);
        } else {
            return null;
        }
    }

}
