import java.lang.reflect.Constructor;

public class Main {

    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        RunnableDemo R3 = new RunnableDemo("Thread-3");
        R1.start();
        R2.start();
        R3.start();

        LazyInitializedSingleton instanceOne = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton instanceTwo = null;
        LazyInitializedSingleton instanceThree = null;

        try {
            Constructor[] constructors = LazyInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instanceTwo = (LazyInitializedSingleton) constructor.newInstance();
                instanceThree = (LazyInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
        System.out.println(instanceThree.hashCode());
    }

}