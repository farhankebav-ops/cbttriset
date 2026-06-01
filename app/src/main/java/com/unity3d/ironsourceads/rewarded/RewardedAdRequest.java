package com.unity3d.ironsourceads.rewarded;

import android.os.Bundle;
import com.ironsource.C2658yc;
import com.ironsource.InterfaceC2676zd;
import com.ironsource.X9;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RewardedAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Bundle f10901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InterfaceC2676zd f10902d;
    private final String e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f10905c;

        public Builder(String instanceId, String adm) {
            k.e(instanceId, "instanceId");
            k.e(adm, "adm");
            this.f10903a = instanceId;
            this.f10904b = adm;
        }

        public final RewardedAdRequest build() {
            IronLog.API.info("instanceId: " + this.f10903a);
            return new RewardedAdRequest(this.f10903a, this.f10904b, this.f10905c, null);
        }

        public final String getAdm() {
            return this.f10904b;
        }

        public final String getInstanceId() {
            return this.f10903a;
        }

        public final Builder withExtraParams(Bundle extraParams) {
            k.e(extraParams, "extraParams");
            this.f10905c = extraParams;
            return this;
        }
    }

    public /* synthetic */ RewardedAdRequest(String str, String str2, Bundle bundle, f fVar) {
        this(str, str2, bundle);
    }

    public final String getAdId$mediationsdk_release() {
        return this.e;
    }

    public final String getAdm() {
        return this.f10900b;
    }

    public final Bundle getExtraParams() {
        return this.f10901c;
    }

    public final String getInstanceId() {
        return this.f10899a;
    }

    public final InterfaceC2676zd getProviderName$mediationsdk_release() {
        return this.f10902d;
    }

    private RewardedAdRequest(String str, String str2, Bundle bundle) {
        this.f10899a = str;
        this.f10900b = str2;
        this.f10901c = bundle;
        this.f10902d = new C2658yc(str);
        String strB = X9.b();
        k.d(strB, "generateMultipleUniqueInstanceId()");
        this.e = strB;
    }
}
