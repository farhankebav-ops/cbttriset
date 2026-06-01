package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
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
import android.widget.ExpandableListView;
import androidx.exifinterface.media.ExifInterface;
import com.ironsource.adqualitysdk.sdk.i.af;
import com.ironsource.adqualitysdk.sdk.i.jb;
import com.ironsource.adqualitysdk.sdk.i.jc;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ah {

    /* JADX INFO: renamed from: 乁, reason: contains not printable characters */
    private static int f217 = 1;

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    private static int f218 = 0;

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private static int[] f219 = {1636505573, -1445906369, -549566008, -2078372514, -158098116, 829238119, -777576999, 669829647, 1573097770, -1236452304, 668210869, 246835912, -136812530, 1992296459, -1560172218, 107719777, 272220635, 1640670566};

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    private static long f220 = 1772483359548452696L;

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private r f221;

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private String f222;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private ae f223;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private Context f224;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private iq f225;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private jn f227;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private boolean f228;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private boolean f231;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private Handler f232;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ak f233;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private af f234;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private iy f235;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private jc f236;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean f237;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private List<ai> f230 = new ArrayList();

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private List<jb.d> f229 = new ArrayList();

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private Thread.UncaughtExceptionHandler f226 = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.ah$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 implements af.d {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        final /* synthetic */ JSONArray f265;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        final /* synthetic */ List f267;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        final /* synthetic */ iz f268;

        public AnonymousClass2(JSONArray jSONArray, List list, iz izVar) {
            this.f265 = jSONArray;
            this.f267 = list;
            this.f268 = izVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.af.d
        public void onEventGenerated(JSONObject jSONObject) {
            ah.m431(ah.this).m381(jSONObject);
            ah.m410(ah.this).m2613(ah.m416(ah.this).m507(ah.m415(ah.this)), jSONObject, new iz() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.2.5

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static int f269 = 1;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static long f270 = 825120361375802077L;

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static int f271;

                @Override // com.ironsource.adqualitysdk.sdk.i.iz
                /* JADX INFO: renamed from: ﻛ */
                public final void mo465(final ir irVar, final String str) {
                    p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.2.5.1
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            AnonymousClass2.this.f268.mo465(irVar, str);
                        }
                    });
                    f271 = (f269 + 43) % 128;
                }

                @Override // com.ironsource.adqualitysdk.sdk.i.iz
                /* JADX INFO: renamed from: ｋ */
                public final void mo467(final ir irVar) {
                    final int iM2558 = irVar.m2557().m2558();
                    final String strM2559 = irVar.m2557().m2559();
                    if (iM2558 >= 200 && iM2558 <= 299) {
                        k.m2859(m477("㜡㝠±ἆ활∂嫝뺧밬꺔칁∴↺", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), m477("屶就븹痙箓鲋〗ጤ흣၈ꒄ迭䫽螟⤞ҟ﹙笠鶽焅燕\ueee4ؼ\ued9a\ue541扽謇娮ᢡ\ud9deﾋ횯谿䵞恛䌕ޠ쀡퓭뿐뭃", -TextUtils.lastIndexOf("", '0', 0, 0)).intern(), AnonymousClass2.this.f265);
                        Iterator it = AnonymousClass2.this.f267.iterator();
                        while (it.hasNext()) {
                            ah.m420(ah.this).m2662(((ag) it.next()).m407());
                        }
                        p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.2.5.5
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                AnonymousClass2.this.f268.mo467(irVar);
                            }
                        });
                        return;
                    }
                    if (iM2558 == 403) {
                        synchronized (ah.this) {
                            try {
                                for (final jb.d dVar : ah.m411(ah.this)) {
                                    p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.2.5.2
                                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                        /* JADX INFO: renamed from: ﻐ */
                                        public final void mo306() {
                                            dVar.mo2648();
                                        }
                                    });
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    } else {
                        String strIntern = m477("㜡㝠±ἆ활∂嫝뺧밬꺔칁∴↺", 1 - View.MeasureSpec.makeMeasureSpec(0, 0)).intern();
                        StringBuilder sb = new StringBuilder();
                        sb.append(m477("폆펕㜔沭쩋ᖦ⥺ꊹ壆餭뷪㸮앉\u0ef1へ땑燴\uf259蒛샏﹤柖Ὁ屋檢\ueb42鈺\uebe4霖傡\ue6ac条΄쑹礎\uf2fe蠃䤇춃๒㓲㺢䀌薔ꅮꈃ풊ᄧ⹊អ⽵겫嫓魣ꎧ", (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1).intern());
                        sb.append(iM2558);
                        sb.append(m477("쿤쿄ཡそ뚼", -TextUtils.lastIndexOf("", '0', 0, 0)).intern());
                        sb.append(strM2559);
                        k.m2858(strIntern, sb.toString());
                    }
                    p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.2.5.4

                        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                        private static int f277 = 0;

                        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                        private static int f278 = 1;

                        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                        private static char f279 = 5;

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static char[] f280 = {'S', 'o', 'm', 'e', 't', 'h', 'i', 'n', 'g', ' ', 'w', 'r', 's', 'd', 'E', 'v', '.', 'G', 'p', ':', 'T', 'U', 'V', 'W', 'X'};

                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            iz izVar = AnonymousClass2.this.f268;
                            ir irVar2 = irVar;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(m478((-16777165) - Color.rgb(0, 0, 0), (byte) (61 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), "\u0001\u0002\u0003\u0004\u0000\t\u0007\b\t\u0005\r\u0000\t\u0002\u0005\u000e\u0010\u0006\b\t\u0005\u000e\t\u0001\u0006\u0005\r\u0002\b\f\n\u0013\u0002\b\u0001\u0013\u0007\u0013\u0002\u0000\u0006\u000e\u0002\r\u0010\u0003\f\u0011\u0004\u0012]").intern());
                            sb2.append(iM2558);
                            sb2.append(m478(-ExpandableListView.getPackedPositionChild(0L), (byte) (KeyEvent.getDeadChar(0, 0) + 19), ExifInterface.GPS_MEASUREMENT_3D).intern());
                            sb2.append(strM2559);
                            izVar.mo465(irVar2, sb2.toString());
                            int i2 = f277 + 61;
                            f278 = i2 % 128;
                            if (i2 % 2 == 0) {
                                int i8 = 73 / 0;
                            }
                        }

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static String m478(int i2, byte b8, String str) {
                            String str2;
                            Object charArray = str;
                            if (str != null) {
                                charArray = str.toCharArray();
                            }
                            char[] cArr = (char[]) charArray;
                            synchronized (h.f2264) {
                                try {
                                    char[] cArr2 = f280;
                                    char c7 = f279;
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
                                    str2 = new String(cArr3);
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            return str2;
                        }
                    });
                }

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static String m477(String str, int i2) {
                    String str2;
                    Object charArray = str;
                    if (str != null) {
                        charArray = str.toCharArray();
                    }
                    char[] cArr = (char[]) charArray;
                    synchronized (i.f2441) {
                        try {
                            char[] cArrM2497 = i.m2497(f270, cArr, i2);
                            i.f2442 = 4;
                            while (true) {
                                int i8 = i.f2442;
                                if (i8 < cArrM2497.length) {
                                    i.f2443 = i8 - 4;
                                    cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f270));
                                    i.f2442 = i8 + 1;
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
            });
        }
    }

    public ah(Context context, as asVar, ak akVar, boolean z2, String str, r rVar) {
        this.f221 = rVar;
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.4

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f289 = 1;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static long f290 = -5840101160116598947L;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static int f291;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static String m479(String str2, int i2) {
                String str3;
                Object charArray = str2;
                if (str2 != null) {
                    charArray = str2.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (i.f2441) {
                    try {
                        char[] cArrM2497 = i.m2497(f290, cArr, i2);
                        i.f2442 = 4;
                        while (true) {
                            int i8 = i.f2442;
                            if (i8 < cArrM2497.length) {
                                i.f2443 = i8 - 4;
                                cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f290));
                                i.f2442 = i8 + 1;
                            } else {
                                str3 = new String(cArrM2497, 4, cArrM2497.length - 4);
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str3;
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                f291 = (f289 + 115) % 128;
                kd.m2916(m479("꾔꿕禳ղ\uf771㺀让ℊ늙ᴖꤵҙ锏", -MotionEvent.axisFromString("")).intern(), m479("맔릁㝋䂞\u0ef9灸칇\ud88fꓕ叽\uecd8ﴆ茜땫襄ṥ\ue1edꢂꟼ⃣챫計", ExpandableListView.getPackedPositionType(0L) + 1).intern(), m479("\udfd9\udf8d닌\ue1b0㩇\uf5e3潫\uec33싈홿䷿즯\ue55a", 1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), th);
                ah.this.m461();
                ah.m448(ah.this).uncaughtException(thread, th);
                f289 = (f291 + 29) % 128;
            }
        });
        this.f233 = akVar;
        this.f224 = context;
        jb jbVar = new jb(context, m447("欅㜴⮤歱\u181e㻳畵나혀\udbee㟕痸ᆮ鴂\uf2bf㙍匋倨봖\uf8f5黤ᎂ翵봗\ud99c핸㩝繸ᬶ", ImageFormat.getBitsPerPixel(0) + 1).intern(), m447("\udcba聿\ud14c9꽈ⶐ藚ꏵ憶沦윸暋ꘟ⨄ȇ┽\ue4ee\ue72a䷡\uebd9⥔꓆轙깡渮戮쫶洋", Process.getGidForName("") + 1).intern());
        this.f236 = new jc(m433(new int[]{1588581690, -2127013717, -427515673, 625051055}, TextUtils.indexOf("", "") + 8).intern(), m447("牔䤺\ue637爱昔員룢\uda87콀ꖬ", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), jbVar);
        int iM439 = m439(jbVar);
        this.f234 = new af(context, asVar, iM439, m432(jbVar), aq.m530().mo533());
        this.f235 = new iy(context);
        this.f237 = false;
        HandlerThread handlerThread = new HandlerThread(m433(new int[]{955287113, -1318617357, -1089994594, -280516384, -988955356, -604985532, -1644483777, -867748097}, 14 - ((Process.getThreadPriority(0) + 20) >> 6)).intern());
        handlerThread.start();
        this.f232 = new Handler(handlerThread.getLooper());
        this.f223 = new ae(iM439);
        this.f231 = !z2;
        this.f222 = str;
        m444(true);
        m422();
    }

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private String m409() {
        int i2 = f217 + 9;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            aq.m530().mo548();
            throw null;
        }
        if (aq.m530().mo548()) {
            return m414().m606();
        }
        int i8 = f217 + 55;
        f218 = i8 % 128;
        if (i8 % 2 == 0) {
            return m414().m603();
        }
        int i9 = 93 / 0;
        return m414().m603();
    }

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    public static /* synthetic */ iy m410(ah ahVar) {
        int i2 = (f217 + 109) % 128;
        f218 = i2;
        iy iyVar = ahVar.f235;
        int i8 = i2 + 97;
        f217 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 10 / 0;
        }
        return iyVar;
    }

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    public static /* synthetic */ List m411(ah ahVar) {
        int i2 = f217;
        f218 = (i2 + 13) % 128;
        List<jb.d> list = ahVar.f229;
        f218 = (i2 + 1) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public static /* synthetic */ af m412(ah ahVar) {
        int i2 = f218 + 83;
        f217 = i2 % 128;
        int i8 = i2 % 2;
        af afVar = ahVar.f234;
        if (i8 != 0) {
            return afVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public static /* synthetic */ String m415(ah ahVar) {
        f217 = (f218 + 67) % 128;
        String strM409 = ahVar.m409();
        int i2 = f217 + 49;
        f218 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM409;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static /* synthetic */ ak m416(ah ahVar) {
        int i2 = f217;
        f218 = (i2 + 9) % 128;
        ak akVar = ahVar.f233;
        f218 = (i2 + 109) % 128;
        return akVar;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    public static /* synthetic */ int m419(ah ahVar) {
        f218 = (f217 + 99) % 128;
        int iM418 = ahVar.m418();
        f218 = (f217 + 107) % 128;
        return iM418;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public static /* synthetic */ jc m420(ah ahVar) {
        int i2 = f217;
        f218 = (i2 + 81) % 128;
        jc jcVar = ahVar.f236;
        f218 = (i2 + 79) % 128;
        return jcVar;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ void m423(ah ahVar) {
        f217 = (f218 + 11) % 128;
        ahVar.m436(true);
        int i2 = f218 + 71;
        f217 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 94 / 0;
        }
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static /* synthetic */ Handler m424(ah ahVar) {
        int i2 = f217;
        f218 = (i2 + 23) % 128;
        Handler handler = ahVar.f232;
        f218 = (i2 + 95) % 128;
        return handler;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ void m426(ah ahVar) {
        f218 = (f217 + 97) % 128;
        ahVar.m413();
        f217 = (f218 + 85) % 128;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ void m428(ah ahVar) {
        f217 = (f218 + 7) % 128;
        ahVar.m451(false);
        f218 = (f217 + 59) % 128;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static /* synthetic */ void m430(ah ahVar) {
        int i2 = f217 + 113;
        f218 = i2 % 128;
        int i8 = i2 % 2;
        ahVar.m427();
        if (i8 != 0) {
            int i9 = 97 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ ae m431(ah ahVar) {
        int i2 = (f217 + 25) % 128;
        f218 = i2;
        ae aeVar = ahVar.f223;
        int i8 = i2 + 79;
        f217 = i8 % 128;
        if (i8 % 2 != 0) {
            return aeVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ r m437(ah ahVar) {
        int i2 = f218 + 33;
        f217 = i2 % 128;
        int i8 = i2 % 2;
        r rVar = ahVar.f221;
        if (i8 != 0) {
            return rVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m440(ah ahVar) {
        f218 = (f217 + 35) % 128;
        ahVar.m425();
        f217 = (f218 + 93) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ Thread.UncaughtExceptionHandler m448(ah ahVar) {
        int i2 = f217 + 101;
        int i8 = i2 % 128;
        f218 = i8;
        int i9 = i2 % 2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = ahVar.f226;
        if (i9 != 0) {
            throw null;
        }
        f217 = (i8 + 5) % 128;
        return uncaughtExceptionHandler;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m453(ah ahVar) {
        f217 = (f218 + 71) % 128;
        ahVar.m444(false);
        int i2 = f218 + 63;
        f217 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private synchronized void m413() {
        try {
            f217 = (f218 + 49) % 128;
            if (m421() && !TextUtils.isEmpty(this.f234.m2763().m620())) {
                f218 = (f217 + 109) % 128;
                if (!m417()) {
                    m451(true);
                    k.m2858(m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, ((byte) KeyEvent.getModifierMetaStateMask()) + 10).intern(), m447("踻\uf27d꼆蹨\udd40톘\uf1d8忴㌲ẫ덱髐\uf49e堓瘓\ud93e뙯镶㧶៖築훊ﭛ到㲸ဤ뻵鄘\ufe1e", (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1).intern());
                    this.f236.m2659(m414().m607(), new AnonymousClass1());
                }
            }
            f217 = (f218 + 29) % 128;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private synchronized ar m414() {
        int i2 = f217 + 39;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            aq.m530().mo544();
            throw null;
        }
        return aq.m530().mo544();
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private synchronized boolean m417() {
        boolean z2;
        int i2 = (f217 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        f218 = i2;
        z2 = this.f228;
        f217 = (i2 + 67) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private int m418() {
        if (m414() == null) {
            return 100;
        }
        int i2 = f218 + 53;
        f217 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 21 / 0;
            if (aq.m530().mo548()) {
                return 100;
            }
        } else if (aq.m530().mo548()) {
            return 100;
        }
        f217 = (f218 + 37) % 128;
        return m414().m608();
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private synchronized boolean m421() {
        boolean z2;
        int i2 = f217;
        int i8 = i2 + 63;
        f218 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        z2 = this.f237;
        int i9 = i2 + 71;
        f218 = i9 % 128;
        if (i9 % 2 != 0) {
            throw null;
        }
        return z2;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private void m422() {
        this.f225 = new iq() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.6
            @Override // com.ironsource.adqualitysdk.sdk.i.iq
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo481() {
                ah.m440(ah.this);
            }
        };
        this.f235.m2611().m2570(this.f225);
        this.f227 = new jn(new jo() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.10

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f239 = 0;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int f240 = 1;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static long f241 = 8093892175527280894L;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public static /* synthetic */ JSONObject m468(Activity activity) {
                f240 = (f239 + 25) % 128;
                JSONObject jSONObjectM470 = m470(activity);
                int i2 = f239 + 13;
                f240 = i2 % 128;
                if (i2 % 2 != 0) {
                    return jSONObjectM470;
                }
                throw null;
            }

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static JSONObject m470(Activity activity) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(m469("劫勊兪儩⌗儲啬唰凷傡↣", ViewConfiguration.getEdgeSlop() >> 16).intern(), activity.getClass().getName());
                } catch (JSONException unused) {
                    k.m2863(m469("冤凥\uea5dﾆ㗐別\uee4fﮆ\ueacd\ufe1b㝆㇗嘧", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))).intern(), m469("䪒䫗釓㱯눔䤘閉㡴酟㷡낁똗䴆駘㑣먌䅚鷘て븗䔛臷ⱔꈯ夳薩⡛\ua632崯觴", TextUtils.indexOf("", "", 0)).intern());
                }
                f240 = (f239 + 115) % 128;
                return jSONObject;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jo
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final void mo471(final Activity activity) {
                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.10.4

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static long f251 = 3742823802152323135L;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static int f252 = 1;

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static int f253;

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static String m474(String str, int i2) {
                        String str2;
                        Object charArray = str;
                        if (str != null) {
                            charArray = str.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        synchronized (i.f2441) {
                            try {
                                char[] cArrM2497 = i.m2497(f251, cArr, i2);
                                i.f2442 = 4;
                                while (true) {
                                    int i8 = i.f2442;
                                    if (i8 < cArrM2497.length) {
                                        i.f2443 = i8 - 4;
                                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f251));
                                        i.f2442 = i8 + 1;
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

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        f252 = (f253 + 95) % 128;
                        ah.m437(ah.this).onEvent(m474("ﺜὙ愫촓ﻺ霉然嗛\ude13똽倣瓏뼗픚㌲។鰍\uf40e", -TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern());
                        ah.this.m458(m474("ﺜὙ愫촓ﻺ霉然嗛\ude13똽倣瓏뼗픚㌲។鰍\uf40e", 1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), AnonymousClass10.m468(activity));
                        f253 = (f252 + 7) % 128;
                    }
                });
                f240 = (f239 + 37) % 128;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jo
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo472(final Activity activity) {
                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.10.1

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static int f243 = 1;

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static int f244 = 0;

                    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                    private static boolean f245 = true;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static int f246 = 85;

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static boolean f247 = true;

                    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                    private static char[] f248 = {187, 196, 184, 202, 200, 180, 193, 201};

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static String m473(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                                char[] cArr2 = f248;
                                int i8 = f246;
                                if (f245) {
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
                                if (f247) {
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

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        f243 = (f244 + 107) % 128;
                        ah.m437(ah.this).onEvent(m473(null, 127 - Gravity.getAbsoluteGravity(0, 0), null, "\u0088\u0085\u0082\u0087\u0086\u0085\u0084\u0083\u0082\u0081").intern());
                        ah.this.m458(m473(null, KeyEvent.normalizeMetaState(0) + 127, null, "\u0088\u0085\u0082\u0087\u0086\u0085\u0084\u0083\u0082\u0081").intern(), AnonymousClass10.m468(activity));
                        int i2 = f244 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
                        f243 = i2 % 128;
                        if (i2 % 2 == 0) {
                            throw null;
                        }
                    }
                });
                int i2 = f239 + 71;
                f240 = i2 % 128;
                if (i2 % 2 == 0) {
                    throw null;
                }
            }

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m469(String str, int i2) {
                String str2;
                Object charArray = str;
                if (str != null) {
                    charArray = str.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (i.f2441) {
                    try {
                        char[] cArrM2497 = i.m2497(f241, cArr, i2);
                        i.f2442 = 4;
                        while (true) {
                            int i8 = i.f2442;
                            if (i8 < cArrM2497.length) {
                                i.f2443 = i8 - 4;
                                cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f241));
                                i.f2442 = i8 + 1;
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
        });
        jf.m2685().m2686(new jj() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.8
            @Override // com.ironsource.adqualitysdk.sdk.i.jj, com.ironsource.adqualitysdk.sdk.i.jg
            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            public final void mo483(Activity activity) {
                ah.this.m461();
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.jj, com.ironsource.adqualitysdk.sdk.i.jg
            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            public final void mo484(Activity activity) {
                ah.m430(ah.this);
            }
        });
        aq.m530().mo559(new at() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.12
            @Override // com.ironsource.adqualitysdk.sdk.i.at
            /* JADX INFO: renamed from: ﾇ */
            public final void mo383() {
                ah.m423(ah.this);
            }
        });
        f217 = (f218 + 61) % 128;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private void m425() {
        int i2 = f218 + 5;
        f217 = i2 % 128;
        m444(i2 % 2 == 0);
        int i8 = f218 + 77;
        f217 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private void m427() {
        int i2 = f217 + 3;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (this.f231) {
            m460();
        }
        this.f231 = false;
        f217 = (f218 + 21) % 128;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private void m429() {
        if (this.f225 != null) {
            f218 = (f217 + 39) % 128;
            this.f235.m2611().m2573(this.f225);
        }
        this.f227.m2745();
        this.f227 = null;
        f218 = (f217 + 97) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m434(ah ahVar, JSONObject jSONObject, iu iuVar) {
        int i2 = f217 + 55;
        f218 = i2 % 128;
        int i8 = i2 % 2;
        ahVar.m443(jSONObject, iuVar);
        if (i8 != 0) {
            int i9 = 80 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m446(ah ahVar, ag agVar) {
        f218 = (f217 + 11) % 128;
        boolean zM445 = ahVar.m445(agVar);
        int i2 = f217 + 69;
        f218 = i2 % 128;
        if (i2 % 2 == 0) {
            return zM445;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ boolean m452(ah ahVar, int i2) {
        f217 = (f218 + 37) % 128;
        boolean zM438 = ahVar.m438(i2);
        int i8 = f218 + 103;
        f217 = i8 % 128;
        if (i8 % 2 != 0) {
            return zM438;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m454(ah ahVar, List list, iz izVar) {
        int i2 = f218 + 39;
        f217 = i2 % 128;
        int i8 = i2 % 2;
        ahVar.m442((List<ag>) list, izVar);
        if (i8 == 0) {
            int i9 = 94 / 0;
        }
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final String m455() {
        String strM432 = m432(new jb(this.f224, m447("欅㜴⮤歱\u181e㻳畵나혀\udbee㟕痸ᆮ鴂\uf2bf㙍匋倨봖\uf8f5黤ᎂ翵봗\ud99c핸㩝繸ᬶ", MotionEvent.axisFromString("") + 1).intern(), m447("\udcba聿\ud14c9꽈ⶐ藚ꏵ憶沦윸暋ꘟ⨄ȇ┽\ue4ee\ue72a䷡\uebd9⥔꓆轙깡渮戮쫶洋", ViewConfiguration.getJumpTapTimeout() >> 16).intern()));
        f218 = (f217 + 89) % 128;
        return strM432;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m457() {
        synchronized (this) {
            try {
                Handler handler = this.f232;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                m444(true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0028 A[Catch: all -> 0x0015, TRY_LEAVE, TryCatch #1 {all -> 0x0015, blocks: (B:3:0x0001, B:5:0x000e, B:12:0x001d, B:14:0x0028, B:19:0x0032, B:20:0x0033, B:21:0x0038, B:10:0x0017, B:16:0x002f), top: B:28:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0033 A[Catch: all -> 0x0015, TryCatch #1 {all -> 0x0015, blocks: (B:3:0x0001, B:5:0x000e, B:12:0x001d, B:14:0x0028, B:19:0x0032, B:20:0x0033, B:21:0x0038, B:10:0x0017, B:16:0x002f), top: B:28:0x0001, inners: #0 }] */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m456() {
        /*
            r3 = this;
            monitor-enter(r3)
            int r0 = com.ironsource.adqualitysdk.sdk.i.ah.f217     // Catch: java.lang.Throwable -> L15
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ah.f218 = r1     // Catch: java.lang.Throwable -> L15
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L17
            r3.f237 = r2     // Catch: java.lang.Throwable -> L15
            android.os.Handler r0 = r3.f232     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L38
            goto L1d
        L15:
            r0 = move-exception
            goto L42
        L17:
            r3.f237 = r2     // Catch: java.lang.Throwable -> L15
            android.os.Handler r0 = r3.f232     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L38
        L1d:
            int r1 = r1 + 1
            int r0 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.ah.f217 = r0     // Catch: java.lang.Throwable -> L15
            int r1 = r1 % 2
            r0 = 0
            if (r1 != 0) goto L33
            android.os.Handler r1 = r3.f232     // Catch: java.lang.Throwable -> L15
            r1.removeCallbacksAndMessages(r0)     // Catch: java.lang.Throwable -> L15
            r0 = 21
            int r0 = r0 / r2
            goto L38
        L31:
            r0 = move-exception
            throw r0     // Catch: java.lang.Throwable -> L15
        L33:
            android.os.Handler r1 = r3.f232     // Catch: java.lang.Throwable -> L15
            r1.removeCallbacksAndMessages(r0)     // Catch: java.lang.Throwable -> L15
        L38:
            com.ironsource.adqualitysdk.sdk.i.iy r0 = r3.f235     // Catch: java.lang.Throwable -> L15
            r0.m2612()     // Catch: java.lang.Throwable -> L15
            r3.m429()     // Catch: java.lang.Throwable -> L15
            monitor-exit(r3)
            return
        L42:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L15
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ah.m456():void");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m460() {
        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.7

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static int f301 = 1;

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static int f302 = 0;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static boolean f303 = true;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static boolean f304 = true;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f305 = 290;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static char[] f306 = {406, 402, 385, 405, 391, 387, 404};

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m482(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                        char[] cArr2 = f306;
                        int i8 = f305;
                        if (f304) {
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
                        if (f303) {
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                ah.m437(ah.this).onEvent(m482(null, 128 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), null, "\u0081\u0087\u0086\u0081\u0084\u0083\u0084\u0084\u0085\u0084\u0083\u0082\u0081").intern());
                ah.this.m458(m482(null, TextUtils.indexOf((CharSequence) "", '0', 0) + 128, null, "\u0081\u0087\u0086\u0081\u0084\u0083\u0084\u0084\u0085\u0084\u0083\u0082\u0081").intern(), new JSONObject());
                int i2 = f302 + 87;
                f301 = i2 % 128;
                if (i2 % 2 == 0) {
                    int i8 = 91 / 0;
                }
            }
        });
        int i2 = f217 + 101;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m461() {
        int i2 = f217 + 13;
        f218 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f231 = true;
            } else {
                this.f231 = true;
            }
            m462();
            m457();
            int i8 = f217 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
            f218 = i8 % 128;
            if (i8 % 2 != 0) {
                throw null;
            }
        } catch (Exception e) {
            kd.m2919(m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, 10 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern(), m447("꯭\uf07a퇞ꮨ\udf50ᚙ輜飾\u16ff᳢춧嶟턍娍ࣀḐ鎽靲䝚탞帯퓃薍镺ᥪሰ쀡嘄\udbc3澆", ExpandableListView.getPackedPositionChild(0L) + 1).intern(), e, false);
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m463(ai aiVar) {
        f217 = (f218 + 31) % 128;
        this.f230.add(aiVar);
        f217 = (f218 + 63) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m441(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        int i2 = f217 + 35;
        f218 = i2 % 128;
        int i8 = i2 % 2;
        m459(str, jSONObject, jSONObject2, null);
        if (i8 != 0) {
            throw null;
        }
        int i9 = f218 + 103;
        f217 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m464(jb.d dVar) {
        f217 = (f218 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        this.f229.add(dVar);
        int i2 = f217 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 0 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f A[PHI: r0
  0x004f: PHI (r0v7 java.lang.String) = (r0v6 java.lang.String), (r0v15 java.lang.String) binds: [B:9:0x004d, B:5:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int m439(com.ironsource.adqualitysdk.sdk.i.jb r7) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.ah.f217
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.ah.f218 = r1
            int r0 = r0 % 2
            r1 = 6
            r2 = 1
            if (r0 == 0) goto L30
            int[] r0 = new int[r1]
            r0 = {x007c: FILL_ARRAY_DATA , data: [1755379739, 1676837991, 1778278594, -961391209, 1941074353, -485037900} // fill-array
            int r3 = android.view.ViewConfiguration.getDoubleTapTimeout()
            int r3 = r3 >> 57
            int r3 = 98 - r3
            java.lang.String r0 = m433(r0, r3)
            java.lang.String r0 = r0.intern()
            java.lang.String r0 = r7.m2637(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L2e
            goto L4f
        L2e:
            r2 = 0
            goto L54
        L30:
            int[] r0 = new int[r1]
            r0 = {x008c: FILL_ARRAY_DATA , data: [1755379739, 1676837991, 1778278594, -961391209, 1941074353, -485037900} // fill-array
            int r3 = android.view.ViewConfiguration.getDoubleTapTimeout()
            int r3 = r3 >> 16
            int r3 = 10 - r3
            java.lang.String r0 = m433(r0, r3)
            java.lang.String r0 = r0.intern()
            java.lang.String r0 = r7.m2637(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L54
        L4f:
            int r0 = java.lang.Integer.parseInt(r0)
            int r2 = r2 + r0
        L54:
            int[] r0 = new int[r1]
            r0 = {x009c: FILL_ARRAY_DATA , data: [1755379739, 1676837991, 1778278594, -961391209, 1941074353, -485037900} // fill-array
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            int r1 = r1 + 9
            java.lang.String r0 = m433(r0, r1)
            java.lang.String r0 = r0.intern()
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r7.m2640(r0, r1)
            int r7 = com.ironsource.adqualitysdk.sdk.i.ah.f217
            int r7 = r7 + 11
            int r7 = r7 % 128
            com.ironsource.adqualitysdk.sdk.i.ah.f218 = r7
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ah.m439(com.ironsource.adqualitysdk.sdk.i.jb):int");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m462() {
        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.5

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f293 = 0;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f294 = 1;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static char f295 = 38631;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static char f296 = 1482;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static char f297 = 11697;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static char f298 = 3808;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static String m480(String str, int i2) {
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
                                    char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f295)) ^ ((c8 >>> 5) + f296)));
                                    cArr3[1] = c9;
                                    cArr3[0] = (char) (c8 - (((c9 >>> 5) + f298) ^ ((c9 + i9) ^ ((c9 << 4) + f297))));
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                ah.m437(ah.this).onEvent(m480("㓫僼筊ጲ緊竒悁ꨘ\uf3db爛戱뺎", 11 - View.combineMeasuredStates(0, 0)).intern());
                ah.this.m458(m480("㓫僼筊ጲ緊竒悁ꨘ\uf3db爛戱뺎", 11 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), new JSONObject());
                int i2 = f294 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
                f293 = i2 % 128;
                if (i2 % 2 != 0) {
                    throw null;
                }
            }
        });
        f218 = (f217 + 11) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m458(String str, JSONObject jSONObject) {
        f217 = (f218 + 21) % 128;
        m441(str, jSONObject, null);
        int i2 = f218 + 71;
        f217 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 27 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m459(String str, JSONObject jSONObject, JSONObject jSONObject2, final iu iuVar) {
        String strIntern = m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, 8 - TextUtils.lastIndexOf("", '0', 0)).intern();
        StringBuilder sb = new StringBuilder();
        sb.append(m433(new int[]{-133208383, 2132252603, -688476464, -137971687, 554944587, -258064227, 1371759843, 66712934, 1914710116, 784194277, 112803549, -2115664299}, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 21).intern());
        sb.append(str);
        sb.append(m447("嗤䎅\u09b4嗄沪\uf7de坭禢\ue8ec꼝ᗁ볎⽐\ue9ef킥Ｖ涭⒓鼂㆙ꁞ", TextUtils.indexOf("", "")).intern());
        k.m2859(strIntern, sb.toString(), jSONObject);
        try {
            if (m414().m609().contains(str)) {
                String strIntern2 = m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, 9 - Color.red(0)).intern();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m433(new int[]{1687463885, 8921318, 1677661517, -135159342, 1031872874, 1024453725, -1217451107, 1232049054, 209824166, 770804426, -675425167, -507839233, 1204606052, 1994339335, -1131369875, 293501334}, 29 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern());
                sb2.append(str);
                sb2.append(m433(new int[]{-538754540, -1967238809, -79468009, -1984180914, 1913297529, -80760394, 141400645, 886217392, 1176632602, -824888637, -792154844, -11407279}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 21).intern());
                k.m2858(strIntern2, sb2.toString());
                f217 = (f218 + 21) % 128;
                return;
            }
            String strIntern3 = m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, 9 - View.MeasureSpec.getMode(0)).intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m433(new int[]{-133208383, 2132252603, -688476464, -137971687, 554944587, -258064227, 1371759843, 66712934, 1914710116, 784194277, 1006152527, 2024078580, -101543990, -1373006536, 1119945736, -2122658991}, Color.rgb(0, 0, 0) + 16777248).intern());
            sb3.append(str);
            k.m2858(strIntern3, sb3.toString());
            this.f234.m393(str, jSONObject, jSONObject2, this.f235.m2611().m2571(), new af.d() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.9
                @Override // com.ironsource.adqualitysdk.sdk.i.af.d
                public void onEventGenerated(JSONObject jSONObject3) {
                    ah.m431(ah.this).m381(jSONObject3);
                    ah.m434(ah.this, jSONObject3, new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.9.5

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static int f311 = 0;

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static int f312 = 1;

                        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                        private static char[] f313 = {'4', 'n', 'v', 'r', 'f', 'g', 'W', 'Z', 'k', '7', 'i', 'T', ']', 'm', 'i', 'q', 'W', '-', 'G', 'n', 'X', 'Y', 'n', 'n', 'n', 'h', 'l', 'n', 'l', 'n', 'Y', '[', 'r', 'p', 'p', 'I', 'D', 'k', 'G', 'I', 'l'};

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static String m485(String str2, boolean z2, int[] iArr) throws UnsupportedEncodingException {
                            String str3;
                            Object bytes = str2;
                            if (str2 != null) {
                                bytes = str2.getBytes("ISO-8859-1");
                            }
                            byte[] bArr = (byte[]) bytes;
                            synchronized (g.f2126) {
                                try {
                                    int i2 = iArr[0];
                                    int i8 = iArr[1];
                                    int i9 = iArr[2];
                                    int i10 = iArr[3];
                                    char[] cArr = new char[i8];
                                    System.arraycopy(f313, i2, cArr, 0, i8);
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
                                    str3 = new String(cArr);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            return str3;
                        }

                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            ah.m453(ah.this);
                            iu iuVar2 = iuVar;
                            if (iuVar2 != null) {
                                int i2 = f311 + 25;
                                f312 = i2 % 128;
                                try {
                                    if (i2 % 2 != 0) {
                                        iuVar2.mo306();
                                        return;
                                    } else {
                                        iuVar2.mo306();
                                        throw null;
                                    }
                                } catch (Exception e) {
                                    kd.m2914(m485("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0000", true, new int[]{0, 9, 0, 7}).intern(), m485("\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000", false, new int[]{9, 32, 0, 21}).intern(), (Throwable) e, false, false, true);
                                }
                            }
                            int i8 = f312 + 39;
                            f311 = i8 % 128;
                            if (i8 % 2 != 0) {
                                throw null;
                            }
                        }
                    });
                }
            });
            f218 = (f217 + 37) % 128;
        } catch (Exception e) {
            kd.m2914(m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, 9 - (ViewConfiguration.getEdgeSlop() >> 16)).intern(), m447("ﻋ賯뾶ﺎꏅ撡\ue174\ueac6䏙恷ꏏ⾧萫⚄暣氇욏\uebd2⤐ꋬଥꡃ", (-1) - TextUtils.indexOf((CharSequence) "", '0')).intern(), (Throwable) e, false, false, true);
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static JSONObject m449(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(m447("࠰့杅ࡕ㼝ꠐ㦁♹딷", ViewConfiguration.getTapTimeout() >> 16).intern(), str);
            jSONObject2.put(m447("\ue50e썏쵪\ue56b\uec65債鎷\udece堉", ViewConfiguration.getMaximumDrawingCacheSize() >> 24).intern(), str2);
            jSONObject2.put(m447("刑肄托剴꾮ꁣ㲋⸄\uef15汙", TextUtils.indexOf("", "")).intern(), str3);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put(m447("ꎎ㣹\ue1b2ꏫ៓Ṹ뽱逄ẅ", AndroidCharacter.getMirror('0') - '0').intern(), str4);
            }
            if (jSONObject != null) {
                kc.m2910(jSONObject2, jSONObject);
                f217 = (f218 + 111) % 128;
            }
        } catch (JSONException e) {
            k.m2861(m433(new int[]{2107837037, -659857316, 590876672, 395596117, -1633927646, 1663631817}, 10 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), m433(new int[]{-1365163766, -359683786, -1903856556, -928715780, -1927696298, -624639449, 1516157364, -1098486624, -2018208337, -1848821941, -79995877, 543293388, 799264577, 863994337}, 26 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern(), (Throwable) e);
        }
        int i2 = f217 + 65;
        f218 = i2 % 128;
        if (i2 % 2 == 0) {
            return jSONObject2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private synchronized void m444(final boolean z2) {
        this.f236.m2661(new jc.b() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.11
            @Override // com.ironsource.adqualitysdk.sdk.i.jc.b
            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            public final void mo475(int i2) {
                ah.m424(ah.this).removeCallbacksAndMessages(null);
                ah.m424(ah.this).postDelayed(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.11.2

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static int f258 = 1;

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static int f259 = 0;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static long f260 = 0;

                    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                    private static int f261 = 0;

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static char f262 = 42248;

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        int i8 = f261 + 23;
                        f258 = i8 % 128;
                        try {
                            if (i8 % 2 == 0) {
                                ah.m426(ah.this);
                                throw null;
                            }
                            ah.m426(ah.this);
                            f258 = (f261 + 39) % 128;
                        } catch (Throwable th) {
                            k.m2872(m476("灢\uf789⚠\ue000", (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), "欮럎敊럦트敝큈ጜ쟍", (-1594390161) - TextUtils.lastIndexOf("", '0'), "\u0000\u0000\u0000\u0000").intern(), m476("揎౫䠿쏟", (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 57160), "刘\ude6d䂛ᙴ牼ⵤ롞箜导\uedc0ദ盲쒒큩鹬䓺頔\ued48㨤Ὸ\ude8b\uea60㛪䈗뚼ၬ쉉噘쎩붢焸", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1057778531, "\u0000\u0000\u0000\u0000").intern(), th);
                            ah.m428(ah.this);
                        }
                    }

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static String m476(String str, char c7, String str2, int i8, String str3) {
                        String str4;
                        Object charArray = str3;
                        if (str3 != null) {
                            charArray = str3.toCharArray();
                        }
                        char[] cArr = (char[]) charArray;
                        Object charArray2 = str2;
                        if (str2 != null) {
                            charArray2 = str2.toCharArray();
                        }
                        char[] cArr2 = (char[]) charArray2;
                        Object charArray3 = str;
                        if (str != null) {
                            charArray3 = str.toCharArray();
                        }
                        char[] cArr3 = (char[]) charArray3;
                        synchronized (f.f2031) {
                            try {
                                char[] cArr4 = (char[]) cArr3.clone();
                                char[] cArr5 = (char[]) cArr.clone();
                                cArr4[0] = (char) (c7 ^ cArr4[0]);
                                cArr5[2] = (char) (cArr5[2] + ((char) i8));
                                int length = cArr2.length;
                                char[] cArr6 = new char[length];
                                f.f2032 = 0;
                                while (true) {
                                    int i9 = f.f2032;
                                    if (i9 < length) {
                                        int i10 = (i9 + 2) % 4;
                                        int i11 = (i9 + 3) % 4;
                                        int i12 = cArr4[i9 % 4] * 32718;
                                        char c8 = cArr5[i10];
                                        char c9 = (char) ((i12 + c8) % 65535);
                                        f.f2030 = c9;
                                        cArr5[i11] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i11], 32718, c8, 65535);
                                        cArr4[i11] = c9;
                                        int i13 = f.f2032;
                                        cArr6[i13] = (char) (((((long) (c9 ^ cArr2[i13])) ^ f260) ^ ((long) f259)) ^ ((long) f262));
                                        f.f2032 = i13 + 1;
                                    } else {
                                        str4 = new String(cArr6);
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return str4;
                    }
                }, (ah.m452(ah.this, i2) || z2) ? 0L : ah.m419(ah.this));
            }
        });
        int i2 = f218 + 69;
        f217 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private synchronized void m436(boolean z2) {
        f217 = (f218 + 93) % 128;
        this.f237 = true;
        m444(true);
        int i2 = f217 + 99;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean m445(ag agVar) {
        f217 = (f218 + 115) % 128;
        boolean zMo560 = aq.m530().mo560(agVar.m404(), this.f222);
        int i2 = f218 + 71;
        f217 = i2 % 128;
        if (i2 % 2 != 0) {
            return zMo560;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private boolean m438(int i2) {
        f217 = (f218 + 65) % 128;
        if (i2 >= m414().m607()) {
            f217 = (f218 + 73) % 128;
            return true;
        }
        int i8 = f218 + 9;
        f217 = i8 % 128;
        if (i8 % 2 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m442(List<ag> list, iz izVar) {
        JSONArray jSONArray = new JSONArray();
        f217 = (f218 + 113) % 128;
        for (ag agVar : list) {
            JSONObject jSONObjectM403 = agVar.m403();
            if (!jSONObjectM403.has(m447("墉鿝᭎壭냱\ueddf䖍", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1).intern())) {
                f218 = (f217 + 103) % 128;
                try {
                    jSONObjectM403.put(m447("墉鿝᭎壭냱\ueddf䖍", 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))).intern(), jSONObjectM403.optLong(ig.f2520));
                    f217 = (f218 + 71) % 128;
                } catch (JSONException unused) {
                }
            }
            if (this.f223.m381(jSONObjectM403)) {
                f217 = (f218 + 51) % 128;
                this.f236.m2660(agVar.m407(), (iu) null);
            }
            jSONArray.put(jSONObjectM403);
        }
        this.f234.m391(jSONArray, this.f235.m2611().m2571(), new AnonymousClass2(jSONArray, list, izVar));
    }

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.ah$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 implements iz, jc.d {
        public AnonymousClass1() {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.jc.d
        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final void mo466(List<je> list) {
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        PriorityQueue priorityQueue = new PriorityQueue();
                        Iterator<je> it = list.iterator();
                        while (it.hasNext()) {
                            priorityQueue.add(new ag(it.next()));
                        }
                        ArrayList arrayList = new ArrayList();
                        for (ag agVar = (ag) priorityQueue.poll(); agVar != null; agVar = (ag) priorityQueue.poll()) {
                            if (ah.m446(ah.this, agVar)) {
                                if (TextUtils.isEmpty(agVar.m406())) {
                                    agVar.m405(ah.m412(ah.this).m2763().m620());
                                }
                                arrayList.add(agVar);
                            } else {
                                ah.m420(ah.this).m2662(agVar.m407());
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return;
                        }
                        ah.m454(ah.this, arrayList, this);
                        return;
                    }
                } catch (Exception unused) {
                    ah.m428(ah.this);
                    return;
                }
            }
            ah.m428(ah.this);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iz
        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        public final void mo467(ir irVar) {
            ah.m428(ah.this);
            ah.m453(ah.this);
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iz
        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final void mo465(ir irVar, String str) {
            ah.m428(ah.this);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m432(jb jbVar) {
        f218 = (f217 + 39) % 128;
        String strM2637 = jbVar.m2637(m447("\uf16aᖥƝ\uf119㪉፵彟鴔䱤梁ᶣ塮诅뿒\ud880ᯑ줫犈霤픹", ExpandableListView.getPackedPositionGroup(0L)).intern());
        if (!TextUtils.isEmpty(strM2637)) {
            return strM2637;
        }
        f217 = (f218 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        String string = UUID.randomUUID().toString();
        jbVar.m2640(m447("\uf16aᖥƝ\uf119㪉፵彟鴔䱤梁ᶣ塮诅뿒\ud880ᯑ줫犈霤픹", ViewConfiguration.getPressedStateDuration() >> 16).intern(), string);
        f218 = (f217 + 41) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private synchronized void m451(boolean z2) {
        try {
            int i2 = f217;
            int i8 = i2 + 97;
            f218 = i8 % 128;
            if (i8 % 2 != 0) {
                this.f228 = z2;
                throw null;
            }
            this.f228 = z2;
            int i9 = i2 + 91;
            f218 = i9 % 128;
            if (i9 % 2 != 0) {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m450(JSONObject jSONObject) {
        f217 = (f218 + 57) % 128;
        Iterator<String> it = m414().m611().iterator();
        while (it.hasNext()) {
            jSONObject.remove(it.next());
        }
        int i2 = f217 + 85;
        f218 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m435(final JSONObject jSONObject) {
        final ArrayList arrayList;
        if (q.m3013().m3032()) {
            synchronized (this) {
                arrayList = new ArrayList(this.f230);
            }
            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.ah.3
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ai) it.next()).onEventReceived(jSONObject);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m447(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f220, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f220));
                        i.f2442 = i8 + 1;
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m443(JSONObject jSONObject, iu iuVar) {
        m450(jSONObject);
        ag agVar = new ag(jc.m2649(jSONObject));
        agVar.m408(m414().m610());
        this.f236.m2660(agVar.m407(), iuVar);
        m435(agVar.m403());
        p.m2967(iuVar);
        f217 = (f218 + 111) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m433(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f219.clone();
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
                        str = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
