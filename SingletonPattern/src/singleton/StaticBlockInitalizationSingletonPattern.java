package singleton;

public class StaticBlockInitalizationSingletonPattern {

    private static final StaticBlockInitalizationSingletonPattern INSTANCE;

    /**
     * class가 로드될 때 instance가 생성되는 방법
     * instance 멤버변수 초기화와 함께 선언하여도 되지만,
     * 복잡한 로직을 처리하거나 예외 처리를 추가할 수 있으므로 정적 블록을 사용
     */
    static {
        INSTANCE = new StaticBlockInitalizationSingletonPattern();
    }

    private StaticBlockInitalizationSingletonPattern() {}

    public static StaticBlockInitalizationSingletonPattern getInstance() {
        return INSTANCE;
    }
}
