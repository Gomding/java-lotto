# java-lotto
로또 미션 진행을 위한 저장소

## 기능 요구사항
### TDD
- [x] LottoNumber.java 숫자를 생성한다.
    - [x] 예외 : 숫자는 1 ~ 45 사이의 숫자여야한다.
- [x] LottoTicket.java 로또 티켓을 생성한다. 정렬해야한다.
    - [x] 예외 : 총 6개의 숫자여야 한다.
    - [x] 예외 : 중복이 없어야한다. (Set 사용)
- [x] LottoTickets.java 로또 티켓들을 가진다.
    - [x] 예외 : 유저가 구매한 만큼 티켓수를 가지고 있어야한다. 
- [x] LottoWinnerTicket.java 총 6개의 당첨번호를 생성한다. (보너스 번호도 포함한다.)
    - [ ] 예외 : 총 6개의 당첨 숫자와 1개의 보너스 숫자는 중복이 없어야 한다.
- [ ] WinStatistics.java 정보가 맞는지 확인한다.
    - [ ] FIRST_PLACE(200000000000, 당첨 횟수)
    - [ ] 2등,3등,4등,5등 까지 동일하게 한다. 
- [ ] LottoService.java 당첨 번호를 바탕으로 맞춘 개수를 정확하게 Winstatics에 전달하는지 확인한다.
### Non TDD
- [ ] InputView.java 구매 금액을 입력 받는다.
- [ ] OutputView.java
    - [ ] 유저에게 얼마 구할건지 물어본다.
    - [ ] 로또 번호를 출력한다.
    - [ ] 당첨 번호를 출력한다. (보너스 번호까지)
    - [ ] 당첨 통계를 출력한다.
- [ ] LottoController 입력받은 내용을 LottoService에게 전달하고 결과를 OutputView에게 넘겨준다.


```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 30%입니다.
```

