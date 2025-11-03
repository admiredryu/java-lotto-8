package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerChecker {

    private final int[] winning;
    private final int bonus;
    private final int spentMoney;

    private final Map<Integer, Integer> matchCount = new HashMap<>();
    private int bonusMatch = 0;
    private int totalPrize = 0;

    public WinnerChecker(int[] winning, int bonus, int spentMoney) {
        this.winning = winning;
        this.bonus = bonus;
        this.spentMoney = spentMoney;

        matchCount.put(3, 0);
        matchCount.put(4, 0);
        matchCount.put(5, 0);
        matchCount.put(6, 0);
    }

    public void check(LottoTicket ticket) {
        for (Lotto lotto : ticket.getTickets()) {
            List<Integer> nums = lotto.getNumbers();
            int count = countMatch(nums);
            if (count == 5 && nums.contains(bonus)) {
                bonusMatch++;
                totalPrize += 30_000_000;
                continue;
            }
            if (count >= 3) {
                matchCount.put(count, matchCount.get(count) + 1);
                totalPrize += prize(count);
            }
        }
    }

    private int countMatch(List<Integer> nums) {
        int c = 0;
        for (int n : winning) if (nums.contains(n)) c++;
        return c;
    }

    private int prize(int count) {
        return switch (count) {
            case 3 -> 5_000;
            case 4 -> 50_000;
            case 5 -> 1_500_000;
            case 6 -> 2_000_000_000;
            default -> 0;
        };
    }

    public int getCount(int n) {
        return matchCount.get(n);
    }

    public int getCountBonus() {
        return bonusMatch;
    }

    // 소수점 첫째 자리 반올림
    public double getProfitRate() {
        if (spentMoney <= 0) return 0.0;
        double rate = (double) totalPrize / spentMoney * 100.0;
        return Math.round(rate * 10) / 10.0;
    }
}
