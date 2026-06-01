package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ax {

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f595 = 0;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f597 = 1;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f598 = 11;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f600 = 1251088553;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f601 = -352306575;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static short[] f602;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private JSONObject f605;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private JSONObject f606;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private final List<String> f607;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static byte[] f599 = {9, -73, 18, -4, -13, 20, -3, -18, 73, -54, -5, -6, -3, 14, -10, 13, 51, -63, -2, 12, 30, 5, 11, -13, 13, -11, 17, 34, -35, 35, -40, 7, -13, 34, -33, 37, 27, -57, -7, 5, -9, 13, 1, -10, 9, -13, 68, -69, 15, 3, 51, -59, 7, -13, 2, -1, 5, 59, -63, -2, 12, 36, 5, 11, -13, 13, -11, 17, 34, -43, 11, -8, -11, 11, -11, 1, 1, 13, -15, 6, 37, 27, -59, -12, 71, -62, 11, -8, -11, 11, -11, 1, 1, 13, -15, 6, 5, 59, -55, -2, 6, -18, 14, -13, 2, 66, -65, 6, -8, 13, -6, -8, 4, 15, -9, -6, -2, 8, 2, -1, -3, 2, 2, -17, -2, -8, -8, 19, -7, -3, -14, 16};

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static char f594 = 6;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static char[] f596 = {'a', 'n', 'd', 'r', 'o', 'i', '.', 'w', 'e', 'b', 'k', 't', 'c', 'm', 'g', 'I', 'M', 'A', 'v', 'y', 'p', 's', 'l', 'f', 'x', '7', '0', 'h', 'j', 'q', 'u', 'z', '{', '|', '}', '~'};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private final List<String> f604 = Arrays.asList(m725((Process.myTid() >> 22) - 12, (short) (ViewConfiguration.getMinimumFlingVelocity() >> 16), 352306575 - View.MeasureSpec.getSize(0), (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) - 1251088454).intern(), m728(Color.blue(0) + 15, (byte) (View.getDefaultSize(0, 0) + 20), "\u0001\u0002\u0003\u0004\u0005\u0000\u0000\b\b\t\n\u000b\u000b\u0011B").intern(), "");

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private final List<String> f603 = new ArrayList();

    public ax() {
        List<String> listAsList = Arrays.asList(m728((-16777179) - Color.rgb(0, 0, 0), (byte) (Color.alpha(0) + 61), "\u0010\u0000\f\u0007\u0000\u0002\u0010\u0001\u000b\u0003\t\u0000\u0007\u0002\b\u000e\u0004\u0000\u0002\r\t\f\u0004\r\u0003\n\u000b\u0017\u0005\u000e\u0011\u0006\u0000\u0017\u000b\u0011¶").intern(), m725((-12) - KeyEvent.keyCodeFromString(""), (short) (ViewConfiguration.getTapTimeout() >> 16), 352306595 - TextUtils.indexOf("", "", 0), (byte) ExpandableListView.getPackedPositionGroup(0L), (-1251088454) - TextUtils.getOffsetAfter("", 0)).intern(), m728((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 44, (byte) (77 - TextUtils.indexOf((CharSequence) "", '0')), "\u0000\u0005\b\u0012\u0002\t\u0012\u0003\u0014\u000e\u000b\u0000\u0005\u0007\t\u0002\u0017\t\u000b\u0011\u0000\u0001\u0012\n\r\u0003\u0006\t\t\u001b\u0011\u000b\u0011\u000b\u0004\u0012\f\r\u0011\u000b\u0017\u0000\u0007\u0017").intern(), m725((-12) - (ViewConfiguration.getDoubleTapTimeout() >> 16), (short) (ViewConfiguration.getFadingEdgeLength() >> 16), 352306636 - Color.blue(0), (byte) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) - 1251088447).intern());
        this.f607 = listAsList;
        m728(TextUtils.indexOf("", "", 0, 0) + 3, (byte) ((KeyEvent.getMaxKeyCode() >> 16) + 93), "\u0006\u0013Í").intern();
        m728(4 - Color.green(0), (byte) (26 - (ViewConfiguration.getPressedStateDuration() >> 16)), "\u0006\u0013\u0014\u0003").intern();
        m725((-12) - View.resolveSizeAndState(0, 0, 0), (short) TextUtils.indexOf("", ""), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 352306682, (byte) View.resolveSizeAndState(0, 0, 0), (-1251088448) - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern();
        m728(4 - ExpandableListView.getPackedPositionType(0L), (byte) (View.MeasureSpec.getMode(0) + 96), "\u0000\u0011\u0014\u0003").intern();
        m728(2 - TextUtils.indexOf((CharSequence) "", '0'), (byte) (TextUtils.getOffsetBefore("", 0) + Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), "\u001d\u0011ò").intern();
        m725((-12) - View.resolveSizeAndState(0, 0, 0), (short) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 352306686 - (ViewConfiguration.getWindowTouchSlop() >> 8), (byte) (Process.myPid() >> 22), (-1251088452) - (Process.myTid() >> 22)).intern();
        m728((ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (byte) (100 - TextUtils.getTrimmedLength("")), "\u0000\u0001\u0017\b").intern();
        this.f605 = new JSONObject();
        this.f606 = new JSONObject();
        try {
            Iterator<String> it = listAsList.iterator();
            while (it.hasNext()) {
                this.f606.put(it.next(), m725(TextUtils.lastIndexOf("", '0', 0, 0) - 11, (short) (ViewConfiguration.getKeyRepeatDelay() >> 16), KeyEvent.normalizeMetaState(0) + 352306689, (byte) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), (KeyEvent.getMaxKeyCode() >> 16) - 1251088439).intern());
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m726(ax axVar, String str) {
        f595 = (f597 + 111) % 128;
        axVar.m727(str);
        f595 = (f597 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m727(String str) {
        f595 = (f597 + 59) % 128;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.f605 = new JSONObject(str);
                return;
            } catch (JSONException unused) {
            }
        }
        int i2 = f597 + 91;
        f595 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final List<String> m729() {
        List<String> listM2901 = kc.m2901(this.f605, m725((-12) - TextUtils.indexOf("", ""), (short) (TextUtils.lastIndexOf("", '0', 0) + 1), TextUtils.indexOf("", "", 0) + 352306686, (byte) (ViewConfiguration.getEdgeSlop() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0) - 1251088451).intern(), new ArrayList());
        f595 = (f597 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        return listM2901;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final int m730() {
        f597 = (f595 + 89) % 128;
        int iOptInt = this.f605.optInt(m728((ViewConfiguration.getFadingEdgeLength() >> 16) + 4, (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 102), "\r\u000e\u0004\u0003").intern(), 3000);
        int i2 = f595 + 49;
        f597 = i2 % 128;
        if (i2 % 2 != 0) {
            return iOptInt;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final String m731() {
        f597 = (f595 + 81) % 128;
        String strOptString = this.f605.optString(m728(Gravity.getAbsoluteGravity(0, 0) + 4, (byte) (View.resolveSizeAndState(0, 0, 0) + 21), "\u0005\b\u0005\b").intern(), m725((-11) - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (short) (ViewConfiguration.getScrollBarSize() >> 8), 352306700 - View.getDefaultSize(0, 0), (byte) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (-1251088455) - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern());
        f595 = (f597 + 109) % 128;
        return strOptString;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final JSONObject m732() {
        f595 = (f597 + 45) % 128;
        JSONObject jSONObjectOptJSONObject = this.f605.optJSONObject(m725((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 13, (short) View.MeasureSpec.makeMeasureSpec(0, 0), 352306703 - Color.argb(0, 0, 0, 0), (byte) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (-1251088454) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern());
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        f595 = (f597 + 91) % 128;
        return this.f606;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final int m733() {
        f595 = (f597 + 79) % 128;
        int iOptInt = this.f605.optInt(m728((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 3, (byte) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 25), "\u0006\u0013\u0014\u0003").intern(), 7);
        f597 = (f595 + 5) % 128;
        return iOptInt;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final List<String> m736() {
        JSONObject jSONObject;
        int iIndexOf;
        int iRed;
        int i2 = f595 + 59;
        f597 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObject = this.f605;
            iIndexOf = 3 << TextUtils.indexOf("", "", 1);
            iRed = 4 << Color.red(0);
        } else {
            jSONObject = this.f605;
            iIndexOf = 3 - TextUtils.indexOf("", "", 0);
            iRed = Color.red(0) + 93;
        }
        List<String> listM2901 = kc.m2901(jSONObject, m728(iIndexOf, (byte) iRed, "\u0006\u0013Í").intern(), this.f604);
        int i8 = f597 + 25;
        f595 = i8 % 128;
        if (i8 % 2 == 0) {
            return listM2901;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final void m738(iw iwVar) {
        m727(iwVar.m2586(m725((ViewConfiguration.getMinimumFlingVelocity() >> 16) - 12, (short) View.MeasureSpec.makeMeasureSpec(0, 0), Color.green(0) + 352306691, (byte) Color.blue(0), (-1251088438) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), m728((ViewConfiguration.getEdgeSlop() >> 16) + 3, (byte) (90 - (ViewConfiguration.getTouchSlop() >> 8)), "\u0018\u0007\u008a").intern(), new il() { // from class: com.ironsource.adqualitysdk.sdk.i.ax.3
            @Override // com.ironsource.adqualitysdk.sdk.i.il
            /* JADX INFO: renamed from: ﻐ */
            public final void mo724(String str) {
                ax.m726(ax.this, str);
            }
        }));
        f597 = (f595 + 21) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m728(int i2, byte b8, String str) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (h.f2264) {
            try {
                char[] cArr2 = f596;
                char c7 = f594;
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final List<String> m734() {
        List<String> listM2901 = kc.m2901(this.f605, m728(3 - Color.green(0), (byte) (122 - View.MeasureSpec.getMode(0)), "\u001d\u0011ò").intern(), new ArrayList());
        int i2 = f595 + 81;
        f597 = i2 % 128;
        if (i2 % 2 != 0) {
            return listM2901;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m725(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f598;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f599;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f601 + i8] + i10);
                    } else {
                        i11 = (short) (f602[f601 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f601 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f600);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f599;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f602;
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

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final int m737() {
        int i2 = f597 + 83;
        f595 = i2 % 128;
        int iOptInt = i2 % 2 != 0 ? this.f605.optInt(m728(2 << (Process.myTid() >> 108), (byte) (KeyEvent.getDeadChar(1, 0) + 62), "\u0000\u0011\u0014\u0003").intern(), 4) : this.f605.optInt(m728((Process.myTid() >> 22) + 4, (byte) (96 - KeyEvent.getDeadChar(0, 0)), "\u0000\u0011\u0014\u0003").intern(), 2);
        int i8 = f597 + 29;
        f595 = i8 % 128;
        if (i8 % 2 == 0) {
            return iOptInt;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final List<String> m735() {
        f597 = (f595 + 67) % 128;
        List<String> listM2901 = kc.m2901(this.f605, m725((-12) - View.MeasureSpec.getMode(0), (short) (ViewConfiguration.getJumpTapTimeout() >> 16), 352306682 - TextUtils.lastIndexOf("", '0', 0), (byte) Color.blue(0), Process.getGidForName("") - 1251088447).intern(), this.f603);
        f595 = (f597 + 83) % 128;
        return listM2901;
    }
}
