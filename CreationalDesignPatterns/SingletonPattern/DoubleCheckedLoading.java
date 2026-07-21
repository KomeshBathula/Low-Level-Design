package CreationalDesignPatterns.SingletonPattern;

class DoubleCheckedLoading {
    private static DoubleCheckedLoading lazyLoading;

    private DoubleCheckedLoading() {

    }

    public static DoubleCheckedLoading getInstance() {
        if (lazyLoading == null) {
            synchronized(DoubleCheckedLoading.class) {
                // double check 
                if (lazyLoading == null) 
                    lazyLoading = new DoubleCheckedLoading();
            }
        }
            
        
        return lazyLoading;
    }
}

class Main2 {
    public static void main(String[] args) {
        DoubleCheckedLoading doubleCheckedLoading = DoubleCheckedLoading.getInstance();

        DoubleCheckedLoading doubleCheckedLoading2 = DoubleCheckedLoading.getInstance();

        System.out.println(doubleCheckedLoading);
        System.out.println(doubleCheckedLoading2);

    }
}
