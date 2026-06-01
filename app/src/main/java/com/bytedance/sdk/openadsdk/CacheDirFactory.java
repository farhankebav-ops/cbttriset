package com.bytedance.sdk.openadsdk;

import a1.a;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Bc;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.multipro.MY;
import java.io.File;
import u.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class CacheDirFactory {
    private static String IlO = null;
    public static volatile b MEDIA_CACHE_DIR = null;
    public static String ROOT_DIR = null;
    public static final int SPLASH_USE_INTERNAL_STORAGE = 1;

    private static b IlO() {
        if (MEDIA_CACHE_DIR == null) {
            synchronized (CacheDirFactory.class) {
                try {
                    if (MEDIA_CACHE_DIR == null) {
                        b0.b bVar = new b0.b();
                        bVar.f4116a = null;
                        bVar.f4117b = null;
                        bVar.f4118c = null;
                        bVar.f4119d = null;
                        bVar.e = null;
                        MEDIA_CACHE_DIR = bVar;
                        bVar.f4116a = getRootDir();
                        ((b0.b) MEDIA_CACHE_DIR).e();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MEDIA_CACHE_DIR;
    }

    public static int getCacheType() {
        return 1;
    }

    public static String getDiskCacheDirPath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(getRootDir());
        return a.r(sb, File.separator, str);
    }

    public static b getICacheDir(int i2) {
        return IlO();
    }

    public static String getImageCacheDir(String str) {
        if (IlO == null) {
            IlO = getDiskCacheDirPath(str);
        }
        return IlO;
    }

    public static String getRootDir() {
        if (!TextUtils.isEmpty(ROOT_DIR)) {
            return ROOT_DIR;
        }
        File fileIlO = Bc.IlO(cl.IlO(), MY.EO(), "tt_ad");
        if (fileIlO.isFile()) {
            fileIlO.delete();
        }
        if (!fileIlO.exists()) {
            fileIlO.mkdirs();
        }
        String absolutePath = fileIlO.getAbsolutePath();
        ROOT_DIR = absolutePath;
        return absolutePath;
    }
}
