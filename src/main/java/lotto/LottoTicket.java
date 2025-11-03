package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private final List<Lotto> tickets;

    private LottoTicket(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static LottoTicket generate(int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            list.add(new Lotto(nums));
        }
        return new LottoTicket(list);
    }

    public int getCount() { return tickets.size(); }

    public List<Lotto> getTickets() { return tickets; }
}
