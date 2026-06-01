package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new android.support.v4.media.f(4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaDescriptionCompat f3269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3270b;

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.f3269a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.f3270b = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
        sb.append(this.f3269a);
        sb.append(", Id=");
        return a1.a.p(sb, this.f3270b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        this.f3269a.writeToParcel(parcel, i2);
        parcel.writeLong(this.f3270b);
    }
}
