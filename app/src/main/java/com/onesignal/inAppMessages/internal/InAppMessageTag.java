package com.onesignal.inAppMessages.internal;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageTag {
    private static final String ADD_TAGS = "adds";
    public static final Companion Companion = new Companion(null);
    private static final String REMOVE_TAGS = "removes";
    private JSONObject tagsToAdd;
    private JSONArray tagsToRemove;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppMessageTag(JSONObject json) {
        k.e(json, "json");
        this.tagsToAdd = json.has(ADD_TAGS) ? json.getJSONObject(ADD_TAGS) : null;
        this.tagsToRemove = json.has(REMOVE_TAGS) ? json.getJSONArray(REMOVE_TAGS) : null;
    }

    public final JSONObject getTagsToAdd() {
        return this.tagsToAdd;
    }

    public final JSONArray getTagsToRemove() {
        return this.tagsToRemove;
    }

    public final void setTagsToAdd(JSONObject jSONObject) {
        this.tagsToAdd = jSONObject;
    }

    public final void setTagsToRemove(JSONArray jSONArray) {
        this.tagsToRemove = jSONArray;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = this.tagsToAdd;
            if (jSONObject2 != null) {
                jSONObject.put(ADD_TAGS, jSONObject2);
            }
            JSONArray jSONArray = this.tagsToRemove;
            if (jSONArray != null) {
                jSONObject.put(REMOVE_TAGS, jSONArray);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public String toString() {
        return "OSInAppMessageTag{adds=" + this.tagsToAdd + ", removes=" + this.tagsToRemove + '}';
    }
}
