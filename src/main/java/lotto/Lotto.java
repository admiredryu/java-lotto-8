package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 한 장은 정확히 6개 숫자여야 합니다.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위여야 합니다.");
            }
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() { return numbers; }

    @Override
    public String toString() { return numbers.toString(); }
}