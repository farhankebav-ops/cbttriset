package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class l extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f5360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f5361b;

    public l(n nVar, v vVar) {
        this.f5361b = nVar;
        this.f5360a = vVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i2, int i8) {
        String dateTime;
        b bVar = this.f5360a.f5404a;
        n nVar = this.f5361b;
        int iFindFirstVisibleItemPosition = i2 < 0 ? ((LinearLayoutManager) nVar.h.getLayoutManager()).findFirstVisibleItemPosition() : ((LinearLayoutManager) nVar.h.getLayoutManager()).findLastVisibleItemPosition();
        Calendar calendarA = a0.a(bVar.f5337a.f5391a);
        calendarA.add(2, iFindFirstVisibleItemPosition);
        r rVar = new r(calendarA);
        nVar.f5365d = rVar;
        MaterialButton materialButton = nVar.m;
        Calendar calendarA2 = a0.a(bVar.f5337a.f5391a);
        calendarA2.add(2, iFindFirstVisibleItemPosition);
        calendarA2.set(5, 1);
        Calendar calendarA3 = a0.a(calendarA2);
        calendarA3.get(2);
        calendarA3.get(1);
        calendarA3.getMaximum(7);
        calendarA3.getActualMaximum(5);
        calendarA3.getTimeInMillis();
        long timeInMillis = calendarA3.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = a0.f5336a;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            DisplayContext unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            dateTime = instanceForSkeleton.format(new Date(timeInMillis));
        } else {
            dateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        materialButton.setText(dateTime);
        nVar.d(bVar.f5337a.d(rVar));
    }
}
