package com.onesignal.inAppMessages.internal.hydrators;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppHydrator {
    public static final Companion Companion = new Companion(null);
    private static final String LIQUID_TAG_SCRIPT = "\n\n<script>\n    setPlayerTags(%s);\n</script>";
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public InAppHydrator(ITime _time, PropertiesModelStore _propertiesModelStore) {
        k.e(_time, "_time");
        k.e(_propertiesModelStore, "_propertiesModelStore");
        this._time = _time;
        this._propertiesModelStore = _propertiesModelStore;
    }

    private final String taggedHTMLString(String str) {
        MapModel<String> tags = this._propertiesModelStore.getModel().getTags();
        k.c(tags, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        String string = new JSONObject(tags).toString();
        k.d(string, "tagsAsJson.toString()");
        return str + String.format(LIQUID_TAG_SCRIPT, Arrays.copyOf(new Object[]{string}, 1));
    }

    public final InAppMessageContent hydrateIAMMessageContent(JSONObject jsonObject) {
        k.e(jsonObject, "jsonObject");
        try {
            InAppMessageContent inAppMessageContent = new InAppMessageContent(jsonObject);
            if (inAppMessageContent.getContentHtml() == null) {
                Logging.debug$default("displayMessage:OnSuccess: No HTML retrieved from loadMessageContent", null, 2, null);
                return null;
            }
            String contentHtml = inAppMessageContent.getContentHtml();
            k.b(contentHtml);
            inAppMessageContent.setContentHtml(taggedHTMLString(contentHtml));
            return inAppMessageContent;
        } catch (JSONException e) {
            Logging.error("Error attempting to hydrate InAppMessageContent: " + jsonObject, e);
            return null;
        }
    }

    public final List<InAppMessage> hydrateIAMMessages(JSONArray jsonArray) throws JSONException {
        k.e(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject = jsonArray.getJSONObject(i2);
            k.d(jSONObject, "jsonArray.getJSONObject(i)");
            InAppMessage inAppMessage = new InAppMessage(jSONObject, this._time);
            if (inAppMessage.getMessageId() != null) {
                arrayList.add(inAppMessage);
            }
        }
        return arrayList;
    }
}
