package com.example.b.test4;

/**
 * Created by b on 1/18/2016.
 */
public class MyUtil {


    private static final int CLIENT_CODE_STACK_INDEX;

    static {
        int i = 0;
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            i++;
            if (ste.getClassName().equals(MyUtil.class.getName())) {
                break;
            }
        }
        CLIENT_CODE_STACK_INDEX = i;
    }



    public static String methodName() {
        return Thread.currentThread().getStackTrace()[CLIENT_CODE_STACK_INDEX].getMethodName();
    }

}
