package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class ae {

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static int f159 = 0;

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private static int f160 = 1;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static short[] f164 = null;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f166 = -55440258;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f168 = 26;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f169 = 2090261893;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private int f170;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Boolean f171 = null;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private long f172;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private long f173;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private long f174;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private long f175;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static byte[] f167 = {13, -21, 17, -5, -1, -3, 10, 5, -11, -11, 38, -29, 3, 12, -19, 1, 14, -8, 4, 21, -1, -1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static char f162 = 55973;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static char f161 = 54129;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static char f163 = 39008;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static char f165 = 1073;

    public ae(int i2) {
        this.f170 = i2;
        aq.m530().mo559(new at() { // from class: com.ironsource.adqualitysdk.sdk.i.ae.2

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static int f176 = 0;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int f177 = 1;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static long f178 = -6440169920918320696L;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static String m382(String str, int i8) {
                String str2;
                Object charArray = str;
                if (str != null) {
                    charArray = str.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (i.f2441) {
                    try {
                        char[] cArrM2497 = i.m2497(f178, cArr, i8);
                        i.f2442 = 4;
                        while (true) {
                            int i9 = i.f2442;
                            if (i9 < cArrM2497.length) {
                                i.f2443 = i9 - 4;
                                cArrM2497[i9] = (char) (((long) (cArrM2497[i9] ^ cArrM2497[i9 % 4])) ^ (((long) r2) * f178));
                                i.f2442 = i9 + 1;
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

            @Override // com.ironsource.adqualitysdk.sdk.i.at
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            public final void mo383() {
                f177 = (f176 + 5) % 128;
                ar arVarMo544 = aq.m530().mo544();
                long jM604 = arVarMo544.m604();
                if (jM604 == 0) {
                    ae.m376(ae.this, Boolean.FALSE);
                    jM604 = arVarMo544.m605();
                    kd.m2919(m382("䠲쎫訸䡦\uea21쨊駅\uf71c潡\uf337냩긴\u0602鯰\ueb91臗㴱볫ʺ磶퓜斊㩒厜诠", ExpandableListView.getPackedPositionGroup(0L)).intern(), m382("닥᭑덄늠ꆳያꂦ버閷⮙覝\ue5a5ﲅ䌾틱쩟쟱搐㯚㍬⹅뵪̱᠙焳활搆䅫塑\uefb0䵹\ua9ceꍶ\u008d陕軦讕", KeyEvent.normalizeMetaState(0)).intern(), null, false);
                } else {
                    ae.m376(ae.this, Boolean.TRUE);
                    f177 = (f176 + 95) % 128;
                }
                ae.m375(ae.this, arVarMo544.m602());
                ae.m378(ae.this, arVarMo544.m605());
                ae aeVar = ae.this;
                ae.m371(aeVar, jM604 - ae.m374(aeVar));
                ae aeVar2 = ae.this;
                ae.m368(aeVar2, jM604 - ae.m370(aeVar2));
            }
        });
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ long m368(ae aeVar, long j) {
        int i2 = (f159 + 7) % 128;
        f160 = i2;
        aeVar.f174 = j;
        int i8 = i2 + 5;
        f159 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 31 / 0;
        }
        return j;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ long m370(ae aeVar) {
        int i2 = f160 + 15;
        f159 = i2 % 128;
        if (i2 % 2 == 0) {
            return aeVar.f173;
        }
        long j = aeVar.f173;
        int i8 = 60 / 0;
        return j;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ long m374(ae aeVar) {
        int i2 = f160 + 59;
        f159 = i2 % 128;
        if (i2 % 2 == 0) {
            return aeVar.f172;
        }
        long j = aeVar.f172;
        int i8 = 74 / 0;
        return j;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ long m378(ae aeVar, long j) {
        int i2 = f160 + 95;
        f159 = i2 % 128;
        int i8 = i2 % 2;
        aeVar.f173 = j;
        if (i8 != 0) {
            int i9 = 57 / 0;
        }
        return j;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m381(JSONObject jSONObject) {
        int i2 = f159 + 5;
        f160 = i2 % 128;
        if (i2 % 2 == 0) {
            m369(jSONObject);
            throw null;
        }
        if (!m369(jSONObject) && this.f171 != null) {
            try {
                m377(jSONObject);
                return true;
            } catch (Exception e) {
                kd.m2919(m379((-5) - (Process.myTid() >> 22), (short) ExpandableListView.getPackedPositionGroup(0L), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 55440257, (byte) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 2090261810).intern(), m367("邐岹牨郦萁⃒Ϋ帲뛴浭僧韼癈忌▔忏슉㺆容ᒏ\ue483ꩋ艃狆\ue633唈", 26 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern(), e, false);
            }
        }
        int i8 = f159 + 107;
        f160 = i8 % 128;
        if (i8 % 2 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean m369(JSONObject jSONObject) {
        f160 = (f159 + 55) % 128;
        if (!jSONObject.has(m367("㠪ಞ워\uea76", 2 - TextUtils.indexOf((CharSequence) "", '0')).intern()) && !jSONObject.has(m367("驲ᾘ워\uea76", 3 - View.getDefaultSize(0, 0)).intern())) {
            return false;
        }
        int i2 = f160 + 69;
        f159 = i2 % 128;
        if (i2 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ long m371(ae aeVar, long j) {
        int i2 = f160 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        int i8 = i2 % 128;
        f159 = i8;
        int i9 = i2 % 2;
        aeVar.f175 = j;
        if (i9 != 0) {
            int i10 = 62 / 0;
        }
        int i11 = i8 + 43;
        f160 = i11 % 128;
        if (i11 % 2 == 0) {
            int i12 = 61 / 0;
        }
        return j;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ long m375(ae aeVar, long j) {
        int i2 = f159;
        int i8 = i2 + 115;
        f160 = i8 % 128;
        int i9 = i8 % 2;
        aeVar.f172 = j;
        if (i9 == 0) {
            int i10 = 79 / 0;
        }
        f160 = (i2 + 79) % 128;
        return j;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m380(JSONObject jSONObject, boolean z2) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(m367("袑\uf46e얍틠墫\u038d각筻茵ꏚ", 9 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern());
            if (jSONObjectOptJSONObject != null) {
                Long lValueOf = null;
                if (z2) {
                    f160 = (f159 + 105) % 128;
                    long jOptLong = jSONObjectOptJSONObject.optLong(m379(Color.green(0) - 25, (short) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), 55440281 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (byte) (TextUtils.lastIndexOf("", '0', 0) + 1), (Process.myPid() >> 22) - 2090261776).intern());
                    if (jOptLong > 0) {
                        int i2 = f160 + 41;
                        f159 = i2 % 128;
                        lValueOf = i2 % 2 != 0 ? Long.valueOf(jOptLong - this.f175) : Long.valueOf(jOptLong + this.f175);
                    }
                    f159 = (f160 + 79) % 128;
                } else {
                    long jOptLong2 = jSONObjectOptJSONObject.optLong(m367("\ue633唈", 1 - (ViewConfiguration.getTouchSlop() >> 8)).intern());
                    if (jOptLong2 > 0) {
                        lValueOf = Long.valueOf(jOptLong2 + this.f174);
                    }
                }
                if (lValueOf != null) {
                    jSONObjectOptJSONObject.put(m367("\ue633唈", 1 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern(), lValueOf);
                }
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m372(JSONObject jSONObject, boolean z2) {
        long jOptLong;
        long j;
        f160 = (f159 + 25) % 128;
        if (jSONObject.has(m379((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) - 23, (short) (MotionEvent.axisFromString("") + 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 55440279, (byte) Color.blue(0), View.resolveSize(0, 0) - 2090261778).intern())) {
            if (z2) {
                f160 = (f159 + 115) % 128;
                jOptLong = jSONObject.optLong(m367("㓳踞\ue633唈", 3 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern());
                j = this.f175;
            } else {
                jOptLong = jSONObject.optLong(m379((-24) - ((byte) KeyEvent.getModifierMetaStateMask()), (short) (ViewConfiguration.getScrollBarSize() >> 8), 38663063 - Color.rgb(0, 0, 0), (byte) (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 2090261778).intern());
                j = this.f174;
            }
            try {
                jSONObject.put(m379((-24) - TextUtils.lastIndexOf("", '0', 0), (short) (MotionEvent.axisFromString("") + 1), 55440279 - (ViewConfiguration.getTouchSlop() >> 8), (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) - 2090261778).intern(), jOptLong + j);
                return;
            } catch (JSONException unused) {
            }
        }
        int i2 = f160 + 73;
        f159 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 69 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ Boolean m376(ae aeVar, Boolean bool) {
        int i2 = f159 + 35;
        int i8 = i2 % 128;
        f160 = i8;
        int i9 = i2 % 2;
        aeVar.f171 = bool;
        if (i9 == 0) {
            int i10 = 36 / 0;
        }
        f159 = (i8 + 31) % 128;
        return bool;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m377(JSONObject jSONObject) {
        long jOptLong;
        f159 = (f160 + 61) % 128;
        try {
            boolean z2 = true;
            if (jSONObject.optInt(m367("橜쀃渮䡶", Process.getGidForName("") + 4).intern(), 1) == this.f170) {
                jOptLong = jSONObject.optLong(m379(TextUtils.lastIndexOf("", '0', 0, 0) - 23, (short) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 55440278, (byte) Color.red(0), (-2090261776) - Gravity.getAbsoluteGravity(0, 0)).intern()) + this.f175;
                jSONObject.put(m367("㠪ಞ워\uea76", 3 - (Process.myPid() >> 22)).intern(), this.f175);
            } else {
                int i2 = f160 + 111;
                f159 = i2 % 128;
                if (i2 % 2 == 0) {
                    if (m373(jSONObject)) {
                        jOptLong = jSONObject.optLong(m379(TextUtils.lastIndexOf("", '0', 0, 0) - 23, (short) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 55440278, (byte) Color.red(0), (-2090261776) - Gravity.getAbsoluteGravity(0, 0)).intern()) + this.f175;
                        jSONObject.put(m367("㠪ಞ워\uea76", 3 - (Process.myPid() >> 22)).intern(), this.f175);
                    } else {
                        jOptLong = jSONObject.optLong(m367("洗Ꚉ몂㎅", 2 - TextUtils.lastIndexOf("", '0', 0)).intern()) + this.f174;
                        jSONObject.put(m367("驲ᾘ워\uea76", (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3).intern(), this.f174);
                        z2 = false;
                    }
                } else {
                    m373(jSONObject);
                    throw null;
                }
            }
            jSONObject.put(ig.f2520, jOptLong);
            if (!this.f171.booleanValue()) {
                jSONObject.put(m367("驲ᾘ몂㎅", 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern(), false);
            }
            m372(jSONObject, z2);
            m380(jSONObject, z2);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m367(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f162)) ^ ((c8 >>> 5) + f163)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f161) ^ ((c9 + i9) ^ ((c9 << 4) + f165))));
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean m373(JSONObject jSONObject) {
        f159 = (f160 + 49) % 128;
        if (Math.abs((this.f173 - this.f172) - (jSONObject.optLong(m367("洗Ꚉ몂㎅", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2).intern()) - jSONObject.optLong(m379(View.MeasureSpec.makeMeasureSpec(0, 0) - 24, (short) View.resolveSize(0, 0), (ViewConfiguration.getTouchSlop() >> 8) + 55440278, (byte) TextUtils.getOffsetAfter("", 0), (-2090261775) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern()))) > 10) {
            return false;
        }
        int i2 = (f160 + 37) % 128;
        f159 = i2;
        int i8 = i2 + 53;
        f160 = i8 % 128;
        if (i8 % 2 != 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m379(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f168;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f167;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f166 + i8] + i10);
                    } else {
                        i11 = (short) (f164[f166 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f166 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f169);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f167;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f164;
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
}
