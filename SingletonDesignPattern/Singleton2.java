class Singleton2 {
    private static Singleton obj;
    private Singleton2() {}

    // Only one thread can execute this at a time
    public static synchronized Singleton getInstance()
    {
        if (obj == null)
            obj = new Singleton();
        return obj;
    }
}
//using sinchronized when two threads are trying to create same object
