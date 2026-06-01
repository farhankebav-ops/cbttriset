package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jc {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2704 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char f2705 = 62247;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static char f2706 = 10229;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2707 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static char f2708 = 38930;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f2709 = 19383;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final int f2710;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final String f2711;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final String f2712;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final jb f2713;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        /* JADX INFO: renamed from: ﻐ */
        void mo475(int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface d {
        /* JADX INFO: renamed from: ﻛ */
        void mo466(List<je> list);
    }

    public jc(String str, String str2, jb jbVar) {
        this(str, str2, jbVar, (byte) 0);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static je m2649(JSONObject jSONObject) {
        je jeVar = new je(jSONObject);
        f2704 = (f2707 + 55) % 128;
        return jeVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ jb m2651(jc jcVar) {
        int i2 = f2707;
        int i8 = i2 + 39;
        f2704 = i8 % 128;
        int i9 = i8 % 2;
        jb jbVar = jcVar.f2713;
        if (i9 != 0) {
            throw null;
        }
        int i10 = i2 + 57;
        f2704 = i10 % 128;
        if (i10 % 2 == 0) {
            return jbVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ int m2653(jc jcVar) {
        int i2 = f2704 + 13;
        int i8 = i2 % 128;
        f2707 = i8;
        int i9 = i2 % 2 == 0 ? 29428 : 10000;
        f2704 = (i8 + 21) % 128;
        return i9;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m2657(jc jcVar) {
        int i2 = f2707 + 71;
        f2704 = i2 % 128;
        int i8 = i2 % 2;
        String strM2654 = jcVar.m2654();
        if (i8 != 0) {
            int i9 = 94 / 0;
        }
        return strM2654;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2659(final int i2, final d dVar) {
        jb.m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.4

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static byte[] f2723 = {87, 93, 103, 26, 107, 110, 73, 86, 83, -1, -103, -63, -88, -60, -100, -30, -87, -106, -66, -59, -71, 66, 111, 84, -85, -83, 77, -14, 27, 91, -97, 81, 90, -93, -11, 86, 30, -94, -85, 73, -77, -33, 24, 89, 87, -97, -90, 90, -27, 29, 83, -75, 88, 85, -87, -27, 8, -25, 27, -82, 92, 81, -94, -120, 0, 0, 0, 0, 0};

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static int f2724 = 950129968;

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static int f2725 = 1;

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f2726 = 0;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static short[] f2727 = null;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int f2728 = 65;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f2729 = -306024298;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m2664(int i8, short s7, int i9, byte b8, int i10) {
                String string;
                synchronized (n.f2979) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int i11 = f2728;
                        int i12 = i8 + i11;
                        int i13 = i12 == -1 ? 1 : 0;
                        if (i13 != 0) {
                            byte[] bArr = f2723;
                            i12 = bArr != null ? (byte) (bArr[f2729 + i9] + i11) : (short) (f2727[f2729 + i9] + i11);
                        }
                        if (i12 > 0) {
                            n.f2984 = ((i9 + i12) - 2) + f2729 + i13;
                            n.f2982 = b8;
                            char c7 = (char) (i10 + f2724);
                            n.f2981 = c7;
                            sb.append(c7);
                            n.f2980 = n.f2981;
                            n.f2983 = 1;
                            while (n.f2983 < i12) {
                                byte[] bArr2 = f2723;
                                if (bArr2 != null) {
                                    int i14 = n.f2984;
                                    n.f2984 = i14 - 1;
                                    n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i14] + s7)) ^ n.f2982));
                                } else {
                                    short[] sArr = f2727;
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                float f4;
                long j;
                final ArrayList arrayList = new ArrayList();
                float f8 = 0.0f;
                f2726 = (f2725 + 15) % 128;
                for (String str : jc.m2651(jc.this).m2638(jc.m2655(jc.this, m2664((-64) - TextUtils.getOffsetAfter("", 0), (short) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 85), 306024298 - (ViewConfiguration.getScrollBarSize() >> 8), (byte) ((-127) - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), KeyEvent.getDeadChar(0, 0) - 950129926).intern()), i2).values()) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        f4 = f8;
                        try {
                            j = 0;
                            try {
                                arrayList.add(new je(jSONObject.getJSONObject(m2664((-57) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (short) (38 - Color.alpha(0)), View.combineMeasuredStates(0, 0) + 306024298, (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) - 112), (Process.myPid() >> 22) - 950129856).intern()), jSONObject.optString(m2664(ExpandableListView.getPackedPositionChild(0L) - 60, (short) ((ViewConfiguration.getTapTimeout() >> 16) - 45), Color.red(0) + 306024305, (byte) ((ViewConfiguration.getScrollFriction() > f4 ? 1 : (ViewConfiguration.getScrollFriction() == f4 ? 0 : -1)) - 47), (-950129851) - Drawable.resolveOpacity(0, 0)).intern())));
                            } catch (Exception unused) {
                                k.m2867(jc.m2657(jc.this), m2664(View.MeasureSpec.getSize(0) - 53, (short) (83 - (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1))), 306024308 - TextUtils.indexOf("", ""), (byte) (21 - (KeyEvent.getMaxKeyCode() >> 16)), (Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)) - 950129902).intern(), a0.d(new StringBuilder(), m2664((-21) - View.resolveSize(0, 0), (short) (1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 306024318, (byte) ((-90) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (-950129900) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), str), true);
                            }
                        } catch (Exception unused2) {
                            j = 0;
                            k.m2867(jc.m2657(jc.this), m2664(View.MeasureSpec.getSize(0) - 53, (short) (83 - (ViewConfiguration.getGlobalActionKeyTimeout() > j ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == j ? 0 : -1))), 306024308 - TextUtils.indexOf("", ""), (byte) (21 - (KeyEvent.getMaxKeyCode() >> 16)), (Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)) - 950129902).intern(), a0.d(new StringBuilder(), m2664((-21) - View.resolveSize(0, 0), (short) (1 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (ViewConfiguration.getZoomControlsTimeout() > j ? 1 : (ViewConfiguration.getZoomControlsTimeout() == j ? 0 : -1)) + 306024318, (byte) ((-90) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (-950129900) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), str), true);
                            f8 = f4;
                        }
                    } catch (Exception unused3) {
                        f4 = f8;
                    }
                    f8 = f4;
                }
                p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.4.3
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        dVar.mo466(arrayList);
                    }
                });
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﾒ */
            public final void mo719(Throwable th) {
                super.mo719(th);
                p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.4.1
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        dVar.mo466(new ArrayList());
                    }
                });
                f2725 = (f2726 + 45) % 128;
            }
        });
        int i8 = f2707 + 71;
        f2704 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 6 / 0;
        }
    }

    private jc(String str, String str2, jb jbVar, byte b8) {
        this.f2711 = str2;
        this.f2710 = 10000;
        this.f2712 = str;
        this.f2713 = jbVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2652(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2708)) ^ ((c8 >>> 5) + f2706)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2705) ^ ((c9 + i9) ^ ((c9 << 4) + f2709))));
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m2655(jc jcVar, String str) {
        f2704 = (f2707 + 89) % 128;
        String strM2650 = jcVar.m2650(str);
        int i2 = f2704 + 111;
        f2707 = i2 % 128;
        if (i2 % 2 != 0) {
            return strM2650;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m2658(jc jcVar, je jeVar) {
        f2704 = (f2707 + 59) % 128;
        String strM2656 = jcVar.m2656(jeVar);
        f2707 = (f2704 + 47) % 128;
        return strM2656;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2660(final je jeVar, final iu iuVar) {
        jb.m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.5

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static char f2736 = 13986;

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static int f2737 = 1;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f2738;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static long f2739;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static int f2740;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static String m2665(String str, char c7, String str2, int i2, String str3) {
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
                        cArr5[2] = (char) (cArr5[2] + ((char) i2));
                        int length = cArr2.length;
                        char[] cArr6 = new char[length];
                        f.f2032 = 0;
                        while (true) {
                            int i8 = f.f2032;
                            if (i8 < length) {
                                int i9 = (i8 + 2) % 4;
                                int i10 = (i8 + 3) % 4;
                                int i11 = cArr4[i8 % 4] * 32718;
                                char c8 = cArr5[i9];
                                char c9 = (char) ((i11 + c8) % 65535);
                                f.f2030 = c9;
                                cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                                cArr4[i10] = c9;
                                int i12 = f.f2032;
                                cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f2739) ^ ((long) f2740)) ^ ((long) f2736));
                                f.f2032 = i12 + 1;
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                f2737 = (f2738 + 69) % 128;
                if (jc.m2651(jc.this).m2644(jc.m2655(jc.this, m2665("稇㧂犟╿", (char) (View.getDefaultSize(0, 0) + 32626), "˒", (-1623604614) - View.getDefaultSize(0, 0), "\u0000\u0000\u0000\u0000").intern())) <= jc.m2653(jc.this)) {
                    String strM2658 = jc.m2658(jc.this, jeVar);
                    if (TextUtils.isEmpty(strM2658)) {
                        k.m2867(jc.m2657(jc.this), m2665("轭뻠\ud942祟", (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), "\uf2b1拠珯彧酥㝡య蹘톹媼螺\ue8b1", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1, "\u0000\u0000\u0000\u0000").intern(), m2665("㌗핍礀ᢙ", (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 39289), "渻筱\ud9b5蠙舳\ueb82琬ㆶ⎷탿㼭䱩䡓ꤥ顙즽湝䪱嶺ᾓ읃䘤॰뒃ଔⷱ㎿\u181e쨪ꜚ䭑겇嗊鼺䐝ꅾ씫녎좸⛜\u2458枔麯큅穽", TextUtils.indexOf("", "", 0) + 13978931, "\u0000\u0000\u0000\u0000").intern(), true);
                        return;
                    }
                    try {
                        String string = jeVar.m2684().toString();
                        f2738 = (f2737 + 17) % 128;
                        k.m2866(jc.m2657(jc.this), m2665("轭뻠\ud942祟", (char) (ViewConfiguration.getTapTimeout() >> 16), "\uf2b1拠珯彧酥㝡య蹘톹媼螺\ue8b1", Color.alpha(0), "\u0000\u0000\u0000\u0000").intern(), m2665("㠦塦\u17ebଞ", (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 7703), "땖\udb01엚˯␋褖흄\uefb8㟱\ud87e栮ּ瑉釄㑆", (ViewConfiguration.getScrollBarFadeDuration() >> 16) - 346528200, "\u0000\u0000\u0000\u0000").intern(), string, true);
                        jc.m2651(jc.this).m2640(strM2658, string);
                    } catch (JSONException unused) {
                        return;
                    }
                }
                iu iuVar2 = iuVar;
                if (iuVar2 != null) {
                    p.m2967(iuVar2);
                }
            }
        });
        int i2 = f2704 + 91;
        f2707 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String m2650(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2711);
        sb.append(str);
        String string = sb.toString();
        int i2 = f2707 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f2704 = i2 % 128;
        if (i2 % 2 == 0) {
            return string;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m2661(final b bVar) {
        jb.m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.3

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int[] f2716 = {-983644487, 1559506784, -571811020, -804378807, -231782613, -442676875, 1144708367, -622082578, -1425127842, -1562387873, -817292036, -1818619706, 720688820, -734158325, -819377400, 2015691269, -713258691, 1356507939};

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static int f2717 = 1;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static int f2718;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static String m2663(int[] iArr, int i2) {
                String str;
                synchronized (com.ironsource.adqualitysdk.sdk.i.d.f1664) {
                    try {
                        char[] cArr = new char[4];
                        char[] cArr2 = new char[iArr.length << 1];
                        int[] iArr2 = (int[]) f2716.clone();
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                final int iM2644 = jc.m2651(jc.this).m2644(jc.m2655(jc.this, m2663(new int[]{-1635730098, -814473502}, 1 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern()));
                p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.3.4
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        bVar.mo475(iM2644);
                    }
                });
                int i2 = f2717 + 11;
                f2718 = i2 % 128;
                if (i2 % 2 != 0) {
                    int i8 = 35 / 0;
                }
            }
        });
        int i2 = f2707 + 49;
        f2704 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m2662(final je jeVar) {
        jb.m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jc.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                jc.m2651(jc.this).m2642(jc.m2658(jc.this, jeVar));
            }
        });
        int i2 = f2704 + 105;
        f2707 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String m2656(je jeVar) {
        int i2 = f2707 + 93;
        f2704 = i2 % 128;
        int i8 = i2 % 2;
        String strM2650 = m2650(jeVar.m2682());
        if (i8 != 0) {
            int i9 = 61 / 0;
        }
        f2704 = (f2707 + 69) % 128;
        return strM2650;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String m2654() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2652("Ί햯⑉导ꛦ\ud9ed꒦ⳅệ铚벊ᶨ蒋툔", TextUtils.lastIndexOf("", '0') + 15).intern());
        sb.append(this.f2712);
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2652("갾̪", 1 - TextUtils.indexOf("", "")));
        f2704 = (f2707 + 105) % 128;
        return strZ;
    }
}
