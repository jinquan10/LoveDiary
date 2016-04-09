package org.jz.lovediary.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import org.jz.lovediary.R;
import org.jz.lovediary.application.Globals;
import org.jz.lovediary.factory.ApplicationInitializor;
import org.jz.lovediary.fragment.SplashScreenFragment;
import org.jz.lovediary.util.Utils;


/**
 * Created by JZ on 3/4/2016.
 */
public class LaunchActivity extends Activity {
    private Fragment currFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        Globals.appInitializor = new ApplicationInitializor();
        Globals.appInitializor.setOnBeforeListener(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                currFragment = new SplashScreenFragment();
                fragmentTransaction.add(R.id.container, currFragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
            }
        });

        Globals.appInitializor.setOnAfterListener(new Runnable() {
            @Override
            public void run() {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                fragmentTransaction.remove(currFragment);
                currFragment = new org.jz.lovediary.fragment.CalendarFragment();
                fragmentTransaction.add(R.id.container, currFragment);
                fragmentTransaction.commit();

                Log.d(Utils.APP_TAG, "LaunchActivity.onCrea te()ed", null);
            }
        });
        Globals.appInitializor.initialize();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.remove(currFragment);

        Globals.appInitializor.destory();
        Log.d(Utils.APP_TAG, "LaunchActivity.onDestroy()");
    }
}
