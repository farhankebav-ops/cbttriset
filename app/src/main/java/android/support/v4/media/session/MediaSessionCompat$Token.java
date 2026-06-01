package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new android.support.v4.media.f(6);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f3273b;

    public MediaSessionCompat$Token(Object obj, c cVar) {
        this.f3272a = obj;
        this.f3273b = cVar;
    }

    public static MediaSessionCompat$Token a(Parcelable parcelable, c cVar) {
        if (parcelable == null) {
            return null;
        }
        if (parcelable instanceof MediaSession.Token) {
            return new MediaSessionCompat$Token(parcelable, cVar);
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        Object obj2 = ((MediaSessionCompat$Token) obj).f3272a;
        Object obj3 = this.f3272a;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f3272a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable((Parcelable) this.f3272a, i2);
    }
}
