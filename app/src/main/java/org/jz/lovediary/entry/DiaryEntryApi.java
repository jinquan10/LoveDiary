package org.jz.lovediary.entry;

import org.jz.lovediary.Mood;
import org.jz.lovediary.api.AndroidMVPApi;

public final class DiaryEntryApi {
    public interface View extends AndroidMVPApi.View {
        void displayDate(String dateString);

        void displayMood(Mood mood);

        void displayText(String entry);
    }

    public interface Presenter<TView extends AndroidMVPApi.View> extends AndroidMVPApi.Presenter<TView> {
        void diaryTextUpdated(String text);

        void moodUpdated(Mood mood);

        void searchDiaryEntry();
    }

    public interface Provider extends AndroidMVPApi.Provider {
        void saveText(String text);

        void saveMood(Mood mood);

        void saveTime(long now);

        String getText();

        Mood getMood();

        long getTime();
    }
}
