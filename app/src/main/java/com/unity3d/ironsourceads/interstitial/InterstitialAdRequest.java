package com.unity3d.ironsourceads.interstitial;

import android.os.Bundle;
import com.ironsource.C2658yc;
import com.ironsource.InterfaceC2676zd;
import com.ironsource.X9;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InterstitialAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f10889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2676zd f10890d;
    private final String e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f10893c;

        public Builder(String instanceId, String adm) {
            k.e(instanceId, "instanceId");
            k.e(adm, "adm");
            this.f10891a = instanceId;
            this.f10892b = adm;
        }

        public final InterstitialAdRequest build() {
            IronLog.API.info("instanceId: " + this.f10891a);
            return new InterstitialAdRequest(this.f10891a, this.f10892b, this.f10893c, null);
        }

        public final String getAdm() {
            return this.f10892b;
        }

        public final String getInstanceId() {
            return this.f10891a;
        }

        public final Builder withExtraParams(Bundle extraParams) {
            k.e(extraParams, "extraParams");
            this.f10893c = extraParams;
            return this;
        }
    }

    public /* synthetic */ InterstitialAdRequest(String str, String str2, Bundle bundle, f fVar) {
        this(str, str2, bundle);
    }

    public final String getAdId$mediationsdk_release() {
        return this.e;
    }

    public final String getAdm() {
        return this.f10888b;
    }

    public final Bundle getExtraParams() {
        return this.f10889c;
    }

    public final String getInstanceId() {
        return this.f10887a;
    }

    public final InterfaceC2676zd getProviderName$mediationsdk_release() {
        return this.f10890d;
    }

    private InterstitialAdRequest(String str, String str2, Bundle bundle) {
        this.f10887a = str;
        this.f10888b = str2;
        this.f10889c = bundle;
        this.f10890d = new C2658yc(str);
        String strB = X9.b();
        k.d(strB, "generateMultipleUniqueInstanceId()");
        this.e = strB;
    }
}
