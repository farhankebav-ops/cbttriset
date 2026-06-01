package com.ironsource.adqualitysdk.sdk.i;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ij {

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f2547 = 1;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static int f2548;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static long f2549;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static final Object f2550;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static ij f2551;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static char[] f2552;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private final Handler f2553;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final Context f2558;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private boolean f2557 = true;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f2554 = new HashMap<>();

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private final HashMap<String, ArrayList<b>> f2556 = new HashMap<>();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final ArrayList<c> f2555 = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class b {

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f2560 = 1;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static int f2561;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static int[] f2562 = {485328589, -1673035864, 819681568, -946934813, 1759404449, -663451268, 1444110866, 1551429464, 956207766, -1954172214, -1744601474, 949565856, 1478976832, -1089543108, 1888201248, -40742774, 812107891, 1924333627};

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        boolean f2563;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        final BroadcastReceiver f2564;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        final IntentFilter f2565;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m2546(int[] iArr, int i2) {
            String str;
            synchronized (d.f1664) {
                try {
                    char[] cArr = new char[4];
                    char[] cArr2 = new char[iArr.length << 1];
                    int[] iArr2 = (int[]) f2562.clone();
                    d.f1665 = 0;
                    while (true) {
                        int i8 = d.f1665;
                        if (i8 < iArr.length) {
                            int i9 = iArr[i8];
                            char c7 = (char) (i9 >> 16);
                            cArr[0] = c7;
                            char c8 = (char) i9;
                            cArr[1] = c8;
                            char c9 = (char) (iArr[i8 + 1] >> 16);
                            cArr[2] = c9;
                            char c10 = (char) iArr[i8 + 1];
                            cArr[3] = c10;
                            d.f1663 = (c7 << 16) + c8;
                            d.f1666 = (c9 << 16) + c10;
                            d.m1895(iArr2);
                            for (int i10 = 0; i10 < 16; i10++) {
                                int i11 = d.f1663 ^ iArr2[i10];
                                d.f1663 = i11;
                                int iM1894 = d.m1894(i11) ^ d.f1666;
                                int i12 = d.f1663;
                                d.f1663 = iM1894;
                                d.f1666 = i12;
                            }
                            int i13 = d.f1663;
                            int i14 = d.f1666;
                            d.f1663 = i14;
                            d.f1666 = i13;
                            int i15 = i13 ^ iArr2[16];
                            d.f1666 = i15;
                            int i16 = i14 ^ iArr2[17];
                            d.f1663 = i16;
                            cArr[0] = (char) (i16 >>> 16);
                            cArr[1] = (char) i16;
                            cArr[2] = (char) (i15 >>> 16);
                            cArr[3] = (char) i15;
                            d.m1895(iArr2);
                            int i17 = d.f1665;
                            cArr2[i17 << 1] = cArr[0];
                            cArr2[(i17 << 1) + 1] = cArr[1];
                            cArr2[(i17 << 1) + 2] = cArr[2];
                            cArr2[(i17 << 1) + 3] = cArr[3];
                            d.f1665 = i17 + 2;
                        } else {
                            str = new String(cArr2, 0, i2);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append(m2546(new int[]{-328711423, -1737740282, 1192311182, 1645251307, -1377714264, -279532661}, Gravity.getAbsoluteGravity(0, 0) + 9).intern());
            sb.append(this.f2564);
            sb.append(m2546(new int[]{-1998460702, 1812817390, 954893831, -297017669}, ExpandableListView.getPackedPositionType(0L) + 8).intern());
            sb.append(this.f2565);
            String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2546(new int[]{54226400, -1236242686}, -TextUtils.lastIndexOf("", '0', 0, 0)));
            int i2 = f2561 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
            f2560 = i2 % 128;
            if (i2 % 2 != 0) {
                return strZ;
            }
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class c {

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        final ArrayList<b> f2566;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        final Intent f2567;

        public c(Intent intent, ArrayList<b> arrayList) {
            this.f2567 = intent;
            this.f2566 = arrayList;
        }
    }

    static {
        m2537();
        f2550 = new Object();
        f2548 = (f2547 + 73) % 128;
    }

    private ij(Context context) {
        this.f2558 = context;
        this.f2553 = new Handler(context.getMainLooper()) { // from class: com.ironsource.adqualitysdk.sdk.i.ij.2
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    ij.m2542(ij.this);
                }
            }
        };
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2537() {
        f2549 = 1408749369287217145L;
        f2552 = new char[]{28, '[', 131, 141, 143, 'c', '\\', 131, 132, 136, 138, 134, 138, 133, 't', '7', 'n', 'l', 'n', 'k', 'R', '0', '-', 'W', 's', 'n', 'j', 'F', '0', 'b', 'k', 'n', 'l', 'n', 'p', 233, 233, 225, '`', 191, 198, 205, 202, 205, 205, 200, 200, 202, 207, 206, 163, 165, '@', '}', 'z', 'S', 'N', 'r', 'r', 'N', 'U', 'w', 'x', '|', 'v', 'c', '?', ',', ',', '9', ']', 'q', 'w', 'v', 's', 'R'};
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static ij m2538(Context context) {
        ij ijVar;
        synchronized (f2550) {
            try {
                if (f2551 == null) {
                    f2551 = new ij(context.getApplicationContext());
                }
                ijVar = f2551;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ijVar;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m2542(ij ijVar) {
        int i2 = f2547 + 45;
        f2548 = i2 % 128;
        int i8 = i2 % 2;
        ijVar.m2535();
        if (i8 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m2543(Intent intent) {
        String str;
        int i2;
        String str2;
        int i8;
        String strIntern;
        String str3;
        Uri uri;
        String strIntern2 = m2541("辵댁\uf6b4㩝緉ꅈ\ue401➷欠껒퉼ᗥ增鰦\udff6́䛧覟촀\uf0a9㑇", 15510 - ((byte) KeyEvent.getModifierMetaStateMask())).intern();
        if (!this.f2557) {
            return false;
        }
        synchronized (this.f2554) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f2558.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z2 = (intent.getFlags() & 8) != 0;
                if (z2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(m2536("\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000\u0001", true, new int[]{0, 15, 25, 0}).intern());
                    sb.append(strResolveTypeIfNeeded);
                    sb.append(m2541("这酋눘폒\uf498ᙑ㜚增", 7873 - Gravity.getAbsoluteGravity(0, 0)).intern());
                    sb.append(scheme);
                    sb.append(m2541("这鹭걩먨졼홰\ue46f\uf241O\u2e5e㰗", (Process.myTid() >> 22) + 4603).intern());
                    sb.append(intent);
                    Log.v(strIntern2, sb.toString());
                }
                ArrayList<b> arrayList = this.f2556.get(intent.getAction());
                if (arrayList != null) {
                    if (z2) {
                        StringBuilder sb2 = new StringBuilder();
                        str = action;
                        sb2.append(m2536("\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0000\u0001\u0000", true, new int[]{15, 13, 0, 6}).intern());
                        sb2.append(arrayList);
                        Log.v(strIntern2, sb2.toString());
                    } else {
                        str = action;
                    }
                    ArrayList arrayList2 = null;
                    int i9 = 0;
                    while (i9 < arrayList.size()) {
                        b bVar = arrayList.get(i9);
                        if (z2) {
                            i2 = 16;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(m2541("辴퇏㌣钟\uf6cd堣릝᯿絡\ude97\u20f8舥\ue384䗼Ꝉ\u0894檩챘ⶎ迠텁㊿铱\uf608", 24151 - (ViewConfiguration.getTapTimeout() >> 16)).intern());
                            sb3.append(bVar.f2565);
                            Log.v(strIntern2, sb3.toString());
                        } else {
                            i2 = 16;
                        }
                        if (bVar.f2563) {
                            if (z2) {
                                Log.v(strIntern2, m2541("这ﾠ潍\udefb乱뷐ⵊ鳄ఖ篋\ueb63媾쨴㦮꤀ᢋ蠝\uf7d0朚흮䛿뙱◾镂Ә琈\ue3d2卞슡㈩ꆳ", 28793 - Gravity.getAbsoluteGravity(0, 0)).intern());
                            }
                            str2 = strResolveTypeIfNeeded;
                        } else {
                            String str4 = str;
                            int i10 = i2;
                            int iMatch = bVar.f2565.match(str4, strResolveTypeIfNeeded, scheme, data, categories, strIntern2);
                            str = str4;
                            if (iMatch >= 0) {
                                if (z2) {
                                    StringBuilder sb4 = new StringBuilder();
                                    str2 = strResolveTypeIfNeeded;
                                    sb4.append(m2541("这䶔ଥ쥷蚡䐌ɒ\udf90鶱嬡ᢚ훂鐆剸⾪\ued1e\uab08棄⚳\ue423ꆜ翜㴄ﭺ룼癌㑓", 49741 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)).intern());
                                    sb4.append(Integer.toHexString(iMatch));
                                    Log.v(strIntern2, sb4.toString());
                                } else {
                                    str2 = strResolveTypeIfNeeded;
                                }
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                arrayList2.add(bVar);
                                bVar.f2563 = true;
                            } else {
                                str2 = strResolveTypeIfNeeded;
                                if (z2) {
                                    if (iMatch == -4) {
                                        i8 = i10;
                                        strIntern = m2541("辚䳩९엏艚庣ᬭ힗", (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 50032).intern();
                                    } else if (iMatch == -3) {
                                        i8 = i10;
                                        strIntern = m2536("\u0001\u0000\u0001\u0001\u0000\u0001", false, new int[]{28, 6, 0, 0}).intern();
                                    } else if (iMatch == -2) {
                                        i8 = i10;
                                        strIntern = m2536("\u0000\u0001\u0001\u0001", true, new int[]{34, 4, 127, 0}).intern();
                                    } else if (iMatch != -1) {
                                        i8 = i10;
                                        strIntern = m2536("\u0001\u0000\u0000\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0000", false, new int[]{38, 14, 92, 5}).intern();
                                    } else {
                                        i8 = i10;
                                        strIntern = m2541("辍鿳꽯뻅", (ViewConfiguration.getFadingEdgeLength() >> 16) + 4211).intern();
                                    }
                                    StringBuilder sb5 = new StringBuilder();
                                    str3 = scheme;
                                    uri = data;
                                    sb5.append(m2536("\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0000\u0001\u0001\u0001\u0000\u0001", true, new int[]{52, 24, 12, i8}).intern());
                                    sb5.append(strIntern);
                                    Log.v(strIntern2, sb5.toString());
                                }
                                i9++;
                                data = uri;
                                strResolveTypeIfNeeded = str2;
                                scheme = str3;
                            }
                        }
                        str3 = scheme;
                        uri = data;
                        i9++;
                        data = uri;
                        strResolveTypeIfNeeded = str2;
                        scheme = str3;
                    }
                    if (arrayList2 != null) {
                        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                            ((b) arrayList2.get(i11)).f2563 = false;
                        }
                        this.f2555.add(new c(intent, arrayList2));
                        if (!this.f2553.hasMessages(1)) {
                            this.f2553.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final synchronized void m2545() {
        int i2 = (f2547 + 105) % 128;
        f2548 = i2;
        this.f2557 = true;
        int i8 = i2 + 79;
        f2547 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2536(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
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
                System.arraycopy(f2552, i2, cArr, 0, i8);
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final synchronized void m2544() {
        try {
            int i2 = f2548 + 21;
            f2547 = i2 % 128;
            int i8 = i2 % 2;
            this.f2557 = false;
            m2539();
            int i9 = f2548 + 113;
            f2547 = i9 % 128;
            if (i9 % 2 == 0) {
                int i10 = 36 / 0;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2541(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f2549);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2540(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f2554) {
            try {
                ArrayList<IntentFilter> arrayListRemove = this.f2554.remove(broadcastReceiver);
                if (arrayListRemove == null) {
                    return;
                }
                for (int i2 = 0; i2 < arrayListRemove.size(); i2++) {
                    IntentFilter intentFilter = arrayListRemove.get(i2);
                    for (int i8 = 0; i8 < intentFilter.countActions(); i8++) {
                        String action = intentFilter.getAction(i8);
                        ArrayList<b> arrayList = this.f2556.get(action);
                        if (arrayList != null) {
                            int i9 = 0;
                            while (i9 < arrayList.size()) {
                                if (arrayList.get(i9).f2564 == broadcastReceiver) {
                                    arrayList.remove(i9);
                                    i9--;
                                }
                                i9++;
                            }
                            if (arrayList.size() <= 0) {
                                this.f2556.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m2539() {
        synchronized (this.f2554) {
            try {
                Iterator it = new HashMap(this.f2554).keySet().iterator();
                while (it.hasNext()) {
                    m2540((BroadcastReceiver) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m2535() {
        int size;
        c[] cVarArr;
        while (true) {
            synchronized (this.f2554) {
                try {
                    size = this.f2555.size();
                    if (size <= 0) {
                        return;
                    }
                    cVarArr = new c[size];
                    this.f2555.toArray(cVarArr);
                    this.f2555.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = cVarArr[i2];
                for (int i8 = 0; i8 < cVar.f2566.size(); i8++) {
                    cVar.f2566.get(i8).f2564.onReceive(this.f2558, cVar.f2567);
                }
            }
        }
    }
}
