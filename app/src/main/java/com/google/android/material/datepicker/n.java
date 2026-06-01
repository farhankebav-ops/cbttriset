package com.google.android.material.datepicker;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import j4.r0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class n<S> extends w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f5364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f5365d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f5366f;
    public RecyclerView g;
    public RecyclerView h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f5367i;
    public View j;
    public View k;
    public View l;
    public MaterialButton m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AccessibilityManager f5368n;

    public final void b(r rVar) {
        v vVar = (v) this.h.getAdapter();
        int iD = vVar.f5404a.f5337a.d(rVar);
        AccessibilityManager accessibilityManager = this.f5368n;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int iD2 = iD - vVar.f5404a.f5337a.d(this.f5365d);
            boolean z2 = Math.abs(iD2) > 3;
            boolean z7 = iD2 > 0;
            this.f5365d = rVar;
            if (z2 && z7) {
                this.h.scrollToPosition(iD - 3);
                this.h.post(new r0(this, iD, 2));
            } else if (z2) {
                this.h.scrollToPosition(iD + 3);
                this.h.post(new r0(this, iD, 2));
            } else {
                this.h.post(new r0(this, iD, 2));
            }
        } else {
            this.f5365d = rVar;
            this.h.scrollToPosition(iD);
        }
        d(iD);
    }

    public final void c(int i2) {
        this.e = i2;
        if (i2 == 2) {
            this.g.getLayoutManager().scrollToPosition(this.f5365d.f5393c - ((c0) this.g.getAdapter()).f5345a.f5364c.f5337a.f5393c);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.f5367i.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        if (i2 == 1) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.f5367i.setVisibility(0);
            this.j.setVisibility(0);
            b(this.f5365d);
        }
    }

    public final void d(int i2) {
        this.j.setEnabled(i2 + 1 < this.h.getAdapter().getItemCount());
        this.f5367i.setEnabled(i2 - 1 >= 0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f5363b = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f5364c = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f5365d = (r) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i8;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f5363b);
        this.f5366f = new c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.f5368n = (AccessibilityManager) requireContext().getSystemService("accessibility");
        r rVar = this.f5364c.f5337a;
        if (p.d(contextThemeWrapper, R.attr.windowFullscreen)) {
            i2 = com.cbt.exam.browser.R.layout.mtrl_calendar_vertical;
            i8 = 1;
        } else {
            i2 = com.cbt.exam.browser.R.layout.mtrl_calendar_horizontal;
            i8 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i2, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_calendar_days_of_week_height);
        int i9 = s.f5396d;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_calendar_month_vertical_padding) * (i9 - 1)) + (resources.getDimensionPixelSize(com.cbt.exam.browser.R.dimen.mtrl_calendar_day_height) * i9) + resources.getDimensionPixelOffset(com.cbt.exam.browser.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(com.cbt.exam.browser.R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new g(0));
        int i10 = this.f5364c.e;
        gridView.setAdapter((ListAdapter) (i10 > 0 ? new e(i10) : new e()));
        gridView.setNumColumns(rVar.f5394d);
        gridView.setEnabled(false);
        this.h = (RecyclerView) viewInflate.findViewById(com.cbt.exam.browser.R.id.mtrl_calendar_months);
        this.h.setLayoutManager(new h(this, getContext(), i8, i8));
        this.h.setTag("MONTHS_VIEW_GROUP_TAG");
        v vVar = new v(contextThemeWrapper, this.f5364c, new i(this));
        this.h.setAdapter(vVar);
        int integer = contextThemeWrapper.getResources().getInteger(com.cbt.exam.browser.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(com.cbt.exam.browser.R.id.mtrl_calendar_year_selector_frame);
        this.g = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.g.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.g.setAdapter(new c0(this));
            this.g.addItemDecoration(new j(this));
        }
        View viewFindViewById = viewInflate.findViewById(com.cbt.exam.browser.R.id.month_navigation_fragment_toggle);
        b bVar = vVar.f5404a;
        if (viewFindViewById != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(com.cbt.exam.browser.R.id.month_navigation_fragment_toggle);
            this.m = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(this.m, new k(this));
            View viewFindViewById2 = viewInflate.findViewById(com.cbt.exam.browser.R.id.month_navigation_previous);
            this.f5367i = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById3 = viewInflate.findViewById(com.cbt.exam.browser.R.id.month_navigation_next);
            this.j = viewFindViewById3;
            viewFindViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.k = viewInflate.findViewById(com.cbt.exam.browser.R.id.mtrl_calendar_year_selector_frame);
            this.l = viewInflate.findViewById(com.cbt.exam.browser.R.id.mtrl_calendar_day_selector_frame);
            c(1);
            this.m.setText(this.f5365d.c());
            this.h.addOnScrollListener(new l(this, vVar));
            this.m.setOnClickListener(new m(this));
            this.j.setOnClickListener(new f(this, vVar, 1));
            this.f5367i.setOnClickListener(new f(this, vVar, 0));
            d(bVar.f5337a.d(this.f5365d));
        }
        if (!p.d(contextThemeWrapper, R.attr.windowFullscreen)) {
            new PagerSnapHelper().attachToRecyclerView(this.h);
        }
        this.h.scrollToPosition(bVar.f5337a.d(this.f5365d));
        ViewCompat.setAccessibilityDelegate(this.h, new g(1));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f5363b);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f5364c);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f5365d);
    }
}
