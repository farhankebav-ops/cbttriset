package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.five_corp.ad.CreativeType;
import com.five_corp.ad.FiveAd;
import com.five_corp.ad.FiveAdConfig;
import com.five_corp.ad.FiveAdCustomLayout;
import com.five_corp.ad.FiveAdInterface;
import com.five_corp.ad.FiveAdListener;
import com.five_corp.ad.FiveAdLoadListener;
import com.five_corp.ad.FiveAdViewEventListener;
import com.ironsource.adqualitysdk.sdk.i.bg;
import com.vungle.ads.internal.protos.Sdk;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class br extends bg {

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static int f1007 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f1008 = 2596280672829213887L;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1009 = 0;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f1010 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1011 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static long f1012 = 373955893671153825L;

    public br(String str) {
        super(str);
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static CreativeType m1157(FiveAdInterface fiveAdInterface) {
        int i2 = f1011 + 71;
        f1007 = i2 % 128;
        if (i2 % 2 == 0) {
            fiveAdInterface.getCreativeType();
            throw null;
        }
        CreativeType creativeType = fiveAdInterface.getCreativeType();
        f1011 = (f1007 + 15) % 128;
        return creativeType;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    private static String m1159(FiveAdInterface fiveAdInterface) {
        int i2 = f1011 + 25;
        f1007 = i2 % 128;
        int i8 = i2 % 2;
        String slotId = fiveAdInterface.getSlotId();
        if (i8 == 0) {
            int i9 = 17 / 0;
        }
        int i10 = f1007 + 3;
        f1011 = i10 % 128;
        if (i10 % 2 == 0) {
            return slotId;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    private static String m1160(FiveAdInterface fiveAdInterface) {
        f1011 = (f1007 + 99) % 128;
        String adParameter = fiveAdInterface.getAdParameter();
        f1007 = (f1011 + 97) % 128;
        return adParameter;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static /* synthetic */ FiveAd m1161() {
        int i2 = f1011 + 79;
        f1007 = i2 % 128;
        if (i2 % 2 != 0) {
            return m1158();
        }
        m1158();
        throw null;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private static String m1163(FiveAdInterface fiveAdInterface) {
        int i2 = f1007 + 17;
        f1011 = i2 % 128;
        if (i2 % 2 != 0) {
            fiveAdInterface.getFiveAdTag();
            throw null;
        }
        String fiveAdTag = fiveAdInterface.getFiveAdTag();
        int i8 = f1011 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1007 = i8 % 128;
        if (i8 % 2 != 0) {
            return fiveAdTag;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ CreativeType m1164(FiveAdInterface fiveAdInterface) {
        f1007 = (f1011 + 3) % 128;
        CreativeType creativeTypeM1157 = m1157(fiveAdInterface);
        f1007 = (f1011 + 73) % 128;
        return creativeTypeM1157;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1168(FiveAdConfig fiveAdConfig) {
        int i2 = f1007 + 47;
        f1011 = i2 % 128;
        int i8 = i2 % 2;
        String strM1175 = m1175(fiveAdConfig);
        if (i8 != 0) {
            int i9 = 36 / 0;
        }
        int i10 = f1007 + 51;
        f1011 = i10 % 128;
        if (i10 % 2 == 0) {
            return strM1175;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static /* synthetic */ String m1172(FiveAdInterface fiveAdInterface) {
        int i2 = f1007 + 11;
        f1011 = i2 % 128;
        if (i2 % 2 == 0) {
            return m1163(fiveAdInterface);
        }
        m1163(fiveAdInterface);
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static /* synthetic */ FiveAdListener m1174(FiveAdInterface fiveAdInterface) {
        int i2 = f1011 + 27;
        f1007 = i2 % 128;
        if (i2 % 2 == 0) {
            m1162(fiveAdInterface);
            throw null;
        }
        FiveAdListener fiveAdListenerM1162 = m1162(fiveAdInterface);
        f1011 = (f1007 + 111) % 128;
        return fiveAdListenerM1162;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static /* synthetic */ String m1179(FiveAdInterface fiveAdInterface) {
        int i2 = f1007 + 113;
        f1011 = i2 % 128;
        int i8 = i2 % 2;
        String strM1160 = m1160(fiveAdInterface);
        if (i8 != 0) {
            int i9 = 8 / 0;
        }
        int i10 = f1007 + Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE;
        f1011 = i10 % 128;
        if (i10 % 2 == 0) {
            return strM1160;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static FiveAd m1158() {
        int i2 = f1007 + 77;
        f1011 = i2 % 128;
        if (i2 % 2 != 0) {
            FiveAd.getSingleton();
            throw null;
        }
        FiveAd singleton = FiveAd.getSingleton();
        int i8 = f1011 + 25;
        f1007 = i8 % 128;
        if (i8 % 2 != 0) {
            return singleton;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    private static FiveAdListener m1162(FiveAdInterface fiveAdInterface) {
        int i2 = f1011 + 23;
        f1007 = i2 % 128;
        int i8 = i2 % 2;
        FiveAdListener listener = fiveAdInterface.getListener();
        if (i8 == 0) {
            int i9 = 13 / 0;
        }
        return listener;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ String m1165(FiveAdCustomLayout fiveAdCustomLayout) {
        f1011 = (f1007 + 101) % 128;
        String strM1178 = m1178(fiveAdCustomLayout);
        f1011 = (f1007 + 115) % 128;
        return strM1178;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ String m1169(FiveAdInterface fiveAdInterface) {
        f1011 = (f1007 + 9) % 128;
        String strM1159 = m1159(fiveAdInterface);
        int i2 = f1007 + 77;
        f1011 = i2 % 128;
        if (i2 % 2 == 0) {
            return strM1159;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1173(String str, int i2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (j.f2671) {
            try {
                j.f2669 = i2;
                char[] cArr2 = new char[cArr.length];
                j.f2670 = 0;
                while (true) {
                    int i8 = j.f2670;
                    if (i8 < cArr.length) {
                        cArr2[i8] = (char) (((long) (cArr[i8] ^ (j.f2669 * i8))) ^ f1008);
                        j.f2670++;
                    } else {
                        str2 = new String(cArr2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static String m1178(FiveAdCustomLayout fiveAdCustomLayout) {
        f1007 = (f1011 + 39) % 128;
        String advertiserName = fiveAdCustomLayout.getAdvertiserName();
        int i2 = f1011 + 101;
        f1007 = i2 % 128;
        if (i2 % 2 != 0) {
            return advertiserName;
        }
        throw null;
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﾇ */
    public final Map<String, bg.a> mo827() {
        HashMap map = new HashMap();
        map.put(m1170("쐞\uf477\u0097ﵸ", (char) View.MeasureSpec.makeMeasureSpec(0, 0), "爲榝ᑣ❞禠飒ꗳ칾\udfea：戊ƣ脐ꚿ졞冉꼮끎欚˸", View.MeasureSpec.getSize(0), "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.1
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1168((FiveAdConfig) list.get(0));
            }
        });
        map.put(m1173("賘箣戹檒儲妔䀌䢱㜓㾷♫\u2ef8ᕶᷨч\u0cc9בֿ\ue3d3\uea6e턨\ud9a4쀦좐뜄", TextUtils.indexOf("", "", 0) + 63353).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.5
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1169((FiveAdInterface) list.get(0));
            }
        });
        map.put(m1173("賘㐗ﵑꚞ濢\u10c8\ud814腥䪳\uf3c3듓簄╆\ueea4韯壝\f쥇犁㯩ﳜ", 47309 - View.MeasureSpec.getSize(0)).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.3
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1172((FiveAdInterface) list.get(0));
            }
        });
        map.put(m1170("뗰醧琣ᦘ", (char) (39028 - View.resolveSizeAndState(0, 0, 0)), "ᄞ눤\uf10bᶪ쭐҅⸕樞袿飄酱덚렏ꔱ댉趽뚨㜬矾뒓蟧㏖솁⫐駈ź앾뗂㺤\uaad8", ViewConfiguration.getMaximumFlingVelocity() >> 16, "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.10
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1164((FiveAdInterface) list.get(0));
            }
        });
        map.put(m1170("鹵䍠㠁Ⱓ", (char) (9015 - TextUtils.lastIndexOf("", '0')), "л\ude28\uda90ꉩ\ue998㴬〣\u20fc搼켯\ud9f8Kț싦ᐘ溑ꍏࣆ沨媪䪆ş\uf795⼟\uec7a旈븂蚚괚", ExpandableListView.getPackedPositionType(0L) + 21192862, "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.8
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1179((FiveAdInterface) list.get(0));
            }
        });
        map.put(m1170("봳ᦗ嵟專", (char) (2142 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), "ꤹ毾ᱶ┸⨉ﯫ良륈칛퇸睊\ued67탣諸쉗᳗臩맳츻ޫ嵿\ue2ca\ude7d滋\ueabb㴡", View.MeasureSpec.getMode(0), "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.6
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1174((FiveAdInterface) list.get(0));
            }
        });
        map.put(m1170("ꉽ\u0a52쒯釣", (char) (TextUtils.lastIndexOf("", '0', 0) + 58309), "襇餼䠆\ue221쑧켘荞Ბꈉ༓휯⟦䘙掭\uf381裕ᚫꦅƖ\ue4e0\ue902녈\uf607\uea1d櫟컳", '0' - AndroidCharacter.getMirror('0'), "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.9
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                br.m1171((FiveAdInterface) list.get(0), (FiveAdListener) list.get(1));
                return null;
            }
        });
        map.put(m1170("ҡ\ue9d8껤ڍ", (char) (36270 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), "庠ᬗꏠ㬍봔傖ᜑ⮄律쏱瓈\u206f肯躪劚镖柪∑", KeyEvent.getDeadChar(0, 0), "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.7
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1161();
            }
        });
        map.put(m1173("賘䶩อ좠褚䯶Ѩ웛蝃䇷ʴ쌽鶯帇ᢘ\ud94e鯮呥ᛆ흃逷劑ጹ\ued9c긒棶⥥\uebf7ꑘ曝➷\ue01cꊾ持㶜", (ViewConfiguration.getScrollBarSize() >> 8) + 49523).intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.12
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                return br.m1165((FiveAdCustomLayout) list.get(0));
            }
        });
        map.put(m1170("帘峝袹若", (char) (29832 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))), "\ue1b7흹\uf5b5\uf1a6闻๑쌓\ue036垢鱺걮ਉ锖疝螤", Color.alpha(0) - 1185096354, "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.2
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                br.m1166((FiveAdInterface) list.get(0), (FiveAdLoadListener) list.get(1));
                return null;
            }
        });
        map.put(m1170("킯끅雟\ue5d8", (char) View.combineMeasuredStates(0, 0), "携ං欦跶勖剴≢\ue40b㦛舽吲谙忚\uedbb\ue73a쇳ᱏ꣗ᴔ\ude32", TextUtils.getOffsetBefore("", 0), "킡毮軧\u0530").intern(), new bg.a() { // from class: com.ironsource.adqualitysdk.sdk.i.br.4
            @Override // com.ironsource.adqualitysdk.sdk.i.bg.a
            /* JADX INFO: renamed from: ﻐ */
            public final Object mo828(List<Object> list, ch chVar) {
                br.m1167((FiveAdInterface) list.get(0), (FiveAdViewEventListener) list.get(1));
                return null;
            }
        });
        int i2 = f1007 + 15;
        f1011 = i2 % 128;
        if (i2 % 2 != 0) {
            int i8 = 24 / 0;
        }
        return map;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m1166(FiveAdInterface fiveAdInterface, FiveAdLoadListener fiveAdLoadListener) {
        f1011 = (f1007 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
        m1180(fiveAdInterface, fiveAdLoadListener);
        f1007 = (f1011 + 19) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static /* synthetic */ void m1171(FiveAdInterface fiveAdInterface, FiveAdListener fiveAdListener) {
        int i2 = f1011 + 57;
        f1007 = i2 % 128;
        int i8 = i2 % 2;
        m1176(fiveAdInterface, fiveAdListener);
        if (i8 == 0) {
            throw null;
        }
        int i9 = f1011 + 23;
        f1007 = i9 % 128;
        if (i9 % 2 == 0) {
            throw null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static void m1180(FiveAdInterface fiveAdInterface, FiveAdLoadListener fiveAdLoadListener) {
        int i2 = f1011 + 27;
        f1007 = i2 % 128;
        int i8 = i2 % 2;
        fiveAdInterface.setLoadListener(fiveAdLoadListener);
        if (i8 == 0) {
            int i9 = 13 / 0;
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static /* synthetic */ void m1167(FiveAdInterface fiveAdInterface, FiveAdViewEventListener fiveAdViewEventListener) {
        int i2 = f1011 + 83;
        f1007 = i2 % 128;
        int i8 = i2 % 2;
        m1177(fiveAdInterface, fiveAdViewEventListener);
        if (i8 == 0) {
            int i9 = 1 / 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0277  */
    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻛ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Class mo826(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 920
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adqualitysdk.sdk.i.br.mo826(java.lang.String):java.lang.Class");
    }

    @Override // com.ironsource.adqualitysdk.sdk.i.bg
    /* JADX INFO: renamed from: ﻐ */
    public final String mo825() {
        f1007 = (f1011 + 53) % 128;
        String sdkSemanticVersion = FiveAd.getSdkSemanticVersion();
        int i2 = f1011 + 59;
        f1007 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 47 / 0;
        }
        return sdkSemanticVersion;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m1175(FiveAdConfig fiveAdConfig) {
        f1007 = (f1011 + 59) % 128;
        String str = fiveAdConfig.appId;
        f1007 = (f1011 + 115) % 128;
        return str;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m1176(FiveAdInterface fiveAdInterface, FiveAdListener fiveAdListener) {
        int i2 = f1011 + 11;
        f1007 = i2 % 128;
        int i8 = i2 % 2;
        fiveAdInterface.setListener(fiveAdListener);
        if (i8 == 0) {
            throw null;
        }
        f1011 = (f1007 + 103) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static void m1177(FiveAdInterface fiveAdInterface, FiveAdViewEventListener fiveAdViewEventListener) {
        int i2 = f1007 + 49;
        f1011 = i2 % 128;
        int i8 = i2 % 2;
        fiveAdInterface.setViewEventListener(fiveAdViewEventListener);
        if (i8 != 0) {
            int i9 = 64 / 0;
        }
        f1007 = (f1011 + 67) % 128;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m1170(String str, char c7, String str2, int i2, String str3) {
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
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1012) ^ ((long) f1009)) ^ ((long) f1010));
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
}
