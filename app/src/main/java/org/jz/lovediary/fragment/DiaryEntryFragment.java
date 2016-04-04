package org.jz.lovediary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jz.lovediary.R;
import org.jz.lovediary.widget.DiaryEntriesLayout;


/**
 * Created by JZ on 3/4/2016.
 */
public class DiaryEntryFragment extends Fragment {
    private DiaryEntriesLayout layoutContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return layoutContainer = (DiaryEntriesLayout) inflater.inflate(R.layout.diary_entries, container, false);
    }
}
