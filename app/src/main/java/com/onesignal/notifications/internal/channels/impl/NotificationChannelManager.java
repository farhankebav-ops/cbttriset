package com.onesignal.notifications.internal.channels.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.d;
import com.facebook.ads.internal.dynamicloading.a;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import com.onesignal.notifications.internal.common.NotificationHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationChannelManager implements INotificationChannelManager {
    private static final String CHANNEL_PREFIX = "OS_";
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_CHANNEL_ID = "fcm_fallback_notification_channel";
    private static final String RESTORE_CHANNEL_ID = "restored_OS_notifications";
    private final IApplicationService _applicationService;
    private final ILanguageContext _languageContext;
    private final Pattern hexPattern;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public NotificationChannelManager(IApplicationService _applicationService, ILanguageContext _languageContext) {
        k.e(_applicationService, "_applicationService");
        k.e(_languageContext, "_languageContext");
        this._applicationService = _applicationService;
        this._languageContext = _languageContext;
        this.hexPattern = Pattern.compile("^([A-Fa-f0-9]{8})$");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    @androidx.annotation.RequiresApi(api = 26)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String createChannel(android.content.Context r9, android.app.NotificationManager r10, org.json.JSONObject r11) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.channels.impl.NotificationChannelManager.createChannel(android.content.Context, android.app.NotificationManager, org.json.JSONObject):java.lang.String");
    }

    @RequiresApi(api = 26)
    private final String createDefaultChannel(NotificationManager notificationManager) {
        a.D();
        NotificationChannel notificationChannelW = k3.a.w();
        notificationChannelW.enableLights(true);
        notificationChannelW.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannelW);
        return "fcm_fallback_notification_channel";
    }

    @RequiresApi(api = 26)
    private final String createRestoreChannel(NotificationManager notificationManager) {
        a.D();
        notificationManager.createNotificationChannel(k3.a.b());
        return RESTORE_CHANNEL_ID;
    }

    private final int priorityToImportance(int i2) {
        if (i2 > 9) {
            return 5;
        }
        if (i2 > 7) {
            return 4;
        }
        if (i2 > 5) {
            return 3;
        }
        if (i2 > 3) {
            return 2;
        }
        return i2 > 1 ? 1 : 0;
    }

    @Override // com.onesignal.notifications.internal.channels.INotificationChannelManager
    public String createNotificationChannel(NotificationGenerationJob notificationJob) {
        k.e(notificationJob, "notificationJob");
        if (Build.VERSION.SDK_INT < 26) {
            return "fcm_fallback_notification_channel";
        }
        Context appContext = this._applicationService.getAppContext();
        JSONObject jsonPayload = notificationJob.getJsonPayload();
        k.b(jsonPayload);
        NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(appContext);
        if (notificationJob.isRestoring()) {
            return createRestoreChannel(notificationManager);
        }
        if (jsonPayload.has("oth_chnl")) {
            String otherChannel = jsonPayload.optString("oth_chnl");
            if (notificationManager.getNotificationChannel(otherChannel) != null) {
                k.d(otherChannel, "otherChannel");
                return otherChannel;
            }
        }
        if (!jsonPayload.has("chnl")) {
            return createDefaultChannel(notificationManager);
        }
        try {
            return createChannel(appContext, notificationManager, jsonPayload);
        } catch (JSONException e) {
            Logging.error("Could not create notification channel due to JSON payload error!", e);
            return "fcm_fallback_notification_channel";
        }
    }

    @Override // com.onesignal.notifications.internal.channels.INotificationChannelManager
    public void processChannelList(JSONArray jSONArray) {
        if (Build.VERSION.SDK_INT < 26 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        NotificationManager notificationManager = NotificationHelper.INSTANCE.getNotificationManager(this._applicationService.getAppContext());
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                Context appContext = this._applicationService.getAppContext();
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                k.d(jSONObject, "list.getJSONObject(i)");
                hashSet.add(createChannel(appContext, notificationManager, jSONObject));
            } catch (JSONException e) {
                Logging.error("Could not create notification channel due to JSON payload error!", e);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        List arrayList = new ArrayList();
        try {
            List notificationChannels = notificationManager.getNotificationChannels();
            k.d(notificationChannels, "notificationManager.notificationChannels");
            arrayList = notificationChannels;
        } catch (NullPointerException e4) {
            Logging.error$default("Error when trying to delete notification channel: " + e4.getMessage(), null, 2, null);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String id = d.g(it.next()).getId();
            k.d(id, "id");
            if (t.n0(id, CHANNEL_PREFIX, false) && !hashSet.contains(id)) {
                notificationManager.deleteNotificationChannel(id);
            }
        }
    }
}
