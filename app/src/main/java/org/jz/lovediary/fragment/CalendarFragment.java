package org.jz.lovediary.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.jz.lovediary.R;

import java.util.Calendar;

/**
 * Created by JZ on 4/7/2016.
 */
public class CalendarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        for (int i = 10; i >= 0; i--) {
            Log.d("jzjz", i + " \n");
        }

        LinearLayout foo = (LinearLayout) inflater.inflate(R.layout.calendar_fragment, container, false);
        MaterialCalendarView mcv = (MaterialCalendarView) foo.findViewById(R.id.calendar);

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1987);
        c.set(Calendar.MONTH, 4);
        c.set(Calendar.DATE, 1);

        mcv.setDateSelected(c, true);

        return foo;
    }
}
