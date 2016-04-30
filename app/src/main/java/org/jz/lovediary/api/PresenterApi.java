package org.jz.lovediary.api;

import org.jz.lovediary.Mood;

/**
 * Created by JZ on 4/30/2016.
 */
public class PresenterApi {
    public interface View {

    }

    public interface Provider {

    }

    public interface DiaryEntryView extends View {
        void displayDate(String dateString);

        void displayMood(Mood mood);

        void displayText(String entry);
    }

    public interface DiaryEntryProvider extends Provider {
        void saveText(String text);

        void saveMood(Mood mood);

        void saveTime(long now);

        String getText();

        Mood getMood();

        long getTime();
    }
}
