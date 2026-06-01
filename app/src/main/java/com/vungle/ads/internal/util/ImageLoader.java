package com.vungle.ads.internal.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.unity3d.services.ads.operation.show.b;
import com.vungle.ads.internal.util.Logger;
import e6.l;
import e6.p;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ImageLoader {
    private static final String FILE_SCHEME = "file://";
    private Executor ioExecutor;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ImageLoader";
    private static final ImageLoader instance = new ImageLoader();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final ImageLoader getInstance() {
            return ImageLoader.instance;
        }

        private Companion() {
        }
    }

    private ImageLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: displayImage$lambda-0, reason: not valid java name */
    public static final void m3378displayImage$lambda0(String str, l onImageLoaded) {
        k.e(onImageLoaded, "$onImageLoaded");
        if (t.n0(str, "file://", false)) {
            String strSubstring = str.substring(7);
            k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(strSubstring);
            if (bitmapDecodeFile != null) {
                onImageLoaded.invoke(bitmapDecodeFile);
                return;
            }
            Logger.Companion companion = Logger.Companion;
            String TAG2 = TAG;
            k.d(TAG2, "TAG");
            companion.w(TAG2, "decode bitmap failed.");
        }
    }

    public final void displayImage(String str, l onImageLoaded) {
        k.e(onImageLoaded, "onImageLoaded");
        if (this.ioExecutor == null) {
            Logger.Companion companion = Logger.Companion;
            String TAG2 = TAG;
            k.d(TAG2, "TAG");
            companion.w(TAG2, "ImageLoader not initialized.");
            return;
        }
        if (str == null || str.length() == 0) {
            Logger.Companion companion2 = Logger.Companion;
            String TAG3 = TAG;
            k.d(TAG3, "TAG");
            companion2.w(TAG3, "the uri is required.");
            return;
        }
        Executor executor = this.ioExecutor;
        if (executor != null) {
            executor.execute(new b(str, onImageLoaded, 8));
        }
    }

    public final void getImageSize(String str, p onImageSizeLoaded) {
        k.e(onImageSizeLoaded, "onImageSizeLoaded");
        if (str == null || str.length() == 0 || !t.n0(str, "file://", false)) {
            Logger.Companion companion = Logger.Companion;
            String TAG2 = TAG;
            k.d(TAG2, "TAG");
            companion.w(TAG2, "the valid uri is required.");
            return;
        }
        String strSubstring = str.substring(7);
        k.d(strSubstring, "this as java.lang.String).substring(startIndex)");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(strSubstring, options);
        onImageSizeLoaded.invoke(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
    }

    public final void init(Executor ioExecutor) {
        k.e(ioExecutor, "ioExecutor");
        this.ioExecutor = ioExecutor;
    }
}
