package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.ironsource.adqualitysdk.sdk.i.jk;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class cp {

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private static int f1390 = 0;

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    private static int f1391 = 1;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static char[] f1392 = {274, 293, 301, 303, 308, 257, 292, 268, 297, 307, 302, 306, 238, 289, 300, 314, 291, 310, 313, 294, 309, 296, 260, 276, 304, 311, 259, 270, 261, 312, 266, 275, 258, 224, 295, 287};

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static long f1393 = 227323916017794373L;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f1394 = 192;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static boolean f1395 = true;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static boolean f1396 = true;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private jj f1397 = null;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private u f1398;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private cn f1399;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private jn f1400;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private JSONObject f1401;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ch f1402;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private hr f1403;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ds f1404;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private bg f1405;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private de f1406;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$a$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass3 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ Object f1482;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ s f1483;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1484;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private /* synthetic */ Object f1485;

            public AnonymousClass3(s sVar, JSONObject jSONObject, Object obj, Object obj2) {
                this.f1483 = sVar;
                this.f1484 = jSONObject;
                this.f1485 = obj;
                this.f1482 = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1483.mo296(this.f1484, this.f1485, this.f1482);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class b<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$b$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass4 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ Object f1486;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ Object f1487;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private /* synthetic */ s f1488;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ Object f1489;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1490;

            public AnonymousClass4(s sVar, JSONObject jSONObject, Object obj, Object obj2, Object obj3) {
                this.f1488 = sVar;
                this.f1490 = jSONObject;
                this.f1487 = obj;
                this.f1489 = obj2;
                this.f1486 = obj3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1488.mo329(this.f1490, this.f1487, this.f1489, this.f1486);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class c<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$c$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass2 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ Object f1491;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ Object f1492;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1493;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private /* synthetic */ s f1494;

            public AnonymousClass2(s sVar, JSONObject jSONObject, Object obj, Object obj2) {
                this.f1494 = sVar;
                this.f1493 = jSONObject;
                this.f1491 = obj;
                this.f1492 = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1494.mo330(this.f1493, this.f1491, this.f1492);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class d<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$d$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass5 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1495;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ Object f1496;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private /* synthetic */ s f1497;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ Object f1498;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private /* synthetic */ Object f1499;

            public AnonymousClass5(s sVar, JSONObject jSONObject, Object obj, Object obj2, Object obj3) {
                this.f1497 = sVar;
                this.f1495 = jSONObject;
                this.f1499 = obj;
                this.f1498 = obj2;
                this.f1496 = obj3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1497.mo333(this.f1495, this.f1499, this.f1498, this.f1496);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class e<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$e$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass1 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ Object f1500;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1501;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private /* synthetic */ s f1502;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ Object f1503;

            public AnonymousClass1(s sVar, JSONObject jSONObject, Object obj, Object obj2) {
                this.f1502 = sVar;
                this.f1501 = jSONObject;
                this.f1500 = obj;
                this.f1503 = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1502.mo293(this.f1501, this.f1500, this.f1503);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class f<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$f$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass4 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ Object f1504;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ Object f1505;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private /* synthetic */ Object f1506;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ s f1507;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1508;

            public AnonymousClass4(s sVar, JSONObject jSONObject, Object obj, Object obj2, Object obj3) {
                this.f1507 = sVar;
                this.f1508 = jSONObject;
                this.f1506 = obj;
                this.f1504 = obj2;
                this.f1505 = obj3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1507.mo331(this.f1508, this.f1506, this.f1504, this.f1505);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class h<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$h$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass3 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ Object f1509;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ Object f1510;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ s f1511;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1512;

            public AnonymousClass3(s sVar, JSONObject jSONObject, Object obj, Object obj2) {
                this.f1511 = sVar;
                this.f1512 = jSONObject;
                this.f1510 = obj;
                this.f1509 = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1511.mo332(this.f1512, this.f1510, this.f1509);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class i<K, T> {

        /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.cp$i$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class AnonymousClass2 extends iu {

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private /* synthetic */ JSONObject f1513;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private /* synthetic */ s f1514;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private /* synthetic */ Object f1515;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private /* synthetic */ Object f1516;

            public AnonymousClass2(s sVar, JSONObject jSONObject, Object obj, Object obj2) {
                this.f1514 = sVar;
                this.f1513 = jSONObject;
                this.f1515 = obj;
                this.f1516 = obj2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                this.f1514.mo328(this.f1513, this.f1515, this.f1516);
            }
        }
    }

    public cp(cn cnVar, de deVar, bg bgVar, hr hrVar, ds dsVar) {
        this.f1403 = hrVar;
        ds dsVar2 = new ds(new HashMap(), dsVar, true);
        this.f1404 = dsVar2;
        dsVar2.m2137(m1732().m2354());
        dsVar.m2135(hrVar.m2352(), this);
        this.f1406 = deVar;
        this.f1405 = bgVar;
        this.f1402 = m1675();
        this.f1399 = cnVar;
        this.f1398 = new u();
        m1709(m1705((String) null, (ViewConfiguration.getPressedStateDuration() >> 16) + 127, (int[]) null, "\u0082\u0090\u0089\u008f\u008e\u0089\u0085\u0089\u008b\u0089\u008d\u008c\u0082\u008b\u0082\u0085\u008a\u0089\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), new ArrayList());
        m1680();
    }

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private void m1674() {
        f1390 = (f1391 + 21) % 128;
        this.f1398.m3050();
        f1390 = (f1391 + 67) % 128;
    }

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    private ch m1675() {
        ch chVar = new ch() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.2
            @Override // com.ironsource.adqualitysdk.sdk.i.ch
            /* JADX INFO: renamed from: ﻐ */
            public final void mo1591(final String str, final List<Object> list) {
                final boolean z2 = true;
                final boolean z7 = false;
                cp.m1682(cp.this, str, true, false, list);
                cp.m1694(cp.this, new im() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.2.5
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        cp.m1682(cp.this, str, false, z7, list);
                    }
                }, false);
                cp.m1694(cp.this, new im() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.2.5
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        cp.m1682(cp.this, str, false, z2, list);
                    }
                }, true);
            }
        };
        int i2 = f1390 + 109;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return chVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private jj m1676() {
        jj jjVar = new jj() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.3
            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
                cp cpVar = cp.this;
                cpVar.m1726(ig.f2490, cp.m1706(cpVar, activity, null));
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                cp cpVar = cp.this;
                cpVar.m1726(ig.f2491, cp.m1706(cpVar, activity, null));
            }
        };
        int i2 = f1390 + 93;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return jjVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private dn m1677() {
        f1390 = (f1391 + 45) % 128;
        dn dnVarM1658 = m1730().m1658();
        f1390 = (f1391 + 97) % 128;
        return dnVarM1658;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private void m1678() {
        int i2 = f1390 + 25;
        f1391 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f1398.m3053();
            throw null;
        }
        this.f1398.m3053();
        int i8 = f1391 + 51;
        f1390 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 36 / 0;
        }
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private void m1679() {
        int i2 = f1391 + 59;
        f1390 = i2 % 128;
        if (i2 % 2 != 0) {
            this.f1398.m3048();
            throw null;
        }
        this.f1398.m3048();
        f1390 = (f1391 + 41) % 128;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private void m1680() {
        f1390 = (f1391 + 89) % 128;
        for (dm dmVar : m1732().m2355()) {
            if (m1687(dmVar)) {
                m1695(dmVar);
            }
            f1391 = (f1390 + 5) % 128;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ ds m1681(cp cpVar) {
        int i2 = f1390;
        f1391 = (i2 + 101) % 128;
        ds dsVar = cpVar.f1404;
        f1391 = (i2 + 101) % 128;
        return dsVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m1694(cp cpVar, im imVar, boolean z2) {
        f1390 = (f1391 + 29) % 128;
        cpVar.m1708(imVar, z2);
        int i2 = f1390 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1391 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m1706(cp cpVar, Activity activity, Bundle bundle) {
        int i2 = f1390 + 7;
        f1391 = i2 % 128;
        int i8 = i2 % 2;
        JSONObject jSONObjectM1700 = cpVar.m1700(activity, bundle);
        if (i8 == 0) {
            int i9 = 60 / 0;
        }
        int i10 = f1391 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1390 = i10 % 128;
        if (i10 % 2 == 0) {
            return jSONObjectM1700;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public final void m1718() {
        int i2 = f1391 + 41;
        f1390 = i2 % 128;
        if (i2 % 2 != 0) {
            m1674();
            m1679();
            m1678();
            throw null;
        }
        m1674();
        m1679();
        m1678();
        if (this.f1397 != null) {
            jf.m2685().m2689(this.f1397);
            this.f1397 = null;
            f1390 = (f1391 + 41) % 128;
        }
        jn jnVar = this.f1400;
        if (jnVar != null) {
            jnVar.m2745();
            this.f1400 = null;
        }
        this.f1402 = null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final de m1719() {
        int i2 = f1391 + 1;
        f1390 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1406;
        }
        int i8 = 70 / 0;
        return this.f1406;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final ch m1720() {
        int i2 = f1390 + 93;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1402;
        }
        int i8 = 32 / 0;
        return this.f1402;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final JSONObject m1721() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ig.f2524, m1730().m1666());
            jSONObject.put(ig.f2481, m1730().m1663());
            jSONObject.put(ig.f2480, m1730().m1669());
            f1391 = (f1390 + 59) % 128;
            return jSONObject;
        } catch (JSONException e4) {
            String strIntern = m1705((String) null, Color.red(0) + 127, (int[]) null, "\u008c\u0082\u008b\u0082\u0085\u008a\u0089\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m1691("둰됵⏨\udedf뽮鼑䖖䄖梱톑ꩫ萠帽쓤ꅐ褯欢．鱰뿟恖\uf218謢ꓚ紴\ue52b蘋ꧭ੦顯ﲴ", -MotionEvent.axisFromString("")).intern());
            sb.append(e4.getLocalizedMessage());
            k.m2863(strIntern, sb.toString());
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final ds m1722() {
        int i2 = f1390 + 91;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1404;
        }
        int i8 = 50 / 0;
        return this.f1404;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final String m1723() {
        StringBuilder sb = new StringBuilder();
        sb.append(m1730().m1667());
        sb.append(m1691("\uf22a\uf205蕲ໆ巷", View.resolveSize(0, 0) + 1).intern());
        sb.append(m1732().m2352());
        String string = sb.toString();
        int i2 = f1390 + 23;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return string;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final cn m1730() {
        int i2 = f1390;
        cn cnVar = this.f1399;
        f1391 = (i2 + 107) % 128;
        return cnVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final bg m1733() {
        int i2 = f1390;
        bg bgVar = this.f1405;
        f1391 = (i2 + 43) % 128;
        return bgVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m1682(cp cpVar, String str, boolean z2, boolean z7, List list) {
        int i2 = f1390 + 29;
        f1391 = i2 % 128;
        int i8 = i2 % 2;
        cpVar.m1684(str, z2, z7, (List<Object>) list);
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m1711(Activity activity, List list) {
        f1391 = (f1390 + 85) % 128;
        boolean zM1696 = m1696(activity, (List<String>) list);
        f1391 = (f1390 + 85) % 128;
        return zM1696;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m1716(dm dmVar) {
        JSONObject jSONObjectM1715 = m1715(dmVar.m2059());
        if (jSONObjectM1715 != null) {
            f1390 = (f1391 + 69) % 128;
            m1717(jSONObjectM1715, m1699(false), m1699(true));
        }
        int i2 = f1391 + 5;
        f1390 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 79 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final Context m1728() {
        f1390 = (f1391 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        Context contextM1655 = m1730().m1655();
        f1391 = (f1390 + 87) % 128;
        return contextM1655;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m1731(io ioVar) {
        int i2 = f1390 + 85;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            this.f1399.m1657().m853(ioVar);
        } else {
            this.f1399.m1657().m853(ioVar);
            throw null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003b, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
    
        r5 = com.ironsource.adqualitysdk.sdk.i.cp.f1391 + 33;
        com.ironsource.adqualitysdk.sdk.i.cp.f1390 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
    
        if ((r5 % 2) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
    
        r5 = m1729(r8);
        r6 = 84 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (r5 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0053, code lost:
    
        r5 = m1729(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0057, code lost:
    
        if (r5 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        m1710(r0, r4, r1, new com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass9(r7));
        com.ironsource.adqualitysdk.sdk.i.cp.f1391 = (com.ironsource.adqualitysdk.sdk.i.cp.f1390 + 3) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        r0 = m1723();
        r1 = new java.lang.StringBuilder();
        r1.append(m1691("蔨蕥岯ꆏ\uefa2䃘ᕜ灓띿꺒\ufae2寸潥뮤\uf187囦婽聚쳳怛儖贚\udbe0笏䰾騦", android.graphics.drawable.Drawable.resolveOpacity(0, 0) + 1).intern());
        r1.append(r8);
        r1.append(m1691("\udcfd\udcdd쾎㊥\uf16c秽உ⧉蹆㶱\ue478拐㚻⢇", (android.graphics.PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (android.graphics.PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1).intern());
        com.ironsource.adqualitysdk.sdk.i.co.m1671(r0, r1.toString(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a6, code lost:
    
        m1686(r0, r4, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0028, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) == false) goto L11;
     */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m1701(com.ironsource.adqualitysdk.sdk.i.dm r8) {
        /*
            r7 = this;
            org.json.JSONObject r0 = r8.m2059()
            org.json.JSONObject r0 = r7.m1715(r0)
            if (r0 == 0) goto La9
            int r1 = com.ironsource.adqualitysdk.sdk.i.cp.f1391
            int r1 = r1 + 89
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.cp.f1390 = r2
            int r1 = r1 % 2
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2b
            java.lang.String r8 = r8.m2056()
            com.ironsource.adqualitysdk.sdk.i.t r1 = r7.m1703(r3)
            com.ironsource.adqualitysdk.sdk.i.t r4 = r7.m1703(r3)
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 != 0) goto La6
            goto L3d
        L2b:
            java.lang.String r8 = r8.m2056()
            com.ironsource.adqualitysdk.sdk.i.t r1 = r7.m1703(r3)
            com.ironsource.adqualitysdk.sdk.i.t r4 = r7.m1703(r2)
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 != 0) goto La6
        L3d:
            int r5 = com.ironsource.adqualitysdk.sdk.i.cp.f1391
            int r5 = r5 + 33
            int r6 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.cp.f1390 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L53
            com.ironsource.adqualitysdk.sdk.i.dq r5 = r7.m1729(r8)
            r6 = 84
            int r6 = r6 / r2
            if (r5 == 0) goto L6a
            goto L59
        L53:
            com.ironsource.adqualitysdk.sdk.i.dq r5 = r7.m1729(r8)
            if (r5 == 0) goto L6a
        L59:
            com.ironsource.adqualitysdk.sdk.i.cp$9 r8 = new com.ironsource.adqualitysdk.sdk.i.cp$9
            r8.<init>()
            r7.m1710(r0, r4, r1, r8)
            int r8 = com.ironsource.adqualitysdk.sdk.i.cp.f1390
            int r8 = r8 + 3
            int r8 = r8 % 128
            com.ironsource.adqualitysdk.sdk.i.cp.f1391 = r8
            return
        L6a:
            java.lang.String r0 = r7.m1723()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = android.graphics.drawable.Drawable.resolveOpacity(r2, r2)
            int r2 = r2 + r3
            java.lang.String r4 = "蔨蕥岯ꆏ\uefa2䃘ᕜ灓띿꺒\ufae2寸潥뮤\uf187囦婽聚쳳怛儖贚\udbe0笏䰾騦"
            java.lang.String r2 = m1691(r4, r2)
            java.lang.String r2 = r2.intern()
            r1.append(r2)
            r1.append(r8)
            r8 = 0
            float r2 = android.graphics.PointF.length(r8, r8)
            int r8 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            int r8 = r8 + r3
            java.lang.String r2 = "\udcfd\udcdd쾎㊥\uf16c秽உ⧉蹆㶱\ue478拐㚻⢇"
            java.lang.String r8 = m1691(r2, r8)
            java.lang.String r8 = r8.intern()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r1 = 0
            com.ironsource.adqualitysdk.sdk.i.co.m1671(r0, r8, r1)
            return
        La6:
            r7.m1686(r0, r4, r1)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cp.m1701(com.ironsource.adqualitysdk.sdk.i.dm):void");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m1727(JSONObject jSONObject) {
        f1390 = (f1391 + 101) % 128;
        this.f1401 = kc.m2909(jSONObject, true);
        f1390 = (f1391 + 31) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final dq m1729(String str) {
        int i2 = f1390 + 23;
        f1391 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (str == null) {
            return null;
        }
        dq dqVarM2353 = m1732().m2353(str);
        f1390 = (f1391 + 83) % 128;
        return dqVarM2353;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final hr m1732() {
        int i2 = f1390 + 109;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1403;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m1707(dm dmVar) {
        int i2 = f1391 + 89;
        f1390 = i2 % 128;
        it itVar = null;
        if (i2 % 2 == 0) {
            JSONObject jSONObjectM1715 = m1715(dmVar.m2059());
            if (jSONObjectM1715 != null) {
                f1390 = (f1391 + 91) % 128;
                final String strM2054 = dmVar.m2054();
                if (!TextUtils.isEmpty(strM2054)) {
                    int i8 = f1390 + 113;
                    f1391 = i8 % 128;
                    if (i8 % 2 != 0) {
                        final dq dqVarM1729 = m1729(strM2054);
                        if (dqVarM1729 != null) {
                            itVar = new it() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.1

                                /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                                private static char f1407 = 21759;

                                /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                                private static int f1408 = 1;

                                /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                                private static int f1409 = 0;

                                /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                                private static char f1410 = 56348;

                                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                                private static char f1411 = 35047;

                                /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                                private static char f1412 = 47207;

                                @Override // com.ironsource.adqualitysdk.sdk.i.it
                                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                                public final List<WebView> mo1735(Object obj) {
                                    int i9 = f1409 + 77;
                                    f1408 = i9 % 128;
                                    try {
                                        if (i9 % 2 == 0) {
                                            throw null;
                                        }
                                        List<WebView> list = (List) dqVarM1729.m2081(cp.m1681(cp.this), cp.this, Collections.singletonList(obj)).m2153();
                                        f1409 = (f1408 + 99) % 128;
                                        return list;
                                    } catch (Exception unused) {
                                        String strIntern = m1734("䄹죺ꦽ홉ﻝᨇ▉䄘⑂锜ᓇꨈ섷逮\ueddeި", TextUtils.indexOf((CharSequence) "", '0') + 17).intern();
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(m1734("閭뾵铪輙ӈ㝶议뻭蟋ᬥ핔㙘\ueba1\ue431垐ۼ\ue825̼爨࿁ꠙꞁ鲨ꧭ铪輙䏳鎚", TextUtils.lastIndexOf("", '0', 0, 0) + 29).intern());
                                        sb.append(strM2054);
                                        k.m2863(strIntern, sb.toString());
                                        return null;
                                    }
                                }

                                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                                private static String m1734(String str, int i9) {
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
                                                int i10 = o.f2986;
                                                if (i10 < cArr.length) {
                                                    cArr3[0] = cArr[i10];
                                                    cArr3[1] = cArr[i10 + 1];
                                                    int i11 = 58224;
                                                    for (int i12 = 0; i12 < 16; i12++) {
                                                        char c7 = cArr3[1];
                                                        char c8 = cArr3[0];
                                                        char c9 = (char) (c7 - (((c8 + i11) ^ ((c8 << 4) + f1410)) ^ ((c8 >>> 5) + f1407)));
                                                        cArr3[1] = c9;
                                                        cArr3[0] = (char) (c8 - (((c9 >>> 5) + f1411) ^ ((c9 + i11) ^ ((c9 << 4) + f1412))));
                                                        i11 -= 40503;
                                                    }
                                                    int i13 = o.f2986;
                                                    cArr2[i13] = cArr3[0];
                                                    cArr2[i13 + 1] = cArr3[1];
                                                    o.f2986 = i13 + 2;
                                                } else {
                                                    str2 = new String(cArr2, 0, i9);
                                                }
                                            }
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    return str2;
                                }
                            };
                        } else {
                            String strM1723 = m1723();
                            StringBuilder sb = new StringBuilder();
                            sb.append(m1691("蔨蕥岯ꆏ\uefa2䃘ᕜ灓띿꺒\ufae2寸潥뮤\uf187囦婽聚쳳怛儖贚\udbe0笏䰾騦", (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern());
                            sb.append(strM2054);
                            sb.append(m1691("\udcfd\udcdd쾎㊥\uf16c秽உ⧉蹆㶱\ue478拐㚻⢇", -TextUtils.indexOf((CharSequence) "", '0')).intern());
                            co.m1671(strM1723, sb.toString(), null);
                            f1391 = (f1390 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
                        }
                    } else {
                        m1729(strM2054);
                        throw null;
                    }
                }
                m1685(jSONObjectM1715, m1689(false), m1689(true), itVar);
                return;
            }
            return;
        }
        m1715(dmVar.m2059());
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m1717(JSONObject jSONObject, x xVar, x xVar2) {
        int i2 = f1391 + 89;
        f1390 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f1398.m3049(jSONObject, m1704(xVar, xVar2));
        } else {
            this.f1398.m3049(jSONObject, m1704(xVar, xVar2));
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final JSONObject m1724() {
        int i2 = f1391;
        int i8 = i2 + 109;
        f1390 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        JSONObject jSONObject = this.f1401;
        int i9 = i2 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1390 = i9 % 128;
        if (i9 % 2 == 0) {
            return jSONObject;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1685(JSONObject jSONObject, l lVar, l lVar2, it itVar) {
        f1390 = (f1391 + 7) % 128;
        this.f1398.m3051(jSONObject, m1698(lVar, lVar2), m1676(), itVar);
        f1391 = (f1390 + 37) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1714(String str, JSONObject jSONObject) {
        f1390 = (f1391 + 57) % 128;
        int iHashCode = str.hashCode();
        if (iHashCode != -1655966961) {
            if (iHashCode != -787751952) {
                if (iHashCode == 3619493 && str.equals(m1691("ﳝﲫ慮鱂\ud81a烳⋵蝋", View.resolveSize(0, 0) + 1).intern())) {
                    return jSONObject.optString(m1691("ⰏⱮ概钣㬚☕쇆\ud97e톳鮬⸛㴼왆躜┇《\uf352땮ᡥ", KeyEvent.getDeadChar(0, 0) + 1).intern(), null);
                }
            } else if (str.equals(m1691("鴎鵹褱琝鄕넗毱桵䚼笟", 1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern())) {
                return jSONObject.optString(m1705((String) null, 127 - TextUtils.getOffsetBefore("", 0), (int[]) null, "\u0082\u0083\u008e\u009c\u008a\u008a\u008e\u008f\u009b\u009a\u0082\u0089\u0092").intern(), null);
            }
        } else if (str.equals(m1705((String) null, KeyEvent.getDeadChar(0, 0) + 127, (int[]) null, "\u0093\u0085\u0089\u0092\u0089\u0085\u0091\u008e").intern())) {
            f1390 = (f1391 + 115) % 128;
            String strOptString = jSONObject.optString(m1691("댉덨Ф串\ue4ed猪Ḧ䙩蒆\uf614\uf1ce栌奕\ue330\ufada攐汘\ud8c0", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1).intern(), null);
            int i2 = f1390 + 35;
            f1391 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 62 / 0;
            }
            return strOptString;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1683(String str, dm dmVar) {
        JSONObject jSONObjectM1715 = m1715(dmVar.m2059());
        if (jSONObjectM1715 != null && jSONObjectM1715.has(m1705((String) null, 127 - TextUtils.getTrimmedLength(""), (int[]) null, "\u0082\u0099\u0093\u0098\u008b\u0084\u0089\u0085\u0091\u0082\u0085\u0082\u0097\u0096\u0091\u0095\u0084\u0085").intern())) {
            jk.e eVarM2738 = jk.e.m2738(jSONObjectM1715.optString(m1705((String) null, KeyEvent.getDeadChar(0, 0) + 127, (int[]) null, "\u0082\u0099\u0093\u0098\u008b\u0084\u0089\u0085\u0091\u0082\u0085\u0082\u0097\u0096\u0091\u0095\u0084\u0085").intern(), null));
            String strM1714 = m1714(str, jSONObjectM1715);
            if (eVarM2738 != null) {
                f1391 = (f1390 + 89) % 128;
                jk.m2733().m2734(strM1714, eVarM2738);
            }
        }
        f1390 = (f1391 + 75) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private JSONObject m1693(JSONObject jSONObject) {
        JSONObject jSONObjectM1721;
        int i2 = f1390 + 59;
        f1391 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM1721 = m1721();
            kc.m2910(jSONObjectM1721, jSONObject);
            int i8 = 90 / 0;
        } else {
            jSONObjectM1721 = m1721();
            kc.m2910(jSONObjectM1721, jSONObject);
        }
        int i9 = f1391 + 65;
        f1390 = i9 % 128;
        if (i9 % 2 == 0) {
            return jSONObjectM1721;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1686(JSONObject jSONObject, t tVar, t tVar2) {
        int i2 = f1391 + 75;
        f1390 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f1398.m3052(jSONObject, m1690(tVar, tVar2));
        } else {
            this.f1398.m3052(jSONObject, m1690(tVar, tVar2));
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static boolean m1687(dm dmVar) {
        List listMo531 = aq.m530().mo531();
        ISAdQualityAdType iSAdQualityAdTypeM2057 = dmVar.m2057();
        if (listMo531 != null) {
            int i2 = f1390 + 31;
            f1391 = i2 % 128;
            if (i2 % 2 == 0) {
                ISAdQualityAdType iSAdQualityAdType = ISAdQualityAdType.UNKNOWN;
                throw null;
            }
            if (iSAdQualityAdTypeM2057 != ISAdQualityAdType.UNKNOWN) {
                if (listMo531.contains(iSAdQualityAdTypeM2057)) {
                    f1391 = (f1390 + 67) % 128;
                    return false;
                }
                f1390 = (f1391 + 29) % 128;
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m1695(dm dmVar) {
        String strM2058 = dmVar.m2058();
        switch (strM2058.hashCode()) {
            case -1825565413:
                if (strM2058.equals(m1705((String) null, 127 - View.getDefaultSize(0, 0), (int[]) null, "\u0082\u008f\u0091\u0093\u0091\u0082\u0094\u0089\u0088\u0093\u0085\u0089\u0092\u0089\u0085\u0091\u008e").intern()) && this.f1397 == null) {
                    f1390 = (f1391 + 49) % 128;
                    this.f1397 = m1697(m1692(dmVar.m2055()));
                    jf.m2685().m2686(this.f1397);
                    break;
                }
                break;
            case -1655966961:
                if (strM2058.equals(m1705((String) null, 126 - TextUtils.lastIndexOf("", '0', 0, 0), (int[]) null, "\u0093\u0085\u0089\u0092\u0089\u0085\u0091\u008e").intern())) {
                    f1390 = (f1391 + 9) % 128;
                    m1707(dmVar);
                    m1683(m1705((String) null, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 128, (int[]) null, "\u0093\u0085\u0089\u0092\u0089\u0085\u0091\u008e").intern(), dmVar);
                }
                break;
            case -787751952:
                if (strM2058.equals(m1691("鴎鵹褱琝鄕넗毱桵䚼笟", ExpandableListView.getPackedPositionGroup(0L) + 1).intern())) {
                    m1716(dmVar);
                    m1683(m1691("鴎鵹褱琝鄕넗毱桵䚼笟", -ExpandableListView.getPackedPositionChild(0L)).intern(), dmVar);
                }
                break;
            case 3619493:
                if (strM2058.equals(m1691("ﳝﲫ慮鱂\ud81a烳⋵蝋", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1).intern())) {
                    m1701(dmVar);
                    m1683(m1691("ﳝﲫ慮鱂\ud81a烳⋵蝋", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1).intern(), dmVar);
                }
                break;
            case 1144592183:
                if (strM2058.equals(m1691("\uf0a1\uf0c0⦬풙垄⇿굾ך홶\udb96䊕㫦", -ImageFormat.getBitsPerPixel(0)).intern())) {
                    this.f1400 = new jn(m1712(m1692(dmVar.m2055())));
                }
                break;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private JSONObject m1715(JSONObject jSONObject) {
        dn dnVarM1677;
        String strOptString = jSONObject.optString(m1691("ĵşꋹ忏뻻\uec97䐡\uf444ᬪ僆ꯖ\uf7b1", -MotionEvent.axisFromString("")).intern());
        jSONObject.remove(m1691("ĵşꋹ忏뻻\uec97䐡\uf444ᬪ僆ꯖ\uf7b1", 1 - Color.blue(0)).intern());
        if (jSONObject.optBoolean(m1691("깴긝\uf5aeࢅ譕퀗熵嬃➽ރ鹡쬭", 1 - View.combineMeasuredStates(0, 0)).intern()) && (dnVarM1677 = m1677()) != null) {
            if (!TextUtils.isEmpty(dnVarM1677.m2063())) {
                jSONObject.remove(m1691("깴긝\uf5aeࢅ譕퀗熵嬃➽ރ鹡쬭", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern());
                try {
                    String strIntern = m1691("䘉䙣ট\uf4a9ᒫ䀃\uee75더랣ﮨƁ嬥걂\uee86", View.MeasureSpec.getSize(0) + 1).intern();
                    StringBuilder sb = new StringBuilder();
                    sb.append(strOptString);
                    sb.append(dnVarM1677.m2063());
                    jSONObject.put(strIntern, sb.toString());
                } catch (JSONException unused) {
                }
            }
            if (dnVarM1677.m2061()) {
                int i2 = f1390 + 83;
                f1391 = i2 % 128;
                try {
                    jSONObject.put((i2 % 2 == 0 ? m1705((String) null, 68 << View.combineMeasuredStates(0, 1), (int[]) null, "\u008a\u009f\u008e\u008c\u0085\u009e\u009d\u0082\u008a\u0095") : m1705((String) null, View.combineMeasuredStates(0, 0) + 127, (int[]) null, "\u008a\u009f\u008e\u008c\u0085\u009e\u009d\u0082\u008a\u0095")).intern(), true);
                } catch (JSONException unused2) {
                }
            }
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            f1391 = (f1390 + 105) % 128;
            if (!m1688(jSONObject, itKeys.next())) {
                int i8 = (f1390 + 63) % 128;
                f1391 = i8;
                f1390 = (i8 + 49) % 128;
                return null;
            }
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private boolean m1688(JSONObject jSONObject, String str) {
        f1391 = (f1390 + 13) % 128;
        Object objOpt = jSONObject.opt(str);
        try {
            if (objOpt instanceof String) {
                int i2 = f1391 + 69;
                f1390 = i2 % 128;
                if (i2 % 2 == 0) {
                    String str2 = (String) objOpt;
                    if (m1702(str2)) {
                        String strM1713 = m1713(str2);
                        if (strM1713 != null) {
                            f1391 = (f1390 + 65) % 128;
                            jSONObject.put(str, strM1713);
                        } else {
                            String strM1723 = m1723();
                            StringBuilder sb = new StringBuilder();
                            sb.append(m1691("卙匚䆷벞僁\ufafcꨪ\ua63eീ돎", 1 - KeyEvent.getDeadChar(0, 0)).intern());
                            sb.append(str2);
                            sb.append(m1691("⑫\u244b뇷䳜ᴏ塰\ue7ea텟꿋䏈ࠛ䍝츭图\u0378丑ﭷ洗㹎碯\uf049怖⥙掺\ued68睾⑨溑驠ਾ庍᧢鞂Ŕ䧜ӣ貮ᑦ䒵࿔", ExpandableListView.getPackedPositionType(0L) + 1).intern());
                            co.m1672(strM1723, sb.toString());
                            int i8 = f1390 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                            f1391 = i8 % 128;
                            if (i8 % 2 == 0) {
                                int i9 = 73 / 0;
                            }
                            return false;
                        }
                    }
                } else {
                    m1702((String) objOpt);
                    throw null;
                }
            } else if (objOpt instanceof JSONArray) {
                jSONObject.put(str, new JSONArray((Collection) m1692(kc.m2900((JSONArray) objOpt))));
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m1710(JSONObject jSONObject, t tVar, t tVar2, is isVar) {
        int i2 = f1390 + 19;
        f1391 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f1398.m3054(jSONObject, m1690(tVar, tVar2), isVar);
            throw null;
        }
        this.f1398.m3054(jSONObject, m1690(tVar, tVar2), isVar);
        int i8 = f1390 + 43;
        f1391 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private t m1703(final boolean z2) {
        t tVar = new t() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.15

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f1437 = 1;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f1438;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int[] f1439 = {-1903055520, 1305868750, 1857150868, -1286161687, 1741343652, -1023515914, 248491156, 951687475, -1559547079, 890954036, -1487609970, 1844179634, 1744764495, -910079889, 101125097, 1195720760, -1002155931, -421936584};

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final /* bridge */ /* synthetic */ void mo328(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1437 + 19;
                f1438 = i2 % 128;
                int i8 = i2 % 2;
                mo328(jSONObject, view, activity);
                if (i8 != 0) {
                    throw null;
                }
                f1437 = (f1438 + 23) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ */
            public final /* synthetic */ void mo330(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1437 + 77;
                f1438 = i2 % 128;
                int i8 = i2 % 2;
                mo330(jSONObject, view, activity);
                if (i8 != 0) {
                    throw null;
                }
                int i9 = f1437 + 9;
                f1438 = i9 % 128;
                if (i9 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ void mo293(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1438 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
                f1437 = i2 % 128;
                int i8 = i2 % 2;
                mo293(jSONObject, view, activity);
                if (i8 == 0) {
                    int i9 = 75 / 0;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ */
            public final /* synthetic */ void mo296(JSONObject jSONObject, View view, Activity activity) {
                f1437 = (f1438 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
                mo296(jSONObject, view, activity);
                int i2 = f1437 + 87;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final /* synthetic */ void mo332(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1437 + 47;
                f1438 = i2 % 128;
                int i8 = i2 % 2;
                mo332(jSONObject, view, activity);
                if (i8 != 0) {
                    throw null;
                }
                int i9 = f1437 + 7;
                f1438 = i9 % 128;
                if (i9 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ void mo329(JSONObject jSONObject, View view, Object obj, Activity activity) {
                f1437 = (f1438 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
                mo329(jSONObject, view, obj, activity);
                int i2 = f1437 + 67;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo329(JSONObject jSONObject, View view, Object obj, Activity activity) {
                f1438 = (f1437 + 83) % 128;
                m1757(m1756(new int[]{139513171, 377327494, 1314956943, 1308315702, 1538980857, 685891609, 113844258, 1518085328}, 16 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))).intern(), jSONObject, view, obj, activity);
                f1438 = (f1437 + 23) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ void mo331(JSONObject jSONObject, View view, Object obj, Activity activity) {
                f1437 = (f1438 + 21) % 128;
                mo331(jSONObject, view, obj, activity);
                f1438 = (f1437 + 23) % 128;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final void mo330(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1438 + 7;
                f1437 = i2 % 128;
                if (i2 % 2 == 0) {
                    m1757(m1756(new int[]{139513171, 377327494, 1200637872, 371320727}, 90 >> (ViewConfiguration.getScrollBarFadeDuration() + 79)).intern(), jSONObject, view, null, activity);
                } else {
                    m1757(m1756(new int[]{139513171, 377327494, 1200637872, 371320727}, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 8).intern(), jSONObject, view, null, activity);
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final /* synthetic */ void mo333(JSONObject jSONObject, View view, Object obj, Activity activity) {
                int i2 = f1437 + 45;
                f1438 = i2 % 128;
                int i8 = i2 % 2;
                mo333(jSONObject, view, obj, activity);
                if (i8 != 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final void mo328(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1437 + 41;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    m1757(m1756(new int[]{474170242, 1584170332, 2019762885, -799889410, -1732274692, -1678806398}, 81 >>> View.combineMeasuredStates(0, 1)).intern(), jSONObject, view, null, activity);
                } else {
                    m1757(m1756(new int[]{474170242, 1584170332, 2019762885, -799889410, -1732274692, -1678806398}, View.combineMeasuredStates(0, 0) + 12).intern(), jSONObject, view, null, activity);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo332(JSONObject jSONObject, View view, Activity activity) {
                f1437 = (f1438 + 69) % 128;
                m1757(m1756(new int[]{-472133129, 1587626011, 1399554265, 1366767670, 698973561, 1030483624}, TextUtils.getTrimmedLength("") + 11).intern(), jSONObject, view, null, activity);
                f1438 = (f1437 + 3) % 128;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo296(JSONObject jSONObject, View view, Activity activity) {
                f1437 = (f1438 + 15) % 128;
                m1757(m1756(new int[]{1113277572, -1906659739, -1150611741, -134688617, 1643176596, -371248464, -1971336628, 195214921}, View.combineMeasuredStates(0, 0) + 16).intern(), jSONObject, view, null, activity);
                int i2 = f1437 + 27;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final void mo331(JSONObject jSONObject, View view, Object obj, Activity activity) {
                int i2 = f1437 + 51;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    m1757(m1756(new int[]{1024306148, 1997946275, -1443411696, -1963181567, -2030207084, -44457224, -296588160, -1673859579, 1855018425, 1698288767}, TextUtils.indexOf((CharSequence) "", '/') + 3).intern(), jSONObject, view, obj, activity);
                } else {
                    m1757(m1756(new int[]{1024306148, 1997946275, -1443411696, -1963181567, -2030207084, -44457224, -296588160, -1673859579, 1855018425, 1698288767}, TextUtils.indexOf((CharSequence) "", '0') + 21).intern(), jSONObject, view, obj, activity);
                }
                f1437 = (f1438 + 83) % 128;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo293(JSONObject jSONObject, View view, Activity activity) {
                int i2 = f1437 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    m1757(m1756(new int[]{1113277572, -1906659739, -1150611741, -134688617, 2049615262, -1005931031}, TextUtils.indexOf("", "") + 89).intern(), jSONObject, view, null, activity);
                } else {
                    m1757(m1756(new int[]{1113277572, -1906659739, -1150611741, -134688617, 2049615262, -1005931031}, TextUtils.indexOf("", "") + 11).intern(), jSONObject, view, null, activity);
                }
            }

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m1756(int[] iArr, int i2) {
                String str;
                synchronized (com.ironsource.adqualitysdk.sdk.i.d.f1664) {
                    try {
                        char[] cArr = new char[4];
                        char[] cArr2 = new char[iArr.length << 1];
                        int[] iArr2 = (int[]) f1439.clone();
                        com.ironsource.adqualitysdk.sdk.i.d.f1665 = 0;
                        while (true) {
                            int i8 = com.ironsource.adqualitysdk.sdk.i.d.f1665;
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
                                com.ironsource.adqualitysdk.sdk.i.d.f1663 = (c7 << 16) + c8;
                                com.ironsource.adqualitysdk.sdk.i.d.f1666 = (c9 << 16) + c10;
                                com.ironsource.adqualitysdk.sdk.i.d.m1895(iArr2);
                                for (int i10 = 0; i10 < 16; i10++) {
                                    int i11 = com.ironsource.adqualitysdk.sdk.i.d.f1663 ^ iArr2[i10];
                                    com.ironsource.adqualitysdk.sdk.i.d.f1663 = i11;
                                    int iM1894 = com.ironsource.adqualitysdk.sdk.i.d.m1894(i11) ^ com.ironsource.adqualitysdk.sdk.i.d.f1666;
                                    int i12 = com.ironsource.adqualitysdk.sdk.i.d.f1663;
                                    com.ironsource.adqualitysdk.sdk.i.d.f1663 = iM1894;
                                    com.ironsource.adqualitysdk.sdk.i.d.f1666 = i12;
                                }
                                int i13 = com.ironsource.adqualitysdk.sdk.i.d.f1663;
                                int i14 = com.ironsource.adqualitysdk.sdk.i.d.f1666;
                                com.ironsource.adqualitysdk.sdk.i.d.f1663 = i14;
                                com.ironsource.adqualitysdk.sdk.i.d.f1666 = i13;
                                int i15 = i13 ^ iArr2[16];
                                com.ironsource.adqualitysdk.sdk.i.d.f1666 = i15;
                                int i16 = i14 ^ iArr2[17];
                                com.ironsource.adqualitysdk.sdk.i.d.f1663 = i16;
                                cArr[0] = (char) (i16 >>> 16);
                                cArr[1] = (char) i16;
                                cArr[2] = (char) (i15 >>> 16);
                                cArr[3] = (char) i15;
                                com.ironsource.adqualitysdk.sdk.i.d.m1895(iArr2);
                                int i17 = com.ironsource.adqualitysdk.sdk.i.d.f1665;
                                cArr2[i17 << 1] = cArr[0];
                                cArr2[(i17 << 1) + 1] = cArr[1];
                                cArr2[(i17 << 1) + 2] = cArr[2];
                                cArr2[(i17 << 1) + 3] = cArr[3];
                                com.ironsource.adqualitysdk.sdk.i.d.f1665 = i17 + 2;
                            } else {
                                str = new String(cArr2, 0, i2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            }

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private void m1757(String str, JSONObject jSONObject, View view, Object obj, Activity activity) {
                cp.m1682(cp.this, a0.d(new StringBuilder(), m1756(new int[]{-1238603757, 215876822, -1357773174, -903728930, 1304518563, 1838526319, 285993961, -1563441559}, 15 - ExpandableListView.getPackedPositionType(0L)), str), z2, false, Arrays.asList(jSONObject, view, obj, activity));
                int i2 = f1437 + 39;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.t
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo333(JSONObject jSONObject, View view, Object obj, Activity activity) {
                f1438 = (f1437 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                m1757(m1756(new int[]{139513171, 377327494, 1314956943, 1308315702, 2032367137, 873632352}, TextUtils.indexOf("", "", 0) + 9).intern(), jSONObject, view, obj, activity);
                int i2 = f1437 + 71;
                f1438 = i2 % 128;
                if (i2 % 2 != 0) {
                    int i8 = 2 / 0;
                }
            }
        };
        int i2 = f1390 + 67;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return tVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private jj m1697(final List<String> list) {
        jj jjVar = new jj() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.6

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f1465 = 1;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f1466;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static char[] f1468 = {'T', 171, 169, 164, 147, 154, 163, 166, 179, 171, 158, 163, 178, 154, 153, 176, 171, 171, 179, 180, 178, '7', 'n', 'W', 'R', 'k', 'n', 'o', 'o', 'n', 'v', '^', 'Z', 'k', 'c', 'j', 'l', 'd', '7', 'n', 'W', 'R', 'k', 'n', 'o', 'o', 'n', 'v', 'e', '[', 'l', 't', 'q', 'i', 'd', '2', 'd', 'o', 't', 'p', 's', 's', 'l', 'T', '^', 'v', 'n', 'o', 'o', 'n', 'k', 'R', 'W', 'n'};

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f1467 = 12;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private void m1769(String str, Activity activity) {
                f1465 = (f1466 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
                m1770(str, Collections.singletonList(activity));
                f1465 = (f1466 + 81) % 128;
            }

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public static /* synthetic */ void m1771(AnonymousClass6 anonymousClass6, String str, List list2) {
                int i2 = f1466 + 29;
                f1465 = i2 % 128;
                anonymousClass6.m1772(str, i2 % 2 == 0, (List<Object>) list2);
                int i8 = f1465 + 29;
                f1466 = i8 % 128;
                if (i8 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static String m1773(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
                String str2;
                Object bytes = str;
                if (str != null) {
                    bytes = str.getBytes("ISO-8859-1");
                }
                byte[] bArr = (byte[]) bytes;
                synchronized (g.f2126) {
                    try {
                        int i2 = iArr[0];
                        int i8 = iArr[1];
                        int i9 = iArr[2];
                        int i10 = iArr[3];
                        char[] cArr = new char[i8];
                        System.arraycopy(f1468, i2, cArr, 0, i8);
                        if (bArr != null) {
                            char[] cArr2 = new char[i8];
                            g.f2125 = 0;
                            char c7 = 0;
                            while (true) {
                                int i11 = g.f2125;
                                if (i11 >= i8) {
                                    break;
                                }
                                if (bArr[i11] == 1) {
                                    cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                                } else {
                                    cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                                }
                                c7 = cArr2[i11];
                                g.f2125 = i11 + 1;
                            }
                            cArr = cArr2;
                        }
                        if (i10 > 0) {
                            char[] cArr3 = new char[i8];
                            System.arraycopy(cArr, 0, cArr3, 0, i8);
                            int i12 = i8 - i10;
                            System.arraycopy(cArr3, 0, cArr, i12, i10);
                            System.arraycopy(cArr3, i10, cArr, 0, i12);
                        }
                        if (z2) {
                            char[] cArr4 = new char[i8];
                            g.f2125 = 0;
                            while (true) {
                                int i13 = g.f2125;
                                if (i13 >= i8) {
                                    break;
                                }
                                cArr4[i13] = cArr[(i8 - i13) - 1];
                                g.f2125 = i13 + 1;
                            }
                            cArr = cArr4;
                        }
                        if (i9 > 0) {
                            g.f2125 = 0;
                            while (true) {
                                int i14 = g.f2125;
                                if (i14 >= i8) {
                                    break;
                                }
                                cArr[i14] = (char) (cArr[i14] - iArr[2]);
                                g.f2125 = i14 + 1;
                            }
                        }
                        str2 = new String(cArr);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                int i2 = f1466 + 65;
                f1465 = i2 % 128;
                if (i2 % 2 == 0) {
                    cp.m1711(activity, list);
                    throw null;
                }
                if (cp.m1711(activity, list)) {
                    f1466 = (f1465 + 113) % 128;
                    m1774(m1773("\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001", false, new int[]{21, 17, 0, 0}).intern(), activity, bundle);
                }
                f1465 = (f1466 + 7) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
                int i2 = f1465 + 53;
                f1466 = i2 % 128;
                if (i2 % 2 != 0) {
                    cp.m1711(activity, list);
                    throw null;
                }
                if (cp.m1711(activity, list)) {
                    f1466 = (f1465 + 29) % 128;
                    m1769(m1773("\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001", true, new int[]{55, 19, 0, 0}).intern(), activity);
                    f1465 = (f1466 + 49) % 128;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity) {
                f1465 = (f1466 + 55) % 128;
                if (cp.m1711(activity, list)) {
                    f1466 = (f1465 + 61) % 128;
                    m1769(m1768(115 - TextUtils.lastIndexOf("", '0', 0), AndroidCharacter.getMirror('0') - ' ', "\f\u0001\u000e\u0001\f\u0011￨\ufff9\r\u000b�￼\u0007\u0006\uffd9\ufffb", 13 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), false).intern(), activity);
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                int i2 = f1465 + 79;
                f1466 = i2 % 128;
                if (i2 % 2 != 0) {
                    cp.m1711(activity, list);
                    throw null;
                }
                if (cp.m1711(activity, list)) {
                    m1769(m1773("\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0001", false, new int[]{38, 17, 0, 17}).intern(), activity);
                }
                int i8 = f1466 + 47;
                f1465 = i8 % 128;
                if (i8 % 2 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                f1466 = (f1465 + 15) % 128;
                if (cp.m1711(activity, list)) {
                    m1774(m1768((ViewConfiguration.getPressedStateDuration() >> 16) + 115, (ViewConfiguration.getWindowTouchSlop() >> 8) + 27, "￬\ufffe￼\u0007\ufffa\r\f\u0007￢\ufffe\u000f\ufffa￬\u0012\r\u0002\u000f\u0002\r￼ￚ\u0007\b\ufffe\r\ufffa\r", (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 24, true).intern(), activity, bundle);
                    f1466 = (f1465 + 71) % 128;
                }
                f1466 = (f1465 + 1) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity) {
                f1465 = (f1466 + 31) % 128;
                if (cp.m1711(activity, list)) {
                    int i2 = f1465 + 105;
                    f1466 = i2 % 128;
                    m1769((i2 % 2 != 0 ? m1768(Color.green(1) * 60, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE << TextUtils.getTrimmedLength(""), "\ufffb￼\u000b\t\ufff8\u000b￪\u0010\u000b\u0000\r\u0000\u000b\ufffa\uffd8\u0005\u0006", 44 - TextUtils.lastIndexOf("", (char) 16), false) : m1768(Color.green(0) + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE, TextUtils.getTrimmedLength("") + 17, "\ufffb￼\u000b\t\ufff8\u000b￪\u0010\u000b\u0000\r\u0000\u000b\ufffa\uffd8\u0005\u0006", TextUtils.lastIndexOf("", '0') + 18, true)).intern(), activity);
                }
                f1466 = (f1465 + 59) % 128;
            }

            /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onActivityStopped(android.app.Activity r7) {
                /*
                    r6 = this;
                    int r0 = com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1466
                    int r0 = r0 + 5
                    int r1 = r0 % 128
                    com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1465 = r1
                    int r0 = r0 % 2
                    r1 = 0
                    if (r0 != 0) goto L19
                    java.util.List r0 = r2
                    boolean r0 = com.ironsource.adqualitysdk.sdk.i.cp.m1711(r7, r0)
                    r2 = 55
                    int r2 = r2 / r1
                    if (r0 == 0) goto L72
                    goto L21
                L19:
                    java.util.List r0 = r2
                    boolean r0 = com.ironsource.adqualitysdk.sdk.i.cp.m1711(r7, r0)
                    if (r0 == 0) goto L72
                L21:
                    int r0 = com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1466
                    int r0 = r0 + 25
                    int r2 = r0 % 128
                    com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1465 = r2
                    int r0 = r0 % 2
                    java.lang.String r2 = "\u000b\u0000\r\u0000\u000b\u0010￪\u000b\u0006\u0007\u0007￼\ufffb\u0006\u0005\uffd8\ufffa"
                    r3 = 0
                    if (r0 != 0) goto L51
                    r0 = 1
                    int r4 = android.graphics.Color.blue(r0)
                    int r4 = r4 + 71
                    float r5 = android.media.AudioTrack.getMinVolume()
                    int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                    int r3 = r3 * 14
                    int r0 = android.graphics.drawable.Drawable.resolveOpacity(r1, r0)
                    int r0 = r0 * 9
                    java.lang.String r0 = m1768(r4, r3, r2, r0, r1)
                L49:
                    java.lang.String r0 = r0.intern()
                    r6.m1769(r0, r7)
                    goto L6a
                L51:
                    int r0 = android.graphics.Color.blue(r1)
                    int r0 = r0 + 117
                    float r4 = android.media.AudioTrack.getMinVolume()
                    int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                    int r3 = r3 + 17
                    int r4 = android.graphics.drawable.Drawable.resolveOpacity(r1, r1)
                    int r4 = 13 - r4
                    java.lang.String r0 = m1768(r0, r3, r2, r4, r1)
                    goto L49
                L6a:
                    int r7 = com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1465
                    int r7 = r7 + 13
                    int r7 = r7 % 128
                    com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1466 = r7
                L72:
                    int r7 = com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1465
                    int r7 = r7 + 57
                    int r0 = r7 % 128
                    com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.f1466 = r0
                    int r7 = r7 % 2
                    if (r7 != 0) goto L7f
                    return
                L7f:
                    r7 = 0
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cp.AnonymousClass6.onActivityStopped(android.app.Activity):void");
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, com.ironsource.adqualitysdk.sdk.i.jg
            /* JADX INFO: renamed from: ﾒ */
            public final void mo484(Activity activity) {
                int i2 = f1465 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
                f1466 = i2 % 128;
                m1769((i2 % 2 != 0 ? m1768(36 % TextUtils.getCapsMode("", 1, 1), (ViewConfiguration.getJumpTapTimeout() >>> 40) * 16, "\u000b\u000e\r\ufffe￫\t\tￚ\u0007\b�\u0007\u000e\b\u000b\u0000\ufffe\u000b\b\uffdf\b￭�\ufffe\u0007", (-16777206) / Color.rgb(0, 1, 1), false) : m1768(TextUtils.getCapsMode("", 0, 0) + 115, 25 - (ViewConfiguration.getJumpTapTimeout() >> 16), "\u000b\u000e\r\ufffe￫\t\tￚ\u0007\b�\u0007\u000e\b\u000b\u0000\ufffe\u000b\b\uffdf\b￭�\ufffe\u0007", (-16777206) - Color.rgb(0, 0, 0), true)).intern(), activity);
            }

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private void m1770(final String str, final List<Object> list2) {
                m1772(str, true, list2);
                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.6.5
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        AnonymousClass6.m1771(AnonymousClass6.this, str, list2);
                    }
                });
                int i2 = f1465 + 29;
                f1466 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private void m1774(String str, Activity activity, Bundle bundle) {
                List<Object> listAsList;
                int i2 = f1466 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f1465 = i2 % 128;
                if (i2 % 2 == 0) {
                    Object[] objArr = new Object[4];
                    objArr[0] = activity;
                    objArr[0] = bundle;
                    listAsList = Arrays.asList(objArr);
                } else {
                    listAsList = Arrays.asList(activity, bundle);
                }
                m1770(str, listAsList);
                int i8 = f1465 + 29;
                f1466 = i8 % 128;
                if (i8 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, com.ironsource.adqualitysdk.sdk.i.jg
            /* JADX INFO: renamed from: ｋ */
            public final void mo483(Activity activity) {
                int i2 = f1465 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f1466 = i2 % 128;
                m1769((i2 % 2 != 0 ? m1773("\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001", false, new int[]{0, 21, 66, 16}) : m1773("\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001", true, new int[]{0, 21, 66, 16})).intern(), activity);
                int i8 = f1466 + 115;
                f1465 = i8 % 128;
                if (i8 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private void m1772(String str, boolean z2, List<Object> list2) {
                cp.m1682(cp.this, a0.d(new StringBuilder(), m1768(113 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), View.MeasureSpec.getSize(0) + 18, "\u0005\u0012\u0005\u0010\u0015￨\u0005\u0002\u0001\uffff\u0015\uffff\b\u0001ￊ\uffdd\uffff\u0010", 15 - TextUtils.getCapsMode("", 0, 0), false), str), z2, false, list2);
                int i2 = f1466 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
                f1465 = i2 % 128;
                if (i2 % 2 == 0) {
                    int i8 = 81 / 0;
                }
            }

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m1768(int i2, int i8, String str, int i9, boolean z2) {
                String str2;
                Object charArray = str;
                if (str != null) {
                    charArray = str.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (com.ironsource.adqualitysdk.sdk.i.e.f1927) {
                    try {
                        char[] cArr2 = new char[i8];
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                        while (true) {
                            int i10 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                            if (i10 >= i8) {
                                break;
                            }
                            com.ironsource.adqualitysdk.sdk.i.e.f1929 = cArr[i10];
                            cArr2[com.ironsource.adqualitysdk.sdk.i.e.f1926] = (char) (com.ironsource.adqualitysdk.sdk.i.e.f1929 + i2);
                            int i11 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                            cArr2[i11] = (char) (cArr2[i11] - f1467);
                            com.ironsource.adqualitysdk.sdk.i.e.f1926 = i11 + 1;
                        }
                        if (i9 > 0) {
                            com.ironsource.adqualitysdk.sdk.i.e.f1928 = i9;
                            char[] cArr3 = new char[i8];
                            System.arraycopy(cArr2, 0, cArr3, 0, i8);
                            int i12 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                            System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                            int i13 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                            System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                        }
                        if (z2) {
                            char[] cArr4 = new char[i8];
                            com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                            while (true) {
                                int i14 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                                if (i14 >= i8) {
                                    break;
                                }
                                cArr4[i14] = cArr2[(i8 - i14) - 1];
                                com.ironsource.adqualitysdk.sdk.i.e.f1926 = i14 + 1;
                            }
                            cArr2 = cArr4;
                        }
                        str2 = new String(cArr2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        };
        int i2 = f1391 + 31;
        f1390 = i2 % 128;
        if (i2 % 2 == 0) {
            return jjVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private x m1704(final x xVar, final x xVar2) {
        if (xVar == null) {
            xVar = new x();
            f1391 = (f1390 + 65) % 128;
        }
        if (xVar2 == null) {
            xVar2 = new x();
            f1391 = (f1390 + 93) % 128;
        }
        return new x() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo293(JSONObject jSONObject, WebView webView, View view) {
                xVar2.mo293(jSONObject, webView, view);
                p.m2964(new e.AnonymousClass1(xVar, jSONObject, webView, view));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final void mo296(JSONObject jSONObject, WebView webView, View view) {
                xVar2.mo296(jSONObject, webView, view);
                p.m2964(new a.AnonymousClass3(xVar, jSONObject, webView, view));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final void mo328(JSONObject jSONObject, WebView webView, View view) {
                xVar2.mo328(jSONObject, webView, view);
                p.m2964(new i.AnonymousClass2(xVar, jSONObject, webView, view));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo330(JSONObject jSONObject, WebView webView, View view) {
                xVar2.mo330(jSONObject, webView, view);
                p.m2964(new c.AnonymousClass2(xVar, jSONObject, webView, view));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo333(JSONObject jSONObject, WebView webView, Object obj, View view) {
                xVar2.mo333(jSONObject, webView, obj, view);
                p.m2964(new d.AnonymousClass5(xVar, jSONObject, webView, obj, view));
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo329(JSONObject jSONObject, WebView webView, Object obj, View view) {
                xVar2.mo329(jSONObject, webView, obj, view);
                p.m2964(new b.AnonymousClass4(xVar, jSONObject, webView, obj, view));
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final void mo331(JSONObject jSONObject, WebView webView, Object obj, View view) {
                xVar2.mo331(jSONObject, webView, obj, view);
                p.m2964(new f.AnonymousClass4(xVar, jSONObject, webView, obj, view));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo332(JSONObject jSONObject, WebView webView, View view) {
                xVar2.mo332(jSONObject, webView, view);
                p.m2964(new h.AnonymousClass3(xVar, jSONObject, webView, view));
            }
        };
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m1702(String str) {
        f1390 = (f1391 + 105) % 128;
        boolean zEndsWith = str.endsWith(m1691("킍킣̧︁橼剭邚◪ꗃ\uf10d", 1 - View.getDefaultSize(0, 0)).intern());
        f1390 = (f1391 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        return zEndsWith;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private x m1699(final boolean z2) {
        x xVar = new x() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.14

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static byte[] f1428 = {-103, -1, -20, 24, -11, -4, -3, 10, 37, -32, 3, -98, -17, -2, -4, 51, -31, -1, -20, 24, -11, -4, -3, 10, 37, -32, 3, -105, -1, -6, 8, -6, -3, 41, -33, 3, -99, 41, -35, -2, -3, 44, -30, -1, -6, 8, -6, -3, 41, -33, 3, -106, -1, -14, 4, 3, 41, -33, 3, -102, -1, -3, 5, 2, -19, 0, 51, -54, 18, -4, -13, -94, 6, 9, -17, 49, -47, 6, 9, -4, -3, 41, -34, -8, -2, -3, 10, 37, -31, -3, -18, -103, 6, 9, -17, 49, -40, -2, -5, 1, -2, 18, -97, -68, 13, -9, 9, -15, 1, 10, 29, -24, 35, -54, 8, 11, -10, 5, 18};

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static int f1429 = 1;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f1430 = 0;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static short[] f1431 = null;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f1432 = -295393330;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int f1433 = 780639299;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f1434 = 114;

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final /* bridge */ /* synthetic */ void mo328(JSONObject jSONObject, WebView webView, View view) {
                int i2 = f1429 + 105;
                f1430 = i2 % 128;
                int i8 = i2 % 2;
                mo328(jSONObject, webView, view);
                if (i8 != 0) {
                    int i9 = 78 / 0;
                }
                int i10 = f1430 + 65;
                f1429 = i10 % 128;
                if (i10 % 2 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ */
            public final /* synthetic */ void mo330(JSONObject jSONObject, WebView webView, View view) {
                int i2 = f1430 + 103;
                f1429 = i2 % 128;
                int i8 = i2 % 2;
                mo330(jSONObject, webView, view);
                if (i8 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ void mo293(JSONObject jSONObject, WebView webView, View view) {
                int i2 = f1430 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f1429 = i2 % 128;
                int i8 = i2 % 2;
                mo293(jSONObject, webView, view);
                if (i8 == 0) {
                    throw null;
                }
                int i9 = f1430 + 29;
                f1429 = i9 % 128;
                if (i9 % 2 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ */
            public final /* synthetic */ void mo296(JSONObject jSONObject, WebView webView, View view) {
                int i2 = f1429 + 99;
                f1430 = i2 % 128;
                int i8 = i2 % 2;
                mo296(jSONObject, webView, view);
                if (i8 != 0) {
                    throw null;
                }
                int i9 = f1429 + 55;
                f1430 = i9 % 128;
                if (i9 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final /* synthetic */ void mo332(JSONObject jSONObject, WebView webView, View view) {
                int i2 = f1429 + 47;
                f1430 = i2 % 128;
                int i8 = i2 % 2;
                mo332(jSONObject, webView, view);
                if (i8 != 0) {
                    throw null;
                }
                int i9 = f1430 + 79;
                f1429 = i9 % 128;
                if (i9 % 2 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ void mo329(JSONObject jSONObject, WebView webView, Object obj, View view) {
                int i2 = f1430 + 109;
                f1429 = i2 % 128;
                int i8 = i2 % 2;
                mo329(jSONObject, webView, obj, view);
                if (i8 == 0) {
                    throw null;
                }
                int i9 = f1430 + 13;
                f1429 = i9 % 128;
                if (i9 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﻛ */
            public final void mo293(JSONObject jSONObject, WebView webView, View view) {
                f1430 = (f1429 + 59) % 128;
                m1755(m1754((-115) - ExpandableListView.getPackedPositionType(0L), (short) (Color.rgb(0, 0, 0) + 16777216), (-780639299) - TextUtils.getOffsetBefore("", 0), (byte) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 295393427).intern(), jSONObject, webView, null, view);
                f1430 = (f1429 + 77) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ void mo331(JSONObject jSONObject, WebView webView, Object obj, View view) {
                f1430 = (f1429 + 33) % 128;
                mo331(jSONObject, webView, obj, view);
                f1429 = (f1430 + 33) % 128;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﾇ */
            public final void mo296(JSONObject jSONObject, WebView webView, View view) {
                f1429 = (f1430 + 35) % 128;
                m1755(m1754((-115) - (ViewConfiguration.getTapTimeout() >> 16), (short) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (-780639289) - TextUtils.indexOf((CharSequence) "", '0', 0), (byte) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 295393428 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))).intern(), jSONObject, webView, null, view);
                int i2 = f1429 + 1;
                f1430 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final /* synthetic */ void mo333(JSONObject jSONObject, WebView webView, Object obj, View view) {
                f1430 = (f1429 + 19) % 128;
                mo333(jSONObject, webView, obj, view);
                int i2 = f1429 + 41;
                f1430 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﻐ */
            public final void mo328(JSONObject jSONObject, WebView webView, View view) {
                f1430 = (f1429 + 49) % 128;
                m1755(m1754(((byte) KeyEvent.getModifierMetaStateMask()) - 114, (short) (ViewConfiguration.getWindowTouchSlop() >> 8), ExpandableListView.getPackedPositionType(0L) - 780639240, (byte) ((-1) - Process.getGidForName("")), 295393448 - Gravity.getAbsoluteGravity(0, 0)).intern(), jSONObject, webView, null, view);
                int i2 = f1430 + 79;
                f1429 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﻛ */
            public final void mo329(JSONObject jSONObject, WebView webView, Object obj, View view) {
                f1430 = (f1429 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
                m1755(m1754((-115) - (ViewConfiguration.getEdgeSlop() >> 16), (short) TextUtils.getCapsMode("", 0, 0), KeyEvent.keyCodeFromString("") - 780639263, (byte) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), View.MeasureSpec.getMode(0) + 295393427).intern(), jSONObject, webView, obj, view);
                int i2 = f1429 + 63;
                f1430 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ｋ */
            public final void mo330(JSONObject jSONObject, WebView webView, View view) {
                f1429 = (f1430 + 105) % 128;
                m1755(m1754(View.MeasureSpec.getMode(0) - 115, (short) (ExpandableListView.getPackedPositionChild(0L) + 1), Color.argb(0, 0, 0, 0) - 780639248, (byte) (ViewConfiguration.getKeyRepeatDelay() >> 16), 295393427 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern(), jSONObject, webView, null, view);
                f1430 = (f1429 + 81) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﾇ */
            public final void mo331(JSONObject jSONObject, WebView webView, Object obj, View view) {
                f1430 = (f1429 + 103) % 128;
                m1755(m1754(ImageFormat.getBitsPerPixel(0) - 114, (short) (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.lastIndexOf("", '0', 0) - 780639227, (byte) (Color.rgb(0, 0, 0) + 16777216), 295393449 - View.resolveSizeAndState(0, 0, 0)).intern(), jSONObject, webView, obj, view);
                int i2 = f1429 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f1430 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﾒ */
            public final void mo333(JSONObject jSONObject, WebView webView, Object obj, View view) {
                f1430 = (f1429 + 77) % 128;
                m1755(m1754((-115) - (ViewConfiguration.getEdgeSlop() >> 16), (short) (TextUtils.lastIndexOf("", '0', 0) + 1), (-780639273) - TextUtils.lastIndexOf("", '0'), (byte) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 295393428).intern(), jSONObject, webView, obj, view);
                int i2 = f1429 + 71;
                f1430 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static String m1754(int i2, short s7, int i8, byte b8, int i9) {
                String string;
                synchronized (n.f2979) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int i10 = f1434;
                        int i11 = i2 + i10;
                        int i12 = i11 == -1 ? 1 : 0;
                        if (i12 != 0) {
                            byte[] bArr = f1428;
                            if (bArr != null) {
                                i11 = (byte) (bArr[f1433 + i8] + i10);
                            } else {
                                i11 = (short) (f1431[f1433 + i8] + i10);
                            }
                        }
                        if (i11 > 0) {
                            n.f2984 = ((i8 + i11) - 2) + f1433 + i12;
                            n.f2982 = b8;
                            char c7 = (char) (i9 + f1432);
                            n.f2981 = c7;
                            sb.append(c7);
                            n.f2980 = n.f2981;
                            n.f2983 = 1;
                            while (n.f2983 < i11) {
                                byte[] bArr2 = f1428;
                                if (bArr2 != null) {
                                    int i13 = n.f2984;
                                    n.f2984 = i13 - 1;
                                    n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                                } else {
                                    short[] sArr = f1431;
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

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.x
            /* JADX INFO: renamed from: ﾒ */
            public final void mo332(JSONObject jSONObject, WebView webView, View view) {
                f1429 = (f1430 + 73) % 128;
                m1755(m1754((-115) - (ViewConfiguration.getTapTimeout() >> 16), (short) (ViewConfiguration.getTouchSlop() >> 8), (-780639209) - Process.getGidForName(""), (byte) (KeyEvent.getMaxKeyCode() >> 16), 295393429 - TextUtils.indexOf("", "")).intern(), jSONObject, webView, null, view);
                int i2 = f1429 + 69;
                f1430 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private void m1755(String str, JSONObject jSONObject, WebView webView, Object obj, View view) {
                cp.m1682(cp.this, a0.d(new StringBuilder(), m1754((-115) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (short) ExpandableListView.getPackedPositionType(0L), (-780639197) - TextUtils.getTrimmedLength(""), (byte) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), Drawable.resolveOpacity(0, 0) + 295393417), str), z2, false, Arrays.asList(jSONObject, webView, obj, view));
                int i2 = f1430 + 69;
                f1429 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }
        };
        f1391 = (f1390 + 43) % 128;
        return xVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private l m1698(final l lVar, final l lVar2) {
        int i2 = f1391 + 71;
        f1390 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (lVar == null) {
            lVar = new l();
        }
        if (lVar2 == null) {
            lVar2 = new l();
            f1390 = (f1391 + 11) % 128;
        }
        return new l() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.12
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ */
            public final void mo296(JSONObject jSONObject, WebView webView, Activity activity) {
                lVar2.mo296(jSONObject, webView, activity);
                p.m2964(new a.AnonymousClass3(lVar, jSONObject, webView, activity));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ */
            public final void mo332(JSONObject jSONObject, WebView webView, Activity activity) {
                lVar2.mo332(jSONObject, webView, activity);
                p.m2964(new h.AnonymousClass3(lVar, jSONObject, webView, activity));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final void mo328(JSONObject jSONObject, WebView webView, Activity activity) {
                lVar2.mo328(jSONObject, webView, activity);
                p.m2964(new i.AnonymousClass2(lVar, jSONObject, webView, activity));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final void mo333(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                lVar2.mo333(jSONObject, webView, obj, activity);
                p.m2964(new d.AnonymousClass5(lVar, jSONObject, webView, obj, activity));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final void mo293(JSONObject jSONObject, WebView webView, Activity activity) {
                lVar2.mo293(jSONObject, webView, activity);
                p.m2964(new e.AnonymousClass1(lVar, jSONObject, webView, activity));
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ */
            public final void mo329(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                lVar2.mo329(jSONObject, webView, obj, activity);
                p.m2964(new b.AnonymousClass4(lVar, jSONObject, webView, obj, activity));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final void mo330(JSONObject jSONObject, WebView webView, Activity activity) {
                lVar2.mo330(jSONObject, webView, activity);
                p.m2964(new c.AnonymousClass2(lVar, jSONObject, webView, activity));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final void mo331(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                lVar2.mo331(jSONObject, webView, obj, activity);
                p.m2964(new f.AnonymousClass4(lVar, jSONObject, webView, obj, activity));
            }
        };
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m1709(final String str, final List<Object> list) {
        p.m2964(new im() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.5
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                cp.m1682(cp.this, str, false, false, list);
            }
        });
        p.m2967(new im() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.7
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                cp.m1682(cp.this, str, true, false, list);
            }
        });
        m1708(new im() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.8
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                cp.m1682(cp.this, str, false, true, list);
            }
        }, true);
        f1391 = (f1390 + 71) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m1708(final im imVar, boolean z2) {
        try {
            if (z2) {
                p.m2969(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.10
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        p.m2963(imVar);
                    }
                });
                int i2 = f1390 + 1;
                f1391 = i2 % 128;
                if (i2 % 2 == 0) {
                    int i8 = 81 / 0;
                    return;
                }
                return;
            }
            p.m2963(imVar);
            int i9 = f1391 + 65;
            f1390 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private JSONObject m1700(Activity activity, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ig.f2524, m1730().m1666());
            jSONObject.put(ig.f2480, m1730().m1669());
            jSONObject.put(ig.f2481, m1730().m1663());
            jSONObject.put(m1705((String) null, ExpandableListView.getPackedPositionChild(0L) + 128, (int[]) null, "\u0082\u0083\u008e\u009c\u0085\u0091\u008e").intern(), activity.getClass().getName());
            if (bundle != null) {
                int i2 = f1391 + 59;
                f1390 = i2 % 128;
                if (i2 % 2 != 0) {
                    jSONObject.put(m1691("䃤䂅酣汅탼疶⨂떄航捛엨溬", -(ExpandableListView.getPackedPositionForChild(1, 1) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(1, 1) == 0L ? 0 : -1))).intern(), false);
                } else {
                    jSONObject.put(m1691("䃤䂅酣汅탼疶⨂떄航捛엨溬", -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern(), true);
                }
            }
        } catch (JSONException unused) {
            k.m2863(m1705((String) null, 127 - KeyEvent.getDeadChar(0, 0), (int[]) null, "\u008c\u0082\u008b\u0082\u0085\u008a\u0089\u0088\u0087\u0086\u0082\u0085\u0084\u0083\u0082\u0081").intern(), m1691("痊疏\ue525᠒ᆬ၈\ueb54肬\ue7e8\u175cҩ\u0b79龇ȩྒٶꪘ㧃㊲もꇹ㓄▮⮝볝⏣⣔⛻쯝建刼凊옥喀", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1).intern());
        }
        int i8 = f1391 + 35;
        f1390 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 13 / 0;
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String m1713(String str) {
        Class clsM884;
        int i2 = f1391 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f1390 = i2 % 128;
        if (i2 % 2 != 0) {
            bg bgVarM1733 = m1733();
            ViewConfiguration.getScrollDefaultDelay();
            clsM884 = bgVarM1733.m884(ka.m2882(str, m1691("킍킣̧︁橼剭邚◪ꗃ\uf10d", 0).intern()));
            if (clsM884 == null) {
                return null;
            }
        } else {
            clsM884 = m1733().m884(ka.m2882(str, m1691("킍킣̧︁橼剭邚◪ꗃ\uf10d", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1).intern()));
            if (clsM884 == null) {
                return null;
            }
        }
        String name = clsM884.getName();
        f1390 = (f1391 + 37) % 128;
        return name;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean m1696(Activity activity, List<String> list) {
        int i2 = f1390 + 17;
        f1391 = i2 % 128;
        if (i2 % 2 == 0) {
            list.isEmpty();
            throw null;
        }
        if (!list.isEmpty() && !list.contains(activity.getClass().getName())) {
            return false;
        }
        int i8 = f1391 + 33;
        f1390 = i8 % 128;
        if (i8 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private List<String> m1692(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (m1702(str)) {
                f1390 = (f1391 + 115) % 128;
                String strM1713 = m1713(str);
                if (strM1713 != null) {
                    int i2 = f1391 + 33;
                    f1390 = i2 % 128;
                    if (i2 % 2 != 0) {
                        arrayList.add(strM1713);
                        int i8 = 2 / 0;
                    } else {
                        arrayList.add(strM1713);
                    }
                }
            } else {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1705(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
        Object bytes = str2;
        if (str2 != null) {
            bytes = str2.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (m.f2978) {
            try {
                char[] cArr2 = f1392;
                int i8 = f1394;
                if (f1395) {
                    int length = bArr.length;
                    m.f2976 = length;
                    char[] cArr3 = new char[length];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i9 = m.f2977;
                        int i10 = m.f2976 - 1;
                        int i11 = m.f2977;
                        cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                        m.f2977 = i11 + 1;
                    }
                    return new String(cArr3);
                }
                if (f1396) {
                    int length2 = cArr.length;
                    m.f2976 = length2;
                    char[] cArr4 = new char[length2];
                    m.f2977 = 0;
                    while (m.f2977 < m.f2976) {
                        int i12 = m.f2977;
                        int i13 = m.f2976 - 1;
                        int i14 = m.f2977;
                        cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                        m.f2977 = i14 + 1;
                    }
                    return new String(cArr4);
                }
                int length3 = iArr.length;
                m.f2976 = length3;
                char[] cArr5 = new char[length3];
                m.f2977 = 0;
                while (m.f2977 < m.f2976) {
                    int i15 = m.f2977;
                    int i16 = m.f2976 - 1;
                    int i17 = m.f2977;
                    cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                    m.f2977 = i17 + 1;
                }
                return new String(cArr5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private jo m1712(final List<String> list) {
        jo joVar = new jo() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.4

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static int f1451 = 1;

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static int f1452 = 0;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static boolean f1453 = true;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f1454 = 271;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static boolean f1455 = true;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static char[] f1456 = {382, 381, 341, 370, 388, 386, 347, 387, 353, 372, 385, 371, 336, 383, 376, 317};

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private void m1767(String str, final Activity activity, List<String> list2) {
                f1452 = (f1451 + 19) % 128;
                if (cp.m1711(activity, list2)) {
                    final String strD = a0.d(new StringBuilder(), m1766(null, 127 - (ViewConfiguration.getScrollBarSize() >> 8), null, "\u0090\u008b\u008a\u0082\u008a\u0088\u0086\u008f\u0087\u0086\u0085\u0084\u0081\u0083\u008e\u008e\u008d"), str);
                    cp.m1682(cp.this, strD, true, false, Collections.singletonList(activity));
                    p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.4.2
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            cp.m1682(cp.this, strD, false, false, Collections.singletonList(activity));
                        }
                    });
                    f1452 = (f1451 + 31) % 128;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jo
            /* JADX INFO: renamed from: ﻛ */
            public final void mo471(Activity activity) {
                int i2 = f1451 + 107;
                f1452 = i2 % 128;
                m1767(m1766(null, i2 % 2 != 0 ? 6 >>> TextUtils.getCapsMode("", 1, 0) : TextUtils.getCapsMode("", 0, 0) + 127, null, "\u008c\u008a\u008b\u0081\u0088\u0086\u008a\u0089\u0086\u0085\u0084\u0081\u0083\u0082\u0081").intern(), activity, list);
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jo
            /* JADX INFO: renamed from: ｋ */
            public final void mo472(Activity activity) {
                int i2 = f1452 + 85;
                f1451 = i2 % 128;
                m1767(m1766(null, i2 % 2 == 0 ? 55 - TextUtils.getOffsetBefore("", 1) : TextUtils.getOffsetBefore("", 0) + 127, null, "\u0088\u0086\u0081\u0087\u0086\u0085\u0084\u0081\u0083\u0082\u0081").intern(), activity, list);
            }

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static String m1766(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
                Object bytes = str2;
                if (str2 != null) {
                    bytes = str2.getBytes("ISO-8859-1");
                }
                byte[] bArr = (byte[]) bytes;
                Object charArray = str;
                if (str != null) {
                    charArray = str.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (m.f2978) {
                    try {
                        char[] cArr2 = f1456;
                        int i8 = f1454;
                        if (f1453) {
                            int length = bArr.length;
                            m.f2976 = length;
                            char[] cArr3 = new char[length];
                            m.f2977 = 0;
                            while (m.f2977 < m.f2976) {
                                int i9 = m.f2977;
                                int i10 = m.f2976 - 1;
                                int i11 = m.f2977;
                                cArr3[i9] = (char) (cArr2[bArr[i10 - i11] + i2] - i8);
                                m.f2977 = i11 + 1;
                            }
                            return new String(cArr3);
                        }
                        if (f1455) {
                            int length2 = cArr.length;
                            m.f2976 = length2;
                            char[] cArr4 = new char[length2];
                            m.f2977 = 0;
                            while (m.f2977 < m.f2976) {
                                int i12 = m.f2977;
                                int i13 = m.f2976 - 1;
                                int i14 = m.f2977;
                                cArr4[i12] = (char) (cArr2[cArr[i13 - i14] - i2] - i8);
                                m.f2977 = i14 + 1;
                            }
                            return new String(cArr4);
                        }
                        int length3 = iArr.length;
                        m.f2976 = length3;
                        char[] cArr5 = new char[length3];
                        m.f2977 = 0;
                        while (m.f2977 < m.f2976) {
                            int i15 = m.f2977;
                            int i16 = m.f2976 - 1;
                            int i17 = m.f2977;
                            cArr5[i15] = (char) (cArr2[iArr[i16 - i17] - i2] - i8);
                            m.f2977 = i17 + 1;
                        }
                        return new String(cArr5);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        };
        int i2 = f1390 + 39;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return joVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m1725(String str, List<Object> list) {
        m1709(a0.d(new StringBuilder(), m1705((String) null, 127 - Color.alpha(0), (int[]) null, "\u008d\u0085\u008a\u008e\u0091\u0087\u008e\u0084\u008c¡\u008e\u008f\u0083\u0084\u0084 "), str), list);
        int i2 = f1391 + 103;
        f1390 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private l m1689(final boolean z2) {
        l lVar = new l() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.11

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int[] f1417 = {786615364, -472032777, 1109367275, 1723318077, -725493527, 967523925, -1072313284, -1928970602, -939548095, -1846819537, -1188424576, 359712903, -2086425615, -1469519809, -755670154, 1296563246, -10242547, 340176911};

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int f1418 = 1;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f1419;

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ void mo328(JSONObject jSONObject, WebView webView, Activity activity) {
                f1419 = (f1418 + 51) % 128;
                mo328(jSONObject, webView, activity);
                int i2 = f1419 + 11;
                f1418 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻛ */
            public final /* synthetic */ void mo330(JSONObject jSONObject, WebView webView, Activity activity) {
                int i2 = f1418 + 111;
                f1419 = i2 % 128;
                int i8 = i2 % 2;
                mo330(jSONObject, webView, activity);
                if (i8 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ void mo293(JSONObject jSONObject, WebView webView, Activity activity) {
                f1419 = (f1418 + 89) % 128;
                mo293(jSONObject, webView, activity);
                int i2 = f1418 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
                f1419 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾇ */
            public final /* synthetic */ void mo296(JSONObject jSONObject, WebView webView, Activity activity) {
                f1419 = (f1418 + 33) % 128;
                mo296(jSONObject, webView, activity);
                f1419 = (f1418 + 115) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final /* synthetic */ void mo332(JSONObject jSONObject, WebView webView, Activity activity) {
                int i2 = f1418 + 87;
                f1419 = i2 % 128;
                int i8 = i2 % 2;
                mo332(jSONObject, webView, activity);
                if (i8 != 0) {
                    throw null;
                }
                int i9 = f1418 + 111;
                f1419 = i9 % 128;
                if (i9 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ void mo329(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                f1418 = (f1419 + 51) % 128;
                mo329(jSONObject, webView, obj, activity);
                int i2 = f1419 + 35;
                f1418 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo296(JSONObject jSONObject, WebView webView, Activity activity) {
                int i2 = f1419 + 11;
                f1418 = i2 % 128;
                if (i2 % 2 == 0) {
                    m1737(m1736(new int[]{1357838378, -1853293199, 469173052, 1470295177, -1162877648, -1381495202, 1601253815, -256076300}, 35 % (ViewConfiguration.getScrollBarSize() * 7)).intern(), jSONObject, webView, null, activity);
                } else {
                    m1737(m1736(new int[]{1357838378, -1853293199, 469173052, 1470295177, -1162877648, -1381495202, 1601253815, -256076300}, 16 - (ViewConfiguration.getScrollBarSize() >> 8)).intern(), jSONObject, webView, null, activity);
                }
                f1419 = (f1418 + 59) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ｋ */
            public final /* synthetic */ void mo331(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                int i2 = f1419 + 35;
                f1418 = i2 % 128;
                int i8 = i2 % 2;
                mo331(jSONObject, webView, obj, activity);
                if (i8 == 0) {
                    throw null;
                }
                int i9 = f1418 + 45;
                f1419 = i9 % 128;
                if (i9 % 2 != 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final void mo332(JSONObject jSONObject, WebView webView, Activity activity) {
                int i2 = f1418 + 113;
                f1419 = i2 % 128;
                if (i2 % 2 != 0) {
                    m1737(m1736(new int[]{-1516270676, -1928781424, 1876101690, -362300530, -464785761, 506388420}, 'b' << AndroidCharacter.getMirror('N')).intern(), jSONObject, webView, null, activity);
                } else {
                    m1737(m1736(new int[]{-1516270676, -1928781424, 1876101690, -362300530, -464785761, 506388420}, AndroidCharacter.getMirror('0') - '%').intern(), jSONObject, webView, null, activity);
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l, com.ironsource.adqualitysdk.sdk.i.s
            /* JADX INFO: renamed from: ﾒ */
            public final /* synthetic */ void mo333(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                int i2 = f1419 + 107;
                f1418 = i2 % 128;
                int i8 = i2 % 2;
                mo333(jSONObject, webView, obj, activity);
                if (i8 == 0) {
                    throw null;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final void mo328(JSONObject jSONObject, WebView webView, Activity activity) {
                f1418 = (f1419 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
                m1737(m1736(new int[]{-96249618, -50214201, 1006999522, 242250734, 1932703387, -1243294797}, 13 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))).intern(), jSONObject, webView, null, activity);
                int i2 = f1418 + 105;
                f1419 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo329(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                f1419 = (f1418 + 89) % 128;
                m1737(m1736(new int[]{1478436806, 1188496500, -845490914, 1823411676, 714861733, 1668544432, -1356157074, 1673633120}, 15 - Color.argb(0, 0, 0, 0)).intern(), jSONObject, webView, obj, activity);
                int i2 = f1419 + 53;
                f1418 = i2 % 128;
                if (i2 % 2 == 0) {
                    int i8 = 2 / 0;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo333(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                f1419 = (f1418 + 55) % 128;
                m1737(m1736(new int[]{1478436806, 1188496500, -845490914, 1823411676, 1126080345, 1599616371}, 9 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern(), jSONObject, webView, obj, activity);
                f1418 = (f1419 + 63) % 128;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo293(JSONObject jSONObject, WebView webView, Activity activity) {
                f1419 = (f1418 + 63) % 128;
                m1737(m1736(new int[]{1357838378, -1853293199, 469173052, 1470295177, -2140951976, 311481332}, 11 - Color.blue(0)).intern(), jSONObject, webView, null, activity);
                int i2 = f1419 + 109;
                f1418 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static String m1736(int[] iArr, int i2) {
                String str;
                synchronized (com.ironsource.adqualitysdk.sdk.i.d.f1664) {
                    try {
                        char[] cArr = new char[4];
                        char[] cArr2 = new char[iArr.length << 1];
                        int[] iArr2 = (int[]) f1417.clone();
                        com.ironsource.adqualitysdk.sdk.i.d.f1665 = 0;
                        while (true) {
                            int i8 = com.ironsource.adqualitysdk.sdk.i.d.f1665;
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
                                com.ironsource.adqualitysdk.sdk.i.d.f1663 = (c7 << 16) + c8;
                                com.ironsource.adqualitysdk.sdk.i.d.f1666 = (c9 << 16) + c10;
                                com.ironsource.adqualitysdk.sdk.i.d.m1895(iArr2);
                                for (int i10 = 0; i10 < 16; i10++) {
                                    int i11 = com.ironsource.adqualitysdk.sdk.i.d.f1663 ^ iArr2[i10];
                                    com.ironsource.adqualitysdk.sdk.i.d.f1663 = i11;
                                    int iM1894 = com.ironsource.adqualitysdk.sdk.i.d.m1894(i11) ^ com.ironsource.adqualitysdk.sdk.i.d.f1666;
                                    int i12 = com.ironsource.adqualitysdk.sdk.i.d.f1663;
                                    com.ironsource.adqualitysdk.sdk.i.d.f1663 = iM1894;
                                    com.ironsource.adqualitysdk.sdk.i.d.f1666 = i12;
                                }
                                int i13 = com.ironsource.adqualitysdk.sdk.i.d.f1663;
                                int i14 = com.ironsource.adqualitysdk.sdk.i.d.f1666;
                                com.ironsource.adqualitysdk.sdk.i.d.f1663 = i14;
                                com.ironsource.adqualitysdk.sdk.i.d.f1666 = i13;
                                int i15 = i13 ^ iArr2[16];
                                com.ironsource.adqualitysdk.sdk.i.d.f1666 = i15;
                                int i16 = i14 ^ iArr2[17];
                                com.ironsource.adqualitysdk.sdk.i.d.f1663 = i16;
                                cArr[0] = (char) (i16 >>> 16);
                                cArr[1] = (char) i16;
                                cArr[2] = (char) (i15 >>> 16);
                                cArr[3] = (char) i15;
                                com.ironsource.adqualitysdk.sdk.i.d.m1895(iArr2);
                                int i17 = com.ironsource.adqualitysdk.sdk.i.d.f1665;
                                cArr2[i17 << 1] = cArr[0];
                                cArr2[(i17 << 1) + 1] = cArr[1];
                                cArr2[(i17 << 1) + 2] = cArr[2];
                                cArr2[(i17 << 1) + 3] = cArr[3];
                                com.ironsource.adqualitysdk.sdk.i.d.f1665 = i17 + 2;
                            } else {
                                str = new String(cArr2, 0, i2);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo330(JSONObject jSONObject, WebView webView, Activity activity) {
                f1419 = (f1418 + 95) % 128;
                m1737(m1736(new int[]{1478436806, 1188496500, -397704008, -1453386109}, ((byte) KeyEvent.getModifierMetaStateMask()) + 9).intern(), jSONObject, webView, null, activity);
                f1419 = (f1418 + 109) % 128;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.ironsource.adqualitysdk.sdk.i.l
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo331(JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                f1419 = (f1418 + 35) % 128;
                m1737(m1736(new int[]{992479764, -1197396707, 4473799, -1985360276, 812654023, -1924692271, 487604835, -1745707246, -1616168760, -1755301163}, 20 - (KeyEvent.getMaxKeyCode() >> 16)).intern(), jSONObject, webView, obj, activity);
                int i2 = f1419 + 67;
                f1418 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private void m1737(String str, JSONObject jSONObject, WebView webView, Object obj, Activity activity) {
                cp.m1682(cp.this, a0.d(new StringBuilder(), m1736(new int[]{741371940, -1554738951, -1875080094, -664754478, -796531261, 2115294261, 2107443999, -487757682, -1132572803, 500055709}, ImageFormat.getBitsPerPixel(0) + 20), str), z2, false, Arrays.asList(jSONObject, webView, obj, activity));
                f1418 = (f1419 + 97) % 128;
            }
        };
        int i2 = f1390 + 83;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            return lVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private t m1690(final t tVar, final t tVar2) {
        int i2 = f1390 + 49;
        f1391 = i2 % 128;
        if (i2 % 2 != 0) {
            if (tVar == null) {
                tVar = new t();
                f1390 = (f1391 + 79) % 128;
            }
            if (tVar2 == null) {
                tVar2 = new t();
                f1391 = (f1390 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            }
            return new t() { // from class: com.ironsource.adqualitysdk.sdk.i.cp.18
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ﻛ */
                public final void mo329(JSONObject jSONObject, View view, Object obj, Activity activity) {
                    tVar2.mo329(jSONObject, view, obj, activity);
                    p.m2964(new b.AnonymousClass4(tVar, jSONObject, view, obj, activity));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ﾇ */
                public final void mo330(JSONObject jSONObject, View view, Activity activity) {
                    tVar2.mo330(jSONObject, view, activity);
                    p.m2964(new c.AnonymousClass2(tVar, jSONObject, view, activity));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ﻐ */
                public final void mo328(JSONObject jSONObject, View view, Activity activity) {
                    tVar2.mo328(jSONObject, view, activity);
                    p.m2964(new i.AnonymousClass2(tVar, jSONObject, view, activity));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ｋ */
                public final void mo296(JSONObject jSONObject, View view, Activity activity) {
                    tVar2.mo296(jSONObject, view, activity);
                    p.m2964(new a.AnonymousClass3(tVar, jSONObject, view, activity));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ﾒ */
                public final void mo293(JSONObject jSONObject, View view, Activity activity) {
                    tVar2.mo293(jSONObject, view, activity);
                    p.m2964(new e.AnonymousClass1(tVar, jSONObject, view, activity));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ﻛ */
                public final void mo332(JSONObject jSONObject, View view, Activity activity) {
                    tVar2.mo332(jSONObject, view, activity);
                    p.m2964(new h.AnonymousClass3(tVar, jSONObject, view, activity));
                }

                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ﾇ */
                public final void mo331(JSONObject jSONObject, View view, Object obj, Activity activity) {
                    tVar2.mo331(jSONObject, view, obj, activity);
                    p.m2964(new f.AnonymousClass4(tVar, jSONObject, view, obj, activity));
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.ironsource.adqualitysdk.sdk.i.t, com.ironsource.adqualitysdk.sdk.i.s
                /* JADX INFO: renamed from: ｋ */
                public final void mo333(JSONObject jSONObject, View view, Object obj, Activity activity) {
                    tVar2.mo333(jSONObject, view, obj, activity);
                    p.m2964(new d.AnonymousClass5(tVar, jSONObject, view, obj, activity));
                }
            };
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1684(String str, boolean z2, boolean z7, List<Object> list) {
        int i2 = f1391 + 5;
        f1390 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                dl dlVarM2350 = this.f1403.m2350(str);
                if (dlVarM2350 != null) {
                    dq dqVarM2353 = this.f1403.m2353(dlVarM2350.m2051());
                    if (dqVarM2353 != null) {
                        int i8 = f1390 + 63;
                        f1391 = i8 % 128;
                        if (i8 % 2 == 0) {
                            int i9 = 30 / 0;
                            if (z2 != dlVarM2350.m2052()) {
                                return;
                            }
                        } else if (z2 != dlVarM2350.m2052()) {
                            return;
                        }
                        if (z7 == dlVarM2350.m2050()) {
                            f1390 = (f1391 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                            if (q.m3013().m3032()) {
                                f1391 = (f1390 + 79) % 128;
                                co.m1672(m1723(), str);
                            }
                            dqVarM2353.m2081(this.f1404, this, list);
                            return;
                        }
                        return;
                    }
                    String strM1723 = m1723();
                    StringBuilder sb = new StringBuilder();
                    sb.append(m1691("蔨蕥岯ꆏ\uefa2䃘ᕜ灓띿꺒\ufae2寸潥뮤\uf187囦婽聚쳳怛儖贚\udbe0笏䰾騦", Color.argb(0, 0, 0, 0) + 1).intern());
                    sb.append(dlVarM2350.m2051());
                    sb.append(m1691("\udcfd\udcdd쾎㊥\uf16c秽உ⧉蹆㶱\ue478拐㚻⢇", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern());
                    co.m1671(strM1723, sb.toString(), null);
                    f1391 = (f1390 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
                    return;
                }
                return;
            }
            this.f1403.m2350(str);
            throw null;
        } catch (Throwable th) {
            String strM17232 = m1723();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m1705((String) null, 126 - TextUtils.lastIndexOf("", '0'), (int[]) null, "¢\u0085\u008b\u0082\u0092\u0082¢£\u008b\u0089\u008f\u0087\u008b\u008e\u0096¢\u008c\u0084\u008c\u008c\u009d").intern());
            sb2.append(str);
            co.m1671(strM17232, sb2.toString(), th);
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1691(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (com.ironsource.adqualitysdk.sdk.i.i.f2441) {
            try {
                char[] cArrM2497 = com.ironsource.adqualitysdk.sdk.i.i.m2497(f1393, cArr, i2);
                com.ironsource.adqualitysdk.sdk.i.i.f2442 = 4;
                while (true) {
                    int i8 = com.ironsource.adqualitysdk.sdk.i.i.f2442;
                    if (i8 < cArrM2497.length) {
                        com.ironsource.adqualitysdk.sdk.i.i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1393));
                        com.ironsource.adqualitysdk.sdk.i.i.f2442 = i8 + 1;
                    } else {
                        str2 = new String(cArrM2497, 4, cArrM2497.length - 4);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m1726(String str, JSONObject jSONObject) {
        if (str.equals(m1691("䗺䖛ﵦG쎘שׁ㥍낇ಁཌ횣\ue00e꾳ᩲ\udd9a\ued12", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1).intern())) {
            this.f1399.m1657().m852(jSONObject);
        } else if (str.equals(m1705((String) null, View.MeasureSpec.makeMeasureSpec(0, 0) + 127, (int[]) null, "\u0087\u0082\u008a\u0084\u008f\u0091¤\u0087\u008e").intern())) {
            this.f1399.m1657().m857(jSONObject);
        }
        JSONObject jSONObjectM2895 = kc.m2895(m1693(jSONObject));
        if (str.equals(ig.f2487)) {
            f1391 = (f1390 + 87) % 128;
            this.f1399.m1657().m850(jSONObjectM2895);
            return;
        }
        if (str.equals(ig.f2483)) {
            int i2 = f1391 + 33;
            f1390 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f1399.m1657().m855(jSONObjectM2895);
                return;
            } else {
                this.f1399.m1657().m855(jSONObjectM2895);
                throw null;
            }
        }
        if (str.equals(ig.f2491)) {
            f1391 = (f1390 + 87) % 128;
            this.f1399.m1657().m858(jSONObjectM2895);
            int i8 = f1390 + 79;
            f1391 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 41 / 0;
                return;
            }
            return;
        }
        if (str.equals(ig.f2490)) {
            this.f1399.m1657().m847(jSONObjectM2895);
            return;
        }
        if (str.equals(ig.f2484)) {
            this.f1399.m1657().m848(jSONObjectM2895);
            return;
        }
        if (str.equals(ig.f2485)) {
            f1391 = (f1390 + 81) % 128;
            this.f1399.m1657().m845(jSONObjectM2895);
        } else if (str.equals(ig.f2486)) {
            this.f1399.m1657().m846(jSONObjectM2895);
        } else {
            this.f1399.m1657().m854(str, jSONObject);
        }
    }
}
