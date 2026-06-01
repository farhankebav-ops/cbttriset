package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickResult;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessageClickResult implements IInAppMessageClickResult {
    private static final String CLICK_NAME = "click_name";
    private static final String CLICK_URL = "click_url";
    private static final String CLOSE = "close";
    private static final String CLOSES_MESSAGE = "closes_message";
    public static final Companion Companion = new Companion(null);
    private static final String FIRST_CLICK = "first_click";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String OUTCOMES = "outcomes";
    private static final String PAGE_ID = "pageId";
    private static final String PROMPTS = "prompts";
    private static final String TAGS = "tags";
    private static final String URL = "url";
    private static final String URL_TARGET = "url_target";
    private final String actionId;
    private final String clickId;
    private final boolean closingMessage;
    private boolean isFirstClick;
    private final List<InAppMessageOutcome> outcomes;
    private final String pageId;
    private final List<InAppMessagePrompt> prompts;
    private InAppMessageTag tags;
    private final String url;
    private InAppMessageActionUrlType urlTarget;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppMessageClickResult(JSONObject json, IInAppMessagePromptFactory promptFactory) throws JSONException {
        k.e(json, "json");
        k.e(promptFactory, "promptFactory");
        this.outcomes = new ArrayList();
        this.prompts = new ArrayList();
        this.clickId = json.optString("id", null);
        this.actionId = json.optString("name", null);
        this.url = json.optString("url", null);
        this.pageId = json.optString("pageId", null);
        setUrlTarget(InAppMessageActionUrlType.Companion.fromString(json.optString(URL_TARGET, null)));
        if (getUrlTarget() == null) {
            setUrlTarget(InAppMessageActionUrlType.IN_APP_WEBVIEW);
        }
        this.closingMessage = json.optBoolean("close", true);
        if (json.has(OUTCOMES)) {
            parseOutcomes(json);
        }
        if (json.has(TAGS)) {
            JSONObject jSONObject = json.getJSONObject(TAGS);
            k.d(jSONObject, "json.getJSONObject(TAGS)");
            this.tags = new InAppMessageTag(jSONObject);
        }
        if (json.has(PROMPTS)) {
            parsePrompts(json, promptFactory);
        }
    }

    private final void parseOutcomes(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(OUTCOMES);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            List<InAppMessageOutcome> list = this.outcomes;
            Object obj = jSONArray.get(i2);
            k.c(obj, "null cannot be cast to non-null type org.json.JSONObject");
            list.add(new InAppMessageOutcome((JSONObject) obj));
        }
    }

    private final void parsePrompts(JSONObject jSONObject, IInAppMessagePromptFactory iInAppMessagePromptFactory) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(PROMPTS);
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            String promptType = jSONArray.getString(i2);
            k.d(promptType, "promptType");
            InAppMessagePrompt inAppMessagePromptCreatePrompt = iInAppMessagePromptFactory.createPrompt(promptType);
            if (inAppMessagePromptCreatePrompt != null) {
                this.prompts.add(inAppMessagePromptCreatePrompt);
            }
        }
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageClickResult
    public String getActionId() {
        return this.actionId;
    }

    public final String getClickId() {
        return this.clickId;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageClickResult
    public boolean getClosingMessage() {
        return this.closingMessage;
    }

    public final List<InAppMessageOutcome> getOutcomes() {
        return this.outcomes;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final List<InAppMessagePrompt> getPrompts() {
        return this.prompts;
    }

    public final InAppMessageTag getTags() {
        return this.tags;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageClickResult
    public String getUrl() {
        return this.url;
    }

    @Override // com.onesignal.inAppMessages.IInAppMessageClickResult
    public InAppMessageActionUrlType getUrlTarget() {
        return this.urlTarget;
    }

    public final boolean isFirstClick() {
        return this.isFirstClick;
    }

    public final void setFirstClick(boolean z2) {
        this.isFirstClick = z2;
    }

    public final void setTags(InAppMessageTag inAppMessageTag) {
        this.tags = inAppMessageTag;
    }

    public void setUrlTarget(InAppMessageActionUrlType inAppMessageActionUrlType) {
        this.urlTarget = inAppMessageActionUrlType;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CLICK_NAME, getActionId());
            jSONObject.put(CLICK_URL, getUrl());
            jSONObject.put(FIRST_CLICK, this.isFirstClick);
            jSONObject.put(CLOSES_MESSAGE, getClosingMessage());
            JSONArray jSONArray = new JSONArray();
            Iterator<InAppMessageOutcome> it = this.outcomes.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSONObject());
            }
            jSONObject.put(OUTCOMES, jSONArray);
            InAppMessageTag inAppMessageTag = this.tags;
            if (inAppMessageTag != null) {
                k.b(inAppMessageTag);
                jSONObject.put(TAGS, inAppMessageTag.toJSONObject());
            }
            if (getUrlTarget() != null) {
                jSONObject.put(URL_TARGET, String.valueOf(getUrlTarget()));
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }
}
