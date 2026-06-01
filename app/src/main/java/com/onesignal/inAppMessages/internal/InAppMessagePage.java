package com.onesignal.inAppMessages.internal;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class InAppMessagePage {
    public static final Companion Companion = new Companion(null);
    public static final String PAGE_ID = "pageId";
    public static final String PAGE_INDEX = "pageIndex";
    private String pageId;
    private String pageIndex;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppMessagePage(JSONObject jsonObject) {
        k.e(jsonObject, "jsonObject");
        this.pageId = jsonObject.optString(PAGE_ID, null);
        this.pageIndex = jsonObject.optString(PAGE_INDEX, null);
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageIndex() {
        return this.pageIndex;
    }

    public final void setPageId(String str) {
        this.pageId = str;
    }

    public final void setPageIndex(String str) {
        this.pageIndex = str;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PAGE_ID, this.pageId);
            jSONObject.put(PAGE_INDEX, this.pageIndex);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
