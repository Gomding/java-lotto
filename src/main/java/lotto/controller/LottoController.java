package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoTicketService;
import lotto.service.LottoTicketsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void lottoStart() {
        Money money = initMoney();
        LottoTickets lottoTickets = initLottoTickets(money);

        LottoWinnerTicket lottoWinnerTicket = initLottoWinnerTicket();
        LottoWinnerBonusNumber lottoWinnerBonusNumber = initLottoWinnerBonusNumber(lottoWinnerTicket);
        LottoWinner lottoWinner = new LottoWinner(lottoWinnerTicket, lottoWinnerBonusNumber);

        OutputView.printRewardResultBoard();
        LottoResultStatistics lottoResultStatistics =
                LottoResultStatistics.calculateResultStatistics(lottoTickets, lottoWinner);
        OutputView.printStatistics(lottoResultStatistics);
        OutputView.printFinalResult(lottoResultStatistics, money);
    }

    private Money initMoney() {
        Money money;
        try {
            money = new Money(InputView.getMoneyInput());
        } catch (NullPointerException | IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initMoney();
        }
        return money;
    }

    private LottoTickets initLottoTickets(Money money) {
        LottoTickets lottoTickets = LottoTicketsService.createLottoTickets(money);
        OutputView.printTickets(lottoTickets, money.getLottoCount());
        return lottoTickets;
    }

    private LottoWinnerTicket initLottoWinnerTicket() {
        try {
            return LottoTicketService.createLottoWinnerTicket(InputView.getWinnerNumbersInput());
        } catch (NullPointerException | IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initLottoWinnerTicket();
        }
    }

    private LottoWinnerBonusNumber initLottoWinnerBonusNumber(LottoWinnerTicket lottoWinnerTicket) {
        try {
            return new LottoWinnerBonusNumber(Integer.parseInt(InputView.getBonusNumberInput()), lottoWinnerTicket);
        } catch (NullPointerException | IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return initLottoWinnerBonusNumber(lottoWinnerTicket);
        }
    }
}