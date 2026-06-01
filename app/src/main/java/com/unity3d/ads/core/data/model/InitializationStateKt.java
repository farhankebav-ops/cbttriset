package com.unity3d.ads.core.data.model;

import com.unity3d.services.core.properties.SdkProperties;
import e2.s;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InitializationStateKt {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[InitializationState.values().length];
            try {
                iArr[InitializationState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationState.INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InitializationState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[SdkProperties.InitializationState.values().length];
            try {
                iArr2[SdkProperties.InitializationState.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SdkProperties.InitializationState.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SdkProperties.InitializationState.INITIALIZED_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final InitializationState toBold(SdkProperties.InitializationState initializationState) {
        k.e(initializationState, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$1[initializationState.ordinal()];
        if (i2 == 1) {
            return InitializationState.NOT_INITIALIZED;
        }
        if (i2 == 2) {
            return InitializationState.INITIALIZING;
        }
        if (i2 == 3) {
            return InitializationState.INITIALIZED;
        }
        if (i2 == 4) {
            return InitializationState.FAILED;
        }
        throw new s(3);
    }

    public static final SdkProperties.InitializationState toLegacy(InitializationState initializationState) {
        k.e(initializationState, "<this>");
        int i2 = WhenMappings.$EnumSwitchMapping$0[initializationState.ordinal()];
        if (i2 == 1) {
            return SdkProperties.InitializationState.NOT_INITIALIZED;
        }
        if (i2 == 2) {
            return SdkProperties.InitializationState.INITIALIZING;
        }
        if (i2 == 3) {
            return SdkProperties.InitializationState.INITIALIZED_SUCCESSFULLY;
        }
        if (i2 == 4) {
            return SdkProperties.InitializationState.INITIALIZED_FAILED;
        }
        throw new s(3);
    }
}
