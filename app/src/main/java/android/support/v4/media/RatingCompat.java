package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new f(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f3253b;

    public RatingCompat(int i2, float f4) {
        this.f3252a = i2;
        this.f3253b = f4;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f3252a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f3252a);
        sb.append(" rating=");
        float f4 = this.f3253b;
        sb.append(f4 < 0.0f ? "unrated" : String.valueOf(f4));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3252a);
        parcel.writeFloat(this.f3253b);
    }
}
