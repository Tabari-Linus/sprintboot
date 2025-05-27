import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
int[] nums = {};
System.out.println(removeDuplicates(nums));
    }

    static int removeDuplicates(int[] numbers) {
        if (numbers.length == 0) return 0;

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if(!list.contains(numbers[i])) {
                list.add(numbers[i]);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            numbers[i] = list.get(i);
        }
        return list.size();
    }
}