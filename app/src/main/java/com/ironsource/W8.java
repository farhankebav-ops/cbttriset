package com.ironsource;

import android.graphics.drawable.Drawable;
import android.webkit.URLUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class W8 implements X8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final X3 f7776a;

    public W8() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final Object b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return r2.q.M(new Exception("file does not exists"));
        }
        Drawable drawableCreateFromPath = Drawable.createFromPath(file.getPath());
        return drawableCreateFromPath == null ? r2.q.M(new Exception("failed to create a drawable")) : drawableCreateFromPath;
    }

    private final Object c(String str) throws IOException {
        InputStream inputStreamA = this.f7776a.a(str);
        try {
            Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamA, new File(str).getName());
            r2.q.I(inputStreamA, null);
            return drawableCreateFromStream == null ? r2.q.M(new Exception("failed to create a drawable")) : drawableCreateFromStream;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                r2.q.I(inputStreamA, th);
                throw th2;
            }
        }
    }

    private final boolean d(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    @Override // com.ironsource.X8
    public Object a(String url) {
        kotlin.jvm.internal.k.e(url, "url");
        try {
            return d(url) ? c(url) : b(url);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return r2.q.M(e);
        }
    }

    public W8(X3 connectionFactory) {
        kotlin.jvm.internal.k.e(connectionFactory, "connectionFactory");
        this.f7776a = connectionFactory;
    }

    public /* synthetic */ W8(X3 x32, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? L4.f7088a : x32);
    }
}
