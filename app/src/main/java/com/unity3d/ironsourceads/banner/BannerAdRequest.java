package com.unity3d.ironsourceads.banner;

import android.content.Context;
import android.os.Bundle;
import com.ironsource.C2658yc;
import com.ironsource.InterfaceC2676zd;
import com.ironsource.X9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.ironsourceads.AdSize;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BannerAdRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AdSize f10874d;
    private final Bundle e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InterfaceC2676zd f10875f;
    private final String g;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f10876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f10878c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AdSize f10879d;
        private Bundle e;

        public Builder(Context context, String instanceId, String adm, AdSize size) {
            k.e(context, "context");
            k.e(instanceId, "instanceId");
            k.e(adm, "adm");
            k.e(size, "size");
            this.f10876a = context;
            this.f10877b = instanceId;
            this.f10878c = adm;
            this.f10879d = size;
        }

        public final BannerAdRequest build() {
            IronLog.API.info("instanceId: " + this.f10877b + ", size: " + this.f10879d.getSizeDescription());
            return new BannerAdRequest(this.f10876a, this.f10877b, this.f10878c, this.f10879d, this.e, null);
        }

        public final String getAdm() {
            return this.f10878c;
        }

        public final Context getContext() {
            return this.f10876a;
        }

        public final String getInstanceId() {
            return this.f10877b;
        }

        public final AdSize getSize() {
            return this.f10879d;
        }

        public final Builder withExtraParams(Bundle extraParams) {
            k.e(extraParams, "extraParams");
            this.e = extraParams;
            return this;
        }
    }

    public /* synthetic */ BannerAdRequest(Context context, String str, String str2, AdSize adSize, Bundle bundle, f fVar) {
        this(context, str, str2, adSize, bundle);
    }

    public final String getAdId$mediationsdk_release() {
        return this.g;
    }

    public final String getAdm() {
        return this.f10873c;
    }

    public final Context getContext() {
        return this.f10871a;
    }

    public final Bundle getExtraParams() {
        return this.e;
    }

    public final String getInstanceId() {
        return this.f10872b;
    }

    public final InterfaceC2676zd getProviderName$mediationsdk_release() {
        return this.f10875f;
    }

    public final AdSize getSize() {
        return this.f10874d;
    }

    private BannerAdRequest(Context context, String str, String str2, AdSize adSize, Bundle bundle) {
        this.f10871a = context;
        this.f10872b = str;
        this.f10873c = str2;
        this.f10874d = adSize;
        this.e = bundle;
        this.f10875f = new C2658yc(str);
        String strB = X9.b();
        k.d(strB, "generateMultipleUniqueInstanceId()");
        this.g = strB;
    }
}
