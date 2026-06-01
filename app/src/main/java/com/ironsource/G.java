package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2595v0 f6776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NetworkSettings f6777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q5.f f6778c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ V0 f6779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ G f6780b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(V0 v02, G g) {
            super(0);
            this.f6779a = v02;
            this.f6780b = g;
        }

        @Override // e6.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BaseAdAdapter<?, ?> invoke() {
            return this.f6779a.a(this.f6780b.e(), this.f6780b.a(), this.f6780b.d());
        }
    }

    public G(V0 adTools, AbstractC2595v0 adUnitData, NetworkSettings providerSettings) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adUnitData, "adUnitData");
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        this.f6776a = adUnitData;
        this.f6777b = providerSettings;
        this.f6778c = n7.b.C(new a(adTools, this));
    }

    public final IronSource.a a() {
        return this.f6776a.b().a();
    }

    public final BaseAdAdapter<?, ?> b() {
        return (BaseAdAdapter) this.f6778c.getValue();
    }

    public final String c() {
        String providerName = this.f6777b.getProviderName();
        kotlin.jvm.internal.k.d(providerName, "providerSettings.providerName");
        return providerName;
    }

    public final UUID d() {
        return this.f6776a.b().b();
    }

    public final NetworkSettings e() {
        return this.f6777b;
    }
}
