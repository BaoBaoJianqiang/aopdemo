package jianqiang.com.testaspectj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testWithin();
        testTryCatch();


        testAOP1_demo5();
        testAOP2_demo5();
    }

    public void testWithin() {

    }

    public void testTryCatch() {
        View view = null;
        view.animate();
    }


    public void testAOP_demo5() {
        Log.d("jianqiang", "testAOP");
    }

    public void testAOP1_demo5() {
        testAOP_demo5();
    }

    public void testAOP2_demo5() {
        testAOP_demo5();
    }
}
