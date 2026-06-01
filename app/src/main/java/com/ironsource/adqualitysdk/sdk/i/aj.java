package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import com.ironsource.adqualitysdk.sdk.ISAdQualityAdType;
import com.ironsource.adqualitysdk.sdk.ISAdQualityCustomMediationRevenue;
import com.ironsource.adqualitysdk.sdk.ISAdQualityMediationNetwork;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class aj {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f315 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f316 = 1;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final aw f321;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f322;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f319 = {128, 265, 269, 261, 265, 265, 247, 252, 266, 264, 266, 262, 257, 258, 256, 245, 249, 266, 269, 271, 272, 248, 240, 256, 262, 271, 270, 253, 252, 266, 268, 249, '!', 'R', 'g', 'J', 'M', 'J', 'I', 'l', 'i', 'i', 'B', 'A', 'l', 't', 's', 'q', 'n', 'F', 'F', 'i', 'd', 'f', 'e', 'j', 'n', 'l', 'n', 'G', 'I', 'k', 'm', 'm', 'i', 'q', 'm', 'O', '-', 'I', 'k', 'm', 'm', 'i', 'q', 'm', 'B', 'I', 'm', 'k', 'r', 'p', 'h', 'B', 'A', 'c', 'B', 'G', 'n', 'n', 'M', 'M', 'i', 'f', 'd', 'j', 'n', 'o', 'm', '5', 'n', 'p', 's', 'u', 'l', 'i', 'G', 'G', 'n', 'l', 'n', 'j', 'e', 'f', 'd', 'i', 'F', 'C', 'j', 'k', 'n', 's', 'n', 'k', 'F', '-', 'O', 'm', 'q', 'i', 'm', 'm', 'k', 'I', 'G', 'n', 'l', 'n', 'j', 'e', 'f', 'd', 'i', 'F', 'F', 'n', 'q', 's', 't', 'l', 'A', 'B', 'i', 'i', 'l', 'I', 'J', 'M', 'J', 'g', 'R', '9', 'u', 't', 'y', '|', 't', 'r', 'v', 't', 'd', 'j', 'o', 'p', 't', 's', 'f', 'q', ']', 183, 187, 190, 185, 186, 188, 180, '9', 'k', 'f', 'n', 'q'};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f320 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f318 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f317 = 37969;

    public aj(aw awVar) {
        this.f321 = awVar;
        jf.m2685().m2686(new jj() { // from class: com.ironsource.adqualitysdk.sdk.i.aj.3
            @Override // com.ironsource.adqualitysdk.sdk.i.jj, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity) {
                p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aj.3.4

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static int f324 = 1;

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static short[] f325 = null;

                    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                    private static int f326 = 0;

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private static int f327 = -265187829;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static int f328 = 523073688;

                    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                    private static byte[] f329 = {-52, -50, 56, 35, 38, -36, 35, -17, 8, -48, 33, 36, -44, -24, 29, 34, -37, 40, -50, 37, -40, 34, 37, 0};

                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                    private static int f330 = 70;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static String m498(int i2, short s7, int i8, byte b8, int i9) {
                        String string;
                        synchronized (n.f2979) {
                            try {
                                StringBuilder sb = new StringBuilder();
                                int i10 = f330;
                                int i11 = i2 + i10;
                                int i12 = i11 == -1 ? 1 : 0;
                                if (i12 != 0) {
                                    byte[] bArr = f329;
                                    i11 = bArr != null ? (byte) (bArr[f327 + i8] + i10) : (short) (f325[f327 + i8] + i10);
                                }
                                if (i11 > 0) {
                                    n.f2984 = ((i8 + i11) - 2) + f327 + i12;
                                    n.f2982 = b8;
                                    char c7 = (char) (i9 + f328);
                                    n.f2981 = c7;
                                    sb.append(c7);
                                    n.f2980 = n.f2981;
                                    n.f2983 = 1;
                                    while (n.f2983 < i11) {
                                        byte[] bArr2 = f329;
                                        if (bArr2 != null) {
                                            int i13 = n.f2984;
                                            n.f2984 = i13 - 1;
                                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                                        } else {
                                            short[] sArr = f325;
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

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() throws Exception {
                        f324 = (f326 + 23) % 128;
                        if (aj.m492(aj.this)) {
                            f324 = (f326 + 57) % 128;
                            aj.m494(aj.this).m710(m498((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 47, (short) TextUtils.getOffsetBefore("", 0), Color.green(0) + 265187829, (byte) (TextUtils.lastIndexOf("", '0') - 34), Drawable.resolveOpacity(0, 0) - 523073579).intern());
                            aj.m496(aj.this, false);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ JSONObject m487(aj ajVar, ISAdQualityCustomMediationRevenue iSAdQualityCustomMediationRevenue) {
        f316 = (f315 + 11) % 128;
        JSONObject jSONObjectM486 = m486(iSAdQualityCustomMediationRevenue);
        f316 = (f315 + 9) % 128;
        return jSONObjectM486;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean m490(ISAdQualityAdType iSAdQualityAdType) {
        if (iSAdQualityAdType != ISAdQualityAdType.INTERSTITIAL) {
            f315 = (f316 + 11) % 128;
            if (iSAdQualityAdType != ISAdQualityAdType.VIDEO && iSAdQualityAdType != ISAdQualityAdType.REWARDED_VIDEO && iSAdQualityAdType != ISAdQualityAdType.REWARDED) {
                f315 = (f316 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
                return false;
            }
        }
        int i2 = f316 + 49;
        f315 = i2 % 128;
        if (i2 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m492(aj ajVar) {
        int i2 = f315;
        int i8 = i2 + 99;
        f316 = i8 % 128;
        int i9 = i8 % 2;
        boolean z2 = ajVar.f322;
        if (i9 == 0) {
            throw null;
        }
        f316 = (i2 + 65) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static boolean m493(ISAdQualityMediationNetwork iSAdQualityMediationNetwork) {
        if (iSAdQualityMediationNetwork == null || TextUtils.isEmpty(m491(iSAdQualityMediationNetwork))) {
            f315 = (f316 + 35) % 128;
            return false;
        }
        f315 = (f316 + 39) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ aw m494(aj ajVar) {
        int i2 = f316;
        f315 = (i2 + 83) % 128;
        aw awVar = ajVar.f321;
        int i8 = i2 + 113;
        f315 = i8 % 128;
        if (i8 % 2 == 0) {
            return awVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static JSONObject m486(ISAdQualityCustomMediationRevenue iSAdQualityCustomMediationRevenue) {
        dg dgVar = new dg();
        dgVar.m1942(true);
        dgVar.m1944(Double.valueOf(iSAdQualityCustomMediationRevenue.getRevenue()));
        dgVar.m1941(m491(iSAdQualityCustomMediationRevenue.getMediationNetwork()));
        dgVar.m1943(iSAdQualityCustomMediationRevenue.getPlacement());
        JSONObject jSONObjectM1940 = dgVar.m1940();
        f316 = (f315 + 47) % 128;
        return jSONObjectM1940;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m489(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f319, i2, cArr, 0, i8);
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ boolean m496(aj ajVar, boolean z2) {
        int i2 = f315 + 57;
        f316 = i2 % 128;
        int i8 = i2 % 2;
        ajVar.f322 = z2;
        if (i8 != 0) {
            return z2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m497(@NonNull final ISAdQualityCustomMediationRevenue iSAdQualityCustomMediationRevenue) {
        int i2 = f315 + 57;
        f316 = i2 % 128;
        if (i2 % 2 == 0) {
            m495(iSAdQualityCustomMediationRevenue);
            throw null;
        }
        if (m495(iSAdQualityCustomMediationRevenue)) {
            p.m2973(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.aj.5

                /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
                private static int f332 = 1;

                /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                private static int f333 = 0;

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static long f334 = 1747949037909725973L;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static int f335;

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static char f336;

                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    f333 = (f332 + 5) % 128;
                    aj.m494(aj.this).m711(m499("䦑蕑듚쥻", (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), "\udd6c丣缁髨緌ﱜ䜣廨免\uf5cb\ue4c4쿂\uec6b⫙형눫ល䋛ﾍ≠퐒", (-628797111) - TextUtils.indexOf("", ""), "匕鈘\uf663ᡁ").intern(), Collections.singletonList(aj.m487(aj.this, iSAdQualityCustomMediationRevenue)));
                    aj.m496(aj.this, true);
                    f332 = (f333 + 83) % 128;
                }

                /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                private static String m499(String str, char c7, String str2, int i8, String str3) {
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
                                    cArr6[i13] = (char) (((((long) (c9 ^ cArr2[i13])) ^ f334) ^ ((long) f335)) ^ ((long) f336));
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
            }, aq.m530().mo547());
        }
        f315 = (f316 + 107) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private boolean m495(ISAdQualityCustomMediationRevenue iSAdQualityCustomMediationRevenue) {
        if (iSAdQualityCustomMediationRevenue == null) {
            return false;
        }
        f315 = (f316 + 31) % 128;
        if (iSAdQualityCustomMediationRevenue.getRevenue() < 0.0d) {
            int i2 = f315 + 1;
            f316 = i2 % 128;
            if (i2 % 2 == 0) {
                k.m2868(m489("\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", true, new int[]{0, 32, 156, 0}).intern(), m489("\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", true, new int[]{32, 67, 0, 0}).intern());
                return false;
            }
            k.m2868(m489("\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", true, new int[]{0, 32, 156, 0}).intern(), m489("\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", false, new int[]{32, 67, 0, 0}).intern());
            return false;
        }
        if (!m493(iSAdQualityCustomMediationRevenue.getMediationNetwork())) {
            f315 = (f316 + 29) % 128;
            k.m2868(m489("\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", true, new int[]{0, 32, 156, 0}).intern(), m489("\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000", true, new int[]{99, 62, 0, 0}).intern());
            return false;
        }
        if (m490(iSAdQualityCustomMediationRevenue.getAdType())) {
            return true;
        }
        f316 = (f315 + 39) % 128;
        k.m2868(m489("\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001", true, new int[]{0, 32, 156, 0}).intern(), m488("㩚ݨ漰\uf3cf", (char) (53103 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), "舃鼫溲ꬓע賡흕壋쯶⤂粽蠌쐴렑籑洯阈ꄬ狼鋋㻧ﴪ푤몟♖烂뽊\u0bc4䑎\ue5d8蒓\udc42\udcbc뤙ꈵᚘ炩ꛕ큛伤犲➚꯳颼Ⓥ衬﹦\uf25b鼺삧呇֦徎䙘酫\ue9fcಐ琲㘅\uebe4！ﮦ큐腫뾤\uecf9Ǳꎲ렞褘\ueb2cꥡ\uee79ᙣꔓ㎯永ⵦ촣㖡\uea5d咊葨勄ᯋ脓罠┲\ude4b튴寯騪봉揯ﻨ\ufae8\u0dcd\uf81fധ窽\udad1⟳鵽鲡ꀸ䱺ꖁ\ue55c", (Process.getThreadPriority(0) + 20) >> 6, "\u0000\u0000\u0000\u0000").intern());
        return false;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m491(ISAdQualityMediationNetwork iSAdQualityMediationNetwork) {
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.ADMOB) {
            return m488("咃唞쳤蹳", (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 29644), "邶䗵\ue15e\udeaa䎲", (Process.myTid() >> 22) - 464183724, "\u0000\u0000\u0000\u0000").intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.DT_FAIR_BID) {
            return m489("\u0001\u0001\u0001\u0000\u0001\u0000\u0001", true, new int[]{161, 7, 15, 0}).intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.HELIUM) {
            return m488("髆㗺ᡎ눒", (char) (4632 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), "᳁細ԇ\u0adb榊뮲", KeyEvent.normalizeMetaState(0), "\u0000\u0000\u0000\u0000").intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.LEVEL_PLAY) {
            int i2 = f315 + 105;
            f316 = i2 % 128;
            return i2 % 2 == 0 ? m489(null, false, new int[]{168, 10, 1, 2}).intern() : m489(null, true, new int[]{168, 10, 1, 2}).intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.MAX) {
            int i8 = f315 + 83;
            f316 = i8 % 128;
            return i8 % 2 == 0 ? m489("\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001", false, new int[]{178, 8, 76, 0}).intern() : m489("\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001", true, new int[]{178, 8, 76, 0}).intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.UNITY) {
            f315 = (f316 + 15) % 128;
            return m488("처ꮛ儡뚁", (char) TextUtils.getOffsetBefore("", 0), "\ue450㢼ꈋ̍\ud923ꤍ迲ⅽ", TextUtils.getCapsMode("", 0, 0), "\u0000\u0000\u0000\u0000").intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.SELF_MEDIATED) {
            int i9 = f315 + 53;
            f316 = i9 % 128;
            return i9 % 2 == 0 ? m488("奉㊺\uf56dꞅ", (char) KeyEvent.getDeadChar(0, 0), "ꡳ႕ꏭ箪셰읮酪ঢ춙驛␃\uf477", ViewConfiguration.getFadingEdgeLength() + 55, "\u0000\u0000\u0000\u0000").intern() : m488("奉㊺\uf56dꞅ", (char) KeyEvent.getDeadChar(0, 0), "ꡳ႕ꏭ箪셰읮酪ঢ춙驛␃\uf477", ViewConfiguration.getFadingEdgeLength() >> 16, "\u0000\u0000\u0000\u0000").intern();
        }
        if (iSAdQualityMediationNetwork == ISAdQualityMediationNetwork.OTHER) {
            int i10 = f316 + 111;
            f315 = i10 % 128;
            return i10 % 2 != 0 ? m489("\u0000\u0001\u0001\u0000\u0001", false, new int[]{186, 5, 0, 0}).intern() : m489("\u0000\u0001\u0001\u0000\u0001", true, new int[]{186, 5, 0, 0}).intern();
        }
        f315 = (f316 + 75) % 128;
        return "";
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m488(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f320) ^ ((long) f318)) ^ ((long) f317));
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
}
