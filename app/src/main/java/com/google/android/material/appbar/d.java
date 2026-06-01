package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends AbsSavedState {
    public static final Parcelable.Creator<d> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5253d;
    public boolean e;

    public d(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5250a = parcel.readByte() != 0;
        this.f5251b = parcel.readByte() != 0;
        this.f5252c = parcel.readInt();
        this.f5253d = parcel.readFloat();
        this.e = parcel.readByte() != 0;
    }

    @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeByte(this.f5250a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f5251b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f5252c);
        parcel.writeFloat(this.f5253d);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
    }
}
