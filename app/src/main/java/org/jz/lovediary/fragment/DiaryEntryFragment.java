package org.jz.lovediary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.jz.lovediary.R;
import org.jz.lovediary.application.Globals;
import org.jz.lovediary.entity.DiaryEntry;
import org.jz.lovediary.storage.rules.SimpleEditTextPersistenceRule;
import org.jz.lovediary.util.Utils;
import org.jz.lovediary.widget.DiaryEntriesView;
import org.jz.lovediary.widget.DiaryEntryView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by JZ on 3/4/2016.
 */
public class DiaryEntryFragment extends Fragment {
    private DiaryEntriesView layoutContainer;
    private ArrayAdapter<DiaryEntry> adapter;
    private List<SimpleEditTextPersistenceRule> textWatchers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layoutContainer = (DiaryEntriesView) inflater.inflate(R.layout.diary_entries, container, false);

        adapter = new ArrayAdapter<DiaryEntry>(getActivity(), R.layout.diary_entry) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                DiaryEntryView diaryEntryView = (DiaryEntryView) convertView;
                DiaryEntry entry = getItem(position);

                if (convertView == null) {
                    diaryEntryView = (DiaryEntryView) super.getView(position, convertView, parent);
                    diaryEntryView.setHint(Utils.DEFAULT_DATE_FORMATTER.format(new Date()));

                    textWatchers.add(position, new SimpleEditTextPersistenceRule(entry));
                }


                try {
                    Field mListenersField = TextView.class.getDeclaredField("mListeners");
                    mListenersField.setAccessible(true);
                    mListenersField.set(diaryEntryView, null);

                    if (position == textWatchers.size()) {
                        textWatchers.add(position, new SimpleEditTextPersistenceRule(entry));
                    }

                    diaryEntryView.addTextChangedListener(textWatchers.get(position));
                } catch (NoSuchFieldException e) {
                } catch (IllegalAccessException e) {
                }

                diaryEntryView.setText(entry.getEntry());

                Log.d("jzjz", "position: " + position);
                Log.d("jzjz", "entry: " + entry);

                return diaryEntryView;
            }
        };

        DiaryEntry diaryEntry = Globals.persistenceManager.getLatest(DiaryEntry.class);

        if (diaryEntry == null || !Utils.isFromToday(diaryEntry.getCreated())) {
            adapter.add(new DiaryEntry());
        }

        adapter.addAll(Globals.persistenceManager.getAllEntities(DiaryEntry.class));
        layoutContainer.setAdapter(adapter);
        textWatchers = new ArrayList<>(adapter.getCount());

        return layoutContainer;
    }
}
