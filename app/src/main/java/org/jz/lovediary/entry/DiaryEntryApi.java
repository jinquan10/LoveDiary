package org.jz.lovediary.entry;

import org.jz.lovediary.Mood;
import org.jz.lovediary.api.AndroidMVPApi;

public final class DiaryEntryApi {
    public interface View extends AndroidMVPApi.View {
        void displayDate(String dateString);

        void displayMood(Mood mood);

        void displayMoodSelection(Mood[] moods);

        void displayText(String entry);
    }

    public interface Presenter<TView extends AndroidMVPApi.View> extends AndroidMVPApi.Presenter<TView> {
        void requestTextUpdate(String text);

        void requestMoodUpdate(Mood mood);

        void requestMoodSelection();

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
