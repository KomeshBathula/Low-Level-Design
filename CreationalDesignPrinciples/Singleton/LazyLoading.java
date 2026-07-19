package CreationalDesignPrinciples.Singleton;

class LazyLoading {
    private static LazyLoading lazyLoading;

    private LazyLoading() {

    }

    public static LazyLoading getInstance() {
        if (lazyLoading == null)  
            lazyLoading = new LazyLoading();
        
        return lazyLoading;
    }
}

class Main1 {
    public static void main(String[] args) {
        LazyLoading lazyLoading = LazyLoading.getInstance();

        LazyLoading lazyLoading2 = LazyLoading.getInstance();

        System.out.println(lazyLoading);
        System.out.println(lazyLoading2);
    }
}
