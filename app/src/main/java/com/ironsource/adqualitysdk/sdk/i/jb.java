package com.ironsource.adqualitysdk.sdk.i;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class jb {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f2686 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static Handler f2687 = null;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2688 = 169;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f2689;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private ib f2690;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b {
        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        void mo2647(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface d {
        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        void mo2648();
    }

    public jb(Context context, String str, String str2) {
        this.f2690 = new ib(context, str, str2);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static Handler m2633() {
        Handler handler;
        synchronized (jb.class) {
            try {
                if (f2687 == null) {
                    HandlerThread handlerThread = new HandlerThread(m2632(271 - Color.alpha(0), 14 - TextUtils.indexOf((CharSequence) "", '0'), "\u0013\uffff￥\uffff\u0001\ufffb\f\t\u000e￭\uffff\u000f\u0006\ufffb\ufff0", 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), true).intern());
                    handlerThread.start();
                    f2687 = new Handler(handlerThread.getLooper());
                }
                handler = f2687;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m2635(jb jbVar, d dVar) {
        int i2 = f2686 + 29;
        f2689 = i2 % 128;
        int i8 = i2 % 2;
        jbVar.m2634(dVar);
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m2636(String str) {
        String strZ = com.google.android.gms.ads.internal.client.a.z(androidx.camera.core.processing.util.a.r(str), m2632(TextUtils.indexOf((CharSequence) "", '0') + 272, Color.alpha(0) + 11, "\n\ufffe\ufffb\u000e\uffff\uffc8\u0006\ufffb\r\u000e\u000f", 5 - (ViewConfiguration.getScrollBarSize() >> 8), false));
        f2686 = (f2689 + 17) % 128;
        return strZ;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final HashMap<String, String> m2638(String str, int i2) {
        int i8 = f2686 + 111;
        f2689 = i8 % 128;
        if (i8 % 2 != 0) {
            this.f2690.m2500(str, i2);
            throw null;
        }
        HashMap<String, String> mapM2500 = this.f2690.m2500(str, i2);
        int i9 = f2689 + 39;
        f2686 = i9 % 128;
        if (i9 % 2 != 0) {
            return mapM2500;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2643(final String str, final b bVar) {
        m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jb.5
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                final String strM2637 = jb.this.m2637(str);
                p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jb.5.2
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        bVar.mo2647(strM2637);
                    }
                });
            }
        });
        f2686 = (f2689 + 23) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final String m2637(String str) {
        int i2 = f2689 + 65;
        f2686 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f2690.m2502(str);
            throw null;
        }
        String strM2502 = this.f2690.m2502(str);
        int i8 = f2689 + 81;
        f2686 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 2 / 0;
        }
        return strM2502;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2642(String str) {
        f2689 = (f2686 + 1) % 128;
        this.f2690.m2498(str);
        f2689 = (f2686 + 23) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final int m2644(String str) {
        f2689 = (f2686 + 73) % 128;
        int iM2499 = this.f2690.m2499(str);
        f2686 = (f2689 + 65) % 128;
        return iM2499;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2634(d dVar) {
        f2689 = (f2686 + 25) % 128;
        if (dVar != null) {
            p.m2967(new iu(dVar) { // from class: com.ironsource.adqualitysdk.sdk.i.jb.4
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                }
            });
        }
        int i2 = f2689 + 1;
        f2686 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m2639(String str, String str2) {
        int i2 = f2689 + 101;
        f2686 = i2 % 128;
        int i8 = i2 % 2;
        m2641(str, str2, null);
        if (i8 == 0) {
            throw null;
        }
        f2686 = (f2689 + 9) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m2645(String str, String str2) {
        f2689 = (f2686 + 49) % 128;
        m2640(str, str2);
        m2640(m2636(str), Long.toString(jv.m2801()));
        f2689 = (f2686 + 13) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2632(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f2688);
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m2646(final String str, final String str2, final d dVar) {
        m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jb.1
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                jb.this.m2645(str, str2);
                jb.m2635(jb.this, dVar);
            }
        });
        f2686 = (f2689 + 7) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2640(String str, String str2) {
        f2689 = (f2686 + 17) % 128;
        this.f2690.m2501(str, str2);
        int i2 = f2686 + 35;
        f2689 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 62 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2641(final String str, final String str2, final d dVar) {
        m2633().post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jb.3
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                jb.this.m2640(str, str2);
                jb.m2635(jb.this, dVar);
            }
        });
        int i2 = f2689 + 13;
        f2686 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }
}
