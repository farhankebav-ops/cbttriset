package com.ironsource.adqualitysdk.sdk.i;

import android.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ironsource.adqualitysdk.sdk.i.hl;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jh {

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static int f2791 = 1;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static short[] f2792 = null;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2793 = 61;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static byte[] f2794 = {2, -6, -13, 4, 13, 18, -31, 13, -9, 9, -15, 1, 10, 29, -28, 5, -18, 6, 27, -24, 11, -1, -13, 3, 37, -30, 22, -17, 82, -82, 3, 79, -56, -31, 22, -17, 82, -72, 5, -18, 6, -5, 84, -71, -7, 5, -11, 0, 15, -2, 71, -82, 3, -3, 0, 45, -4, 18, -4, 19, -30, -4, 19, 17, 52, -89, 13, -2, -1, 79, -83, 5, 5, 8, -19, 6, -1, 12, 67, -80, -5, 6, -3, 43, -48, 18, -4, 19, 54, -70, -3, 73, -71, -7, 5, -2, 8, -2, -3, 5, 67, -82, 3, -3, 0, 45, 0, 0, 0};

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f2795 = -191818690;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f2796 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static jh f2797 = null;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2798 = -1634707089;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private jl f2800;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Map<RelativeLayout, Object> f2799 = new WeakHashMap();

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private ik f2801 = new ik(-1, -1, -1, -1);

    private jh() {
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m2700(jh jhVar, ViewGroup viewGroup, View.OnLayoutChangeListener onLayoutChangeListener) {
        int i2 = f2791 + 7;
        f2796 = i2 % 128;
        int i8 = i2 % 2;
        jhVar.m2712(viewGroup, onLayoutChangeListener);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m2701(jh jhVar, MotionEvent motionEvent) {
        f2791 = (f2796 + 53) % 128;
        jhVar.m2698(motionEvent);
        int i2 = f2796 + 87;
        f2791 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ View.OnLayoutChangeListener m2704(jh jhVar, ViewGroup viewGroup) {
        f2791 = (f2796 + 111) % 128;
        View.OnLayoutChangeListener onLayoutChangeListenerM2703 = jhVar.m2703(viewGroup);
        f2791 = (f2796 + 17) % 128;
        return onLayoutChangeListenerM2703;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m2708(View view, hl.c cVar) {
        f2796 = (f2791 + 13) % 128;
        m2706(view, cVar);
        int i2 = f2796 + 57;
        f2791 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 39 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ ViewGroup m2710(ViewGroup viewGroup, ViewGroup viewGroup2) {
        f2791 = (f2796 + 23) % 128;
        ViewGroup viewGroupM2705 = m2705(viewGroup, viewGroup2);
        int i2 = f2791 + 47;
        f2796 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 68 / 0;
        }
        return viewGroupM2705;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean m2702(ViewGroup viewGroup) {
        f2796 = (f2791 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        try {
            if (viewGroup.getChildCount() == 0) {
                return false;
            }
            f2796 = (f2791 + 93) % 128;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                if (!(viewGroup.getChildAt(i2) instanceof TextView)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            k.m2861(m2697((-35) - TextUtils.getOffsetAfter("", 0), (short) Drawable.resolveOpacity(0, 0), 1634707089 - (Process.myTid() >> 22), (byte) Color.red(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 191818761).intern(), m2697((-10) - Gravity.getAbsoluteGravity(0, 0), (short) (ViewConfiguration.getJumpTapTimeout() >> 16), (Process.myPid() >> 22) + 1634707145, (byte) TextUtils.getTrimmedLength(""), ((Process.getThreadPriority(0) + 20) >> 6) + 191818759).intern(), th);
            return false;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m2713(jh jhVar, ViewGroup viewGroup, View.OnLayoutChangeListener onLayoutChangeListener) {
        f2791 = (f2796 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        jhVar.m2707(viewGroup, onLayoutChangeListener);
        f2796 = (f2791 + 79) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized void m2715() {
        try {
            f2791 = (f2796 + 19) % 128;
            if (this.f2800 == null) {
                this.f2800 = new jl() { // from class: com.ironsource.adqualitysdk.sdk.i.jh.3
                    @Override // com.ironsource.adqualitysdk.sdk.i.jl
                    /* JADX INFO: renamed from: ﾇ */
                    public final void mo264(View view) {
                        if (q.m3013().m3031()) {
                            jh.this.m2717();
                            return;
                        }
                        if (view instanceof ViewGroup) {
                            ViewGroup viewGroupM2710 = (ViewGroup) view;
                            if (viewGroupM2710.getContext() instanceof Activity) {
                                viewGroupM2710 = jh.m2710(viewGroupM2710, (ViewGroup) ((Activity) viewGroupM2710.getContext()).findViewById(R.id.content));
                            }
                            jh jhVar = jh.this;
                            jh.m2713(jhVar, viewGroupM2710, jh.m2704(jhVar, viewGroupM2710));
                        }
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.jl
                    /* JADX INFO: renamed from: ﻛ */
                    public final void mo259(View view) {
                    }
                };
                ji.m2724().m2727(this.f2800);
                f2796 = (f2791 + 41) % 128;
            }
            int i2 = f2796 + 73;
            f2791 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final synchronized ik m2716() {
        ik ikVar;
        int i2 = f2796;
        ikVar = this.f2801;
        f2791 = (i2 + 103) % 128;
        return ikVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final synchronized void m2717() {
        try {
            f2796 = (f2791 + 69) % 128;
            if (this.f2800 != null) {
                for (RelativeLayout relativeLayout : this.f2799.keySet()) {
                    f2796 = (f2791 + 9) % 128;
                    ViewParent parent = relativeLayout.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(relativeLayout);
                    }
                }
                this.f2799.clear();
                ji.m2724().m2728(this.f2800);
                this.f2800 = null;
            }
            f2791 = (f2796 + 29) % 128;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static ViewGroup m2705(ViewGroup viewGroup, ViewGroup viewGroup2) {
        int i2 = f2796;
        int i8 = i2 + 19;
        int i9 = i8 % 128;
        f2791 = i9;
        if (i8 % 2 == 0) {
            throw null;
        }
        if (viewGroup2 == null) {
            f2791 = (i2 + 35) % 128;
            return viewGroup;
        }
        f2796 = (i9 + 77) % 128;
        ViewGroup viewGroup3 = viewGroup2;
        while (viewGroup2 != null) {
            ViewParent parent = viewGroup2.getParent();
            if (parent != viewGroup) {
                if (!(parent instanceof ViewGroup)) {
                    break;
                }
                viewGroup3 = viewGroup2;
                viewGroup2 = (ViewGroup) parent;
            } else {
                if (viewGroup3 != viewGroup2) {
                    return viewGroup3;
                }
                f2791 = (f2796 + 61) % 128;
                return viewGroup2;
            }
        }
        return viewGroup2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m2714(jh jhVar, ik ikVar) {
        f2791 = (f2796 + 101) % 128;
        jhVar.m2709(ikVar);
        int i2 = f2791 + 97;
        f2796 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0020 A[Catch: all -> 0x001a, TryCatch #1 {all -> 0x001a, blocks: (B:4:0x0003, B:6:0x000f, B:18:0x0027, B:25:0x003c, B:17:0x0020, B:12:0x0019, B:15:0x001c, B:8:0x0013, B:21:0x0037), top: B:32:0x0003, inners: #0, #2 }] */
    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.ironsource.adqualitysdk.sdk.i.jh m2711() {
        /*
            java.lang.Class<com.ironsource.adqualitysdk.sdk.i.jh> r0 = com.ironsource.adqualitysdk.sdk.i.jh.class
            monitor-enter(r0)
            int r1 = com.ironsource.adqualitysdk.sdk.i.jh.f2791     // Catch: java.lang.Throwable -> L1a
            int r1 = r1 + 89
            int r2 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.jh.f2796 = r2     // Catch: java.lang.Throwable -> L1a
            int r1 = r1 % 2
            if (r1 == 0) goto L1c
            com.ironsource.adqualitysdk.sdk.i.jh r1 = com.ironsource.adqualitysdk.sdk.i.jh.f2797     // Catch: java.lang.Throwable -> L1a
            r2 = 77
            int r2 = r2 / 0
            if (r1 != 0) goto L27
            goto L20
        L18:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L1a
        L1a:
            r1 = move-exception
            goto L3f
        L1c:
            com.ironsource.adqualitysdk.sdk.i.jh r1 = com.ironsource.adqualitysdk.sdk.i.jh.f2797     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L27
        L20:
            com.ironsource.adqualitysdk.sdk.i.jh r1 = new com.ironsource.adqualitysdk.sdk.i.jh     // Catch: java.lang.Throwable -> L1a
            r1.<init>()     // Catch: java.lang.Throwable -> L1a
            com.ironsource.adqualitysdk.sdk.i.jh.f2797 = r1     // Catch: java.lang.Throwable -> L1a
        L27:
            com.ironsource.adqualitysdk.sdk.i.jh r1 = com.ironsource.adqualitysdk.sdk.i.jh.f2797     // Catch: java.lang.Throwable -> L1a
            int r2 = com.ironsource.adqualitysdk.sdk.i.jh.f2791     // Catch: java.lang.Throwable -> L1a
            int r2 = r2 + 75
            int r3 = r2 % 128
            com.ironsource.adqualitysdk.sdk.i.jh.f2796 = r3     // Catch: java.lang.Throwable -> L1a
            int r2 = r2 % 2
            if (r2 == 0) goto L3d
            r2 = 59
            int r2 = r2 / 0
            monitor-exit(r0)
            return r1
        L3b:
            r1 = move-exception
            throw r1     // Catch: java.lang.Throwable -> L1a
        L3d:
            monitor-exit(r0)
            return r1
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.jh.m2711():com.ironsource.adqualitysdk.sdk.i.jh");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2699(final ViewGroup viewGroup, final View.OnLayoutChangeListener onLayoutChangeListener) {
        final RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext()) { // from class: com.ironsource.adqualitysdk.sdk.i.jh.1
            @Override // android.view.ViewGroup
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                jh.m2701(jh.this, motionEvent);
                return super.onInterceptTouchEvent(motionEvent);
            }
        };
        relativeLayout.setAlpha(0.0f);
        synchronized (this) {
            this.f2799.put(relativeLayout, new Object());
        }
        relativeLayout.setId(160766228);
        new Handler(Looper.getMainLooper()).post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jh.2
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                viewGroup.addView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
                viewGroup.removeOnLayoutChangeListener(onLayoutChangeListener);
                viewGroup.addOnLayoutChangeListener(onLayoutChangeListener);
            }
        });
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private View.OnLayoutChangeListener m2703(final ViewGroup viewGroup) {
        View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.ironsource.adqualitysdk.sdk.i.jh.5

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f2808 = 1;

            /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
            private static char f2809 = 5;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static char[] f2810 = {'G', 'l', 'o', 'b', 'a', 'T', 'u', 'c', 'h', 'L', 'i', 's', 't', 'e', 'n', 'r', 'S', 'v', 'E', ' ', 'y', 'C', 'g', 'H', 'I'};

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static int f2811;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static String m2718(int i2, byte b8, String str) {
                String str2;
                Object charArray = str;
                if (str != null) {
                    charArray = str.toCharArray();
                }
                char[] cArr = (char[]) charArray;
                synchronized (h.f2264) {
                    try {
                        char[] cArr2 = f2810;
                        char c7 = f2809;
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
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
                f2811 = (f2808 + 19) % 128;
                if (!q.m3013().m3031()) {
                    int i15 = f2808 + 39;
                    f2811 = i15 % 128;
                    try {
                        if (i15 % 2 == 0) {
                            jh.m2713(jh.this, viewGroup, this);
                            return;
                        } else {
                            jh.m2713(jh.this, viewGroup, this);
                            int i16 = 41 / 0;
                            return;
                        }
                    } catch (Throwable th) {
                        kd.m2919(m2718(TextUtils.lastIndexOf("", '0') + 27, (byte) (2 - KeyEvent.getDeadChar(0, 0)), "\u0001\u0002\u0003\u0004\u0000\u0002\u0007\u0000\u0007\b\t\u0005\u000b\f\r\u000e\n\u000e\u0010\u0011\n\u0012\u000f\f\b\f").intern(), m2718((ViewConfiguration.getTapTimeout() >> 16) + 23, (byte) (105 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), "\u0013\u0010\u0011\u0000\u0010\u000f\u000b\n\u0011\u0004\u0013\u000e\u0000\u0018\u0001\u0007\u000b\u0016\t\u0003\f\u0018Í").intern(), th, false);
                    }
                }
                f2808 = (f2811 + 3) % 128;
            }
        };
        f2791 = (f2796 + 43) % 128;
        return onLayoutChangeListener;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2707(ViewGroup viewGroup, View.OnLayoutChangeListener onLayoutChangeListener) {
        int i2 = f2796;
        f2791 = (i2 + 9) % 128;
        if (viewGroup != null) {
            int i8 = i2 + 91;
            f2791 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 68 / 0;
                if (m2702(viewGroup)) {
                    return;
                }
            } else if (m2702(viewGroup)) {
                return;
            }
            Activity activityM2926 = ke.m2926(viewGroup);
            if (jk.m2733().m2736(activityM2926)) {
                if (viewGroup.findViewById(160766228) == null) {
                    int i10 = f2796 + 109;
                    f2791 = i10 % 128;
                    if (i10 % 2 != 0) {
                        m2699(viewGroup, onLayoutChangeListener);
                        return;
                    } else {
                        m2699(viewGroup, onLayoutChangeListener);
                        throw null;
                    }
                }
                return;
            }
            if (jk.m2733().m2735(activityM2926)) {
                m2712(viewGroup, onLayoutChangeListener);
            }
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private synchronized void m2709(ik ikVar) {
        int i2 = f2791 + 75;
        int i8 = i2 % 128;
        f2796 = i8;
        if (i2 % 2 != 0) {
            this.f2801 = ikVar;
            throw null;
        }
        this.f2801 = ikVar;
        f2791 = (i8 + 25) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m2712(final ViewGroup viewGroup, final View.OnLayoutChangeListener onLayoutChangeListener) {
        final hl.c cVar = new hl.c() { // from class: com.ironsource.adqualitysdk.sdk.i.jh.4
            @Override // com.ironsource.adqualitysdk.sdk.i.hl.c
            /* JADX INFO: renamed from: ﻛ */
            public final boolean mo1874(hl hlVar, View view, MotionEvent motionEvent) {
                jh.m2701(jh.this, motionEvent);
                return true;
            }
        };
        new Handler(Looper.getMainLooper()).post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jh.9
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                jh.m2708(viewGroup, cVar);
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof ViewGroup) {
                        jh.m2700(jh.this, (ViewGroup) childAt, onLayoutChangeListener);
                    } else {
                        jh.m2708(childAt, cVar);
                    }
                }
                viewGroup.removeOnLayoutChangeListener(onLayoutChangeListener);
                viewGroup.addOnLayoutChangeListener(onLayoutChangeListener);
            }
        });
        int i2 = f2791 + 99;
        f2796 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2698(MotionEvent motionEvent) {
        try {
            final MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jh.7

                /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
                private static int f2814 = 1;

                /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                private static char[] f2815 = {'G', 'l', 'o', 'b', 'a', 'T', 'u', 'c', 'h', 'L', 'i', 's', 't', 'e', 'n', 'r', 'S', 'v', ' ', 'd', 'f', ':', '{', ',', '}', 'E', 'H', 'I', 'J', 'K', 'M', 'N', 'O', 'P', 'Q', 'R'};

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static int f2816 = 0;

                /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
                private static char f2817 = 6;

                /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                private static String m2719(int i2, byte b8, String str) {
                    String str2;
                    Object charArray = str;
                    if (str != null) {
                        charArray = str.toCharArray();
                    }
                    char[] cArr = (char[]) charArray;
                    synchronized (h.f2264) {
                        try {
                            char[] cArr2 = f2815;
                            char c7 = f2817;
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
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return str2;
                }

                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    f2814 = (f2816 + 79) % 128;
                    try {
                        int iRound = Math.round(motionEventObtain.getRawX());
                        int iRound2 = Math.round(motionEventObtain.getRawY());
                        if (ju.m2800(iRound, iRound2)) {
                            jh.m2714(jh.this, new ik(iRound, iRound2, jv.m2801(), jv.m2805()));
                            return;
                        }
                        String strIntern = m2719(26 - (ViewConfiguration.getWindowTouchSlop() >> 8), (byte) (119 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), "\u0001\u0002\u0003\u0004\u0005\u0002\u0000\u0003\u0007\b\t\n\u000b\u0006\r\u000e\u000f\u000e\u0010\u0011\u000e\u0010\u0010\u000b\r\u0013").intern();
                        StringBuilder sb = new StringBuilder();
                        sb.append(m2719(49 - View.MeasureSpec.getSize(0), (byte) (Color.red(0) + 54), "\u0000\u0003\u0007\b\u0006\u0014\u000e\f\u000e\u000f\u0012\u0018\u0010\u000e\r\u0013\u000b\u0010\u0013\u0019\u0014\u0000\f\u0012\u0014\u0000\u0015\u0013\u0004\u0003\b\f\u0017\u0007\u0013\u0006¥¥\r\u0015\b\u0010\u0000\u0010\u0011\u0007\u0016\u0013±").intern());
                        sb.append(iRound);
                        sb.append(m2719((ViewConfiguration.getWindowTouchSlop() >> 8) + 2, (byte) (47 - Color.blue(0)), "\u0012\u0013").intern());
                        sb.append(iRound2);
                        sb.append(m2719((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (byte) (1 - View.resolveSize(0, 0)), "~").intern());
                        k.m2863(strIntern, sb.toString());
                        f2816 = (f2814 + 1) % 128;
                    } catch (Throwable th) {
                        kd.m2919(m2719(26 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (byte) (KeyEvent.getDeadChar(0, 0) + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), "\u0001\u0002\u0003\u0004\u0005\u0002\u0000\u0003\u0007\b\t\n\u000b\u0006\r\u000e\u000f\u000e\u0010\u0011\u000e\u0010\u0010\u000b\r\u0013").intern(), m2719(TextUtils.getOffsetAfter("", 0) + 16, (byte) (ExpandableListView.getPackedPositionChild(0L) + 99), "\u001b\r\u000e\u0003\f\u0015\b\u0010\u0014\u0000\u0011\u0002\u0000\b\b\t").intern(), th, false);
                    }
                }
            });
            f2791 = (f2796 + 45) % 128;
        } catch (Throwable th) {
            kd.m2919(m2697((-36) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (short) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 1634707089 - Drawable.resolveOpacity(0, 0), (byte) Color.argb(0, 0, 0, 0), 191818761 - TextUtils.getCapsMode("", 0, 0)).intern(), m2697((-29) - View.MeasureSpec.getSize(0), (short) (TextUtils.lastIndexOf("", '0', 0) + 1), (ViewConfiguration.getLongPressTimeout() >> 16) + 1634707114, (byte) View.MeasureSpec.makeMeasureSpec(0, 0), 191818759 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern(), th, false);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2697(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f2793;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f2794;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f2798 + i8] + i10);
                    } else {
                        i11 = (short) (f2792[f2798 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f2798 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f2795);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f2794;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f2792;
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
    private static void m2706(View view, hl.c cVar) {
        int i2 = f2791 + 79;
        f2796 = i2 % 128;
        int i8 = i2 % 2;
        jy.m2825(view, cVar);
        if (i8 != 0) {
            int i9 = 62 / 0;
        }
    }
}
