package org.jz.lovediary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jz.lovediary.R;
import org.jz.lovediary.application.Globals;
import org.jz.lovediary.entity.DiaryEntry;

/**
 * Created by JZ on 4/3/2016.
 */
public class DiaryEntriesLayout extends ListView {
    public DiaryEntriesLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ArrayAdapter<DiaryEntry> adapter = new ArrayAdapter<DiaryEntry>(getContext(), R.layout.diary_entry) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                DiaryEntryView diaryEntryView = (DiaryEntryView) super.getView(position, convertView, parent);
                diaryEntryView.init(getItem(position));
                return diaryEntryView;
            }
        };

        adapter.addAll(Globals.persistenceManager.getAllEntities(DiaryEntry.class));
        setAdapter(adapter);

        if (adapter.isEmpty()) {
            adapter.add(new DiaryEntry());
        }
    }
}
