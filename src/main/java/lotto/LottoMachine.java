package lotto;

public class LottoMachine {

    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int money = inputView.inputMoney();
        int count = money / 1000;

        LottoTicket ticket = LottoTicket.generate(count);
        outputView.printPurchasedLotto(ticket);

        int[] winningNumbers = inputView.inputWinningNumbers();
        int bonus = inputView.inputBonusNumber(winningNumbers); // ← 변경 포인트

        WinnerChecker checker = new WinnerChecker(winningNumbers, bonus, money); // spentMoney 전달
        checker.check(ticket);
        outputView.printResult(checker);
    }
}
