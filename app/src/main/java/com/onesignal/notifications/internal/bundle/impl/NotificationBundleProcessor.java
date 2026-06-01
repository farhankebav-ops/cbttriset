package com.onesignal.notifications.internal.bundle.impl;

import android.content.Context;
import android.os.Bundle;
import com.ironsource.C2300e4;
import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.common.NotificationConstants;
import com.onesignal.notifications.internal.common.NotificationFormatHelper;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationBundleProcessor implements INotificationBundleProcessor {
    private static final String ANDROID_NOTIFICATION_ID = "android_notif_id";
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_ACTION = "__DEFAULT__";
    public static final String PUSH_ADDITIONAL_DATA_KEY = "a";
    public static final String PUSH_MINIFIED_BUTTONS_LIST = "o";
    public static final String PUSH_MINIFIED_BUTTON_ICON = "p";
    public static final String PUSH_MINIFIED_BUTTON_ID = "i";
    public static final String PUSH_MINIFIED_BUTTON_TEXT = "n";
    private final ITime _time;
    private final INotificationGenerationWorkManager _workManager;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public NotificationBundleProcessor(INotificationGenerationWorkManager _workManager, ITime _time) {
        k.e(_workManager, "_workManager");
        k.e(_time, "_time");
        this._workManager = _workManager;
        this._time = _time;
    }

    private final void maximizeButtonsFromBundle(Bundle bundle) {
        JSONObject jSONObject;
        String string;
        if (bundle.containsKey(PUSH_MINIFIED_BUTTONS_LIST)) {
            try {
                JSONObject jSONObject2 = new JSONObject(bundle.getString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
                if (jSONObject2.has("a")) {
                    jSONObject = jSONObject2.getJSONObject("a");
                    k.d(jSONObject, "{\n                    cu…      )\n                }");
                } else {
                    jSONObject = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray(bundle.getString(PUSH_MINIFIED_BUTTONS_LIST));
                bundle.remove(PUSH_MINIFIED_BUTTONS_LIST);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    String string2 = jSONObject3.getString("n");
                    jSONObject3.remove("n");
                    if (jSONObject3.has("i")) {
                        string = jSONObject3.getString("i");
                        jSONObject3.remove("i");
                    } else {
                        string = string2;
                    }
                    jSONObject3.put("id", string);
                    jSONObject3.put(C2300e4.h.K0, string2);
                    if (jSONObject3.has(PUSH_MINIFIED_BUTTON_ICON)) {
                        jSONObject3.put(C2300e4.h.H0, jSONObject3.getString(PUSH_MINIFIED_BUTTON_ICON));
                        jSONObject3.remove(PUSH_MINIFIED_BUTTON_ICON);
                    }
                }
                jSONObject.put("actionButtons", jSONArray);
                jSONObject.put(NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, DEFAULT_ACTION);
                if (!jSONObject2.has("a")) {
                    jSONObject2.put("a", jSONObject);
                }
                bundle.putString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM, jSONObject2.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.onesignal.notifications.internal.bundle.INotificationBundleProcessor
    public INotificationBundleProcessor.ProcessedBundleResult processBundleFromReceiver(Context context, Bundle bundle) {
        k.e(context, "context");
        k.e(bundle, "bundle");
        INotificationBundleProcessor.ProcessedBundleResult processedBundleResult = new INotificationBundleProcessor.ProcessedBundleResult();
        NotificationFormatHelper notificationFormatHelper = NotificationFormatHelper.INSTANCE;
        if (!notificationFormatHelper.isOneSignalBundle(bundle)) {
            return processedBundleResult;
        }
        processedBundleResult.setOneSignalPayload(true);
        maximizeButtonsFromBundle(bundle);
        JSONObject jSONObjectBundleAsJSONObject = JSONUtils.INSTANCE.bundleAsJSONObject(bundle);
        long currentTimeMillis = this._time.getCurrentTimeMillis() / 1000;
        boolean z2 = bundle.getBoolean("is_restoring", false);
        String string = bundle.getString("pri", "0");
        k.d(string, "bundle.getString(\"pri\", \"0\")");
        boolean z7 = Integer.parseInt(string) > 9;
        String oSNotificationIdFromJson = notificationFormatHelper.getOSNotificationIdFromJson(jSONObjectBundleAsJSONObject);
        int i2 = bundle.containsKey(ANDROID_NOTIFICATION_ID) ? bundle.getInt(ANDROID_NOTIFICATION_ID) : 0;
        INotificationGenerationWorkManager iNotificationGenerationWorkManager = this._workManager;
        k.b(oSNotificationIdFromJson);
        processedBundleResult.setWorkManagerProcessing(iNotificationGenerationWorkManager.beginEnqueueingWork(context, oSNotificationIdFromJson, i2, jSONObjectBundleAsJSONObject, currentTimeMillis, z2, z7));
        return processedBundleResult;
    }
}
