package lotto;

import java.util.HashMap;
import java.util.Map;

public class WinnerChecker {

    private final int[] winning;
    private final int bonus;
    private final Map<Integer, Integer> matchCount = new HashMap<>();
    private int bonusMatch = 0;
    private int totalPrize = 0;
    private final int spentMoney;

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
            int count = match(winning, lotto.getNumbers());

            if (count == 5 && lotto.getNumbers().contains(bonus)) {
                bonusMatch++;
                totalPrize += 30000000;
            } else if (count >= 3) {
                matchCount.put(count, matchCount.get(count) + 1);
                totalPrize += prize(count);
            }
        }
    }

    private int prize(int count) {
        return switch (count) {
            case 3 -> 5000;
            case 4 -> 50000;
            case 5 -> 1500000;
            case 6 -> 2000000000;
            default -> 0;
        };
    }

    private int match(int[] a, java.util.List<Integer> b) {
        int c = 0;
        for (int n : a) if (b.contains(n)) c++;
        return c;
    }

    public int getCount(int n) {
        return matchCount.get(n);
    }

    public int getCountBonus() {
        return bonusMatch;
    }

    public double getProfitRate() {
        if (spentMoney <= 0) return 0;
        return Math.round((double) totalPrize / spentMoney * 100 * 10) / 10.0;
    }
}
