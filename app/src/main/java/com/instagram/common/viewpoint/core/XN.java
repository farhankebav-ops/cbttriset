package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.bridge.fbsdk.FBLoginASID;
import com.facebook.ads.internal.bridge.gms.AdvertisingId;
import com.facebook.ads.internal.settings.AdInternalSettings;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XN implements SV {
    public static byte[] A01;
    public final SQ A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-20, 25, 15, 29, 26, 20, 15};
    }

    public XN(SQ sq) {
        this.A00 = sq;
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A71() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A7y() {
        return VZ.A02(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A7z() {
        return FBLoginASID.getFBLoginASID();
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A8N() {
        return AdInternalSettings.getMediationService();
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A8U() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final SU A8p() {
        AdvertisingId advertisingIdInfoDirectly = AdvertisingId.getAdvertisingIdInfoDirectly(this.A00);
        if (advertisingIdInfoDirectly == null) {
            return null;
        }
        return new XV(this, advertisingIdInfoDirectly);
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A9I() {
        return AdInternalSettings.getUrlPrefix();
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A9K() {
        return A00(0, 7, 114);
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final String A9L() {
        return BuildConfigApi.getVersionName(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.SV
    public final boolean AAF() {
        return BuildConfigApi.isDebug();
    }
}
