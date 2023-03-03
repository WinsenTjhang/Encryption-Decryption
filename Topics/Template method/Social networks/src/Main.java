import java.util.Scanner;

abstract class SocialNetwork {

    public void connect() {
        logIn();
        post();
        logOut();
    }

    abstract void logIn();

    abstract void post();

    abstract void logOut();

}

class Instagram extends SocialNetwork{
     void logIn() {
         System.out.println("Log into Instagram");
     }

     void post() {
         System.out.println("Post: Hello, Instagram!");
     }

    void logOut() {
         System.out.println("Log out of Instagram");
     }
}


class Facebook extends SocialNetwork{
  void logIn() {
         System.out.println("Log into Facebook");
     }

    void post() {
         System.out.println("Post: Hello, Facebook!");
     }

    void logOut() {
         System.out.println("Log out of Facebook");
     }
}

// Do not change the code below
class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        SocialNetwork network = null;
        if ("facebook".equalsIgnoreCase(type)) {
            network = new Facebook();
        } else if ("instagram".equalsIgnoreCase(type)) {
            network = new Instagram();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        network.connect();
    }
}
