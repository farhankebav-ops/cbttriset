package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ironsource.adqualitysdk.sdk.i.hp;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class hm extends hp {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private List<Class> f2341 = new ArrayList();

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private int f2342;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private boolean f2343;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private Class f2344;

    public hm() {
        super.mo2312();
        this.f2344 = null;
        this.f2342 = 0;
        this.f2343 = true;
        this.f2341.clear();
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final List<Class> m2308() {
        return this.f2341;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final Class m2309() {
        return this.f2344;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final int m2310() {
        return this.f2342;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final boolean m2311() {
        return this.f2343;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m2313(Class cls) {
        this.f2344 = cls;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.hp
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final void mo2312() {
        super.mo2312();
        this.f2344 = null;
        this.f2342 = 0;
        this.f2343 = true;
        this.f2341.clear();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class e extends hp.c implements ci {

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f2345 = 1;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f2346 = 0;

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static char f2347 = 37805;

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private static char f2348 = 20034;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private static char f2349 = 41563;

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static char f2350 = 24575;

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private hm f2351 = new hm();

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private e m2315(boolean z2) {
            int i2 = f2346 + 81;
            f2345 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f2351.f2343 = z2;
                throw null;
            }
            this.f2351.f2343 = z2;
            f2345 = (f2346 + 23) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        private e m2317(int i2) {
            int i8 = f2345 + 47;
            f2346 = i8 % 128;
            if (i8 % 2 != 0) {
                this.f2351.f2342 = i2;
                throw null;
            }
            this.f2351.f2342 = i2;
            f2346 = (f2345 + 107) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public final e m2321(int i2) {
            hm hmVar;
            int i8;
            int i9 = f2346;
            int i10 = i9 + 47;
            f2345 = i10 % 128;
            if (i10 % 2 == 0) {
                hmVar = this.f2351;
                i8 = i2 ^ hmVar.f2375;
            } else {
                hmVar = this.f2351;
                i8 = i2 | hmVar.f2375;
            }
            hmVar.f2375 = i8;
            int i11 = i9 + 3;
            f2345 = i11 % 128;
            if (i11 % 2 != 0) {
                return this;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final e m2323(Class cls) {
            int i2 = f2346 + 11;
            f2345 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f2351.f2344 = cls;
                throw null;
            }
            this.f2351.f2344 = cls;
            int i8 = f2345 + 69;
            f2346 = i8 % 128;
            if (i8 % 2 == 0) {
                return this;
            }
            throw null;
        }

        @Override // com.ironsource.adqualitysdk.sdk.i.ci
        /* JADX INFO: renamed from: ﾒ */
        public final Object mo886(String str, List<Object> list, ch chVar) {
            int i2 = f2346 + 75;
            f2345 = i2 % 128;
            byte b8 = 2;
            if (i2 % 2 == 0) {
                str.hashCode();
                throw null;
            }
            switch (str.hashCode()) {
                case -1347544616:
                    if (!str.equals(m2319("ퟣ튲⥗磄₾쓛\uee60깼\ud8ae漏ڍ㜻텇㤔㸯㘔鑺뢋", TextUtils.getTrimmedLength("") + 18).intern())) {
                        b8 = -1;
                    } else {
                        f2346 = (f2345 + 41) % 128;
                    }
                    break;
                case -923635536:
                    if (!str.equals(m2319("ퟣ튲䏚\ud99c\uea62蛽灌\uee53壵侠嘊䴓趘鄻", TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 14).intern())) {
                        b8 = -1;
                    } else {
                        f2346 = (f2345 + 5) % 128;
                        b8 = 0;
                    }
                    break;
                case -216533736:
                    b8 = !str.equals(m2319("个瓌漘苙欄袩互⎹ྩ箃", 11 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern()) ? (byte) -1 : (byte) 1;
                    break;
                case 94094958:
                    b8 = !str.equals(m2319("뗨ἇ\ue4adꐽ趘鄻", TextUtils.indexOf("", "", 0) + 5).intern()) ? (byte) -1 : (byte) 8;
                    break;
                case 108404047:
                    if (!str.equals(m2319("⎑뢂ퟣ튲ᦲ밂", (Process.myTid() >> 22) + 5).intern())) {
                        b8 = -1;
                    } else {
                        f2345 = (f2346 + 87) % 128;
                        b8 = 7;
                    }
                    break;
                case 387034026:
                    b8 = !str.equals(m2319("ퟣ튲⥗磄₾쓛햙泀⏋욅鑺뢋䋳舿㚬ꓮჸ\ue093", (Process.myPid() >> 22) + 18).intern()) ? (byte) -1 : (byte) 5;
                    break;
                case 391966482:
                    b8 = !str.equals(m2319("箭쵁⸘︣兣畆헁㰒ﯘ띦ꚑרּ\uded5䶡햙泀\u0af3㨟\uf677Ⓦ\ue1ad䢀", 21 - TextUtils.indexOf("", "", 0)).intern()) ? (byte) -1 : (byte) 3;
                    break;
                case 1067445448:
                    b8 = !str.equals(m2319("箭쵁痶뽤\uea62蛽灌\uee53띳뤳\ue87a稃踉\uf70e\ue1ad䢀", Color.green(0) + 15).intern()) ? (byte) -1 : (byte) 6;
                    break;
                case 1423210564:
                    b8 = !str.equals(m2319("箭쵁⸘︣兣畆헁㰒ﯘ띦ꚑרּ\uded5䶡䲗〥\u0af3㨟\uf677Ⓦ\ue1ad䢀", 21 - Color.green(0)).intern()) ? (byte) -1 : (byte) 4;
                    break;
                default:
                    b8 = -1;
                    break;
            }
            switch (b8) {
                case 0:
                    return m2323((Class) da.m1896(list, 0, Class.class));
                case 1:
                    return m2317(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                case 2:
                    return m2315(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue());
                case 3:
                    return m2321(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                case 4:
                    return m2322(((Integer) da.m1896(list, 0, Integer.class)).intValue());
                case 5:
                    return m2316(((Boolean) da.m1896(list, 0, Boolean.class)).booleanValue(), list.size() > 1 ? ((Integer) da.m1896(list, 1, Integer.class)).intValue() : -1);
                case 6:
                    return m2314((Class) da.m1896(list, 0, Class.class));
                case 7:
                    return m2318();
                case 8:
                    return m2320();
                default:
                    return null;
            }
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        private e m2316(boolean z2, int i2) {
            int i8 = f2345 + 111;
            int i9 = i8 % 128;
            f2346 = i9;
            if (i8 % 2 != 0) {
                hm hmVar = this.f2351;
                hmVar.f2372 = z2;
                hmVar.f2373 = i2;
                int i10 = 12 / 0;
            } else {
                hm hmVar2 = this.f2351;
                hmVar2.f2372 = z2;
                hmVar2.f2373 = i2;
            }
            f2345 = (i9 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
            return this;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private e m2314(Class cls) {
            int i2 = f2345 + 77;
            f2346 = i2 % 128;
            if (i2 % 2 == 0) {
                this.f2351.f2341.add(cls);
                f2345 = (f2346 + 69) % 128;
                return this;
            }
            this.f2351.f2341.add(cls);
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        public final e m2322(int i2) {
            int i8 = (f2346 + 77) % 128;
            f2345 = i8;
            hm hmVar = this.f2351;
            hmVar.f2374 = i2 | hmVar.f2374;
            int i9 = i8 + 9;
            f2346 = i9 % 128;
            if (i9 % 2 != 0) {
                int i10 = 43 / 0;
            }
            return this;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private e m2318() {
            f2345 = (f2346 + 35) % 128;
            this.f2351.mo2312();
            int i2 = f2345 + 1;
            f2346 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 25 / 0;
            }
            return this;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        public final hm m2320() {
            int i2 = f2346 + 101;
            f2345 = i2 % 128;
            if (i2 % 2 != 0) {
                return this.f2351;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        private static String m2319(String str, int i2) {
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
                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f2348)) ^ ((c8 >>> 5) + f2350)));
                                cArr3[1] = c9;
                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f2349) ^ ((c9 + i9) ^ ((c9 << 4) + f2347))));
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
}
