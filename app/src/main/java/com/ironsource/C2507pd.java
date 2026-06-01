package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.P7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: renamed from: com.ironsource.pd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2507pd implements P7, P7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9661a = "CappingManager.IS_DELIVERY_ENABLED";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9662b = "CappingManager.IS_CAPPING_ENABLED";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9663c = "CappingManager.IS_PACING_ENABLED";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9664d = "CappingManager.MAX_NUMBER_OF_SHOWS";
    private static final String e = "CappingManager.CAPPING_TYPE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9665f = "CappingManager.SECONDS_BETWEEN_SHOWS";
    private static final String g = "CappingManager.CURRENT_NUMBER_OF_SHOWS";
    private static final String h = "CappingManager.CAPPING_TIME_THRESHOLD";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9666i = "CappingManager.TIME_OF_THE_PREVIOUS_SHOW";

    /* JADX INFO: renamed from: com.ironsource.pd$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9667a;

        static {
            int[] iArr = new int[EnumC2524qd.values().length];
            f9667a = iArr;
            try {
                iArr[EnumC2524qd.PER_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9667a[EnumC2524qd.PER_HOUR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.pd$b */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum b {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    @Override // com.ironsource.P7
    public synchronized b a(Context context, AbstractC2615w3 abstractC2615w3, IronSource.a aVar) {
        if (context == null) {
            return b.NOT_CAPPED;
        }
        if (abstractC2615w3 == null) {
            return b.NOT_CAPPED;
        }
        String strA = a(aVar);
        if (abstractC2615w3.c() == null) {
            return b.NOT_CAPPED;
        }
        if (abstractC2615w3.a() == null) {
            return b.NOT_CAPPED;
        }
        return b(context, strA, abstractC2615w3.c());
    }

    @Override // com.ironsource.P7.a
    public synchronized void b(Context context, AbstractC2615w3 abstractC2615w3, IronSource.a aVar) {
        if (context == null || abstractC2615w3 == null) {
            return;
        }
        C2452md c2452mdA = abstractC2615w3.a();
        if (c2452mdA == null) {
            return;
        }
        a(context, a(aVar), abstractC2615w3.c(), c2452mdA);
    }

    @Override // com.ironsource.P7
    public synchronized boolean c(Context context, AbstractC2615w3 abstractC2615w3, IronSource.a aVar) {
        return a(context, abstractC2615w3, aVar) != b.NOT_CAPPED;
    }

    private b b(Context context, String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.a(context, a(str, f9661a, str2), true)) {
            return b.CAPPED_PER_DELIVERY;
        }
        if (IronSourceUtils.a(context, a(str, f9663c, str2), false)) {
            if (jCurrentTimeMillis - IronSourceUtils.a(context, a(str, f9666i, str2), 0L) < IronSourceUtils.a(context, a(str, f9665f, str2), 0) * 1000) {
                return b.CAPPED_PER_PACE;
            }
        }
        if (IronSourceUtils.a(context, a(str, f9662b, str2), false)) {
            int iA = IronSourceUtils.a(context, a(str, f9664d, str2), 0);
            String strA = a(str, g, str2);
            int iA2 = IronSourceUtils.a(context, strA, 0);
            String strA2 = a(str, h, str2);
            if (jCurrentTimeMillis >= IronSourceUtils.a(context, strA2, 0L)) {
                IronSourceUtils.b(context, strA, 0);
                IronSourceUtils.b(context, strA2, 0L);
            } else if (iA2 >= iA) {
                return b.CAPPED_PER_COUNT;
            }
        }
        return b.NOT_CAPPED;
    }

    @Override // com.ironsource.P7.a
    public synchronized void a(Context context, String str, IronSource.a aVar) {
        if (context == null) {
            return;
        }
        if (str == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, a(aVar), str);
    }

    private String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    private void a(Context context, String str, String str2) {
        EnumC2524qd enumC2524qd;
        int i2 = 0;
        if (IronSourceUtils.a(context, a(str, f9663c, str2), false)) {
            IronSourceUtils.b(context, a(str, f9666i, str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.a(context, a(str, f9662b, str2), false)) {
            String strA = a(str, g, str2);
            int iA = IronSourceUtils.a(context, strA, 0);
            if (iA == 0) {
                String strC = IronSourceUtils.c(context, a(str, e, str2), EnumC2524qd.PER_DAY.toString());
                EnumC2524qd[] enumC2524qdArrValues = EnumC2524qd.values();
                int length = enumC2524qdArrValues.length;
                while (true) {
                    if (i2 >= length) {
                        enumC2524qd = null;
                        break;
                    }
                    enumC2524qd = enumC2524qdArrValues[i2];
                    if (enumC2524qd.f9712a.equals(strC)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                IronSourceUtils.b(context, a(str, h, str2), a(enumC2524qd));
            }
            IronSourceUtils.b(context, strA, iA + 1);
        }
    }

    private long a(EnumC2524qd enumC2524qd) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i2 = a.f9667a[enumC2524qd.ordinal()];
        if (i2 == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i2 == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    private void a(Context context, String str, String str2, C2452md c2452md) {
        boolean zE = c2452md.e();
        IronSourceUtils.b(context, a(str, f9661a, str2), zE);
        if (zE) {
            boolean zD = c2452md.d();
            IronSourceUtils.b(context, a(str, f9662b, str2), zD);
            if (zD) {
                IronSourceUtils.b(context, a(str, f9664d, str2), c2452md.b());
                IronSourceUtils.f(context, a(str, e, str2), c2452md.a().toString());
            }
            boolean zF = c2452md.f();
            IronSourceUtils.b(context, a(str, f9663c, str2), zF);
            if (zF) {
                IronSourceUtils.b(context, a(str, f9665f, str2), c2452md.c());
            }
        }
    }

    private String a(IronSource.a aVar) {
        if (aVar == IronSource.a.REWARDED_VIDEO) {
            return IronSourceConstants.REWARDED_VIDEO_AD_UNIT;
        }
        if (aVar == IronSource.a.INTERSTITIAL) {
            return "Interstitial";
        }
        if (aVar == IronSource.a.BANNER) {
            return "Banner";
        }
        if (aVar == IronSource.a.NATIVE_AD) {
            return IronSourceConstants.NATIVE_AD_UNIT;
        }
        return aVar.toString();
    }
}
