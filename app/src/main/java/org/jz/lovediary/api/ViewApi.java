package org.jz.lovediary.api;

import org.jz.lovediary.Mood;

/**
 * Created by JZ on 4/30/2016.
 */
public final class ViewApi {
    public interface Presenter<T extends PresenterApi.View> {
        void onAttachView(T view);
        void onDetachView();
    }

    public interface DiaryEntryPresenter extends Presenter<PresenterApi.DiaryEntryView> {
        void requestTextUpdate(String text);

        void requestMoodUpdate(Mood mood);

        void searchDiaryEntry();
    }
}
