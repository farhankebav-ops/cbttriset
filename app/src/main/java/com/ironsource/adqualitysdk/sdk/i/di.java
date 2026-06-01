package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class di extends da implements ci {

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static short[] f1735 = null;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f1736 = 0;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f1737 = 1;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static byte[] f1738 = {-38, 61, -63, 33, 46, 1, -16, 47, -46, 8, -17, 27, -7, 1, -9, -47, 32, -3, 12, -24, 15, -30, 16, -29, -17, 20, 14, -3, 18, 17, 126, -115, -127, 122, 96, -109, 103, -85, 113, -114, 118, -119, 126, 113, -109, 110, 95, -79, 115, -126, 123, -120, -124, 127, 101, -106, 98, -82, 116, -117, 115, -116, 123, 116, -106, 107, 90, -76, 118, -117, -61, 48, 60, -57, -35, 38, 59, -36, 32, -64, -49, -32, 17, -50, 63, 97, -110, -98, 101, 127, -124, -103, 126, -109, 97, -110, -98, 101, 127, -68, 108, -99, 12, -1, -13, 8, 18, -23, -12, 19, -2, 12, -1, -13, 8, 18, -47, 1, -4, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static long f1739 = -8993914270937839447L;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1740 = -733435483;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1741 = 71;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1742 = 197925965;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String f1744;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private hi f1745;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String f1746;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String f1748;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private final JSONObject f1747 = new JSONObject();

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private final List<String> f1743 = new ArrayList();

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private JSONObject m1959() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f1744;
            if (str != null && this.f1745 != null) {
                f1737 = (f1736 + 95) % 128;
                jSONObject.putOpt(ig.f2516, str);
                jSONObject.putOpt(ig.f2515, Integer.valueOf(this.f1745.m2298()));
            }
            jSONObject.putOpt(ig.f2512, this.f1748);
            jSONObject.putOpt(ig.f2510, this.f1746);
            if (this.f1743.size() > 0) {
                jSONObject.putOpt(ig.f2504, new JSONArray((Collection) this.f1743));
                f1736 = (f1737 + 27) % 128;
            }
            if (this.f1747.length() > 0) {
                int i2 = f1737 + 57;
                f1736 = i2 % 128;
                if (i2 % 2 != 0) {
                    jSONObject.putOpt(ig.f2517, this.f1747.toString());
                    throw null;
                }
                jSONObject.putOpt(ig.f2517, this.f1747.toString());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object m1960() {
        /*
            r3 = this;
            int r0 = com.ironsource.adqualitysdk.sdk.i.di.f1736
            int r0 = r0 + 69
            int r1 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.di.f1737 = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L62
            java.lang.String r0 = r3.f1744
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L54
            int r0 = com.ironsource.adqualitysdk.sdk.i.di.f1736
            int r0 = r0 + 97
            int r2 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.di.f1737 = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L4e
            java.lang.String r0 = r3.f1748
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L54
            java.lang.String r0 = r3.f1746
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L54
            int r0 = com.ironsource.adqualitysdk.sdk.i.di.f1736
            int r0 = r0 + 37
            int r2 = r0 % 128
            com.ironsource.adqualitysdk.sdk.i.di.f1737 = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L48
            java.util.List<java.lang.String> r0 = r3.f1743
            int r0 = r0.size()
            if (r0 <= 0) goto L46
            goto L54
        L46:
            r0 = 0
            goto L55
        L48:
            java.util.List<java.lang.String> r0 = r3.f1743
            r0.size()
            throw r1
        L4e:
            java.lang.String r0 = r3.f1748
            android.text.TextUtils.isEmpty(r0)
            throw r1
        L54:
            r0 = 1
        L55:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            int r1 = com.ironsource.adqualitysdk.sdk.i.di.f1736
            int r1 = r1 + 33
            int r1 = r1 % 128
            com.ironsource.adqualitysdk.sdk.i.di.f1737 = r1
            return r0
        L62:
            java.lang.String r0 = r3.f1744
            android.text.TextUtils.isEmpty(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.di.m1960():java.lang.Object");
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private String m1961() {
        int i2 = f1737 + 29;
        f1736 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1747.optString(ig.f2516);
        }
        this.f1747.optString(ig.f2516);
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private void m1963(String str) {
        int i2 = f1736 + 77;
        f1737 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f1747.put(ig.f2510, str);
            } else {
                this.f1747.put(ig.f2510, str);
                int i8 = 57 / 0;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private String m1964() {
        f1737 = (f1736 + 115) % 128;
        String strOptString = this.f1747.optString(ig.f2512);
        int i2 = f1737 + 3;
        f1736 = i2 % 128;
        if (i2 % 2 == 0) {
            return strOptString;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private void m1967(String str) {
        int i2 = f1737 + 31;
        f1736 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f1747.put(ig.f2512, str);
                int i8 = 45 / 0;
            } else {
                this.f1747.put(ig.f2512, str);
            }
            int i9 = f1737 + 3;
            f1736 = i9 % 128;
            if (i9 % 2 != 0) {
                int i10 = 94 / 0;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private String m1968() {
        f1737 = (f1736 + 15) % 128;
        String strOptString = this.f1747.optString(ig.f2504);
        f1736 = (f1737 + 37) % 128;
        return strOptString;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private String m1969() {
        String str;
        int i2 = f1736 + 15;
        int i8 = i2 % 128;
        f1737 = i8;
        if (i2 % 2 == 0) {
            str = this.f1748;
            int i9 = 64 / 0;
        } else {
            str = this.f1748;
        }
        int i10 = i8 + 11;
        f1736 = i10 % 128;
        if (i10 % 2 == 0) {
            return str;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private List<String> m1972() {
        int i2 = f1737 + 19;
        int i8 = i2 % 128;
        f1736 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        List<String> list = this.f1743;
        int i9 = i8 + 13;
        f1737 = i9 % 128;
        if (i9 % 2 != 0) {
            return list;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private String m1974() {
        int i2 = f1736;
        int i8 = i2 + 89;
        f1737 = i8 % 128;
        if (i8 % 2 == 0) {
            throw null;
        }
        String str = this.f1744;
        f1737 = (i2 + 3) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private hi m1978() {
        hi hiVar;
        int i2 = f1737 + 97;
        int i8 = i2 % 128;
        f1736 = i8;
        if (i2 % 2 != 0) {
            hiVar = this.f1745;
            int i9 = 54 / 0;
        } else {
            hiVar = this.f1745;
        }
        f1737 = (i8 + 65) % 128;
        return hiVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private void m1982(String str) {
        int i2 = f1736;
        int i8 = i2 + 11;
        f1737 = i8 % 128;
        int i9 = i8 % 2;
        this.f1744 = str;
        if (i9 == 0) {
            throw null;
        }
        int i10 = i2 + 51;
        f1737 = i10 % 128;
        if (i10 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private void m1965(String str) {
        int i2 = f1737 + 37;
        f1736 = i2 % 128;
        try {
            if (i2 % 2 != 0) {
                this.f1747.put(ig.f2504, str);
                throw null;
            }
            this.f1747.put(ig.f2504, str);
            int i8 = f1736 + 5;
            f1737 = i8 % 128;
            if (i8 % 2 == 0) {
                int i9 = 95 / 0;
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private void m1970(String str) {
        int i2 = f1736;
        this.f1748 = str;
        f1737 = (i2 + 47) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private void m1973(String str) {
        if (!TextUtils.isEmpty(str) && !this.f1743.contains(str)) {
            this.f1743.add(str);
            f1737 = (f1736 + 77) % 128;
        }
        f1736 = (f1737 + 37) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m1975(hi hiVar) {
        int i2 = f1736 + 107;
        int i8 = i2 % 128;
        f1737 = i8;
        int i9 = i2 % 2;
        this.f1745 = hiVar;
        if (i9 == 0) {
            throw null;
        }
        int i10 = i8 + 21;
        f1736 = i10 % 128;
        if (i10 % 2 != 0) {
            int i11 = 33 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private void m1980(String str) {
        int i2 = f1736 + 105;
        f1737 = i2 % 128;
        int i8 = i2 % 2;
        this.f1746 = str;
        if (i8 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private String m1981() {
        String str;
        int i2 = f1736;
        int i8 = i2 + 95;
        f1737 = i8 % 128;
        if (i8 % 2 == 0) {
            str = this.f1746;
            int i9 = 2 / 0;
        } else {
            str = this.f1746;
        }
        f1737 = (i2 + 39) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m1977(List<String> list) {
        f1736 = (f1737 + 21) % 128;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            int i2 = f1737 + 103;
            f1736 = i2 % 128;
            if (i2 % 2 != 0) {
                m1973(it.next());
                throw null;
            }
            m1973(it.next());
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1979(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f1739, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f1739));
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.ironsource.adqualitysdk.sdk.i.ci
    /* JADX INFO: renamed from: ﾒ */
    public final Object mo886(String str, List<Object> list, ch chVar) {
        byte b8;
        switch (str.hashCode()) {
            case -2118395364:
                b8 = !str.equals(m1979("揬掋쵎얂瞯暉슨\udb12䄬\ueeb9唚\ue7ff⛐蠚だ萴Ѳ땞ΐ", -((byte) KeyEvent.getModifierMetaStateMask())).intern()) ? (byte) -1 : (byte) 0;
                break;
            case -1836320845:
                b8 = !str.equals(m1971((-59) - View.combineMeasuredStates(0, 0), (short) View.combineMeasuredStates(0, 0), (ViewConfiguration.getPressedStateDuration() >> 16) + 733435502, (byte) (17 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0) - 197925867).intern()) ? (byte) -1 : (byte) 9;
                break;
            case -1700761801:
                if (!str.equals(m1979("\uf0c6\uf0a1ᣦဪ랿ꚙﱔ\ue5eb툇㬔锛\ud921뗼嶷", (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1).intern())) {
                    b8 = -1;
                } else {
                    f1737 = (f1736 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                    b8 = 4;
                }
                break;
            case -1409157227:
                b8 = 8;
                if (!str.equals(m1979("꼃꽤뵳떿ᶦಀ྅ᘭ跈麇㼄⫑\uea2e\uf81b婨䤂좜", (ViewConfiguration.getTouchSlop() >> 8) + 1).intern())) {
                    b8 = -1;
                }
                break;
            case -1296571754:
                if (!str.equals(m1979("䡇䠴㞑㽝艤鍂\ueff5\uf648檊ᑾꃕ쪻൚狞어\ua958⿄侽\uea0e矌슲", -TextUtils.lastIndexOf("", '0', 0, 0)).intern())) {
                    b8 = -1;
                } else {
                    f1736 = (f1737 + 75) % 128;
                    b8 = 16;
                }
                break;
            case -1247838300:
                b8 = !str.equals(m1979("碪磍\ue80c\ue0c0嘉䜯\ua87a뇀婪쯻璼购㶖굘ᇆ\ueee6ἴ逆㹾げ\uf248玚\udca8ᔁ헭啲劉", 1 - KeyEvent.normalizeMetaState(0)).intern()) ? (byte) -1 : (byte) 19;
                break;
            case -1207642840:
                b8 = !str.equals(m1979("䜁䝲ꯞꌒቛͽ襎郴旁蠩ヮ같Ƚ\uee8a喔쿒\u209f폎稧", KeyEvent.getDeadChar(0, 0) + 1).intern()) ? (byte) -1 : (byte) 1;
                break;
            case -1091371232:
                b8 = !str.equals(m1979("棓梲埭张싏폹啚䳲䨘琘\ue07d瀎ⷾኄ蔑Ꮭཌ", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1).intern()) ? (byte) -1 : (byte) 10;
                break;
            case -869156349:
                if (!str.equals(m1979("泆沲\ued03\ue5c5ፂɚ๋ៃ不컦", -ImageFormat.getBitsPerPixel(0)).intern())) {
                    b8 = -1;
                } else {
                    f1737 = (f1736 + 49) % 128;
                    b8 = 21;
                }
                break;
            case -772930430:
                b8 = !str.equals(m1979("ק֔ƭॡ䃖凰\uf73a\uee80✧≚扣퉭䃛䓹ܙ놦批禽⢪漳輎騨쩷", -Process.getGidForName("")).intern()) ? (byte) -1 : (byte) 3;
                break;
            case -407028174:
                b8 = !str.equals(m1971((-55) - TextUtils.getCapsMode("", 0, 0), (short) (ViewConfiguration.getJumpTapTimeout() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 733435552, (byte) (KeyEvent.keyCodeFromString("") - 63), KeyEvent.normalizeMetaState(0) - 197925862).intern()) ? (byte) -1 : (byte) 13;
                break;
            case -356418934:
                b8 = !str.equals(m1979("現玙˛ਗ\uf046\ue160䂛夦儳ℴ틷旕㛣䞔랖ضᑽ竷頬\ud8a2喇", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))).intern()) ? (byte) -1 : (byte) 15;
                break;
            case -140869031:
                if (!str.equals(m1971((-53) - Gravity.getAbsoluteGravity(0, 0), (short) (KeyEvent.getMaxKeyCode() >> 16), 733435567 - ((byte) KeyEvent.getModifierMetaStateMask()), (byte) ((ViewConfiguration.getEdgeSlop() >> 16) + 99), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) - 197925862).intern())) {
                    b8 = -1;
                } else {
                    int i2 = f1737 + 25;
                    f1736 = i2 % 128;
                    b8 = i2 % 2 == 0 ? (byte) 17 : (byte) 116;
                }
                break;
            case 205499235:
                b8 = !str.equals(m1971(View.getDefaultSize(0, 0) - 50, (short) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), View.MeasureSpec.getSize(0) + 733435533, (byte) (121 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (ViewConfiguration.getEdgeSlop() >> 16) - 197925850).intern()) ? (byte) -1 : (byte) 12;
                break;
            case 236043435:
                b8 = !str.equals(m1971((-61) - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (short) Gravity.getAbsoluteGravity(0, 0), 733435483 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (byte) ('P' - AndroidCharacter.getMirror('0')), (-197925851) - TextUtils.lastIndexOf("", '0')).intern()) ? (byte) -1 : (byte) 5;
                break;
            case 770797430:
                b8 = !str.equals(m1979("乔丳썢쮮쇿탙푾췄沔\ue095\ue34a\uf129୨蘶蘰鋢⧊뭲ꦃ䱷쒽壧䭞", 1 - (ViewConfiguration.getKeyRepeatDelay() >> 16)).intern()) ? (byte) -1 : (byte) 2;
                break;
            case 779164621:
                if (!str.equals(m1971(((byte) KeyEvent.getModifierMetaStateMask()) - 52, (short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (ViewConfiguration.getJumpTapTimeout() >> 16) + 733435585, (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 14), (ViewConfiguration.getTapTimeout() >> 16) - 197925850).intern())) {
                    b8 = -1;
                } else {
                    int i8 = f1736 + 43;
                    f1737 = i8 % 128;
                    b8 = i8 % 2 != 0 ? (byte) 18 : (byte) 121;
                }
                break;
            case 1308044955:
                b8 = !str.equals(m1979("\ue6e5\ue696䊏䩃耞鄸댛ꪦ쐨慠ꊯ陕ꏸ߀쟎", (ViewConfiguration.getEdgeSlop() >> 16) + 1).intern()) ? (byte) -1 : (byte) 7;
                break;
            case 1396624783:
                if (!str.equals(m1971((-60) - Drawable.resolveOpacity(0, 0), (short) TextUtils.indexOf("", "", 0), TextUtils.indexOf("", "", 0, 0) + 733435492, (byte) (Color.argb(0, 0, 0, 0) - 14), (-197925862) - (Process.myTid() >> 22)).intern())) {
                    b8 = -1;
                } else {
                    int i9 = f1736 + 11;
                    f1737 = i9 % 128;
                    b8 = i9 % 2 != 0 ? (byte) 6 : (byte) 97;
                }
                break;
            case 1924460979:
                b8 = !str.equals(m1979("\ue8b9\ue8d1迃蜋㫙⯸\ue1e4\uf85e쩹갰ᡫ쒳궅쪓紑ꝸ輧\uf7d7动租扆", (ViewConfiguration.getTapTimeout() >> 16) + 1).intern()) ? (byte) -1 : (byte) 20;
                break;
            case 1964255575:
                b8 = !str.equals(m1971((-50) - View.combineMeasuredStates(0, 0), (short) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 733435513, (byte) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), (-197925862) - TextUtils.getOffsetAfter("", 0)).intern()) ? (byte) -1 : (byte) 11;
                break;
            case 2056496294:
                if (!str.equals(m1979("ၷငᄻ᧷嵳䱕᪺̅㊶㋉翗㿏啍呪\u1a9c尩矮椐㔈芇", View.resolveSizeAndState(0, 0, 0) + 1).intern())) {
                    b8 = -1;
                } else {
                    f1737 = (f1736 + 77) % 128;
                    b8 = 14;
                }
                break;
            default:
                b8 = -1;
                break;
        }
        switch (b8) {
            case 0:
                return m1974();
            case 1:
                m1982((String) da.m1896(list, 0, String.class));
                return null;
            case 2:
                if (m1978() != null) {
                    return Integer.valueOf(m1978().m2298());
                }
                return null;
            case 3:
                m1975(hi.m2295(((Integer) da.m1896(list, 0, Integer.class)).intValue()));
                return null;
            case 4:
                return m1969();
            case 5:
                m1970((String) da.m1896(list, 0, String.class));
                return null;
            case 6:
                return m1981();
            case 7:
                m1980((String) da.m1896(list, 0, String.class));
                return null;
            case 8:
                return m1972();
            case 9:
                m1973((String) da.m1896(list, 0, String.class));
                return null;
            case 10:
                m1977((List<String>) da.m1896(list, 0, List.class));
                return null;
            case 11:
                return m1961();
            case 12:
                m1976((String) da.m1896(list, 0, String.class));
                return null;
            case 13:
                return m1964();
            case 14:
                m1967((String) da.m1896(list, 0, String.class));
                return null;
            case 15:
                return m1966();
            case 16:
                m1963((String) da.m1896(list, 0, String.class));
                return null;
            case 17:
                return m1968();
            case 18:
                m1965((String) da.m1896(list, 0, String.class));
                return null;
            case 19:
                return m1962();
            case 20:
                return m1960();
            case 21:
                return m1959();
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1971(int i2, short s7, int i8, byte b8, int i9) {
        String string;
        synchronized (n.f2979) {
            try {
                StringBuilder sb = new StringBuilder();
                int i10 = f1741;
                int i11 = i2 + i10;
                int i12 = i11 == -1 ? 1 : 0;
                if (i12 != 0) {
                    byte[] bArr = f1738;
                    if (bArr != null) {
                        i11 = (byte) (bArr[f1740 + i8] + i10);
                    } else {
                        i11 = (short) (f1735[f1740 + i8] + i10);
                    }
                }
                if (i11 > 0) {
                    n.f2984 = ((i8 + i11) - 2) + f1740 + i12;
                    n.f2982 = b8;
                    char c7 = (char) (i9 + f1742);
                    n.f2981 = c7;
                    sb.append(c7);
                    n.f2980 = n.f2981;
                    n.f2983 = 1;
                    while (n.f2983 < i11) {
                        byte[] bArr2 = f1738;
                        if (bArr2 != null) {
                            int i13 = n.f2984;
                            n.f2984 = i13 - 1;
                            n.f2981 = (char) (n.f2980 + (((byte) (bArr2[i13] + s7)) ^ n.f2982));
                        } else {
                            short[] sArr = f1735;
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

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private JSONObject m1962() {
        int i2 = f1736;
        JSONObject jSONObject = this.f1747;
        f1737 = (i2 + 61) % 128;
        return jSONObject;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private Object m1966() {
        int i2 = f1736 + 1;
        f1737 = i2 % 128;
        if (i2 % 2 != 0) {
            return this.f1747.optString(ig.f2510);
        }
        int i8 = 79 / 0;
        return this.f1747.optString(ig.f2510);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private void m1976(String str) {
        f1737 = (f1736 + 99) % 128;
        try {
            this.f1747.put(ig.f2516, str);
            int i2 = f1737 + 55;
            f1736 = i2 % 128;
            if (i2 % 2 != 0) {
                int i8 = 58 / 0;
            }
        } catch (JSONException unused) {
        }
    }
}
