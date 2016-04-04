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
import org.jz.lovediary.util.Utils;

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

        DiaryEntry diaryEntry = Globals.persistenceManager.getLatest(DiaryEntry.class);

        if (diaryEntry == null || !Utils.isFromToday(diaryEntry.getCreated())) {
            adapter.add(new DiaryEntry());
        }

        adapter.addAll(Globals.persistenceManager.getAllEntities(DiaryEntry.class));
        setAdapter(adapter);
    }
}
