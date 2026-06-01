package com.google.ads.mediation.pangle;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleRequestHelper {

    @VisibleForTesting
    public static final String ADMOB_WATERMARK_KEY = "admob_watermark";

    private PangleRequestHelper() {
    }

    public static void setWatermarkString(PAGRequest pAGRequest, String str, MediationAdConfiguration mediationAdConfiguration) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String watermark = mediationAdConfiguration.getWatermark();
        if (TextUtils.isEmpty(watermark)) {
            return;
        }
        Map<String, Object> extraInfo = pAGRequest.getExtraInfo();
        if (extraInfo == null) {
            extraInfo = new HashMap<>();
        }
        extraInfo.put(ADMOB_WATERMARK_KEY, watermark);
        pAGRequest.setExtraInfo(extraInfo);
    }
}
