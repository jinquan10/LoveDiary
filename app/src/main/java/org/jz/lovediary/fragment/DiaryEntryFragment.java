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
import org.jz.lovediary.storage.entity.DiaryEntry;
import org.jz.lovediary.storage.rules.SimpleEditTextPersistenceRule;

import java.util.Date;


/**
 * Created by JZ on 3/4/2016.
 */
public class DiaryEntryFragment extends Fragment
{
    private RelativeLayout layoutContainer;
    private EditText editText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        layoutContainer = (RelativeLayout) inflater.inflate(R.layout.diary_entry, container, false);

        editText = (EditText) layoutContainer.findViewById(R.id.editText);
        editText.setHint(org.jz.lovediary.util.Utils.DEFAULT_DATE_FORMATTER.format(new Date()).toString());

        //        List<DiaryEntry> entries = new;
        //
        DiaryEntry entry = null;
        //        if (entries.size() == 1) {
        //            entry = entries.get(0);
        //            if (Utils.isFromToday(entry.getLastUpdated())) {
        //                editText.setText(entry.getEntry());
        //            } else {
        //                entry = new DiaryEntry();
        //            }
        //        } else if (entries.size() == 0) { // no entries yet
        //            entry = new DiaryEntry();
        //        } else if (entries.size() != 1) {
        //            throw new RuntimeException("Expected one DiaryEntry");
        //        }

        editText.addTextChangedListener(new SimpleEditTextPersistenceRule(entry));

        return layoutContainer;
    }
}
