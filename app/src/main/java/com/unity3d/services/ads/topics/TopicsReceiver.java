package com.unity3d.services.ads.topics;

import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.os.OutcomeReceiver;
import androidx.privacysandbox.ads.adservices.topics.a;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TopicsReceiver implements OutcomeReceiver {
    private final IEventSender eventSender;

    public TopicsReceiver(IEventSender eventSender) {
        k.e(eventSender, "eventSender");
        this.eventSender = eventSender;
    }

    public final JSONObject formatTopic(Topic topic) throws JSONException {
        k.e(topic, "topic");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taxonomyVersion", topic.getTaxonomyVersion());
        jSONObject.put("modelVersion", topic.getModelVersion());
        jSONObject.put("topicId", topic.getTopicId());
        return jSONObject;
    }

    public /* bridge */ /* synthetic */ void onResult(Object obj) {
        onResult(a.d(obj));
    }

    public void onError(Exception error) {
        k.e(error, "error");
        DeviceLog.debug("GetTopics exception: " + error);
        this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, error.toString());
    }

    public void onResult(GetTopicsResponse result) {
        k.e(result, "result");
        JSONArray jSONArray = new JSONArray();
        List topics = result.getTopics();
        k.d(topics, "result.topics");
        Iterator it = topics.iterator();
        while (it.hasNext()) {
            Topic it2 = androidx.privacysandbox.ads.adservices.measurement.a.r(it.next());
            k.d(it2, "it");
            jSONArray.put(formatTopic(it2));
        }
        IEventSender iEventSender = this.eventSender;
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.TOPICS;
        TopicsEvents topicsEvents = TopicsEvents.TOPICS_AVAILABLE;
        String string = jSONArray.toString();
        k.d(string, "resultArray.toString()");
        iEventSender.sendEvent(webViewEventCategory, topicsEvents, string);
    }
}
