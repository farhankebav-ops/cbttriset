package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class au {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f433 = 0;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f435 = 1;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private List<String> f438;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private d f439;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f440;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f437 = {22808, 32415, 5640, 12183, 'v', 10212, 30865, 24332, 14230, 3598, 59044, 48447, 'e', 10226, 20341, 30461, 40540, 'n', 10239, 20344, 30450, 'C', 10213, 20346, 30448, 40525, 50641, 60744, 5289, 15394, 25502, 35597, 45725, 55833, 608, 10720, 20851, 30947, 41029, 51162, 61272, 5793, 15925, 'E', 10232, 20326, 30449, 40538, 50578, 60757, 5288, 15472, 25513, 35596, 45697, 55821, 622, 10728, 20818, 30921, 41049, 51157, 61276, 5796, 15927};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f436 = -1689655379036723318L;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f434 = 97;

    /* JADX INFO: renamed from: com.ironsource.adqualitysdk.sdk.i.au$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
        static final /* synthetic */ int[] f441;

        static {
            int[] iArr = new int[d.valuesCustom().length];
            f441 = iArr;
            try {
                iArr[d.f451.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f441[d.f449.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f441[d.f450.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f441[d.f452.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum d {
        f451,
        f452,
        f450,
        f449;


        /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
        private static int f442 = 1;

        /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
        private static char f443;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static char f444;

        /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
        private static char f445;

        /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
        private static char f446;

        /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
        private static int f447;

        static {
            m637();
            f447 = (f442 + 21) % 128;
        }

        public static d valueOf(String str) {
            f447 = (f442 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
            d dVar = (d) Enum.valueOf(d.class, str);
            int i2 = f447 + 61;
            f442 = i2 % 128;
            if (i2 % 2 != 0) {
                return dVar;
            }
            throw null;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static d[] valuesCustom() {
            f447 = (f442 + 91) % 128;
            d[] dVarArr = (d[]) values().clone();
            int i2 = f447 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
            f442 = i2 % 128;
            if (i2 % 2 != 0) {
                return dVarArr;
            }
            throw null;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m636(String str, int i2) {
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
                                char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f443)) ^ ((c8 >>> 5) + f445)));
                                cArr3[1] = c9;
                                cArr3[0] = (char) (c8 - (((c9 >>> 5) + f446) ^ ((c9 + i9) ^ ((c9 << 4) + f444))));
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

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static void m637() {
            f443 = (char) 53151;
            f446 = (char) 48610;
            f445 = (char) 36980;
            f444 = (char) 709;
        }
    }

    public au(JSONObject jSONObject) {
        this.f439 = m629(jSONObject.optString(m630((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 22892), 4 - ExpandableListView.getPackedPositionGroup(0L), TextUtils.getOffsetBefore("", 0)).intern()));
        this.f438 = m633(jSONObject.optString(m630((char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), View.resolveSize(0, 0) + 2, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 3).intern()));
        this.f440 = m631(jSONObject.optString(m630((char) (30947 - (ViewConfiguration.getLongPressTimeout() >> 16)), View.getDefaultSize(0, 0) + 6, View.combineMeasuredStates(0, 0) + 6).intern()));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ironsource.adqualitysdk.sdk.i.au.d m629(java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.au.m629(java.lang.String):com.ironsource.adqualitysdk.sdk.i.au$d");
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m631(String str) {
        f433 = (f435 + 7) % 128;
        if (!TextUtils.isEmpty(str)) {
            f433 = (f435 + 51) % 128;
            if (!str.equals(m630((char) ((-1) - TextUtils.lastIndexOf("", '0')), 4 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0', 0) + 18).intern())) {
                return str;
            }
        }
        f435 = (f433 + 43) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static List<String> m633(String str) {
        List<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            f433 = (f435 + 3) % 128;
            arrayList = Arrays.asList(str.split(m632(141 - View.MeasureSpec.getSize(0), 1 - View.resolveSize(0, 0), "\u0000", 1 - (ViewConfiguration.getFadingEdgeLength() >> 16), true).intern()));
        }
        f435 = (f433 + 53) % 128;
        return arrayList;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final boolean m634(String str) {
        int i2;
        try {
            i2 = AnonymousClass4.f441[this.f439.ordinal()];
        } catch (Exception e) {
            kd.m2919(m630((char) View.getDefaultSize(0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 22, 21 - Drawable.resolveOpacity(0, 0)).intern(), m630((char) View.combineMeasuredStates(0, 0), 23 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getPressedStateDuration() >> 16) + 43).intern(), e, false);
        }
        if (i2 == 1) {
            f435 = (f433 + 3) % 128;
            return true;
        }
        if (i2 == 2) {
            boolean zContains = this.f438.contains(str);
            int i8 = f433 + 115;
            f435 = i8 % 128;
            if (i8 % 2 != 0) {
                return zContains;
            }
            throw null;
        }
        if (i2 != 3) {
            if (i2 != 4) {
            }
            return false;
        }
        if (this.f438.size() > 0) {
            return ka.m2874(str, this.f438.get(0)) < 0;
        }
        if (this.f438.size() > 0) {
            if (ka.m2874(str, this.f438.get(0)) < 0) {
                f435 = (f433 + 87) % 128;
                return false;
            }
            int i9 = f435 + 49;
            f433 = i9 % 128;
            return i9 % 2 == 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m632(int i2, int i8, String str, int i9, boolean z2) {
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
                    cArr2[i11] = (char) (cArr2[i11] - f434);
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m635() {
        int i2 = f433;
        String str = this.f440;
        f435 = (i2 + 103) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m630(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f437[i8 + i9]) ^ (((long) i9) * f436)) ^ ((long) c7));
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
}
