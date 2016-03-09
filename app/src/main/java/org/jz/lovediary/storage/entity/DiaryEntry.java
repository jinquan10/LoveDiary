package org.jz.lovediary.storage.entity;

import java.util.Calendar;

/**
 * Created by JZ on 3/8/2016.
 */
public class DiaryEntry extends EditTextEntry {
    public DiaryEntry(){
        created = Calendar.getInstance().getTimeInMillis();
    }
}
