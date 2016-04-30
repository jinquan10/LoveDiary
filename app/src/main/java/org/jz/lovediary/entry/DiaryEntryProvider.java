package org.jz.lovediary.entry;


import org.jz.lovediary.Mood;
import org.jz.lovediary.api.PresenterApi;

/**
 * Created by JZ on 4/23/2016.
 */
public class DiaryEntryProvider implements PresenterApi.DiaryEntryProvider {
    @Override
    public void saveText(String text) {

    }

    @Override
    public void saveMood(Mood mood) {

    }

    @Override
    public void saveTime(long now) {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public Mood getMood() {
        return null;
    }

    @Override
    public long getTime() {
        return 0;
    }
}
