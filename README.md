# designPattern
design pattern을 공부하고 구현하였습니다.

## Spec
- jdk 17


## study log
<table>
    <tr>
        <th>study_date</th>
        <th>design_pattern_name</th>
        <th>참고자료</th>
        <th>개선점</th>
    </tr>
    <tr>
        <td>2024.06.25</td>
        <td>Abstarct Factory Pattern</td>
        <td>박은종의 객체지향 설계를 위한 디자인패턴 with 자바 > ch02_03. Abstract Factory</td>
        <td><span style="display: block">개선 keyword : stream, 응집도</span>- Main 클래스가 아닌 DaoFactory에서 DB 지원여부 확인가능하도록 isSupportDBDriver 메서드 추가</td>
    </tr>
    <tr>
        <td>2024.06.30</td>
        <td>Template Method Pattern</td>
        <td>박은종의 객체지향 설계를 위한 디자인패턴 with 자바 > ch03_01.Template Method</td>
        <td><span style="display: block">개선 keyword : stream, 일급컬렉션, Junit5테스트, 응집도</span>- Level를 일급 컬렉션으로 관리하여 Level과 관련된 처리 위임<br>- 획득한 경험치 기반으로 Level up이 가능하도록 변경<br>- Experience Class를 생성함으로써 경험치와 관련된 처리를 응집도있게 관리하고자 함<br>- Junit5, assertj를 기반으로 Test code 작성</td>
    </tr>
</table>