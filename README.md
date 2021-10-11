# 자동차 경주 게임

## 진행 방법

* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 요구사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표 (,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
- 우승자가 한 명 이상일 경우, 쉼표(,)로 이름을 구분해 출력한다.
- 사용자가 잘못된 값을 입력할 경우 “[ERROR]”로 시작하는 에러 메시지를 출력 후 입력을 다시 받는다.

## 프로그래밍 요구사항

- 자동차 경주 게임을 실행하는 시작점은 `src/main/java` 폴더의 `racinggame.Application` 의 `main()` 이다.
- 자동차 경주 게임은 `JDK8` 버전에서 실행가능해야 한다. `JDK8` 에서 정상 동작하지 않을 경우 0점 처리한다.
- JDK 에서 기본 제공하는 Random,Scanner API 대신 **nextstep.utils 패키지에서 제공하는 Randoms,ConsoleAPI** 를 활용해구현해야한다.
- Random 값 추출은 nextstep.utils.Randoms 의 `pickNumberInRange()` 를 활용한다.
- 사용자가 입력하는 값은 `nextstep.utils.Console의readLine()` 을활용한다.
- 프로그램 구현을 완료 했을 때 `src/test/java` 폴더의 `racinggame.ApplicationTest` 에있는 2개의 TestCase 가 성공해 야한다.
- `ApplicationTest` 에서 제공하는 2개의 TestCase 는 자동차 경주 게임을 위한 최소한의 TestCase 이다.
- 필수요구사항은 아니지만 제공하는 소스코드를 참고해 자동차 경주 게임을 위한 모든 TestCase 를 추가 해보는것 도 테스트에 대한 좋은 연습이 될 수 있다.

---

- 자바 코드 컨벤션을 지키면서 프로그래밍 한다.
- [https://naver.github.io/hackday-conventions-java/](https://naver.github.io/hackday-conventions-java/)
- indent(인덴트,들여쓰기) depth 를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
- 예를들어 while 문 안에 if 문이 있으면 들여쓰기는 2이다.
- 힌트:indent(인덴트,들여쓰기) depth 를 줄이는 좋은 방법은 함수(또는 메소드)를 분리 하면 된다.
- 자바8 에 추가된 `streamapi` 를 사용하지 않고 구현 해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
- 힌트: if 조건절 에서 값을 `return` 하는 방식 으로 구현하면 else 를 사용하지 않아도 된다.
- else 를 쓰지 말라고 하니 switch/case 로 구현 하는 경우가 있는데 `switch/case` 도 허용 하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

--- 

- 일급 콜렉션을 활용해 구현한다
  - [참고문서](https://developerfarm.wordpress.com/2012/02/01/object_calisthenics_)
- 모든 원시값과 문자열을 포장한다.
  - [참고문서](https://developerfarm.wordpress.com/2012/01/27/object_calisthenics_4)

## 기능구현 목록
- [x] `레이싱카`는 5자 이하의 이름, `랩` 를 가진다.
  - [x] 이름이 5자를 초과할 경우, `[ERROR] 경주할 자동차의 이름이 5자 초과하였습니다.` 라는 에러가 발생 한다.
  - [x] 이름이 없을 경우, `[ERROR] 경주할 자동차의 이름을 입력해주세요.` 라는 에러가 발생 한다.
- [x] `레이싱카`는 `레이스`를 할 수 있다.
  - [x] `레이스`는 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3이하의 값이면 멈춘다.
- [x] `레이싱카그룹`은 쉼표(`,`)를 기준으로 구분하여 `레이싱카` 를 생성 할 수 있다.
- [x] `레이싱카게임`은 경주에 참여할 `레이싱카그룹` 을 게임의 참여 시킬 수 있다.
- [x] `레이싱카게임`은 라운드 마다 `레이싱카그룹` 을 레이스 시킬 수 있다.
- [x] `레이싱카게임`은 모든 라운드가 끝나면 종료된다.
- [x] `레이싱카게임`은 종료시 후 우승한 `레이싱카그룹`을 알 수 있다.
---
- [x] `레이싱카게임 컨트롤러`는 `레이싱카 이름들`과 라운드 횟수를 통해  `레이싱카게임` 을 생성 할 수 있다.
  - [x] 콘솔로 부터 `경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로구분)` 라는 메시지와 함께 `레이싱카 이름들`을 받을 수 있다.
  - [x] 콘솔로 부터 `시도할 회수는 몇 회인가요?` 라는 메시지 와 함께 `라운드 횟수`를 입력 받을 수 있다.
    - [x] 라운드 횟수는 숫자형태의 문자열만 입력 가능하다. (ex. 5)
    - [x] 숫자 형태가 아닐 경우 `[ERROR] 시도할 횟수는 숫자만 입력 가능합니다.` 라는 에러가 발생 한다.
- [ ] `레이싱카게임 뷰`는 레이싱카게임 실행 결과를 확인 할 수 있다. 
  - [ ] 라운드 마다 레이스 결과를 확인 할 수 있다.
  - [ ] `레이싱카게임 뷰`는 우승한 `레이싱카그룹` 의 레이싱카 이름을 출력 할 수 있다.
    - [ ] 크기가 2 이상일 경우, 쉼표(,)로 이름을 구분해 출력할 수 있다.
  - 출력 예시
    ```
      실행결과
      pobi:-
      crong:
      honux:-
    
      pobi:--
      crong:-
      honux:--
    
      최종 우승자는 pobi,honux 입니다.
      ```


## 용어 사전

| 한글명 | 영문명 | 설명 |
| ---------- | :--------- | :---------- |
| 레이싱카 | racingCar | 경주 할 자동차 |
| 레이싱카게임 | racingCarGame | 레이싱카게임을 진행하는 주최  |
| 레이싱카그룹 | racingCarGroups | 레이싱카게임의 참여하는 레이싱카 리스트 |
| 레이스 | racing | 라운드의 레이싱을 하는 행위 |
| 랩 | lap | 앞으로 전진한 횟수 | 
| 우승 | victory | 레이싱카게임 에서 가장 랩을 가진 레이싱카 |
