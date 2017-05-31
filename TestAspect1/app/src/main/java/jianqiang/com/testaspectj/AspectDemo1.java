package jianqiang.com.testaspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectDemo1 {

    private static final String TAG = "baobao";

    //demo1
    @Before("execution(* android.app.Activity.on**(..))")
    public void doSomethingBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "在Activity生命周期的方法前执行: " + key);
    }

    //    demo2
//    @After("execution(* jianqiang.com.testaspectj.MainActivity.on*(android.os.Bundle))")
//    public void doSomethingAfter(JoinPoint joinPoint) throws Throwable {
//        String key = joinPoint.getSignature().toString();
//        Log.d(TAG, "在Activity生命周期的方法后执行: " + key);
//    }

    //    demo3
//    @Around("execution(* jianqiang.com.testaspectj.MainActivity.testAOP())")
//    public void doSomethingAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        String key = proceedingJoinPoint.getSignature().toString();
//        Log.d(TAG, "onActivityMethodAroundFirst: " + key);
//        proceedingJoinPoint.proceed();    //执行原先的方法，没有这句，就真的覆盖了
//        Log.d(TAG, "覆盖Activity生命周期的方法: " + key);
//    }

    //    demo4 自定义注解
    @Pointcut("execution(@jianqiang.com.testaspectj.DebugTool * *(..))")
    public void DebugToolMethod() {
    }

    @Before("DebugToolMethod()")
    public void onDebugToolMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(TAG, "onDebugToolMethodBefore: " + key);
    }
}
