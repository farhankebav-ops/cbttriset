package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.f.a.c;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.utils.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f4989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile File f4990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Long f4991d;
    private volatile com.bykv.vk.openvk.preload.geckox.f.a.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f4992f = new AtomicBoolean(false);

    public a(String str, String str2) {
        this.f4988a = str;
        this.f4989b = str2;
    }

    private synchronized com.bykv.vk.openvk.preload.geckox.f.a.a d(String str) throws Exception {
        if (this.e != null) {
            return this.e;
        }
        File fileE = e(str);
        if (fileE == null) {
            throw new FileNotFoundException("channel no exist，channel:".concat(String.valueOf(str)));
        }
        File file = new File(fileE, "res.macv");
        File file2 = new File(fileE, "res");
        if (file2.exists() && file2.isDirectory()) {
            this.e = new c(fileE);
        } else {
            if (!file.exists() || !file.isFile()) {
                throw new RuntimeException("can not find res, dir:" + fileE.getAbsolutePath());
            }
            this.e = new com.bykv.vk.openvk.preload.geckox.f.a.b(fileE);
        }
        return this.e;
    }

    private synchronized File e(String str) throws Exception {
        if (this.f4990c != null) {
            return this.f4990c;
        }
        if (this.f4991d != null && this.f4991d.longValue() == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4988a);
        String str2 = File.separator;
        sb.append(str2);
        sb.append(str);
        sb.append(str2);
        sb.append("select.lock");
        com.bykv.vk.openvk.preload.geckox.g.b bVarA = com.bykv.vk.openvk.preload.geckox.g.b.a(sb.toString());
        try {
            if (this.f4991d == null) {
                this.f4991d = g.a(new File(this.f4988a, str));
            }
            if (this.f4991d == null) {
                this.f4991d = -1L;
                bVarA.a();
                return null;
            }
            File file = new File(this.f4988a, str2 + str + str2 + this.f4991d + str2 + "using.lock");
            this.f4990c = file.getParentFile();
            com.bykv.vk.openvk.preload.geckox.g.c.a(file.getAbsolutePath());
            File file2 = this.f4990c;
            bVarA.a();
            return file2;
        } catch (Throwable th) {
            bVarA.a();
            throw th;
        }
    }

    public final InputStream a(String str) throws Exception {
        return d(this.f4989b).a(a(this.f4989b, str));
    }

    public final boolean b(String str) throws Exception {
        return d(this.f4989b).b(a(this.f4989b, str));
    }

    public final int c(String str) {
        try {
            File file = new File(e(str), "res");
            if (!file.exists() || !file.isDirectory()) {
                return 0;
            }
            int length = file.listFiles().length;
            if (length > 0) {
                return length - 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    public final String b() {
        return this.f4989b;
    }

    public final Long a() {
        return this.f4991d;
    }

    public final void c() throws Exception {
        if (this.f4992f.getAndSet(true)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4988a);
        String str = File.separator;
        sb.append(str);
        sb.append(this.f4989b);
        sb.append(str);
        sb.append("select.lock");
        com.bykv.vk.openvk.preload.geckox.g.b bVarA = com.bykv.vk.openvk.preload.geckox.g.b.a(sb.toString());
        GeckoLogger.d("gecko-file-lock", "channel version loader clean");
        try {
            if (this.f4990c == null) {
                return;
            }
            com.bykv.vk.openvk.preload.geckox.g.c.b(this.f4990c.getAbsolutePath() + str + "using.lock");
            bVarA.a();
            com.bykv.vk.openvk.preload.geckox.a.c.a(this.f4988a + str + this.f4989b);
        } finally {
            bVarA.a();
        }
    }
}
