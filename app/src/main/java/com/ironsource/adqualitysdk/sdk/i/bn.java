package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.view.InputDeviceCompat;
import com.fyber.FairBid;
import com.fyber.fairbid.ads.ImpressionData;
import com.fyber.fairbid.ads.Interstitial;
import com.fyber.fairbid.ads.PlacementType;
import com.fyber.fairbid.ads.Rewarded;
import com.fyber.fairbid.ads.ShowOptions;
import com.fyber.fairbid.ads.interstitial.InterstitialListener;
import com.fyber.fairbid.ads.rewarded.RewardedListener;
import com.fyber.fairbid.common.lifecycle.EventStream;
import com.fyber.fairbid.internal.Constants;
import com.fyber.fairbid.mediation.MediationManager;
import com.fyber.fairbid.mediation.abstr.CachedAd;
import com.fyber.fairbid.mediation.abstr.NetworkAdapter;
import com.fyber.fairbid.mediation.adapter.AdapterConfiguration;
import com.fyber.fairbid.mediation.adapter.AdapterPool;
import com.fyber.fairbid.mediation.config.MediationConfig;
import com.fyber.fairbid.sdk.placements.Placement;
import com.fyber.fairbid.sdk.placements.PlacementsHandler;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class bn extends bg {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static char f934 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f935 = 0;

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static int f936 = 0;

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static int f937 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f938 = 6426385359202850544L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char f939 = 23460;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f940 = 27311;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char f941 = 63848;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char f942 = 19254;

    public bn(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: 爫, reason: contains not printable characters */
    private static String m1061(ImpressionData impressionData) {
        int i2 = f937 + 71;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return impressionData.getAdvertiserDomain();
        }
        impressionData.getAdvertiserDomain();
        throw null;
    }

    /* JADX INFO: renamed from: ﬤ, reason: contains not printable characters */
    private static String m1062(ImpressionData impressionData) {
        f937 = (f935 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        String campaignId = impressionData.getCampaignId();
        f935 = (f937 + 19) % 128;
        return campaignId;
    }

    /* JADX INFO: renamed from: ףּ, reason: contains not printable characters */
    private static String m1063(ImpressionData impressionData) {
        f935 = (f937 + 3) % 128;
        String creativeId = impressionData.getCreativeId();
        int i2 = f935 + 75;
        f937 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 74 / 0;
        }
        return creativeId;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static double m1064(ImpressionData impressionData) {
        int i2 = f935 + 105;
        f937 = i2 % 128;
        if (i2 % 2 != 0) {
            return impressionData.getNetPayout();
        }
        impressionData.getNetPayout();
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static String m1065(ImpressionData impressionData) {
        f937 = (f935 + 79) % 128;
        String variantId = impressionData.getVariantId();
        f937 = (f935 + 65) % 128;
        return variantId;
    }

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static String m1067(ImpressionData impressionData) {
        int i2 = f937 + 23;
        f935 = i2 % 128;
        if (i2 % 2 != 0) {
            impressionData.getRenderingSdk();
            throw null;
        }
        String renderingSdk = impressionData.getRenderingSdk();
        int i8 = f935 + 101;
        f937 = i8 % 128;
        if (i8 % 2 != 0) {
            return renderingSdk;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static String m1068(ImpressionData impressionData) {
        int i2 = f937 + 5;
        f935 = i2 % 128;
        int i8 = i2 % 2;
        String demandSource = impressionData.getDemandSource();
        if (i8 != 0) {
            int i9 = 4 / 0;
        }
        return demandSource;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static MediationManager m1069() {
        f935 = (f937 + 43) % 128;
        MediationManager companion = MediationManager.Companion.getInstance();
        f935 = (f937 + 3) % 128;
        return companion;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ String m1072(ImpressionData impressionData) {
        f937 = (f935 + 17) % 128;
        String strM1061 = m1061(impressionData);
        int i2 = f937 + 89;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1061;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static PlacementType m1074(ImpressionData impressionData) {
        f937 = (f935 + 67) % 128;
        PlacementType placementType = impressionData.getPlacementType();
        int i2 = f935 + 49;
        f937 = i2 % 128;
        if (i2 % 2 != 0) {
            return placementType;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public static /* synthetic */ double m1075(ImpressionData impressionData) {
        f937 = (f935 + 41) % 128;
        double dM1064 = m1064(impressionData);
        f935 = (f937 + 103) % 128;
        return dM1064;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ MediationManager m1076() {
        int i2 = f937 + 35;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1069();
        }
        m1069();
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public static /* synthetic */ String m1078(ImpressionData impressionData) {
        int i2 = f935 + 13;
        f937 = i2 % 128;
        if (i2 % 2 != 0) {
            return m1063(impressionData);
        }
        m1063(impressionData);
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ Constants.AdType m1079(String str) {
        int i2 = f935 + 105;
        f937 = i2 % 128;
        int i8 = i2 % 2;
        Constants.AdType adTypeM1071 = m1071(str);
        if (i8 == 0) {
            int i9 = 67 / 0;
        }
        int i10 = f937 + 55;
        f935 = i10 % 128;
        if (i10 % 2 == 0) {
            return adTypeM1071;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1087(ImpressionData impressionData) {
        int i2 = f935 + 113;
        f937 = i2 % 128;
        if (i2 % 2 == 0) {
            m1068(impressionData);
            throw null;
        }
        String strM1068 = m1068(impressionData);
        int i8 = f937 + 81;
        f935 = i8 % 128;
        if (i8 % 2 == 0) {
            return strM1068;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ PlacementType m1090(Constants.AdType adType) {
        f935 = (f937 + 23) % 128;
        PlacementType placementTypeM1084 = m1084(adType);
        int i2 = f935 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f937 = i2 % 128;
        if (i2 % 2 != 0) {
            return placementTypeM1084;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ Constants.AdType m1094(Placement placement) {
        int i2 = f935 + 99;
        f937 = i2 % 128;
        if (i2 % 2 == 0) {
            m1101(placement);
            throw null;
        }
        Constants.AdType adTypeM1101 = m1101(placement);
        f935 = (f937 + 21) % 128;
        return adTypeM1101;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ PlacementType m1100(ImpressionData impressionData) {
        f937 = (f935 + 115) % 128;
        PlacementType placementTypeM1074 = m1074(impressionData);
        int i2 = f937 + 3;
        f935 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 24 / 0;
        }
        return placementTypeM1074;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static boolean m1066() {
        int i2 = f935 + 91;
        f937 = i2 % 128;
        if (i2 % 2 != 0) {
            return FairBid.assertStarted();
        }
        FairBid.assertStarted();
        throw null;
    }

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static String m1070(ImpressionData impressionData) {
        int i2 = f937 + 89;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return impressionData.getRenderingSdkVersion();
        }
        impressionData.getRenderingSdkVersion();
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public static /* synthetic */ boolean m1073() {
        f935 = (f937 + 111) % 128;
        boolean zM1066 = m1066();
        f937 = (f935 + 59) % 128;
        return zM1066;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ String m1077(ImpressionData impressionData) {
        int i2 = f937 + 95;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1062(impressionData);
        }
        m1062(impressionData);
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1080(FairBid.AdsConfig adsConfig) {
        int i2 = f935 + 37;
        f937 = i2 % 128;
        int i8 = i2 % 2;
        String strM1086 = m1086(adsConfig);
        if (i8 == 0) {
            int i9 = 28 / 0;
        }
        return strM1086;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ List m1088(MediationConfig mediationConfig) {
        int i2 = f937 + 29;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1083(mediationConfig);
        }
        m1083(mediationConfig);
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1091(ImpressionData impressionData) {
        f935 = (f937 + 113) % 128;
        String strM1067 = m1067(impressionData);
        f935 = (f937 + 113) % 128;
        return strM1067;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1095(FairBid.AdsConfig adsConfig) {
        f935 = (f937 + 59) % 128;
        String strM1103 = m1103(adsConfig);
        f937 = (f935 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        return strM1103;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ PlacementsHandler m1102(MediationManager mediationManager) {
        f935 = (f937 + 37) % 128;
        PlacementsHandler placementsHandlerM1085 = m1085(mediationManager);
        int i2 = f935 + 113;
        f937 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 39 / 0;
        }
        return placementsHandlerM1085;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static Constants.AdType m1071(String str) {
        switch (str.hashCode()) {
            case -1372958932:
                if (str.equals(m1104("\ufbcb\uf4f9倂蛵", (char) (ViewConfiguration.getTapTimeout() >> 16), "緄\uf3b5鏧\ue7c1袜枸퓊뼤輙ꁾ立ㆥ", (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, "雰贎᭯夯").intern())) {
                    f935 = (f937 + 33) % 128;
                    return Constants.AdType.INTERSTITIAL;
                }
                break;
            case 433141802:
                if (str.equals(m1097("\udca5縘\udefb敯瓬జ຺芭", KeyEvent.normalizeMetaState(0) + 7).intern())) {
                    return Constants.AdType.UNKNOWN;
                }
                break;
            case 543046670:
                if (str.equals(m1104("\udb4b䑛ꕴ暂", (char) View.MeasureSpec.makeMeasureSpec(0, 0), "ꋦ\ued32流遁祅飛烴싼", TextUtils.getOffsetBefore("", 0), "雰贎᭯夯").intern())) {
                    return Constants.AdType.REWARDED;
                }
                break;
            case 1951953708:
                if (str.equals(m1104("﹕㾔㢹⇓", (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 54071), "䑠匉ࡢ쵇瞣✵", ViewConfiguration.getKeyRepeatTimeout() >> 16, "雰贎᭯夯").intern())) {
                    return Constants.AdType.BANNER;
                }
                break;
        }
        f935 = (f937 + 61) % 128;
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1081(ImpressionData impressionData) {
        int i2 = f937 + 11;
        f935 = i2 % 128;
        int i8 = i2 % 2;
        String strM1065 = m1065(impressionData);
        if (i8 != 0) {
            int i9 = 36 / 0;
        }
        return strM1065;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1092(Placement placement) {
        f935 = (f937 + 57) % 128;
        String strM1082 = m1082(placement);
        int i2 = f935 + 11;
        f937 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 38 / 0;
        }
        return strM1082;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ String m1096(ImpressionData impressionData) {
        f935 = (f937 + 51) % 128;
        String strM1070 = m1070(impressionData);
        f935 = (f937 + 55) % 128;
        return strM1070;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1103(FairBid.AdsConfig adsConfig) {
        f935 = (f937 + 63) % 128;
        String str = adsConfig.store;
        f937 = (f935 + 31) % 128;
        return str;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    public final Class mo826(String str) {
        switch (str.hashCode()) {
            case -2041833493:
                if (!str.equals(m1104("僰잱⤮싔", (char) (ViewConfiguration.getJumpTapTimeout() >> 16), "냹틱Ꝫ樾챾羜햵ᜪ硜㢤ﺓ", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 784838992, "雰贎᭯夯").intern())) {
                    return null;
                }
                int i2 = f935 + 35;
                f937 = i2 % 128;
                if (i2 % 2 == 0) {
                    return null;
                }
                return AdapterPool.class;
            case -1598046662:
                if (!str.equals(m1104("ꯌ섁˸阐", (char) ((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + InputDeviceCompat.SOURCE_TOUCHSCREEN), "娝\uef81屙姚ດ㧙㹌ᚵ桅뀦\u19cbᩞ\udcb3廻䪐", TextUtils.indexOf("", "", 0, 0) - 121568853, "雰贎᭯夯").intern())) {
                    return null;
                }
                f935 = (f937 + 47) % 128;
                return MediationConfig.class;
            case -1115843213:
                if (str.equals(m1104("礆\uf261流筊", (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 19053), "㲍䤁\uef04ᥐ漠䍘㛯\ue563ﭔ\ue137止ϐ%뜯", View.getDefaultSize(0, 0), "雰贎᭯夯").intern())) {
                    return ImpressionData.class;
                }
                return null;
            case -847426041:
                if (str.equals(m1097("ቪ퇌魫⚰⚨蔼\ue836曑\ue44f\uab08\u0a3d몒퓦\udfe3ꖑ\uaafb\u0ef6ᨑ\ue44f\uab08", 19 - MotionEvent.axisFromString("")).intern())) {
                    return AdapterConfiguration.class;
                }
                return null;
            case -498060603:
                if (str.equals(m1097("쪚쮅䭇琶쭿㽡\u09d1͇࢈狳", 9 - (ViewConfiguration.getDoubleTapTimeout() >> 16)).intern())) {
                    return Placement.class;
                }
                return null;
            case -368841467:
                if (!str.equals(m1104("踽퀩뵙衲", (char) Drawable.resolveOpacity(0, 0), "谻ኙ벺퀃䁷\uf0dd豕ẻ", ViewConfiguration.getScrollBarFadeDuration() >> 16, "雰贎᭯夯").intern())) {
                    return null;
                }
                int i8 = f937 + 19;
                f935 = i8 % 128;
                if (i8 % 2 != 0) {
                    return null;
                }
                return CachedAd.class;
            case -174936018:
                if (str.equals(m1104("⛩纕ᅈ⨢", (char) TextUtils.getOffsetAfter("", 0), "菸趵\u2d7a裖彨ꞌ\u245c쑠", ImageFormat.getBitsPerPixel(0) + 1, "雰贎᭯夯").intern())) {
                    return Rewarded.class;
                }
                return null;
            case 99044255:
                if (str.equals(m1104("\ue3c5\u244b\ueaee츪", (char) (10986 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), "阵瓹憯\ue3dd렃꜀哏\ueffb됯ᐑ褬며\ue017", ExpandableListView.getPackedPositionChild(0L) - 299611164, "雰贎᭯夯").intern())) {
                    return PlacementType.class;
                }
                return null;
            case 438795617:
                if (str.equals(m1097("梋ᢃ\ueecb㭹稆\udd97탺歧︪\u0080崿\uebc9ꞐᲞ", TextUtils.indexOf((CharSequence) "", '0') + 15).intern())) {
                    return NetworkAdapter.class;
                }
                return null;
            case 578208537:
                if (str.equals(m1097("랁멵欮锩즄Ⳇ툃ᨱ", 7 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))).intern())) {
                    return FairBid.class;
                }
                return null;
            case 769047372:
                if (str.equals(m1104("㺎⫴鈀菙", (char) (ViewConfiguration.getJumpTapTimeout() >> 16), "鑗攂犚ዾ뢈珿졐ᱲ瓱噲肗猐", ViewConfiguration.getMinimumFlingVelocity() >> 16, "雰贎᭯夯").intern())) {
                    return Interstitial.class;
                }
                return null;
            case 806552769:
                if (!str.equals(m1097("릜福ਫ਼\uf2e2쬩歷\u0ef6ᨑ\ue44f\uab08\uef96器", (ViewConfiguration.getPressedStateDuration() >> 16) + 11).intern())) {
                    return null;
                }
                int i9 = f935 + 99;
                f937 = i9 % 128;
                if (i9 % 2 == 0) {
                    return null;
                }
                return ShowOptions.class;
            case 1062384924:
                if (str.equals(m1097("쪚쮅䭇琶쭿㽡\u09d1͇픜믰\uf2ef\ue4a1埑鰠০\u19af\ude4c㿩", 17 - View.combineMeasuredStates(0, 0)).intern())) {
                    return PlacementsHandler.class;
                }
                return null;
            case 1212533506:
                if (str.equals(m1104("䅇\uedf7冩꣧", (char) (TextUtils.lastIndexOf("", '0') + 59218), "梯䙴鸩䆉펙䞺䙯넛湨ⲙ퓃\udda2訉㩒䉡\u0e61", ViewConfiguration.getScrollBarSize() >> 8, "雰贎᭯夯").intern())) {
                    return RewardedListener.class;
                }
                return null;
            case 1297340448:
                if (str.equals(m1097("ꀕ\ue58c⚨蔼⒧쓒\u0ef6ᨑ\u0ef6ᨑ͠壞簠任첦亴\u09d1͇ꞐᲞ", View.resolveSize(0, 0) + 20).intern())) {
                    return InterstitialListener.class;
                }
                return null;
            case 1775008410:
                if (str.equals(m1104("쑝努읶㘺", (char) ExpandableListView.getPackedPositionGroup(0L), "\ud8a7覢䘅蘥좜䑚엤ꃫ⮞饈\uf566", 1985129157 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), "雰贎᭯夯").intern())) {
                    return EventStream.class;
                }
                return null;
            case 1884304309:
                if (str.equals(m1104("濮䀑㑆替", (char) (65332 - (ViewConfiguration.getPressedStateDuration() >> 16)), "辑욀먪희譫\uf34f熗\udce6撆\uf728\udacc㔙做ꉄ蝫ꌺ", TextUtils.indexOf("", "", 0), "雰贎᭯夯").intern())) {
                    return MediationManager.class;
                }
                return null;
            case 1955869213:
                if (str.equals(m1097("ቪ퇌⛇႒擈ᯏ", (ViewConfiguration.getLongPressTimeout() >> 16) + 6).intern())) {
                    return Constants.AdType.class;
                }
                return null;
            case 1969669106:
                if (str.equals(m1097("ቪ퇌굎鮭\ue44f\uab08\u0a3d몒더\uebb0", TextUtils.indexOf((CharSequence) "", '0') + 10).intern())) {
                    return FairBid.AdsConfig.class;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m1093(InterstitialListener interstitialListener) {
        f935 = (f937 + 57) % 128;
        Interstitial.setInterstitialListener(interstitialListener);
        f937 = (f935 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m1098(InterstitialListener interstitialListener) {
        f935 = (f937 + 43) % 128;
        m1093(interstitialListener);
        int i2 = f937 + 73;
        f935 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 32 / 0;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static Constants.AdType m1101(Placement placement) {
        int i2 = f937 + 71;
        f935 = i2 % 128;
        int i8 = i2 % 2;
        Constants.AdType adType = placement.getAdType();
        if (i8 != 0) {
            int i9 = 65 / 0;
        }
        f937 = (f935 + 79) % 128;
        return adType;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        int i2 = f935 + 89;
        f937 = i2 % 128;
        try {
            try {
                return (String) (i2 % 2 == 0 ? FairBid.class.getDeclaredField(m1104("\uf436蚰綰찫", (char) ExpandableListView.getPackedPositionType(1L), "ՠ챸뫷Ꙃ⚝⾿ꇕᐱ왣裑讳", (-1333350156) / (ViewConfiguration.getMaximumDrawingCacheSize() + 4), "雰贎᭯夯").intern()) : FairBid.class.getDeclaredField(m1104("\uf436蚰綰찫", (char) ExpandableListView.getPackedPositionType(0L), "ՠ챸뫷Ꙃ⚝⾿ꇕᐱ왣裑讳", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) - 1333350156, "雰贎᭯夯").intern())).get(null);
            } catch (Exception unused) {
                return hu.m2386().m2388().m2439(FairBid.class, m1097("ꭩ\u0bc4뾦鋗ㇰ폲\uf069꽮緰뇿뾦鋗ㇰ폲\uf069꽮緰뇿뾦鋗ㇰ폲፤暘", 23 - (ViewConfiguration.getJumpTapTimeout() >> 16)).intern());
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ void m1099(RewardedListener rewardedListener) {
        int i2 = f937 + 27;
        f935 = i2 % 128;
        int i8 = i2 % 2;
        m1089(rewardedListener);
        if (i8 != 0) {
            throw null;
        }
        f935 = (f937 + 15) % 128;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1104(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f938) ^ ((long) f936)) ^ ((long) f934));
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

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1104("㔦⼧濔\uf7f5", (char) (62831 - (KeyEvent.getMaxKeyCode() >> 16)), "˶䬣囯瀖칭Ϊ싪몚ċ캇탆쵻骢ꟶ熺\udd8f뛻싿ӏ룄䑮킬㩫\ue9e8鎏\uee64殞", (-735107276) - TextUtils.indexOf((CharSequence) "", '0'), "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1076();
            }
        });
        map.put(m1104("\ue165튮ᩓ콡", (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), "邫㰯俱ꈢ鲘\ue076㱌\uedbc똘\ue96b\uf1bcὦ鄾觩蓲ꄒ룿旞䖵ߡ鬢冡", Color.rgb(0, 0, 0) + 16777216, "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.14
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1090((Constants.AdType) list.get(0));
            }
        });
        map.put(m1097("磑쌮凾遝㵷硩ﮧꗪ茽쯼稥겷随綅Ⲝ옲ᡌ므倴샱嘝ԏ鄾刺쌰\ue2c4⛇႒擈ᯏ", 30 - (ViewConfiguration.getTouchSlop() >> 8)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.11
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1100((ImpressionData) list.get(0));
            }
        });
        map.put(m1097("磑쌮凾遝㵷硩ﮧꗪ茽쯼稥겷随綅Ⲝ옲⛌찆\u09d1͇⩱ꂕ篭룙㱻↟痁︷覑䋈", (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 29).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.16
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1091((ImpressionData) list.get(0));
            }
        });
        map.put(m1097("磑쌮凾遝㵷硩ﮧꗪ茽쯼稥겷随綅Ⲝ옲⛌찆\u09d1͇⩱ꂕ篭룙㱻↟痁︷ꙸ뭐ꞐᲞδ\u20c4\ue44f\uab08", (ViewConfiguration.getDoubleTapTimeout() >> 16) + 36).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.20
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1096((ImpressionData) list.get(0));
            }
        });
        map.put(m1097("磑쌮凾遝㵷硩ﮧꗪ茽쯼稥겷随綅Ⲝ옲\uf1e8黻쭿㽡\ue4df滘⛌鲆ᆮ轕ꢖﮢ狵\uf67f", TextUtils.indexOf((CharSequence) "", '0') + 30).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.19
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1087((ImpressionData) list.get(0));
            }
        });
        map.put(m1104("눗윥䥅姷", (char) (63305 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), "✣붉\ue13f遅堼❷ⵈ凩貔臶傡䓖쳭⾿瓾\uf323랩爣ꈒ鈰ᑅﾧἴ娗㳫㑎", 1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.17
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1081((ImpressionData) list.get(0));
            }
        });
        map.put(m1104("䈫⿀붜䐂", (char) (701 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), "ࣶ烜\ue0eb慌쇂縄陫䂤႔\ue812ΎѸ\ue753㧿쇸嗠犥䝏ᤒ鷭\udfeaꞩ⊉赔៑샷", (-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.18
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Double.valueOf(bn.m1075((ImpressionData) list.get(0)));
            }
        });
        map.put(m1097("磑쌮凾遝㵷硩ﮧꗪ茽쯼稥겷随綅Ⲝ옲顭晊ﮧꗪⲜ옲聣谋ﾗ×툃ᨱ", View.MeasureSpec.makeMeasureSpec(0, 0) + 27).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.22
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1078((ImpressionData) list.get(0));
            }
        });
        map.put(m1104("꿏媱മ碸", (char) TextUtils.indexOf("", ""), "\ud8e1ꑯ巙韞붮숈슊ᶷ㻕䍷햜ம瀀䠱ጩἿ儆Ņ\udbc0뱯瑢讀\ue943唵\ue391ꪩ\uf76c\u0a0d⪕\udc47욿䉉䎖", 777695663 - Drawable.resolveOpacity(0, 0), "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1072((ImpressionData) list.get(0));
            }
        });
        map.put(m1097("磑쌮凾遝㵷硩ﮧꗪ茽쯼稥겷随綅Ⲝ옲顭晊鈃㞈㖓쭬\ud7c9垓\uf82f\uf783툃ᨱ", 27 - (ViewConfiguration.getScrollDefaultDelay() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1077((ImpressionData) list.get(0));
            }
        });
        map.put(m1104("侴\uf421虪掆", (char) View.MeasureSpec.getMode(0), "⒆\ueb8b벵᷄蜶⛤内㻏", Color.blue(0), "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1080((FairBid.AdsConfig) list.get(0));
            }
        });
        map.put(m1097("磑쌮榳\ued9b罅ิﮧꗪ", (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 8).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1095((FairBid.AdsConfig) list.get(0));
            }
        });
        map.put(m1097("磑쌮苋У︪\u0080崿\uebc9ꞐᲞ烘㢘Ⲓ鰌\ud7c9垓ꢤ澄Ⲝ옲稥겷罄濠", (KeyEvent.getMaxKeyCode() >> 16) + 24).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1088((MediationConfig) list.get(0));
            }
        });
        map.put(m1097("磑쌮䡕䓑倴샱嘝ԏ鄾刺쌰\ue2c4ቪ퇌⛇႒擈ᯏ", 18 - Drawable.resolveOpacity(0, 0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1094((Placement) list.get(0));
            }
        });
        map.put(m1097("磑쌮䡕䓑倴샱嘝ԏ鄾刺쌰\ue2c4\ue707훣鄾刺", 17 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1092((Placement) list.get(0));
            }
        });
        map.put(m1104("봩樑\uf89b\uddbc", (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1), "酊變嫃뤗鼅銚\ueaba鱰夭ᑑ\uf024菈⫳ᰜ떂嗢굅荼\uee02阏", ViewConfiguration.getFadingEdgeLength() >> 16, "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1102((MediationManager) list.get(0));
            }
        });
        map.put(m1104("䊳\ue5b7㋰疨", (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 43059), "氅\ud93aഥ槲Ꞝ珼\udaab䐜끕쥬⾲ㅟ\uf600", ((byte) KeyEvent.getModifierMetaStateMask()) - 253380797, "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return bn.m1079((String) list.get(0));
            }
        });
        map.put(m1097("᷐\udf0c凾遝쌰\ue2c4ꞐᲞ첦亴⍝晃ᐡ熦頇ܽᇃ⣡⚨蔼鄁\udcae\ude4c㿩", 24 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.12
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bn.m1098((InterstitialListener) list.get(0));
                return null;
            }
        });
        map.put(m1097("᷐\udf0c㠅貳꽦㙒蠳䃪⩱ꂕ聊⨀ᇃ⣡⚨蔼鄁\udcae\ude4c㿩", 19 - (ViewConfiguration.getFadingEdgeLength() >> 16)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.13
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                bn.m1099((RewardedListener) list.get(0));
                return null;
            }
        });
        map.put(m1104("䔘﹌遏፨", (char) ((ViewConfiguration.getScrollBarSize() >> 8) + 26768), "ཎ䭏㧛ꢭ\uf26d\uf3a8\uf078엄ᡫ塵輖᭳㈱", Color.blue(0) + 1342065733, "雰贎᭯夯").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.bn.15
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Boolean.valueOf(bn.m1073());
            }
        });
        f935 = (f937 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static List<AdapterConfiguration> m1083(MediationConfig mediationConfig) {
        int i2 = f937 + 65;
        f935 = i2 % 128;
        int i8 = i2 % 2;
        List<AdapterConfiguration> adapterConfigurations = mediationConfig.getAdapterConfigurations();
        if (i8 != 0) {
            int i9 = 1 / 0;
        }
        int i10 = f937 + 95;
        f935 = i10 % 128;
        if (i10 % 2 == 0) {
            return adapterConfigurations;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m1082(Placement placement) {
        int i2 = f937 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE;
        f935 = i2 % 128;
        if (i2 % 2 == 0) {
            return placement.getName();
        }
        placement.getName();
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1097(String str, int i2) {
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
                            char c9 = (char) (c7 - (((c8 + i9) ^ ((c8 << 4) + f940)) ^ ((c8 >>> 5) + f941)));
                            cArr3[1] = c9;
                            cArr3[0] = (char) (c8 - (((c9 >>> 5) + f942) ^ ((c9 + i9) ^ ((c9 << 4) + f939))));
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static PlacementType m1084(Constants.AdType adType) {
        f935 = (f937 + 39) % 128;
        PlacementType placementType = adType.getPlacementType();
        f937 = (f935 + 3) % 128;
        return placementType;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1086(FairBid.AdsConfig adsConfig) {
        int i2 = f935 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f937 = i2 % 128;
        int i8 = i2 % 2;
        String str = adsConfig.appId;
        if (i8 == 0) {
            int i9 = 57 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static PlacementsHandler m1085(MediationManager mediationManager) {
        int i2 = f935 + 37;
        f937 = i2 % 128;
        if (i2 % 2 != 0) {
            return mediationManager.getPlacementsHandler();
        }
        mediationManager.getPlacementsHandler();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m1089(RewardedListener rewardedListener) {
        int i2 = f935 + 109;
        f937 = i2 % 128;
        int i8 = i2 % 2;
        Rewarded.setRewardedListener(rewardedListener);
        if (i8 == 0) {
            throw null;
        }
    }
}
