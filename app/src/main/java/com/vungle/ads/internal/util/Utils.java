package com.vungle.ads.internal.util;

import android.content.Context;
import android.os.Build;
import android.webkit.URLUtil;
import c6.g;
import c6.i;
import c6.j;
import java.io.File;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    private final long getFolderSize(File file) {
        long length = 0;
        if (file.exists()) {
            j jVar = j.f4234a;
            g gVar = new g(new i(file));
            while (gVar.hasNext()) {
                File file2 = (File) gVar.next();
                if (file2.isFile()) {
                    length = file2.length() + length;
                }
            }
        }
        return length;
    }

    public final long getWebViewDataSize(Context context) {
        k.e(context, "context");
        try {
            File file = new File(context.getApplicationInfo().dataDir, "app_webview");
            folderSize = file.exists() ? getFolderSize(file) : 0L;
            File cacheDir = context.getCacheDir();
            return cacheDir.exists() ? folderSize + getFolderSize(c6.k.d0(cacheDir, "webviewCache")) : folderSize;
        } catch (Exception e) {
            Logger.Companion.e("WebViewSize", "Error reading WebView data size: " + e.getMessage());
            return folderSize;
        }
    }

    public final boolean isOSVersionInvalid() {
        return Build.VERSION.SDK_INT < 25;
    }

    public final boolean isUrlValid(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str);
    }
}
