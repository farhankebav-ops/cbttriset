package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new f(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDescriptionCompat f3244b;

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f3243a = parcel.readInt();
        this.f3244b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.f3243a + ", mDescription=" + this.f3244b + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3243a);
        this.f3244b.writeToParcel(parcel, i2);
    }
}
