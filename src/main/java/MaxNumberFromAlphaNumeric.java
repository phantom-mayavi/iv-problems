import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumberFromAlphaNumeric {
    public static void main(String[] args) {
        MaxNumberFromAlphaNumeric myObj = new MaxNumberFromAlphaNumeric();
        System.out.println(myObj.maxNumber("100klh564abc365bg"));
        System.out.println(myObj.maxNumber2("100klh564abc365bg"));
    }

    public int maxNumber2(String inputString) {
        String[] numList = inputString.split("\\D+");

        return Arrays.stream(numList).filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);
    }

    public int maxNumber(String inputString) {
        int result = 0;
        StringBuilder currentNumber = new StringBuilder("");
        List<Integer> numbers = new ArrayList<>();
        for (char ch : inputString.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                currentNumber.append(ch);
            } else if (currentNumber.length() > 0) {
                numbers.add(Integer.parseInt(String.valueOf(currentNumber)));
                currentNumber = new StringBuilder("");
            }
        }

        if (numbers.size() > 0) {
            Collections.sort(numbers);
            result = numbers.get(numbers.size() - 1);
        }

        return result;
    }
}
