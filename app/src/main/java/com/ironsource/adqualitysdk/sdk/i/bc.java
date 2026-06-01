package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.gf;
import com.ironsource.adqualitysdk.sdk.i.gn;
import com.ironsource.adqualitysdk.sdk.i.gt;
import com.ironsource.adqualitysdk.sdk.i.gx;
import com.ironsource.adqualitysdk.sdk.i.hb;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bc {

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f767 = 1;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f768;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static char f769;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Map<String, List<? extends gk>> f770;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static long f771;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f772;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static List<String> f773;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f774;

    static {
        m859();
        f773 = Arrays.asList(m862("\uf238⦹盺㠫", (char) (MotionEvent.axisFromString("") + 11127), "煂푾㗸\u0096㤿몊\udbd8슆퓍✋\ue456交\ue6b2檖", KeyEvent.normalizeMetaState(0), "度\uf30b㑤\uf802").intern(), m865("ຍ໌꒱⑳昋쫡\ue0b0恔嗔∹蛡ⲗ옠땛걹", -TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), m862("븍镹衁\uecce", (char) (52872 - KeyEvent.normalizeMetaState(0)), "㊲凵Ŷ蛯谮恖悳㟶谏蚷ᦪ芊㸁쑁躼", (ViewConfiguration.getTapTimeout() >> 16) + 1100315070, "度\uf30b㑤\uf802").intern());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(m865("ჲႳ⅗㜏㨿풔퀲핀\ue953", -TextUtils.indexOf((CharSequence) "", '0', 0, 0)).intern(), m861(new ft()));
        linkedHashMap.put(m862("ꣲ귓ࠟ㩜", (char) TextUtils.indexOf("", ""), "χ广Ჟ\u0bda뿶ҥ텇䶓炘", 531485608 - (KeyEvent.getMaxKeyCode() >> 16), "度\uf30b㑤\uf802").intern(), m861(new fz()));
        linkedHashMap.put(m865("鍀錁ᡚ⬺㘖圫屘漧\ue92b爰쥈\ue559", ExpandableListView.getPackedPositionGroup(0L) + 1).intern(), m861(new fy()));
        linkedHashMap.put(m862("躶ꌙ烏ǘ", (char) View.MeasureSpec.makeMeasureSpec(0, 0), "\ueb41ꦪ꧰\uef21臠쾫䣾ʖ撒", TextUtils.getOffsetBefore("", 0) - 811394674, "度\uf30b㑤\uf802").intern(), m861(new gf.d(), new gf.e()));
        linkedHashMap.put(m865("䛽䚿萯럊瀄芘쀡\uf3c2畇㐤캛ఫ喬ꍊ", KeyEvent.keyCodeFromString("") + 1).intern(), m861(new gg()));
        linkedHashMap.put(m862("㧫㰥Ṝ먮", (char) TextUtils.indexOf("", ""), "\udf8d攎惝䚅\udfae恌듬䮧ꨟ⒂", TextUtils.getOffsetBefore("", 0), "度\uf30b㑤\uf802").intern(), m861(new gh()));
        linkedHashMap.put(m862("\uaafe녻婵쐿", (char) TextUtils.indexOf("", ""), "竆칉२\u05f8杜샎竸嘛", Process.myPid() >> 22, "度\uf30b㑤\uf802").intern(), m861(new gd()));
        linkedHashMap.put(m865("᫁᪇ข랑璋\ude87䨎\uf398｢嗺ꟺ", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1).intern(), m861(new ge()));
        linkedHashMap.put(m862("ἂ澚\u0b4aﺝ", (char) (40203 - ExpandableListView.getPackedPositionType(0L)), "텭됏䳊ꬔﾲ饝", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), "度\uf30b㑤\uf802").intern(), m861(new gj()));
        linkedHashMap.put(m865("♕☝퍬⡉\ue52c\ue21c靉∔쨻㙝", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), m861(new gi()));
        linkedHashMap.put(m862("Ẫ꿜偯㚼", (char) (48208 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), "\uee02䓯ᴼ？읜\ue4fb", ViewConfiguration.getTouchSlop() >> 8, "度\uf30b㑤\uf802").intern(), m861(new gm()));
        linkedHashMap.put(m862("菿ﺹ뎈ₒ", (char) Gravity.getAbsoluteGravity(0, 0), "뤐ᆄ퐿緳媴䨲܍㈝\udae2ﬡ\ude99", TextUtils.indexOf("", "") - 1996572285, "度\uf30b㑤\uf802").intern(), m861(new gl()));
        linkedHashMap.put(m862("凞ꑶ솟㚢", (char) View.combineMeasuredStates(0, 0), "ߋႁ튿䭜\ue5de嵜ꐫ쯾螰袏", (-1) - ((byte) KeyEvent.getModifierMetaStateMask()), "度\uf30b㑤\uf802").intern(), m861(new gr()));
        linkedHashMap.put(m865("钻银ಣິᇆﷃ\uecdf슪", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), m861(new gq()));
        linkedHashMap.put(m865("녿넲ᨀҔࣨ甞帊䂌\ueb68䳹㤛\ue6f8\udb9f", 1 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern(), m861(new gn.b(), new gn.c()));
        linkedHashMap.put(m862("ܻ褟锜漱", (char) (12693 - TextUtils.getOffsetBefore("", 0)), "｟洣ᢏ廁ṭ撟", Color.blue(0), "度\uf30b㑤\uf802").intern(), m861(new go()));
        linkedHashMap.put(m865("玱珼몰ծ〘럇ﺪ䅛䯈琉\ue738\ue37a", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern(), m861(new gp()));
        linkedHashMap.put(m862("ᦂ\ud8aa\u09de篊", (char) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 51721), "⠝\u0605\udffe㔲萪", (-556226024) - ExpandableListView.getPackedPositionChild(0L), "度\uf30b㑤\uf802").intern(), m861(new gt(), new gt.b()));
        linkedHashMap.put(m865("릆맖\uef3a悝㓥緣ꬿ⒒Ṏ烙\u31eb苽\ue7a8", -TextUtils.lastIndexOf("", '0', 0, 0)).intern(), m861(new gw()));
        linkedHashMap.put(m862("縏\uf0f2\ued16운", (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 46317), "ꝼ鋲펜\ue6db⟢囹", Color.blue(0), "度\uf30b㑤\uf802").intern(), m861(new gu()));
        linkedHashMap.put(m862("ٙ뢭䕭燔", (char) ((-1) - Process.getGidForName("")), "ⓘ差䡜护岉뾬赶䢇匮쫳粄正", ViewConfiguration.getMaximumDrawingCacheSize() >> 24, "度\uf30b㑤\uf802").intern(), m861(new gv()));
        linkedHashMap.put(m862("姑饟㼿竸", (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 63551), "멍䮯죊쾻ꔻ㕳", ViewConfiguration.getMaximumDrawingCacheSize() >> 24, "度\uf30b㑤\uf802").intern(), m861(new gs()));
        linkedHashMap.put(m862("斗ᚂꃥ㥤", (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), "쳱鲼좘ᅎ橜暘ⅸ", (-451509659) - (ViewConfiguration.getLongPressTimeout() >> 16), "度\uf30b㑤\uf802").intern(), m861(new gy()));
        linkedHashMap.put(m865("ኗዂቋ쩝溣훪噠蹔\ue324⪠⠶뷔", 1 - Color.red(0)).intern(), m861(new gx(), new gx.d()));
        linkedHashMap.put(m862("踎㚋냆袷", (char) (47024 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))), "哬暅날砎ⵞ딂", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), "度\uf30b㑤\uf802").intern(), m861(new hb.b(), new hb.d()));
        linkedHashMap.put(m862("驻쟇㵠铄", (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 50236), "ꜷ矣\u0e3d䦣瓥ச", Color.argb(0, 0, 0, 0), "度\uf30b㑤\uf802").intern(), m861(new gz()));
        f770 = Collections.unmodifiableMap(linkedHashMap);
        int i2 = f767 + 33;
        f768 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 58 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static void m859() {
        f774 = 8676093622720459009L;
        f771 = -575840194171019610L;
        f772 = 0;
        f769 = (char) 0;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static List<? extends gk> m861(gk... gkVarArr) {
        int i2 = f768 + 45;
        f767 = i2 % 128;
        int i8 = i2 % 2;
        List<? extends gk> listAsList = Arrays.asList(gkVarArr);
        if (i8 == 0) {
            int i9 = 25 / 0;
        }
        int i10 = f768 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f767 = i10 % 128;
        if (i10 % 2 == 0) {
            int i11 = 4 / 0;
        }
        return listAsList;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static List<String> m863() {
        int i2 = f767 + 41;
        f768 = i2 % 128;
        if (i2 % 2 == 0) {
            return f773;
        }
        int i8 = 36 / 0;
        return f773;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Map<String, List<gk>> m866() {
        gk next;
        ArrayList arrayList = new ArrayList(f770.keySet());
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int i2 = f767 + 71;
            f768 = i2 % 128;
            if (i2 % 2 != 0) {
                f770.get((String) it.next());
                throw null;
            }
            String str = (String) it.next();
            List<? extends gk> list = f770.get(str);
            if (list != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<? extends gk> it2 = list.iterator();
                f768 = (f767 + 17) % 128;
                while (it2.hasNext()) {
                    int i8 = f767 + 47;
                    f768 = i8 % 128;
                    if (i8 % 2 != 0) {
                        next = it2.next();
                        int i9 = 44 / 0;
                        if (m864(next)) {
                            f767 = (f768 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
                            arrayList2.add(next);
                        }
                    } else {
                        next = it2.next();
                        if (m864(next)) {
                            f767 = (f768 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
                            arrayList2.add(next);
                        }
                    }
                }
                map.put(str, arrayList2);
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static gk m867() {
        gb gbVar = new gb();
        f768 = (f767 + 37) % 128;
        return gbVar;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static String m868() {
        int i2 = f768 + 49;
        f767 = i2 % 128;
        return m865("\ude20\ude61࿑踷↯ᩅ䯝쨋ﺴ斪噑蟮汤\uf2d9؆꦳鉞쏜䈎", (ViewConfiguration.getZoomControlsTimeout() > (i2 % 2 == 0 ? 1L : 0L) ? 1 : (ViewConfiguration.getZoomControlsTimeout() == (i2 % 2 == 0 ? 1L : 0L) ? 0 : -1))).intern();
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static List<gk> m860() {
        List<gk> listAsList = Arrays.asList(new gc(), new ga(), new fx());
        f768 = (f767 + 49) % 128;
        return listAsList;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static boolean m864(gk gkVar) {
        try {
            if (Prode.m249()) {
                int i2 = f767 + 55;
                f768 = i2 % 128;
                if (i2 % 2 != 0) {
                    gkVar.mo2241();
                    throw null;
                }
                gkVar.mo2241();
            } else {
                Class.forName(gkVar.mo2243());
            }
            f767 = (f768 + 65) % 128;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m862(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f771) ^ ((long) f772)) ^ ((long) f769));
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

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m865(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f774, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f774));
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
}
