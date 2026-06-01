package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.view.ViewCompat;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJAdUnit;
import com.tapjoy.TJAdUnitActivity;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TJCurrency;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementVideoListener;
import com.tapjoy.TJSplitWebView;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TJWebView;
import com.tapjoy.Tapjoy;
import com.tapjoy.mraid.view.ActionHandler;
import com.tapjoy.mraid.view.Browser;
import com.tapjoy.mraid.view.MraidView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ce extends bg {

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1269 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1270 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f1272 = 53080;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1274;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f1275;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static char[] f1271 = {'T', 15515, 31201, 46620, 62250, 12385, 27779, 43481, 59132, 8984, 24649, 40079, 55717, 5867, 21255, 36939, 52585, 'c', 15550, 31183, 46685, 62256, 12404, 27798, 43485, 59111, 8992, 24580, 40111, 55686, 5854, 21249, 36945, 52580, 2436, 18140, 33783, 49173, 64838, 14722, 30382, 46062, 61440, 11598, 27250, 'T', 15515, 31218, 46623, 62245, 12406, 27779, 43482, 59117, 9015, 24670, 40127, 55725, 5865, 21263, 'T', 15515, 31221, 46614, 62246, 12355, 27791, 43474, 59135, 'T', 15515, 31203, 46615, 62225, 12411, 27791, 43459, 'T', 15515, 31218, 46623, 62245, 12406, 27779, 43482, 59117, 9015, 24670, 40119, 55717, 5870, 21274, 36954, 52606, 2436, 18112, 'T', 15515, 31220, 46618, 62240, 12400, 27785, 43515, 59105, 9002, 24670, 40094, 55714, 5880, 21276, 33240, 48407, 63599, 14235, 29341, 45559, 60675, 10319, 26451, 41648, 57796, 7457, 22569, 38772, 53909, 4607, 19701, 34846, 51018, 618, 16822, 31948, 47112, 'T', 15515, 31203, 46615, 62225, 12411, 27791, 43459, 59074, 8970, 24680, 40073, 55717, 5881, 21257, 36954, 'T', 15515, 31203, 46596, 62245, 12391, 27778, 43508, 59133, 9003, 24664, 40094, 55714, 5886, 21271, 36979, 52601, 2450, 18118, 33766, 49210, 64832, 14724, 'c', 15550, 31183, 46685, 62256, 12404, 27798, 43485, 59111, 8992, 24580, 40111, 55686, 5838, 21278, 36947, 52601, 2453, 18149, 33766, 49206, 64883, 14751, 30370, 46063, 44027, 38696, 53834, 7615, 22708, 39912, 50969, 590, 19833, 34976, 52184, 14099, 29214, 48480, 63647, 15302, 'g', 15540, 31190, 46630, 62262, 12409, 'g', 15540, 31190, 46653, 62245, 12408, 27779, 52887, 62020, 46886, 30927, 15837, 65174, 41570, 26402, 10262, 60876, 44712, 'g', 15540, 31190, 46629, 62253, 12401, 27779, 43480, 59076, 9008, 24665, 40079, 55721, 5875, 21259, 36941, 28914, 19509, 2391, 50852, 33708, 16624, 7170, 55641, 38469, 21425, 4312, 60430, 43304, 26226, 9098, 57548, 'g', 15540, 31190, 46655, 62245, 12390, 27794, 43490, 59130, 9013};

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static long f1273 = 5513364116228488401L;

    public ce(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static TJPlacementVideoListener m1520(TJPlacement tJPlacement) {
        f1270 = (f1269 + 23) % 128;
        TJPlacementVideoListener videoListener = tJPlacement.getVideoListener();
        int i2 = f1269 + 25;
        f1270 = i2 % 128;
        if (i2 % 2 == 0) {
            return videoListener;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static String m1521(TJPlacementData tJPlacementData) {
        int i2 = f1270 + 19;
        f1269 = i2 % 128;
        int i8 = i2 % 2;
        String httpResponse = tJPlacementData.getHttpResponse();
        if (i8 == 0) {
            int i9 = 90 / 0;
        }
        int i10 = f1270 + 31;
        f1269 = i10 % 128;
        if (i10 % 2 != 0) {
            return httpResponse;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ TJPlacementListener m1522(TJPlacement tJPlacement) {
        int i2 = f1269 + 77;
        f1270 = i2 % 128;
        if (i2 % 2 != 0) {
            m1535(tJPlacement);
            throw null;
        }
        TJPlacementListener tJPlacementListenerM1535 = m1535(tJPlacement);
        int i8 = f1270 + 67;
        f1269 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 48 / 0;
        }
        return tJPlacementListenerM1535;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ TJPlacementVideoListener m1524(TJPlacement tJPlacement) {
        f1270 = (f1269 + 27) % 128;
        TJPlacementVideoListener tJPlacementVideoListenerM1520 = m1520(tJPlacement);
        f1270 = (f1269 + 65) % 128;
        return tJPlacementVideoListenerM1520;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1526(TJPlacement tJPlacement) {
        f1270 = (f1269 + 61) % 128;
        String strM1531 = m1531(tJPlacement);
        f1270 = (f1269 + 53) % 128;
        return strM1531;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1532(TJPlacementData tJPlacementData) {
        int i2 = f1269 + 95;
        f1270 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1521(tJPlacementData);
        }
        m1521(tJPlacementData);
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m1537(TJPlacement tJPlacement, TJPlacementVideoListener tJPlacementVideoListener) {
        int i2 = f1269 + 75;
        f1270 = i2 % 128;
        int i8 = i2 % 2;
        m1529(tJPlacement, tJPlacementVideoListener);
        if (i8 != 0) {
            throw null;
        }
        f1269 = (f1270 + 5) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1525(TJPlacementData tJPlacementData) {
        f1269 = (f1270 + 93) % 128;
        String strM1523 = m1523(tJPlacementData);
        int i2 = f1269 + 71;
        f1270 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 34 / 0;
        }
        return strM1523;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1527(TJPlacementData tJPlacementData) {
        int i2 = f1269 + 107;
        f1270 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1536(tJPlacementData);
        }
        m1536(tJPlacementData);
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1533(TJSplitWebView tJSplitWebView) {
        f1269 = (f1270 + 111) % 128;
        String strM1528 = m1528(tJSplitWebView);
        f1270 = (f1269 + 17) % 128;
        return strM1528;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1536(TJPlacementData tJPlacementData) {
        f1270 = (f1269 + 47) % 128;
        String placementName = tJPlacementData.getPlacementName();
        f1269 = (f1270 + 53) % 128;
        return placementName;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        String version;
        int i2 = f1270 + 11;
        f1269 = i2 % 128;
        if (i2 % 2 == 0) {
            version = Tapjoy.getVersion();
            int i8 = 54 / 0;
        } else {
            version = Tapjoy.getVersion();
        }
        int i9 = f1269 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1270 = i9 % 128;
        if (i9 % 2 == 0) {
            return version;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1523(TJPlacementData tJPlacementData) {
        f1270 = (f1269 + 91) % 128;
        String url = tJPlacementData.getUrl();
        int i2 = f1269 + 61;
        f1270 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 75 / 0;
        }
        return url;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m1529(TJPlacement tJPlacement, TJPlacementVideoListener tJPlacementVideoListener) {
        int i2 = f1270 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1269 = i2 % 128;
        int i8 = i2 % 2;
        tJPlacement.setVideoListener(tJPlacementVideoListener);
        if (i8 == 0) {
            throw null;
        }
        f1270 = (f1269 + 31) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static TJPlacementListener m1535(TJPlacement tJPlacement) {
        f1270 = (f1269 + 75) % 128;
        TJPlacementListener listener = tJPlacement.getListener();
        f1269 = (f1270 + 9) % 128;
        return listener;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        byte b8;
        f1270 = (f1269 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        switch (str.hashCode()) {
            case -1983375197:
                b8 = !str.equals(m1534("咍❜娭芳", (char) (45914 - (ViewConfiguration.getWindowTouchSlop() >> 8)), "윙毼䳠첮蟌へ\uee30\ue5b3\uebf1躽চꛀꗐ\ue998\uea67", (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 757554259, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 22;
                break;
            case -1687314074:
                if (!str.equals(m1534("⪱좦糦\uf2a8", (char) (43132 - TextUtils.getOffsetAfter("", 0)), "ᑖ插행뤘胞贔ꃝ壌\u2068컕爸ꇢ␘\u13fe\udd63⬕짇▢Ἦ\uf2d7\ud886詆덗鮟焤䷻蹑㈁ᄘ", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 423057879, "\u0000\u0000\u0000\u0000").intern())) {
                    b8 = -1;
                } else {
                    int i2 = f1270 + 95;
                    f1269 = i2 % 128;
                    b8 = i2 % 2 != 0 ? (byte) 8 : (byte) 82;
                }
                break;
            case -1640254126:
                b8 = !str.equals(m1530((char) TextUtils.indexOf("", ""), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 16, TextUtils.lastIndexOf("", '0', 0) + 1).intern()) ? (byte) -1 : (byte) 2;
                break;
            case -1628534628:
                b8 = !str.equals(m1534("劔ﲡ彦롤", (char) KeyEvent.getDeadChar(0, 0), "暱춖秗翹杺㪆ᶿẔᅩ", ExpandableListView.getPackedPositionType(0L) + 1727832402, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 9;
                break;
            case -1429063965:
                if (!str.equals(m1530((char) TextUtils.indexOf("", ""), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 19, 76 - Process.getGidForName("")).intern())) {
                    b8 = -1;
                } else {
                    f1269 = (f1270 + 25) % 128;
                    b8 = 14;
                }
                break;
            case -1414965228:
                if (!str.equals(m1534("䩪\ue995\ue04a녜", (char) (23776 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), "\uf68e愴揩Ữ装ﮱ贎ꏑྔ鐭쑼⺴햮", (ViewConfiguration.getWindowTouchSlop() >> 8) + 1256822090, "\u0000\u0000\u0000\u0000").intern())) {
                    b8 = -1;
                } else {
                    f1270 = (f1269 + 13) % 128;
                    b8 = 5;
                }
                break;
            case -1147119309:
                b8 = !str.equals(m1534("﮴\ud952푸瞫", (char) ((-1) - Process.getGidForName("")), "鮺癩Ꝺ娋ꄯぐ籡ꅕꢕ쌍槵肗ᎋ乇\ueeb6\ue45b\ue737뺋鉼ڞ", 1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 12;
                break;
            case -872754855:
                b8 = !str.equals(m1530((char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), 15 - (ViewConfiguration.getFadingEdgeLength() >> 16), KeyEvent.getDeadChar(0, 0) + 45).intern()) ? (byte) -1 : (byte) 4;
                break;
            case -721136035:
                b8 = !str.equals(m1530((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 7, 69 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern()) ? (byte) -1 : (byte) 13;
                break;
            case -668579974:
                b8 = !str.equals(m1534("\ue3ff쌂狲䙑", (char) (20851 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), "㍇ꄦ큶䁆븨㶫䠧嗀꼥嗊戗惪椬\ue6aaҧ\uf37aʮ㨔ꈝ圊簟藛䒸徼鑅ᡗ７娡滽鉯\uddf9", (-222100765) - (ViewConfiguration.getWindowTouchSlop() >> 8), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 10;
                break;
            case -593336436:
                if (!str.equals(m1530((char) (ViewCompat.MEASURED_STATE_MASK - Color.rgb(0, 0, 0)), 23 - TextUtils.getOffsetAfter("", 0), 150 - (ViewConfiguration.getPressedStateDuration() >> 16)).intern())) {
                    b8 = -1;
                } else {
                    f1270 = (f1269 + 13) % 128;
                    b8 = 23;
                }
                break;
            case -217417742:
                b8 = !str.equals(m1534("뷚渃稕龼", (char) TextUtils.indexOf("", ""), "苊䔢貔段웥尃☲牑ᕚ㴌\ue5c1眗얁斘ᄀ䩼ዜ䆀帄嵞擪ᖸ럣廾㔹㹣犾긐倬馁悸孛ꓯ鉕㙩", Color.red(0) + 359531453, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 6;
                break;
            case 178410181:
                if (!str.equals(m1530((char) (Process.myTid() >> 22), 25 - TextUtils.indexOf("", ""), 173 - TextUtils.getCapsMode("", 0, 0)).intern())) {
                    b8 = -1;
                } else {
                    int i8 = f1270 + 65;
                    f1269 = i8 % 128;
                    b8 = i8 % 2 != 0 ? (byte) 25 : (byte) 107;
                }
                break;
            case 206635148:
                b8 = !str.equals(m1534("➙ρ夳\ua4cc", (char) (52312 - MotionEvent.axisFromString("")), "ꔾ흦祝똜봘㦌潜Ӵ䡈糺\udfee櫢\uecfe줹ٽ풾", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 0;
                break;
            case 268330895:
                b8 = !str.equals(m1530((char) TextUtils.getOffsetBefore("", 0), 16 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + Sdk.SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE).intern()) ? (byte) -1 : (byte) 19;
                break;
            case 327820672:
                b8 = !str.equals(m1534("㹅ᜮਸ煓", (char) (ImageFormat.getBitsPerPixel(0) + 1), "몐爻\uea48若㺾짫ᵊᇺ᪢襟ꄙ喤黐呭\uf417⻄\u0bfb眄평䘀鵗ή\u1ae7퇶", (-1) - TextUtils.indexOf((CharSequence) "", '0'), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 18;
                break;
            case 705136807:
                b8 = !str.equals(m1534("㯎譋俖鎚", (char) View.getDefaultSize(0, 0), "ꂓᖆ拱；⬸姳햘\uf21aꏄ\u05ce", Process.myPid() >> 22, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 20;
                break;
            case 741045788:
                b8 = !str.equals(m1534("⼷緆橒\ue923", (char) (9066 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), "ⴊ\uedb3렉쵓䞫궂\ue83b驠ꛡ䀹纨厀\uf4bcὟ᪃Ɩ읁蘂㯵被炁\ue339袣ꢏ튂䟃䍭", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 1383974446, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 1;
                break;
            case 832039888:
                b8 = !str.equals(m1530((char) (ExpandableListView.getPackedPositionGroup(0L) + 33164), 22 - ImageFormat.getBitsPerPixel(0), 111 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern()) ? (byte) -1 : (byte) 16;
                break;
            case 906946425:
                b8 = !str.equals(m1530((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15, (ViewConfiguration.getJumpTapTimeout() >> 16) + 96).intern()) ? (byte) -1 : (byte) 15;
                break;
            case 1317517621:
                b8 = !str.equals(m1534("튬哪鑮࢟", (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 40852), "\ude91埯밠趭逸賕₷릤쾯諭悲鑕\uf522쩢", TextUtils.getOffsetAfter("", 0), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 24;
                break;
            case 1504750787:
                b8 = !str.equals(m1530((char) Color.blue(0), (ViewConfiguration.getLongPressTimeout() >> 16) + 9, TextUtils.lastIndexOf("", '0') + 61).intern()) ? (byte) -1 : (byte) 11;
                break;
            case 1519750415:
                b8 = !str.equals(m1534("ᨠ況뀐ㄪ", (char) (MotionEvent.axisFromString("") + 1), "糩帷컙≔ࠛ냝괅낛瑍ꪵ䂰", 275562777 - TextUtils.lastIndexOf("", '0'), "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 21;
                break;
            case 1815593736:
                b8 = !str.equals(m1534("鍨껸\uf821\ue4d9", (char) ExpandableListView.getPackedPositionGroup(0L), "룁刁2故壚笋闽", TextUtils.indexOf("", "", 0) + 565115027, "\u0000\u0000\u0000\u0000").intern()) ? (byte) -1 : (byte) 7;
                break;
            case 1891461874:
                if (!str.equals(m1534("❱ㅯ\ue54b\ue99a", (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), "臊ꪲ\uf29dቩӸ赴⦐\ue183冡芴唈謒唰넘뢾쮯ඳ憚遐훱現", AndroidCharacter.getMirror('0') + 28407, "\u0000\u0000\u0000\u0000").intern())) {
                    b8 = -1;
                } else {
                    f1270 = (f1269 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                    b8 = 17;
                }
                break;
            case 2041573826:
                b8 = !str.equals(m1530((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), Color.blue(0) + 28, ImageFormat.getBitsPerPixel(0) + 18).intern()) ? (byte) -1 : (byte) 3;
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
            case 1:
                return TJAdUnitActivity.class;
            case 2:
            case 3:
                return TJContentActivity.class;
            case 4:
                return TJPlacementData.class;
            case 5:
            case 6:
                return ActionHandler.class;
            case 7:
            case 8:
                return Browser.class;
            case 9:
            case 10:
                return MraidView.class;
            case 11:
            case 12:
                return TJWebView.class;
            case 13:
                return TJAdUnit.class;
            case 14:
                return TJPlacementListener.class;
            case 15:
                return TJVideoListener.class;
            case 16:
                return TJAdUnit.TJAdUnitWebViewListener.class;
            case 17:
                return TJAdUnit.TJAdUnitVideoListener.class;
            case 18:
                return TJPlacementVideoListener.class;
            case 19:
                return TJAdUnitJSBridge.class;
            case 20:
                return TJCurrency.class;
            case 21:
                return TJPlacement.class;
            case 22:
                return TJActionRequest.class;
            case 23:
                return TJAwardCurrencyListener.class;
            case 24:
            case 25:
                return TJSplitWebView.class;
            default:
                return null;
        }
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1530((char) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 43932), 16 - TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 198).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1527((TJPlacementData) list.get(0));
            }
        });
        map.put(m1530((char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 6, (ViewConfiguration.getLongPressTimeout() >> 16) + Sdk.SDKError.Reason.INVALID_GZIP_BID_PAYLOAD_VALUE).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1525((TJPlacementData) list.get(0));
            }
        });
        map.put(m1534("곌鐎ﮂ㛧", (char) ((Process.myTid() >> 22) + 59387), "채떫䲕튱ٛ왲춤ȓ\uf021⦪ጇɹ魰썪ཪ", (-2104226133) - ImageFormat.getBitsPerPixel(0), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1532((TJPlacementData) list.get(0));
            }
        });
        map.put(m1530((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 7, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + Sdk.SDKError.Reason.MRAID_JS_COPY_FAILED_VALUE).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1526((TJPlacement) list.get(0));
            }
        });
        map.put(m1530((char) ((ViewConfiguration.getTapTimeout() >> 16) + 52976), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 11, Process.getGidForName("") + 228).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1522((TJPlacement) list.get(0));
            }
        });
        map.put(m1530((char) View.MeasureSpec.makeMeasureSpec(0, 0), View.resolveSize(0, 0) + 16, Process.getGidForName("") + 239).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1524((TJPlacement) list.get(0));
            }
        });
        map.put(m1530((char) (28801 - ExpandableListView.getPackedPositionType(0L)), 16 - TextUtils.indexOf("", ""), 254 - Gravity.getAbsoluteGravity(0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                ce.m1537((TJPlacement) list.get(0), (TJPlacementVideoListener) list.get(1));
                return null;
            }
        });
        map.put(m1530((char) (AndroidCharacter.getMirror('0') - '0'), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 9, 270 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.ce.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return ce.m1533((TJSplitWebView) list.get(0));
            }
        });
        int i2 = f1270 + 91;
        f1269 = i2 % 128;
        if (i2 % 2 != 0) {
            return map;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1528(TJSplitWebView tJSplitWebView) {
        int i2 = f1269 + 87;
        f1270 = i2 % 128;
        if (i2 % 2 != 0) {
            tJSplitWebView.getLastUrl();
            throw null;
        }
        String lastUrl = tJSplitWebView.getLastUrl();
        f1270 = (f1269 + 49) % 128;
        return lastUrl;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1531(TJPlacement tJPlacement) {
        int i2 = f1270 + 27;
        f1269 = i2 % 128;
        int i8 = i2 % 2;
        String name = tJPlacement.getName();
        if (i8 == 0) {
            int i9 = 59 / 0;
        }
        return name;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1534(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1275) ^ ((long) f1274)) ^ ((long) f1272));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1530(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f1271[i8 + i9]) ^ (((long) i9) * f1273)) ^ ((long) c7));
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
