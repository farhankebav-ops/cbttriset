package com.onesignal.session.internal.influence.impl;

import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.influence.InfluenceChannel;
import com.onesignal.session.internal.influence.InfluenceType;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageTracker extends ChannelTracker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessageTracker(InfluenceDataRepository dataRepository, ITime timeProvider) {
        super(dataRepository, timeProvider);
        k.e(dataRepository, "dataRepository");
        k.e(timeProvider, "timeProvider");
    }

    @Override // com.onesignal.session.internal.influence.impl.IChannelTracker
    public void cacheState() {
        InfluenceType influenceType = getInfluenceType();
        if (influenceType == null) {
            influenceType = InfluenceType.UNATTRIBUTED;
        }
        InfluenceDataRepository dataRepository = getDataRepository();
        if (influenceType == InfluenceType.DIRECT) {
            influenceType = InfluenceType.INDIRECT;
        }
        dataRepository.cacheIAMInfluenceType(influenceType);
    }

    @Override // com.onesignal.session.internal.influence.impl.ChannelTracker
    public int getChannelLimit() {
        return getDataRepository().getIamLimit();
    }

    @Override // com.onesignal.session.internal.influence.impl.IChannelTracker
    public InfluenceChannel getChannelType() {
        return InfluenceChannel.IAM;
    }

    @Override // com.onesignal.session.internal.influence.impl.IChannelTracker
    public String getIdTag() {
        return InfluenceConstants.IAM_ID_TAG;
    }

    @Override // com.onesignal.session.internal.influence.impl.ChannelTracker
    public int getIndirectAttributionWindow() {
        return getDataRepository().getIamIndirectAttributionWindow();
    }

    @Override // com.onesignal.session.internal.influence.impl.ChannelTracker
    public JSONArray getLastChannelObjects() throws JSONException {
        return getDataRepository().getLastIAMsReceivedData();
    }

    @Override // com.onesignal.session.internal.influence.impl.ChannelTracker
    public JSONArray getLastChannelObjectsReceivedByNewId(String str) {
        try {
            JSONArray lastChannelObjects = getLastChannelObjects();
            try {
                JSONArray jSONArray = new JSONArray();
                int length = lastChannelObjects.length();
                for (int i2 = 0; i2 < length; i2++) {
                    if (!k.a(str, lastChannelObjects.getJSONObject(i2).getString(getIdTag()))) {
                        jSONArray.put(lastChannelObjects.getJSONObject(i2));
                    }
                }
                return jSONArray;
            } catch (JSONException e) {
                Logging.error("Generating tracker lastChannelObjectReceived get JSONObject ", e);
                return lastChannelObjects;
            }
        } catch (JSONException e4) {
            Logging.error("Generating IAM tracker getLastChannelObjects JSONObject ", e4);
            return new JSONArray();
        }
    }

    @Override // com.onesignal.session.internal.influence.impl.ChannelTracker
    public void initInfluencedTypeFromCache() {
        InfluenceType iamCachedInfluenceType = getDataRepository().getIamCachedInfluenceType();
        if (iamCachedInfluenceType.isIndirect()) {
            setIndirectIds(getLastReceivedIds());
        }
        setInfluenceType(iamCachedInfluenceType);
        Logging.debug$default("InAppMessageTracker.initInfluencedTypeFromCache: " + this, null, 2, null);
    }

    @Override // com.onesignal.session.internal.influence.impl.ChannelTracker
    public void saveChannelObjects(JSONArray channelObjects) {
        k.e(channelObjects, "channelObjects");
        getDataRepository().saveIAMs(channelObjects);
    }
}
