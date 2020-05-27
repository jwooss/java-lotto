# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계

### 기능 요구사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 
(예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
- 앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 
커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

### 기능 요구사항 분리
1. StringAddCalculator
   - [x] 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
   - [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.
   - [x] 숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.
   - [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.
   - [x] “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.
   - [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.
2. FormulaSplitter
   - [x] 컴마(,) 구분자로 문자를 분할하여 Operand 리스트를 반환한다.
   - [x] 콜론(:) 구분자로 문자를 분할하여 Operand 리스트를 반환한다.
   - [x] 커스텀 구분자가 존재하면 커스텀 구분자를 사용해서 분할해야 한다
3. Formula
   - [x] 입력한 계산식을 상태로 가지고 있는다.
   - [x] 빈 문자열 또는 null 여부를 확인할 수 있어야 한다.
4. Operand
   - [x] 객체 생성시 숫자 이외의 경우 RuntimeException 예외가 발생해야 한다.

## 2단계

### 기능 요구사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

### 기능 요구사항 분리
- Money
  - [x] 보유한 돈으로 물품을 구입할 수 있는지 확인할 수 있어야 한다.
  - [x] 보유한 돈을 차감할 수 있어야 한다.
  - [x] 보유 금액보다 큰 금액을 차감하면 RuntimeException이 발생한다
- LottoMachine
  - [ ] 입력한 금액으로 1,000원당 1장의 로또 티켓을 반환한다.
- LottoTicketGenerator
- LottoTicket
- LottoTickets
- LottoNumberGenerator
- LottoNumber
  - [x] 로또 번호는 1 ~ 45까지만 입력이 가능하다
  - [x] 로또 번호 범위를 벗어나면 RuntimeException이 발생한다.
- LottoNumbers
  - [x] 로또 번호가 6개가 아니면 RuntimeException이 발생한다
