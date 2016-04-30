package org.jz.lovediary.entry;

import org.jz.lovediary.Mood;
import org.jz.lovediary.PersistenceRule;
import org.jz.lovediary.api.AbsPresenter;
import org.jz.lovediary.api.PresenterApi;
import org.jz.lovediary.api.ViewApi;
import org.jz.lovediary.util.Utils;

/**
 * Created by JZ on 4/23/2016.
 */
public class DiaryEntryPresenter extends AbsPresenter<PresenterApi.DiaryEntryView, PresenterApi.DiaryEntryProvider> implements ViewApi.DiaryEntryPresenter {
    private PersistenceRule.Api<String> perWordRule;
    private PersistenceRule.Api<Object> sameStateRule;
    private PersistenceRule.Api<Long> timeRule;

    @Override
    public void onAttachView(PresenterApi.DiaryEntryView view) {
        super.onAttachView(view);

        if (isViewAttached()) {
            this.view.get().displayText(this.provider.getText());
            this.view.get().displayMood(this.provider.getMood());
            this.view.get().displayDate(Utils.getFormattedDate(this.provider.getTime()));
        }
    }

    @Override
    public void requestTextUpdate(String text) {
        if (perWordRule.canBePersisted(text)) {
            provider.saveText(text);
        }
    }

    @Override
    public void requestMoodUpdate(Mood mood) {
        if (sameStateRule.canBePersisted(mood)) {
            provider.saveMood(mood);
            updateMood(mood);
        }
    }

    @Override
    public void searchDiaryEntry() {

    }

    void updateMood(Mood mood) {
        if (isViewAttached()) {
            this.view.get().displayMood(mood);
        }
    }
}
