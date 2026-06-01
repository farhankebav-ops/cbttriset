package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class NativeAd {

    @NonNull
    public static final String ASSET_ADCHOICES_CONTAINER_VIEW = "1098";

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Deprecated
    public static abstract class AdChoicesInfo {
        @NonNull
        public abstract List<Image> getImages();

        @NonNull
        public abstract CharSequence getText();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @Deprecated
    public static abstract class Image {
        @NonNull
        public abstract Drawable getDrawable();

        public abstract double getScale();

        @NonNull
        public abstract Uri getUri();

        public int zza() {
            return -1;
        }

        public int zzb() {
            return -1;
        }
    }

    @Deprecated
    public abstract void performClick(@NonNull Bundle bundle);

    @Deprecated
    public abstract boolean recordImpression(@NonNull Bundle bundle);

    @Deprecated
    public abstract void reportTouchEvent(@NonNull Bundle bundle);
}
