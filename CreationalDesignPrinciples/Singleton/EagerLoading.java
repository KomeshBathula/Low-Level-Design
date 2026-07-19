package CreationalDesignPrinciples.Singleton;

class EagerLoading {
    private static final EagerLoading eagerLoading = new EagerLoading();

    private EagerLoading() {

    }

    public static EagerLoading getInstance() {
        return eagerLoading;
    }
}

class Main {
    public static void main(String[] args) {
        EagerLoading eagerLoading = EagerLoading.getInstance();
        EagerLoading eagerLoading2 = EagerLoading.getInstance();

        System.out.println(eagerLoading);
        System.out.println(eagerLoading2);
    }
}
