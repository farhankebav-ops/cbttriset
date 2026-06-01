package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import gatewayprotocol.v1.CampaignKt;
import gatewayprotocol.v1.CampaignStateKt;
import gatewayprotocol.v1.CampaignStateOuterClass;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.i;
import r5.s;
import r5.x;
import t6.d1;
import t6.q0;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidCampaignRepository implements CampaignRepository {
    private final q0 campaigns;
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public AndroidCampaignRepository(GetSharedDataTimestamps getSharedDataTimestamps) {
        k.e(getSharedDataTimestamps, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps;
        this.campaigns = x0.c(s.f13639a);
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public CampaignStateOuterClass.Campaign getCampaign(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        return (CampaignStateOuterClass.Campaign) ((Map) ((d1) this.campaigns).getValue()).get(opportunityId.toStringUtf8());
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public CampaignStateOuterClass.CampaignState getCampaignState() {
        Collection collectionValues = ((Map) ((d1) this.campaigns).getValue()).values();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionValues) {
            if (((CampaignStateOuterClass.Campaign) obj).hasShowTimestamp()) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        CampaignStateKt.Dsl.Companion companion = CampaignStateKt.Dsl.Companion;
        CampaignStateOuterClass.CampaignState.Builder builderNewBuilder = CampaignStateOuterClass.CampaignState.newBuilder();
        k.d(builderNewBuilder, "newBuilder()");
        CampaignStateKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.addAllShownCampaigns(dsl_create.getShownCampaigns(), arrayList);
        dsl_create.addAllLoadedCampaigns(dsl_create.getLoadedCampaigns(), arrayList2);
        return dsl_create._build();
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void removeState(ByteString opportunityId) {
        d1 d1Var;
        Object value;
        LinkedHashMap linkedHashMapO0;
        k.e(opportunityId, "opportunityId");
        q0 q0Var = this.campaigns;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
            Map map = (Map) value;
            String stringUtf8 = opportunityId.toStringUtf8();
            k.d(stringUtf8, "opportunityId.toStringUtf8()");
            k.e(map, "<this>");
            linkedHashMapO0 = x.o0(map);
            linkedHashMapO0.remove(stringUtf8);
        } while (!d1Var.g(value, x.h0(linkedHashMapO0)));
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void setCampaign(ByteString opportunityId, CampaignStateOuterClass.Campaign campaign) {
        d1 d1Var;
        Object value;
        k.e(opportunityId, "opportunityId");
        k.e(campaign, "campaign");
        q0 q0Var = this.campaigns;
        do {
            d1Var = (d1) q0Var;
            value = d1Var.getValue();
        } while (!d1Var.g(value, x.j0((Map) value, new i(opportunityId.toStringUtf8(), campaign))));
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void setLoadTimestamp(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        CampaignStateOuterClass.Campaign campaign = getCampaign(opportunityId);
        if (campaign != null) {
            CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.Companion;
            CampaignStateOuterClass.Campaign.Builder builder = campaign.toBuilder();
            k.d(builder, "this.toBuilder()");
            CampaignKt.Dsl dsl_create = companion._create(builder);
            dsl_create.setLoadTimestamp(this.getSharedDataTimestamps.invoke());
            setCampaign(opportunityId, dsl_create._build());
        }
    }

    @Override // com.unity3d.ads.core.data.repository.CampaignRepository
    public void setShowTimestamp(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        CampaignStateOuterClass.Campaign campaign = getCampaign(opportunityId);
        if (campaign != null) {
            CampaignKt.Dsl.Companion companion = CampaignKt.Dsl.Companion;
            CampaignStateOuterClass.Campaign.Builder builder = campaign.toBuilder();
            k.d(builder, "this.toBuilder()");
            CampaignKt.Dsl dsl_create = companion._create(builder);
            dsl_create.setShowTimestamp(this.getSharedDataTimestamps.invoke());
            setCampaign(opportunityId, dsl_create._build());
        }
    }
}
