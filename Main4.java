package org.itstep;

public class Main4 {
    public interface Capsule {}

    static public class Capsule1 implements Capsule {
    }

    static public class Capsule2 implements Capsule {
    }

    public interface Cleaner {}

    static public class CoffeeMaker<Template extends Capsule, Template2 extends Cleaner> {
        private Template capsule;

        public Template getCapsule() {
            return capsule;
        }

        public void setCapsule(Template capsule) {
            this.capsule = capsule;
        }

        void open(Template capsule) {
            // сложная логика
        }

        void utilize(Template capsule) {
        }

        void clean(Template2 cleaner) {
            // cleaner.....
        }
    }

    static class Fairy implements Cleaner {}
    static class Aos implements Cleaner {}

    public static void main(String[] args) {
        CoffeeMaker<Capsule2, Fairy> cm2 = new CoffeeMaker<>();
        CoffeeMaker<Capsule1, Fairy> cm1 = new CoffeeMaker<>();
        Fairy f = new Fairy();
        Aos a = new Aos();
        cm2.clean(f);
//        cm2.clean(a); Так нельзя делать!
    }
}
