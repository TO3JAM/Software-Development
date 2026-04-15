public class TheInteger {
    private int value;

    public TheInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean Even() { return value % 2 == 0; }
    public boolean Odd() { return value % 2 != 0; }
    public boolean Prime() {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
    public static boolean Even(int n) { return n % 2 == 0; }
    public static boolean Odd(int n) { return n % 2 != 0; }
    public static boolean Prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static boolean Even(TheInteger m) { return m.Even(); }
    public static boolean Odd(TheInteger m) { return m.Odd(); }
    public static boolean Prime(TheInteger m) { return m.Prime(); }

    public boolean equals(int n) { return this.value == n; }
    public boolean equals(TheInteger m) { return this.value == m.value; }

    public static int parseInt(char[] chars) {
        int result = 0;
        for (char c :  chars) {
            result = result * 10 + (c - '0');
        }
        return result;
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        TheInteger num1 = new TheInteger(16);
        TheInteger num2 = new TheInteger(82);
        
        System.out.println("The Number 1: " + num1.getValue());
        System.out.println("Is even: " + num1.Even());
        System.out.println("Is odd: " + num1.Odd());
        System.out.println("Is prime: " + num1.Prime());
        System.out.println("\nNumber 2: " + num2.getValue());
        System.out.println("Is even: " + num2.Even());
        System.out.println("Is odd: " + num2.Odd());
        System.out.println("Is prime: " + num2.Prime());
        System.out.println("\nStatic methods:");
        System.out.println("Is 15 even? " + TheInteger.Even(15));
        System.out.println("Is 15 odd? " + TheInteger.Odd(15));
        System.out.println("Is 15 prime? " + TheInteger.Prime(15));
        char[] digits = {'1', '2', '3', '4'};
        System.out.println("\nParsed char: " + TheInteger.parseInt(digits));
        System.out.println("Parsed string: " + TheInteger.parseInt("2861"));
    }
}
