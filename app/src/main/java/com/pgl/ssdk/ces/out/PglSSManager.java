package com.pgl.ssdk.ces.out;

import android.content.Context;
import android.view.MotionEvent;
import com.pgl.ssdk.ces.b;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class PglSSManager {
    public static final int INIT_STATUS_FAIL_CONTEXT_NULL = 4;
    public static final int INIT_STATUS_FAIL_SO_LOADFAIL = 3;
    public static final int INIT_STATUS_FAIL_SO_MISSING = 2;
    public static final int INIT_STATUS_OK = 0;
    public static final int INIT_STATUS_UNINITIALIZE = 1;
    public static final String REPORT_SCENE_ADSHOW = "AdShow";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile PglSSManager f10741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f10742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f10743c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile PglSSCallBack f10744d;

    private PglSSManager(Context context, PglSSConfig pglSSConfig) {
        this.f10742b = b.a(context, pglSSConfig.getAppId(), pglSSConfig.getOVRegionType(), pglSSConfig.getCollectMode(), pglSSConfig.getAdSdkVersion());
    }

    public static int getInitStatus() {
        return b.g();
    }

    public static PglSSManager getInstance() {
        return f10741a;
    }

    public static String getLoadError() {
        if (b.i() != null) {
            return b.i().f10822b;
        }
        return null;
    }

    @DungeonFlag
    public static PglSSManager init(Context context, PglSSConfig pglSSConfig, String str, String str2, String str3, String str4) {
        if (context == null && pglSSConfig == null) {
            return null;
        }
        if (f10741a == null) {
            synchronized (PglSSManager.class) {
                try {
                    if (f10741a == null) {
                        f10741a = new PglSSManager(context, pglSSConfig);
                        if (b.g() == 0) {
                            f10741a.f10744d = pglSSConfig.getCallBack();
                            f10741a.f10742b.a(pglSSConfig.getCustomInfo());
                            f10741a.f10742b.a(str, str3, str2, str4);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f10741a;
    }

    public void checkEventVirtual(MotionEvent motionEvent) {
        if (b.g() == 0) {
            this.f10742b.a(motionEvent);
        }
    }

    public long getECForBidding() {
        if (b.g() == 0) {
            return this.f10742b.e();
        }
        return 0L;
    }

    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        if (b.g() == 0) {
            return this.f10742b.a(str, bArr);
        }
        return null;
    }

    public PglSSCallBack getPglCallBack() {
        return this.f10744d;
    }

    public String getSofChara() {
        if (b.g() == 0) {
            return this.f10742b.j();
        }
        return null;
    }

    public String getToken() {
        if (b.g() == 0) {
            return this.f10742b.k();
        }
        return null;
    }

    public void reportNow(String str, Map<String, Object> map) {
        if (b.g() == 0) {
            if (REPORT_SCENE_ADSHOW.equals(str)) {
                this.f10742b.b();
            }
            int i2 = this.f10743c;
            b bVar = this.f10742b;
            if (i2 % bVar.p == 0) {
                bVar.a(str, map);
            }
            this.f10743c++;
        }
    }

    public void setCustomInfo(Map<String, Object> map) {
        if (b.g() == 0) {
            this.f10742b.a(map);
        }
    }

    public void setDeviceId(String str) {
        if (b.g() == 0) {
            this.f10742b.b(str);
        }
    }

    public void setGaid(String str) {
        if (b.g() == 0) {
            this.f10742b.c(str);
        }
    }
}
