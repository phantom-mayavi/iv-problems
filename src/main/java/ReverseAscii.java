import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseAscii {
    public static void main(String[] args) {
        ReverseAscii myObj = new ReverseAscii();
        myObj.reverseStringByAscii("Test String!");
    }

    public void reverseStringByAscii(String s) {
        List<String> str = new ArrayList<>();
        str.stream().map(s1 -> s1 + "").collect(Collectors.toList());
        List<CharDetails> charDetails = new ArrayList<>();
        AtomicInteger pos = new AtomicInteger(0);
        s.chars().forEach(value -> {
            System.out.println(value);
            CharDetails charDetails1 = new CharDetails();
            charDetails1.ascii = value;
            charDetails1.position = pos.getAndIncrement();
            charDetails1.ch = (char) value;
            charDetails.add(charDetails1);
        });

        Collections.sort(charDetails, Comparator.comparingInt(o -> o.ascii));
        charDetails.stream().forEach(System.out::println);
    }

    class CharDetails {
        Character ch;
        int position;
        int ascii;

        @Override
        public String toString() {
            return "CharDetails{" +
                    "ch=" + ch +
                    ", position=" + position +
//                    ", ascii=" + ascii +
                    '}';
        }
    }
}
