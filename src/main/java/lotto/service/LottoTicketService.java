package lotto.service;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinnerTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketService {

    private static final String DELIMITER = ",";
    private static final String COUNT_ERROR_MESSAGE = "당첨 숫자는 6개 넣어야 합니다.";

    private LottoTicketService() {
    }

    public static LottoTicket createLottoTicket() {
        List<LottoNumber> lottoNumbers = LottoNumber.getCache();
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(
                lottoNumbers
                        .stream()
                        .limit(6)
                        .sorted()
                        .collect(Collectors.toList()));
    }

    public static LottoWinnerTicket createLottoWinnerTicket(String input) {
        List<LottoNumber> lottoWinnerNumbers =
                Arrays.stream(input.split(DELIMITER))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList());
        if (lottoWinnerNumbers.size() != 6) {
            throw new IllegalArgumentException(COUNT_ERROR_MESSAGE);
        }
        return new LottoWinnerTicket(lottoWinnerNumbers);
    }

}
