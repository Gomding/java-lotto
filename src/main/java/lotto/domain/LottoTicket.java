package lotto.domain;

import java.util.*;

public class LottoTicket {

    private static final int TOTAL_NUMBER_COUNT = 12;
    private static final int VALID_NUMBER_COUNT = 6;
    private static final String NULL_ERROR_MESSAGE = "null값은 허용하지 않습니다.";
    private static final String EMPTY_ERROR_MESSAGE = "숫자는 하나 이상이어야 합니다.";
    private static final String COUNT_ERROR_MESSAGE = "숫자는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 존재합니다.";

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        Objects.requireNonNull(lottoNumbers, NULL_ERROR_MESSAGE);
        validateLottoTicket(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoRank getRank(final LottoWinner lottoWinner) {
        int matchCount = calculateMatchCount(lottoWinner.getLottoWinnerTicket());
        boolean matchBonusNumber = lottoNumbers.contains(lottoWinner.getLottoWinnerBonusNumber());
        return LottoRank.matchLottoRank(matchCount, matchBonusNumber);
    }

    private int calculateMatchCount(final LottoWinnerTicket lottoWinnerTicket) {
        Set<LottoNumber> matchingCheckContainer = new HashSet<>(lottoNumbers);
        matchingCheckContainer.addAll(lottoWinnerTicket.getLottoNumbers());
        return TOTAL_NUMBER_COUNT - matchingCheckContainer.size();
    }

    private void validateLottoTicket(final List<LottoNumber> lottoNumbers) {
        validateEmptyTicket(lottoNumbers);
        validateCount(lottoNumbers);
        validateDuplicate(lottoNumbers);
    }

    private void validateEmptyTicket(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateDuplicate(final List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> uniqueLottoNumbers = new HashSet<>(lottoNumbers);
        if (uniqueLottoNumbers.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateCount(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() == VALID_NUMBER_COUNT) {
            return;
        }
        throw new RuntimeException(COUNT_ERROR_MESSAGE);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
