

class Problem {
    public static void main(String[] args) {
//        String operator = args[0];
        int n1 = Integer.parseInt(args[1]);
        int n2 = Integer.parseInt(args[2]);

        switch (args[0]){
            case "+" -> System.out.println(n1 + n2);
            case "-" -> System.out.println(n1 - n2);
            case "*" -> System.out.println(n1 * n2);
            default -> System.out.println("Unknown operator");
        }
    }
}