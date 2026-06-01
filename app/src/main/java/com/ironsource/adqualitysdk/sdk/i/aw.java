package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdListener;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitError;
import com.ironsource.adqualitysdk.sdk.ISAdQualityInitListener;
import com.ironsource.adqualitysdk.sdk.IronSourceAdQuality;
import com.ironsource.adqualitysdk.sdk.i.ay;
import com.ironsource.adqualitysdk.sdk.i.az.AnonymousClass4;
import com.ironsource.adqualitysdk.sdk.i.az.AnonymousClass5;
import com.ironsource.adqualitysdk.sdk.i.ja;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class aw {

    /* JADX INFO: renamed from: リ, reason: contains not printable characters */
    private static int f456 = 1;

    /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
    private static int f457 = 0;

    /* JADX INFO: renamed from: ヶ, reason: contains not printable characters */
    private static byte[] f458 = {-66, 28, 18, -28, 18, -11, 61, -12, 58, 56, -94, 27, -24, -28, 31, 5, -4, -26, -28, 16, 80, -22, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, -117, 120, -128, 117, -117, -110, 93, -123, 125, -105, 120, 113, -122, 121, -86, -87, 83, -86, 90, -83, -95, 67, -6, 2, -81, 87, -67, 82, 91, -84, 83, -96, -17, 21, 85, -87, -87, -84, -81, -19, 2, -81, 81, -84, -127, 92, 94, -96, 93, 80, 24, -13, 94, -90, 76, -93, -86, 93, -94, 81, 30, -28, -92, 88, 88, 93, 94, 28, -13, 94, -96, 93, 112, -67, 82, 15, 9, -6, -15, 3, -7, -83, -19, 17, -23, 30, 21, -6, 30, 49, -46, 44, 42, 64, -68, 77, -20, 10, -67, -15, 4, 71, -71, -69, 74, -69, -12, 20, -67, -71, -10, 21, -86, 82, -17, 21, -71, -69, 67, -87, 70, 79, -72, 71, -76, -5, 3, 69, 76, -20, 2, 79, -9, 3, 79, 71, -9, 20, -71, -86, 68, 65, -12, 20, -117, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: 丫, reason: contains not printable characters */
    private static short[] f459 = null;

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static int f460 = -1233204606;

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    private static char f461 = 29089;

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private static int f462 = 96;

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    private static char f463 = 61020;

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private static int f464 = 1390409778;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static char f465 = 30053;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static char f466 = 34416;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private bb f467;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private ISAdQualityInitListener f468;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private iw f469;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private String f472;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private az f474;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f478 = false;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private List<cn> f479 = new ArrayList();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private List<gk> f476 = new ArrayList();

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Map<String, JSONObject> f475 = new HashMap();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private Map<String, String> f477 = new HashMap();

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private de f470 = new de();

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private ds f473 = ds.m2132();

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private Map<String, au> f471 = new HashMap();

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.aw$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 extends iu {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private /* synthetic */ String f480;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private /* synthetic */ List f481;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private /* synthetic */ String f482;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        final /* synthetic */ Map f484;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        final /* synthetic */ Context f485;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        final /* synthetic */ Runnable f486;

        public AnonymousClass1(String str, Context context, String str2, List list, Map map, Runnable runnable) {
            this.f482 = str;
            this.f485 = context;
            this.f480 = str2;
            this.f481 = list;
            this.f484 = map;
            this.f486 = runnable;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            if (aq.m530().mo560(this.f482, aw.m650(aw.this))) {
                aw.m690(aw.this, this.f485, this.f480, this.f482, this.f481, new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.1.1
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        if (aw.m653(aw.this)) {
                            p.m2970(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.1.1.5
                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    aw.m691(aw.this, anonymousClass1.f485, anonymousClass1.f484, anonymousClass1.f486);
                                }
                            }, aq.m530().mo534());
                        }
                    }
                });
                return;
            }
            JSONObject jSONObject = new JSONObject();
            aw.m669(aw.this, this.f482, jSONObject);
            aw.m649(aw.this).put(this.f482, jSONObject);
            p.m2970(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.1.4
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    aw.m691(aw.this, anonymousClass1.f485, anonymousClass1.f484, anonymousClass1.f486);
                }
            }, aq.m530().mo534());
        }
    }

    public aw(iw iwVar, ah ahVar, String str, az azVar, ISAdQualityInitListener iSAdQualityInitListener) {
        this.f469 = iwVar;
        bb bbVar = new bb(p.m2966(), ahVar);
        this.f467 = bbVar;
        kd.m2921(bbVar);
        this.f467.m853(new io() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.3

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f536 = 1;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static long f537 = -1212349987351233413L;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f538;

            @Override // com.ironsource.adqualitysdk.sdk.i.io
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final JSONObject mo716(String str2, JSONObject jSONObject) {
                f538 = (f536 + 103) % 128;
                if (!str2.equals(m715("ﰏ桀풲䃿괥\u197e藖\uf204", 37963 - TextUtils.indexOf("", "")).intern())) {
                    return null;
                }
                f536 = (f538 + 7) % 128;
                JSONObject jSONObjectM706 = aw.this.m706();
                int i2 = f538 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
                f536 = i2 % 128;
                if (i2 % 2 != 0) {
                    return jSONObjectM706;
                }
                throw null;
            }

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m715(String str2, int i2) {
                String str3;
                Object charArray = str2;
                if (str2 != null) {
                    charArray = str2.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (j.f2671) {
                    try {
                        j.f2669 = i2;
                        char[] cArr2 = new char[cArr.length];
                        j.f2670 = 0;
                        while (true) {
                            int i8 = j.f2670;
                            if (i8 < cArr.length) {
                                cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f537);
                                j.f2670++;
                            } else {
                                str3 = new String(cArr2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str3;
            }
        });
        this.f472 = str;
        this.f474 = azVar;
        this.f468 = iSAdQualityInitListener;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private synchronized void m645() {
        f457 = (f456 + 11) % 128;
        if (this.f474.m761()) {
            m712().adQualitySdkInitSuccess();
            f457 = (f456 + 27) % 128;
        } else {
            f457 = (f456 + 19) % 128;
            m712().adQualitySdkInitFailed(ISAdQualityInitError.CONNECTOR_LOAD_TIMEOUT, m658((-43) - View.MeasureSpec.getMode(0), (short) (ImageFormat.getBitsPerPixel(0) + 1), View.getDefaultSize(0, 0) + 1233204734, (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 73), View.combineMeasuredStates(0, 0) - 1390409713).intern());
        }
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private synchronized boolean m646() {
        int i2 = f457 + 65;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            aq.m530().mo535();
            throw null;
        }
        return aq.m530().mo535();
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private synchronized boolean m647() {
        boolean z2 = false;
        if (!aq.m530().mo532() || !m646()) {
            return false;
        }
        int i2 = f456;
        int i8 = i2 + 103;
        f457 = i8 % 128;
        if (i8 % 2 == 0) {
            z2 = true;
        }
        f457 = (i2 + 77) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ Map m649(aw awVar) {
        int i2 = f456 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f457 = i2 % 128;
        int i8 = i2 % 2;
        Map<String, JSONObject> mapM652 = awVar.m652();
        if (i8 != 0) {
            int i9 = 91 / 0;
        }
        return mapM652;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static /* synthetic */ String m650(aw awVar) {
        int i2 = f456;
        int i8 = i2 + 1;
        f457 = i8 % 128;
        int i9 = i8 % 2;
        String str = awVar.f472;
        if (i9 != 0) {
            throw null;
        }
        f457 = (i2 + 61) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ boolean m653(aw awVar) {
        int i2 = f457 + 59;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        boolean zM646 = awVar.m646();
        if (i8 == 0) {
            int i9 = 16 / 0;
        }
        return zM646;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ List m655(aw awVar) {
        int i2 = f457 + 115;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        List<gk> listM651 = awVar.m651();
        if (i8 == 0) {
            int i9 = 34 / 0;
        }
        f457 = (f456 + 19) % 128;
        return listM651;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static /* synthetic */ void m657(aw awVar) {
        int i2 = f457 + 65;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        awVar.m689();
        if (i8 == 0) {
            throw null;
        }
        int i9 = f456 + 57;
        f457 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 59 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m663(aw awVar) {
        int i2 = f457 + 79;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        awVar.m645();
        if (i8 == 0) {
            int i9 = 42 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ ds m665(aw awVar, ds dsVar) {
        int i2 = f457;
        f456 = (i2 + 99) % 128;
        awVar.f473 = dsVar;
        f456 = (i2 + 103) % 128;
        return dsVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ az m673(aw awVar) {
        int i2 = f456 + 93;
        f457 = i2 % 128;
        int i8 = i2 % 2;
        az azVar = awVar.f474;
        if (i8 != 0) {
            int i9 = 1 / 0;
        }
        return azVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ cn m684(aw awVar, Context context, String str, bg bgVar) {
        int i2 = f457 + 67;
        f456 = i2 % 128;
        if (i2 % 2 != 0) {
            return awVar.m674(context, str, bgVar);
        }
        awVar.m674(context, str, bgVar);
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ List m695(aw awVar) {
        int i2 = f456 + 95;
        f457 = i2 % 128;
        int i8 = i2 % 2;
        List<cn> listM654 = awVar.m654();
        if (i8 != 0) {
            int i9 = 96 / 0;
        }
        return listM654;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private synchronized Map<String, String> m648() {
        int i2 = f457 + 69;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        return this.f477;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private synchronized List<gk> m651() {
        List<gk> list;
        int i2 = f457;
        list = this.f476;
        f456 = (i2 + 67) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private synchronized Map<String, JSONObject> m652() {
        Map<String, JSONObject> map;
        int i2 = f457;
        int i8 = i2 + 43;
        f456 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        map = this.f475;
        f456 = (i2 + 101) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private synchronized List<cn> m654() {
        List<cn> list;
        int i2 = (f457 + 89) % 128;
        f456 = i2;
        list = this.f479;
        f457 = (i2 + 103) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private List<cn> m656() {
        int i2 = f456 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (this.f479 != null) {
            return new ArrayList(this.f479);
        }
        ArrayList arrayList = new ArrayList();
        int i8 = f457 + 61;
        f456 = i8 % 128;
        if (i8 % 2 != 0) {
            return arrayList;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Map m666(aw awVar) {
        f456 = (f457 + 103) % 128;
        Map<String, String> mapM648 = awVar.m648();
        int i2 = f457 + 113;
        f456 = i2 % 128;
        if (i2 % 2 != 0) {
            return mapM648;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m679(aw awVar, Context context, List list, List list2, iu iuVar) {
        f457 = (f456 + 61) % 128;
        awVar.m700(context, list, list2, iuVar);
        int i2 = f457 + 63;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ List m685(aw awVar) {
        int i2 = f457 + 5;
        f456 = i2 % 128;
        if (i2 % 2 != 0) {
            return awVar.m656();
        }
        awVar.m656();
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ Map m696(aw awVar, Map map) {
        int i2 = f456;
        int i8 = i2 + 105;
        f457 = i8 % 128;
        int i9 = i8 % 2;
        awVar.f471 = map;
        if (i9 != 0) {
            throw null;
        }
        f457 = (i2 + 11) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized void m705() {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.12
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                Iterator it = aw.m685(aw.this).iterator();
                while (it.hasNext()) {
                    ((cn) it.next()).m1664();
                }
                aw.m695(aw.this).clear();
                aw.m686(aw.this, (List) null);
            }
        });
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.az.1
            public AnonymousClass1() {
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                az.this.f650.clear();
                az.this.f650 = null;
            }
        });
        this.f474 = null;
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.15
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() throws Exception {
                aw.m665(aw.this, (ds) null);
            }
        });
        f456 = (f457 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m668(aw awVar, Context context) {
        int i2 = f457 + 43;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        awVar.m660(context);
        if (i8 == 0) {
            throw null;
        }
        int i9 = f456 + 13;
        f457 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m680(aw awVar, cn cnVar, String str) {
        int i2 = f456 + 113;
        f457 = i2 % 128;
        int i8 = i2 % 2;
        awVar.m681(cnVar, str);
        if (i8 != 0) {
            throw null;
        }
        int i9 = f456 + 51;
        f457 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ List m686(aw awVar, List list) {
        int i2 = f457 + 19;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        awVar.f479 = list;
        if (i8 == 0) {
            int i9 = 60 / 0;
        }
        return list;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m702(aw awVar, Context context, String str, String str2, gk gkVar, cn cnVar, boolean z2, bg bgVar, iu iuVar) {
        f457 = (f456 + 75) % 128;
        awVar.m699(context, str, str2, gkVar, cnVar, z2, bgVar, iuVar);
        f457 = (f456 + 25) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m669(aw awVar, String str, JSONObject jSONObject) {
        int i2 = f456 + 81;
        f457 = i2 % 128;
        int i8 = i2 % 2;
        awVar.m670(str, jSONObject);
        if (i8 != 0) {
            throw null;
        }
        int i9 = f457 + 69;
        f456 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m687(aw awVar, cn cnVar) {
        JSONObject jSONObjectM697;
        int i2 = f456 + 75;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            jSONObjectM697 = m697(cnVar);
            int i8 = 46 / 0;
        } else {
            jSONObjectM697 = m697(cnVar);
        }
        f456 = (f457 + 63) % 128;
        return jSONObjectM697;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m703(aw awVar, Context context, String str, String str2, gk gkVar, iu iuVar) {
        f456 = (f457 + 35) % 128;
        awVar.m677(context, str, str2, gkVar, iuVar);
        int i2 = f456 + 45;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m709(ISAdQualityAdListener iSAdQualityAdListener) {
        f457 = (f456 + 5) % 128;
        this.f467.m849(iSAdQualityAdListener);
        f457 = (f456 + 87) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m690(aw awVar, Context context, String str, String str2, List list, iu iuVar) {
        int i2 = f457 + 35;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        awVar.m678(context, str, str2, (List<gk>) list, iuVar);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m704(aw awVar, Context context, String str, String str2, List list, iu iuVar) {
        f456 = (f457 + 27) % 128;
        awVar.m662(context, str, str2, (List<gk>) list, iuVar);
        int i2 = f456 + 81;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final synchronized void m707(final Context context, final Runnable runnable) {
        try {
            int i2 = f457 + 87;
            f456 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            if (!this.f478) {
                String strIntern = m675("鄣\ue9ce糢绊땒쿅楪Ἥ捍╣ደ\uf112", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 11).intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m658((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 61, (short) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 1233204606 - View.resolveSizeAndState(0, 0, 0), (byte) (24 - ExpandableListView.getPackedPositionChild(0L)), (-1390409732) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern());
                sb.append(IronSourceAdQuality.getSDKVersion());
                sb.append(m675("琂\ue854⨑暢⨑暢⨑暢⨑暢⨑暢⨑暢ꃸᤧ", View.MeasureSpec.getSize(0) + 15).intern());
                k.m2854(strIntern, sb.toString());
                iu iuVar = new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.9
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.9.3
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                runnable.run();
                            }
                        });
                        aw.m668(aw.this, context);
                    }
                };
                if (m647()) {
                    int i8 = f457 + 65;
                    f456 = i8 % 128;
                    if (i8 % 2 == 0) {
                        m676(context, iuVar);
                        int i9 = 66 / 0;
                    } else {
                        m676(context, iuVar);
                    }
                } else {
                    m698(context, iuVar);
                }
                this.f478 = true;
                return;
            }
            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.11
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    runnable.run();
                }
            });
            int i10 = f457 + 83;
            f456 = i10 % 128;
            if (i10 % 2 == 0) {
                throw null;
            }
            return;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final JSONObject m708() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            f457 = (f456 + 97) % 128;
            for (String str : new HashSet(m648().keySet())) {
                f456 = (f457 + 1) % 128;
                jSONObject2.put(str, m648().get(str));
            }
            jSONObject.put(m675("\uf72e⩙뼮\ue54d", Color.red(0) + 4).intern(), jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            k.m2861(m658(AndroidCharacter.getMirror('0') - 128, (short) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1233204641 - TextUtils.indexOf("", ""), (byte) ((-122) - (Process.myTid() >> 22)), (-1390409711) - (ViewConfiguration.getScrollBarSize() >> 8)).intern(), m658((-68) - ((byte) KeyEvent.getModifierMetaStateMask()), (short) Color.argb(0, 0, 0, 0), 1233204685 - TextUtils.indexOf((CharSequence) "", '0', 0), (byte) (92 - TextUtils.indexOf((CharSequence) "", '0', 0)), (Process.myTid() >> 22) - 1390409709).intern(), (Throwable) e);
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m691(aw awVar, Context context, Map map, Runnable runnable) {
        f456 = (f457 + 109) % 128;
        awVar.m701(context, map, runnable);
        int i2 = f456 + 23;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m700(Context context, final List<gk> list, final List<String> list2, final iu iuVar) {
        final Context context2;
        f457 = (f456 + 5) % 128;
        if (list.isEmpty()) {
            return;
        }
        gk gkVarRemove = list.remove(0);
        String strRemove = list2.remove(0);
        if (list.isEmpty()) {
            int i2 = f456 + 95;
            f457 = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
            context2 = context;
        } else {
            context2 = context;
            iu iuVar2 = new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.14
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    p.m2973(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.14.3
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            AnonymousClass14 anonymousClass14 = AnonymousClass14.this;
                            aw.m679(aw.this, context2, list, list2, iuVar);
                        }
                    }, aq.m530().mo534());
                }
            };
            f457 = (f456 + 17) % 128;
            iuVar = iuVar2;
        }
        m661(context2, gkVarRemove, strRemove, iuVar);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m661(final Context context, final gk gkVar, final String str, final iu iuVar) {
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.13
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                final String lowerCase = str.toLowerCase();
                aw.m673(aw.this).m760(lowerCase);
                p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.13.1

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static int f505 = 0;

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static char f506 = 41652;

                    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                    private static int f507 = 1;

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static char f508 = 62978;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static char f509 = 52973;

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static char f510 = 38670;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static String m713(String str2, int i2) {
                        String str3;
                        Object charArray = str2;
                        if (str2 != null) {
                            charArray = str2.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        synchronized (o.f2985) {
                            try {
                                char[] cArr2 = new char[cArr.length];
                                o.f2986 = 0;
                                char[] cArr3 = new char[2];
                                while (true) {
                                    int i8 = o.f2986;
                                    if (i8 < cArr.length) {
                                        cArr3[0] = cArr[i8];
                                        cArr3[1] = cArr[i8 + 1];
                                        int i9 = 58224;
                                        for (int i10 = 0; i10 < 16; i10++) {
                                            char c7 = cArr3[1];
                                            char c8 = cArr3[0];
                                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f509)) ^ ((c8 >>> 5) + f506)));
                                            cArr3[1] = c9;
                                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f510) ^ ((c9 + i9) ^ ((c9 << 4) + f508))));
                                            i9 -= 40503;
                                        }
                                        int i11 = o.f2986;
                                        cArr2[i11] = cArr3[0];
                                        cArr2[i11 + 1] = cArr3[1];
                                        o.f2986 = i11 + 2;
                                    } else {
                                        str3 = new String(cArr2, 0, i2);
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return str3;
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        String strIntern = m713("㹆鉌촣Ḷ욨哯팯엕깓㝄踠ꨠ㯆\uf75c\ueeb1\udca3", TextUtils.lastIndexOf("", '0', 0, 0) + 17).intern();
                        StringBuilder sb = new StringBuilder();
                        sb.append(m713("㱝\uf420荳蕦㠥㝰ꃵ쮏溞뢜ꎬ㡯\uf51fꊯ쁇ꮰ瘾◹昞瓄䦰豯ᐴ\udc2d", KeyEvent.normalizeMetaState(0) + 23).intern());
                        sb.append(lowerCase);
                        k.m2858(strIntern, sb.toString());
                        try {
                            AnonymousClass13 anonymousClass13 = AnonymousClass13.this;
                            aw.m703(aw.this, context, str, lowerCase, gkVar, iuVar);
                            int i2 = f507 + 107;
                            f505 = i2 % 128;
                            if (i2 % 2 != 0) {
                                throw null;
                            }
                        } catch (Throwable th) {
                            p.m2967(aw.m673(aw.this).new AnonymousClass4(lowerCase, ay.d.f647));
                            aw.m666(aw.this).put(str, kd.m2917(th).toString());
                            String strIntern2 = m713("㹆鉌촣Ḷ욨哯팯엕깓㝄踠ꨠ㯆\uf75c\ueeb1\udca3", TextUtils.getTrimmedLength("") + 16).intern();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(m713("篙\uef05纨辑屮輂踀뫈䋃扁ൽࢉꎬ㡯\uf51fꊯ쁇ꮰ瘾◹昞瓄䦰豯ᐴ\udc2d", View.getDefaultSize(0, 0) + 25).intern());
                            sb2.append(lowerCase);
                            kd.m2914(strIntern2, sb2.toString(), th, true, true, true);
                        }
                    }
                });
            }
        });
        f457 = (f456 + 71) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m692(aw awVar, String str) {
        f457 = (f456 + 115) % 128;
        boolean zM672 = awVar.m672(str);
        f457 = (f456 + 41) % 128;
        return zM672;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m660(final Context context) {
        int i2 = f456 + 49;
        f457 = i2 % 128;
        if (i2 % 2 == 0) {
            if (!m646()) {
                p.m2973(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.17
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.17.5
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                aw.m663(aw.this);
                            }
                        });
                    }
                }, aq.m530().mo540());
                f457 = (f456 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            }
            final Map<String, List<gk>> mapM866 = bc.m866();
            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.20
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    aw.m696(aw.this, aq.m530().mo557());
                    aw.m691(aw.this, context, mapM866, new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.20.5
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            if (aw.m653(aw.this)) {
                                aw.m663(aw.this);
                            }
                        }
                    });
                    aq.m530().mo559(new at() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.20.3

                        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                        private static int f527 = 1;

                        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                        private static int f528 = 0;

                        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                        private static short[] f529 = null;

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static int f530 = 317769424;

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static int f531 = 1789779435;

                        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                        private static byte[] f532 = {-19, -89, -104, -96, -115, -89, -82, 117, -99, -107, -85, -104, -111, -102, -103, -58, -3, -42, -40, -48, -26, -45, -52, -43, -44, -31, 24, -111, -44, -64, -26, -46, -32, -51, -54, -32, -48, -38, 30, -114, -50, -38, -46, -33, -42, -61, -33, -6};

                        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                        private static int f533 = 35;

                        @Override // com.ironsource.adqualitysdk.sdk.i.at
                        /* JADX INFO: renamed from: ﾇ */
                        public final void mo383() {
                            f528 = (f527 + 41) % 128;
                            aw.m696(aw.this, aq.m530().mo557());
                            k.m2858(m714(TextUtils.getCapsMode("", 0, 0) - 36, (short) (103 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ViewConfiguration.getScrollBarSize() >> 8) - 317769424, (byte) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), View.combineMeasuredStates(0, 0) - 1789779368).intern(), m714((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 37, (short) (TextUtils.getOffsetBefore("", 0) + 43), (-317769409) - TextUtils.lastIndexOf("", '0', 0, 0), (byte) (Process.myPid() >> 22), (-1789779367) - (ViewConfiguration.getLongPressTimeout() >> 16)).intern());
                            aw.m657(aw.this);
                            int i8 = f527 + 53;
                            f528 = i8 % 128;
                            if (i8 % 2 != 0) {
                                throw null;
                            }
                        }

                        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                        private static String m714(int i8, short s7, int i9, byte b8, int i10) {
                            String string;
                            synchronized (n.f2979) {
                                try {
                                    StringBuilder sb = new StringBuilder();
                                    int i11 = f533;
                                    int i12 = i8 + i11;
                                    int i13 = i12 == -1 ? 1 : 0;
                                    if (i13 != 0) {
                                        byte[] bArr = f532;
                                        if (bArr != null) {
                                            i12 = (byte) (bArr[f530 + i9] + i11);
                                        } else {
                                            i12 = (short) (f529[f530 + i9] + i11);
                                        }
                                    }
                                    if (i12 > 0) {
                                        n.f2984 = ((i9 + i12) - 2) + f530 + i13;
                                        n.f2982 = b8;
                                        char c7 = (char) (i10 + f531);
                                        n.f2981 = c7;
                                        sb.append(c7);
                                        n.f2980 = n.f2981;
                                        n.f2983 = 1;
                                        while (n.f2983 < i12) {
                                            byte[] bArr2 = f532;
                                            if (bArr2 != null) {
                                                int i14 = n.f2984;
                                                n.f2984 = i14 - 1;
                                                n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i14] + s7)) ^ n.f2982));
                                            } else {
                                                short[] sArr = f529;
                                                int i15 = n.f2984;
                                                n.f2984 = i15 - 1;
                                                n.f2981 = (char) (n.f2980 + (((short) (sArr[i15] + s7)) ^ n.f2982));
                                            }
                                            sb.append(n.f2981);
                                            n.f2980 = n.f2981;
                                            n.f2983++;
                                        }
                                    }
                                    string = sb.toString();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return string;
                        }
                    });
                }
            });
            return;
        }
        m646();
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m693(cn cnVar) {
        f456 = (f457 + 59) % 128;
        boolean zM664 = m664(cnVar);
        f457 = (f456 + 115) % 128;
        return zM664;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m694(cn cnVar, String str) {
        int i2 = f457 + 95;
        f456 = i2 % 128;
        int i8 = i2 % 2;
        boolean zM671 = m671(cnVar, str);
        if (i8 == 0) {
            int i9 = 51 / 0;
        }
        f456 = (f457 + 103) % 128;
        return zM671;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m689() {
        ArrayList<cn> arrayList = new ArrayList();
        for (cn cnVar : m656()) {
            if (m672(cnVar.m1666())) {
                f457 = (f456 + 103) % 128;
                arrayList.add(cnVar);
            }
        }
        f456 = (f457 + 37) % 128;
        for (final cn cnVar2 : arrayList) {
            String strIntern = m658((-80) - ExpandableListView.getPackedPositionGroup(0L), (short) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), 1233204641 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (byte) ((-123) - MotionEvent.axisFromString("")), (-1390409711) - (ViewConfiguration.getScrollBarSize() >> 8)).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m658((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 87, (short) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 1233204722 - View.MeasureSpec.makeMeasureSpec(0, 0), (byte) (TextUtils.lastIndexOf("", '0', 0, 0) + 21), (-1390409709) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern());
            sb.append(cnVar2.m1667());
            sb.append(m675("㐃魸\ue5f0伀四派徚书\uec3c笯", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 9).intern());
            k.m2854(strIntern, sb.toString());
            String strM1666 = cnVar2.m1666();
            m670(strM1666, m652().get(strM1666));
            p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.7
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    cnVar2.m1664();
                }
            });
            m654().remove(cnVar2);
        }
        f457 = (f456 + 11) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m698(Context context, iu iuVar) {
        f457 = (f456 + 29) % 128;
        m661(context, bc.m867(), bc.m868(), iuVar);
        f456 = (f457 + 35) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m676(Context context, iu iuVar) {
        m700(context, new ArrayList(bc.m860()), new ArrayList(bc.m863()), iuVar);
        int i2 = f457 + 37;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m659(List<gk> list) {
        int i2 = f457;
        f456 = (i2 + 3) % 128;
        if (list != null) {
            f456 = (i2 + 81) % 128;
            if (!list.isEmpty() && list.get(0) != null) {
                return list.get(0).mo2240();
            }
        }
        f456 = (f457 + 59) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m701(Context context, Map<String, List<gk>> map, Runnable runnable) {
        Context context2;
        Map<String, List<gk>> map2;
        Runnable runnable2;
        while (map != null) {
            int i2 = f456 + 49;
            f457 = i2 % 128;
            if (i2 % 2 != 0) {
                map.size();
                throw null;
            }
            if (map.size() <= 0) {
                break;
            }
            String next = map.keySet().iterator().next();
            List<gk> listRemove = map.remove(next);
            String strM659 = m659(listRemove);
            if (strM659 != null) {
                this.f474.m760(strM659);
                context2 = context;
                map2 = map;
                runnable2 = runnable;
                p.m2969(new AnonymousClass1(strM659, context2, next, listRemove, map2, runnable2));
                if (m646()) {
                    f457 = (f456 + 55) % 128;
                    return;
                }
            } else {
                context2 = context;
                map2 = map;
                runnable2 = runnable;
            }
            context = context2;
            map = map2;
            runnable = runnable2;
        }
        final Runnable runnable3 = runnable;
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                p.m2969(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.2.2
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        runnable3.run();
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m678(final Context context, final String str, final String str2, final List<gk> list, final iu iuVar) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.5

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static int f556 = 42;

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static int f557 = 0;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f558 = 1;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static String m721(int i2, int i8, String str3, int i9, boolean z2) {
                String str4;
                Object charArray = str3;
                if (str3 != null) {
                    charArray = str3.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (e.f1927) {
                    try {
                        char[] cArr2 = new char[i8];
                        e.f1926 = 0;
                        while (true) {
                            int i10 = e.f1926;
                            if (i10 >= i8) {
                                break;
                            }
                            e.f1929 = cArr[i10];
                            cArr2[e.f1926] = (char) (e.f1929 + i2);
                            int i11 = e.f1926;
                            cArr2[i11] = (char) (cArr2[i11] - f556);
                            e.f1926 = i11 + 1;
                        }
                        if (i9 > 0) {
                            e.f1928 = i9;
                            char[] cArr3 = new char[i8];
                            System.arraycopy(cArr2, 0, cArr3, 0, i8);
                            int i12 = e.f1928;
                            System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                            int i13 = e.f1928;
                            System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                        }
                        if (z2) {
                            char[] cArr4 = new char[i8];
                            e.f1926 = 0;
                            while (true) {
                                int i14 = e.f1926;
                                if (i14 >= i8) {
                                    break;
                                }
                                cArr4[i14] = cArr2[(i8 - i14) - 1];
                                e.f1926 = i14 + 1;
                            }
                            cArr2 = cArr4;
                        }
                        str4 = new String(cArr2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str4;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                String strIntern = m721(TextUtils.lastIndexOf("", '0', 0) + 145, 16 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), "\ufffb\uffe7\f\t\u000e�\uffff\b\b\t\uffdd\f\uffff\u0001\ufffb\b", 11 - (ViewConfiguration.getTouchSlop() >> 8), true).intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m721((Process.myTid() >> 22) + 141, ((byte) KeyEvent.getModifierMetaStateMask()) + 24, "\u0000\u0011\f\u000fﾽ￦\u000b\u0006\u0011\u0006\ufffe\t\u0006\u0017\u0006\u000b\u0004ﾽ\u0000\f\u000b\u000b\u0002", 5 - (ViewConfiguration.getScrollDefaultDelay() >> 16), false).intern());
                sb.append(str2);
                k.m2858(strIntern, sb.toString());
                try {
                    aw.m704(aw.this, context, str, str2, list, iuVar);
                } catch (Throwable th) {
                    if (aw.m673(aw.this) != null) {
                        p.m2967(aw.m673(aw.this).new AnonymousClass4(str2, ay.d.f647));
                    }
                    aw.m666(aw.this).put(str, kd.m2917(th).toString());
                    String strIntern2 = m721(View.getDefaultSize(0, 0) + 144, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 16, "\ufffb\uffe7\f\t\u000e�\uffff\b\b\t\uffdd\f\uffff\u0001\ufffb\b", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 11, true).intern();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(m721(139 - View.MeasureSpec.getMode(0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 25, "\b\r\u0006\uffbf\u0002\u000e\r\r\u0004\u0002\u0013\u000e\u0011\uffbf￤\u0011\u0011\u000e\u0011\uffbf\u0002\u0011\u0004\u0000\u0013", 14 - View.getDefaultSize(0, 0), false).intern());
                    sb2.append(str2);
                    kd.m2914(strIntern2, sb2.toString(), th, true, true, true);
                    f558 = (f557 + 49) % 128;
                }
            }
        });
        int i2 = f457 + 5;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 84 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m681(final cn cnVar, final String str) {
        final String strM1666 = cnVar.m1666();
        p.m2967(this.f474.new AnonymousClass5(strM1666, ay.a.f632));
        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.4

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static int f540 = 1;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f543;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int[] f544 = {1485007659, 1939020960, -941006970, 462896707, -176291680, 722120486, -1150809040, 1207154011, -1179993113, -1947524827, 1439808645, 1005327270, -1677653051, 464390205, -1172409733, -453430271, 1892063542, 2063000275};

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static char f541 = 6;

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static char[] f542 = {'D', 'I', 'S', 'A', 'B', 'L', 'E', 'C', 'o', 'n', 'e', 'c', 't', 'r', 'M', 'a', 'g', ' ', 'i', 's', 'd', 'b', 'l', 'K', 'v', 'y', 'u', 'p', 'h', 'F', 'G', 'H', 'J', 'N', 'O', 'P'};

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static String m718(int i2, byte b8, String str2) {
                String str3;
                Object charArray = str2;
                if (str2 != null) {
                    charArray = str2.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (h.f2264) {
                    try {
                        char[] cArr2 = f542;
                        char c7 = f541;
                        char[] cArr3 = new char[i2];
                        if (i2 % 2 != 0) {
                            i2--;
                            cArr3[i2] = (char) (cArr[i2] - b8);
                        }
                        if (i2 > 1) {
                            h.f2267 = 0;
                            while (true) {
                                int i8 = h.f2267;
                                if (i8 >= i2) {
                                    break;
                                }
                                h.f2269 = cArr[i8];
                                h.f2268 = cArr[h.f2267 + 1];
                                if (h.f2269 == h.f2268) {
                                    cArr3[h.f2267] = (char) (h.f2269 - b8);
                                    cArr3[h.f2267 + 1] = (char) (h.f2268 - b8);
                                } else {
                                    h.f2266 = h.f2269 / c7;
                                    h.f2263 = h.f2269 % c7;
                                    h.f2265 = h.f2268 / c7;
                                    h.f2262 = h.f2268 % c7;
                                    if (h.f2263 == h.f2262) {
                                        h.f2266 = androidx.camera.core.processing.util.a.C(h.f2266, c7, 1, c7);
                                        h.f2265 = androidx.camera.core.processing.util.a.C(h.f2265, c7, 1, c7);
                                        int i9 = (h.f2266 * c7) + h.f2263;
                                        int i10 = (h.f2265 * c7) + h.f2262;
                                        int i11 = h.f2267;
                                        cArr3[i11] = cArr2[i9];
                                        cArr3[i11 + 1] = cArr2[i10];
                                    } else if (h.f2266 == h.f2265) {
                                        h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                        h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                        int i12 = (h.f2266 * c7) + h.f2263;
                                        int i13 = (h.f2265 * c7) + h.f2262;
                                        int i14 = h.f2267;
                                        cArr3[i14] = cArr2[i12];
                                        cArr3[i14 + 1] = cArr2[i13];
                                    } else {
                                        int i15 = (h.f2266 * c7) + h.f2262;
                                        int i16 = (h.f2265 * c7) + h.f2263;
                                        int i17 = h.f2267;
                                        cArr3[i17] = cArr2[i15];
                                        cArr3[i17 + 1] = cArr2[i16];
                                    }
                                }
                                h.f2267 += 2;
                            }
                        }
                        str3 = new String(cArr3);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str3;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() throws Exception {
                f540 = (f543 + 37) % 128;
                JSONObject jSONObjectM687 = aw.m687(aw.this, cnVar);
                jSONObjectM687.put(m717(new int[]{80787808, 87933237}, 2 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern(), true);
                aw.m649(aw.this).put(cnVar.m1666(), jSONObjectM687);
                String strM1661 = cnVar.m1661();
                if (m718(8 - Color.alpha(0), (byte) (TextUtils.getTrimmedLength("") + 19), "\u0001\u0002\u0003\u0004\u0005\u0000\f\u0006").intern().equals(strM1661)) {
                    String strIntern = m718(15 - TextUtils.lastIndexOf("", '0', 0), (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), "\b\tää\u000b\u0006\u000e\u0006\u000e\u000f\u0015\u000f\u0010\u0011\u0007\u0010").intern();
                    StringBuilder sb = new StringBuilder();
                    sb.append(cnVar.m1667());
                    sb.append(m718(TextUtils.lastIndexOf("", '0') + 23, (byte) (54 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), "\u0017\u0011\t\n\n\u000b\u0006\u0011\u0007\u000e\f\u0017\u0017\r\u0015\u0013\u0015\r\u0016\u0017\b\u0016").intern());
                    k.m2858(strIntern, sb.toString());
                    p.m2967(aw.m673(aw.this).new AnonymousClass5(strM1666, ay.a.f634));
                } else if (aw.m692(aw.this, strM1666)) {
                    String strIntern2 = m718(TextUtils.indexOf("", "", 0) + 16, (byte) (118 - Color.alpha(0)), "\b\tää\u000b\u0006\u000e\u0006\u000e\u000f\u0015\u000f\u0010\u0011\u0007\u0010").intern();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cnVar.m1667());
                    sb2.append(m717(new int[]{-340634122, -1610354385, 2033189240, -804002619, -1701060329, 1992396819, -1451711041, -292552502, 902928751, 1944657189, 1393282767, -245956943, -765915568, -227416314, -1760402196, -733046947, -787668847, 852229423, 2090431582, -187378673}, Color.blue(0) + 39).intern());
                    k.m2858(strIntern2, sb2.toString());
                    p.m2967(aw.m673(aw.this).new AnonymousClass5(strM1666, ay.a.f634));
                    jSONObjectM687.put(m718((ViewConfiguration.getTouchSlop() >> 8) + 3, (byte) ((ViewConfiguration.getPressedStateDuration() >> 16) + 93), "\u0017\bÐ").intern(), true);
                    f540 = (f543 + 23) % 128;
                } else if (aw.m694(cnVar, strM1661)) {
                    p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.4.4

                        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                        private static int f549 = 1;

                        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                        private static int f550 = 0;

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static char f551 = 60476;

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static char f552 = 56619;

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static char f553 = 16348;

                        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                        private static char f554 = 22819;

                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            cnVar.m1665();
                            p.m2967(aw.m673(aw.this).new AnonymousClass5(strM1666, ay.a.f635));
                            String strIntern3 = m720("㧦\uef13\ud91bⓌ⨐軠끂쨸\udac8篤\ua4c8麙ه戻㠬᷒", Process.getGidForName("") + 17).intern();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(cnVar.m1667());
                            sb3.append(m720("醈콩묣쿆줐Ꝓ纣누䩜ঠ슦鶬ྯ㈠秴㘹ﴜ犳諣ꦀ招㮂꣐\uf6b1૽䢙삮荠톗\uea1c웍櫓츦涜瀽뎠", View.resolveSize(0, 0) + 35).intern());
                            k.m2858(strIntern3, sb3.toString());
                            int i2 = f550 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
                            f549 = i2 % 128;
                            if (i2 % 2 == 0) {
                                throw null;
                            }
                        }

                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﾒ */
                        public final void mo719(Throwable th) {
                            try {
                                ((JSONObject) aw.m649(aw.this).get(cnVar.m1666())).put(m720("૽䢙삮荠", 5 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern(), false);
                                f550 = (f549 + 3) % 128;
                            } catch (JSONException e) {
                                k.m2861(m720("㧦\uef13\ud91bⓌ⨐軠끂쨸\udac8篤\ua4c8麙ه戻㠬᷒", MotionEvent.axisFromString("") + 17).intern(), m720("ഔ緻̏栾\uefc3盓\u2458后ⱟ퍊૽䢙\ue806ꌍ૽䢙삮荠\uf846퐾ēﲓ藻賎\ud91bⓌ⨐軠끂쨸\uefc3盓瘤\uedc5淺內੦蝾\ue5a3⣄⑇娣묣쿆", (ViewConfiguration.getTapTimeout() >> 16) + 44).intern(), (Throwable) e);
                            }
                            p.m2967(aw.m673(aw.this).new AnonymousClass4(strM1666, ay.d.f645));
                            String strIntern3 = m720("㧦\uef13\ud91bⓌ⨐軠끂쨸\udac8篤\ua4c8麙ه戻㠬᷒", 16 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(m720("ഔ緻̏栾\uefc3盓૽䢙삮荠톗\uea1c웍櫓쾯ᇔ㷮攙\udade謮", 18 - Process.getGidForName("")).intern());
                            sb3.append(cnVar.m1667());
                            kd.m2914(strIntern3, com.google.android.gms.ads.internal.client.a.z(sb3, m720("醈콩묣쿆줐Ꝓ纣누䩜ঠ", Color.red(0) + 10)), th, true, true, true);
                            String strIntern4 = m720("뽰\uf1dd⤰鸽鶃澔삮荠㈷膿餶㬢", 12 - KeyEvent.keyCodeFromString("")).intern();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(m720("騋珞鶚液蘋境䩜ঠ⽄꒲Ĩ◰\u0ee7ק뗸\uf428扇ᖢ螁㩂鴠ﲿ᳝逑૽䢙삮荠톗\uea1c웍櫓쾯ᇔ㷮攙粔孬殐㓏찟㯠䰇笏웍櫓쬃걘딍뢮餶㬢\udade謮", TextUtils.getOffsetBefore("", 0) + 53).intern());
                            sb4.append(cnVar.m1667());
                            sb4.append(m720("醈콩묣쿆줐Ꝓ纣누䩜ঠ珳鷬", 11 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern());
                            k.m2868(strIntern4, sb4.toString());
                            f550 = (f549 + 69) % 128;
                        }

                        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                        private static String m720(String str2, int i2) {
                            String str3;
                            Object charArray = str2;
                            if (str2 != null) {
                                charArray = str2.toCharArray();
                            }
                            char[] cArr = (char[]) charArray;
                            synchronized (o.f2985) {
                                try {
                                    char[] cArr2 = new char[cArr.length];
                                    o.f2986 = 0;
                                    char[] cArr3 = new char[2];
                                    while (true) {
                                        int i8 = o.f2986;
                                        if (i8 < cArr.length) {
                                            cArr3[0] = cArr[i8];
                                            cArr3[1] = cArr[i8 + 1];
                                            int i9 = 58224;
                                            for (int i10 = 0; i10 < 16; i10++) {
                                                char c7 = cArr3[1];
                                                char c8 = cArr3[0];
                                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f552)) ^ ((c8 >>> 5) + f551)));
                                                cArr3[1] = c9;
                                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f553) ^ ((c9 + i9) ^ ((c9 << 4) + f554))));
                                                i9 -= 40503;
                                            }
                                            int i11 = o.f2986;
                                            cArr2[i11] = cArr3[0];
                                            cArr2[i11 + 1] = cArr3[1];
                                            o.f2986 = i11 + 2;
                                        } else {
                                            str3 = new String(cArr2, 0, i2);
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return str3;
                        }
                    });
                    aw.m695(aw.this).add(cnVar);
                } else {
                    jSONObjectM687.put(m717(new int[]{-119623801, 1060626872}, 3 - TextUtils.indexOf("", "", 0, 0)).intern(), false);
                    p.m2967(aw.m673(aw.this).new AnonymousClass4(strM1666, ay.d.f646));
                    String strIntern3 = m718(16 - Color.green(0), (byte) (117 - ((byte) KeyEvent.getModifierMetaStateMask())), "\b\tää\u000b\u0006\u000e\u0006\u000e\u000f\u0015\u000f\u0010\u0011\u0007\u0010").intern();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    kd.m2914(strIntern3, com.google.android.gms.ads.internal.client.a.z(sb3, m717(new int[]{137862923, -805221656, 514945754, -660136246, -1626064643, -2139873346, 1167795931, -327042994, 1587709015, 916932184}, View.MeasureSpec.getMode(0) + 19)), (Throwable) null, true, true, true);
                    ISAdQualityInitListener iSAdQualityInitListenerM712 = aw.this.m712();
                    ISAdQualityInitError iSAdQualityInitError = ISAdQualityInitError.AD_NETWORK_VERSION_NOT_SUPPORTED_YET;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(cnVar.m1667());
                    sb4.append(m718(14 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (byte) (105 - TextUtils.getTrimmedLength("")), "\u000e\u0005\u0005\u0012\f\u001d\u0007\u0010\u0014\u0013\t\n\u0089").intern());
                    sb4.append(cnVar.m1661());
                    sb4.append(m718((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 37, (byte) (15 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), "\f\u0017\u0017\r\n\t\r\f\u001c\u0007\r\f\u0014\u0019\u0080\u0080\u0007\u000e\u0010\u0006\u0017\u000e\u0013\u001b\f\r\"\u0010\u0017\u0011\t\n\n\u000b\u0006\u0011\u0007\u000e").intern());
                    iSAdQualityInitListenerM712.adQualitySdkInitFailed(iSAdQualityInitError, sb4.toString());
                }
                jSONObjectM687.remove(m717(new int[]{80787808, 87933237}, 2 - ExpandableListView.getPackedPositionType(0L)).intern());
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo719(Throwable th) {
                p.m2967(aw.m673(aw.this).new AnonymousClass4(strM1666, ay.d.f642));
                String strIntern = m718(16 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) (118 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), "\b\tää\u000b\u0006\u000e\u0006\u000e\u000f\u0015\u000f\u0010\u0011\u0007\u0010").intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m717(new int[]{-1744323945, -1073580132, -1215931352, -1406414483, 703855415, -654569506, -1208946028, 607438862, -926425136, -1677657355, 1042846384, 1752331145, -365084195, 530846172, -1546405924, 1312900211}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 30).intern());
                sb.append(strM1666);
                kd.m2914(strIntern, sb.toString(), th, true, true, true);
                int i2 = f543 + 13;
                f540 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static String m717(int[] iArr, int i2) {
                String str2;
                synchronized (d.f1664) {
                    try {
                        char[] cArr = new char[4];
                        char[] cArr2 = new char[iArr.length << 1];
                        int[] iArr2 = (int[]) f544.clone();
                        d.f1665 = 0;
                        while (true) {
                            int i8 = d.f1665;
                            if (i8 < iArr.length) {
                                int i9 = iArr[i8];
                                char c7 = (char) (i9 >> 16);
                                cArr[0] = c7;
                                char c8 = (char) i9;
                                cArr[1] = c8;
                                char c9 = (char) (iArr[i8 + 1] >> 16);
                                cArr[2] = c9;
                                char c10 = (char) iArr[i8 + 1];
                                cArr[3] = c10;
                                d.f1663 = (c7 << 16) + c8;
                                d.f1666 = (c9 << 16) + c10;
                                d.m1895(iArr2);
                                for (int i10 = 0; i10 < 16; i10++) {
                                    int i11 = d.f1663 ^ iArr2[i10];
                                    d.f1663 = i11;
                                    int iM1894 = d.m1894(i11) ^ d.f1666;
                                    int i12 = d.f1663;
                                    d.f1663 = iM1894;
                                    d.f1666 = i12;
                                }
                                int i13 = d.f1663;
                                int i14 = d.f1666;
                                d.f1663 = i14;
                                d.f1666 = i13;
                                int i15 = i13 ^ iArr2[16];
                                d.f1666 = i15;
                                int i16 = i14 ^ iArr2[17];
                                d.f1663 = i16;
                                cArr[0] = (char) (i16 >>> 16);
                                cArr[1] = (char) i16;
                                cArr[2] = (char) (i15 >>> 16);
                                cArr[3] = (char) i15;
                                d.m1895(iArr2);
                                int i17 = d.f1665;
                                cArr2[i17 << 1] = cArr[0];
                                cArr2[(i17 << 1) + 1] = cArr[1];
                                cArr2[(i17 << 1) + 2] = cArr[2];
                                cArr2[(i17 << 1) + 3] = cArr[3];
                                d.f1665 = i17 + 2;
                            } else {
                                str2 = new String(cArr2, 0, i2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        });
        f456 = (f457 + 61) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m662(Context context, String str, String str2, List<gk> list, iu iuVar) {
        int i2 = f457 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f456 = i2 % 128;
        if (i2 % 2 != 0) {
            Iterator<gk> it = list.iterator();
            while (it.hasNext()) {
                f457 = (f456 + 95) % 128;
                m677(context, str, str2, it.next(), iuVar);
            }
            return;
        }
        list.iterator();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final JSONObject m706() {
        f457 = (f456 + 5) % 128;
        try {
            JSONObject jSONObjectM667 = m667(m652());
            f456 = (f457 + 33) % 128;
            return jSONObjectM667;
        } catch (JSONException e) {
            k.m2861(m658((-80) - ExpandableListView.getPackedPositionType(0L), (short) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), View.getDefaultSize(0, 0) + 1233204641, (byte) ((-122) - KeyEvent.getDeadChar(0, 0)), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1390409712).intern(), m658(TextUtils.lastIndexOf("", '0', 0, 0) - 64, (short) ((-1) - MotionEvent.axisFromString("")), 1233204656 - TextUtils.getOffsetAfter("", 0), (byte) (TextUtils.indexOf("", "") - 84), TextUtils.lastIndexOf("", '0', 0, 0) - 1390409708).intern(), (Throwable) e);
            return new JSONObject();
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private long m683(ja.d dVar) {
        int i2 = f456 + 97;
        f457 = i2 % 128;
        if (i2 % 2 == 0) {
            if (aq.m530().mo556()) {
                int i8 = f457 + 67;
                f456 = i8 % 128;
                if (i8 % 2 == 0) {
                    int i9 = 93 / 0;
                }
                return 2000L;
            }
            if (dVar == null) {
                return 0L;
            }
            int i10 = f456 + 9;
            f457 = i10 % 128;
            if (i10 % 2 != 0) {
                this.f469.m2587(dVar);
                throw null;
            }
            if (this.f469.m2587(dVar)) {
                return 0L;
            }
            f457 = (f456 + 111) % 128;
            return 2000L;
        }
        aq.m530().mo556();
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m677(final Context context, final String str, final String str2, final gk gkVar, final iu iuVar) {
        f456 = (f457 + 115) % 128;
        ja.d dVarM2262 = gkVar.m2262();
        if (dVarM2262 == null) {
            p.m2963(iuVar);
            return;
        }
        final bg bgVarMo2242 = gkVar.mo2242();
        m682(str2, bgVarMo2242);
        p.m2967(this.f474.new AnonymousClass5(str2, ay.a.f633));
        final String strM2588 = this.f469.m2588(dVarM2262, new il() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.8
            @Override // com.ironsource.adqualitysdk.sdk.i.il
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final void mo724(String str3) {
                aw.m702(aw.this, context, str, str2, gkVar, aw.m684(aw.this, context, str3, bgVarMo2242), false, bgVarMo2242, iuVar);
            }
        });
        p.m2973(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.10
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                cn cnVarM684 = aw.m684(aw.this, context, strM2588, bgVarMo2242);
                if (cnVarM684 != null) {
                    aw.m702(aw.this, context, str, str2, gkVar, cnVarM684, true, bgVarMo2242, iuVar);
                } else {
                    p.m2963(iuVar);
                }
            }
        }, m683(dVarM2262));
        int i2 = f457 + 99;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 84 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean m664(cn cnVar) {
        String strM1662 = cnVar.m1662();
        if (strM1662 != null) {
            int i2 = f456 + 97;
            f457 = i2 % 128;
            if (i2 % 2 != 0) {
                ka.m2874(IronSourceAdQuality.getSDKVersion(), strM1662);
                throw null;
            }
            if (ka.m2874(IronSourceAdQuality.getSDKVersion(), strM1662) < 0) {
                return false;
            }
        }
        f456 = (f457 + 19) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m670(String str, JSONObject jSONObject) {
        p.m2967(this.f474.new AnonymousClass5(str, ay.a.f634));
        if (jSONObject != null) {
            f457 = (f456 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            try {
                jSONObject.put(m658((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 93, (short) KeyEvent.keyCodeFromString(""), Color.argb(0, 0, 0, 0) + 1233204714, (byte) ((-83) - View.resolveSize(0, 0)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 1390409678).intern(), true);
                f456 = (f457 + 1) % 128;
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m658(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f462;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f458;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f460 + i8] + i10);
                    } else {
                        i11 = (short) (f459[f460 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f460 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f464);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f458;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f459;
                            int i14 = n.f2984;
                            n.f2984 = i14 - 1;
                            n.f2981 = (char) (n.f2980 + (((short) (sArr[i14] + s7)) ^ n.f2982));
                        }
                        sb.append(n.f2981);
                        n.f2980 = n.f2981;
                        n.f2983++;
                    }
                }
                string = sb.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m699(final Context context, final String str, final String str2, final gk gkVar, final cn cnVar, final boolean z2, final bg bgVar, final iu iuVar) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.6

            /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
            private static char f565 = 5;

            /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
            private static int f566 = 0;

            /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
            private static int f567 = 1;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static char[] f568 = {'C', 'o', 'n', 'e', 'c', 't', 'r', 'M', 'a', 'g', 'I', 'i', 'l', 'z', ' ', 'm', '(', 'h', 'd', ')', 'f', 'D', 'E', 'F', 'G'};

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static String m722(int i2, byte b8, String str3) {
                String str4;
                Object charArray = str3;
                if (str3 != null) {
                    charArray = str3.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (h.f2264) {
                    try {
                        char[] cArr2 = f568;
                        char c7 = f565;
                        char[] cArr3 = new char[i2];
                        if (i2 % 2 != 0) {
                            i2--;
                            cArr3[i2] = (char) (cArr[i2] - b8);
                        }
                        if (i2 > 1) {
                            h.f2267 = 0;
                            while (true) {
                                int i8 = h.f2267;
                                if (i8 >= i2) {
                                    break;
                                }
                                h.f2269 = cArr[i8];
                                h.f2268 = cArr[h.f2267 + 1];
                                if (h.f2269 == h.f2268) {
                                    cArr3[h.f2267] = (char) (h.f2269 - b8);
                                    cArr3[h.f2267 + 1] = (char) (h.f2268 - b8);
                                } else {
                                    h.f2266 = h.f2269 / c7;
                                    h.f2263 = h.f2269 % c7;
                                    h.f2265 = h.f2268 / c7;
                                    h.f2262 = h.f2268 % c7;
                                    if (h.f2263 == h.f2262) {
                                        h.f2266 = androidx.camera.core.processing.util.a.C(h.f2266, c7, 1, c7);
                                        h.f2265 = androidx.camera.core.processing.util.a.C(h.f2265, c7, 1, c7);
                                        int i9 = (h.f2266 * c7) + h.f2263;
                                        int i10 = (h.f2265 * c7) + h.f2262;
                                        int i11 = h.f2267;
                                        cArr3[i11] = cArr2[i9];
                                        cArr3[i11 + 1] = cArr2[i10];
                                    } else if (h.f2266 == h.f2265) {
                                        h.f2263 = androidx.camera.core.processing.util.a.C(h.f2263, c7, 1, c7);
                                        h.f2262 = androidx.camera.core.processing.util.a.C(h.f2262, c7, 1, c7);
                                        int i12 = (h.f2266 * c7) + h.f2263;
                                        int i13 = (h.f2265 * c7) + h.f2262;
                                        int i14 = h.f2267;
                                        cArr3[i14] = cArr2[i12];
                                        cArr3[i14 + 1] = cArr2[i13];
                                    } else {
                                        int i15 = (h.f2266 * c7) + h.f2262;
                                        int i16 = (h.f2265 * c7) + h.f2263;
                                        int i17 = h.f2267;
                                        cArr3[i17] = cArr2[i15];
                                        cArr3[i17 + 1] = cArr2[i16];
                                    }
                                }
                                h.f2267 += 2;
                            }
                        }
                        str4 = new String(cArr3);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str4;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                iu iuVar2;
                iu iuVar3;
                if (cnVar == null || aw.m655(aw.this).contains(gkVar)) {
                    return;
                }
                p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.az.2

                    /* JADX INFO: renamed from: ｋ */
                    private /* synthetic */ cn f653;

                    /* JADX INFO: renamed from: ﾇ */
                    private /* synthetic */ boolean f654;

                    /* JADX INFO: renamed from: ﾒ */
                    private /* synthetic */ String f655;

                    public AnonymousClass2(String str3, cn cnVar2, boolean z7) {
                        str = str3;
                        cnVar = cnVar2;
                        z = z7;
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        ay ayVarM757 = az.m757(az.this, str);
                        if (ayVarM757 != null) {
                            ayVarM757.m747(cnVar);
                        }
                    }
                });
                if (!cnVar.m1656() && (iuVar3 = iuVar) != null) {
                    p.m2963(iuVar3);
                }
                if (!aw.m693(cnVar)) {
                    p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aw.6.1

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static long f578 = -6346004179913980196L;

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static int f579 = 0;

                        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                        private static int f580 = 1;

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static String m723(String str3, int i2) {
                            String str4;
                            Object charArray = str3;
                            if (str3 != null) {
                                charArray = str3.toCharArray();
                            }
                            char[] cArr = (char[]) charArray;
                            synchronized (i.f2441) {
                                try {
                                    char[] cArrM2497 = i.m2497(f578, cArr, i2);
                                    i.f2442 = 4;
                                    while (true) {
                                        int i8 = i.f2442;
                                        if (i8 < cArrM2497.length) {
                                            i.f2443 = i8 - 4;
                                            cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f578));
                                            i.f2442 = i8 + 1;
                                        } else {
                                            str4 = new String(cArrM2497, 4, cArrM2497.length - 4);
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return str4;
                        }

                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            f579 = (f580 + 115) % 128;
                            if (aw.m666(aw.this).containsKey(cnVar.m1666())) {
                                return;
                            }
                            p.m2967(aw.m673(aw.this).new AnonymousClass4(cnVar.m1666(), ay.d.f648));
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            JSONObject jSONObjectM687 = aw.m687(aw.this, cnVar);
                            try {
                                jSONObjectM687.put(m723("\uea0a즩\uea6b較䌄컏샆", 1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), false);
                            } catch (JSONException unused) {
                            }
                            aw.m649(aw.this).put(cnVar.m1666(), jSONObjectM687);
                            String strM759 = aw.m673(aw.this).m759(cnVar.m1666());
                            aw.m666(aw.this).put(cnVar.m1666(), strM759);
                            ISAdQualityInitListener iSAdQualityInitListenerM712 = aw.this.m712();
                            ISAdQualityInitError iSAdQualityInitError = ISAdQualityInitError.AD_NETWORK_SDK_REQUIRES_NEWER_AD_QUALITY_SDK;
                            StringBuilder sb = new StringBuilder();
                            sb.append(cnVar.m1667());
                            sb.append(m723("\ud9af珙\ud98f㕶쀭䷱䫠싿鸟ᇣ\ue4bc湩\uef3cฌ褆锅诟", TextUtils.indexOf("", "")).intern());
                            sb.append(cnVar.m1661());
                            sb.append(m723("᳧墷᳇ḙ\ue450榍ᠫߢ쳎㪒샗㲯⩴┫굆쟕付쇶觩\uea4b焇\uec58銑軱闷裍缀酸렴뎢宺떔\udcd7", (-1) - TextUtils.indexOf((CharSequence) "", '0')).intern());
                            sb.append(cnVar.m1662());
                            sb.append(m723("林컊倫衹除ᮮ\uf260\ue2ea⛔곣닱횵콦", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern());
                            iSAdQualityInitListenerM712.adQualitySdkInitFailed(iSAdQualityInitError, sb.toString());
                            kd.m2914(m723("꼓▿꽐挌Ῑ鈏ﳗ됆⠭䞐㭓\ud846馁塎囶⌷ﴢ보牢ົ", Color.red(0)).intern(), strM759, (Throwable) null, true, true, true);
                            f580 = (f579 + 65) % 128;
                        }
                    });
                    return;
                }
                String strIntern = m722((ViewConfiguration.getPressedStateDuration() >> 16) + 16, (byte) (Drawable.resolveOpacity(0, 0) + 90), "\u0001\u0002ÈÈ\u0004\u0000\u0006\u0000\u0007\b\u0007\u0003\t\u0005\u0001\b").intern();
                StringBuilder sb = new StringBuilder();
                sb.append(m722(12 - TextUtils.indexOf((CharSequence) "", '0'), (byte) (KeyEvent.keyCodeFromString("") + 10), "\f\u0000\n\u0006\r\u0006\r\f\u000e\f\u0004\u0007*").intern());
                sb.append(str);
                sb.append(m722((ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (byte) (125 - MotionEvent.axisFromString("")), "\u000b\t\u0000\u0012\u0000\u0006\u0004\r\u0000\u0002ìì\u0004\u0000\u0006\u0000\t\u000b").intern());
                sb.append((z2 ? m722(TextUtils.lastIndexOf("", '0', 0, 0) + 9, (byte) (KeyEvent.normalizeMetaState(0) + 79), "\u0013\u0001\t\u0003\u0012\u0002\u0013\u000f") : m722((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 8, (byte) (7 - ExpandableListView.getPackedPositionGroup(0L)), "\u000f\u0015\u0000\b\u0002\u0013\b\u00170")).intern());
                co.m1672(strIntern, sb.toString());
                bgVar.m887();
                if (cnVar.m1656() && (iuVar2 = iuVar) != null) {
                    int i2 = f566 + 7;
                    f567 = i2 % 128;
                    if (i2 % 2 == 0) {
                        p.m2963(iuVar2);
                        throw null;
                    }
                    p.m2963(iuVar2);
                }
                if (q.m3013().m3031()) {
                    return;
                }
                f566 = (f567 + 5) % 128;
                aw.m680(aw.this, cnVar, str);
                if (aw.m692(aw.this, cnVar.m1666())) {
                    return;
                }
                aw.m655(aw.this).add(gkVar);
            }
        });
        int i2 = f456 + 57;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static JSONObject m697(cn cnVar) {
        f457 = (f456 + 27) % 128;
        JSONObject jSONObjectM688 = m688(cnVar.m1661());
        try {
            jSONObjectM688.put(ig.f2480, cnVar.m1669());
            f456 = (f457 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        } catch (JSONException e) {
            k.m2861(m658(View.getDefaultSize(0, 0) - 80, (short) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0') + 1233204642, (byte) ((-122) - (Process.myPid() >> 22)), (-1390409710) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), m675("뢐\ue86e넯漂ℜᘌ䵒쨥ᮮ覝ꈆ\uf1df볇۾㐃魸\ue5f0伀四派徚书\uec3c笯٘\u2e70\uf72e⩙ḭ̃\ue5f0伀뱁\u0ee5쇴却枱۰", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 36).intern(), (Throwable) e);
        }
        int i2 = f456 + 17;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 17 / 0;
        }
        return jSONObjectM688;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static JSONObject m688(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ig.f2481, str);
        } catch (JSONException e) {
            k.m2861(m658((-80) - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (short) (TextUtils.lastIndexOf("", '0', 0) + 1), TextUtils.indexOf((CharSequence) "", '0', 0) + 1233204642, (byte) (TextUtils.getOffsetBefore("", 0) - 122), (-1390409711) - TextUtils.indexOf("", "")).intern(), m675("뢐\ue86e넯漂ℜᘌ䵒쨥ᮮ覝ꈆ\uf1df볇۾㐃魸\ue5f0伀四派徚书\uec3c笯٘\u2e70\uf72e⩙ḭ̃\ue5f0伀뱁\u0ee5쇴却枱۰", 36 - ((byte) KeyEvent.getModifierMetaStateMask())).intern(), (Throwable) e);
        }
        f457 = (f456 + 11) % 128;
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean m671(cn cnVar, String str) {
        if (m658((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 89, (short) View.MeasureSpec.makeMeasureSpec(0, 0), 1233204716 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) - 16), (-1390409709) - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern().equals(str)) {
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            int i2 = f456 + 43;
            f457 = i2 % 128;
            if (i2 % 2 == 0) {
                if (ka.m2874(str, cnVar.m1660()) >= 0 && ka.m2874(str, cnVar.m1659()) <= 0) {
                    return true;
                }
            } else {
                ka.m2874(str, cnVar.m1660());
                throw null;
            }
        }
        int i8 = f456 + 75;
        f457 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 92 / 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m711(String str, List<Object> list) {
        f457 = (f456 + 99) % 128;
        Iterator<cn> it = m656().iterator();
        while (it.hasNext()) {
            int i2 = f457 + 37;
            f456 = i2 % 128;
            if (i2 % 2 == 0) {
                it.next().m1668(str, list);
                throw null;
            }
            it.next().m1668(str, list);
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized ISAdQualityInitListener m712() {
        int i2 = f456;
        ISAdQualityInitListener iSAdQualityInitListener = this.f468;
        int i8 = i2 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f457 = i8 % 128;
        if (i8 % 2 == 0) {
            return iSAdQualityInitListener;
        }
        int i9 = 76 / 0;
        return iSAdQualityInitListener;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private cn m674(Context context, String str, bg bgVar) {
        int i2 = (f457 + 5) % 128;
        f456 = i2;
        if (str != null) {
            return new cn(context, new dh(str, this.f473), this.f467, this.f470, bgVar);
        }
        int i8 = i2 + 11;
        f457 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 55 / 0;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private boolean m672(String str) {
        if (this.f471.containsKey(str)) {
            int i2 = f457 + 91;
            f456 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f471.get(str).m634(this.f472);
                throw null;
            }
            if (this.f471.get(str).m634(this.f472)) {
                return true;
            }
        }
        f456 = (f457 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return false;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static JSONObject m667(Map<String, JSONObject> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        f456 = (f457 + 21) % 128;
        for (String str : new HashSet(map.keySet())) {
            f457 = (f456 + 7) % 128;
            jSONObject2.put(str.toLowerCase(), map.get(str));
        }
        jSONObject.put(m658((-92) - (ViewConfiguration.getPressedStateDuration() >> 16), (short) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), 1233204730 - MotionEvent.axisFromString(""), (byte) ((-42) - TextUtils.indexOf((CharSequence) "", '0', 0)), ImageFormat.getBitsPerPixel(0) - 1390409659).intern(), jSONObject2);
        return jSONObject;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m682(String str, bg bgVar) {
        int i2 = f456 + 115;
        f457 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (bgVar != null) {
            m652().put(str, m688(bgVar.m883()));
        }
        f456 = (f457 + 103) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m710(String str) {
        m711(str, new ArrayList());
        int i2 = f457 + 77;
        f456 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m675(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (o.f2985) {
            try {
                char[] cArr2 = new char[cArr.length];
                o.f2986 = 0;
                char[] cArr3 = new char[2];
                while (true) {
                    int i8 = o.f2986;
                    if (i8 < cArr.length) {
                        cArr3[0] = cArr[i8];
                        cArr3[1] = cArr[i8 + 1];
                        int i9 = 58224;
                        for (int i10 = 0; i10 < 16; i10++) {
                            char c7 = cArr3[1];
                            char c8 = cArr3[0];
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f461)) ^ ((c8 >>> 5) + f463)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f465) ^ ((c9 + i9) ^ ((c9 << 4) + f466))));
                            i9 -= 40503;
                        }
                        int i11 = o.f2986;
                        cArr2[i11] = cArr3[0];
                        cArr2[i11 + 1] = cArr3[1];
                        o.f2986 = i11 + 2;
                    } else {
                        str2 = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
