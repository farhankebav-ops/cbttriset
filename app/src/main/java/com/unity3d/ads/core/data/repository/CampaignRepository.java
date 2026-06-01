package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import gatewayprotocol.v1.CampaignStateOuterClass;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface CampaignRepository {
    CampaignStateOuterClass.Campaign getCampaign(ByteString byteString);

    CampaignStateOuterClass.CampaignState getCampaignState();

    void removeState(ByteString byteString);

    void setCampaign(ByteString byteString, CampaignStateOuterClass.Campaign campaign);

    void setLoadTimestamp(ByteString byteString);

    void setShowTimestamp(ByteString byteString);
}
