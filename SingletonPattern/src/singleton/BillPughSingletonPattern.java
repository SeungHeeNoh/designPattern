package singleton;

public class BillPughSingletonPattern {

    private BillPughSingletonPattern() {}

    /**
     * 클래스 안에 정적 내부 클래스를 두어 싱글톤 인스턴스를 관리하는 방법
     * 클래스가 로드될 때 초기화되지 않다가 getInstance 메서드가 호출될 때 로드되므로
     * 지연 초기화와 동기화 문제를 해결
     */
    private static class SingletonHolder {
        private static final BillPughSingletonPattern INSTANCE = new BillPughSingletonPattern();
    }

    public static BillPughSingletonPattern getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
