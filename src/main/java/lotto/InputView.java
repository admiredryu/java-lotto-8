package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class InputView {

    public int inputMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = parseInt(input);

        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
        return money;
    }

    public int[] inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        int[] nums = Arrays.stream(input.split(","))
                .map(String::trim)
                .mapToInt(this::parseInt)
                .toArray();

        if (nums.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        // 범위/중복 검사
        boolean[] seen = new boolean[46];
        for (int n : nums) {
            if (n < 1 || n > 45) throw new IllegalArgumentException("[ERROR] 번호는 1~45 범위여야 합니다.");
            if (seen[n]) throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안 됩니다.");
            seen[n] = true;
        }
        return nums;
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNum = parseInt(input);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 범위여야 합니다.");
        }
        return bonusNum;
    }

    private int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}
