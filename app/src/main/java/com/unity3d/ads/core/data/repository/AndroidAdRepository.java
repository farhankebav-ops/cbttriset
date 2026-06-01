package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidAdRepository implements AdRepository {
    private final ConcurrentHashMap<ByteString, AdObject> loadedAds = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<ByteString>> placementsLoadedAds = new ConcurrentHashMap<>();

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public void addAd(ByteString opportunityId, AdObject adObject) {
        k.e(opportunityId, "opportunityId");
        k.e(adObject, "adObject");
        this.loadedAds.put(opportunityId, adObject);
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public void enqueueOpportunityForPlacement(String placementId, ByteString opportunityId) {
        List<ByteString> listPutIfAbsent;
        k.e(placementId, "placementId");
        k.e(opportunityId, "opportunityId");
        ConcurrentHashMap<String, List<ByteString>> concurrentHashMap = this.placementsLoadedAds;
        List<ByteString> arrayList = concurrentHashMap.get(placementId);
        if (arrayList == null && (listPutIfAbsent = concurrentHashMap.putIfAbsent(placementId, (arrayList = new ArrayList<>()))) != null) {
            arrayList = listPutIfAbsent;
        }
        arrayList.add(opportunityId);
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public AdObject getAd(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        return this.loadedAds.get(opportunityId);
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public Map<ByteString, AdObject> getAllAds() {
        return x.n0(this.loadedAds);
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public boolean hasOpportunityId(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        return this.loadedAds.containsKey(opportunityId);
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public ByteString pollOpportunityIdForPlacement(String placementId) {
        k.e(placementId, "placementId");
        List<ByteString> list = this.placementsLoadedAds.get(placementId);
        if (list != null) {
            return list.isEmpty() ? null : list.remove(0);
        }
        return null;
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    public void removeAd(ByteString opportunityId) {
        k.e(opportunityId, "opportunityId");
        this.loadedAds.remove(opportunityId);
    }
}
