package com.onesignal.session.internal.influence;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Influence {
    public static final Companion Companion = new Companion(null);
    public static final String INFLUENCE_CHANNEL = "influence_channel";
    public static final String INFLUENCE_IDS = "influence_ids";
    public static final String INFLUENCE_TYPE = "influence_type";
    private JSONArray ids;
    private InfluenceChannel influenceChannel;
    private InfluenceType influenceType;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public Influence(String jsonString) throws JSONException {
        k.e(jsonString, "jsonString");
        JSONObject jSONObject = new JSONObject(jsonString);
        String string = jSONObject.getString(INFLUENCE_CHANNEL);
        String string2 = jSONObject.getString(INFLUENCE_TYPE);
        String ids = jSONObject.getString(INFLUENCE_IDS);
        this.influenceChannel = InfluenceChannel.Companion.fromString(string);
        this.influenceType = InfluenceType.Companion.fromString(string2);
        k.d(ids, "ids");
        this.ids = ids.length() == 0 ? null : new JSONArray(ids);
    }

    public final Influence copy() {
        return new Influence(this.influenceChannel, this.influenceType, this.ids);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Influence.class.equals(obj.getClass())) {
            Influence influence = (Influence) obj;
            if (this.influenceChannel == influence.influenceChannel && this.influenceType == influence.influenceType) {
                return true;
            }
        }
        return false;
    }

    public final String getDirectId() throws JSONException {
        JSONArray jSONArray = this.ids;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        return jSONArray.getString(0);
    }

    public final JSONArray getIds() {
        return this.ids;
    }

    public final InfluenceChannel getInfluenceChannel() {
        return this.influenceChannel;
    }

    public final InfluenceType getInfluenceType() {
        return this.influenceType;
    }

    public int hashCode() {
        return this.influenceType.hashCode() + (this.influenceChannel.hashCode() * 31);
    }

    public final void setIds(JSONArray jSONArray) {
        this.ids = jSONArray;
    }

    public final void setInfluenceType(InfluenceType influenceType) {
        k.e(influenceType, "<set-?>");
        this.influenceType = influenceType;
    }

    public final String toJSONString() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(INFLUENCE_CHANNEL, this.influenceChannel.toString()).put(INFLUENCE_TYPE, this.influenceType.toString());
        JSONArray jSONArray = this.ids;
        String string = jSONObjectPut.put(INFLUENCE_IDS, jSONArray != null ? String.valueOf(jSONArray) : "").toString();
        k.d(string, "JSONObject()\n           …)\n            .toString()");
        return string;
    }

    public String toString() {
        return "SessionInfluence{influenceChannel=" + this.influenceChannel + ", influenceType=" + this.influenceType + ", ids=" + this.ids + '}';
    }

    public Influence(InfluenceChannel influenceChannel, InfluenceType influenceType, JSONArray jSONArray) {
        k.e(influenceChannel, "influenceChannel");
        k.e(influenceType, "influenceType");
        this.influenceChannel = influenceChannel;
        this.influenceType = influenceType;
        this.ids = jSONArray;
    }
}
