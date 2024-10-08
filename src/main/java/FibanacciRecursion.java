public class FibanacciRecursion {
    public static void main(String[] args) {
        FibanacciRecursion myObj = new FibanacciRecursion();
        int count = 10;
        System.out.println("Fibanacci Logic 1....");
        myObj.fibinacciAdd(0, 1, count);
        System.out.println("Fibanacci Logic 1....");
        for (int i = 0; i < count; i++) {
            System.out.println(myObj.fibinacciAdd2(i));;
        }
    }

    private int fibinacciAdd2(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibinacciAdd2(n - 1) + fibinacciAdd2(n - 2);
        }
    }

    public void fibinacciAdd(int currNum, int nextNum, int counter) {
        if (counter > 0) {
            System.out.println(currNum);
            fibinacciAdd(nextNum, currNum + nextNum, --counter);
        }
    }
}
