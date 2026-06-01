package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class bg extends da implements ci {

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f792 = 0;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static int f794 = 1;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static short[] f795 = null;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f796 = 76;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f797 = 1970268237;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f800 = -921766532;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f801;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f802;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private Map<String, a> f803;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f804;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static byte[] f799 = {-59, -1, 6, -10, 1, 13, 15, -21, 7, 17, -25, 0, -9, 47, -46, 15, -14, -68, 0, 18, -11, 41, -49, 15, -2, -69, -1, -7, 10, 1, -13, 9, -75, -73, 6, 5, -71, 19, -14, 3, 6, -72, -15, -5, 23, -71, 2, 3, 7, -11, -70, -83, 0, 18, -11, 41};

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static char f793 = 43431;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static char f790 = 56180;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static char f791 = 62784;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f798 = 20631;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface a {
        /* JADX INFO: renamed from: ﻐ */
        Object mo828(List<Object> list, ch chVar);
    }

    public bg(String str) {
        this.f804 = str;
    }

    /* JADX INFO: renamed from: Ꮭ, reason: contains not printable characters */
    public static /* synthetic */ Object m874(List list, Class cls) {
        int i2 = f794 + 73;
        f792 = i2 % 128;
        return da.m1896((List<Object>) list, i2 % 2 != 0 ? 1 : 0, cls);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m876(bg bgVar) {
        int i2 = (f794 + 11) % 128;
        f792 = i2;
        String str = bgVar.f802;
        f794 = (i2 + 71) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Class m877(bg bgVar, String str) {
        int i2 = f792 + 29;
        f794 = i2 % 128;
        int i8 = i2 % 2;
        Class clsM875 = bgVar.m875(str, false);
        f792 = (f794 + 81) % 128;
        return clsM875;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final boolean m880() {
        int i2 = (f792 + 81) % 128;
        f794 = i2;
        if (this.f802 != null) {
            return true;
        }
        f792 = (i2 + 21) % 128;
        return false;
    }

    /* JADX INFO: renamed from: ﱡ */
    public boolean mo870() {
        int i2 = f792;
        int i8 = i2 + 103;
        f794 = i8 % 128;
        boolean z2 = i8 % 2 == 0;
        f794 = (i2 + 19) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﻏ */
    public boolean mo872() {
        int i2 = (f794 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        f792 = i2;
        int i8 = i2 + 21;
        f794 = i8 % 128;
        if (i8 % 2 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ */
    public abstract String mo825();

    /* JADX INFO: renamed from: ﻛ */
    public abstract Class mo826(String str);

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final synchronized String m883() {
        try {
            if (TextUtils.isEmpty(this.f801)) {
                this.f801 = mo825();
                f792 = (f794 + 35) % 128;
            } else {
                f792 = (f794 + 67) % 128;
                if (this.f801.equals(m878(TextUtils.getTrimmedLength("") - 77, (short) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), 921766558 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (byte) Color.blue(0), View.MeasureSpec.getMode(0) - 1970268168).intern())) {
                    this.f801 = mo825();
                    f792 = (f794 + 35) % 128;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f801;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (com.ironsource.adqualitysdk.sdk.i.Prode.m249() == false) goto L9;
     */
    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class m884(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.bg.f794
            int r0 = r0 + 35
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.bg.f792 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L17
            boolean r0 = com.ironsource.adqualitysdk.sdk.i.Prode.m249()     // Catch: java.lang.Throwable -> L2f
            r2 = 72
            int r2 = r2 / r1
            if (r0 != 0) goto L22
            goto L1d
        L17:
            boolean r0 = com.ironsource.adqualitysdk.sdk.i.Prode.m249()     // Catch: java.lang.Throwable -> L2f
            if (r0 != 0) goto L22
        L1d:
            java.lang.Class r4 = r3.m875(r4, r1)     // Catch: java.lang.Throwable -> L2f
            return r4
        L22:
            java.lang.Class r4 = r3.mo826(r4)     // Catch: java.lang.Throwable -> L2f
            int r0 = com.ironsource.adqualitysdk.sdk.i.bg.f792
            int r0 = r0 + 23
            int r0 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.bg.f794 = r0
            return r4
        L2f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.bg.m884(java.lang.String):java.lang.Class");
    }

    /* JADX INFO: renamed from: ﾇ */
    public abstract Map<String, a> mo827();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m887() {
        Map<String, a> mapMo827 = mo827();
        this.f803 = mapMo827;
        mapMo827.put(m878(TextUtils.indexOf("", "", 0, 0) - 77, (short) Gravity.getAbsoluteGravity(0, 0), 921766531 - TextUtils.indexOf((CharSequence) "", '0'), (byte) (ViewConfiguration.getFadingEdgeLength() >> 16), (-1970268121) - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), new a() { // from class: com.ironsource.adqualitysdk.sdk.i.bg.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bg.this.m888((String) bg.m874(list, String.class));
                return bg.m876(bg.this);
            }
        });
        this.f803.put(m879("㡤欌륆젣鋮\u202cậ鱬窲郹ꚸ츁诰嚛㼷ᰑབﰄ\uecf9칤", 19 - Gravity.getAbsoluteGravity(0, 0)).intern(), new a() { // from class: com.ironsource.adqualitysdk.sdk.i.bg.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(bg.this.m880());
            }
        });
        this.f803.put(m878(TextUtils.getTrimmedLength("") - 77, (short) (ViewConfiguration.getWindowTouchSlop() >> 8), 921766549 - TextUtils.getOffsetAfter("", 0), (byte) View.MeasureSpec.makeMeasureSpec(0, 0), (-1970268134) - (ViewConfiguration.getMaximumFlingVelocity() >> 16)).intern(), new a() { // from class: com.ironsource.adqualitysdk.sdk.i.bg.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bg.m877(bg.this, (String) list.get(0));
            }
        });
        f794 = (f792 + 17) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Class m875(String str, boolean z2) {
        try {
            if (str.contains(m878(MotionEvent.axisFromString("") - 76, (short) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 921766563 - ExpandableListView.getPackedPositionChild(0L), (byte) (Process.myPid() >> 22), KeyEvent.getDeadChar(0, 0) - 1970268191).intern())) {
                f794 = (f792 + 89) % 128;
                return jz.m2840(str, z2);
            }
            switch (str.hashCode()) {
                case -1325958191:
                    if (str.equals(m879("쥙뭬ۄἄ췣蛜", 6 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern())) {
                        f792 = (f794 + 5) % 128;
                        return Double.TYPE;
                    }
                    return mo826(str);
                case 104431:
                    if (str.equals(m878(View.MeasureSpec.getMode(0) - 77, (short) View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 921766565, (byte) KeyEvent.getDeadChar(0, 0), TextUtils.indexOf("", "", 0, 0) - 1970268132).intern())) {
                        f792 = (f794 + 93) % 128;
                        return Integer.TYPE;
                    }
                    return mo826(str);
                case 3029738:
                    if (str.equals(m879("ꄫᖉ谟\ue0f0", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 3).intern())) {
                        int i2 = f792 + 23;
                        f794 = i2 % 128;
                        if (i2 % 2 != 0) {
                            return Boolean.TYPE;
                        }
                        return Float.TYPE;
                    }
                    return mo826(str);
                case 3039496:
                    if (str.equals(m878((ViewConfiguration.getScrollBarFadeDuration() >> 16) - 77, (short) (Color.rgb(0, 0, 0) + 16777216), 921766573 - (KeyEvent.getMaxKeyCode() >> 16), (byte) Color.argb(0, 0, 0, 0), (-1970268139) - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern())) {
                        return Byte.TYPE;
                    }
                    return mo826(str);
                case 3052374:
                    if (str.equals(m879("닏캱ゅ霣", 4 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)).intern())) {
                        return Character.TYPE;
                    }
                    return mo826(str);
                case 3327612:
                    if (str.equals(m879("\ud9f0븏䙬碌", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 4).intern())) {
                        return Long.TYPE;
                    }
                    return mo826(str);
                case 3625364:
                    if (str.equals(m879("ᯉ婼Ⱡങ", 5 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern())) {
                        int i8 = f794 + 59;
                        f792 = i8 % 128;
                        if (i8 % 2 == 0) {
                            return Void.TYPE;
                        }
                    }
                    return mo826(str);
                case 97526364:
                    if (str.equals(m878((-76) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (short) Color.alpha(0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 921766568, (byte) (Process.myTid() >> 22), View.getDefaultSize(0, 0) - 1970268135).intern())) {
                        return Float.TYPE;
                    }
                    return mo826(str);
                case 109413500:
                    if (str.equals(m878(TextUtils.getOffsetAfter("", 0) - 77, (short) ((Process.getThreadPriority(0) + 20) >> 6), (ViewConfiguration.getWindowTouchSlop() >> 8) + 921766577, (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), Color.green(0) - 1970268122).intern())) {
                        Class cls = Short.TYPE;
                        f794 = (f792 + 71) % 128;
                        return cls;
                    }
                    return mo826(str);
                default:
                    return mo826(str);
            }
        } catch (Throwable th) {
            if (!z2) {
                return null;
            }
            String str2 = this.f804;
            StringBuilder sb = new StringBuilder();
            sb.append(m878((-78) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (short) TextUtils.indexOf("", "", 0, 0), 921766582 - View.resolveSizeAndState(0, 0, 0), (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), (ViewConfiguration.getScrollBarSize() >> 8) - 1970268170).intern());
            sb.append(str);
            sb.append(m879("ࣽ蹒⡢裃뭧꾷ⅇ딫˨퍏", (ViewConfiguration.getLongPressTimeout() >> 16) + 10).intern());
            co.m1671(str2, sb.toString(), th);
            return null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public String mo881() {
        int i2 = (f792 + 91) % 128;
        f794 = i2;
        String str = this.f802;
        if (str == null) {
            return m883();
        }
        int i8 = i2 + 1;
        f792 = i8 % 128;
        if (i8 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m888(String str) {
        int i2 = (f794 + 41) % 128;
        f792 = i2;
        this.f802 = str;
        int i8 = i2 + 63;
        f794 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 41 / 0;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final Class m882(String str) {
        f794 = (f792 + 67) % 128;
        Class clsM875 = m875(str, true);
        f792 = (f794 + 61) % 128;
        return clsM875;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m885(hc hcVar, ch chVar, String str, Object... objArr) {
        try {
            ArrayList arrayList = new ArrayList(Arrays.asList(objArr));
            arrayList.add(0, hcVar);
            chVar.mo1591(str, arrayList);
            f794 = (f792 + 111) % 128;
        } catch (Throwable th) {
            String str2 = this.f804;
            StringBuilder sb = new StringBuilder();
            sb.append(m879("\uf788滴\ue83e藱녜ꅰ嶀⊳팸ꓹ", (ViewConfiguration.getEdgeSlop() >> 16) + 9).intern());
            sb.append(this);
            co.m1671(str2, sb.toString(), th);
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final Object mo886(String str, List<Object> list, ch chVar) {
        f794 = (f792 + 109) % 128;
        a aVar = this.f803.get(str);
        try {
        } catch (Exception e) {
            String str2 = this.f804;
            StringBuilder sb = new StringBuilder();
            sb.append(m879("\uf788滴\ue83e藱녜ꅰﺣ\uaad0셦⚨㡓鏉嶀⊳䠍ᄀꍔ겈έ봡孩࿃럞ޣ뭆忈䬿ȱ䃎Ɡ☑䍊", 31 - Drawable.resolveOpacity(0, 0)).intern());
            sb.append(str);
            sb.append(m879("☑䍊", 1 - TextUtils.getTrimmedLength("")).intern());
            co.m1671(str2, sb.toString(), e);
        }
        if (aVar != null) {
            f794 = (f792 + 95) % 128;
            return aVar.mo828(list, chVar);
        }
        String str3 = this.f804;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m879("\uf788滴\ue83e藱녜ꅰﺣ\uaad0셦⚨㡓鏉嶀⊳䠍ᄀꍔ겈έ봡孩࿃럞ޣ뭆忈䬿ȱ䃎Ɡ☑䍊", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 31).intern());
        sb2.append(str);
        sb2.append(m879("跬ូ럞ޣ뭆忈䬿ȱ䃎Ɡ\ue96f∑☾뵧햩\ua958唍㏧뙢⇍ᰁ䣑ஂ\u3102", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 22).intern());
        co.m1671(str3, sb2.toString(), null);
        return null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m878(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f796;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f799;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f800 + i8] + i10);
                    } else {
                        i11 = (short) (f795[f800 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f800 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f797);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f799;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f795;
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m879(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f793)) ^ ((c8 >>> 5) + f791)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f790) ^ ((c9 + i9) ^ ((c9 << 4) + f798))));
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
