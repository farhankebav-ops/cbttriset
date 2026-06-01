package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new f(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f3246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f3247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f3248d;
    public final Bitmap e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f3249f;
    public final Bundle g;
    public final Uri h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Object f3250i;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f3245a = str;
        this.f3246b = charSequence;
        this.f3247c = charSequence2;
        this.f3248d = charSequence3;
        this.e = bitmap;
        this.f3249f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f3246b) + ", " + ((Object) this.f3247c) + ", " + ((Object) this.f3248d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Object objBuild = this.f3250i;
        if (objBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f3245a);
            builder.setTitle(this.f3246b);
            builder.setSubtitle(this.f3247c);
            builder.setDescription(this.f3248d);
            builder.setIconBitmap(this.e);
            builder.setIconUri(this.f3249f);
            builder.setExtras(this.g);
            builder.setMediaUri(this.h);
            objBuild = builder.build();
            this.f3250i = objBuild;
        }
        ((MediaDescription) objBuild).writeToParcel(parcel, i2);
    }
}
