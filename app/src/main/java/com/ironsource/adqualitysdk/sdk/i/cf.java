package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.qq.e.ads.ADActivity;
import com.qq.e.ads.DialogActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.IGDTAdManager;
import com.qq.e.comm.managers.status.APPStatus;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.vungle.ads.internal.protos.Sdk;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cf extends bg {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1284 = 1;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f1286 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static boolean f1289 = true;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f1290 = true;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1291 = 193;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f1292 = {264, 261, 277, 258, 293, 276, 300, 292, 309, 298, 311, 314, 304, 302, 239, 306, 294, 290, 308, 301, 296, 269, 303, 305, 275, 312, 307, 273, 278, 295, 266, 279, 259, 310, 291, 262, 313};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f1288 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f1287 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static char f1285 = 24709;

    public cf(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static IGDTAdManager m1538() {
        f1284 = (f1286 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        IGDTAdManager gDTAdManger = GDTAdSdk.getGDTAdManger();
        f1286 = (f1284 + 1) % 128;
        return gDTAdManger;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ IGDTAdManager m1539() {
        int i2 = f1284 + 25;
        f1286 = i2 % 128;
        if (i2 % 2 != 0) {
            m1538();
            throw null;
        }
        IGDTAdManager iGDTAdManagerM1538 = m1538();
        int i8 = f1286 + 45;
        f1284 = i8 % 128;
        if (i8 % 2 != 0) {
            return iGDTAdManagerM1538;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ Map m1542(UnifiedInterstitialAD unifiedInterstitialAD) {
        f1284 = (f1286 + 47) % 128;
        Map mapM1550 = m1550(unifiedInterstitialAD);
        int i2 = f1284 + 87;
        f1286 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 32 / 0;
        }
        return mapM1550;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ int m1543(RewardVideoAD rewardVideoAD) {
        f1286 = (f1284 + 63) % 128;
        int iM1541 = m1541(rewardVideoAD);
        f1284 = (f1286 + 109) % 128;
        return iM1541;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1549(APPStatus aPPStatus) {
        int i2 = f1286 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1284 = i2 % 128;
        int i8 = i2 % 2;
        String strM1544 = m1544(aPPStatus);
        if (i8 == 0) {
            int i9 = 70 / 0;
        }
        f1286 = (f1284 + 1) % 128;
        return strM1544;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f1286 = (f1284 + 91) % 128;
        String integrationSDKVersion = SDKStatus.getIntegrationSDKVersion();
        int i2 = f1284 + 71;
        f1286 = i2 % 128;
        if (i2 % 2 == 0) {
            return integrationSDKVersion;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1546("᧒ᬿ雪缌", (char) (3221 - ImageFormat.getBitsPerPixel(0)), "获ᩙ벰\uf8bc炻㨓ꀎ庽\udf44ꇡ纒㙪ⱥ鯂", View.MeasureSpec.makeMeasureSpec(0, 0), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cf.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cf.m1539();
            }
        });
        map.put(m1547((String) null, ExpandableListView.getPackedPositionGroup(0L) + 127, (int[]) null, "\u0085\u009f\u0098\u0098\u0084\u0089\u0091\u0095").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cf.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cf.m1549((APPStatus) list.get(0));
            }
        });
        map.put(m1546("解롖孿㻽", (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), "뙢ᩍ獇苝闟ﮐ撏썰蕎ﷆ첷솁", KeyEvent.normalizeMetaState(0), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cf.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cf.m1545((LiteAbstractAD) list.get(0));
            }
        });
        map.put(m1546("\uf2a3ⶦ쳢뙨", (char) (26828 - (ViewConfiguration.getKeyRepeatDelay() >> 16)), "⪼\ue78f쿏학훘≰䡡筱ẕ旾긤쁢毹ꌔༀ", (-500324622) - (ViewConfiguration.getDoubleTapTimeout() >> 16), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cf.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Integer.valueOf(cf.m1543((RewardVideoAD) list.get(0)));
            }
        });
        map.put(m1546("噤浩描뛪", (char) (60003 - (ViewConfiguration.getTouchSlop() >> 8)), "\ued35펏\uf1b4⦦齚켮웉딪䎟봷ᶆᛒ敵㋄齃", (-814913195) - ((byte) KeyEvent.getModifierMetaStateMask()), "\u0000\u0000\u0000\u0000").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cf.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cf.m1551((RewardVideoAD) list.get(0));
            }
        });
        map.put(m1547((String) null, TextUtils.getTrimmedLength("") + 127, (int[]) null, "\u0089¥¤\u0094\u0092\u008a\u0089\u008a\u0089\u0093\u009b\u0091\u0089\u0097\u009f\u0089\u0091\u0095").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cf.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cf.m1542((UnifiedInterstitialAD) list.get(0));
            }
        });
        f1284 = (f1286 + 31) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Map<String, Object> m1540(LiteAbstractAD liteAbstractAD) {
        int i2 = f1284 + 1;
        f1286 = i2 % 128;
        if (i2 % 2 == 0) {
            return liteAbstractAD.getExtraInfo();
        }
        liteAbstractAD.getExtraInfo();
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ Map m1545(LiteAbstractAD liteAbstractAD) {
        f1286 = (f1284 + 27) % 128;
        Map<String, Object> mapM1540 = m1540(liteAbstractAD);
        int i2 = f1284 + 13;
        f1286 = i2 % 128;
        if (i2 % 2 == 0) {
            return mapM1540;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ Map m1551(RewardVideoAD rewardVideoAD) {
        f1284 = (f1286 + 37) % 128;
        Map<String, String> mapM1548 = m1548(rewardVideoAD);
        int i2 = f1284 + 59;
        f1286 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 44 / 0;
        }
        return mapM1548;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        switch (str.hashCode()) {
            case -1950656211:
                if (str.equals(m1546("⚫\uf450澾튒", (char) (TextUtils.indexOf("", "") + 37487), "㳔䮝\ude07䪭⼭⏓蜝ຜ\uf6b1귏⣫菌熱㘯\ue0ca⥂얶⇇୪", (-1091284955) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), "\u0000\u0000\u0000\u0000").intern())) {
                    int i2 = f1284 + 43;
                    f1286 = i2 % 128;
                    return i2 % 2 != 0 ? DialogActivity.class : LandscapeADActivity.class;
                }
                break;
            case -1537668511:
                if (str.equals(m1547((String) null, 127 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (int[]) null, "\u0082\u0084\u0094\u0092\u008a\u0089\u008a\u0089\u0093\u009b\u0091\u0089\u0097\u009f\u0085\u0091\u008a\u009e\u008a\u0097\u009d").intern())) {
                    int i8 = f1286 + 5;
                    f1284 = i8 % 128;
                    return i8 % 2 == 0 ? UnifiedBannerADListener.class : UnifiedInterstitialAD.class;
                }
                break;
            case -1192770783:
                if (str.equals(m1547((String) null, 127 - (ViewConfiguration.getJumpTapTimeout() >> 16), (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0082\u0084\u0091\u0098\u0092\u0088\u0093\u0085\u0097\u0092\u0096\u008d\u0091\u0085\u008a\u008b\u0085\u009b\u0092\u009a\u0091\u0099").intern())) {
                    return RewardvideoLandscapeADActivity.class;
                }
                break;
            case -1125491209:
                if (str.equals(m1546("\uf6d3ⲓ嫑폻", (char) View.MeasureSpec.getSize(0), "ꛇ⮞୶ⱪ窜涩㥉窭\uf14d嘆", ViewConfiguration.getMaximumFlingVelocity() >> 16, "\u0000\u0000\u0000\u0000").intern())) {
                    return ADListener.class;
                }
                break;
            case -1040623465:
                if (str.equals(m1547((String) null, (ViewConfiguration.getLongPressTimeout() >> 16) + 127, (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0095\u008d\u0094\u0092\u008a\u0082").intern())) {
                    return DialogActivity.class;
                }
                break;
            case -839956733:
                if (str.equals(m1547((String) null, 127 - View.MeasureSpec.getMode(0), (int[]) null, "\u009a\u0091\u008a \u009b\u0091\u0097\u0097\u0092¡\u0085\u0091\u008a\u009e\u008a\u0097\u009d").intern())) {
                    return UnifiedBannerView.class;
                }
                break;
            case -570955421:
                if (str.equals(m1546("龇켌㞩쾩", (char) (ViewConfiguration.getTapTimeout() >> 16), "팲㹒沟纐겻ቘ⬀\ue5b6¹屃Ⴏ\ue400槂驢ኩ餃⫶ೲ죾ࡃ\uf7cd", (-1446048609) - (ViewConfiguration.getTapTimeout() >> 16), "\u0000\u0000\u0000\u0000").intern())) {
                    return RewardVideoADListener.class;
                }
                break;
            case -427681737:
                if (str.equals(m1546("闅뼶ٳ䜙", (char) (TextUtils.lastIndexOf("", '0') + 1), "ꀤ䪩\ueb47瓲냳蕿혇", 1941911188 - TextUtils.indexOf((CharSequence) "", '0', 0), "\u0000\u0000\u0000\u0000").intern())) {
                    f1284 = (f1286 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
                    return ADEvent.class;
                }
                break;
            case -358530385:
                if (str.equals(m1547((String) null, AndroidCharacter.getMirror('0') + 'O', (int[]) null, "\u0093\u008e\u0092\u009b\u0092\u009c\u0085\u0084\u0085\u0092\u008d\u0096").intern())) {
                    return LoadAdParams.class;
                }
                break;
            case -311779863:
                if (str.equals(m1546("갚ᦥ㔇膠", (char) (TextUtils.indexOf("", "", 0) + 41013), "ꩵꮠ◘ƒꭶ撹硍ꠠ묏\uf5ff倾\uf4fb濏᪨䤱繿窧ᅊ됼\ue015\uf1f2ӖⳖ㨶㽭\ueb17삇윢ﴲ䩘㕭깧漜⑱䌵玳ﻲ璷븪\ue005细宆窉", View.combineMeasuredStates(0, 0) + 119121324, "\u0000\u0000\u0000\u0000").intern())) {
                    return RewardvideoLandscapeADActivity.class;
                }
                break;
            case -301299368:
                if (str.equals(m1546("ꅸﾘ賮⨧", (char) (Color.green(0) + 10124), "\ue09d젴揶亠稪羕\u007f냤斡빡㑘쳈㵗욑엡\uecef䦊", (-285239135) - ((Process.getThreadPriority(0) + 20) >> 6), "\u0000\u0000\u0000\u0000").intern())) {
                    return RewardVideoAD.ADListenerAdapter.class;
                }
                break;
            case -287046183:
                if (str.equals(m1547((String) null, (ViewConfiguration.getJumpTapTimeout() >> 16) + 127, (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0082\u0084\u0089\u008a\u0092\u009b\u0089\u009b\u008d\u009c\u008d\u0091\u0085\u008a\u008b\u0085\u009b\u0092\u009a\u0091\u0099").intern())) {
                    return RewardvideoPortraitADActivity.class;
                }
                break;
            case -207731435:
                if (str.equals(m1546("㟂驍\ue898ႉ", (char) (35303 - TextUtils.indexOf((CharSequence) "", '0')), "\ue715틕ַ\ue3d9\u1c3a䤙軳灏웨䣹㯵뀞ꘛ홄쿨ꊾﯯ\uecdb⤆㠘⚓擴牽\ue825㷹\ue334檗\ue73a⥉읃\ue0ad", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 1734718153, "\u0000\u0000\u0000\u0000").intern())) {
                    return PortraitADActivity.class;
                }
                break;
            case 2003474:
                if (str.equals(m1546("꺕飹痂읟", (char) (24437 - (Process.myPid() >> 22)), "寅⾃퍶ͣ", 1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), "\u0000\u0000\u0000\u0000").intern())) {
                    f1286 = (f1284 + 55) % 128;
                    return ACTD.class;
                }
                break;
            case 167349330:
                if (str.equals(m1547((String) null, 127 - ((Process.getThreadPriority(0) + 20) >> 6), (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0082\u0084").intern())) {
                    return ADActivity.class;
                }
                break;
            case 555831221:
                if (str.equals(m1547((String) null, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 128, (int[]) null, "\u009b\u0091\u0097\u0091\u0089\u0093\u008a\u0096\u0082\u0084\u009b\u0091\u0097\u0097\u0092¡\u0085\u0091\u008a\u009e\u008a\u0097\u009d").intern())) {
                    return UnifiedBannerADListener.class;
                }
                break;
            case 796884557:
                if (str.equals(m1546("\ueace鋻ࢉ勊", (char) (51721 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), "쥥嵅褫᥉\uf617籤\uf573⢢\ud93a밶\uf2db㌗諜שּׁ폔\ue1fe泛\u3040", KeyEvent.normalizeMetaState(0), "\u0000\u0000\u0000\u0000").intern())) {
                    return PortraitADActivity.class;
                }
                break;
            case 814717722:
                if (str.equals(m1547((String) null, Gravity.getAbsoluteGravity(0, 0) + 127, (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0082\u0084\u008f\u0093\u0085\u0092\u008f\u0091\u008f\u0090\u0090\u008f\u008e\u008d\u0088").intern())) {
                    return ADActivity.class;
                }
                break;
            case 937653587:
                if (str.equals(m1547((String) null, 127 - Gravity.getAbsoluteGravity(0, 0), (int[]) null, "\u0093¢\u0089\u0092\u0089\u0086\u009c\u009c\u0084").intern())) {
                    return APPStatus.class;
                }
                break;
            case 1265986405:
                if (str.equals(m1547((String) null, 127 - TextUtils.indexOf("", "", 0), (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0082\u0084\u0091\u0098\u0092\u0088\u0093\u0085\u0097\u0092\u0096\u008f\u0093\u0085\u0092\u008f\u0091\u008f\u0090\u0090\u008f\u008e\u008d\u0088").intern())) {
                    return LandscapeADActivity.class;
                }
                break;
            case 1305853839:
                if (str.equals(m1547((String) null, View.MeasureSpec.getSize(0) + 127, (int[]) null, "\u0082\u0084\u008d\u0091\u0085\u008a \u0085\u009b\u0092\u009a\u0091\u0099").intern())) {
                    f1284 = (f1286 + 41) % 128;
                    return RewardVideoAD.class;
                }
                break;
            case 1336889139:
                if (str.equals(m1547((String) null, 127 - (ViewConfiguration.getTapTimeout() >> 16), (int[]) null, "\u0082\u0084\u0089\u0088\u0092\u009b\u0089\u0093£\u0084\u0091\u0089\u008a\u0096").intern())) {
                    return LiteAbstractAD.class;
                }
                break;
            case 1773421109:
                if (str.equals(m1547((String) null, (-16777089) - Color.rgb(0, 0, 0), (int[]) null, "\u009b\u0091\u0097\u0091\u0089\u0093\u008a\u0096\u0082\u0084\u0094\u0092\u008a\u0089\u008a\u0089\u0093\u009b\u0091\u0089\u0097\u009f\u0085\u0091\u008a\u009e\u008a\u0097\u009d").intern())) {
                    return UnifiedInterstitialADListener.class;
                }
                break;
            case 1874129984:
                if (str.equals(m1547((String) null, 127 - KeyEvent.normalizeMetaState(0), (int[]) null, "\u0087\u0085\u0086\u0085\u0084\u0083\u0082\u0081").intern())) {
                    f1284 = (f1286 + 107) % 128;
                    return GDTAdSdk.class;
                }
                break;
            case 1958130193:
                if (str.equals(m1547((String) null, (ViewConfiguration.getEdgeSlop() >> 16) + 127, (int[]) null, "\u008c\u0089\u008a\u008b\u008a\u0089\u0088\u0084\u0082\u0084\u0089\u008a\u0092\u009b\u0089\u009b\u008d\u009c\u008d\u0091\u0085\u008a\u008b\u0085\u009b\u0092\u009a\u0091\u0099\u008f\u0093\u0085\u0092\u008f\u0091\u008f\u0090\u0090\u008f\u008e\u008d\u0088").intern())) {
                    return RewardvideoPortraitADActivity.class;
                }
                break;
            case 2111488863:
                if (str.equals(m1546("塩흷辤惈", (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 51344), "ሥ晏\ue2ed\uda6cḹ\uf5ceԙ峍\ue2c0\uf5ab䜠ᨍ\udf8c熂戆﵍\u0604꿄沰煮忏녵\ue5d3⽞ꤕ뭎\ue06a", Gravity.getAbsoluteGravity(0, 0) - 1529383080, "\u0000\u0000\u0000\u0000").intern())) {
                    return DialogActivity.class;
                }
                break;
        }
        int i9 = f1284 + 13;
        f1286 = i9 % 128;
        if (i9 % 2 == 0) {
            return null;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1544(APPStatus aPPStatus) {
        int i2 = f1284 + 101;
        f1286 = i2 % 128;
        int i8 = i2 % 2;
        String appid = aPPStatus.getAPPID();
        if (i8 != 0) {
            int i9 = 95 / 0;
        }
        f1286 = (f1284 + 59) % 128;
        return appid;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static Map m1550(UnifiedInterstitialAD unifiedInterstitialAD) {
        f1284 = (f1286 + 83) % 128;
        Map ext = unifiedInterstitialAD.getExt();
        f1284 = (f1286 + 91) % 128;
        return ext;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static Map<String, String> m1548(RewardVideoAD rewardVideoAD) {
        int i2 = f1284 + 3;
        f1286 = i2 % 128;
        if (i2 % 2 != 0) {
            rewardVideoAD.getExts();
            throw null;
        }
        Map<String, String> exts = rewardVideoAD.getExts();
        int i8 = f1286 + 111;
        f1284 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 65 / 0;
        }
        return exts;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1547(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f1292;
                int i8 = f1291;
                if (f1289) {
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
                if (f1290) {
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

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1546(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1288) ^ ((long) f1287)) ^ ((long) f1285));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int m1541(RewardVideoAD rewardVideoAD) {
        f1284 = (f1286 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        int rewardAdType = rewardVideoAD.getRewardAdType();
        f1284 = (f1286 + 45) % 128;
        return rewardAdType;
    }
}
