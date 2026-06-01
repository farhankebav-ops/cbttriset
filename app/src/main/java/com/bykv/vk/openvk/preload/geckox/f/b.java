package com.bykv.vk.openvk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f4994a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f4995b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f4996c;

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file == null) {
            this.f4996c = new File(context.getFilesDir(), a1.a.r(new StringBuilder("gecko_offline_res_x"), File.separator, str)).getAbsolutePath();
        } else {
            this.f4996c = new File(file, str).getAbsolutePath();
        }
    }

    private a d(String str) {
        a aVar;
        int iIndexOf = str.indexOf("/");
        if (iIndexOf == -1) {
            new RuntimeException("channel：".concat(str));
        }
        String strSubstring = str.substring(0, iIndexOf);
        synchronized (this.f4994a) {
            try {
                aVar = this.f4994a.get(strSubstring);
                if (aVar == null) {
                    aVar = new a(this.f4996c, strSubstring);
                    this.f4994a.put(strSubstring, aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final String a() {
        return this.f4996c;
    }

    public final int b(String str) throws Exception {
        if (this.f4995b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final boolean c(String str) throws Exception {
        if (this.f4995b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }

    public final InputStream a(String str) throws Exception {
        if (this.f4995b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final Map<String, Long> b() {
        HashMap map = new HashMap();
        synchronized (this.f4994a) {
            try {
                Collection<a> collectionValues = this.f4994a.values();
                if (collectionValues == null) {
                    return map;
                }
                for (a aVar : collectionValues) {
                    map.put(aVar.b(), aVar.a());
                }
                return map;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() throws Exception {
        if (this.f4995b.getAndSet(true)) {
            return;
        }
        GeckoLogger.d("Loader", "release version res loader");
        synchronized (this.f4994a) {
            try {
                Iterator<a> it = this.f4994a.values().iterator();
                while (it.hasNext()) {
                    it.next().c();
                }
                this.f4994a.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
