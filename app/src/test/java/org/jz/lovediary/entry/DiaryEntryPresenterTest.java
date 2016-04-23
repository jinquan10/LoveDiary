package org.jz.lovediary.entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jz.lovediary.PersistenceRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by JZ on 4/23/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class DiaryEntryPresenterTest {
    @Mock
    private DiaryEntryView diaryEntryView;

    @Mock
    private DiaryEntryProvider diaryEntryProvider;

    @Mock
    private PersistenceRule.Api perWordRule;

    @Mock
    private PersistenceRule.Api sameStateRule;

    @InjectMocks
    private DiaryEntryPresenter diaryEntryPresenter;

    @Before
    public void before() {

    }

    @After
    public void after() {
        verifyNoMoreInteractions(diaryEntryView, diaryEntryProvider, perWordRule, sameStateRule);
    }

    @Test
    public void textCanPersist() {
        when(perWordRule.canBePersisted(Mockito.anyString())).thenReturn(true);
        String changedText = "changedText";

        diaryEntryPresenter.diaryTextUpdated(changedText);

        verify(perWordRule).canBePersisted(changedText);
        verify(diaryEntryProvider).saveText(changedText);
    }

    @Test
    public void textCannotPersist() {
        when(perWordRule.canBePersisted(Mockito.anyString())).thenReturn(false);
        String changedText = "changedText";

        diaryEntryPresenter.diaryTextUpdated(changedText);

        verify(perWordRule).canBePersisted(changedText);
    }
}
