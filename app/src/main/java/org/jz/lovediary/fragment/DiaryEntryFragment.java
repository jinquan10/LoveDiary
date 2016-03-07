package org.jz.lovediary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import org.jz.lovediary.R;
import org.jz.lovediary.widget.DiaryEditText;

/**
 * Created by JZ on 3/4/2016.
 */
public class DiaryEntryFragment extends Fragment {
    protected RelativeLayout layoutContainer;
    protected DiaryEditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutContainer = (RelativeLayout)inflater.inflate(R.layout.diary_entry, container, false);
        editText = (DiaryEditText) layoutContainer.findViewById(R.id.editText);

        return layoutContainer;
    }
}
