package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ag implements Comparable<ag> {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f213 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f214 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f215 = 2215294167266606182L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private je f216;

    public ag(je jeVar) {
        this.f216 = jeVar;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String m396() {
        f213 = (f214 + 105) % 128;
        String strM2682 = this.f216.m2682();
        f213 = (f214 + 109) % 128;
        return strM2682;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private long m397() {
        f213 = (f214 + 19) % 128;
        long jOptLong = m403().optLong(m402("ꪏ\uaafb᧯ꗺ\ufdcc珹", Color.blue(0)).intern());
        f214 = (f213 + 69) % 128;
        return jOptLong;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private long m398() {
        JSONObject jSONObjectM403;
        int iAxisFromString;
        int i2 = f214 + 85;
        f213 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM403 = m403();
            iAxisFromString = 1 >>> MotionEvent.axisFromString("");
        } else {
            jSONObjectM403 = m403();
            iAxisFromString = MotionEvent.axisFromString("") + 1;
        }
        long jOptInt = jSONObjectM403.optInt(m402("셥섀跟㇗⭺둼", iAxisFromString).intern());
        int i8 = f214 + 45;
        f213 = i8 % 128;
        if (i8 % 2 != 0) {
            return jOptInt;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static List<String> m400() {
        f213 = (f214 + 65) % 128;
        List<String> listAsList = Arrays.asList(ig.f2488);
        int i2 = f213 + 71;
        f214 = i2 % 128;
        if (i2 % 2 == 0) {
            return listAsList;
        }
        throw null;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ag agVar) {
        int i2 = f213 + 63;
        f214 = i2 % 128;
        int i8 = i2 % 2;
        int iM401 = m401(agVar);
        if (i8 != 0) {
            int i9 = 43 / 0;
        }
        return iM401;
    }

    public final boolean equals(Object obj) {
        int i2 = f213;
        f214 = (i2 + 3) % 128;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        int i8 = i2 + 73;
        f214 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
        if (ag.class != obj.getClass()) {
            return false;
        }
        return m396().equals(((ag) obj).m396());
    }

    public final int hashCode() {
        if (m403() == null) {
            int i2 = f214 + 105;
            f213 = i2 % 128;
            if (i2 % 2 == 0) {
                int i8 = 10 / 0;
            }
            return 0;
        }
        int i9 = f213 + 93;
        f214 = i9 % 128;
        if (i9 % 2 == 0) {
            return m403().hashCode();
        }
        m403().hashCode();
        throw null;
    }

    public final String toString() {
        int i2 = f214 + 63;
        f213 = i2 % 128;
        if (i2 % 2 == 0) {
            m403().toString();
            throw null;
        }
        String string = m403().toString();
        int i8 = f214 + 33;
        f213 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 5 / 0;
        }
        return string;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized JSONObject m403() {
        f214 = (f213 + 89) % 128;
        JSONObject jSONObjectM2683 = this.f216.m2683();
        int i2 = f213 + 99;
        f214 = i2 % 128;
        if (i2 % 2 == 0) {
            return jSONObjectM2683;
        }
        int i8 = 11 / 0;
        return jSONObjectM2683;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m404() {
        JSONObject jSONObjectM403;
        int maxKeyCode;
        int i2 = f214 + 5;
        f213 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM403 = m403();
            maxKeyCode = KeyEvent.getMaxKeyCode() % 63;
        } else {
            jSONObjectM403 = m403();
            maxKeyCode = KeyEvent.getMaxKeyCode() >> 16;
        }
        return jSONObjectM403.optString(m402("ྙ\u0fe9磺쓰揽᭖ꕞ适", maxKeyCode).intern());
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m406() {
        JSONObject jSONObjectM403;
        int longPressTimeout;
        int i2 = f214 + 41;
        f213 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObjectM403 = m403();
            longPressTimeout = ViewConfiguration.getLongPressTimeout() + 9;
        } else {
            jSONObjectM403 = m403();
            longPressTimeout = ViewConfiguration.getLongPressTimeout() >> 16;
        }
        String strOptString = jSONObjectM403.optString(m402("㖕㗠\u09ca뗅\udd2aꖂ茑", longPressTimeout).intern(), null);
        f213 = (f214 + 87) % 128;
        return strOptString;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m408(int i2) {
        try {
            f213 = (f214 + 83) % 128;
            if (this.f216.m2683() != null) {
                int i8 = f214 + 7;
                f213 = i8 % 128;
                if (i8 % 2 == 0) {
                    kc.m2897(this.f216.m2683(), i2, m400());
                    throw null;
                }
                kc.m2897(this.f216.m2683(), i2, m400());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private int m399(ag agVar) {
        f213 = (f214 + 91) % 128;
        long jM398 = m398();
        long jM3982 = agVar.m398();
        if (jM398 < jM3982) {
            return -1;
        }
        if (jM398 == jM3982) {
            return 0;
        }
        f214 = (f213 + 27) % 128;
        return 1;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private int m401(ag agVar) {
        int i2 = f213 + 91;
        f214 = i2 % 128;
        if (i2 % 2 != 0) {
            m397();
            agVar.m397();
            throw null;
        }
        long jM397 = m397();
        long jM3972 = agVar.m397();
        if (jM397 >= jM3972) {
            if (jM397 == jM3972) {
                return m399(agVar);
            }
            return 1;
        }
        int i8 = f214 + 105;
        f213 = i8 % 128;
        if (i8 % 2 != 0) {
            return -1;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m405(String str) {
        JSONObject jSONObjectM403;
        String strM402;
        int i2 = f214 + 101;
        f213 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                jSONObjectM403 = m403();
                strM402 = m402("㖕㗠\u09ca뗅\udd2aꖂ茑", ViewConfiguration.getMinimumFlingVelocity() << 109);
            } else {
                jSONObjectM403 = m403();
                strM402 = m402("㖕㗠\u09ca뗅\udd2aꖂ茑", ViewConfiguration.getMinimumFlingVelocity() >> 16);
            }
            jSONObjectM403.put(strM402.intern(), str);
            int i8 = f214 + 87;
            f213 = i8 % 128;
            if (i8 % 2 == 0) {
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final je m407() {
        int i2 = f214;
        je jeVar = this.f216;
        int i8 = i2 + 107;
        f213 = i8 % 128;
        if (i8 % 2 != 0) {
            return jeVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m402(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f215, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f215));
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
}
