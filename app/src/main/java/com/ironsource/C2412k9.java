package com.ironsource;

import com.ironsource.Me;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ironsourceads.IronSourceAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.k9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2412k9 {

    /* JADX INFO: renamed from: com.ironsource.k9$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8852a;

        static {
            int[] iArr = new int[IronSourceAds.AdFormat.values().length];
            try {
                iArr[IronSourceAds.AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSourceAds.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSourceAds.AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f8852a = iArr;
        }
    }

    public final void a(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        V7.a(V7.f7731a, runnable, 0L, 2, null);
    }

    public final void b(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        V7.f7731a.a(callback);
    }

    public final IronSource.a[] a(List<? extends IronSourceAds.AdFormat> adFormats) {
        kotlin.jvm.internal.k.e(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends IronSourceAds.AdFormat> it = adFormats.iterator();
        while (it.hasNext()) {
            int i2 = a.f8852a[it.next().ordinal()];
            if (i2 == 1) {
                arrayList.add(IronSource.a.BANNER);
            } else if (i2 == 2) {
                arrayList.add(IronSource.a.INTERSTITIAL);
            } else if (i2 == 3) {
                arrayList.add(IronSource.a.REWARDED_VIDEO);
            }
        }
        return (IronSource.a[]) arrayList.toArray(new IronSource.a[0]);
    }

    public final IronSourceError a(C2473ne error) {
        kotlin.jvm.internal.k.e(error, "error");
        if (error.c() != 2070 && error.c() != 2110) {
            if (error.c() != 2080 && error.c() != 2100) {
                if (error.c() == 2090) {
                    return C2668z5.f10625a.a();
                }
                return new IronSourceError(510, error.d());
            }
            return C2668z5.f10625a.c();
        }
        return C2668z5.f10625a.b();
    }

    public final void a(long j, Me.a responseOrigin) {
        kotlin.jvm.internal.k.e(responseOrigin, "responseOrigin");
        JSONObject jSONObjectB = IronSourceUtils.b(true);
        try {
            jSONObjectB.put("isMultipleAdObjects", 1);
            jSONObjectB.put("duration", j);
            jSONObjectB.put(IronSourceConstants.EVENTS_EXT1, responseOrigin.b());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        Mb.f7131s.d().q().a(new C5(D5.SDK_INIT_SUCCESS, jSONObjectB));
    }

    public final void a(C2473ne error, long j) {
        kotlin.jvm.internal.k.e(error, "error");
        JSONObject jSONObjectB = IronSourceUtils.b(true);
        try {
            jSONObjectB.put(IronSourceConstants.EVENTS_ERROR_CODE, error.c());
            jSONObjectB.put("reason", error.d());
            jSONObjectB.put("duration", j);
            jSONObjectB.put("isMultipleAdObjects", 1);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        Mb.f7131s.d().q().a(new C5(D5.SDK_INIT_FAILED, jSONObjectB));
    }
}
