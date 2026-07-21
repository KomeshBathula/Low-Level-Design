package CreationalDesignPatterns.SingletonPattern;

class SynchronizedLazyLoading {
    private static SynchronizedLazyLoading lazyLoading;

    private SynchronizedLazyLoading() {

    }

    public static synchronized SynchronizedLazyLoading getInstance() {
        if (lazyLoading == null)  
            lazyLoading = new SynchronizedLazyLoading();
        
        return lazyLoading;
    }
}

class Main {
    public static void main(String[] args) {
        SynchronizedLazyLoading lazyLoading = SynchronizedLazyLoading.getInstance();

        SynchronizedLazyLoading lazyLoading2 = SynchronizedLazyLoading.getInstance();

        System.out.println(lazyLoading);
        System.out.println(lazyLoading2);
    }
}
