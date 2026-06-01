package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new android.support.v4.media.f(7);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3277d;
    public int e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3274a);
        parcel.writeInt(this.f3276c);
        parcel.writeInt(this.f3277d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f3275b);
    }
}
