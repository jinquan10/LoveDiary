package org.jz.lovediary.entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jz.lovediary.Mood;
import org.jz.lovediary.PersistenceRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by JZ on 4/23/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DiaryEntryPresenterTest {
    @Mock
    private WeakReference<DiaryEntryView> diaryEntryView;

    @Mock
    private DiaryEntryProvider diaryEntryProvider;

    @Mock
    private PersistenceRule.Api perWordRule;

    @Mock
    private PersistenceRule.Api sameStateRule;

    @Spy
    @InjectMocks
    private DiaryEntryPresenter diaryEntryPresenter;

    @Before
    public void before() {

    }

    @After
    public void after() {
        verifyNoMoreInteractions(diaryEntryView, diaryEntryProvider, perWordRule, sameStateRule, diaryEntryPresenter);
    }

    @Test
    public void textCanPersist() {
        when(perWordRule.canBePersisted(Mockito.anyString())).thenReturn(true);
        String changedText = "changedText";

        diaryEntryPresenter.requestTextUpdate(changedText);

        verify(perWordRule).canBePersisted(changedText);
        verify(diaryEntryProvider).saveText(changedText);
        verify(diaryEntryPresenter).requestTextUpdate(changedText);
    }

    @Test
    public void textCannotPersist() {
        when(perWordRule.canBePersisted(Mockito.anyString())).thenReturn(false);
        String changedText = "changedText";

        diaryEntryPresenter.requestTextUpdate(changedText);

        verify(perWordRule).canBePersisted(changedText);
        verify(diaryEntryPresenter).requestTextUpdate(changedText);
    }

    @Test
    public void moodCanPersist() {
        Mood mood = Mood.HAPPY;

        when(sameStateRule.canBePersisted(Mockito.anyBoolean())).thenReturn(true);
        doNothing().when(diaryEntryPresenter).updateMood(any(Mood.class));

        diaryEntryPresenter.requestMoodUpdate(mood);

        verify(diaryEntryPresenter).requestMoodUpdate(mood);
        verify(sameStateRule).canBePersisted(mood);
        verify(diaryEntryProvider).saveMood(mood);
        verify(diaryEntryPresenter).updateMood(mood);
    }

    @Test
    public void moodCannotPersist() {
        when(sameStateRule.canBePersisted(Mockito.anyBoolean())).thenReturn(false);
        Mood mood = Mood.HAPPY;

        diaryEntryPresenter.requestMoodUpdate(mood);

        verify(sameStateRule).canBePersisted(mood);
        verify(diaryEntryPresenter).requestMoodUpdate(mood);
    }
}
