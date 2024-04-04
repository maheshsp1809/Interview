package Microsoft.LLD.ExceptionDesign;

import java.util.*;

class ExceptionUtil {
    private static ExceptionUtil instance;
    private Map<String, Exception> exceptionMap;

    private ExceptionUtil() {
        exceptionMap = new HashMap<>();
    }

    public static ExceptionUtil getInstance() {
        if (instance == null) {
            synchronized (ExceptionUtil.class) {
                if (instance == null) {
                    instance = new ExceptionUtil();
                }
            }
        }
        return instance;
    }

    public void registerException(String key, Exception exception) {
        exceptionMap.put(key, exception);
    }

    public Exception getException(String key) {
        return exceptionMap.get(key);
    }
}
