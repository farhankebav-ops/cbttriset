package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class y<K, T> implements s<K, T> {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f3189 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f3190 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char[] f3191 = {'6', 129, 150, 152, 151, 148, 156, 166, 156, 'r', '}', 160, 153, 161, 'N', 163, 169, 135, 136, 179, 179, 175, 183, 157, 'W', 143, 142, 133, 136, 'f', 136, '{', 130, 'z', 132, 'w', '^', 'z'};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f3192 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f3193 = 5250353211299395752L;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f3194;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private s<K, T> f3195 = new s<K, T>() { // from class: com.ironsource.adqualitysdk.sdk.i.y.5
        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ﻐ */
        public final void mo328(JSONObject jSONObject, K k, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ｋ */
        public final void mo293(JSONObject jSONObject, K k, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ﾒ */
        public final void mo332(JSONObject jSONObject, K k, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ﻐ */
        public final void mo329(JSONObject jSONObject, K k, Object obj, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ｋ */
        public final void mo331(JSONObject jSONObject, K k, Object obj, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ﾒ */
        public final void mo333(JSONObject jSONObject, K k, Object obj, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ﻛ */
        public final void mo330(JSONObject jSONObject, K k, T t3) {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.s
        /* JADX INFO: renamed from: ﾇ */
        public final void mo296(JSONObject jSONObject, K k, T t3) {
        }
    };

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private s<K, T> f3196;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private s<K, T> m3130() {
        int i2 = (f3189 + 75) % 128;
        f3190 = i2;
        s<K, T> sVar = this.f3196;
        if (sVar == null) {
            return this.f3195;
        }
        f3189 = (i2 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return sVar;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﻐ */
    public final void mo329(JSONObject jSONObject, K k, Object obj, T t3) {
        f3190 = (f3189 + 63) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3129("䦉ꕙ怙ః剗ꂧ℗⡞骧참괌", TextUtils.lastIndexOf("", '0', 0) + 528623888, "ཛ舩蘟ᅀ", "\uf8a8飔m䣝", (char) Color.green(0)).intern(), jSONObjectM3132);
        m3130().mo329(jSONObjectM3132, k, obj, t3);
        f3190 = (f3189 + 5) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m3133(s<K, T> sVar) {
        int i2 = (f3189 + 77) % 128;
        f3190 = i2;
        this.f3196 = sVar;
        int i8 = i2 + 49;
        f3189 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ */
    public abstract String mo291(T t3);

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ｋ */
    public void mo293(JSONObject jSONObject, K k, T t3) {
        f3190 = (f3189 + 69) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3129("緵뵐崳锪㾽买ᩩ㣘鱣\uf6e3쵮˶妩", ((byte) KeyEvent.getModifierMetaStateMask()) - 1739196974, "퇏嗵窘쥥", "\uf8a8飔m䣝", (char) (25978 - View.combineMeasuredStates(0, 0))).intern(), jSONObjectM3132);
        m3130().mo293(jSONObjectM3132, k, t3);
        int i2 = f3189 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f3190 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﾒ */
    public final void mo333(JSONObject jSONObject, K k, Object obj, T t3) {
        f3189 = (f3190 + 43) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3129("왙ᰡ튲\ue742廔\u0dcd\u218d\u001f啱띸ꌔⲳ\uea3b壇榰\uffbf脴釪鈯", ExpandableListView.getPackedPositionChild(0L) + 1920822417, "郚絬푲䫭", "\uf8a8飔m䣝", (char) (60884 - KeyEvent.keyCodeFromString(""))).intern(), jSONObjectM3132);
        m3130().mo333(jSONObjectM3132, k, obj, t3);
        f3189 = (f3190 + 113) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﻛ */
    public final void mo330(JSONObject jSONObject, K k, T t3) {
        f3190 = (f3189 + 63) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3129("傘ꑖ뼍\uda69陷ܕ茺쓏愱", View.combineMeasuredStates(0, 0) + 1533632921, "馺楡굛稏", "\uf8a8飔m䣝", (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern(), jSONObjectM3132);
        m3130().mo330(jSONObjectM3132, k, t3);
        int i2 = f3190 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f3189 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﾇ */
    public void mo296(JSONObject jSONObject, K k, T t3) {
        f3190 = (f3189 + 103) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3129("邢ↇ䒩⡲\u125fꭐ\uf74e\uf8f6㠏襏\ud8c7㦕ｽ횅괎ﻂ镈醲პ", (ViewConfiguration.getScrollBarSize() >> 8) - 403241075, "跖\uf707\udde7㫄", "\uf8a8飔m䣝", (char) (50397 - (KeyEvent.getMaxKeyCode() >> 16))).intern(), jSONObjectM3132);
        m3130().mo296(jSONObjectM3132, k, t3);
        int i2 = f3189 + 19;
        f3190 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﻐ */
    public final void mo328(JSONObject jSONObject, K k, T t3) {
        f3190 = (f3189 + 7) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3131(new int[]{0, 14, 50, 0}, true, "\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001").intern(), jSONObjectM3132);
        m3130().mo328(jSONObjectM3132, k, t3);
        f3190 = (f3189 + 29) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ｋ */
    public final void mo331(JSONObject jSONObject, K k, Object obj, T t3) {
        f3189 = (f3190 + 25) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3131(new int[]{14, 10, 70, 0}, false, "\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0000\u0000").intern(), jSONObjectM3132);
        m3130().mo331(jSONObjectM3132, k, obj, t3);
        f3190 = (f3189 + 93) % 128;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.s
    /* JADX INFO: renamed from: ﾒ */
    public final void mo332(JSONObject jSONObject, K k, T t3) {
        f3189 = (f3190 + 63) % 128;
        JSONObject jSONObjectM3132 = m3132(jSONObject, t3);
        m3128(m3129("ష죺메ᑰ跪\ue34e값\"娜♥鎟䥅防", TextUtils.getOffsetAfter("", 0) - 1215626594, "黬謂覷≙", "\uf8a8飔m䣝", (char) (22921 - (ViewConfiguration.getScrollDefaultDelay() >> 16))).intern(), jSONObjectM3132);
        m3130().mo332(jSONObjectM3132, k, t3);
        f3190 = (f3189 + 33) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m3129(String str, int i2, String str2, String str3, char c7) {
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
                char[] cArr4 = (char[]) cArr2.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr3.length;
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr3[i12])) ^ f3193) ^ ((long) f3194)) ^ ((long) f3192));
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m3131(int[] iArr, boolean z2, String str) throws UnsupportedEncodingException {
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
                System.arraycopy(f3191, i2, cArr, 0, i8);
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

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m3128(String str, JSONObject jSONObject) {
        String strIntern = m3131(new int[]{24, 14, 22, 1}, true, (String) null).intern();
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(m3129("㻏\udc55쏥", (-1693391271) - Color.rgb(0, 0, 0), "奡ღᾜ틩", "\uf8a8飔m䣝", (char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 59679)).intern());
        sb.append(str);
        k.m2869(strIntern, sb.toString(), jSONObject);
        f3189 = (f3190 + 3) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private JSONObject m3132(JSONObject jSONObject, T t3) {
        f3189 = (f3190 + 47) % 128;
        try {
            if (!jSONObject.has(ig.f2525)) {
                jSONObject.put(ig.f2525, mo291(t3));
            }
            if (!jSONObject.has(ig.f2520)) {
                f3190 = (f3189 + 73) % 128;
                jSONObject.put(ig.f2520, jv.m2801());
                f3189 = (f3190 + 21) % 128;
            }
            return jSONObject;
        } catch (JSONException e) {
            k.m2861(m3131(new int[]{24, 14, 22, 1}, true, (String) null).intern(), m3129("づ₊鎊䮌곉岘렐謌墆\ue75dጬ夀\ue676䠿끛繱\ue2e9芺눧橯\ueda2\uea44Ʇ\uf578䲖", (-1980507239) - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), "飵\uf3db侉１", "\uf8a8飔m䣝", (char) (ViewConfiguration.getLongPressTimeout() >> 16)).intern(), (Throwable) e);
            return jSONObject;
        }
    }
}
