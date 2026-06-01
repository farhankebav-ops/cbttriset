package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.cbt.exam.browser.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class e extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5347d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f5348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5350c;

    static {
        f5347d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar calendarC = a0.c(null);
        this.f5348a = calendarC;
        this.f5349b = calendarC.getMaximum(7);
        this.f5350c = calendarC.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f5349b;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i2) {
        int i8 = this.f5349b;
        if (i2 >= i8) {
            return null;
        }
        int i9 = i2 + this.f5350c;
        if (i9 > i8) {
            i9 -= i8;
        }
        return Integer.valueOf(i9);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i8 = i2 + this.f5350c;
        int i9 = this.f5349b;
        if (i8 > i9) {
            i8 -= i9;
        }
        Calendar calendar = this.f5348a;
        calendar.set(7, i8);
        textView.setText(calendar.getDisplayName(7, f5347d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public e(int i2) {
        Calendar calendarC = a0.c(null);
        this.f5348a = calendarC;
        this.f5349b = calendarC.getMaximum(7);
        this.f5350c = i2;
    }
}
