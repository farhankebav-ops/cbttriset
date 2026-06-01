package com.google.firebase.sessions;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.FirebaseApp;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionEvents {
    public static final SessionEvents INSTANCE = new SessionEvents();
    private static final DataEncoder SESSION_EVENT_ENCODER;

    static {
        DataEncoder dataEncoderBuild = new JsonDataEncoderBuilder().configureWith(AutoSessionEventEncoder.CONFIG).ignoreNullValues(true).build();
        k.d(dataEncoderBuild, "build(...)");
        SESSION_EVENT_ENCODER = dataEncoderBuild;
    }

    private SessionEvents() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionEvent buildSession$default(SessionEvents sessionEvents, FirebaseApp firebaseApp, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map map, String str, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            map = s.f13639a;
        }
        return sessionEvents.buildSession(firebaseApp, sessionDetails, sessionsSettings, map, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? "" : str2);
    }

    private final DataCollectionState toDataCollectionState(SessionSubscriber sessionSubscriber) {
        return sessionSubscriber == null ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : sessionSubscriber.isDataCollectionEnabled() ? DataCollectionState.COLLECTION_ENABLED : DataCollectionState.COLLECTION_DISABLED;
    }

    public final SessionEvent buildSession(FirebaseApp firebaseApp, SessionDetails sessionDetails, SessionsSettings sessionsSettings, Map<SessionSubscriber.Name, ? extends SessionSubscriber> subscribers, String firebaseInstallationId, String firebaseAuthenticationToken) {
        k.e(firebaseApp, "firebaseApp");
        k.e(sessionDetails, "sessionDetails");
        k.e(sessionsSettings, "sessionsSettings");
        k.e(subscribers, "subscribers");
        k.e(firebaseInstallationId, "firebaseInstallationId");
        k.e(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new SessionEvent(EventType.SESSION_START, new SessionInfo(sessionDetails.getSessionId(), sessionDetails.getFirstSessionId(), sessionDetails.getSessionIndex(), sessionDetails.getSessionStartTimestampUs(), new DataCollectionStatus(toDataCollectionState(subscribers.get(SessionSubscriber.Name.PERFORMANCE)), toDataCollectionState(subscribers.get(SessionSubscriber.Name.CRASHLYTICS)), sessionsSettings.getSamplingRate()), firebaseInstallationId, firebaseAuthenticationToken), getApplicationInfo(firebaseApp));
    }

    public final ApplicationInfo getApplicationInfo(FirebaseApp firebaseApp) throws PackageManager.NameNotFoundException {
        k.e(firebaseApp, "firebaseApp");
        Context applicationContext = firebaseApp.getApplicationContext();
        k.d(applicationContext, "getApplicationContext(...)");
        String packageName = applicationContext.getPackageName();
        PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        String applicationId = firebaseApp.getOptions().getApplicationId();
        k.d(applicationId, "getApplicationId(...)");
        String MODEL = Build.MODEL;
        k.d(MODEL, "MODEL");
        String RELEASE = Build.VERSION.RELEASE;
        k.d(RELEASE, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        k.b(packageName);
        String str = packageInfo.versionName;
        String str2 = str == null ? strValueOf : str;
        String MANUFACTURER = Build.MANUFACTURER;
        k.d(MANUFACTURER, "MANUFACTURER");
        ProcessDetailsProvider processDetailsProvider = ProcessDetailsProvider.INSTANCE;
        Context applicationContext2 = firebaseApp.getApplicationContext();
        k.d(applicationContext2, "getApplicationContext(...)");
        ProcessDetails myProcessDetails = processDetailsProvider.getMyProcessDetails(applicationContext2);
        Context applicationContext3 = firebaseApp.getApplicationContext();
        k.d(applicationContext3, "getApplicationContext(...)");
        return new ApplicationInfo(applicationId, MODEL, BuildConfig.VERSION_NAME, RELEASE, logEnvironment, new AndroidApplicationInfo(packageName, str2, strValueOf, MANUFACTURER, myProcessDetails, processDetailsProvider.getAppProcessDetails(applicationContext3)));
    }

    public final DataEncoder getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions() {
        return SESSION_EVENT_ENCODER;
    }
}
