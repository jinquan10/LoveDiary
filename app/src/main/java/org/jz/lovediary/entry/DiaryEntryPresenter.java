package org.jz.lovediary.entry;

import org.jz.lovediary.Mood;
import org.jz.lovediary.PersistenceRule;
import org.jz.lovediary.api.AbsPresenter;
import org.jz.lovediary.util.Utils;

/**
 * Created by JZ on 4/23/2016.
 */
public class DiaryEntryPresenter extends AbsPresenter<DiaryEntryView, DiaryEntryProvider> implements DiaryEntryApi.Presenter<DiaryEntryView> {
    private PersistenceRule.Api<String> perWordRule;
    private PersistenceRule.Api<Object> sameStateRule;
    private PersistenceRule.Api<Long> timeRule;

    @Override
    public void onViewReady(DiaryEntryView view) {
        super.onViewReady(view);

        if (isViewAttached()) {
            getView().displayText(this.provider.getText());
            getView().displayMood(this.provider.getMood());
            getView().displayDate(Utils.getFormattedDate(this.provider.getTime()));
        }
    }

    @Override
    public void diaryTextUpdated(String text) {
        if (perWordRule.canBePersisted(text)) {
            provider.saveText(text);
        }
    }

    @Override
    public void moodUpdated(Mood mood) {

    }

    @Override
    public void searchDiaryEntry() {

    }
}
