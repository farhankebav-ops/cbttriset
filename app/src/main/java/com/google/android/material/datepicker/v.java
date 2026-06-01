package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.cbt.exam.browser.R;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class v extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f5405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5406c;

    public v(ContextThemeWrapper contextThemeWrapper, b bVar, i iVar) {
        r rVar = bVar.f5337a;
        r rVar2 = bVar.f5338b;
        r rVar3 = bVar.f5340d;
        if (rVar.f5391a.compareTo(rVar3.f5391a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (rVar3.f5391a.compareTo(rVar2.f5391a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f5406c = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * s.f5396d) + (p.d(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.f5404a = bVar;
        this.f5405b = iVar;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f5404a.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i2) {
        Calendar calendarA = a0.a(this.f5404a.f5337a.f5391a);
        calendarA.add(2, i2);
        calendarA.set(5, 1);
        Calendar calendarA2 = a0.a(calendarA);
        calendarA2.get(2);
        calendarA2.get(1);
        calendarA2.getMaximum(7);
        calendarA2.getActualMaximum(5);
        calendarA2.getTimeInMillis();
        return calendarA2.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        u uVar = (u) viewHolder;
        b bVar = this.f5404a;
        Calendar calendarA = a0.a(bVar.f5337a.f5391a);
        calendarA.add(2, i2);
        r rVar = new r(calendarA);
        uVar.f5402a.setText(rVar.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) uVar.f5403b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !rVar.equals(materialCalendarGridView.a().f5397a)) {
            new s(rVar, bVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!p.d(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new u(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f5406c));
        return new u(linearLayout, true);
    }
}
