package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static IThreadPoolCallback f4932r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static ThreadPoolExecutor f4933s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.geckox.a.a.c f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IStatisticMonitor f4936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final INetWork f4937d;
    private final List<String> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f4938f;
    private final com.bykv.vk.openvk.preload.geckox.a.a.a g;
    private final Long h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f4939i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final File f4940n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f4941o;
    private final long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private JSONObject f4942q;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private INetWork f4943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f4944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<String> f4945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f4946d;
        private com.bykv.vk.openvk.preload.geckox.a.a.c e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IStatisticMonitor f4947f;
        private boolean g = true;
        private com.bykv.vk.openvk.preload.geckox.a.a.a h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Long f4948i;
        private String j;
        private String k;
        private String l;
        private File m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f4949n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f4950o;
        private long p;

        public a(Context context) {
            this.f4946d = context.getApplicationContext();
        }

        public final a a(String... strArr) {
            this.f4945c = Arrays.asList(strArr);
            return this;
        }

        public final a b(String... strArr) {
            this.f4944b = Arrays.asList(strArr);
            return this;
        }

        public final a c(String str) {
            this.l = str;
            return this;
        }

        public final a a(INetWork iNetWork) {
            this.f4943a = iNetWork;
            return this;
        }

        public final a b() {
            this.f4948i = 38L;
            return this;
        }

        public final a a(long j) {
            this.p = j;
            return this;
        }

        public final a b(String str) {
            this.k = str;
            return this;
        }

        public final a a(IStatisticMonitor iStatisticMonitor) {
            this.f4947f = iStatisticMonitor;
            return this;
        }

        public final a a() {
            this.g = false;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.geckox.a.a.a aVar) {
            this.h = aVar;
            return this;
        }

        public final a a(String str) {
            this.j = str;
            return this;
        }

        public final a a(File file) {
            this.m = file;
            return this;
        }
    }

    public /* synthetic */ b(a aVar, byte b8) {
        this(aVar);
    }

    public static Executor g() {
        return t();
    }

    public static Executor h() {
        return t();
    }

    public static ExecutorService t() {
        IThreadPoolCallback iThreadPoolCallback = f4932r;
        ExecutorService threadPool = iThreadPoolCallback != null ? iThreadPoolCallback.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (f4933s == null) {
            synchronized (b.class) {
                try {
                    if (f4933s == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        f4933s = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f4933s;
    }

    public final Context a() {
        return this.f4934a;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.a b() {
        return this.g;
    }

    public final boolean c() {
        return this.f4941o;
    }

    public final List<String> d() {
        return this.f4938f;
    }

    public final List<String> e() {
        return this.e;
    }

    public final JSONObject f() {
        return this.f4942q;
    }

    public final INetWork i() {
        return this.f4937d;
    }

    public final String j() {
        return this.k;
    }

    public final long k() {
        return this.h.longValue();
    }

    public final String l() {
        return this.m;
    }

    public final String m() {
        return this.l;
    }

    public final File n() {
        return this.f4940n;
    }

    public final String o() {
        return this.f4939i;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.c p() {
        return this.f4935b;
    }

    public final IStatisticMonitor q() {
        return this.f4936c;
    }

    public final String r() {
        return this.j;
    }

    public final long s() {
        return this.p;
    }

    private b(a aVar) {
        Context context = aVar.f4946d;
        this.f4934a = context;
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        List<String> list = aVar.f4944b;
        this.e = list;
        this.f4938f = aVar.f4945c;
        this.f4935b = aVar.e;
        this.g = aVar.h;
        Long l = aVar.f4948i;
        this.h = l;
        if (TextUtils.isEmpty(aVar.j)) {
            this.f4939i = com.bykv.vk.openvk.preload.geckox.utils.a.a(context);
        } else {
            this.f4939i = aVar.j;
        }
        String str = aVar.k;
        this.j = str;
        this.l = aVar.f4949n;
        this.m = aVar.f4950o;
        this.p = aVar.p;
        if (aVar.m == null) {
            this.f4940n = new File(context.getFilesDir(), "gecko_offline_res_x");
        } else {
            this.f4940n = aVar.m;
        }
        String str2 = aVar.l;
        this.k = str2;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("host == null");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        if (l == null) {
            throw new IllegalArgumentException("appId == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        this.f4937d = aVar.f4943a;
        this.f4936c = aVar.f4947f;
        this.f4941o = aVar.g;
    }

    public final void a(JSONObject jSONObject) {
        this.f4942q = jSONObject;
    }

    public static void a(IThreadPoolCallback iThreadPoolCallback) {
        f4932r = iThreadPoolCallback;
    }
}
