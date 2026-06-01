package com.onesignal.inAppMessages.internal;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageOutcome {
    public static final Companion Companion = new Companion(null);
    private static final String OUTCOME_NAME = "name";
    private static final String OUTCOME_UNIQUE = "unique";
    private static final String OUTCOME_WEIGHT = "weight";
    private boolean isUnique;
    private String name;
    private float weight;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppMessageOutcome(JSONObject json) throws JSONException {
        k.e(json, "json");
        String string = json.getString("name");
        k.d(string, "json.getString(OUTCOME_NAME)");
        this.name = string;
        this.weight = json.has("weight") ? (float) json.getDouble("weight") : 0.0f;
        this.isUnique = json.has(OUTCOME_UNIQUE) && json.getBoolean(OUTCOME_UNIQUE);
    }

    public final String getName() {
        return this.name;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final boolean isUnique() {
        return this.isUnique;
    }

    public final void setName(String str) {
        k.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUnique(boolean z2) {
        this.isUnique = z2;
    }

    public final void setWeight(float f4) {
        this.weight = f4;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("weight", this.weight);
            jSONObject.put(OUTCOME_UNIQUE, this.isUnique);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OSInAppMessageOutcome{name='");
        sb.append(this.name);
        sb.append("', weight=");
        sb.append(this.weight);
        sb.append(", unique=");
        return a1.a.t(sb, this.isUnique, '}');
    }
}
