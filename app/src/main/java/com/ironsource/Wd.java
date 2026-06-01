package com.ironsource;

import com.ironsource.N0;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Wd extends AbstractC2514q3<Xd> {
    public Wd(List<NetworkSettings> list, Zd zd, String str, boolean z2, C2469na c2469na, C2270ca c2270ca) {
        super(new Ud(str, list, zd, z2), c2469na, c2270ca);
    }

    @Override // com.ironsource.AbstractC2497p3
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Xd a(NetworkSettings networkSettings, BaseAdAdapter<?, AdapterAdRewardListener> baseAdAdapter, int i2, String str, C2461n2 c2461n2) {
        return new Xd(this, new C2421l0(IronSource.a.REWARDED_VIDEO, this.f9596o.o(), i2, this.g, str, this.e, this.f9593f, networkSettings, this.f9596o.n()), baseAdAdapter, c2461n2, this);
    }

    @Override // com.ironsource.AbstractC2497p3
    public K0 g() {
        return new C2274ce();
    }

    @Override // com.ironsource.AbstractC2497p3
    public String l() {
        return IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE;
    }

    @Override // com.ironsource.AbstractC2497p3
    public String o() {
        return IronSourceConstants.OPW_RV_MANAGER_NAME;
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean q() {
        return this.f9596o.h().a() == N0.a.MANUAL;
    }

    @Override // com.ironsource.AbstractC2497p3
    public boolean t() {
        return this.f9596o.h().a() == N0.a.AUTOMATIC_LOAD_WHILE_SHOW;
    }

    @Override // com.ironsource.AbstractC2497p3
    public LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    @Override // com.ironsource.AbstractC2497p3
    public void a(IronSourceError ironSourceError) {
        N0.a aVarA = this.f9596o.h().a();
        if (aVarA != N0.a.AUTOMATIC_LOAD_AFTER_CLOSE && aVarA != N0.a.AUTOMATIC_LOAD_WHILE_SHOW) {
            super.a(ironSourceError);
        } else {
            this.f9600t.a(false, (AdInfo) null);
        }
    }

    @Override // com.ironsource.AbstractC2497p3
    public JSONObject b(NetworkSettings networkSettings) {
        return networkSettings.getRewardedVideoSettings();
    }
}
