package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.ja;
import com.vungle.ads.internal.protos.Sdk;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class iw {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2612 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2613 = 1;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2614;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String f2615;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f2616;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private iy f2617;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private jb f2618;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private List<Runnable> f2619 = new ArrayList();

    static {
        m2579();
        f2615 = m2577(Color.blue(0) + Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 69, "\u0015ￔ\ufff7\u0019ￗ\u001d\uffd8\u000b\fￜ%\u001b\u000f\f\t\f\u001a\u001b%ￜ\f\n\u001c\u0019\u0010\ufffb \u0010\ufff5\u001b\uffef\f\ufffe\u0016\u0019\u0013\u000bￒￔￋￗ\ufff6\u0014\u0013ￛￎ\u001a\u0013\ufff6\u0015￠\ufff2\uffdd ￛ￩\f\uffde\uffde\f\u0019ￚ\u0015\n\u0019 \u0017\u001b\uffd8ￗ", TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 40, false).intern();
        int i2 = f2614 + 5;
        f2613 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    public iw(Context context, iy iyVar, String str) {
        this.f2618 = new jb(context, m2577(Color.red(0) + 141, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 24, "\u000e\u0013\u0004\u0003\u0001\u0013\u0011\u0000\u0002\u0004\u0001\u0000\u0002\nￍ\n\u0015ￍ\u0003\u0001ￍ\u0011\u0004\f", TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 6, false).intern(), m2577((ViewConfiguration.getTouchSlop() >> 8) + 140, 17 - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\u0013\u0002\u0004ￔￍ\u0014\u0005\u0012\u0003\u0005\u0013ￍ\u0001\f\r\u000f\u000f", 1 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), true).intern());
        this.f2617 = iyVar;
        this.f2616 = str;
        aq.m530().mo559(new at() { // from class: com.ironsource.adqualitysdk.sdk.i.iw.2
            @Override // com.ironsource.adqualitysdk.sdk.i.at
            /* JADX INFO: renamed from: ﾇ */
            public final void mo383() {
                ArrayList arrayList;
                synchronized (this) {
                    arrayList = new ArrayList(iw.m2578(iw.this));
                    iw.m2578(iw.this).clear();
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    ((Runnable) obj).run();
                }
            }
        });
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2579() {
        f2612 = 44;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ iy m2580(iw iwVar) {
        int i2 = f2613;
        f2614 = (i2 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        iy iyVar = iwVar.f2617;
        f2614 = (i2 + 43) % 128;
        return iyVar;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private synchronized String m2582() {
        String str;
        int i2 = (f2613 + 59) % 128;
        f2614 = i2;
        str = this.f2616;
        int i8 = i2 + 41;
        f2613 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m2583() {
        int i2 = f2613;
        String str = f2615;
        int i8 = i2 + 15;
        f2614 = i8 % 128;
        if (i8 % 2 != 0) {
            int i9 = 74 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ jb m2584(iw iwVar) {
        int i2 = (f2613 + 81) % 128;
        f2614 = i2;
        jb jbVar = iwVar.f2618;
        f2613 = (i2 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        return jbVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ List m2578(iw iwVar) {
        int i2 = f2613 + 61;
        int i8 = i2 % 128;
        f2614 = i8;
        int i9 = i2 % 2;
        List<Runnable> list = iwVar.f2619;
        if (i9 != 0) {
            throw null;
        }
        int i10 = i8 + 25;
        f2613 = i10 % 128;
        if (i10 % 2 != 0) {
            return list;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2581(final ja jaVar, final il ilVar) {
        String strMo2625 = jaVar.mo2625();
        StringBuilder sb = new StringBuilder();
        sb.append(m2582());
        final String strD = a0.d(sb, m2577(View.MeasureSpec.getMode(0) + 91, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), "\u0000", (ViewConfiguration.getLongPressTimeout() >> 16) + 1, true), strMo2625);
        final String strM2627 = jaVar.m2627();
        if (aq.m530().mo563()) {
            int i2 = f2613 + 95;
            f2614 = i2 % 128;
            if (i2 % 2 != 0) {
                aq.m530().mo556();
                throw null;
            }
            if (aq.m530().mo556() || this.f2618.m2637(strM2627) == null) {
                jv.m2807(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iw.3

                    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                    private static int f2623 = 0;

                    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
                    private static int f2624 = 1;

                    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
                    private static char[] f2622 = {'U', 51510, 37607, 23662, 9671, 61114, 47127, 33162, 42043, 28009, 14030, 63529, 33161, 19189, 7283, 9704, 57066, 6062, 19463, 33523, 64323, 12327, 26244, 24328, 38370, 51715, 815, 31117, 44640, 58598, 56646, 4642, 18654, 33149, 63430, 11454, 25895, 23495, ' ', 51462, 37541, 23617, 9696, 61080, 47159, 33197, 19291, 5293, 56731, 42809, 28874, 14912, 1002, 52354, 38452, 24469, 10617, 61975, 48005, 34107, 20189, 18275, 36365, 54714, 6918, 39185, 20547, 3052, 50452, 48306, 30605, 8557, 6386, 53768, 36269, 17615, 15981, 59791, 41813, 39584, 21978, 3945, 50830, 45114, 27470, 8848, 7246, 55182, 33077, 30789, 13287, 60785, 42195, 40510, 18775, 237, 64002, 46548, 'e', 51467, 37545, 15798, 62668, 43826, 25157, 14823, 63258};

                    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
                    private static long f2621 = -7925279194686895771L;

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private void m2591(final ja jaVar2, final il ilVar2) {
                        iw.m2580(iw.this).m2611().m2570(new iq() { // from class: com.ironsource.adqualitysdk.sdk.i.iw.3.1
                            @Override // com.ironsource.adqualitysdk.sdk.i.iq
                            /* JADX INFO: renamed from: ﻛ */
                            public final void mo481() {
                                iw.m2580(iw.this).m2611().m2573(this);
                                iw.m2585(iw.this, jaVar2, ilVar2);
                            }
                        });
                        f2624 = (f2623 + 39) % 128;
                    }

                    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                    private static String m2592(String str) throws JSONException {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString(m2590((char) View.getDefaultSize(0, 0), (-16777213) - Color.rgb(0, 0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 98).intern());
                        if (TextUtils.isEmpty(strOptString)) {
                            int i8 = f2623 + 53;
                            f2624 = i8 % 128;
                            if (i8 % 2 == 0) {
                                int i9 = 74 / 0;
                            }
                            return str;
                        }
                        String strM2802 = jv.m2802(strOptString, iw.m2583(), jSONObject.optString(m2590((char) ((ViewConfiguration.getEdgeSlop() >> 16) + 15839), 1 - TextUtils.lastIndexOf("", '0'), View.combineMeasuredStates(0, 0) + 101).intern()), jSONObject.optString(m2590((char) (43840 - MotionEvent.axisFromString("")), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 4, TextUtils.lastIndexOf("", '0', 0, 0) + 104).intern()));
                        f2624 = (f2623 + 65) % 128;
                        return strM2802;
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        int i8 = f2623 + 39;
                        f2624 = i8 % 128;
                        if (i8 % 2 == 0) {
                            m2589(strD, jaVar, strM2627, ilVar);
                            throw null;
                        }
                        m2589(strD, jaVar, strM2627, ilVar);
                        f2623 = (f2624 + 43) % 128;
                    }

                    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                    private void m2589(String str, ja jaVar2, String str2, il ilVar2) {
                        if (!iw.m2580(iw.this).m2611().m2571()) {
                            int i8 = f2623 + 75;
                            f2624 = i8 % 128;
                            if (i8 % 2 == 0) {
                                m2591(jaVar2, ilVar2);
                                int i9 = 48 / 0;
                            } else {
                                m2591(jaVar2, ilVar2);
                            }
                            int i10 = f2624 + 105;
                            f2623 = i10 % 128;
                            if (i10 % 2 != 0) {
                                int i11 = 61 / 0;
                                return;
                            }
                            return;
                        }
                        try {
                            ir irVarM2604 = ix.m2604(str);
                            if (irVarM2604 == null || irVarM2604.m2557().m2558() != 200) {
                                if (!iw.m2580(iw.this).m2611().m2571()) {
                                    m2591(jaVar2, ilVar2);
                                    return;
                                } else {
                                    if ((irVarM2604.m2557().m2558() == 403 || irVarM2604.m2557().m2558() == 404) && str.contains(m2590((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 18182), (Process.myTid() >> 22) + 4, ((byte) KeyEvent.getModifierMetaStateMask()) + 62).intern())) {
                                        jaVar2.m2626();
                                        iw.this.m2588(jaVar2, ilVar2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            f2623 = (f2624 + 89) % 128;
                            String strM2592 = m2592(ix.m2593(irVarM2604));
                            if (Charset.forName(m2590((char) Gravity.getAbsoluteGravity(0, 0), 8 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1).intern()).newEncoder().canEncode(strM2592)) {
                                if (TextUtils.isEmpty(strM2592)) {
                                    return;
                                }
                                iw.m2584(iw.this).m2645(str2, strM2592);
                                p.m2969(new iu(str2, strM2592) { // from class: com.ironsource.adqualitysdk.sdk.i.iw.3.4

                                    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                                    private /* synthetic */ String f2634;

                                    {
                                        this.f2634 = strM2592;
                                    }

                                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                    /* JADX INFO: renamed from: ﻐ */
                                    public final void mo306() {
                                        this.f2633.mo724(this.f2634);
                                    }
                                });
                                return;
                            }
                            String strIntern = m2590((char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 42088), 8 - (ViewConfiguration.getDoubleTapTimeout() >> 16), TextUtils.indexOf("", "") + 8).intern();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(m2590((char) (57006 - (ViewConfiguration.getTouchSlop() >> 8)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 21, 16 - TextUtils.getCapsMode("", 0, 0)).intern());
                            sb2.append(str);
                            sb2.append(m2590((char) (ViewConfiguration.getPressedStateDuration() >> 16), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 23, View.resolveSize(0, 0) + 38).intern());
                            kd.m2919(strIntern, sb2.toString(), null, false);
                        } catch (Exception e) {
                            if (iw.m2580(iw.this).m2611().m2571()) {
                                kd.m2919(m2590((char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 42089), 8 - KeyEvent.getDeadChar(0, 0), 7 - TextUtils.lastIndexOf("", '0')).intern(), a0.d(new StringBuilder(), m2590((char) (39252 - (ViewConfiguration.getLongPressTimeout() >> 16)), 33 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), View.resolveSizeAndState(0, 0, 0) + 65), str), e, false);
                            } else {
                                m2591(jaVar2, ilVar2);
                            }
                        }
                    }

                    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                    private static String m2590(char c7, int i8, int i9) {
                        String str;
                        synchronized (c.f1192) {
                            try {
                                char[] cArr = new char[i8];
                                c.f1193 = 0;
                                while (true) {
                                    int i10 = c.f1193;
                                    if (i10 < i8) {
                                        cArr[i10] = (char) ((((long) f2622[i9 + i10]) ^ (((long) i10) * f2621)) ^ ((long) c7));
                                        c.f1193 = i10 + 1;
                                    } else {
                                        str = new String(cArr);
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        return str;
                    }
                });
            }
        }
        f2614 = (f2613 + 69) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m2585(iw iwVar, ja jaVar, il ilVar) {
        int i2 = f2613 + 35;
        f2614 = i2 % 128;
        int i8 = i2 % 2;
        iwVar.m2581(jaVar, ilVar);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2586(String str, String str2, il ilVar) {
        ja.c cVar = new ja.c(str, str2);
        if (aq.m530().mo543().m528()) {
            int i2 = f2613 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
            f2614 = i2 % 128;
            if (i2 % 2 != 0) {
                TextUtils.isEmpty(aq.m530().mo543().m527(str));
                throw null;
            }
            String strM527 = aq.m530().mo543().m527(str);
            if (TextUtils.isEmpty(strM527)) {
                int i8 = f2613 + 99;
                f2614 = i8 % 128;
                if (i8 % 2 == 0) {
                    return null;
                }
                throw null;
            }
            cVar = new ja.b(str, str2, strM527);
        }
        return m2588(cVar, ilVar);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2577(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
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
                    cArr2[i11] = (char) (cArr2[i11] - f2612);
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
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final String m2588(final ja jaVar, final il ilVar) {
        boolean z2;
        if (TextUtils.isEmpty(jaVar.m2628()) || TextUtils.isEmpty(jaVar.m2624())) {
            return null;
        }
        String strM2627 = jaVar.m2627();
        synchronized (this) {
            try {
                if (aq.m530().mo546()) {
                    z2 = true;
                } else {
                    this.f2619.add(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iw.4
                        @Override // com.ironsource.adqualitysdk.sdk.i.iu
                        /* JADX INFO: renamed from: ﻐ */
                        public final void mo306() {
                            iw.m2585(iw.this, jaVar, ilVar);
                        }
                    });
                    z2 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            m2581(jaVar, ilVar);
        }
        return this.f2618.m2637(strM2627);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final boolean m2587(ja jaVar) {
        int i2 = f2614 + 49;
        f2613 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 57 / 0;
            if (this.f2618.m2637(jaVar.m2627()) != null) {
                return true;
            }
        } else {
            if (this.f2618.m2637(jaVar.m2627()) != null) {
                return true;
            }
        }
        f2614 = (f2613 + 37) % 128;
        return false;
    }
}
