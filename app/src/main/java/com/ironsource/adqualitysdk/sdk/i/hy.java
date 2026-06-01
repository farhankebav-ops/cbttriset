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
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.hz;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class hy {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f2415 = 1;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char f2416 = 64881;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2417 = 0;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char f2418 = 17772;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2419 = 155;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2420 = 1193;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f2421 = 43667;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Map<hz.b, hv> f2422;

    public hy() {
        m2414(254 - View.resolveSizeAndState(0, 0, 0), 11 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 9 - TextUtils.indexOf("", ""), false).intern();
        this.f2422 = new HashMap();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static List m2415(Object obj, hz hzVar, int i2) {
        int i8 = f2417 + 51;
        f2415 = i8 % 128;
        if (i8 % 2 == 0) {
            m2416(obj, hzVar.m2445(i2), hzVar.m2454(i2), hzVar.m2452(i2));
            throw null;
        }
        List listM2416 = m2416(obj, hzVar.m2445(i2), hzVar.m2454(i2), hzVar.m2452(i2));
        int i9 = f2415 + 9;
        f2417 = i9 % 128;
        if (i9 % 2 == 0) {
            return listM2416;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static List<Object> m2422(Class cls, Object obj, hm hmVar) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<Field> it = hu.m2386().m2389().m2331(cls, hmVar).iterator();
            while (it.hasNext()) {
                f2417 = (f2415 + 1) % 128;
                arrayList.add(it.next().get(obj));
            }
            f2417 = (f2415 + 51) % 128;
            return arrayList;
        } catch (Throwable unused) {
            String strIntern = m2414(TextUtils.indexOf("", "", 0) + 254, 11 - ((byte) KeyEvent.getModifierMetaStateMask()), "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 9 - (KeyEvent.getMaxKeyCode() >> 16), false).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2421("䟪\ufdd9\ue55d옦蓝銹\uf1f6↝ς᠐䁏\u31ee݄\uabfc", 15 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))).intern());
            sb.append(hmVar.m2309());
            sb.append(m2421("̩覻嘐\uf45d뒤Ĩ\ueead齿\u0380畜됖\udd97", (Process.myPid() >> 22) + 11).intern());
            sb.append(cls);
            sb.append(m2414(TextUtils.lastIndexOf("", '0', 0, 0) + 250, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 5, "ￂ\u0005\u000e\u0003\u0015\u0015", TextUtils.getOffsetBefore("", 0) + 6, false).intern());
            k.m2863(strIntern, sb.toString());
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static <T> T m2431(Class cls, Object obj, hm hmVar, T t3) {
        f2417 = (f2415 + 107) % 128;
        try {
            Field fieldM2329 = hu.m2386().m2389().m2329(cls, hmVar);
            if (fieldM2329 == null) {
                return t3;
            }
            T t7 = (T) fieldM2329.get(obj);
            int i2 = f2417 + 103;
            f2415 = i2 % 128;
            if (i2 % 2 != 0) {
                return t7;
            }
            throw null;
        } catch (Throwable unused) {
            String strIntern = m2414(254 - (KeyEvent.getMaxKeyCode() >> 16), ImageFormat.getBitsPerPixel(0) + 13, "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 9 - (ViewConfiguration.getDoubleTapTimeout() >> 16), false).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(m2421("䟪\ufdd9\ue55d옦蓝銹\uf1f6↝ς᠐䁏\u31ee݄\uabfc", View.resolveSize(0, 0) + 14).intern());
            sb.append(hmVar.m2309());
            sb.append(m2421("̩覻嘐\uf45d뒤Ĩ\ueead齿\u0380畜됖\udd97", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 11).intern());
            sb.append(cls);
            sb.append(m2414(249 - TextUtils.indexOf("", "", 0), 6 - Color.red(0), "ￂ\u0005\u000e\u0003\u0015\u0015", 6 - View.MeasureSpec.makeMeasureSpec(0, 0), false).intern());
            k.m2863(strIntern, sb.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final <T> hs<T> m2434(Object obj, ia iaVar, hq hqVar, List<String> list, int i2) {
        hs<T> hsVarM2438 = m2438(obj, new hz.a().m2468(true).m2469(iaVar, hqVar, list, i2));
        f2415 = (f2417 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return hsVarM2438;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final <T> hs<T> m2438(Object obj, hz hzVar) {
        long j;
        long jCurrentTimeMillis = System.currentTimeMillis();
        hz.b bVarM2448 = hzVar.m2448(obj.getClass());
        hv hvVar = this.f2422.get(bVarM2448);
        if (hvVar != null) {
            int i2 = f2417 + 41;
            f2415 = i2 % 128;
            if (i2 % 2 == 0) {
                m2419(obj, hvVar);
                throw null;
            }
            hs<T> hsVarM2419 = m2419(obj, hvVar);
            if (hsVarM2419 != null) {
                int i8 = f2415 + 105;
                j = 0;
                f2417 = i8 % 128;
                if (i8 % 2 != 0) {
                    m2423(hzVar.m2449(), hsVarM2419);
                    throw null;
                }
                if (m2423(hzVar.m2449(), hsVarM2419)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2414(247 - TextUtils.getTrimmedLength(""), (-16777197) - Color.rgb(0, 0, 0), "\n\u0013\u0019\u0012\bￄ\n\u0016\u0013\u0011ￄ\u0014\u0005\u0018\fￄ\r\u0012ￄ", MotionEvent.axisFromString("") + 20, false).intern());
                    sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    m2428(hsVarM2419, obj, com.google.android.gms.ads.internal.client.a.z(sb, m2421("禨鎄", 1 - TextUtils.lastIndexOf("", '0'))));
                    return hsVarM2419;
                }
            } else {
                j = 0;
            }
            String strIntern = m2414(254 - (KeyEvent.getMaxKeyCode() >> 16), (Process.getElapsedCpuTime() > j ? 1 : (Process.getElapsedCpuTime() == j ? 0 : -1)) + 11, "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 8, false).intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(m2414(245 - TextUtils.getOffsetBefore("", 0), 11 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), "\u0013ￆ\u000e\u001a\u0007\u0016ￆ￠\u0019\u0019\u000f", AndroidCharacter.getMirror('0') - '(', true).intern());
            k.m2863(strIntern, sb2.toString());
            this.f2422.remove(bVarM2448);
        } else {
            j = 0;
        }
        hw<T> hwVar = new hw<>(hzVar);
        hs<T> hsVarM2417 = m2417(obj, hwVar, 0, null);
        if (hsVarM2417 != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(m2421("֔丱\uf244릑롚\ue148䁏\u31ee됖\udd97", 9 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern());
            sb3.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb3.append(m2414((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 230, 3 - ((byte) KeyEvent.getModifierMetaStateMask()), "(\"ￕ￡", 1 - ImageFormat.getBitsPerPixel(0), true).intern());
            sb3.append(hwVar.m2398().size());
            m2428(hsVarM2417, obj, com.google.android.gms.ads.internal.client.a.z(sb3, m2414(247 - TextUtils.getTrimmedLength(""), 15 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), "\u0007\t\u000e\u0006\u0013ￄ\u0018\t\u0017ￄ\u0012\rￄ\u0017\u0018", KeyEvent.getDeadChar(0, 0) + 6, true)));
            this.f2422.put(bVarM2448, hwVar.m2397());
            return hsVarM2417;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(m2421("忦뻰\ue492Ȥ֔丱\uf244릑롚\ue148䁏\u31ee됖\udd97", 13 - (KeyEvent.getMaxKeyCode() >> 16)).intern());
        sb4.append(System.currentTimeMillis() - jCurrentTimeMillis);
        sb4.append(m2414(Drawable.resolveOpacity(0, 0) + 230, (ViewConfiguration.getTapTimeout() >> 16) + 4, "(\"ￕ￡", 2 - (ViewConfiguration.getJumpTapTimeout() >> 16), true).intern());
        sb4.append(hwVar.m2398().size());
        m2428((hs) null, obj, com.google.android.gms.ads.internal.client.a.z(sb4, m2414(Gravity.getAbsoluteGravity(0, 0) + 247, 15 - (ExpandableListView.getPackedPositionForGroup(0) > j ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == j ? 0 : -1)), "\u0007\t\u000e\u0006\u0013ￄ\u0018\t\u0017ￄ\u0012\rￄ\u0017\u0018", (Process.myTid() >> 22) + 6, true)));
        int i9 = f2415 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f2417 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 85 / 0;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List m2416(java.lang.Object r3, boolean r4, boolean r5, boolean r6) {
        /*
            r0 = 0
            r1 = 0
            if (r3 == 0) goto L6c
            boolean r2 = r3 instanceof java.util.Collection
            if (r2 == 0) goto L1a
            int r2 = com.ironsource.adqualitysdk.sdk.i.hy.f2417
            int r2 = r2 + 47
            int r2 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2415 = r2
            if (r4 == 0) goto L1a
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Collection r3 = (java.util.Collection) r3
            r1.<init>(r3)
            goto L6c
        L1a:
            java.lang.Class r4 = r3.getClass()
            boolean r4 = r4.isArray()
            if (r4 == 0) goto L46
            int r4 = com.ironsource.adqualitysdk.sdk.i.hy.f2417
            int r4 = r4 + 33
            int r2 = r4 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2415 = r2
            int r4 = r4 % 2
            if (r4 != 0) goto L35
            r4 = 4
            int r4 = r4 / r0
            if (r6 == 0) goto L46
            goto L37
        L35:
            if (r6 == 0) goto L46
        L37:
            java.util.ArrayList r1 = new java.util.ArrayList
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r0] = r3
            java.util.List r3 = java.util.Arrays.asList(r4)
            r1.<init>(r3)
            goto L6c
        L46:
            boolean r4 = r3 instanceof java.util.Map
            if (r4 == 0) goto L6c
            int r4 = com.ironsource.adqualitysdk.sdk.i.hy.f2417
            int r4 = r4 + 81
            int r6 = r4 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2415 = r6
            int r4 = r4 % 2
            if (r4 == 0) goto L6b
            if (r5 == 0) goto L6c
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.Map r3 = (java.util.Map) r3
            java.util.Collection r4 = r3.values()
            r1.<init>(r4)
            java.util.Set r3 = r3.keySet()
            r1.addAll(r3)
            goto L6c
        L6b:
            throw r1
        L6c:
            int r3 = com.ironsource.adqualitysdk.sdk.i.hy.f2415
            int r3 = r3 + 55
            int r4 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2417 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L7b
            r3 = 57
            int r3 = r3 / r0
        L7b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hy.m2416(java.lang.Object, boolean, boolean, boolean):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00be A[SYNTHETIC] */
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> com.ironsource.adqualitysdk.sdk.i.hs<T> m2417(java.lang.Object r10, com.ironsource.adqualitysdk.sdk.i.hw<T> r11, int r12, com.ironsource.adqualitysdk.sdk.i.hs r13) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hy.m2417(java.lang.Object, com.ironsource.adqualitysdk.sdk.i.hw, int, com.ironsource.adqualitysdk.sdk.i.hs):com.ironsource.adqualitysdk.sdk.i.hs");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final List<hs> m2440(Object obj, hz hzVar) {
        hw hwVar = new hw(hzVar);
        hwVar.m2401();
        m2417(obj, hwVar, 0, null);
        ArrayList arrayList = new ArrayList(hwVar.m2395());
        f2415 = (f2417 + 13) % 128;
        return arrayList;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private <T> hs<T> m2419(Object obj, hv hvVar) {
        List<Field> list;
        int i2 = f2417 + 51;
        f2415 = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                list = hvVar.m2390().get(0);
            } else {
                list = hvVar.m2390().get(0);
            }
            return m2418(m2430(obj, list, (hs) null), hvVar, 1);
        } catch (Exception e) {
            k.m2861(m2414(253 - TextUtils.indexOf((CharSequence) "", '0', 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 12, "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 9 - (ViewConfiguration.getTapTimeout() >> 16), false).intern(), m2421("䟪\ufdd9\ue55d옦蓝銹\uf1f6↝ς᠐䁏\u31ee݄\uabfc\u2fe1䥔ㆀ췗䗹䃘聘ⴈ降\uf3cc롚\ue148\ueead齿\u0380畜꼡Ⓨ\ue22a᪐࣐ꖩ", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34).intern(), (Throwable) e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static <T> hs<T> m2430(Object obj, List<Field> list, hs hsVar) throws IllegalAccessException {
        Object obj2;
        int i2 = f2417 + 101;
        f2415 = i2 % 128;
        if (i2 % 2 != 0) {
            for (Field field : list) {
                if (WeakReference.class.isAssignableFrom(field.getType())) {
                    f2417 = (f2415 + 3) % 128;
                    obj2 = ((WeakReference) field.get(obj)).get();
                } else {
                    obj2 = field.get(obj);
                }
                hsVar = m2426(field, obj, hsVar);
                obj = obj2;
            }
            return hsVar;
        }
        list.iterator();
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2414(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f2419);
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if (r4 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
    
        r8 = m2414(android.widget.ExpandableListView.getPackedPositionChild(0) + 255, 11 - android.view.MotionEvent.axisFromString(""), "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 9 - android.view.View.MeasureSpec.getMode(0), false).intern();
        r9 = new java.lang.StringBuilder();
        r9.append(m2421("䫈\ue1d4嶠⏠䗹䃘傭뷦韕亵⇙웰䜴蕃䗹䃘濟≞δ䑙鹌配彽쵐ᣊ盭\uef1dꜣ뮸ꗀ鋬룟烊ῷ傭뷦됖\udd97", 37 - android.graphics.drawable.Drawable.resolveOpacity(0, 0)).intern());
        r9.append(r3.getClass());
        com.ironsource.adqualitysdk.sdk.i.k.m2863(r8, r9.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x008a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x008b, code lost:
    
        r4 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0093, code lost:
    
        if (r4.hasNext() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0095, code lost:
    
        r5 = r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0099, code lost:
    
        r5 = m2430(r5, r0, m2425(r3, r5, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a1, code lost:
    
        if (r5 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a3, code lost:
    
        r8 = m2418(r5, r9, r10 + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a9, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.hy.f2417 = (com.ironsource.adqualitysdk.sdk.i.hy.f2415 + 19) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b1, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b2, code lost:
    
        com.ironsource.adqualitysdk.sdk.i.hy.f2417 = (com.ironsource.adqualitysdk.sdk.i.hy.f2415 + 109) % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bb, code lost:
    
        r8 = com.ironsource.adqualitysdk.sdk.i.hy.f2415 + com.vungle.ads.internal.protos.Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        com.ironsource.adqualitysdk.sdk.i.hy.f2417 = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c5, code lost:
    
        if ((r8 % 2) == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c7, code lost:
    
        r8 = 29 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ca, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        if (r4 == null) goto L11;
     */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> com.ironsource.adqualitysdk.sdk.i.hs<T> m2418(com.ironsource.adqualitysdk.sdk.i.hs r8, com.ironsource.adqualitysdk.sdk.i.hv r9, int r10) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hy.m2418(com.ironsource.adqualitysdk.sdk.i.hs, com.ironsource.adqualitysdk.sdk.i.hv, int):com.ironsource.adqualitysdk.sdk.i.hs");
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private hs m2429(hs hsVar, hw hwVar, int i2) {
        Iterator it;
        f2415 = (f2417 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        Object objMo2359 = hsVar.mo2359();
        hs hsVarM2429 = null;
        if (!hwVar.m2398().contains(objMo2359) && !hwVar.m2396().contains(objMo2359)) {
            if (hwVar.m2402().m2450(i2) && m2423(hwVar.m2402().m2449(), hsVar)) {
                if (hwVar.m2400()) {
                    hwVar.m2403(hsVar);
                    hwVar.m2399(objMo2359);
                }
                return hsVar;
            }
            if (objMo2359 instanceof WeakReference) {
                int i8 = f2415 + 3;
                f2417 = i8 % 128;
                if (i8 % 2 == 0) {
                    if (((WeakReference) objMo2359).get() != null && hwVar.m2402().m2456(i2)) {
                        WeakReference weakReference = (WeakReference) objMo2359;
                        if (m2432(weakReference.get(), hwVar.m2402().m2455())) {
                            return m2417(weakReference.get(), hwVar, i2 + 1, hsVar);
                        }
                    }
                } else {
                    ((WeakReference) objMo2359).get();
                    throw null;
                }
            }
            if (m2432(objMo2359, hwVar.m2402().m2455())) {
                int i9 = f2417 + 45;
                f2415 = i9 % 128;
                return i9 % 2 == 0 ? m2417(objMo2359, hwVar, i2 / 0, hsVar) : m2417(objMo2359, hwVar, i2 + 1, hsVar);
            }
            if (hwVar.m2402().m2447() && objMo2359 != null) {
                hwVar.m2398().add(objMo2359);
            }
            List listM2415 = m2415(objMo2359, hwVar.m2402(), i2);
            hv hvVarM2397 = hwVar.m2397();
            if (listM2415 != null) {
                int i10 = f2415 + 115;
                f2417 = i10 % 128;
                if (i10 % 2 != 0) {
                    it = listM2415.iterator();
                    int i11 = 52 / 0;
                } else {
                    it = listM2415.iterator();
                }
                while (it.hasNext()) {
                    hs hsVarM2425 = m2425(objMo2359, it.next(), hsVar);
                    hvVarM2397.m2394();
                    hsVarM2429 = m2429(hsVarM2425, hwVar, i2);
                    if (hsVarM2429 != null) {
                        int i12 = f2415 + 79;
                        f2417 = i12 % 128;
                        if (i12 % 2 != 0) {
                            int i13 = 87 / 0;
                            if (!hwVar.m2400()) {
                                return hsVarM2429;
                            }
                        } else if (!hwVar.m2400()) {
                            return hsVarM2429;
                        }
                    }
                    hvVarM2397.m2392();
                }
            }
        }
        return hsVarM2429;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final List<String> m2437(Object obj, List<String> list, int i2) {
        hw hwVar = new hw(new hz.a().m2461(true).m2463(true).m2471(true).m2460(-1).m2472(new ia() { // from class: com.ironsource.adqualitysdk.sdk.i.hy.2
            @Override // com.ironsource.adqualitysdk.sdk.i.ia
            /* JADX INFO: renamed from: ﾇ */
            public final boolean mo1908(hs hsVar) {
                return hsVar.mo2359() instanceof String;
            }
        }, list, i2));
        hwVar.m2401();
        m2417(obj, hwVar, 0, null);
        ArrayList arrayList = new ArrayList(hwVar.m2396());
        int i8 = f2417 + 5;
        f2415 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 93 / 0;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean m2423(ia iaVar, hs hsVar) {
        int i2 = f2417 + 85;
        f2415 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                boolean zMo1908 = iaVar.mo1908(hsVar);
                int i8 = f2415 + 1;
                f2417 = i8 % 128;
                if (i8 % 2 != 0) {
                    int i9 = 20 / 0;
                }
                return zMo1908;
            }
            iaVar.mo1908(hsVar);
            throw null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0069 A[SYNTHETIC] */
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m2420(java.lang.Object r8, java.lang.Class r9, java.lang.String r10) {
        /*
            r7 = this;
        L0:
            if (r9 == 0) goto L72
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            boolean r0 = r9.equals(r0)
            if (r0 != 0) goto L72
            java.lang.reflect.Field[] r0 = m2424(r9)
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L11:
            if (r3 >= r1) goto L6d
            int r4 = com.ironsource.adqualitysdk.sdk.i.hy.f2417
            int r4 = r4 + 31
            int r4 = r4 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2415 = r4
            r4 = r0[r3]
            r5 = 1
            r4.setAccessible(r5)
            java.lang.Object r4 = r4.get(r8)     // Catch: java.lang.Exception -> L6a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L6a
            if (r4 == 0) goto L6a
            int r5 = com.ironsource.adqualitysdk.sdk.i.hy.f2415
            int r5 = r5 + 105
            int r6 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2417 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L49
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r10)     // Catch: java.lang.Exception -> L6a
            java.util.regex.Matcher r5 = r5.matcher(r4)     // Catch: java.lang.Exception -> L6a
            boolean r5 = r5.matches()     // Catch: java.lang.Exception -> L6a
            r6 = 13
            int r6 = r6 / r2
            if (r5 == 0) goto L6a
            goto L57
        L47:
            r8 = move-exception
            throw r8
        L49:
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r10)     // Catch: java.lang.Exception -> L6a
            java.util.regex.Matcher r5 = r5.matcher(r4)     // Catch: java.lang.Exception -> L6a
            boolean r5 = r5.matches()     // Catch: java.lang.Exception -> L6a
            if (r5 == 0) goto L6a
        L57:
            int r5 = com.ironsource.adqualitysdk.sdk.i.hy.f2415
            int r5 = r5 + 121
            int r6 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2417 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L69
            r5 = 33
            int r5 = r5 / r2
            goto L69
        L67:
            r8 = move-exception
            throw r8
        L69:
            return r4
        L6a:
            int r3 = r3 + 1
            goto L11
        L6d:
            java.lang.Class r9 = r9.getSuperclass()
            goto L0
        L72:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hy.m2420(java.lang.Object, java.lang.Class, java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static List m2427(Object obj) {
        int i2 = f2417 + 61;
        f2415 = i2 % 128;
        return i2 % 2 == 0 ? m2416(obj, false, true, true) : m2416(obj, true, true, true);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static <T> hs<T> m2426(Field field, Object obj, hs hsVar) {
        hx hxVar = new hx(field, obj, hsVar);
        int i2 = f2415 + 105;
        f2417 = i2 % 128;
        if (i2 % 2 == 0) {
            return hxVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static <T> hs<T> m2425(Object obj, Object obj2, hs hsVar) {
        if (obj == null) {
            return null;
        }
        f2415 = (f2417 + 75) % 128;
        if (obj instanceof Collection) {
            return new hx((Collection) obj, obj2, hsVar);
        }
        if (obj instanceof Map) {
            hx hxVar = new hx((Map) obj, obj2, hsVar);
            int i2 = f2415 + 55;
            f2417 = i2 % 128;
            if (i2 % 2 == 0) {
                return hxVar;
            }
            throw null;
        }
        if (obj.getClass().isArray()) {
            return new hx(new ArrayList(Arrays.asList(obj)), obj2, hsVar);
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2435(Object obj, String str) {
        f2417 = (f2415 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        String strM2420 = m2420(obj, obj.getClass(), str);
        f2415 = (f2417 + 33) % 128;
        return strM2420;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m2436(Object obj, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                f2417 = (f2415 + 63) % 128;
                String strM2435 = m2435(obj, jSONArray.optString(i2));
                if (strM2435 != null) {
                    f2417 = (f2415 + 107) % 128;
                    return strM2435;
                }
            }
        }
        f2415 = (f2417 + 27) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final String m2439(Class cls, String str) {
        f2415 = (f2417 + 101) % 128;
        String strM2420 = m2420((Object) null, cls, str);
        f2415 = (f2417 + 21) % 128;
        return strM2420;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m2428(hs hsVar, Object obj, String str) {
        f2415 = (f2417 + 7) % 128;
        if (hsVar != null) {
            String strIntern = m2414(Color.rgb(0, 0, 0) + 16777470, 12 - TextUtils.indexOf("", "", 0, 0), "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 9 - View.combineMeasuredStates(0, 0), false).intern();
            StringBuilder sb = new StringBuilder();
            sb.append(obj);
            sb.append(m2414(201 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), ((Process.getThreadPriority(0) + 20) >> 6) + 2, "\r\ufff3", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), true).intern());
            sb.append(str);
            sb.append(m2421("\uef1dꜣ\udc60☧秐뗾뒤Ĩ", Drawable.resolveOpacity(0, 0) + 8).intern());
            sb.append(hsVar.mo2359());
            k.m2852(strIntern, sb.toString());
            return;
        }
        String strIntern2 = m2414(View.combineMeasuredStates(0, 0) + 254, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 11, "\u0002\u0000\u0011￣\u0006\u000b\u0001\u0002\u000f￬\uffff\u0007", 10 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), false).intern();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(m2414(200 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 2, "\r\ufff3", 1 - (ViewConfiguration.getTapTimeout() >> 16), true).intern());
        sb2.append(str);
        k.m2852(strIntern2, sb2.toString());
        f2417 = (f2415 + 91) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean m2432(Object obj, List<String> list) {
        if (obj != null) {
            int i2 = f2415 + 115;
            f2417 = i2 % 128;
            if (i2 % 2 == 0) {
                return jz.m2848(obj.getClass(), list);
            }
            boolean zM2848 = jz.m2848(obj.getClass(), list);
            int i8 = 60 / 0;
            return zM2848;
        }
        int i9 = f2415 + 91;
        f2417 = i9 % 128;
        if (i9 % 2 != 0) {
            int i10 = 41 / 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static Field[] m2424(Class cls) {
        ArrayList arrayList = new ArrayList();
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType().equals(String.class)) {
                f2417 = (f2415 + 13) % 128;
                arrayList.add(field);
            }
        }
        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
        int i2 = f2415 + 71;
        f2417 = i2 % 128;
        if (i2 % 2 == 0) {
            return fieldArr;
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[PHI: r5
  0x0036: PHI (r5v9 java.lang.Class) = (r5v7 java.lang.Class), (r5v10 java.lang.Class) binds: [B:12:0x0034, B:9:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.reflect.Field[] m2433(java.lang.Class r5, int r6) {
        /*
            int r0 = com.ironsource.adqualitysdk.sdk.i.hy.f2417
            int r0 = r0 + 55
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2415 = r1
            int r0 = r0 % 2
            java.lang.reflect.Field[] r0 = r5.getDeclaredFields()
            r1 = 0
            r2 = r1
        L10:
            if (r5 == 0) goto L41
            int r3 = com.ironsource.adqualitysdk.sdk.i.hy.f2417
            int r3 = r3 + 47
            int r3 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2415 = r3
            if (r2 == r6) goto L41
            int r3 = r3 + 15
            int r4 = r3 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2417 = r4
            int r3 = r3 % 2
            if (r3 == 0) goto L30
            java.lang.Class r5 = r5.getSuperclass()
            r3 = 26
            int r3 = r3 / r1
            if (r5 == 0) goto L3e
            goto L36
        L30:
            java.lang.Class r5 = r5.getSuperclass()
            if (r5 == 0) goto L3e
        L36:
            java.lang.reflect.Field[] r3 = r5.getDeclaredFields()
            java.lang.reflect.Field[] r0 = com.ironsource.adqualitysdk.sdk.i.jz.m2849(r0, r3)
        L3e:
            int r2 = r2 + 1
            goto L10
        L41:
            int r5 = com.ironsource.adqualitysdk.sdk.i.hy.f2415
            int r5 = r5 + 77
            int r6 = r5 % 128
            com.ironsource.adqualitysdk.sdk.i.hy.f2417 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L50
            r5 = 38
            int r5 = r5 / r1
        L50:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.hy.m2433(java.lang.Class, int):java.lang.reflect.Field[]");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2421(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2420)) ^ ((c8 >>> 5) + f2416)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2421) ^ ((c9 + i9) ^ ((c9 << 4) + f2418))));
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
