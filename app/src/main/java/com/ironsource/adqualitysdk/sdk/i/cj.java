package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.vungle.ads.internal.protos.Sdk;
import com.yandex.mobile.ads.banner.BannerAdEventListener;
import com.yandex.mobile.ads.banner.BannerAdView;
import com.yandex.mobile.ads.common.AdInfo;
import com.yandex.mobile.ads.common.ImpressionData;
import com.yandex.mobile.ads.common.MobileAds;
import com.yandex.mobile.ads.common.VideoController;
import com.yandex.mobile.ads.common.VideoEventListener;
import com.yandex.mobile.ads.interstitial.InterstitialAd;
import com.yandex.mobile.ads.interstitial.InterstitialAdEventListener;
import com.yandex.mobile.ads.rewarded.Reward;
import com.yandex.mobile.ads.rewarded.RewardedAd;
import com.yandex.mobile.ads.rewarded.RewardedAdEventListener;
import com.yandex.mobile.ads.video.playback.model.MediaFile;
import com.yandex.mobile.ads.video.playback.model.VideoAd;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cj extends bg {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1331 = 0;

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static int f1332 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static char[] f1336 = {':', 'n', 'o', 'o', 'n', 'k', 'R', 'R', 'R', ']', 'a', 175, 170, 166, 172, 190, ':', 's', 'l', 'm', 's', 'k', '[', '[', 'R', 135, 289, 308, 311, 305, 306, 313, 308, 306, 308, 287, 280, 304, 304, 'P', 151, 144, 136, 134, '{', 130, 148, 146, 151, 144, 'z', 'a', 'y', 148, 146, 151, 144, 138, 'q', 'y', 148, 139, 'p', 'r', 145, 147, 142, 145, 151, 'v', '|', 151, 141, 146, 144, 150, '|', 'v', 151, 146, 'h', 207, 204, 203, 199, 202, 195, 190, 197, 195, 201, 184, 184, 205, 208, '2', 'd', 'f', '_', 'd', 'k', 'i', 'i', 'l', 's', 'n', 'Z', '`', 'q', 'i', 'm', ']', 'Z', '!', 'Q', 'g', 'n', 'i', 'k', 'Y', 'R', 'T', ']', 'm', 'i', 'q', '`', 'Z', 'n', 's', 'l', 'i', 'i', 'k', 210, 225, 219, 182, 209, 174, 217, 206, 214, 225, 214, 225, 224, 223, '9', 'k', 'i', 'i', 'l', 's', 'n', 'Z', '`', 'q', 'i', 'm', ']', 'T', 'R', 'V', 'f', 'e', 'n', 'n', 'n', 's', 'r', 'k', 'l', 'q', '[', ')', '[', 'n', 'l', 'i', 'k', 'P', 152, 155, 157, 138, 138, 129, 129, 147, 147, '0', 'e', 'f', 'd', 'Y', 'Y', 'h', 'j', 'W', '+', '_', 'f', 'd', 'j', 'X', 'R', 'Q', 149, 157, 173, 170, 160, 155, 145, 153, 171, 165, '&', 'Z', 'n', 's', 'l', 'i', 'i', 'k', 'r', 'l', 'l', 'e', '_', 'f', 'd', 'j', 'Z', ']', 'm', 'i', 'q', ':', '^', '[', 'p', 's', 'l', 'k', 'r', 's', 'n', 'n', 'n', 'e', 'f', 'Z', '[', 'j', 'j', 'k', 'f', 'M', 157, 145, 139, 150, 152, 133, 129, 147, 148, 146, 135, 142, 154, 148, '2', 'l', 'e', '_', 'f', 'd', 'j', 'X', 'R', 'V', '[', 'j', 'j', 'k'};

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static boolean f1337 = true;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static boolean f1335 = true;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1333 = 128;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static char[] f1334 = {227, 239, 237, 174, 249, 225, 238, 228, 229, 248, 226, 233, 236, 243, 193, 244, 246, 212, 240, 205, 194, 242, 214, 247, 210, 197, 204, 208, 235, 196, 231, 245, 201, 230, 198};

    public cj(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1593(AdInfo adInfo) {
        f1332 = (f1331 + 17) % 128;
        String strM1614 = m1614(adInfo);
        f1332 = (f1331 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE) % 128;
        return strM1614;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ AdInfo m1597(RewardedAd rewardedAd) {
        f1331 = (f1332 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE) % 128;
        AdInfo adInfoM1612 = m1612(rewardedAd);
        f1331 = (f1332 + 21) % 128;
        return adInfoM1612;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1604(ImpressionData impressionData) {
        f1331 = (f1332 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
        String strM1615 = m1615(impressionData);
        f1332 = (f1331 + 65) % 128;
        return strM1615;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ int m1608(Reward reward) {
        int i2 = f1331 + 13;
        f1332 = i2 % 128;
        int i8 = i2 % 2;
        int iM1592 = m1592(reward);
        if (i8 == 0) {
            int i9 = 47 / 0;
        }
        f1332 = (f1331 + 33) % 128;
        return iM1592;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1616(Reward reward) {
        f1332 = (f1331 + 97) % 128;
        String strM1598 = m1598(reward);
        int i2 = f1332 + 101;
        f1331 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1598;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1594(MediaFile mediaFile) {
        f1331 = (f1332 + 1) % 128;
        String strM1599 = m1599(mediaFile);
        int i2 = f1332 + 71;
        f1331 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1599;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1605(VideoAd videoAd) {
        f1332 = (f1331 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
        String strM1600 = m1600(videoAd);
        f1332 = (f1331 + 41) % 128;
        return strM1600;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ AdInfo m1609(InterstitialAd interstitialAd) {
        f1332 = (f1331 + 87) % 128;
        AdInfo adInfoM1603 = m1603(interstitialAd);
        int i2 = f1331 + 93;
        f1332 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 80 / 0;
        }
        return adInfoM1603;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ void m1618(InterstitialAd interstitialAd, InterstitialAdEventListener interstitialAdEventListener) {
        int i2 = f1332 + 63;
        f1331 = i2 % 128;
        int i8 = i2 % 2;
        m1602(interstitialAd, interstitialAdEventListener);
        if (i8 != 0) {
            throw null;
        }
        f1331 = (f1332 + 13) % 128;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026e A[RETURN] */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.cj.mo826(java.lang.String):java.lang.Class");
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m1596(VideoController videoController, VideoEventListener videoEventListener) {
        int i2 = f1332 + 69;
        f1331 = i2 % 128;
        int i8 = i2 % 2;
        m1617(videoController, videoEventListener);
        if (i8 != 0) {
            throw null;
        }
        f1332 = (f1331 + 25) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m1606(BannerAdView bannerAdView, BannerAdEventListener bannerAdEventListener) {
        int i2 = f1331 + 15;
        f1332 = i2 % 128;
        int i8 = i2 % 2;
        m1595(bannerAdView, bannerAdEventListener);
        if (i8 == 0) {
            int i9 = 88 / 0;
        }
        f1331 = (f1332 + 35) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ MediaFile m1610(VideoAd videoAd) {
        f1332 = (f1331 + 27) % 128;
        MediaFile mediaFileM1613 = m1613(videoAd);
        f1332 = (f1331 + 85) % 128;
        return mediaFileM1613;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1614(AdInfo adInfo) {
        int i2 = f1331 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1332 = i2 % 128;
        if (i2 % 2 != 0) {
            return adInfo.getAdUnitId();
        }
        adInfo.getAdUnitId();
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ void m1607(RewardedAd rewardedAd, RewardedAdEventListener rewardedAdEventListener) {
        int i2 = f1331 + 113;
        f1332 = i2 % 128;
        int i8 = i2 % 2;
        m1619(rewardedAd, rewardedAdEventListener);
        if (i8 == 0) {
            int i9 = 0 / 0;
        }
        int i10 = f1332 + 17;
        f1331 = i10 % 128;
        if (i10 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1615(ImpressionData impressionData) {
        f1331 = (f1332 + 5) % 128;
        String rawData = impressionData.getRawData();
        int i2 = f1331 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1332 = i2 % 128;
        if (i2 % 2 != 0) {
            return rawData;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f1332 = (f1331 + 41) % 128;
        String libraryVersion = MobileAds.getLibraryVersion();
        int i2 = f1332 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1331 = i2 % 128;
        if (i2 % 2 == 0) {
            return libraryVersion;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1601("\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000", true, new int[]{207, 11, 63, 11}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1593((AdInfo) list.get(0));
            }
        });
        map.put(m1611((String) null, KeyEvent.normalizeMetaState(0) + 127, (int[]) null, "\u0086\u0090\u0086\u009e\u0098\u0086\u0099\u0090\u0089\u009f").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1604((ImpressionData) list.get(0));
            }
        });
        map.put(m1601("\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000", false, new int[]{Sdk.SDKError.Reason.MRAID_JS_DOES_NOT_EXIST_VALUE, 21, 0, 8}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cj.m1596((VideoController) list.get(0), (VideoEventListener) list.get(1));
                return null;
            }
        });
        map.put(m1601("\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0000", false, new int[]{239, 20, 0, 18}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1609((InterstitialAd) list.get(0));
            }
        });
        map.put(m1611((String) null, 126 - TextUtils.lastIndexOf("", '0', 0), (int[]) null, "\u0090\u0087 \u0082\u0083\u008f\u0088\u0096\u0086\u0098\u0089\u0099\u0090\u0089\u009f").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return Integer.valueOf(cj.m1608((Reward) list.get(0)));
            }
        });
        map.put(m1611((String) null, 127 - Color.red(0), (int[]) null, "\u0089\u0093\u0085\u0092\u0088\u0096\u0086\u0098\u0089\u0099\u0090\u0089\u009f").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1616((Reward) list.get(0));
            }
        });
        map.put(m1611((String) null, 127 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (int[]) null, "\u0082¢\u0087¡\u0088\u008f\u0088\u0089\u0088\u0096\u0086\u0098\u0089\u0099\u0090\u0089\u009f").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.14
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1597((RewardedAd) list.get(0));
            }
        });
        map.put(m1611((String) null, (ViewConfiguration.getWindowTouchSlop() >> 8) + 127, (int[]) null, "\u0096\u0089\u0087\u0089\u0090\u008e\u008c\u009b\u0090\u0087\u0089\u0091\u009a\u0088\u008f\u0088\u0089\u0088\u0096\u0086\u0098\u0089\u0099\u0090\u0089\u008e").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.15
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cj.m1607((RewardedAd) list.get(0), (RewardedAdEventListener) list.get(1));
                return null;
            }
        });
        map.put(m1611((String) null, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 127, (int[]) null, "\u0096\u0089\u0087\u0089\u0090\u008e\u008c\u009b\u0090\u0087\u0089\u0091\u009a\u0088\u008f\u008d\u0086\u008c\u0090\u008c\u0090\u008e\u0096\u0089\u0090\u0087¡\u0090\u0089\u008e").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.11
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cj.m1618((InterstitialAd) list.get(0), (InterstitialAdEventListener) list.get(1));
                return null;
            }
        });
        map.put(m1601("\u0000\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0001\u0000", true, new int[]{259, 15, 46, 0}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1594((MediaFile) list.get(0));
            }
        });
        map.put(m1611((String) null, 127 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (int[]) null, "\u0089\u008d\u008c£\u0086\u008c\u0088\u0089\u0094\u0088\u008f\u0082\u0089\u0088\u008c\u0097\u0090\u0089\u009f").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1610((VideoAd) list.get(0));
            }
        });
        map.put(m1601("\u0001\u0001\u0000\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000", false, new int[]{274, 14, 0, 13}).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return cj.m1605((VideoAd) list.get(0));
            }
        });
        map.put(m1611((String) null, 127 - Color.red(0), (int[]) null, "\u0096\u0089\u0087\u0089\u0090\u008e\u008c\u009b\u0090\u0087\u0089\u0091\u009a\u0088\u008f\u0096\u0089\u0087\u0087\u0086\u0095\u0090\u0089\u008e").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.cj.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                cj.m1606((BannerAdView) list.get(0), (BannerAdEventListener) list.get(1));
                return null;
            }
        });
        f1332 = (f1331 + 77) % 128;
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int m1592(Reward reward) {
        f1332 = (f1331 + 83) % 128;
        int amount = reward.getAmount();
        int i2 = f1332 + 109;
        f1331 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 33 / 0;
        }
        return amount;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static AdInfo m1603(InterstitialAd interstitialAd) {
        int i2 = f1331 + 19;
        f1332 = i2 % 128;
        if (i2 % 2 == 0) {
            interstitialAd.getInfo();
            throw null;
        }
        AdInfo info = interstitialAd.getInfo();
        f1331 = (f1332 + 29) % 128;
        return info;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m1617(VideoController videoController, VideoEventListener videoEventListener) {
        f1331 = (f1332 + 51) % 128;
        videoController.setVideoEventListener(videoEventListener);
        int i2 = f1332 + 89;
        f1331 = i2 % 128;
        if (i2 % 2 != 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m1595(BannerAdView bannerAdView, BannerAdEventListener bannerAdEventListener) {
        f1331 = (f1332 + 19) % 128;
        bannerAdView.setBannerAdEventListener(bannerAdEventListener);
        int i2 = f1331 + 31;
        f1332 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static AdInfo m1612(RewardedAd rewardedAd) {
        f1331 = (f1332 + 111) % 128;
        AdInfo info = rewardedAd.getInfo();
        int i2 = f1331 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1332 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 55 / 0;
        }
        return info;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m1619(RewardedAd rewardedAd, RewardedAdEventListener rewardedAdEventListener) {
        f1332 = (f1331 + 73) % 128;
        rewardedAd.setAdEventListener(rewardedAdEventListener);
        int i2 = f1331 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE;
        f1332 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static MediaFile m1613(VideoAd videoAd) {
        int i2 = f1332 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1331 = i2 % 128;
        if (i2 % 2 != 0) {
            videoAd.getMediaFile();
            throw null;
        }
        MediaFile mediaFile = videoAd.getMediaFile();
        f1332 = (f1331 + 11) % 128;
        return mediaFile;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1611(String str, int i2, int[] iArr, String str2) throws UnsupportedEncodingException {
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
                char[] cArr2 = f1334;
                int i8 = f1333;
                if (f1335) {
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
                if (f1337) {
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

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1598(Reward reward) {
        int i2 = f1331 + 77;
        f1332 = i2 % 128;
        int i8 = i2 % 2;
        String type = reward.getType();
        if (i8 == 0) {
            int i9 = 83 / 0;
        }
        int i10 = f1331 + 55;
        f1332 = i10 % 128;
        if (i10 % 2 != 0) {
            return type;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static void m1602(InterstitialAd interstitialAd, InterstitialAdEventListener interstitialAdEventListener) {
        int i2 = f1331 + Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE;
        f1332 = i2 % 128;
        int i8 = i2 % 2;
        interstitialAd.setAdEventListener(interstitialAdEventListener);
        if (i8 == 0) {
            int i9 = 2 / 0;
        }
        f1331 = (f1332 + 69) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1599(MediaFile mediaFile) {
        f1331 = (f1332 + 111) % 128;
        String url = mediaFile.getUrl();
        int i2 = f1332 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1331 = i2 % 128;
        if (i2 % 2 == 0) {
            return url;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1600(VideoAd videoAd) {
        int i2 = f1332 + 5;
        f1331 = i2 % 128;
        int i8 = i2 % 2;
        String info = videoAd.getInfo();
        if (i8 != 0) {
            int i9 = 90 / 0;
        }
        return info;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1601(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f1336, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
