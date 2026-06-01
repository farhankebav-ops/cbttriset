package com.ironsource;

import androidx.annotation.NonNull;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.ironsource.dg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2294dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final D0 f8250a;

    public C2294dg(D0 d0) {
        this.f8250a = d0;
    }

    public void a(int i2, String str, String str2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        map.put("reason", str);
        map.put(IronSourceConstants.EVENTS_EXT1, str2);
        this.f8250a.a(A0.TROUBLESHOOT_NOTIFICATION_ERROR, map);
    }

    public void b(int i2, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        map.put("reason", str);
        this.f8250a.a(A0.TROUBLESHOOT_LOAD_FAILED, map);
    }

    public void c() {
        this.f8250a.a(A0.TROUBLESHOOT_LOAD_SUCCESS, null);
    }

    public void d() {
        this.f8250a.a(A0.TROUBLESHOOT_SHOW, null);
    }

    public void e() {
        this.f8250a.a(A0.TROUBLESHOOT_SHOW_SUCCESS, null);
    }

    public void f(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_ILLEGAL_STATE, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void g(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_INTERNAL_ERROR, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void h(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_LOAD_SKIPPED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void i(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void j(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void k(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void l(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_CLOSED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void m(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void n(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void o(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void p(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void q(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_OPENED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void r(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void s(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void t(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void u(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_UNEXPECTED_TIMEOUT, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void v(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_WATERFALL_OVERHEAD, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void c(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_BN_RELOAD_EXCEPTION, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void d(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_PAUSE, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void e(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_RESUME, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void b() {
        this.f8250a.a(A0.TROUBLESHOOT_LOAD, null);
    }

    public void a(Long l) {
        HashMap map = new HashMap();
        map.put("duration", l);
        this.f8250a.a(A0.TROUBLESHOOT_LOAD_WHILE_LOADED, map);
    }

    public void b(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_IMPRESSION_TIMEOUT, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void a(LevelPlayAdError levelPlayAdError) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(levelPlayAdError.getErrorCode()));
        map.put("reason", levelPlayAdError.getErrorMessage());
        this.f8250a.a(A0.TROUBLESHOOT_SHOW_FAILED, map);
    }

    public void b(String str, long j, long j3, long j8) {
        HashMap mapU = androidx.camera.core.processing.util.a.u("reason", str);
        mapU.put(IronSourceConstants.EVENTS_EXT1, a(j, j3, j8));
        this.f8250a.a(A0.TROUBLESHOOT_BANNER_REFRESH_RESUMED, mapU);
    }

    public void a(int i2, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2));
        map.put("reason", str);
        this.f8250a.a(A0.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, map);
    }

    public void a(String str) {
        this.f8250a.a(A0.TROUBLESHOOT_AD_EXPIRED, androidx.camera.core.processing.util.a.u("reason", str));
    }

    public void a(String str, long j) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(str.isEmpty() ? "" : a1.a.m("provider=", str, ";"));
        sb.append("expirationDuration=");
        sb.append(j);
        map.put(IronSourceConstants.EVENTS_EXT1, sb.toString());
        this.f8250a.a(A0.TROUBLESHOOT_AD_EXPIRED, map);
    }

    public void a(String str, long j, long j3, long j8) {
        HashMap mapU = androidx.camera.core.processing.util.a.u("reason", str);
        mapU.put(IronSourceConstants.EVENTS_EXT1, a(j, j3, j8));
        this.f8250a.a(A0.TROUBLESHOOT_BANNER_REFRESH_PAUSED, mapU);
    }

    public void a(boolean z2, long j) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, "isAnimated:" + (z2 ? 1 : 0));
        map.put("duration", Long.valueOf(j));
        this.f8250a.a(A0.TROUBLESHOOT_BANNER_REFRESH_TRANSITION, map);
    }

    public void a(long j) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        this.f8250a.a(A0.TROUBLESHOOT_BANNER_REFRESH_ANIMATED, map);
    }

    private String a(long j, long j3, long j8) {
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("interval: ", j, ", remainingTime: ");
        sbT.append(j3);
        sbT.append(", timePassed: ");
        sbT.append(j8);
        return sbT.toString();
    }

    public void a(@NonNull LevelPlayAdInfo levelPlayAdInfo, @NonNull LevelPlayAdInfo levelPlayAdInfo2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, String.format(Locale.ENGLISH, "oldAdNetwork=%s;oldInstanceId=%s;oldRevenue=%.3f;oldPrecision=%s;newAdNetwork=%s;newInstanceId=%s;newRevenue=%.3f;newPrecision=%s;delta=%.3f", levelPlayAdInfo.getAdNetwork(), levelPlayAdInfo.getInstanceId(), Double.valueOf(levelPlayAdInfo.getRevenue()), levelPlayAdInfo.getPrecision(), levelPlayAdInfo2.getAdNetwork(), levelPlayAdInfo2.getInstanceId(), Double.valueOf(levelPlayAdInfo2.getRevenue()), levelPlayAdInfo2.getPrecision(), Double.valueOf(levelPlayAdInfo2.getRevenue() - levelPlayAdInfo.getRevenue())));
        this.f8250a.a(A0.TROUBLESHOOT_AD_INFO_CHANGED, map);
    }

    public void a() {
        this.f8250a.a(A0.TROUBLESHOOT_DISPOSE, null);
    }

    public void a(long j, long j3, String str) {
        HashMap map = new HashMap();
        Locale locale = Locale.ENGLISH;
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("refreshDuration=", j, ";notVisibleDuration=");
        sbT.append(j3);
        sbT.append(";reason=");
        sbT.append(str);
        map.put(IronSourceConstants.EVENTS_EXT1, sbT.toString());
        this.f8250a.a(A0.TROUBLESHOOT_RELOAD, map);
    }
}
