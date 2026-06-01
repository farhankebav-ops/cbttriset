package l3;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends View.BaseSavedState {
    public static final Parcelable.Creator<b> CREATOR = new f(14);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f12767d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12768f;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f12769i;
    public boolean j;
    public boolean k;

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeFloat(this.f12764a);
        parcel.writeFloat(this.f12765b);
        parcel.writeByte(this.f12766c ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.f12767d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f12768f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.f12769i);
        parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
    }
}
