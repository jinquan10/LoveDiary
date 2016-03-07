package org.jz.lovediary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import org.jz.lovediary.R;
import org.jz.lovediary.Util.Utils;

/**
 * Created by JZ on 3/6/2016.
 */
public class SplashScreenFragment extends Fragment {
    private RelativeLayout layoutContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutContainer = (RelativeLayout) inflater.inflate(R.layout.splash_screen, container, false);
        layoutContainer.setAlpha(0f);

        return layoutContainer;
    }

    @Override
    public void onStart() {
        super.onStart();

        Utils.logD("onStart");

        layoutContainer.animate()
                .alpha(1f)
                .setDuration(1000l)
                .start();
    }

    @Override
    public void onStop() {
        super.onStop();

        Utils.logD("onStop");

        layoutContainer.animate()
                .alpha(0f)
                .setDuration(1000l)
                .start();
    }
}
