package com.ironsource.adqualitysdk.sdk.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class iv extends BroadcastReceiver {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char f2589 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f2590 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f2591;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static char f2592;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static char f2593;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String f2594;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f2595;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private Context f2596;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private boolean f2597 = false;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private Set<iq> f2598 = new HashSet();

    static {
        m2561();
        f2594 = m2564("㙃济䳣紈轨ʟ朽둕濲ꒂꔇ\u20fc듣ꊡ杺ꗝ쳐ࢹ䂮逅", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 19).intern();
        int i2 = f2590 + 61;
        f2591 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 57 / 0;
        }
    }

    public iv(Context context) {
        this.f2596 = context.getApplicationContext();
        k.m2852(f2594, m2564("\ue9fcᄴ\ued9eꞔ뵔ﲊꃉ뎎沸樓॥\ue323䥂켁撱滑뫿‘\u1a5f벸頎鯄ꅐ뤰勏쏫ᙄ\ueb1b뀊\ue767", 30 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(m2564("콶朗鮕㺯ጌ\udbae拳븉춤퓲ᐉ钩准撨䭱⺀ꄿ室ퟀ\u0ce4⒭즩㞽䝼걃\ueb7b녻䘃셋ު둻䭖꾏\ua7e1挆鬠", ImageFormat.getBitsPerPixel(0) + 37).intern());
        this.f2596.registerReceiver(this, intentFilter);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static void m2561() {
        f2589 = (char) 13829;
        f2592 = (char) 12505;
        f2593 = (char) 25300;
        f2595 = (char) 60301;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private synchronized Set<iq> m2562() {
        HashSet hashSet = new HashSet(this.f2598);
        int i2 = f2591 + 69;
        f2590 = i2 % 128;
        if (i2 % 2 != 0) {
            return hashSet;
        }
        int i8 = 10 / 0;
        return hashSet;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ boolean m2566(iv ivVar, Context context) {
        boolean zM2569;
        int i2 = f2591 + 15;
        f2590 = i2 % 128;
        if (i2 % 2 == 0) {
            zM2569 = m2569(context);
            int i8 = 80 / 0;
        } else {
            zM2569 = m2569(context);
        }
        int i9 = f2591 + 5;
        f2590 = i9 % 128;
        if (i9 % 2 != 0) {
            return zM2569;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m2567() {
        int i2 = f2591;
        int i8 = i2 + 101;
        f2590 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        String str = f2594;
        f2590 = (i2 + 83) % 128;
        return str;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        p.m2963(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iv.4

            /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
            private static int f2599 = -1189240753;

            /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
            private static int f2600 = 0;

            /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
            private static byte[] f2601 = {-68, -28, -29, 23, -29, 31, -2, 28, 31, 17, -23, 23, -17, 11, -28, -19, 26, -27, 22, 15, -38, 26, -27, 22, 47, -96, 21, -19, 90, -48, -31, -32, -25, 20, -20, 23, -77, -52, -53, 63, -53, 55, 113, -107, 55, 57, -63, 63, -57, 35, -52, -59, 50, -51, 62, 113, -121, -53, 49, -54, 49, 61, 37, -90, -114, -128, 120, -122, 126, -102, 117, 124, -117, 116, -89, 95, -118, -73, -74, -72, 64, -66, 70, -94, 77, 68, -77, 76, -65, -16, 6, 74, -80, 75, -80, -68, 68, -3, 2, -78, -3, 30, -1, 113, 64, -66, 78, -89, -86, -25, 5, 12, 10, -10, 27, -20, -9, 71, -70, 13, 65, -90, 11, -11, 8, 37};

            /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
            private static short[] f2602 = null;

            /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
            private static int f2603 = 1;

            /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
            private static int f2604 = 104;

            /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
            private static int f2605 = -957716683;

            /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
            private static String m2576(int i2, short s7, int i8, byte b8, int i9) {
                String string;
                synchronized (n.f2979) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int i10 = f2604;
                        int i11 = i2 + i10;
                        int i12 = i11 == -1 ? 1 : 0;
                        if (i12 != 0) {
                            byte[] bArr = f2601;
                            i11 = bArr != null ? (byte) (bArr[f2605 + i8] + i10) : (short) (f2602[f2605 + i8] + i10);
                        }
                        if (i11 > 0) {
                            n.f2984 = ((i8 + i11) - 2) + f2605 + i12;
                            n.f2982 = b8;
                            char c7 = (char) (i9 + f2599);
                            n.f2981 = c7;
                            sb.append(c7);
                            n.f2980 = n.f2981;
                            n.f2983 = 1;
                            while (n.f2983 < i11) {
                                byte[] bArr2 = f2601;
                                if (bArr2 != null) {
                                    int i13 = n.f2984;
                                    n.f2984 = i13 - 1;
                                    n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                                } else {
                                    short[] sArr = f2602;
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

            @Override // com.ironsource.adqualitysdk.sdk.i.iu
            /* JADX INFO: renamed from: ﻐ */
            public final void mo306() {
                try {
                    if (intent.getAction().equals(m2576((-105) - (Process.myPid() >> 22), (short) (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.lastIndexOf("", '0', 0) + 957716684, (byte) (26 - KeyEvent.normalizeMetaState(0)), TextUtils.indexOf((CharSequence) "", '0') + 1189240851).intern())) {
                        f2603 = (f2600 + 37) % 128;
                        k.m2858(iv.m2567(), m2576(Color.red(0) - 105, (short) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), KeyEvent.getDeadChar(0, 0) + 957716719, (byte) ('b' - AndroidCharacter.getMirror('0')), 1189240831 - (KeyEvent.getMaxKeyCode() >> 16)).intern());
                        if (intent.getBooleanExtra(m2576((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 105, (short) (ViewConfiguration.getScrollBarFadeDuration() >> 16), 957716746 - (ViewConfiguration.getTouchSlop() >> 8), (byte) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 118), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1189240863).intern(), false)) {
                            k.m2858(iv.m2567(), m2576((-105) - View.combineMeasuredStates(0, 0), (short) View.MeasureSpec.makeMeasureSpec(0, 0), 957716760 - ((Process.getThreadPriority(0) + 20) >> 6), (byte) ((-77) - (ViewConfiguration.getWindowTouchSlop() >> 8)), 1189240837 - (ViewConfiguration.getTapTimeout() >> 16)).intern());
                            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iv.4.2
                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    iv.this.m2572();
                                    iv.m2568(iv.this, false);
                                }
                            });
                        } else if (iv.m2566(iv.this, context)) {
                            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iv.4.1
                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    iv.m2568(iv.this, true);
                                    iv.this.m2574();
                                }
                            });
                            f2600 = (f2603 + 93) % 128;
                        } else {
                            p.m2967(new iu() { // from class: com.ironsource.adqualitysdk.sdk.i.iv.4.4
                                @Override // com.ironsource.adqualitysdk.sdk.i.iu
                                /* JADX INFO: renamed from: ﻐ */
                                public final void mo306() {
                                    iv.m2568(iv.this, false);
                                    iv.this.m2572();
                                }
                            });
                            f2600 = (f2603 + 105) % 128;
                        }
                    }
                } catch (Exception e) {
                    kd.m2919(iv.m2567(), m2576((-105) - View.resolveSize(0, 0), (short) TextUtils.indexOf("", "", 0), 957716791 - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9), 1189240822 - (Process.myPid() >> 22)).intern(), e, false);
                }
            }
        });
        f2591 = (f2590 + 17) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized void m2570(iq iqVar) {
        try {
            int i2 = f2590 + 1;
            f2591 = i2 % 128;
            if (i2 % 2 != 0) {
                this.f2598.add(iqVar);
                int i8 = 69 / 0;
            } else {
                this.f2598.add(iqVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final synchronized void m2573(iq iqVar) {
        int i2 = f2591 + 77;
        f2590 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f2598.remove(iqVar);
            throw null;
        }
        this.f2598.remove(iqVar);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m2575() {
        int i2 = f2590 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f2591 = i2 % 128;
        if (i2 % 2 != 0) {
            this.f2596.unregisterReceiver(this);
            throw null;
        }
        this.f2596.unregisterReceiver(this);
        int i8 = f2590 + 81;
        f2591 = i8 % 128;
        if (i8 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m2568(iv ivVar, boolean z2) {
        f2591 = (f2590 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        ivVar.m2565(z2);
        f2590 = (f2591 + 39) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean m2569(Context context) {
        f2591 = (f2590 + 37) % 128;
        NetworkInfo networkInfoM2563 = m2563(context);
        if (networkInfoM2563 != null) {
            int i2 = f2590 + 115;
            f2591 = i2 % 128;
            if (i2 % 2 != 0) {
                networkInfoM2563.isConnected();
                throw null;
            }
            if (networkInfoM2563.isConnected()) {
                String str = f2594;
                StringBuilder sb = new StringBuilder();
                sb.append(m2564("㙃济䳣紈轨ʟ摝祟", (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 9).intern());
                sb.append(networkInfoM2563.getTypeName());
                sb.append(m2564("幖䕾ꈤ줙춤퓲鄓ᒀ돒\uf2eb竻⌠", 11 - Color.blue(0)).intern());
                k.m2858(str, sb.toString());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final synchronized boolean m2571() {
        boolean z2;
        int i2 = (f2590 + 7) % 128;
        f2591 = i2;
        z2 = this.f2597;
        f2590 = (i2 + 15) % 128;
        return z2;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final void m2572() {
        Iterator<iq> it = m2562().iterator();
        f2590 = (f2591 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        while (it.hasNext()) {
            f2590 = (f2591 + 55) % 128;
            it.next();
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m2574() {
        Iterator<iq> it = m2562().iterator();
        while (it.hasNext()) {
            it.next().mo481();
            f2590 = (f2591 + 27) % 128;
        }
        f2591 = (f2590 + 13) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private synchronized void m2565(boolean z2) {
        int i2 = f2591;
        int i8 = i2 + 33;
        f2590 = i8 % 128;
        if (i8 % 2 == 0) {
            this.f2597 = z2;
            throw null;
        }
        this.f2597 = z2;
        f2590 = (i2 + 23) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static NetworkInfo m2563(Context context) {
        int i2 = f2591 + 33;
        f2590 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(m2564("准撨䭱⺀ꅐ뤰鬲ၕ\udf55㙌盇鶴", View.resolveSizeAndState(0, 0, 0) + 12).intern())).getActiveNetworkInfo();
        int i8 = f2591 + 103;
        f2590 = i8 % 128;
        if (i8 % 2 != 0) {
            return activeNetworkInfo;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2564(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2589)) ^ ((c8 >>> 5) + f2593)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2592) ^ ((c9 + i9) ^ ((c9 << 4) + f2595))));
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
