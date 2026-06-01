package com.bykv.vk.openvk.preload.geckox;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.falconx.a.a f4910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<String> f4911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f4912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f4913d;

    private a(b bVar) {
        new ArrayList();
        this.f4910a = new com.bykv.vk.openvk.preload.falconx.a.a();
        this.f4911b = new LinkedBlockingQueue();
        this.f4912c = bVar;
        File fileN = bVar.n();
        this.f4913d = fileN;
        fileN.mkdirs();
        com.bykv.vk.openvk.preload.geckox.statistic.b.a(this, this.f4912c);
    }

    public static /* synthetic */ void d(a aVar) {
        new ArrayList().addAll(aVar.f4912c.e());
        try {
            String strA = com.bykv.vk.openvk.preload.geckox.c.b.a().b().a(new com.bykv.vk.openvk.preload.geckox.a.a());
            if (aVar.f4912c.p() != null && aVar.f4912c.p().a()) {
                aVar.f4912c.p();
            } else if (aVar.f4911b.size() < 10) {
                aVar.f4911b.add(strA);
            }
        } catch (Throwable unused) {
        }
    }

    public static a a(b bVar) {
        List<String> listE = bVar.e();
        if (listE == null || listE.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        bVar.a();
        return new a(bVar);
    }

    private boolean b(Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        if (map != null && !map.isEmpty()) {
            List<String> listE = this.f4912c.e();
            for (Map.Entry<String, List<CheckRequestBodyModel.TargetChannel>> entry : map.entrySet()) {
                Iterator<String> it = listE.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    if (TextUtils.equals(it.next(), entry.getKey())) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean a() {
        List<String> listD = this.f4912c.d();
        List<String> listE = this.f4912c.e();
        if (listD == null || listD.isEmpty() || listE == null || listE.isEmpty()) {
            return false;
        }
        for (String str : listE) {
            Iterator<String> it = listD.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                if (TextUtils.equals(str, it.next())) {
                    z2 = true;
                }
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    public final void a(Class<? extends d<?, ?>> cls, com.bykv.vk.openvk.preload.b.b.a aVar) {
        this.f4910a.a(cls, aVar);
    }

    public final void a(final Map<String, List<CheckRequestBodyModel.TargetChannel>> map) {
        final String str = "default";
        if (!TextUtils.isEmpty("default")) {
            if (a()) {
                if (b(map)) {
                    final com.bykv.vk.openvk.preload.geckox.e.a aVar = null;
                    final Map map2 = null;
                    b.h().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.bykv.vk.openvk.preload.geckox.a.a.b bVarA;
                            GeckoLogger.d("gecko-debug-tag", "start check update...", str);
                            if (a.this.f4912c.b() != null) {
                                bVarA = a.this.f4912c.b().a();
                                bVarA.a(a.this.f4912c.b(), a.this.f4912c.n(), a.this.f4912c.e());
                            } else {
                                bVarA = null;
                            }
                            com.bykv.vk.openvk.preload.geckox.a.a.b bVar = bVarA;
                            try {
                                try {
                                    a.this.f4912c.a(new JSONObject());
                                    GeckoLogger.d("gecko-debug-tag", "update finished", com.bykv.vk.openvk.preload.geckox.h.a.a(aVar, a.this.f4913d, a.this.f4912c, a.this.f4910a, map2, map, str).a(str));
                                    if (bVar != null) {
                                        bVar.a();
                                    }
                                    JSONObject jSONObjectF = a.this.f4912c.f();
                                    if (jSONObjectF == null) {
                                        jSONObjectF = new JSONObject();
                                    }
                                    try {
                                        jSONObjectF.put("download_duration", SystemClock.elapsedRealtime() - a.this.f4912c.s());
                                    } catch (Throwable unused) {
                                    }
                                    a.this.f4912c.q().upload("download_gecko_end", jSONObjectF);
                                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                                } catch (Exception e) {
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("success", false);
                                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, e.toString());
                                        jSONObject.put("code", 2);
                                        a.this.f4912c.a(jSONObject);
                                    } catch (Throwable unused2) {
                                    }
                                    GeckoLogger.w("gecko-debug-tag", "Gecko update failed:", e);
                                    if (bVar != null) {
                                        bVar.a();
                                    }
                                    JSONObject jSONObjectF2 = a.this.f4912c.f();
                                    if (jSONObjectF2 == null) {
                                        jSONObjectF2 = new JSONObject();
                                    }
                                    try {
                                        jSONObjectF2.put("download_duration", SystemClock.elapsedRealtime() - a.this.f4912c.s());
                                    } catch (Throwable unused3) {
                                    }
                                    a.this.f4912c.q().upload("download_gecko_end", jSONObjectF2);
                                    GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                                }
                                a.d(a.this);
                            } catch (Throwable th) {
                                if (bVar != null) {
                                    bVar.a();
                                }
                                JSONObject jSONObjectF3 = a.this.f4912c.f();
                                if (jSONObjectF3 == null) {
                                    jSONObjectF3 = new JSONObject();
                                }
                                try {
                                    jSONObjectF3.put("download_duration", SystemClock.elapsedRealtime() - a.this.f4912c.s());
                                } catch (Throwable unused4) {
                                }
                                a.this.f4912c.q().upload("download_gecko_end", jSONObjectF3);
                                GeckoLogger.d("gecko-debug-tag", "all channel update finished");
                                throw th;
                            }
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("target keys not in deployments keys");
            }
            throw new IllegalArgumentException("deployments keys not in local keys");
        }
        throw new IllegalArgumentException("groupType == null");
    }
}
