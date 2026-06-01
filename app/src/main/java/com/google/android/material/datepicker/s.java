package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5396d = a0.c(null).getMaximum(4);
    public static final int e = (a0.c(null).getMaximum(7) + a0.c(null).getMaximum(5)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f5397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f5398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5399c;

    public s(r rVar, b bVar) {
        this.f5397a = rVar;
        this.f5399c = bVar;
        throw null;
    }

    public final int a() {
        int firstDayOfWeek = this.f5399c.e;
        r rVar = this.f5397a;
        Calendar calendar = rVar.f5391a;
        int i2 = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i8 = i2 - firstDayOfWeek;
        return i8 < 0 ? i8 + rVar.f5394d : i8;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i2) {
        if (i2 < a() || i2 > c()) {
            return null;
        }
        int iA = (i2 - a()) + 1;
        Calendar calendarA = a0.a(this.f5397a.f5391a);
        calendarA.set(5, iA);
        return Long.valueOf(calendarA.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.f5397a.e) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return e;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2 / this.f5397a.f5394d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            android.content.Context r0 = r7.getContext()
            com.google.android.material.datepicker.c r1 = r4.f5398b
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.c r1 = new com.google.android.material.datepicker.c
            r1.<init>(r0)
            r4.f5398b = r1
        Lf:
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r6 != 0) goto L27
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            r0 = 2131558698(0x7f0d012a, float:1.874272E38)
            android.view.View r6 = r6.inflate(r0, r7, r1)
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r6 = r4.a()
            int r6 = r5 - r6
            if (r6 < 0) goto L5d
            com.google.android.material.datepicker.r r7 = r4.f5397a
            int r2 = r7.e
            if (r6 < r2) goto L36
            goto L5d
        L36:
            r2 = 1
            int r6 = r6 + r2
            r0.setTag(r7)
            android.content.res.Resources r7 = r0.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r3[r1] = r6
            java.lang.String r6 = "%d"
            java.lang.String r6 = java.lang.String.format(r7, r6, r3)
            r0.setText(r6)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L65
        L5d:
            r6 = 8
            r0.setVisibility(r6)
            r0.setEnabled(r1)
        L65:
            java.lang.Long r5 = r4.getItem(r5)
            if (r5 != 0) goto L6c
            goto L6e
        L6c:
            if (r0 != 0) goto L6f
        L6e:
            return r0
        L6f:
            r0.getContext()
            java.util.Calendar r5 = com.google.android.material.datepicker.a0.b()
            r5.getTimeInMillis()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.s.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
