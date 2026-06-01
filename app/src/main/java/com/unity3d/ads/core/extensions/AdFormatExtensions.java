package com.unity3d.ads.core.extensions;

import com.unity3d.ads.AdFormat;
import e2.s;
import gatewayprotocol.v1.AdFormatOuterClass;
import kotlin.jvm.internal.k;
import u3.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AdFormatExtensions {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[AdFormatOuterClass.AdFormat.values().length];
            try {
                iArr[AdFormatOuterClass.AdFormat.AD_FORMAT_REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdFormatOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdFormatOuterClass.AdFormat.AD_FORMAT_BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AdFormatOuterClass.AdFormat.AD_FORMAT_UNSPECIFIED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AdFormat.values().length];
            try {
                iArr2[AdFormat.UNSPECIFIED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AdFormat.BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AdFormat.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AdFormat.REWARDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final AdFormatOuterClass.AdFormat toProtoAdFormat(AdFormat adFormat) {
        k.e(adFormat, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$1[adFormat.ordinal()];
        if (i2 == 1) {
            return AdFormatOuterClass.AdFormat.AD_FORMAT_UNSPECIFIED;
        }
        if (i2 == 2) {
            return AdFormatOuterClass.AdFormat.AD_FORMAT_BANNER;
        }
        if (i2 == 3) {
            return AdFormatOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL;
        }
        if (i2 == 4) {
            return AdFormatOuterClass.AdFormat.AD_FORMAT_REWARDED;
        }
        throw new s(3);
    }

    public static final d toUnityAdFormat(AdFormatOuterClass.AdFormat adFormat) {
        k.e(adFormat, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$0[adFormat.ordinal()];
        if (i2 == 1) {
            return d.f17533c;
        }
        if (i2 == 2) {
            return d.f17532b;
        }
        if (i2 == 3) {
            return d.f17534d;
        }
        if (i2 != 4) {
            return null;
        }
        return d.f17531a;
    }

    public static final d toUnityAdFormat(AdFormat adFormat) {
        k.e(adFormat, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$1[adFormat.ordinal()];
        if (i2 == 1) {
            return d.f17531a;
        }
        if (i2 == 2) {
            return d.f17534d;
        }
        if (i2 == 3) {
            return d.f17532b;
        }
        if (i2 == 4) {
            return d.f17533c;
        }
        throw new s(3);
    }
}
