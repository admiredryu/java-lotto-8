package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputView {

    public int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String raw = Console.readLine();
        int money = parseInt(raw);
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return money;
    }

    public int[] inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();


        int[] nums = Arrays.stream(input.split("\\s*,\\s*"))
                .map(String::trim)
                .mapToInt(this::parseInt)
                .toArray();

        if (nums.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }


        boolean[] seen = new boolean[46];
        for (int n : nums) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 번호는 1~45 범위여야 합니다.");
            }
            if (seen[n]) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }
            seen[n] = true;
        }
        return nums;
    }


    public int inputBonusNumber(int[] winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = parseInt(Console.readLine());

        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1~45 범위여야 합니다.");
        }
        for (int n : winningNumbers) {
            if (n == bonus) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        }
        return bonus;
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
