// Double Checked Locking based Java implementation of
// singleton design pattern
class Singleton4 {
    private static volatile Singleton4 obj = null;
    private Singleton4() {}

    public static Singleton4 getInstance()
    {
        if (obj == null) {
            // To make thread safe
            synchronized (Singleton4.class)
            {
                // check again as multiple threads
                // can reach above step
                if (obj == null)
                    obj = new Singleton4();
            }
        }
        return obj;
    }
}