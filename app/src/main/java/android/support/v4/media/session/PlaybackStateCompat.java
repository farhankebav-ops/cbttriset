package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new android.support.v4.media.f(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3281d;
    public final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3282f;
    public final CharSequence g;
    public final long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f3283i;
    public final long j;
    public final Bundle k;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new h();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f3285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f3287d;

        public CustomAction(Parcel parcel) {
            this.f3284a = parcel.readString();
            this.f3285b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3286c = parcel.readInt();
            this.f3287d = parcel.readBundle(g.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f3285b) + ", mIcon=" + this.f3286c + ", mExtras=" + this.f3287d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f3284a);
            TextUtils.writeToParcel(this.f3285b, parcel, i2);
            parcel.writeInt(this.f3286c);
            parcel.writeBundle(this.f3287d);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f3278a = parcel.readInt();
        this.f3279b = parcel.readLong();
        this.f3281d = parcel.readFloat();
        this.h = parcel.readLong();
        this.f3280c = parcel.readLong();
        this.e = parcel.readLong();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3283i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle(g.class.getClassLoader());
        this.f3282f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f3278a);
        sb.append(", position=");
        sb.append(this.f3279b);
        sb.append(", buffered position=");
        sb.append(this.f3280c);
        sb.append(", speed=");
        sb.append(this.f3281d);
        sb.append(", updated=");
        sb.append(this.h);
        sb.append(", actions=");
        sb.append(this.e);
        sb.append(", error code=");
        sb.append(this.f3282f);
        sb.append(", error message=");
        sb.append(this.g);
        sb.append(", custom actions=");
        sb.append(this.f3283i);
        sb.append(", active item id=");
        return a1.a.p(sb, this.j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3278a);
        parcel.writeLong(this.f3279b);
        parcel.writeFloat(this.f3281d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.f3280c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel(this.g, parcel, i2);
        parcel.writeTypedList(this.f3283i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f3282f);
    }
}
