package CreationalDesignPrinciples.Singleton;

class StaticNestedInnerClass {
    private StaticNestedInnerClass() {

    }

    private static class InnerClass {
        private static final StaticNestedInnerClass obj = new StaticNestedInnerClass();
    }

    public static StaticNestedInnerClass getInstance() {
        return InnerClass.obj;
    }
}

class MainForStaticNestedInnerClass {
    public static void main(String[] args) {
        StaticNestedInnerClass obj = StaticNestedInnerClass.getInstance();
        System.out.println(obj);
    }
}