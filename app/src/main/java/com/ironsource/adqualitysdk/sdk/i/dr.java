package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.InterfaceC2238ae;
import com.ironsource.adqualitysdk.sdk.i.dx;
import com.ironsource.mediationsdk.demandOnly.j;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dr {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char[] f1832 = null;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static long f1833 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1834 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1835 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Map<ee, ee> f1836;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static Map<fr, fr> f1837;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f1838;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1839;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private int f1840 = 0;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c<T> {
        /* JADX INFO: renamed from: ﻛ */
        T mo2129(List<dx> list);
    }

    static {
        m2116();
        f1836 = new HashMap();
        f1837 = new HashMap();
        f1834 = (f1835 + 73) % 128;
    }

    public dr(String str, String str2) {
        this.f1838 = str;
        this.f1839 = str2;
    }

    /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
    private dx m2083(List<dx> list) {
        int i2 = f1834 + 15;
        f1835 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                int i8 = 58 / 0;
                if (!m2085(list)) {
                    return null;
                }
            } else if (!m2085(list)) {
                return null;
            }
            int i9 = f1834 + 27;
            f1835 = i9 % 128;
            if (i9 % 2 != 0) {
                return list.get(this.f1840);
            }
            int i10 = 89 / 0;
            return list.get(this.f1840);
        } catch (Exception e) {
            m2120(m2124((char) (Color.red(0) + 20864), (ViewConfiguration.getFadingEdgeLength() >> 16) + 37, (ViewConfiguration.getPressedStateDuration() >> 16) + InterfaceC2238ae.a.f8001c).intern(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ヶ, reason: contains not printable characters */
    private dx m2084(List<dx> list) {
        f1834 = (f1835 + 107) % 128;
        try {
        } catch (Exception e) {
            m2120(m2124((char) Drawable.resolveOpacity(0, 0), 34 - View.getDefaultSize(0, 0), 1167 - ((byte) KeyEvent.getModifierMetaStateMask())).intern(), e);
        }
        if (!m2085(list)) {
            m2120(m2124((char) (View.resolveSize(0, 0) + 16992), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 23, (ViewConfiguration.getPressedStateDuration() >> 16) + 1144).intern(), (Throwable) null);
            return null;
        }
        int i2 = this.f1840;
        this.f1840 = i2 + 1;
        dx dxVar = list.get(i2);
        int i8 = f1835 + 31;
        f1834 = i8 % 128;
        if (i8 % 2 == 0) {
            return dxVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: 乁, reason: contains not printable characters */
    private boolean m2085(List<dx> list) {
        f1835 = (f1834 + 93) % 128;
        if (this.f1840 >= list.size()) {
            return false;
        }
        f1835 = (f1834 + 103) % 128;
        return true;
    }

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private Map<String, ee> m2086(List<dx> list) {
        HashMap map = new HashMap();
        Iterator it = m2115(list, m2124((char) (5239 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 1 - Gravity.getAbsoluteGravity(0, 0), 764 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern(), new c<Pair<String, ee>>() { // from class: com.ironsource.adqualitysdk.sdk.i.dr.5
            @Override // com.ironsource.adqualitysdk.sdk.i.dr.c
            /* JADX INFO: renamed from: ﻛ */
            public final /* bridge */ /* synthetic */ Pair<String, ee> mo2129(List list2) {
                return dr.m2104(dr.this, list2);
            }
        }).iterator();
        while (it.hasNext()) {
            int i2 = f1835 + 61;
            f1834 = i2 % 128;
            if (i2 % 2 != 0) {
                Pair pair = (Pair) it.next();
                map.put(pair.first, pair.second);
                throw null;
            }
            Pair pair2 = (Pair) it.next();
            map.put(pair2.first, pair2.second);
        }
        return map;
    }

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    private List<ee> m2087(List<dx> list) {
        List<ee> listM2115 = m2115(list, m2124((char) TextUtils.indexOf("", "", 0, 0), 1 - (ViewConfiguration.getLongPressTimeout() >> 16), 774 - Gravity.getAbsoluteGravity(0, 0)).intern(), new c<ee>() { // from class: com.ironsource.adqualitysdk.sdk.i.dr.1

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static char[] f1841 = {16, 'B', 'd', 'm', 'o', 'g', 'd', 'd', 'k', 'I', 'J', 't', 'k', 'A', 'I', 'i', 'k', 'R', 'Q', 's', 'j', 'f', 'g', 'A', 'B', 'd', 'l', 'k', 'd', 'j', 't', '^'};

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static int f1842 = 1;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f1843;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static String m2127(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                        System.arraycopy(f1841, i2, cArr, 0, i8);
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
            private ee m2128(List<dx> list2) {
                f1843 = (f1842 + 9) % 128;
                ee eeVarM2121 = dr.m2121(dr.this, list2);
                if ((eeVarM2121 instanceof dv) || (eeVarM2121 instanceof em)) {
                    f1843 = (f1842 + 97) % 128;
                    return eeVarM2121;
                }
                dr drVar = dr.this;
                StringBuilder sb = new StringBuilder();
                sb.append(m2127("\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001", true, new int[]{0, 32, 0, 0}).intern());
                sb.append(eeVarM2121);
                dr.m2107(drVar, sb.toString());
                f1842 = (f1843 + 45) % 128;
                return null;
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.dr.c
            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            public final /* synthetic */ ee mo2129(List list2) {
                int i2 = f1843 + 29;
                f1842 = i2 % 128;
                int i8 = i2 % 2;
                ee eeVarM2128 = m2128(list2);
                if (i8 == 0) {
                    int i9 = 84 / 0;
                }
                f1843 = (f1842 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                return eeVarM2128;
            }
        });
        f1835 = (f1834 + 57) % 128;
        return listM2115;
    }

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private ee m2088(List<dx> list) {
        dx dxVarM2084;
        Cdo cdoM2067;
        try {
            dxVarM2084 = m2084(list);
            cdoM2067 = Cdo.m2067(this.f1839, dxVarM2084.m2171());
        } catch (Exception e) {
            m2120(m2124((char) (MotionEvent.axisFromString("") + 1), 16 - Gravity.getAbsoluteGravity(0, 0), 849 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern(), e);
        }
        if (dxVarM2084.m2160()) {
            f1834 = (f1835 + 45) % 128;
            String strM2169 = dxVarM2084.m2169();
            String strM21692 = m2084(list).m2169();
            int iHashCode = strM21692.hashCode();
            if (iHashCode != 40) {
                if (iHashCode == 61 && strM21692.equals(m2124((char) (ImageFormat.getBitsPerPixel(0) + 42401), 1 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.resolveSizeAndState(0, 0, 0) + 790).intern())) {
                    return m2106(new dz((em) m2106(new em(strM2169, cdoM2067)), m2126(list), cdoM2067));
                }
            } else if (strM21692.equals(m2124((char) (View.MeasureSpec.getSize(0) + 18493), TextUtils.getOffsetBefore("", 0) + 1, 110 - Color.blue(0)).intern())) {
                return m2106(new ec(strM2169, m2114(list, m2124((char) (Color.alpha(0) + 31737), Drawable.resolveOpacity(0, 0) + 1, 151 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern()), cdoM2067));
            }
            this.f1840--;
            return m2106(new em(strM2169, cdoM2067));
        }
        if (dxVarM2084.m2166()) {
            int i2 = f1835 + 19;
            f1834 = i2 % 128;
            if (i2 % 2 == 0) {
                return m2105(dxVarM2084);
            }
            m2105(dxVarM2084);
            throw null;
        }
        if (dxVarM2084.m2162()) {
            return m2106(new dv(dxVarM2084.m2169(), cdoM2067));
        }
        if (dxVarM2084.m2159()) {
            return m2111(dxVarM2084, list);
        }
        if (!dxVarM2084.m2165()) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2124((char) (ViewConfiguration.getLongPressTimeout() >> 16), Process.getGidForName("") + 18, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 832).intern());
            sb.append(dxVarM2084);
            m2108(sb.toString());
            f1834 = (f1835 + 97) % 128;
            return null;
        }
        f1835 = (f1834 + 71) % 128;
        String strM21693 = dxVarM2084.m2169();
        int iHashCode2 = strM21693.hashCode();
        if (iHashCode2 == 33) {
            if (strM21693.equals(m2124((char) (ViewConfiguration.getWindowTouchSlop() >> 8), 1 - TextUtils.getTrimmedLength(""), 791 - ((Process.getThreadPriority(0) + 20) >> 6)).intern())) {
                int i8 = f1834 + 91;
                f1835 = i8 % 128;
                if (i8 % 2 != 0) {
                    return m2106(new fa(m2089(list), cdoM2067));
                }
                return m2106(new ey(m2106(new ff(0, cdoM2067)), m2088(list), cdoM2067));
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(m2124((char) View.MeasureSpec.getMode(0), Color.blue(0) + 20, (ViewConfiguration.getEdgeSlop() >> 16) + 812).intern());
            sb2.append(dxVarM2084.m2169());
            m2108(sb2.toString());
            return null;
        }
        if (iHashCode2 != 40) {
            if (iHashCode2 != 45) {
                if (iHashCode2 != 91) {
                    if (iHashCode2 == 123 && strM21693.equals(m2124((char) (41193 - (KeyEvent.getMaxKeyCode() >> 16)), View.MeasureSpec.getMode(0) + 1, Process.myPid() >> 22).intern())) {
                        return m2106(new ed(m2086(list), cdoM2067));
                    }
                } else if (strM21693.equals(m2124((char) (TextUtils.indexOf("", "", 0, 0) + 12844), 1 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 789).intern())) {
                    f1834 = (f1835 + 1) % 128;
                    return m2106(new dw(m2114(list, m2124((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 42550), 1 - (ViewConfiguration.getWindowTouchSlop() >> 8), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 810).intern()), cdoM2067));
                }
            } else if (strM21693.equals(m2124((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 26839), 1 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 779).intern())) {
                return m2106(new ey(m2106(new ff(0, cdoM2067)), m2088(list), cdoM2067));
            }
        } else if (strM21693.equals(m2124((char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 18493), 1 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 109 - ((byte) KeyEvent.getModifierMetaStateMask())).intern())) {
            ee eeVarM2106 = m2106(new eh(m2126(list), cdoM2067));
            m2109(list, m2124((char) (31738 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 1 - (Process.myTid() >> 22), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 150).intern(), eeVarM2106, m2124((char) TextUtils.getTrimmedLength(""), 18 - ((byte) KeyEvent.getModifierMetaStateMask()), Gravity.getAbsoluteGravity(0, 0) + 792).intern());
            return eeVarM2106;
        }
        StringBuilder sb22 = new StringBuilder();
        sb22.append(m2124((char) View.MeasureSpec.getMode(0), Color.blue(0) + 20, (ViewConfiguration.getEdgeSlop() >> 16) + 812).intern());
        sb22.append(dxVarM2084.m2169());
        m2108(sb22.toString());
        return null;
    }

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    private ee m2089(List<dx> list) {
        ee eeVarM2088 = m2088(list);
        while (m2085(list)) {
            f1834 = (f1835 + 71) % 128;
            String strM2169 = m2084(list).m2169();
            int iHashCode = strM2169.hashCode();
            if (iHashCode == 46) {
                if (!strM2169.equals(m2124((char) (ViewConfiguration.getFadingEdgeLength() >> 16), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 788 - (ViewConfiguration.getScrollBarSize() >> 8)).intern())) {
                    this.f1840--;
                    break;
                }
                f1835 = (f1834 + 39) % 128;
                eeVarM2088 = m2101(eeVarM2088, list);
            } else {
                if (iHashCode != 91 || !strM2169.equals(m2124((char) (TextUtils.indexOf("", "") + 12844), -TextUtils.lastIndexOf("", '0', 0), 789 - (KeyEvent.getMaxKeyCode() >> 16)).intern())) {
                    this.f1840--;
                    break;
                }
                eeVarM2088 = m2117(eeVarM2088, list);
            }
        }
        return eeVarM2088;
    }

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private Pair<String, ee> m2090(List<dx> list) {
        f1835 = (f1834 + 105) % 128;
        dx dxVarM2084 = m2084(list);
        if (!dxVarM2084.m2168()) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2124((char) (55803 - View.combineMeasuredStates(0, 0)), KeyEvent.getDeadChar(0, 0) + 24, 1047 - KeyEvent.getDeadChar(0, 0)).intern());
            sb.append(dxVarM2084);
            m2120(sb.toString(), (Throwable) null);
        }
        String strM2169 = dxVarM2084.m2169();
        m2109(list, m2124((char) (59123 - TextUtils.indexOf("", "", 0)), TextUtils.getOffsetBefore("", 0) + 1, TextUtils.indexOf("", "", 0) + j.a.k).intern(), strM2169, m2124((char) ((-1) - MotionEvent.axisFromString("")), 48 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 1071 - TextUtils.indexOf((CharSequence) "", '0', 0)).intern());
        Pair<String, ee> pair = new Pair<>(strM2169, m2126(list));
        f1834 = (f1835 + 83) % 128;
        return pair;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private ee m2091(List<dx> list) {
        ee eeVarM2095 = m2095(list);
        if (m2085(list)) {
            Cdo cdoM2067 = Cdo.m2067(this.f1839, eeVarM2095.m2191());
            String strM2169 = m2084(list).m2169();
            int iHashCode = strM2169.hashCode();
            if (iHashCode != 60) {
                if (iHashCode != 62) {
                    if (iHashCode != 1084) {
                        if (iHashCode != 1921) {
                            if (iHashCode != 1952) {
                                if (iHashCode == 1983 && strM2169.equals(m2124((char) (TextUtils.indexOf("", "") + 29828), 2 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 777 - (KeyEvent.getMaxKeyCode() >> 16)).intern())) {
                                    return m2106(new er(eeVarM2095, m2091(list), cdoM2067));
                                }
                            } else if (strM2169.equals(m2124((char) (ExpandableListView.getPackedPositionType(0L) + 40510), KeyEvent.getDeadChar(0, 0) + 2, (ViewConfiguration.getFadingEdgeLength() >> 16) + 769).intern())) {
                                return m2106(new es(eeVarM2095, m2091(list), cdoM2067));
                            }
                        } else if (strM2169.equals(m2124((char) (MotionEvent.axisFromString("") + 2174), 2 - (Process.myPid() >> 22), 775 - (ViewConfiguration.getTapTimeout() >> 16)).intern())) {
                            int i2 = (f1835 + 9) % 128;
                            f1834 = i2;
                            f1835 = (i2 + 37) % 128;
                            return m2106(new ev(eeVarM2095, m2091(list), cdoM2067));
                        }
                    } else if (strM2169.equals(m2124((char) (55789 - AndroidCharacter.getMirror('0')), ((byte) KeyEvent.getModifierMetaStateMask()) + 3, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 771).intern())) {
                        f1834 = (f1835 + 57) % 128;
                        return m2106(new fc(eeVarM2095, m2091(list), cdoM2067));
                    }
                } else if (strM2169.equals(m2124((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), KeyEvent.keyCodeFromString("") + 1, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 773).intern())) {
                    return m2106(new eq(eeVarM2095, m2091(list), cdoM2067));
                }
            } else if (strM2169.equals(m2124((char) (Process.myPid() >> 22), -MotionEvent.axisFromString(""), KeyEvent.keyCodeFromString("") + 773).intern())) {
                return m2106(new ew(eeVarM2095, m2091(list), cdoM2067));
            }
            this.f1840--;
        }
        return eeVarM2095;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private fk m2092(List<dx> list) {
        ArrayList arrayList = new ArrayList();
        dx dxVarM2083 = m2083(list);
        f1835 = (f1834 + 91) % 128;
        while (!dxVarM2083.m2167(m2124((char) (5237 - TextUtils.lastIndexOf("", '0', 0, 0)), 1 - Color.red(0), View.resolveSize(0, 0) + 764).intern())) {
            f1835 = (f1834 + 103) % 128;
            arrayList.add(m2118(list));
            dxVarM2083 = m2083(list);
        }
        this.f1840++;
        return (fk) m2102(new fk(arrayList));
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private fr m2093(List<dx> list) {
        m2110(list, m2124((char) ((Process.myPid() >> 22) + 51080), TextUtils.indexOf("", "", 0) + 1, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 42).intern(), m2124((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 37, Color.alpha(0) + 726).intern());
        fr frVarM2102 = m2102(new fj());
        int i2 = f1835 + 67;
        f1834 = i2 % 128;
        if (i2 % 2 == 0) {
            return frVarM2102;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private ee m2094(List<dx> list) {
        int i2 = f1834 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1835 = i2 % 128;
        if (i2 % 2 == 0) {
            m2089(list);
            m2085(list);
            throw null;
        }
        ee eeVarM2089 = m2089(list);
        if (m2085(list)) {
            Cdo cdoM2067 = Cdo.m2067(this.f1839, eeVarM2089.m2191());
            String strM2169 = m2084(list).m2169();
            int iHashCode = strM2169.hashCode();
            if (iHashCode != 37) {
                if (iHashCode != 42) {
                    if (iHashCode == 47 && strM2169.equals(m2124((char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 23400), AndroidCharacter.getMirror('0') - '/', TextUtils.lastIndexOf("", '0') + 787).intern())) {
                        ee eeVarM2106 = m2106(new et(eeVarM2089, m2094(list), cdoM2067));
                        int i8 = f1834 + 63;
                        f1835 = i8 % 128;
                        if (i8 % 2 != 0) {
                            return eeVarM2106;
                        }
                        throw null;
                    }
                } else if (strM2169.equals(m2124((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 63318), -TextUtils.indexOf((CharSequence) "", '0'), Color.red(0) + 785).intern())) {
                    f1835 = (f1834 + 61) % 128;
                    return m2106(new fb(eeVarM2089, m2094(list), cdoM2067));
                }
            } else if (strM2169.equals(m2124((char) (57352 - (ViewConfiguration.getJumpTapTimeout() >> 16)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (Process.myTid() >> 22) + 787).intern())) {
                return m2106(new eu(eeVarM2089, m2094(list), cdoM2067));
            }
            this.f1840--;
        }
        return eeVarM2089;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
    
        if (r2.equals(m2124((char) (android.widget.ExpandableListView.getPackedPositionGroup(0) + 47018), 1 - android.widget.ExpandableListView.getPackedPositionChild(0), android.view.View.MeasureSpec.getMode(0) + 781).intern()) != false) goto L24;
     */
    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ironsource.adqualitysdk.sdk.i.ee m2095(java.util.List<com.ironsource.adqualitysdk.sdk.i.dx> r9) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dr.m2095(java.util.List):com.ironsource.adqualitysdk.sdk.i.ee");
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private fr m2096(List<dx> list) {
        m2110(list, m2124((char) (18493 - Drawable.resolveOpacity(0, 0)), 1 - TextUtils.indexOf("", ""), 110 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), m2124((char) (View.getDefaultSize(0, 0) + 54171), 43 - ExpandableListView.getPackedPositionGroup(0L), 310 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern());
        ee eeVarM2126 = m2126(list);
        m2110(list, m2124((char) (View.resolveSizeAndState(0, 0, 0) + 31737), -TextUtils.lastIndexOf("", '0'), 150 - TextUtils.lastIndexOf("", '0', 0, 0)).intern(), m2124((char) KeyEvent.normalizeMetaState(0), 46 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.indexOf("", "", 0, 0) + 353).intern());
        fr frVarM2102 = m2102(new fw(eeVarM2126, m2118(list)));
        f1834 = (f1835 + 21) % 128;
        return frVarM2102;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private fr m2097(List<dx> list) {
        m2110(list, m2124((char) (51081 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 43 - TextUtils.getOffsetBefore("", 0)).intern(), m2124((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 34, 692 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern());
        fr frVarM2102 = m2102(new fn());
        int i2 = f1834 + 29;
        f1835 = i2 % 128;
        if (i2 % 2 != 0) {
            return frVarM2102;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private fr m2098(List<dx> list) {
        m2110(list, m2124((char) (41193 - TextUtils.indexOf("", "")), 1 - TextUtils.getOffsetAfter("", 0), TextUtils.indexOf("", "", 0)).intern(), m2124((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 12115), 44 - (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 400).intern());
        fk fkVarM2092 = m2092(list);
        m2110(list, m2124((char) ((Process.getThreadPriority(0) + 20) >> 6), Drawable.resolveOpacity(0, 0) + 5, TextUtils.getTrimmedLength("") + 444).intern(), m2124((char) (2185 - (ViewConfiguration.getTouchSlop() >> 8)), TextUtils.lastIndexOf("", '0', 0, 0) + 54, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 448).intern());
        m2110(list, m2124((char) (Color.argb(0, 0, 0, 0) + 18493), (ViewConfiguration.getTouchSlop() >> 8) + 1, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 110).intern(), m2124((char) ExpandableListView.getPackedPositionGroup(0L), 41 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 502 - View.resolveSize(0, 0)).intern());
        dx dxVarM2084 = m2084(list);
        m2119(dxVarM2084, dx.e.f1913, fkVarM2092, m2124((char) View.getDefaultSize(0, 0), 27 - (ViewConfiguration.getPressedStateDuration() >> 16), 542 - TextUtils.lastIndexOf("", '0', 0, 0)).intern());
        em emVar = (em) m2106(new em(dxVarM2084.m2169(), Cdo.m2067(this.f1839, dxVarM2084.m2171())));
        m2110(list, m2124((char) (31737 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), TextUtils.getOffsetAfter("", 0) + 1, Color.alpha(0) + 151).intern(), m2124((char) (ViewConfiguration.getPressedStateDuration() >> 16), 39 - ExpandableListView.getPackedPositionType(0L), Color.green(0) + 570).intern());
        m2110(list, m2124((char) (View.MeasureSpec.getSize(0) + 41193), 1 - View.combineMeasuredStates(0, 0), TextUtils.indexOf("", "")).intern(), m2124((char) (26663 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 46 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 608 - ImageFormat.getBitsPerPixel(0)).intern());
        fr frVarM2102 = m2102(new fu(fkVarM2092, m2092(list), emVar));
        f1835 = (f1834 + 109) % 128;
        return frVarM2102;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private fr m2099(List<dx> list) {
        fr frVarM2102 = m2102(new fv(m2115(list, m2124((char) (51081 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), 1 - (ViewConfiguration.getPressedStateDuration() >> 16), 43 - View.resolveSize(0, 0)).intern(), new c<ee>() { // from class: com.ironsource.adqualitysdk.sdk.i.dr.4

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static int f1846 = 0;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f1847 = 1;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static char[] f1848 = {319, 370, 362, 351, 349, 366, 350, 282, 368, 347, 364, 355, 348, 358, 367};

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static boolean f1849 = true;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f1850 = 250;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static boolean f1851 = true;

            /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
            private static String m2130(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                        char[] cArr2 = f1848;
                        int i8 = f1850;
                        if (f1851) {
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
                        if (f1849) {
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

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
            
                if ((r6 instanceof com.ironsource.adqualitysdk.sdk.i.dz) != false) goto L14;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
            
                r0 = r5.f1852;
                r2 = new java.lang.StringBuilder();
                r2.append(m2130(null, 127 - android.view.Gravity.getAbsoluteGravity(0, 0), null, "\u0088\u0087\u0084\u0089\u008c\u0084\u0085\u0084\u008b\u0088\u0086\u008f\u008d\u0088\u0084\u008e\u008d\u008a\u008c\u008b\u008a\u0089\u0088\u0087\u0084\u0086\u0085\u0084\u0083\u0082\u0081").intern());
                r2.append(r6);
                com.ironsource.adqualitysdk.sdk.i.dr.m2107(r0, r2.toString());
             */
            /* JADX WARN: Code restructure failed: missing block: B:13:0x0049, code lost:
            
                return null;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
            
                if ((r6 instanceof com.ironsource.adqualitysdk.sdk.i.dz) != false) goto L14;
             */
            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private com.ironsource.adqualitysdk.sdk.i.ee m2131(java.util.List<com.ironsource.adqualitysdk.sdk.i.dx> r6) {
                /*
                    r5 = this;
                    com.ironsource.adqualitysdk.sdk.i.dr r0 = com.ironsource.adqualitysdk.sdk.i.dr.this
                    com.ironsource.adqualitysdk.sdk.i.ee r6 = r0.m2126(r6)
                    boolean r0 = r6 instanceof com.ironsource.adqualitysdk.sdk.i.em
                    if (r0 != 0) goto L4a
                    int r0 = com.ironsource.adqualitysdk.sdk.i.dr.AnonymousClass4.f1847
                    int r0 = r0 + 13
                    int r1 = r0 % 128
                    com.ironsource.adqualitysdk.sdk.i.dr.AnonymousClass4.f1846 = r1
                    int r0 = r0 % 2
                    r1 = 0
                    if (r0 == 0) goto L1f
                    boolean r0 = r6 instanceof com.ironsource.adqualitysdk.sdk.i.dz
                    r2 = 59
                    int r2 = r2 / r1
                    if (r0 == 0) goto L24
                    goto L4a
                L1f:
                    boolean r0 = r6 instanceof com.ironsource.adqualitysdk.sdk.i.dz
                    if (r0 == 0) goto L24
                    goto L4a
                L24:
                    com.ironsource.adqualitysdk.sdk.i.dr r0 = com.ironsource.adqualitysdk.sdk.i.dr.this
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    int r1 = android.view.Gravity.getAbsoluteGravity(r1, r1)
                    int r1 = 127 - r1
                    java.lang.String r3 = "\u0088\u0087\u0084\u0089\u008c\u0084\u0085\u0084\u008b\u0088\u0086\u008f\u008d\u0088\u0084\u008e\u008d\u008a\u008c\u008b\u008a\u0089\u0088\u0087\u0084\u0086\u0085\u0084\u0083\u0082\u0081"
                    r4 = 0
                    java.lang.String r1 = m2130(r4, r1, r4, r3)
                    java.lang.String r1 = r1.intern()
                    r2.append(r1)
                    r2.append(r6)
                    java.lang.String r6 = r2.toString()
                    com.ironsource.adqualitysdk.sdk.i.dr.m2107(r0, r6)
                    return r4
                L4a:
                    int r0 = com.ironsource.adqualitysdk.sdk.i.dr.AnonymousClass4.f1846
                    int r0 = r0 + 15
                    int r0 = r0 % 128
                    com.ironsource.adqualitysdk.sdk.i.dr.AnonymousClass4.f1847 = r0
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dr.AnonymousClass4.m2131(java.util.List):com.ironsource.adqualitysdk.sdk.i.ee");
            }

            @Override // com.ironsource.adqualitysdk.sdk.i.dr.c
            /* JADX INFO: renamed from: ﻛ */
            public final /* synthetic */ ee mo2129(List list2) {
                int i2 = f1846 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
                f1847 = i2 % 128;
                if (i2 % 2 == 0) {
                    m2131(list2);
                    throw null;
                }
                ee eeVarM2131 = m2131(list2);
                f1847 = (f1846 + 25) % 128;
                return eeVarM2131;
            }
        })));
        f1834 = (f1835 + 107) % 128;
        return frVarM2102;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ironsource.adqualitysdk.sdk.i.fr m2100(java.util.List<com.ironsource.adqualitysdk.sdk.i.dx> r11) {
        /*
            r10 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.dr.f1834
            int r0 = r0 + 15
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.dr.f1835 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r4 = 51080(0xc788, float:7.1578E-41)
            if (r0 != 0) goto L39
            com.ironsource.adqualitysdk.sdk.i.dx r0 = r10.m2083(r11)
            r5 = 1
            int r7 = android.widget.ExpandableListView.getPackedPositionGroup(r5)
            int r7 = r4 >> r7
            char r7 = (char) r7
            android.view.ViewConfiguration.getKeyRepeatTimeout()
            long r8 = android.view.ViewConfiguration.getZoomControlsTimeout()
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            int r5 = r5 + 94
            java.lang.String r5 = m2124(r7, r1, r5)
            java.lang.String r5 = r5.intern()
            boolean r0 = r0.m2167(r5)
            if (r0 == 0) goto L6c
            goto L61
        L39:
            com.ironsource.adqualitysdk.sdk.i.dx r0 = r10.m2083(r11)
            int r5 = android.widget.ExpandableListView.getPackedPositionGroup(r2)
            int r5 = r5 + r4
            char r5 = (char) r5
            int r6 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r6 = r6 >> 16
            int r6 = 1 - r6
            long r7 = android.view.ViewConfiguration.getZoomControlsTimeout()
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            int r7 = 44 - r7
            java.lang.String r5 = m2124(r5, r6, r7)
            java.lang.String r5 = r5.intern()
            boolean r0 = r0.m2167(r5)
            if (r0 == 0) goto L6c
        L61:
            com.ironsource.adqualitysdk.sdk.i.fs r0 = new com.ironsource.adqualitysdk.sdk.i.fs
            r5 = 0
            r0.<init>(r5)
            com.ironsource.adqualitysdk.sdk.i.fr r0 = m2102(r0)
            goto L79
        L6c:
            com.ironsource.adqualitysdk.sdk.i.fs r0 = new com.ironsource.adqualitysdk.sdk.i.fs
            com.ironsource.adqualitysdk.sdk.i.ee r5 = r10.m2126(r11)
            r0.<init>(r5)
            com.ironsource.adqualitysdk.sdk.i.fr r0 = m2102(r0)
        L79:
            java.lang.String r5 = ""
            int r6 = android.text.TextUtils.indexOf(r5, r5)
            int r6 = r6 + r4
            char r4 = (char) r6
            int r6 = android.view.MotionEvent.axisFromString(r5)
            int r6 = -r6
            int r7 = android.view.ViewConfiguration.getKeyRepeatTimeout()
            int r7 = r7 >> 16
            int r7 = 43 - r7
            java.lang.String r4 = m2124(r4, r6, r7)
            java.lang.String r4 = r4.intern()
            int r6 = android.view.ViewConfiguration.getScrollBarSize()
            int r6 = r6 >> 8
            char r6 = (char) r6
            int r5 = android.view.MotionEvent.axisFromString(r5)
            int r5 = r5 + 37
            long r7 = android.view.ViewConfiguration.getGlobalActionKeyTimeout()
            int r2 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            int r2 = 656 - r2
            java.lang.String r2 = m2124(r6, r5, r2)
            java.lang.String r2 = r2.intern()
            r10.m2109(r11, r4, r0, r2)
            int r11 = com.ironsource.adqualitysdk.sdk.i.dr.f1834
            int r11 = r11 + 95
            int r2 = r11 % 128
            com.ironsource.adqualitysdk.sdk.i.dr.f1835 = r2
            int r11 = r11 % 2
            if (r11 != 0) goto Lc5
            r11 = 29
            int r11 = r11 / r1
        Lc5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dr.m2100(java.util.List):com.ironsource.adqualitysdk.sdk.i.fr");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static fr m2102(fr frVar) {
        fr frVar2 = f1837.get(frVar);
        if (frVar2 == null) {
            int i2 = f1835 + 113;
            f1834 = i2 % 128;
            if (i2 % 2 != 0) {
                f1837.put(frVar, frVar);
                int i8 = 58 / 0;
            } else {
                f1837.put(frVar, frVar);
            }
        } else {
            frVar = frVar2;
        }
        f1834 = (f1835 + 83) % 128;
        return frVar;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Pair m2104(dr drVar, List list) {
        int i2 = f1834 + 9;
        f1835 = i2 % 128;
        if (i2 % 2 == 0) {
            drVar.m2090(list);
            throw null;
        }
        Pair<String, ee> pairM2090 = drVar.m2090(list);
        int i8 = f1834 + 87;
        f1835 = i8 % 128;
        if (i8 % 2 != 0) {
            return pairM2090;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m2116() {
        char[] cArr = new char[1307];
        a0.o(" \u0092\u0000mç´ÏÖ·\u001b\u009f+\u0087qnÆVÕ>ç&=\u000eSõÛÝ¿Åõ\u00ad\u0001\u0095J}|d\u0085L\u00924á\u001c1\u0004\u0005ë\u0097Óç»û£\u0006\u008bWs{Z³BØ*\u0010\u0012+ú\u0000á\u0082É¶±ò\u0099\u0010\u0081PikP²8Æ \rÇ³\u0000iç·\u0000fç¾ÏÐ\rjê¤ÂÖº\u0002\u0092<\u0000rç´ÏÖ·\u0006\u009f6\u0087{T\u0087³F\u009b\"ã÷ËÊÌ\u000b+Ö\u0003¤{oSEK\u0013¢û\u009aº±;Vì~\u0094\u0000vç°ÏÐ\u0000mç¸ÏÑ·\u0000\u009f-\u0087{n\u0081V\u0097>¯&b\u000e\rõÛÝ\u00adÅé\u00adN\u0095Z}~d\u0085L\u00924ì\u001c2\u0004\u0005ë\u0085Ó³»ù£\u001d\u008b_sfZ¹BÃ*\nH\u0015\u0000iç·Ï\u0082·\u0000\u009f0\u0087tn\u0092VÒ>å&<\u000eDõ\u008fÝìÅî\u00ad\u0006\u0095P}ed\u008dLÖ4£\u001c6\u0004@ëÖÓ¡»÷£\u0005\u008bVsdZ«BÈ*\u001a\u0012oúBá\u0088Éâ±ò\u0099D\u0081\u0012i.Pð{Ð\u0000iç·Ï\u0082·\u0000\u009f0\u0087tn\u0092VÒ>å&<\u000eDõ\u008fÝìÅþ\u00ad\u0001\u0095Q}td\u0088LÆ4ê\u001c;\u0004KëÖÓ´»ð£\u0006\u008bOsgZ¸B\u008d*\u001c\u0012*ú\u0000á\u0098É¬±à\u0099\r\u0081QicP÷8\u008f Q\bcð<\u0000eç½ÏÑ·\u0016\u0000fç¾ÏÐ·S\u009f7\u0087an\u0087VÃ>í&4\u000eOõ\u0095Ý¸Å½\u00ad\u001d\u0095W}\u007fd\u0094LÞ4ç\u001ct\u0004Gë\u0093Óç»þ£\u0006\u008bVsgZ³BÚ*\u001b\u0012+ú\u0000á\u0093É»±³\u0099\u0005\u0081\u0015i!Pÿ8\u008fV¯±w\u0099\u0019á\u009aÉîÑ³8A\u0000\u001ah(päX\u008a£]\u008bk\u0093tûÔÃ\u009e+¶2]\u001a\u0017b.J½R\u0089½Q\u0085jíqõ×Ý\u009a%¶\f}\u0014D|\u0090D½¬Î\u0000oç¡ÏÖ·\u001a\u009f+\u0087{n\u0087VÛ>¨&<\u000eRõ\u008bÝ¾Åø\u00ad\u001d\u0095L}yd\u008eLÜ4£\u001c'\u0004Më\u0099Ó²»ô£\r\u008b\u001asnZ²BÉ*^\u00128úIá\u0085Éª±³Óì4\"\u001cPd\u0084LºT®½\u000e\u0085Xírõ¶ÝÔ&\r\u000e2\u0016h~\u0081F\u0084®ø·\u0012\u009fFçmÏ£×Ú8M\u0000>hfpÒXÇ ÿ\u0089+\u0091Zù\u008aÁ£)Þ2\u000e\u001aybjJ\u0086R\u008eºü\u0083lë\u0014óÊÛö\u0000wç¹ÏË·\u001f\u009f!\u00875n\u0095VÃ>é&-\u000eOõ\u0096Ý©Åó\u00ad\u001a\u0095\u001f}sd\u008eLÜ4ç\u001c=\u0004Që\u009fÓ¨»ö£I\u008bIscZ³BØ*\u0012\u0012+ú\u0000á\u0093É§±³\u0099\r\u0081[iuP¾8Ì \u001c\bjð<×Ä¿\u0094§©/ È÷à\u008f\u0098\u0007°c¨5AÓy\u0097\u0011¹\t`!\u001bÚÁòìêé\u0082Wº\u001eR7KÁcÆ\u001bµ3e+QÄÁüü\u0094¡\u008cM¤\u0001\\*uæm\u009d\u0005\n=3Õ\u001dÎËæå\u009e®¶T®\u0004Fr\u007f¤\u0017\u0087\u000fP'9ßf\u0000cç°ÏÖ·\u0010\u009f,\býï*ÇR¿Ú\u0097¾\u008fèf\u000e^J6d.½\u0006Æý\u001cÕ1Í4¥\u0094\u009dÞuöl\u001dDW<n\u0014ý\fÎã\u001aÛn³w«\u008f\u0083ß{îR:JS\"\u0092\u001a¢ò\u0089é\u001aÁ2¹:\u0091\u008c\u0089\u009caìX?0U(\u0093\u0000«ø²ß\u0016·@¯f\u0087¢\u007fÜWåN>&D\u001e\u0089\u0000cç°ÏÖ·\u0010\u009f,\u00875n\u008dVÒ>ñ&.\u000eEõ\u0089Ý¨Å½\u00ad\u001d\u0095W}\u007fd\u0094LÞ4ç\u001ct\u0004Gë\u0093Óç»þ£\u0006\u008bVsgZ³BÚ*\u001b\u0012+ú\u0000á\u0093É»±³\u0099\u0005\u0081\u0015i!Pÿ8\u008f\u0000mç¸ÏÑ·\u0000\u009f-\u0087{n\u0081V\u0097>ë&8\u000e^õ\u0098Ý¤Å½\u00ad\u0018\u0095^}bd\u0088LÓ4á\u001c8\u0004@ëÖÓ©»ù£\u0004\u008b_\u0000cç°ÏÖ·\u0010\u009f,\u00875n\u0096VÖ>ú&8\u000eGõÛÝ¿Åõ\u00ad\u0001\u0095J}|d\u0085L\u00924á\u001c1\u0004\u0005ë\u0090Ó¨»ô£\u0005\u008bUs|Z¹BÉ*^\u0012-úYáÑÉ£±³\u0099C\u0081\u001ci!hE\u008f\u0096§ðß6÷\nï\u0013\u0006³>åVÏN\u000bfi\u009d°µ\u008f\u00adÕÅ<ý9\u0015[\f²$ç\\ÑtRla\u0083µ»ÁÓÝË ãq\u001b]2\u0095*þB6z\r\u0092&\u0089ÿ¡\u008dÙÛñ1éz\u0001D8\u0094P®Hx`\u0017\u0098@¿í×²\u0000rç´ÏÖ·\u0006\u009f6\u0087{nÆVÄ>ü&8\u000e^õ\u009eÝ¡Åø\u00ad\u0000\u0095K}0d\u0092LÚ4ì\u001c!\u0004Ië\u0092Óç»ý£\u0007\u008b^s+Z«BÄ*\n\u0012'ú\u0000áÖÉù±´\u0000bç£ÏÇ·\u0012\u009f/\u00875n\u0095VÃ>é&-\u000eOõ\u0096Ý©Åó\u00ad\u001a\u0095\u001f}cd\u0089LÝ4ö\u001c8\u0004AëÖÓ¢»ö£\r\u008b\u001as|ZµBÙ*\u0016\u0012oú\u0007áÊÉå\u0000cç¾ÏÌ·\u0007\u009f-\u0087{n\u0093VÒ>¨&*\u000e^õ\u009aÝ¸Åø\u00ad\u0003\u0095Z}~d\u0095L\u00924ð\u001c<\u0004Jë\u0083Ó«»ü£I\u008b_seZ¸B\u008d*\t\u0012&úTá\u0099Éâ±´\u0099_\u0081\u0012\u0014\u000b\u0000&ç÷&5Áä\u009e\u0003yÒÙ\u009c>Q\u0000<\u0000>\bAï\u0091tº\u0093h´²hõ·\u0081PP\u0000-çü÷}[Hà-\u0000.2w¥\u009d\u0000!\u0000mç¸ÏÑ·\u0000\u009f-\u0087{n\u0081V\u0097>ë&5\u000eEõ\u0088Ý¥Åó\u00ad\t\u0095\u001f}7dÈL\u0095¦j\u0000Uç¿ÏÇ·\u000b\u009f4\u0087pn\u0085VÃ>í&=\u000e\nõ\u0094Ý¼Åø\u00ad\u001c\u0095^}dd\u008eLÀ4£\u0000Uç¿ÏÇ·\u000b\u009f4\u0087pn\u0085VÃ>í&=\u000e\nõ\u008fÝ£Åö\u00ad\u000b\u0095Q}0\u0000Cç°Ï×·\u0014\u009f,\u0087anÆVÒ>ð&:\u000eOõ\u008bÝ¸Åô\u00ad\u0001\u0095Q\u0000Eç©ÏÒ·\u0016\u009f'\u0087an\u0083VÓ>¨&0\u000eNõ\u009eÝ¢Åé\u00ad\u0007\u0095Y}yd\u0084LÀ4£\u001c6\u0004Pë\u0082Óç»ÿ£\u0006\u008bNs+\u0000rç´ÏÄ·\u001f\u009f!\u0087vn\u0092VÞ>ç&7\u000e\nõ\u0098Ý Åü\u00ad\u001d\u0095L}0d\u008fLÓ4î\u001c1\u0004VëÖÓ´»ð£\u0006\u008bOsgZ¸B\u008d*\u001c\u0012*ú\u0000á\u0097É\u00ad±ÿ\u0099\b\u0081ZiqP²8Ì Y\b(ðb×Ì¿Ô§à\u008f)w__bF³.×\u0016\u001dþ*æxÍÇµ\u009f\u009d¡\u0085tm\u0005TÒ<ä$¹Î\u0085)R\u00016yöQÑI\u0091 y\u00981ð\nè\u008fÀ¯;e\u0013U\u000b\u001ecô[\u00ad³Æªu\u0082!úUÒÁÊ¿%o\u001dBu\u000bmûEì½\u008a\u0094C\u008c/äàÜ\u00994ñ/Z\u0007\u0013\u008dkj¡BË:\u001a\u000fæè1ÀG¸\u0083\u0090£\u0000sç¤ÏÒ·\u0016\u009f6\u00875n\u0095Vß>ç&,\u000eFõ\u009fÝìÅÿ\u00ad\u000b\u0095\u001f}vd\u008eLÞ4ï\u001c;\u0004Rë\u0093Ó£»¸£\u000b\u008bCs+Z½B\u008d*\u0013\u0012*úTá\u0099É\u00ad±÷\u0099D\u0081\\ihP¡8Ç \u001a\b+ðo×\u0085¿Ò§àÙ¾>R\u0016)níFÜ^\u009a·x\u008f(çSÿñ×¥,r\u0004^\u001c\btòLä¤\u0089½o\u0095=íXÅÈÝ±2y\n\u001cæÉ\u0000jç¢ÏÍ·\u001d\u009fd\u0087~n\u0083VÎ>¨&*\u000eBõ\u0094Ý¹Åñ\u00ad\n\u0095\u001f}rd\u0084L\u00924å\u001c;\u0004Ië\u009aÓ¨»ï£\f\u008b^s+Z¾BÔ*^\u0012.ú\u0000á\u0087É£±ÿ\u0099\u0011\u0081Pi&P¶8Î \r\b/ði×Ì¿\u009a§´\u008fx\n¶\u0000lç¸ÏÑ·\u0007\u009fd\u0087fn\u008eVØ>ý&5\u000eNõÛÝ©Åó\u00ad\n\u0095\u001f}gd\u0088LÆ4ë\u001ct\u0004\u0002\u000b¦B5¥ß\u008d§õkÝTÅ\u0010,å\u0014£|\u008dd]Lj·þ\u009fÂ\u0087\u0099ï.×0?\u0016&¡\u000e¦v\u008c^_F ©ø\u0091Ô\u0000Eç©ÏÁ·\u0016\u009f4\u0087an\u008fVØ>æ&y\u000e]õ\u0093Ý¥Åñ\u00ad\u000b\u0095\u001f}wd\u0084LÆ4÷\u001c=\u0004Kë\u0091Óç»ö£\f\u008bBs\u007fZüBÙ*\u0011\u0012$úEá\u009fQÅ¶)\u009eAæ\u0096Î´Öá?\u000f\u0007Xofwù_Ý¤\u0013\u008c%\u0094qü\u008bÄ\u009f,à5\u0004\u001dWehM½UËº\u0011\u0082gêyò\u009dÚ\u009a\"å\u000b9\u0013U{\u008aCï«Ô°\u001e\u0098)àvÈ\u008a\u0000 ç°ÏÄ·\u0007\u009f!\u0087gnÆ\u0000Eç©ÏÒ·\u0016\u009f'\u0087an\u0083VÓ>¨\u0000 ç³Ï×·\u0007\u009fd\u0087gn\u0083VÔ>í&0\u000e\\õ\u009eÝ¨Å½±=Vá~\u009f\u0000Pç°ÏÐ·\u0000\u009f!\u0087gnÉ\u0000Pç°ÏÐ·\u0000\u009f-\u0087{n\u0081V\u0097>î&8\u000eCõ\u0097Ý©Åù\u00adN\u0095[}ed\u0084L\u00924÷\u001c;\u0004\u0005ë\u0093Óµ»ê£\u0006\u008bHsx", "ISO-8859-1", cArr, 0, 1307);
        f1832 = cArr;
        f1833 = -6523822435983759407L;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private fr m2118(List<dx> list) {
        String strM2169 = m2084(list).m2169();
        switch (strM2169.hashCode()) {
            case -934396624:
                if (strM2169.equals(m2124((char) TextUtils.indexOf("", "", 0), 6 - TextUtils.getTrimmedLength(""), 55 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern())) {
                    return m2100(list);
                }
                break;
            case -567202649:
                if (strM2169.equals(m2124((char) (52328 - (ViewConfiguration.getTouchSlop() >> 8)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 7, (ViewConfiguration.getWindowTouchSlop() >> 8) + 65).intern())) {
                    f1835 = (f1834 + 35) % 128;
                    return m2093(list);
                }
                break;
            case AD_START_TO_BACKGROUND_DURATION_MS_VALUE:
                if (strM2169.equals(m2124((char) (51080 - TextUtils.indexOf("", "")), 1 - Color.red(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 44).intern())) {
                    return m2102(new fo(null));
                }
                break;
            case INVALID_RI_ENDPOINT_VALUE:
                if (strM2169.equals(m2124((char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 41193), 1 - (ViewConfiguration.getLongPressTimeout() >> 16), ViewConfiguration.getEdgeSlop() >> 16).intern())) {
                    f1834 = (f1835 + 89) % 128;
                    return m2092(list);
                }
                break;
            case 3357:
                if (strM2169.equals(m2124((char) Color.green(0), 2 - (ViewConfiguration.getJumpTapTimeout() >> 16), 44 - (KeyEvent.getMaxKeyCode() >> 16)).intern())) {
                    return m2123(list);
                }
                break;
            case 101577:
                if (strM2169.equals(m2124((char) View.resolveSizeAndState(0, 0, 0), 3 - Color.alpha(0), Color.rgb(0, 0, 0) + 16777262).intern())) {
                    f1834 = (f1835 + 7) % 128;
                    return m2112(list);
                }
                break;
            case 115131:
                if (strM2169.equals(m2124((char) (45391 - (Process.myTid() >> 22)), 3 - (ViewConfiguration.getScrollBarSize() >> 8), Color.rgb(0, 0, 0) + 16777289).intern())) {
                    int i2 = f1835 + 105;
                    f1834 = i2 % 128;
                    if (i2 % 2 == 0) {
                        return m2098(list);
                    }
                }
                break;
            case 116519:
                if (strM2169.equals(m2124((char) KeyEvent.normalizeMetaState(0), 4 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 75 - TextUtils.lastIndexOf("", '0', 0, 0)).intern())) {
                    f1835 = (f1834 + 103) % 128;
                    return m2099(list);
                }
                break;
            case 94001407:
                if (strM2169.equals(m2124((char) (21733 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), 5 - TextUtils.indexOf("", ""), 60 - View.getDefaultSize(0, 0)).intern())) {
                    f1834 = (f1835 + 3) % 128;
                    return m2097(list);
                }
                break;
            case 113101617:
                if (strM2169.equals(m2124((char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 3357), TextUtils.lastIndexOf("", '0', 0, 0) + 6, Drawable.resolveOpacity(0, 0) + 49).intern())) {
                    return m2096(list);
                }
                break;
        }
        this.f1840--;
        ee eeVarM2126 = m2126(list);
        m2109(list, m2124((char) (51080 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), 1 - View.getDefaultSize(0, 0), 43 - Color.blue(0)).intern(), eeVarM2126, m2124((char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), 31 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 79 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern());
        return m2102(new fo(eeVarM2126));
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ ee m2121(dr drVar, List list) {
        int i2 = f1834 + 23;
        f1835 = i2 % 128;
        if (i2 % 2 == 0) {
            drVar.m2088(list);
            throw null;
        }
        ee eeVarM2088 = drVar.m2088(list);
        f1835 = (f1834 + 83) % 128;
        return eeVarM2088;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m2107(dr drVar, String str) {
        int i2 = f1834 + 71;
        f1835 = i2 % 128;
        int i8 = i2 % 2;
        drVar.m2108(str);
        if (i8 == 0) {
            throw null;
        }
        int i9 = f1835 + 95;
        f1834 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 66 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00f7  */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ironsource.adqualitysdk.sdk.i.fr m2123(java.util.List<com.ironsource.adqualitysdk.sdk.i.dx> r13) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dr.m2123(java.util.List):com.ironsource.adqualitysdk.sdk.i.fr");
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static ee m2106(ee eeVar) {
        f1835 = (f1834 + 85) % 128;
        ee eeVar2 = f1836.get(eeVar);
        if (eeVar2 != null) {
            return eeVar2;
        }
        f1835 = (f1834 + 91) % 128;
        f1836.put(eeVar, eeVar);
        return eeVar;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final fk m2125(List<dx> list) {
        f1835 = (f1834 + 103) % 128;
        this.f1840 = 0;
        m2110(list, m2124((char) (View.resolveSizeAndState(0, 0, 0) + 41193), (ViewConfiguration.getTouchSlop() >> 8) + 1, ViewConfiguration.getMinimumFlingVelocity() >> 16).intern(), m2124((char) ExpandableListView.getPackedPositionType(0L), 41 - TextUtils.indexOf((CharSequence) "", '0', 0), -TextUtils.lastIndexOf("", '0', 0)).intern());
        fk fkVarM2092 = m2092(list);
        int i2 = f1835 + 31;
        f1834 = i2 % 128;
        if (i2 % 2 == 0) {
            return fkVarM2092;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private fr m2112(List<dx> list) {
        m2110(list, m2124((char) (18493 - View.combineMeasuredStates(0, 0)), -TextUtils.indexOf((CharSequence) "", '0', 0, 0), TextUtils.getTrimmedLength("") + 110).intern(), m2124((char) KeyEvent.keyCodeFromString(""), 41 - (ViewConfiguration.getTouchSlop() >> 8), 200 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))).intern());
        ee eeVarM2122 = m2122(list, m2124((char) (51080 - (Process.myPid() >> 22)), 1 - TextUtils.indexOf("", "", 0), 43 - (Process.myTid() >> 22)).intern());
        ee eeVarM2126 = m2126(list);
        m2109(list, m2124((char) (TextUtils.lastIndexOf("", '0', 0, 0) + 51081), KeyEvent.normalizeMetaState(0) + 1, 43 - (Process.myPid() >> 22)).intern(), eeVarM2126, m2124((char) (TextUtils.indexOf("", "", 0, 0) + 22217), 32 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), View.resolveSize(0, 0) + 241).intern());
        fr frVarM2102 = m2102(new fp(eeVarM2122, eeVarM2126, m2122(list, m2124((char) (31737 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), Drawable.resolveOpacity(0, 0) + 1, (ViewConfiguration.getWindowTouchSlop() >> 8) + 151).intern()), m2118(list)));
        int i2 = f1834 + 75;
        f1835 = i2 % 128;
        if (i2 % 2 != 0) {
            return frVarM2102;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final ee m2126(List<dx> list) {
        ee eeVarM2091 = m2091(list);
        if (m2085(list)) {
            Cdo cdoM2067 = Cdo.m2067(this.f1839, eeVarM2091.m2191());
            String strM2169 = m2084(list).m2169();
            int iHashCode = strM2169.hashCode();
            if (iHashCode != 1216) {
                if (iHashCode == 3968 && strM2169.equals(m2124((char) (9800 - MotionEvent.axisFromString("")), ExpandableListView.getPackedPositionGroup(0L) + 2, Color.green(0) + 767).intern())) {
                    f1834 = (f1835 + 73) % 128;
                    return m2106(new ez(eeVarM2091, m2126(list), cdoM2067));
                }
            } else if (strM2169.equals(m2124((char) (ImageFormat.getBitsPerPixel(0) + 1), 2 - TextUtils.indexOf("", ""), TextUtils.indexOf("", "", 0) + 765).intern())) {
                f1834 = (f1835 + 57) % 128;
                return m2106(new ek(eeVarM2091, m2126(list), cdoM2067));
            }
            this.f1840--;
        }
        return eeVarM2091;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private ee m2101(ee eeVar, List<dx> list) {
        List<ee> listM2087;
        dx dxVarM2084 = m2084(list);
        if (!dxVarM2084.m2160()) {
            StringBuilder sb = new StringBuilder();
            sb.append(m2124((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 28 - Color.green(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 865).intern());
            sb.append(dxVarM2084);
            m2120(sb.toString(), (Throwable) null);
        }
        String strM2169 = dxVarM2084.m2169();
        dx dxVarM20842 = m2084(list);
        if (dxVarM20842.m2167(m2124((char) (Process.getGidForName("") + 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 1, 772 - ExpandableListView.getPackedPositionChild(0L)).intern())) {
            listM2087 = m2087(list);
            m2109(list, m2124((char) (18493 - ExpandableListView.getPackedPositionGroup(0L)), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1, View.MeasureSpec.getMode(0) + 110).intern(), listM2087, m2124((char) Color.argb(0, 0, 0, 0), 63 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 893 - Gravity.getAbsoluteGravity(0, 0)).intern());
        } else {
            if (!dxVarM20842.m2167(m2124((char) (18493 - TextUtils.indexOf("", "", 0)), Color.blue(0) + 1, View.MeasureSpec.getSize(0) + 110).intern())) {
                this.f1840--;
                ee eeVarM2106 = m2106(new ea(eeVar, strM2169, Cdo.m2067(strM2169, dxVarM20842.m2171())));
                int i2 = f1835 + 59;
                f1834 = i2 % 128;
                if (i2 % 2 == 0) {
                    return eeVarM2106;
                }
                throw null;
            }
            listM2087 = null;
        }
        ee eeVarM21062 = m2106(new eb(eeVar, strM2169, listM2087, m2114(list, m2124((char) (31737 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 1 - TextUtils.indexOf("", "", 0), 152 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern()), Cdo.m2067(strM2169, dxVarM20842.m2171())));
        int i8 = f1835 + 1;
        f1834 = i8 % 128;
        if (i8 % 2 == 0) {
            return eeVarM21062;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private ee m2111(dx dxVar, List<dx> list) {
        f1834 = (f1835 + 5) % 128;
        String strM2169 = dxVar.m2169();
        int iHashCode = strM2169.hashCode();
        if (iHashCode == 3392903) {
            if (strM2169.equals(m2124((char) (36101 - TextUtils.indexOf("", "")), 4 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), TextUtils.lastIndexOf("", '0', 0) + 992).intern())) {
                return fl.m2228();
            }
            return null;
        }
        if (iHashCode != 109801339 || !strM2169.equals(m2124((char) (3989 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), 5 - TextUtils.getTrimmedLength(""), 996 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern())) {
            return null;
        }
        m2109(list, m2124((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 1 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.makeMeasureSpec(0, 0) + 788).intern(), dxVar, m2124((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), ExpandableListView.getPackedPositionChild(0L) + 48, View.combineMeasuredStates(0, 0) + 1000).intern());
        ee eeVarM2101 = m2101(m2106(new em(m2124((char) (3988 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (Process.myTid() >> 22) + 5, 995 - Gravity.getAbsoluteGravity(0, 0)).intern(), Cdo.m2067(this.f1839, dxVar.m2171()))), list);
        f1835 = (f1834 + 47) % 128;
        return eeVarM2101;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ee m2122(List<dx> list, String str) {
        int i2 = f1834 + 109;
        f1835 = i2 % 128;
        if (i2 % 2 != 0) {
            if (m2083(list).m2167(str)) {
                return null;
            }
            ee eeVarM2126 = m2126(list);
            m2109(list, str, eeVarM2126, a0.d(new StringBuilder(), m2124((char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), 36 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 274 - View.resolveSizeAndState(0, 0, 0)), str));
            f1835 = (f1834 + 21) % 128;
            return eeVarM2126;
        }
        m2083(list).m2167(str);
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private ee m2105(dx dxVar) {
        int i2 = f1835 + 39;
        f1834 = i2 % 128;
        if (i2 % 2 == 0) {
            Cdo cdoM2067 = Cdo.m2067(this.f1839, dxVar.m2171());
            if (dxVar.m2164()) {
                try {
                    try {
                        ee eeVarM2106 = m2106(new ff(Integer.valueOf(Integer.parseInt(dxVar.m2169())), cdoM2067));
                        int i8 = f1835 + 51;
                        f1834 = i8 % 128;
                        if (i8 % 2 != 0) {
                            int i9 = 3 / 0;
                        }
                        return eeVarM2106;
                    } catch (Exception unused) {
                        return m2106(new fh(Long.valueOf(Long.parseLong(dxVar.m2169())), cdoM2067));
                    }
                } catch (Exception unused2) {
                }
            } else {
                if (dxVar.m2163()) {
                    return m2106(new fe(Double.valueOf(Double.parseDouble(dxVar.m2169())), cdoM2067));
                }
                if (dxVar.m2161()) {
                    return m2106(new fg(Boolean.valueOf(Boolean.parseBoolean(dxVar.m2169())), cdoM2067));
                }
            }
            return m2106(new fm(dxVar.m2169(), cdoM2067));
        }
        Cdo.m2067(this.f1839, dxVar.m2171());
        dxVar.m2164();
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private List<ee> m2114(List<dx> list, String str) {
        List<ee> listM2115 = m2115(list, str, new c<ee>() { // from class: com.ironsource.adqualitysdk.sdk.i.dr.3
            @Override // com.ironsource.adqualitysdk.sdk.i.dr.c
            /* JADX INFO: renamed from: ﻛ */
            public final /* bridge */ /* synthetic */ ee mo2129(List list2) {
                return dr.this.m2126((List<dx>) list2);
            }
        });
        f1835 = (f1834 + 93) % 128;
        return listM2115;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private <T> List<T> m2115(List<dx> list, String str, c<T> cVar) {
        int i2;
        ArrayList arrayList = new ArrayList();
        if (!m2084(list).m2167(str)) {
            int i8 = f1834 + 39;
            f1835 = i8 % 128;
            if (i8 % 2 == 0) {
                i2 = this.f1840;
            } else {
                i2 = this.f1840 - 1;
            }
            this.f1840 = i2;
            arrayList.add(cVar.mo2129(list));
            dx dxVarM2084 = m2084(list);
            f1834 = (f1835 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            while (dxVarM2084.m2167(m2124((char) (2713 - TextUtils.indexOf((CharSequence) "", '0')), 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16), Drawable.resolveOpacity(0, 0) + 1120).intern())) {
                int i9 = f1835 + 115;
                f1834 = i9 % 128;
                if (i9 % 2 != 0) {
                    arrayList.add(cVar.mo2129(list));
                    dxVarM2084 = m2084(list);
                    int i10 = 50 / 0;
                } else {
                    arrayList.add(cVar.mo2129(list));
                    dxVarM2084 = m2084(list);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(m2124((char) Color.alpha(0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 22, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 1120).intern());
            sb.append(str);
            m2103(dxVarM2084, str, arrayList, com.google.android.gms.ads.internal.client.a.z(sb, m2124((char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 2945), TextUtils.getOffsetAfter("", 0) + 1, 1143 - View.resolveSizeAndState(0, 0, 0))));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2103(dx dxVar, String str, Object obj, String str2) {
        int i2 = f1835 + 67;
        f1834 = i2 % 128;
        if (i2 % 2 != 0) {
            dxVar.m2167(str);
            throw null;
        }
        if (dxVar.m2167(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m2124((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 2945), 1 - Color.green(0), TextUtils.indexOf((CharSequence) "", '0', 0) + 1144).intern());
        sb.append(str);
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2124((char) (TextUtils.getCapsMode("", 0, 0) + 2945), 1 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 1143 - (ViewConfiguration.getTapTimeout() >> 16)));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m2124((char) ((Process.myPid() >> 22) + 2945), (KeyEvent.getMaxKeyCode() >> 16) + 1, (Process.myTid() >> 22) + 1143).intern());
        sb2.append(dxVar.m2169());
        m2108(m2113(strZ, com.google.android.gms.ads.internal.client.a.z(sb2, m2124((char) (2944 - TextUtils.lastIndexOf("", '0', 0, 0)), 1 - (Process.myTid() >> 22), 1143 - KeyEvent.keyCodeFromString(""))), obj, str2));
        f1834 = (f1835 + 35) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2110(List<dx> list, String str, String str2) {
        f1835 = (f1834 + 101) % 128;
        m2109(list, str, null, str2);
        int i2 = f1834 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f1835 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2124(char c7, int i2, int i8) {
        String str;
        synchronized (com.ironsource.adqualitysdk.sdk.i.c.f1192) {
            try {
                char[] cArr = new char[i2];
                com.ironsource.adqualitysdk.sdk.i.c.f1193 = 0;
                while (true) {
                    int i9 = com.ironsource.adqualitysdk.sdk.i.c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1832[i8 + i9]) ^ (((long) i9) * f1833)) ^ ((long) c7));
                        com.ironsource.adqualitysdk.sdk.i.c.f1193 = i9 + 1;
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2109(List<dx> list, String str, Object obj, String str2) {
        f1834 = (f1835 + 89) % 128;
        m2103(m2084(list), str, obj, str2);
        int i2 = f1834 + 115;
        f1835 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private ee m2117(ee eeVar, List<dx> list) {
        f1834 = (f1835 + 113) % 128;
        ee eeVarM2126 = m2126(list);
        m2109(list, m2124((char) (42551 - TextUtils.getCapsMode("", 0, 0)), 1 - (Process.myPid() >> 22), 811 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)).intern(), eeVarM2126, m2124((char) (52982 - TextUtils.getOffsetAfter("", 0)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 36, (ViewConfiguration.getTapTimeout() >> 16) + 956).intern());
        dx dxVarM2084 = m2084(list);
        Cdo cdoM2067 = Cdo.m2067(this.f1839, dxVarM2084.m2171());
        if (dxVarM2084.m2167(m2124((char) (42400 - ExpandableListView.getPackedPositionType(0L)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), Color.red(0) + 790).intern())) {
            ee eeVarM2106 = m2106(new ei(eeVar, eeVarM2126, m2126(list), cdoM2067));
            f1834 = (f1835 + 29) % 128;
            return eeVarM2106;
        }
        this.f1840--;
        return m2106(new ef(eeVar, eeVarM2126, cdoM2067));
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m2108(String str) {
        int i2 = f1835 + 51;
        f1834 = i2 % 128;
        int i8 = i2 % 2;
        m2120(str, (Throwable) null);
        if (i8 != 0) {
            int i9 = 25 / 0;
        }
        int i10 = f1834 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1835 = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 81 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0042  */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m2113(java.lang.String r7, java.lang.String r8, java.lang.Object r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.dr.m2113(java.lang.String, java.lang.String, java.lang.Object, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m2119(dx dxVar, dx.e eVar, Object obj, String str) {
        if (!dxVar.m2170().equals(eVar)) {
            f1835 = (f1834 + 31) % 128;
            m2108(m2113(eVar.toString(), dxVar.m2170().toString(), obj, str));
        }
        int i2 = f1834 + 49;
        f1835 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m2120(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(m2124((char) (ViewConfiguration.getLongPressTimeout() >> 16), 7 - (ViewConfiguration.getDoubleTapTimeout() >> 16), Color.blue(0) + 1272).intern());
        sb.append(this.f1838);
        sb.append(m2124((char) (23399 - Gravity.getAbsoluteGravity(0, 0)), -TextUtils.lastIndexOf("", '0'), 786 - View.combineMeasuredStates(0, 0)).intern());
        sb.append(this.f1839);
        co.m1671(sb.toString(), str, th);
        throw new RuntimeException(m2124((char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), 28 - View.resolveSizeAndState(0, 0, 0), 1279 - View.getDefaultSize(0, 0)).intern(), th);
    }
}
