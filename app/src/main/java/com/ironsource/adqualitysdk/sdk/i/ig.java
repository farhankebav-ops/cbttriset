package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ig {

    /* JADX INFO: renamed from: ᔱ, reason: contains not printable characters */
    private static int[] f2468 = null;

    /* JADX INFO: renamed from: ᔲ, reason: contains not printable characters */
    private static int f2469 = 1;

    /* JADX INFO: renamed from: ᔹ, reason: contains not printable characters */
    private static long f2470;

    /* JADX INFO: renamed from: ᔺ, reason: contains not printable characters */
    private static int f2471;

    /* JADX INFO: renamed from: ᔽ, reason: contains not printable characters */
    public static final List<String> f2472;

    /* JADX INFO: renamed from: ᕂ, reason: contains not printable characters */
    public static String f2473;

    /* JADX INFO: renamed from: ᕃ, reason: contains not printable characters */
    public static String f2474;

    /* JADX INFO: renamed from: ᕄ, reason: contains not printable characters */
    public static String f2475;

    /* JADX INFO: renamed from: ᕆ, reason: contains not printable characters */
    public static String f2476;

    /* JADX INFO: renamed from: ᖅ, reason: contains not printable characters */
    public static String f2477;

    /* JADX INFO: renamed from: ᖩ, reason: contains not printable characters */
    public static String f2478;

    /* JADX INFO: renamed from: ᖫ, reason: contains not printable characters */
    public static String f2479;

    /* JADX INFO: renamed from: ᖭ, reason: contains not printable characters */
    public static String f2480;

    /* JADX INFO: renamed from: ᖸ, reason: contains not printable characters */
    public static String f2481;

    /* JADX INFO: renamed from: ᖺ, reason: contains not printable characters */
    public static String f2482;

    /* JADX INFO: renamed from: ᗀ, reason: contains not printable characters */
    public static String f2483;

    /* JADX INFO: renamed from: ᘥ, reason: contains not printable characters */
    public static String f2484;

    /* JADX INFO: renamed from: ᵆ, reason: contains not printable characters */
    public static String f2485;

    /* JADX INFO: renamed from: Ḟ, reason: contains not printable characters */
    public static String f2486;

    /* JADX INFO: renamed from: Ḹ, reason: contains not printable characters */
    public static String f2487;

    /* JADX INFO: renamed from: Ḽ, reason: contains not printable characters */
    public static String f2488;

    /* JADX INFO: renamed from: Ṿ, reason: contains not printable characters */
    public static String f2489;

    /* JADX INFO: renamed from: Ὑ, reason: contains not printable characters */
    public static String f2490;

    /* JADX INFO: renamed from: Ῠ, reason: contains not printable characters */
    public static String f2491;

    /* JADX INFO: renamed from: Ῡ, reason: contains not printable characters */
    public static String f2492;

    /* JADX INFO: renamed from: Ὺ, reason: contains not printable characters */
    public static String f2493;

    /* JADX INFO: renamed from: Ύ, reason: contains not printable characters */
    public static String f2494;

    /* JADX INFO: renamed from: K, reason: contains not printable characters */
    public static String f2495;

    /* JADX INFO: renamed from: Ⅽ, reason: contains not printable characters */
    public static String f2496;

    /* JADX INFO: renamed from: Ↄ, reason: contains not printable characters */
    public static String f2497;

    /* JADX INFO: renamed from: く, reason: contains not printable characters */
    public static String f2498;

    /* JADX INFO: renamed from: っ, reason: contains not printable characters */
    public static String f2499;

    /* JADX INFO: renamed from: へ, reason: contains not printable characters */
    public static String f2500;

    /* JADX INFO: renamed from: ゥ, reason: contains not printable characters */
    public static String f2501;

    /* JADX INFO: renamed from: ト, reason: contains not printable characters */
    public static String f2502;

    /* JADX INFO: renamed from: リ, reason: contains not printable characters */
    public static String f2503;

    /* JADX INFO: renamed from: ヮ, reason: contains not printable characters */
    public static String f2504;

    /* JADX INFO: renamed from: ヶ, reason: contains not printable characters */
    public static String f2505;

    /* JADX INFO: renamed from: 丫, reason: contains not printable characters */
    public static String f2506;

    /* JADX INFO: renamed from: 乁, reason: contains not printable characters */
    public static String f2507;

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    public static String f2508;

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    public static String f2509;

    /* JADX INFO: renamed from: טּ, reason: contains not printable characters */
    public static String f2510;

    /* JADX INFO: renamed from: סּ, reason: contains not printable characters */
    public static String f2511;

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    public static String f2512;

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public static String f2513;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public static String f2514;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    public static String f2515;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    public static String f2516;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    public static String f2517;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static String f2518;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public static String f2519;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static String f2520;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static String f2521;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static String f2522;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static String f2523;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static String f2524;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static String f2525;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static String f2526;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static String f2527;

    static {
        m2521();
        f2524 = m2519("㇈\uea8c沠뉄ㆡ།꜊Ϭꘓ靕ཛ﮹ộﾄ鞘", 1 - Color.green(0)).intern();
        f2526 = m2519("ｏ࿎䌝佧Ｆ\uea4f袷ﻍ", 1 - (ViewConfiguration.getPressedStateDuration() >> 16)).intern();
        f2527 = m2519("ᅳ\udcc4쬵툝ᄃ㥇\u008c掾", (ViewConfiguration.getTapTimeout() >> 16) + 1).intern();
        f2523 = m2519("츃锭\ue3bd浗칢炦⠷\udce3姏\ue8e3", -TextUtils.lastIndexOf("", '0', 0, 0)).intern();
        f2525 = m2520(new int[]{-134524696, -728081134, -271403135, -887313004}, TextUtils.getOffsetAfter("", 0) + 6).intern();
        f2520 = m2519("張䛵ਪ馜彁ꍩ", 1 - (ViewConfiguration.getEdgeSlop() >> 16)).intern();
        f2519 = m2520(new int[]{1267427649, 379363752, -410930470, 1208246470}, TextUtils.indexOf((CharSequence) "", '0', 0) + 7).intern();
        f2518 = m2519("\uef10댵⍅흝\uef62嚿\ue8ff曹磞컻䂼麠", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 1).intern();
        f2522 = m2519("㷍ᴑ枡傛㶺\uf89d개\ue106ꨐ惈њ\u197f\u12c6", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))).intern();
        f2521 = m2519("뒩莈ﭫՋ듄昂テ듵⍴﹄颔", 1 - KeyEvent.normalizeMetaState(0)).intern();
        f2514 = m2520(new int[]{-2094384664, 2022555312, -2082805543, -819662117}, 6 - ((Process.getThreadPriority(0) + 20) >> 6)).intern();
        f2513 = m2519("ꆘ꽚瓹쟛ꇷ䫛뽭癥㙴튃ᜌ踿躐멉", TextUtils.indexOf("", "", 0, 0) + 1).intern();
        f2516 = m2520(new int[]{-1920826012, 275007175, -491382764, -1564184885}, 5 - (ViewConfiguration.getTouchSlop() >> 8)).intern();
        f2515 = m2519("Ш뷆\uea86蜗щ塍℮㚳鏠", 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern();
        f2517 = m2520(new int[]{-1920826012, 275007175, -591374085, -1646734474}, KeyEvent.normalizeMetaState(0) + 5).intern();
        f2512 = m2520(new int[]{101978310, 311411668, -1633395096, -848132712}, '7' - AndroidCharacter.getMirror('0')).intern();
        f2510 = m2519("ຒⶉ棚須\u0ef4젏ꍪ⦤饂偷ଲ퇭", 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern();
        f2511 = m2520(new int[]{-1178118654, 1438324984, 1269336441, -504974215}, (ViewConfiguration.getTapTimeout() >> 16) + 8).intern();
        f2509 = m2519("ṗ景共ꕯḴ菬髄ᓑ覙ᮧ", 1 - ExpandableListView.getPackedPositionGroup(0L)).intern();
        f2508 = m2519("\ud7ca뜢澲볎\ud7a9効ꐚൗ䀏쫹్", Color.argb(0, 0, 0, 0) + 1).intern();
        f2503 = m2520(new int[]{1256912133, -1708289941, -732132750, 801399371}, 7 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))).intern();
        f2506 = m2520(new int[]{1164959114, -1283954978, 1043046583, 112204707}, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 7).intern();
        f2504 = m2519("䪁\uf272다\ue18c䫲\u17ef祙倔\udd4f辵턍", 1 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern();
        f2505 = m2519("者䛱\uf556燛醙ꍷ㻬쁣浼㬶隿", 1 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)).intern();
        f2507 = m2520(new int[]{-830623516, 1677180312, 1043046583, 112204707}, 6 - TextUtils.lastIndexOf("", '0', 0)).intern();
        f2500 = m2519("␛蘄镁뜰⑲掆廸ڈ돕\ufbc3\uf6a8", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1).intern();
        f2499 = m2520(new int[]{-1220005728, -1154699014, 1440930089, -949951594}, (ViewConfiguration.getFadingEdgeLength() >> 16) + 6).intern();
        f2501 = m2520(new int[]{-1838386832, -1923888033, 293676659, 223745654}, Color.blue(0) + 5).intern();
        f2498 = m2519("ƽ蒋岱\ue89cǔ愀霌夡陯", 1 - Color.alpha(0)).intern();
        f2502 = m2519("\uf626룑첺\udfba\uf64f嵚܃清懪", (Process.myPid() >> 22) + 1).intern();
        f2496 = m2519("꣔蛋⛊ᨗꢽ捀\ued66ꮿ㼙", -ImageFormat.getBitsPerPixel(0)).intern();
        f2493 = m2519("䝨江ᵧ癨䜁觔훘쟁", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1).intern();
        f2494 = m2519("㲰\ue953沱蓻㳙\u0cd8꜎㕒ꭺ", (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 1).intern();
        f2497 = m2519("ད鉄뉠㬍༸矏种誰", -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern();
        f2495 = m2519("媧跇킨茔嫎桌ᬕ㊭쵭\uf008덁쫭", (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1).intern();
        f2492 = m2519("蚪뷸䞠外蛃塳谝\ue8abᅸ쀷⑉ჯ", -((byte) KeyEvent.getModifierMetaStateMask())).intern();
        f2488 = m2519("좨\uf3b6筹힢죅ᘰ냂昮彰蹎ᢑ鹈\ue7a3", -(ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))).intern();
        f2489 = m2519("瓟㵼湊⢰璚\ud8e5ꗱ餓\ue317䂅ඵ慚寂⡲镪즐뎏", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1).intern();
        f2490 = m2520(new int[]{-1363159419, -1569381923, 995629744, 1875123925, 1340658068, -1455859519}, MotionEvent.axisFromString("") + 11).intern();
        f2491 = m2520(new int[]{-1363159419, -1569381923, 360218639, -1548705767, 462350731, 1048211404}, Process.getGidForName("") + 12).intern();
        f2487 = m2519("쥮ﮓ襨猳줦ḽ䋕슊庑虊\uea97㫛\ue662\uee91牚", -ExpandableListView.getPackedPositionChild(0L)).intern();
        f2483 = m2519("맀雭곆쑜릈獃杻痥ⸯ\ueb32켽趧雌華埴", 1 - TextUtils.getOffsetBefore("", 0)).intern();
        f2484 = m2519("贈ￚ䞸̔憎ᩴ谅늭洮舅\u244d䫭헉\uead8벊", 1 - KeyEvent.getDeadChar(0, 0)).intern();
        f2486 = m2519("밥使ᑍ⺏뱭\uaad1\udff0鼶⯝㊱瞤杲錯婷\uef62쾯筵", 1 - (ViewConfiguration.getEdgeSlop() >> 16)).intern();
        f2485 = m2519("쥣緥ᾄ봞줫顋퐹ಧ庌/籨\uf4f2\ue67f棑\ue4a6尺ร킣", (ViewConfiguration.getTapTimeout() >> 16) + 1).intern();
        f2482 = m2519("苗⒙糱䱬芢섅띊\ufdd3ᔢ奜Ἅ֊", 1 - TextUtils.indexOf("", "")).intern();
        f2479 = m2520(new int[]{1362154043, -766757092, 1528915980, -221843484, 829248209, 1959541305}, 11 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))).intern();
        f2480 = m2519("禝\udb7e⏨냦积㻧", 1 - (ViewConfiguration.getEdgeSlop() >> 16)).intern();
        f2481 = m2520(new int[]{-1094622614, -1105642218}, 3 - (ViewConfiguration.getTouchSlop() >> 8)).intern();
        f2478 = m2519("曷\ud83e롅\uec09暖㶥珬", (Process.myPid() >> 22) + 1).intern();
        f2473 = m2520(new int[]{1546656174, -1099551718, 1128265754, 66549995, 197507437, -1691625528, 1521074913, -1997872055}, 14 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))).intern();
        f2475 = m2519("䰸㖯\u0b0e蓦䱕퀥살㕂\udbc0䡥棠촎", 1 - (ViewConfiguration.getLongPressTimeout() >> 16)).intern();
        f2476 = m2519("꜌鎧측펴Ꝿ瘭։", 1 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))).intern();
        f2477 = m2520(new int[]{1741289124, -73936979}, 3 - (ViewConfiguration.getWindowTouchSlop() >> 8)).intern();
        f2474 = m2519("㟾\udb26\ued8eᱏ㞗㺪☤귯", (ViewConfiguration.getScrollBarSize() >> 8) + 1).intern();
        f2472 = Arrays.asList(m2519("ⱅ㡄簒茳Ⱔ\uddcf랓㊝뮕䖀Ώ쫟͙", (ViewConfiguration.getLongPressTimeout() >> 16) + 1).intern());
        int i2 = f2471 + 23;
        f2469 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2519(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (i.f2441) {
            try {
                char[] cArrM2497 = i.m2497(f2470, cArr, i2);
                i.f2442 = 4;
                while (true) {
                    int i8 = i.f2442;
                    if (i8 < cArrM2497.length) {
                        i.f2443 = i8 - 4;
                        cArrM2497[i8] = (char) (((long) (cArrM2497[i8] ^ cArrM2497[i8 % 4])) ^ (((long) r2) * f2470));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2521() {
        f2470 = -9198053937772239377L;
        f2468 = new int[]{-370377770, 1505631388, -27336998, -2140154485, -1586166653, -272821785, -1598875969, 1883717487, -1088424270, -1919009616, 322620511, -690741836, -117381846, -1771219271, 386253355, 880057204, 1436151041, -1458626094};
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2520(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2468.clone();
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
}
