package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f6333a;

    public Ab(D0 d0) {
        this.f6333a = d0;
    }

    public void a(boolean z2) {
        HashMap map = new HashMap();
        if (z2) {
            map.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f6333a.a(A0.LOAD_AD, map);
    }

    public void b(int i2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        this.f6333a.a(A0.SKIP_RELOAD_AD, map);
    }

    public void a() {
        this.f6333a.a(A0.RELOAD_AD, new HashMap());
    }

    public void b(long j, int i2) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        this.f6333a.a(A0.RELOAD_AD_NO_FILL, map);
    }

    public void a(int i2) {
        HashMap map = new HashMap();
        map.put("sessionDepth", Integer.valueOf(i2));
        this.f6333a.a(A0.DESTROY_AD, map);
    }

    public void a(long j, boolean z2) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        if (z2) {
            map.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f6333a.a(A0.LOAD_AD_SUCCESS, map);
    }

    public void a(long j) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        this.f6333a.a(A0.RELOAD_AD_SUCCESS, map);
    }

    public void a(long j, int i2, boolean z2) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        if (z2) {
            map.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f6333a.a(A0.LOAD_AD_FAILED, map);
    }

    public void a(long j, int i2, String str, boolean z2) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        if (z2) {
            map.put(IronSourceConstants.EVENTS_PUBLISHER_LOAD, Boolean.TRUE);
        }
        this.f6333a.a(A0.LOAD_AD_FAILED_WITH_REASON, map);
    }

    public void a(long j, int i2, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f6333a.a(A0.RELOAD_AD_FAILED_WITH_REASON, map);
    }

    public void a(boolean z2, long j, boolean z7) {
        A0 a02;
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        if (z7) {
            map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceError.ERROR_RV_EXPIRED_ADS));
            map.put("reason", "loaded ads are expired");
        }
        D0 d0 = this.f6333a;
        if (z2) {
            a02 = A0.AD_AVAILABILITY_CHANGED_TRUE;
        } else {
            a02 = A0.AD_AVAILABILITY_CHANGED_FALSE;
        }
        d0.a(a02, map);
    }

    public void a(long j, int i2) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        this.f6333a.a(A0.LOAD_AD_NO_FILL, map);
    }

    public void a(Boolean bool, String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f6333a.a(bool.booleanValue() ? A0.AD_READY_TRUE : A0.AD_READY_FALSE, map);
    }
}
