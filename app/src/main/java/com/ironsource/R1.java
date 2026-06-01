package com.ironsource;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class R1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f7535a;

    public R1(D0 d0) {
        this.f7535a = d0;
    }

    public void a(@Nullable Double d8) {
        HashMap map;
        if (d8 != null) {
            map = new HashMap();
            map.put(IronSourceConstants.EVENTS_EXT1, "flooring=" + d8);
        } else {
            map = null;
        }
        this.f7535a.a(A0.AUCTION_REQUEST, map);
    }

    public void b(String str) {
        this.f7535a.a(A0.AUCTION_REQUEST_WATERFALL, androidx.camera.core.processing.util.a.u(IronSourceConstants.EVENTS_EXT1, str));
    }

    public void c(String str) {
        this.f7535a.a(A0.AUCTION_RESULT_WATERFALL, androidx.camera.core.processing.util.a.u(IronSourceConstants.EVENTS_EXT1, str));
    }

    public String a(int i2, int i8, int i9, int i10) {
        StringBuilder sbW = a1.a.w(i2, "interstitial=", ";rewarded=", i8, ";banner=");
        sbW.append(i9);
        sbW.append(";native=");
        sbW.append(i10);
        return sbW.toString();
    }

    public void a(long j, int i2, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f7535a.a(A0.AUCTION_FAILED, map);
    }

    public void a(int i2, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f7535a.a(A0.AUCTION_FAILED_NO_CANDIDATES, map);
    }

    public void a(long j, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f7535a.a(A0.AUCTION_SUCCESS, map);
    }

    public void a(String str) {
        this.f7535a.a(A0.AD_FORMAT_CAPPED, androidx.camera.core.processing.util.a.u("auctionId", str));
    }
}
