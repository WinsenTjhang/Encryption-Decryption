import java.util.Scanner;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        String i = scanner.nextLine();
//        if (i.isEmpty()) {
            BurgerStore burgerStore = new BurgerStore();
            Burger chinese = burgerStore.orderBurger("Chinese");
            Burger american = burgerStore.orderBurger("American");
            Burger Russian = burgerStore.orderBurger("Russian");
//        }


    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are unable to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println(burger.getName() + " ready" + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese":
                return new ChineseBurger();
            case "American":
                return new AmericanBurger();
            case "Russian":
                return new RussianBurger();
            default:
                return null;
        }
    }
}

abstract class Burger {
    private String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting patty");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {
    ChineseBurger() {
        super("Chinese Burger");
    }
}

class AmericanBurger extends Burger {
    AmericanBurger() {
        super("American Burger");
    }
}

class RussianBurger extends Burger {
    RussianBurger() {
        super("Russian Burger");
    }
}