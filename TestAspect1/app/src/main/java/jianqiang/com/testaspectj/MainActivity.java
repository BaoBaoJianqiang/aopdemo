package jianqiang.com.testaspectj;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testAOP();
        testAOP2();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void testAOP() {
        Log.d("jianqiang", "testAOP");
    }

    @DebugTool
    public void testAOP2() {
        Log.d("jianqiang", "testAOP2");
    }
}
