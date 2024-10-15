import java.lang.reflect.Constructor;
public class LazyInitializedSingleton {

    public static LazyInitializedSingleton instance;

    public LazyInitializedSingleton(){}

    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}