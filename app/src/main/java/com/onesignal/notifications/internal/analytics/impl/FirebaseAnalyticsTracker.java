package com.onesignal.notifications.internal.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.work.WorkRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.fid.Constants;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FirebaseAnalyticsTracker implements IAnalyticsTracker {
    public static final Companion Companion = new Companion(null);
    private static final String EVENT_NOTIFICATION_INFLUENCE_OPEN = "os_notification_influence_open";
    private static final String EVENT_NOTIFICATION_OPENED = "os_notification_opened";
    private static final String EVENT_NOTIFICATION_RECEIVED = "os_notification_received";
    private static Class<?> firebaseAnalyticsClass;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ITime _time;
    private AtomicLong lastOpenedTime;
    private String lastReceivedNotificationCampaign;
    private String lastReceivedNotificationId;
    private AtomicLong lastReceivedTime;
    private Object mFirebaseAnalyticsInstance;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getInstanceMethod(Class<?> cls) {
            try {
                k.b(cls);
                return cls.getMethod(Constants.GET_INSTANCE, Context.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Method getTrackMethod(Class<?> cls) {
            try {
                k.b(cls);
                return cls.getMethod("logEvent", String.class, Bundle.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        }

        public final boolean canTrack() {
            try {
                FirebaseAnalyticsTracker.firebaseAnalyticsClass = FirebaseAnalytics.class;
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }

        private Companion() {
        }
    }

    public FirebaseAnalyticsTracker(IApplicationService _applicationService, ConfigModelStore _configModelStore, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_configModelStore, "_configModelStore");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        this._time = _time;
    }

    private final Object getFirebaseAnalyticsInstance() {
        if (this.mFirebaseAnalyticsInstance == null) {
            Method instanceMethod = Companion.getInstanceMethod(firebaseAnalyticsClass);
            try {
                k.b(instanceMethod);
                this.mFirebaseAnalyticsInstance = instanceMethod.invoke(null, this._applicationService.getAppContext());
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.mFirebaseAnalyticsInstance;
    }

    private final boolean isEnabled() {
        return this._configModelStore.getModel().getFirebaseAnalytics();
    }

    @Override // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackInfluenceOpenEvent() {
        if (!isEnabled() || this.lastReceivedTime == null || this.lastReceivedNotificationId == null) {
            return;
        }
        long currentTimeMillis = this._time.getCurrentTimeMillis();
        AtomicLong atomicLong = this.lastReceivedTime;
        k.b(atomicLong);
        if (currentTimeMillis - atomicLong.get() > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
            return;
        }
        AtomicLong atomicLong2 = this.lastOpenedTime;
        if (atomicLong2 != null) {
            k.b(atomicLong2);
            if (currentTimeMillis - atomicLong2.get() < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                return;
            }
        }
        try {
            Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance();
            Method trackMethod = Companion.getTrackMethod(firebaseAnalyticsClass);
            Bundle bundle = new Bundle();
            bundle.putString("source", PreferenceStores.ONESIGNAL);
            bundle.putString("medium", OneSignalDbContract.NotificationTable.TABLE_NAME);
            String str = this.lastReceivedNotificationId;
            k.b(str);
            bundle.putString("notification_id", str);
            String str2 = this.lastReceivedNotificationCampaign;
            k.b(str2);
            bundle.putString("campaign", str2);
            k.b(trackMethod);
            trackMethod.invoke(firebaseAnalyticsInstance, EVENT_NOTIFICATION_INFLUENCE_OPEN, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackOpenedEvent(String notificationId, String campaign) {
        k.e(notificationId, "notificationId");
        k.e(campaign, "campaign");
        if (isEnabled()) {
            if (this.lastOpenedTime == null) {
                this.lastOpenedTime = new AtomicLong();
            }
            AtomicLong atomicLong = this.lastOpenedTime;
            k.b(atomicLong);
            atomicLong.set(this._time.getCurrentTimeMillis());
            try {
                Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance();
                Method trackMethod = Companion.getTrackMethod(firebaseAnalyticsClass);
                Bundle bundle = new Bundle();
                bundle.putString("source", PreferenceStores.ONESIGNAL);
                bundle.putString("medium", OneSignalDbContract.NotificationTable.TABLE_NAME);
                bundle.putString("notification_id", notificationId);
                bundle.putString("campaign", campaign);
                k.b(trackMethod);
                trackMethod.invoke(firebaseAnalyticsInstance, EVENT_NOTIFICATION_OPENED, bundle);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.onesignal.notifications.internal.analytics.IAnalyticsTracker
    public void trackReceivedEvent(String notificationId, String campaign) {
        k.e(notificationId, "notificationId");
        k.e(campaign, "campaign");
        if (isEnabled()) {
            try {
                Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance();
                Method trackMethod = Companion.getTrackMethod(firebaseAnalyticsClass);
                Bundle bundle = new Bundle();
                bundle.putString("source", PreferenceStores.ONESIGNAL);
                bundle.putString("medium", OneSignalDbContract.NotificationTable.TABLE_NAME);
                bundle.putString("notification_id", notificationId);
                bundle.putString("campaign", campaign);
                k.b(trackMethod);
                trackMethod.invoke(firebaseAnalyticsInstance, EVENT_NOTIFICATION_RECEIVED, bundle);
                if (this.lastReceivedTime == null) {
                    this.lastReceivedTime = new AtomicLong();
                }
                AtomicLong atomicLong = this.lastReceivedTime;
                k.b(atomicLong);
                atomicLong.set(this._time.getCurrentTimeMillis());
                this.lastReceivedNotificationId = notificationId;
                this.lastReceivedNotificationCampaign = campaign;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
