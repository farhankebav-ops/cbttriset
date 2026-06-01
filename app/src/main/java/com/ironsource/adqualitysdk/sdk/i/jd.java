package com.ironsource.adqualitysdk.sdk.i;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.widget.ExpandableListView;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class jd {

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static jd f2744;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private jj f2745;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Choreographer.FrameCallback f2746;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private boolean f2748;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private HashMap<in, iu> f2749 = new HashMap<>();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Handler f2747 = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.jd$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass1 extends iu {
        public AnonymousClass1() {
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            if (jd.this.f2745 == null) {
                jd.this.f2745 = new jj() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.1.3
                    @Override // com.ironsource.adqualitysdk.sdk.i.jj, com.ironsource.adqualitysdk.sdk.i.jg
                    /* JADX INFO: renamed from: ｋ */
                    public final void mo483(Activity activity) {
                        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.1.3.5
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                final jd jdVar = jd.this;
                                p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.4
                                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                    /* JADX INFO: renamed from: ﻐ */
                                    public final void mo306() {
                                        jd.m2666(jd.this);
                                    }
                                });
                            }
                        });
                    }

                    @Override // com.ironsource.adqualitysdk.sdk.i.jj, com.ironsource.adqualitysdk.sdk.i.jg
                    /* JADX INFO: renamed from: ﾒ */
                    public final void mo484(Activity activity) {
                        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.1.3.2
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                jd.m2676(jd.this);
                            }
                        });
                    }
                };
                jd.this.f2747.post(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.1.5
                    @Override // com.ironsource.adqualitysdk.sdk.i.iu
                    /* JADX INFO: renamed from: ﻐ */
                    public final void mo306() {
                        jf.m2685().m2686(jd.this.f2745);
                        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.1.5.5
                            @Override // com.ironsource.adqualitysdk.sdk.i.iu
                            /* JADX INFO: renamed from: ﻐ */
                            public final void mo306() {
                                jd.m2676(jd.this);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.jd$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass2 extends iu {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private /* synthetic */ in f2756;

        public AnonymousClass2(in inVar) {
            this.f2756 = inVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            jd.this.f2749.remove(this.f2756);
        }
    }

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.jd$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnonymousClass3 extends iu {

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        final /* synthetic */ in f2758;

        public AnonymousClass3(in inVar) {
            this.f2758 = inVar;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.iu
        /* JADX INFO: renamed from: ﻐ */
        public final void mo306() {
            jd.this.f2749.put(this.f2758, new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.3.5
                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                /* JADX INFO: renamed from: ﻐ */
                public final void mo306() {
                    AnonymousClass3.this.f2758.mo1872();
                }
            });
            jd.m2676(jd.this);
        }
    }

    private jd() {
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static /* synthetic */ boolean m2666(jd jdVar) {
        jdVar.f2748 = false;
        return false;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ HashMap m2667(jd jdVar) {
        return new HashMap(jdVar.f2749);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m2679() {
        p.m2964(new AnonymousClass1());
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void m2677(in inVar) {
        p.m2964(new AnonymousClass2(inVar));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static synchronized jd m2673() {
        try {
            if (f2744 == null) {
                f2744 = new jd();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f2744;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m2676(jd jdVar) {
        if (jdVar.f2748 || new HashMap(jdVar.f2749).isEmpty()) {
            return;
        }
        jdVar.f2748 = true;
        p.m2964(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.5
            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                if (!jd.this.f2748) {
                    jd.this.f2746 = null;
                    return;
                }
                HashMap mapM2667 = jd.m2667(jd.this);
                Iterator it = mapM2667.keySet().iterator();
                while (it.hasNext()) {
                    jd.this.f2747.post((Runnable) mapM2667.get((in) it.next()));
                }
                if (jd.this.f2746 == null) {
                    jd.this.f2746 = new Choreographer.FrameCallback() { // from class: com.ironsource.adqualitysdk.sdk.i.jd.5.2

                        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
                        private static long f2763 = -3209217963723198588L;

                        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
                        private static int f2764 = 0;

                        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
                        private static int f2765 = 1;

                        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
                        private static String m2680(String str, int i2) {
                            String str2;
                            Object charArray = str;
                            if (str != null) {
                                charArray = str.toCharArray();
                            }
                            char[] cArr = (char[]) charArray;
                            synchronized (i.f2441) {
                                try {
                                    char[] cArrM2497 = i.m2497(f2763, cArr, i2);
                                    i.f2442 = 4;
                                    while (true) {
                                        int i8 = i.f2442;
                                        if (i8 < cArrM2497.length) {
                                            i.f2443 = i8 - 4;
                                            cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2763));
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

                        @Override // android.view.Choreographer.FrameCallback
                        public final void doFrame(long j) {
                            f2764 = (f2765 + 101) % 128;
                            try {
                                p.m2963(this);
                                int i2 = f2765 + 93;
                                f2764 = i2 % 128;
                                if (i2 % 2 != 0) {
                                    int i8 = 99 / 0;
                                }
                            } catch (Throwable th) {
                                k.m2873(m2680("ᗓ抲ᖒ㌲⅟赒\uec6b\uefa6ꮢ콊깃궷榊ॅ桞殸", ExpandableListView.getPackedPositionChild(0L) + 1).intern(), m2680("灇ꄐ瀡볱攈仵掐ꯨ츲ೠ⇉\ue9f0ఈ쫲\ue7ab⿅䨙裁", Color.alpha(0)).intern(), th, false);
                            }
                        }
                    };
                }
                Choreographer.getInstance().postFrameCallback(jd.this.f2746);
            }
        });
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2678(in inVar) {
        p.m2964(new AnonymousClass3(inVar));
    }
}
