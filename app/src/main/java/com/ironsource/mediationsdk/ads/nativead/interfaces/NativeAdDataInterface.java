package com.ironsource.mediationsdk.ads.nativead.interfaces;

import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface NativeAdDataInterface {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Image {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable f9011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f9012b;

        public Image(Drawable drawable, Uri uri) {
            this.f9011a = drawable;
            this.f9012b = uri;
        }

        public final Drawable getDrawable() {
            return this.f9011a;
        }

        public final Uri getUri() {
            return this.f9012b;
        }
    }

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Image getIcon();

    String getTitle();
}
