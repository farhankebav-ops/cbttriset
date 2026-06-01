package com.apm.insight.k;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.apm.insight.Npth;
import com.apm.insight.runtime.l;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> f4495a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> f4496b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f4497c;
    private volatile boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f4499f = new Runnable() { // from class: com.apm.insight.k.g.1
        @Override // java.lang.Runnable
        public final void run() {
            if (Npth.isStopUpload()) {
                return;
            }
            if (!g.f4496b.isEmpty() && l.e()) {
                g.f();
            }
            g.this.c();
            g.this.f4498d.a(g.this.f4499f, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f4498d = m.a();

    private g() {
    }

    private static void c(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        try {
            String string = cVar.c().getString("log_type");
            HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> map = f4496b;
            synchronized (map) {
                try {
                    HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>> map2 = map.get(string);
                    if (map2 == null) {
                        map2 = new HashMap<>();
                        map.put(obj, map2);
                    }
                    concurrentLinkedQueue = map2.get(string);
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        map2.put(string, concurrentLinkedQueue);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            concurrentLinkedQueue.add(cVar);
            if (concurrentLinkedQueue.size() > 100) {
                concurrentLinkedQueue.poll();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f() {
        HashMap map;
        HashMap<Object, HashMap<String, ConcurrentLinkedQueue<com.apm.insight.entity.c>>> map2 = f4496b;
        synchronized (map2) {
            map = new HashMap(map2);
            map2.clear();
        }
        if (!com.apm.insight.runtime.a.a()) {
            com.apm.insight.a.a("EventUploadQueue", "ApmConfig not inited, clear cache.");
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            for (Map.Entry entry2 : ((HashMap) entry.getValue()).entrySet()) {
                String str = (String) entry2.getKey();
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) entry2.getValue();
                if (concurrentLinkedQueue == null || (com.apm.insight.runtime.a.a() && !com.apm.insight.runtime.a.b(entry.getKey()))) {
                    com.apm.insight.a.a("EventUploadQueue", "logType " + str + " not sampled");
                } else {
                    while (!concurrentLinkedQueue.isEmpty()) {
                        try {
                            com.apm.insight.entity.c cVar = (com.apm.insight.entity.c) concurrentLinkedQueue.poll();
                            if (cVar != null) {
                                b(entry.getKey(), cVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    private static void g() {
        if (!l.e() || Npth.isStopUpload()) {
            return;
        }
        try {
            m.a().a(new Runnable() { // from class: com.apm.insight.k.g.3
                @Override // java.lang.Runnable
                public final void run() {
                    g.a().c();
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static g a() {
        if (f4497c == null) {
            synchronized (g.class) {
                try {
                    if (f4497c == null) {
                        f4497c = new g();
                    }
                } finally {
                }
            }
        }
        return f4497c;
    }

    private static void b(Object obj, com.apm.insight.entity.c cVar) {
        ConcurrentHashMap<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> concurrentHashMap;
        ConcurrentLinkedQueue<com.apm.insight.entity.c> concurrentLinkedQueue;
        synchronized (obj) {
            try {
                concurrentHashMap = f4495a;
                concurrentLinkedQueue = concurrentHashMap.get(obj);
                if (concurrentLinkedQueue == null) {
                    concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                    concurrentHashMap.put(obj, concurrentLinkedQueue);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        concurrentLinkedQueue.add(cVar);
        int size = concurrentHashMap.size();
        boolean z2 = size >= 30;
        com.apm.insight.a.b((Object) "[enqueue] size=".concat(String.valueOf(size)));
        if (z2) {
            g();
        }
    }

    public static void a(@NonNull com.apm.insight.entity.c cVar) {
        a(com.apm.insight.d.a(), cVar);
    }

    public static void a(@Nullable final Object obj, @NonNull final com.apm.insight.entity.c cVar) {
        String string;
        Handler handlerA = m.a().a();
        if (handlerA != null && handlerA.getLooper() == Looper.myLooper()) {
            if (obj == null) {
                obj = com.apm.insight.d.a();
            }
            if (!l.e()) {
                com.apm.insight.a.a("EventUploadQueue", "enqueue before init.");
                c(obj, cVar);
                return;
            }
            if (!com.apm.insight.runtime.a.a(obj)) {
                a.b();
            }
            f();
            try {
                string = cVar.c().getString("log_type");
            } catch (JSONException e) {
                e.printStackTrace();
                string = null;
            }
            if (!TextUtils.isEmpty(string) && com.apm.insight.runtime.a.b(obj)) {
                com.apm.insight.a.a("EventUploadQueue", "logType " + string + " enqueued");
                b(obj, cVar);
                return;
            }
            com.apm.insight.a.a("EventUploadQueue", "logType " + string + " not sampled");
            return;
        }
        m.a().a(new Runnable() { // from class: com.apm.insight.k.g.2
            @Override // java.lang.Runnable
            public final void run() {
                g.a(obj, cVar);
            }
        });
    }

    public final void b() {
        if (f4495a.isEmpty()) {
            this.f4498d.a(this.f4499f, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
        } else {
            this.f4498d.a(this.f4499f);
        }
    }

    public final void c() {
        synchronized (this.f4498d) {
            try {
                if (this.e) {
                    return;
                }
                this.e = true;
                LinkedList linkedList = new LinkedList();
                for (Map.Entry<Object, ConcurrentLinkedQueue<com.apm.insight.entity.c>> entry : f4495a.entrySet()) {
                    ConcurrentLinkedQueue<com.apm.insight.entity.c> value = entry.getValue();
                    Object key = entry.getKey();
                    while (!value.isEmpty()) {
                        for (int i2 = 0; i2 < 30; i2++) {
                            try {
                                if (value.isEmpty()) {
                                    break;
                                }
                                linkedList.add(value.poll());
                            } catch (Throwable th) {
                                com.apm.insight.a.b(th);
                            }
                        }
                        if (linkedList.isEmpty()) {
                            break;
                        }
                        com.apm.insight.entity.a aVarA = com.apm.insight.runtime.a.f.a().a(linkedList, com.apm.insight.entity.b.a(key));
                        if (aVarA != null) {
                            com.apm.insight.a.a((Object) "upload events");
                            d.a().b(aVarA.c());
                        }
                        linkedList.clear();
                    }
                }
                this.e = false;
            } finally {
            }
        }
    }
}
