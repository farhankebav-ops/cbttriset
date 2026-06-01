package com.unity3d.ads.core.extensions;

import com.unity3d.ads.UnityAds;
import com.unity3d.ads.adplayer.model.ShowStatus;
import e2.s;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ShowStatusExtensionsKt {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[NativeConfigurationOuterClass.ShowCompletionState.values().length];
            try {
                iArr[NativeConfigurationOuterClass.ShowCompletionState.SHOW_COMPLETION_STATE_COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NativeConfigurationOuterClass.ShowCompletionState.SHOW_COMPLETION_STATE_SKIPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ShowStatus.values().length];
            try {
                iArr2[ShowStatus.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ShowStatus.SKIPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ShowStatus.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final UnityAds.UnityAdsShowCompletionState toUnityAdsShowCompletionState(ShowStatus showStatus, NativeConfigurationOuterClass.ShowCompletionState defaultShowCompletionState) {
        k.e(showStatus, "<this>");
        k.e(defaultShowCompletionState, "defaultShowCompletionState");
        int i2 = WhenMappings.$EnumSwitchMapping$1[showStatus.ordinal()];
        if (i2 == 1) {
            return UnityAds.UnityAdsShowCompletionState.COMPLETED;
        }
        if (i2 == 2) {
            return UnityAds.UnityAdsShowCompletionState.SKIPPED;
        }
        if (i2 != 3) {
            throw new s(3);
        }
        int i8 = WhenMappings.$EnumSwitchMapping$0[defaultShowCompletionState.ordinal()];
        return i8 != 1 ? i8 != 2 ? UnityAds.UnityAdsShowCompletionState.COMPLETED : UnityAds.UnityAdsShowCompletionState.SKIPPED : UnityAds.UnityAdsShowCompletionState.COMPLETED;
    }
}
