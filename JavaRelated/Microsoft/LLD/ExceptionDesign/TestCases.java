package Microsoft.LLD.ExceptionDesign;

class TestCases {
    public void testSingleton() {
        ExceptionUtil instance1 = ExceptionUtil.getInstance();
        ExceptionUtil instance2 = ExceptionUtil.getInstance();

        // Check if both instances are the same
        assert instance1 == instance2;
    }

    public void testRegisterException() {
        ExceptionUtil exceptionUtil = ExceptionUtil.getInstance();
        Exception myException = new Exception("My Exception");
        exceptionUtil.registerException("MyException", myException);

        // Check if the exception is registered correctly
        assert exceptionUtil.getException("MyException") == myException;
    }

    public void testGetException() {
        ExceptionUtil exceptionUtil = ExceptionUtil.getInstance();
        Exception myException = new Exception("My Exception");
        exceptionUtil.registerException("MyException", myException);

        // Check if the correct exception is retrieved
        assert exceptionUtil.getException("MyException") == myException;

        // Check if null is returned for a non-existent key
        assert exceptionUtil.getException("NonExistentException") == null;
    }
}
