package singleton;

public class DoubleCheckedLockingSingleton {

    private static volatile DoubleCheckedLockingSingleton INSTANCE;

    private DoubleCheckedLockingSingleton() {}

    /**
     * volatile 키워드를 이용하여 메모리 가시성 문제 해결
     * volatile를 사용하면 변수의 값이 각 쓰레드의 캐시에 저장되지 않고 항상 메인 메모리에서
     * 읽고 쓰이기 때문에 최신 값이 보장
     *
     * 하지만 원자성을 보장하지 않기 때문에 synchronized와 같은 다른 동기화 기법 필요
     */
    public static DoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }

        return INSTANCE;
    }
}
