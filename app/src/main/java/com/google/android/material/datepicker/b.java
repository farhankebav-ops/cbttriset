package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.f(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f5337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f5338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f5339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f5340d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5341f;
    public final int g;

    public b(r rVar, r rVar2, d dVar, r rVar3, int i2) {
        Objects.requireNonNull(rVar, "start cannot be null");
        Objects.requireNonNull(rVar2, "end cannot be null");
        Objects.requireNonNull(dVar, "validator cannot be null");
        this.f5337a = rVar;
        this.f5338b = rVar2;
        this.f5340d = rVar3;
        this.e = i2;
        this.f5339c = dVar;
        if (rVar3 != null && rVar.f5391a.compareTo(rVar3.f5391a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (rVar3 != null && rVar3.f5391a.compareTo(rVar2.f5391a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i2 < 0 || i2 > a0.c(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.g = rVar.d(rVar2) + 1;
        this.f5341f = (rVar2.f5393c - rVar.f5393c) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5337a.equals(bVar.f5337a) && this.f5338b.equals(bVar.f5338b) && ObjectsCompat.equals(this.f5340d, bVar.f5340d) && this.e == bVar.e && this.f5339c.equals(bVar.f5339c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5337a, this.f5338b, this.f5340d, Integer.valueOf(this.e), this.f5339c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f5337a, 0);
        parcel.writeParcelable(this.f5338b, 0);
        parcel.writeParcelable(this.f5340d, 0);
        parcel.writeParcelable(this.f5339c, 0);
        parcel.writeInt(this.e);
    }
}
