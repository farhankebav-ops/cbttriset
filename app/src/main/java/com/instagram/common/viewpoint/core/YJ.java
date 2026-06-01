package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.settings.AdInternalSettings;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YJ implements InterfaceC1075Sg {
    public static byte[] A00;
    public static String[] A01 = {"N9cBQFuEXnMHuOhuUHmrN1NbOn9dUH6l", "t4327HI34dmOHxHgJ5Xqb1TMdgfhViRu", "W9WF83HwW2JJuxhyMa", "tDcIRbsxuTPzi4rfI85ylCxCUvgLsm3F", "qO4Uq7mg6XVWSCx2fb2lLTULAXcH9HmN", "DdhWBjv", "pI4BrYZb6jEfbOR6K30piOXwM4lgsdMH", "sO2hGyIlN5zgciGhFXZ1rYz4NH0oO9ru"};

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-70, -73, -54, -73, -43, -58, -56, -59, -71, -69, -55, -55, -65, -60, -67, -43, -59, -58, -54, -65, -59, -60, -55, -43, -71, -59, -53, -60, -54, -56, -49, -43, -63, -69, -49, 48, 45, 64, 45, 75, 60, 62, 59, 47, 49, 63, 63, 53, 58, 51, 75, 59, 60, 64, 53, 59, 58, 63, 75, 55, 49, 69, 5, 2, 21, 2, 32, 17, 19, 16, 4, 6, 20, 20, 10, 15, 8, 32, 16, 17, 21, 10, 16, 15, 20, 32, 20, 21, 2, 21, 6, 32, 12, 6, 26};
        String[] strArr = A01;
        if (strArr[6].charAt(20) == strArr[0].charAt(20)) {
            throw new RuntimeException();
        }
        A01[2] = "00h";
        A00 = bArr;
    }

    static {
        A01();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1075Sg
    public final void ABw(InterfaceC1074Sf interfaceC1074Sf) {
        String[] stringArray;
        Integer integer;
        Integer integer2;
        if (!AdInternalSettings.sDataProcessingOptionsUpdate.getAndSet(false)) {
            return;
        }
        synchronized (AdInternalSettings.sSettingsBundle) {
            stringArray = AdInternalSettings.sSettingsBundle.getStringArray(A00(35, 27, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE));
            integer = AdInternalSettings.sSettingsBundle.getInteger(A00(0, 35, 5));
            integer2 = AdInternalSettings.sSettingsBundle.getInteger(A00(62, 33, 80));
        }
        interfaceC1074Sf.AFC(stringArray, integer, integer2);
    }
}
