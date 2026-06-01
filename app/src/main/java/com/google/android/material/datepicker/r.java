package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class r implements Comparable, Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new android.support.v4.media.f(12);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f5391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5394d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5395f;
    public String g;

    public r(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarA = a0.a(calendar);
        this.f5391a = calendarA;
        this.f5392b = calendarA.get(2);
        this.f5393c = calendarA.get(1);
        this.f5394d = calendarA.getMaximum(7);
        this.e = calendarA.getActualMaximum(5);
        this.f5395f = calendarA.getTimeInMillis();
    }

    public static r a(int i2, int i8) {
        Calendar calendarC = a0.c(null);
        calendarC.set(1, i2);
        calendarC.set(2, i8);
        return new r(calendarC);
    }

    public static r b(long j) {
        Calendar calendarC = a0.c(null);
        calendarC.setTimeInMillis(j);
        return new r(calendarC);
    }

    public final String c() {
        String dateTime;
        if (this.g == null) {
            long timeInMillis = this.f5391a.getTimeInMillis();
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
            this.g = dateTime;
        }
        return this.g;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f5391a.compareTo(((r) obj).f5391a);
    }

    public final int d(r rVar) {
        if (!(this.f5391a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (rVar.f5392b - this.f5392b) + ((rVar.f5393c - this.f5393c) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f5392b == rVar.f5392b && this.f5393c == rVar.f5393c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5392b), Integer.valueOf(this.f5393c)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f5393c);
        parcel.writeInt(this.f5392b);
    }
}
