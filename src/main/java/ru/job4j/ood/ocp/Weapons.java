package ru.job4j.ood.ocp;

public class Weapons {

    private static class Tank {
        public void fire() {
            System.out.println("Tank fire");
        }
    }

    private static class Gun extends Tank {
        @Override
            public void fire() {
                System.out.println("Gun fire");
            }
    }
}
