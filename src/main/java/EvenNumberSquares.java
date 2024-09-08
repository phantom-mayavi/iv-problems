import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenNumberSquares {
    public static void main(String[] args) {
        EvenNumberSquares myObj = new EvenNumberSquares();
        myObj.evenNumberSquares(10);
    }

    public void evenNumberSquares(int count) {
        List<Integer> mainNumList = new ArrayList<>();
        IntStream.rangeClosed(1, count).forEach(value -> mainNumList.add(value));
        List<Integer> evenSquareList = mainNumList.stream().filter(num -> num % 2 == 0)
                .map(num -> (int) Math.pow(num, 2))
                .collect(Collectors.toList());
        evenSquareList.forEach(System.out::println);
    }
}
