package lotto;

public class OutputView {

    public void printPurchasedLotto(LottoTicket ticket) {
        System.out.println(ticket.getCount() + "개를 구매했습니다.");
        ticket.getTickets().forEach(System.out::println);
    }

    public void printResult(WinnerChecker checker) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println("3개 일치 (5,000원) - " + checker.getCount(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + checker.getCount(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + checker.getCount(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + checker.getCountBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + checker.getCount(6) + "개");

        System.out.println("총 수익률은 " + checker.getProfitRate() + "%입니다.");
    }
}
