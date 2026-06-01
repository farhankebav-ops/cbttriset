package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ay {

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    private static int f609 = 1;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static int f610;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private String f619;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f620;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String f621;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f622;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f623;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f624;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char[] f615 = {19090, 6193, 61382, 48493, ';', 55258, 42339, 45813, 57424, 6066, 17672, 63571, 12213, 23812, 61549, 53231, 40230, 27312, 'W', 21197, 42290, 63406, 19145, 40237, 61319, 'A', 21196, 42241, 63373, 19137, 40228, 61337, 17132, 38201, 59323, 15060, 36211, 'M', 21197, 42275, 63371, 19137, 40239, 61333, 17058, 38240, '-', 21125, 42365, 63445, 19085, 40293, 61405, 17077, 38253, 59333, 15037, 36117, 57293, 12965, 34064, 1229, 9374, 30262, 33230, 54118, 28222, 47574, 52078, 26118, 45534, 50038, 7694, 43430, 64382, 5654, 'N', 21191, 42276, 63448, 19142, 40237, 61316, 17147, 38184, 59277, 15092, 1276, 22055, 41416, 62319, 20060, 39394, 60233, 17974, 37359, 58205, 15907, 35210, 56070, 13940, 53037, 40403, 27256, 14499, 34284, 21003, 8408, 36326, 23085, 10386, 62955, 16985, 4231, 65006, 18968, 6389, 58875, 45568, 177, 60675, 47624, 2222, 54551, 41572, 28904, 56601, 43645, 30916, 50504, 37491, 24781, 52512, 39544, 26831, 13610, 33668, 20685, 15652, 35800, 22770, 9521, 62400, 16620, 11608, 64397, 18592, 5467, 58303, 45286, 7502, 60349, 47123, 1372, 54191, 40970};

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static long f616 = 6357781148853883560L;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static char f611 = 62020;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static char f614 = 40828;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static char f612 = 61676;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static char f613 = 40629;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private a f618 = a.f636;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private d f617 = d.f649;

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.ay$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        static final /* synthetic */ int[] f625;

        /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
        static final /* synthetic */ int[] f626;

        static {
            int[] iArr = new int[d.valuesCustom().length];
            f626 = iArr;
            try {
                iArr[d.f642.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f626[d.f648.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f626[d.f646.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f626[d.f645.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f626[d.f647.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[a.valuesCustom().length];
            f625 = iArr2;
            try {
                iArr2[a.f633.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f625[a.f632.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f625[a.f635.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f625[a.f628.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f625[a.f634.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        f636,
        f633,
        f632,
        f635,
        f634,
        f628;


        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static int f627 = 0;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static int f630 = 0;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f631 = 1;

        static {
            m752();
            f627 = (f631 + 79) % 128;
        }

        public static a valueOf(String str) {
            int i2 = f631 + 99;
            f627 = i2 % 128;
            int i8 = i2 % 2;
            a aVar = (a) Enum.valueOf(a.class, str);
            if (i8 != 0) {
                int i9 = 63 / 0;
            }
            return aVar;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            f627 = (f631 + 27) % 128;
            a[] aVarArr = (a[]) values().clone();
            f631 = (f627 + 13) % 128;
            return aVarArr;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public static void m752() {
            f630 = 77;
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m753(int i2, int i8, String str, int i9, boolean z2) {
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
                        cArr2[i11] = (char) (cArr2[i11] - f630);
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
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum d {
        f649,
        f648,
        f646,
        f645,
        f647,
        f642;


        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        private static int f637 = 1;

        /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
        private static int f638;

        /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
        private static boolean f639;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static char[] f641;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static boolean f643;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f644;

        static {
            m754();
            int i2 = f638 + 51;
            f637 = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
        }

        public static d valueOf(String str) {
            f637 = (f638 + 75) % 128;
            d dVar = (d) Enum.valueOf(d.class, str);
            f637 = (f638 + 29) % 128;
            return dVar;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static d[] valuesCustom() {
            f638 = (f637 + 3) % 128;
            d[] dVarArr = (d[]) values().clone();
            f637 = (f638 + 31) % 128;
            return dVarArr;
        }

        /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
        public static void m754() {
            f643 = true;
            f639 = true;
            f644 = ModuleDescriptor.MODULE_VERSION;
            f641 = new char[]{233, 234, 224, 242, 237, 250, 220, 226, 239, 236, 240, 228, 223, 238, 235, 230, 241, 231, 245, 225, 222};
        }

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        private static String m755(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                    char[] cArr2 = f641;
                    int i8 = f644;
                    if (f639) {
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
                    if (f643) {
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
    }

    public ay(String str) {
        this.f622 = str;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private String m739() {
        int i2 = f609 + 3;
        f610 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
        if (this.f620 == null || this.f624 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m746("겚\ue741滚⋑䈁\udfe8゛\uef00\uf21e\ude9d꼩㥨\ude3a\ue96f듋\ue344ﶞT獇⋁亠ᾄਜ਼⯜", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 23).intern());
        sb.append(this.f620);
        sb.append(m746("\ue8fc拃誸ꣃ", ((byte) KeyEvent.getModifierMetaStateMask()) + 4).intern());
        sb.append(this.f624);
        String string = sb.toString();
        f609 = (f610 + 49) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private String m740() {
        f610 = (f609 + 1) % 128;
        String strName = this.f618.name();
        f609 = (f610 + 85) % 128;
        return strName;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private String m742(d dVar) {
        f610 = (f609 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        if (dVar == null) {
            return null;
        }
        int i2 = AnonymousClass5.f626[dVar.ordinal()];
        if (i2 == 1) {
            return m746("ᢣ鮨뼇逪샦㢡ꋯ䧝\uea08걼䱫씼庻ת\ud8fe쟫Фﶶ\uddf7ﵬ亠ᾄ", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 22).intern();
        }
        if (i2 == 2) {
            return String.format(m746("䣌\uea99\ude3a\ue96f疥\ue5beр\uf821\uea08걼惬鑳岘诃㪇ᚸ南ᾛҸ嚐ꪟ끟雩㪯ꢡ핆腃嬇\uf27e\u0b0d斠콀\ueac4Ȣᘃᕦ뺶⠐麞实ῷ쩞р\uf821\uea08걼惬鑳岘诃㪇ᚸ南ᾛ௮◲聉㲾핛갣\uea08걼", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 62).intern(), this.f622, this.f621, this.f619);
        }
        if (i2 == 3) {
            return String.format(m744((char) (53000 - (ViewConfiguration.getTouchSlop() >> 8)), TextUtils.getOffsetAfter("", 0) + 55, 100 - TextUtils.lastIndexOf("", '0')).intern(), this.f622, this.f621);
        }
        if (i2 == 4) {
            return m746("ଣ蓁䮲遦亠ᾄ\uec79ٻ⽷姌\ueade\uecbd粶\udfa6ꕱ溮ᘃᕦ뱗࡛퐍捠岘诃⽍㡭ф\ue335௮◲", 30 - TextUtils.getOffsetBefore("", 0)).intern();
        }
        if (i2 != 5) {
            return null;
        }
        String strIntern = m746("ଣ蓁䮲遦亠ᾄ\uec79ٻ⽷姌Ԃ⒫庘銮緈禍퐍捠岘诃⽍㡭ф\ue335௮◲", Color.rgb(0, 0, 0) + 16777242).intern();
        int i8 = f610 + 11;
        f609 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 38 / 0;
        }
        return strIntern;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009a  */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m747(com.ironsource.adqualitysdk.sdk.i.cn r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.ay.m747(com.ironsource.adqualitysdk.sdk.i.cn):void");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final void m749(d dVar) {
        int i2 = f609 + 49;
        f610 = i2 % 128;
        if (i2 % 2 == 0) {
            this.f617 = dVar;
            m750(a.f628);
        } else {
            this.f617 = dVar;
            m750(a.f628);
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final void m750(a aVar) {
        this.f618 = aVar;
        if (aVar != a.f628) {
            f609 = (f610 + 103) % 128;
            this.f617 = d.f649;
        }
        int i2 = AnonymousClass5.f625[aVar.ordinal()];
        if (i2 == 3 || i2 == 4 || i2 == 5) {
            m741();
            f609 = (f610 + 7) % 128;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final boolean m751() {
        a aVar = this.f618;
        if (aVar == a.f633) {
            return true;
        }
        int i2 = f610 + 33;
        f609 = i2 % 128;
        if (i2 % 2 == 0) {
            a aVar2 = a.f636;
            throw null;
        }
        if (aVar == a.f632 || aVar == a.f636) {
            return true;
        }
        f609 = (f610 + 11) % 128;
        return false;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String m743() {
        String strIntern;
        if (this.f622 == null || (strIntern = this.f621) == null) {
            return null;
        }
        f610 = (f609 + 37) % 128;
        if (strIntern.equals(m744((char) (53154 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 3 - Color.green(0), 16 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern())) {
            int i2 = f610 + 93;
            f609 = i2 % 128;
            if (i2 % 2 == 0) {
                a aVar = a.f636;
                throw null;
            }
            if (this.f618 != a.f634) {
                strIntern = m744((char) (ViewConfiguration.getTouchSlop() >> 8), 11 - (ViewConfiguration.getScrollBarSize() >> 8), 76 - (ViewConfiguration.getPressedStateDuration() >> 16)).intern();
                f609 = (f610 + 53) % 128;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f622);
        return a0.d(sb, m744((char) (TextUtils.indexOf((CharSequence) "", '0') + 1245), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 13, 87 - TextUtils.indexOf("", "", 0, 0)), strIntern);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String m745() {
        StringBuilder sb = new StringBuilder();
        sb.append(m744((char) Color.red(0), 15 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 46 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern());
        sb.append(this.f622);
        String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m746("퐍捠岘诃⽍㡭ф\ue335௮◲誸ꣃ", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 10));
        if (this.f623 != null) {
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(strZ);
            sbR.append(this.f623);
            strZ = com.google.android.gms.ads.internal.client.a.z(sbR, m744((char) (1261 - TextUtils.getCapsMode("", 0, 0)), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), Color.green(0) + 61));
            f609 = (f610 + 87) % 128;
        }
        String strZ2 = com.google.android.gms.ads.internal.client.a.z(androidx.camera.core.processing.util.a.r(strZ), m744((char) (9395 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))), 13 - ImageFormat.getBitsPerPixel(0), 61 - TextUtils.lastIndexOf("", '0', 0)));
        int i2 = f610 + 57;
        f609 = i2 % 128;
        if (i2 % 2 != 0) {
            return strZ2;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final String m748() {
        f610 = (f609 + 69) % 128;
        String strM742 = m742(this.f617);
        f609 = (f610 + 1) % 128;
        return strM742;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m741() {
        f609 = (f610 + 67) % 128;
        if (this.f622.equals(m744((char) TextUtils.getTrimmedLength(""), 8 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19).intern())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m745());
        sb2.append(m746("㟄暢", 1 - View.resolveSizeAndState(0, 0, 0)).intern());
        sb.append(sb2.toString());
        String strM743 = m743();
        if (strM743 != null) {
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(strM743);
            sbR.append(m746("㟄暢", Color.rgb(0, 0, 0) + 16777217).intern());
            sb.append(sbR.toString());
        }
        String strM739 = m739();
        if (strM739 != null) {
            StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(strM739);
            sbR2.append(m746("㟄暢", -TextUtils.indexOf((CharSequence) "", '0', 0)).intern());
            sb.append(sbR2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(m746("꼏뾩㊳\ud963K댰ਜ਼⯜", 8 - Drawable.resolveOpacity(0, 0)).intern());
        sb3.append(m740());
        sb3.append(m746("㟄暢", -TextUtils.indexOf((CharSequence) "", '0')).intern());
        sb.append(sb3.toString());
        a aVar = this.f618;
        if (aVar != a.f635 && aVar != a.f634) {
            String strM742 = m742(this.f617);
            if (strM742 != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(m744((char) (ViewConfiguration.getScrollBarSize() >> 8), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 9, MotionEvent.axisFromString("") + 38).intern());
                sb4.append(strM742);
                sb.append(sb4.toString());
            }
            k.m2868(m744((char) ((-1) - TextUtils.lastIndexOf("", '0')), (ViewConfiguration.getEdgeSlop() >> 16) + 12, 26 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), sb.toString());
            f610 = (f609 + 79) % 128;
            return;
        }
        k.m2854(m744((char) View.getDefaultSize(0, 0), (Process.myPid() >> 22) + 12, 25 - (Process.myTid() >> 22)).intern(), sb.toString());
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m744(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f615[i8 + i9]) ^ (((long) i9) * f616)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m746(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f611)) ^ ((c8 >>> 5) + f612)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f614) ^ ((c9 + i9) ^ ((c9 << 4) + f613))));
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
