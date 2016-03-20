package org.jz.lovediary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;

import org.jz.lovediary.R;
import org.jz.lovediary.application.Globals;
import org.jz.lovediary.storage.entity.DiaryEntry;
import org.jz.lovediary.storage.rules.SimpleEditTextPersistenceRule;
import org.jz.lovediary.util.Utils;

import java.util.Date;
import java.util.List;


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

        DiaryEntry diaryEntry = DiaryEntry.getLatest();

        if (diaryEntry == null) {
            diaryEntry = new DiaryEntry();
        } else if (Utils.isFromToday(diaryEntry.getLastUpdated()))
        {
            editText.setText(diaryEntry.getEntry());
        }

        editText.addTextChangedListener(new SimpleEditTextPersistenceRule(diaryEntry));

        return layoutContainer;
    }
}
