package jianqiang.com.testaspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectDemo1 {

    private static final String TAG = "baobao";

    //demo 6    try
    @AfterThrowing(pointcut = "execution(* jianqiang.com.testaspectj.*.*(..))", throwing = "exception")
    public void catchExceptionMethod(Exception exception) {
        String message = exception.toString();
        Log.d(TAG, "catchExceptionMethod: " + message);
    }


//  demo5 withincode
    // 在testAOP2()方法内
    @Pointcut("withincode(* jianqiang.com.testaspectj.MainActivity.testAOP2_demo5(..))")
    public void invokeAOP2() {
    }

    // 调用testAOP()方法的时候
    @Pointcut("call(* jianqiang.com.testaspectj.MainActivity.testAOP_demo5(..))")
    public void invokeAOP() {
    }

    // 同时满足前面的条件，即在testAOP2()方法内调用testAOP()方法的时候才切入
    @Pointcut("invokeAOP() && invokeAOP2()")
    public void invokeAOPOnlyInAOP2() {
    }

    @Before("invokeAOPOnlyInAOP2()")
    public void beforeInvokeAOPOnlyInAOP2(JoinPoint joinPoint) {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onDebugToolMethodBefore: " + key);
    }
}
