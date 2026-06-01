package com.ironsource;

import android.text.TextUtils;
import com.ironsource.AbstractC2581u3;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.wf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2627wf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<IronSource.a, C2494p0> f10489a = new HashMap();

    /* JADX INFO: renamed from: com.ironsource.wf$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f10491b;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            f10491b = iArr;
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10491b[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10491b[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10491b[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IronSource.a.values().length];
            f10490a = iArr2;
            try {
                iArr2[IronSource.a.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10490a[IronSource.a.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10490a[IronSource.a.NATIVE_AD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10490a[IronSource.a.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static R0 a(AbstractC2595v0 abstractC2595v0, int i2) {
        return a(abstractC2595v0).a(abstractC2595v0.b().c(), abstractC2595v0.m(), i2);
    }

    public static b b(IronSource.a aVar) {
        return new b(aVar);
    }

    public static int c(IronSource.a aVar) {
        int i2 = a.f10490a[aVar.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? AbstractC2581u3.e.NOT_SUPPORTED.b() : AbstractC2581u3.e.BANNER.b() : AbstractC2581u3.e.NATIVE_AD.b() : AbstractC2581u3.e.INTERSTITIAL.b() : AbstractC2581u3.e.REWARDED_VIDEO.b();
    }

    public static IronSource.a b(LevelPlay.AdFormat adFormat) {
        if (adFormat == null) {
            return null;
        }
        int i2 = a.f10491b[adFormat.ordinal()];
        if (i2 == 1) {
            return IronSource.a.REWARDED_VIDEO;
        }
        if (i2 == 2) {
            return IronSource.a.INTERSTITIAL;
        }
        if (i2 == 3) {
            return IronSource.a.BANNER;
        }
        if (i2 != 4) {
            return null;
        }
        return IronSource.a.NATIVE_AD;
    }

    private static C2494p0 a(AbstractC2595v0 abstractC2595v0) {
        Map<IronSource.a, C2494p0> map = f10489a;
        if (map.containsKey(abstractC2595v0.b().a())) {
            return map.get(abstractC2595v0.b().a());
        }
        C2494p0 c2494p0 = new C2494p0();
        map.put(abstractC2595v0.b().a(), c2494p0);
        return c2494p0;
    }

    public static C2270ca a() {
        return com.ironsource.mediationsdk.r.m().s();
    }

    public static void a(Throwable th) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "SafeRunnable", th);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", th.getMessage());
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        a(D5.TROUBLESHOOTING_SDK_INTERNAL_ERROR, jSONObject);
    }

    /* JADX INFO: renamed from: com.ironsource.wf$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IronSource.a f10492a;

        public b(IronSource.a aVar) {
            this.f10492a = aVar;
        }

        private String b() {
            IronSource.a aVar = this.f10492a;
            return aVar != null ? aVar.name() : "";
        }

        public String a(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append(b());
            sb.append(TextUtils.isEmpty(str2) ? "" : a1.a.l(" - ", str2));
            String string = sb.toString();
            return TextUtils.isEmpty(str) ? string : a1.a.D(string, " - ", str);
        }

        public String a(String str) {
            return a(str, null);
        }

        public String a() {
            return a(null);
        }
    }

    public static void a(Exception exc) {
        IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "Exception", exc);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reason", exc.getMessage());
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        a(D5.TROUBLESHOOTING_LOAD_ARM_DATA_PARSE_ERROR, jSONObject);
    }

    public static void a(D5 d52, JSONObject jSONObject) {
        Mb.U().q().a(new C5(d52, C2395ja.a(IronSourceUtils.b(false), jSONObject)));
    }

    public static boolean a(AdapterBaseInterface adapterBaseInterface, IronSource.a aVar, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        if (ContextProvider.getInstance().getCurrentActiveActivity() != null || !(adapterBaseInterface instanceof AdapterSettingsInterface) || !((AdapterSettingsInterface) adapterBaseInterface).isUsingActivityBeforeImpression(a(aVar))) {
            return false;
        }
        ironLog.verbose(str + " - is using activity before impression and activity is null");
        return true;
    }

    public static String a(LevelPlay.AdFormat adFormat) {
        int i2 = a.f10491b[adFormat.ordinal()];
        if (i2 == 1) {
            return "rewarded";
        }
        if (i2 == 2) {
            return "interstitial";
        }
        if (i2 == 3) {
            return "banner";
        }
        if (i2 != 4) {
            return "";
        }
        return "nativeAd";
    }

    public static LevelPlay.AdFormat a(IronSource.a aVar) {
        int i2 = a.f10490a[aVar.ordinal()];
        if (i2 == 1) {
            return LevelPlay.AdFormat.REWARDED;
        }
        if (i2 == 2) {
            return LevelPlay.AdFormat.INTERSTITIAL;
        }
        if (i2 == 3) {
            return LevelPlay.AdFormat.NATIVE_AD;
        }
        if (i2 != 4) {
            return null;
        }
        return LevelPlay.AdFormat.BANNER;
    }
}
