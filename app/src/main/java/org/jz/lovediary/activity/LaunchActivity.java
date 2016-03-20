package org.jz.lovediary.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import org.jz.lovediary.R;
import org.jz.lovediary.application.Globals;
import org.jz.lovediary.factory.ApplicationInitializor;
import org.jz.lovediary.factory.Initializor;
import org.jz.lovediary.fragment.DiaryEntryFragment;
import org.jz.lovediary.fragment.SplashScreenFragment;


/**
 * Created by JZ on 3/4/2016.
 */
public class LaunchActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        Globals.appInitializor = new ApplicationInitializor();
        Globals.appInitializor.setOnBeforeListener(new Runnable()
        {
            @Override
            public void run()
            {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.container, new SplashScreenFragment(), "splashScreen");
                fragmentTransaction.commit();
            }
        });

        Globals.appInitializor.setOnAfterListener(new Runnable()
        {
            @Override
            public void run()
            {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                fragmentTransaction.replace(getFragmentManager().findFragmentByTag("splashScreen").getId(), new DiaryEntryFragment());
                fragmentTransaction.commit();
            }
        });

        Globals.appInitializor.initialize();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Globals.appInitializor.destory();
    }
}
