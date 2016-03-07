package org.jz.lovediary.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RelativeLayout;

import org.jz.lovediary.R;
import org.jz.lovediary.fragment.DiaryEntryFragment;

/**
 * Created by JZ on 3/4/2016.
 */
public class LaunchActivity extends Activity {

    private RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

//        container = (RelativeLayout) findViewById(R.id.container);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, new DiaryEntryFragment());
        fragmentTransaction.commit();
    }
}
