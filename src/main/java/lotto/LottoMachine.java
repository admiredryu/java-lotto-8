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
        int bonus = inputView.inputBonusNumber();

        WinnerChecker checker = new WinnerChecker(winningNumbers, bonus, money);
        checker.check(ticket);
        outputView.printResult(checker);
    }
}
