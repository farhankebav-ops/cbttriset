package com.vungle.ads.internal.signals;

import a.a;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.DeviceCheckUtils;
import com.vungle.ads.internal.session.UnclosedAdDetector;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import g7.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.k;
import n7.b;
import q5.f;
import q5.g;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(21)
public final class SignalManager {
    public static final Companion Companion = new Companion(null);
    public static final String SESSION_COUNT_KEY = "vungle_signal_session_count";
    private static final int SESSION_COUNT_NOT_SET = -1;
    public static final String SESSION_TIME_KEY = "vungle_signal_session_creation_time";
    public static final int SIGNAL_VERSION = 2;
    private static final String TAG = "SignalManager";
    public static final long TWENTY_FOUR_HOURS_MILLIS = 86400000;
    private final Context context;
    private SessionData currentSession;
    private long enterBackgroundTime;
    private long enterForegroundTime;
    private final f filePreferences$delegate;
    private final c json;
    private ConcurrentHashMap<String, Long> mapOfLastLoadTimes;
    private int sessionCount;
    private long sessionDuration;
    private long sessionSeriesCreatedTime;
    private UnclosedAdDetector unclosedAdDetector;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public SignalManager(Context context) {
        k.e(context, "context");
        this.context = context;
        this.json = a.b(SignalManager$json$1.INSTANCE);
        this.enterForegroundTime = System.currentTimeMillis();
        this.sessionCount = -1;
        this.mapOfLastLoadTimes = new ConcurrentHashMap<>();
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        g gVar = g.f13494a;
        this.filePreferences$delegate = b.B(gVar, new SignalManager$special$$inlined$inject$1(context));
        registerNotifications();
        this.sessionSeriesCreatedTime = getFilePreferences().getLong(SESSION_TIME_KEY, -1L);
        updateSessionCount();
        this.currentSession = new SessionData(this.sessionCount);
        UnclosedAdDetector unclosedAdDetector = new UnclosedAdDetector(context, this.currentSession.getSessionId(), m3353_init_$lambda0(b.B(gVar, new SignalManager$special$$inlined$inject$2(context))), m3354_init_$lambda1(b.B(gVar, new SignalManager$special$$inlined$inject$3(context))));
        this.unclosedAdDetector = unclosedAdDetector;
        this.currentSession.setUnclosedAd(unclosedAdDetector.retrieveUnclosedAd());
        try {
            SessionData sessionData = this.currentSession;
            DeviceCheckUtils deviceCheckUtils = DeviceCheckUtils.INSTANCE;
            sessionData.setDevice(!deviceCheckUtils.isEmulator() ? 1 : 0);
            this.currentSession.setVPNConnected(deviceCheckUtils.isVpnConnected(context) ? 1 : 0);
            this.currentSession.setOverlayGranted(deviceCheckUtils.hasSystemAlertWindowPermission(context) ? 1 : 0);
            this.currentSession.setSensorCount(deviceCheckUtils.getSensorCount(context));
            this.currentSession.setHttpProxyEnabled(deviceCheckUtils.isProxyEnabled(context) ? 1 : 0);
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Failed to collect device signals: " + e.getLocalizedMessage());
        }
    }

    /* JADX INFO: renamed from: _init_$lambda-0, reason: not valid java name */
    private static final Executors m3353_init_$lambda0(f fVar) {
        return (Executors) fVar.getValue();
    }

    /* JADX INFO: renamed from: _init_$lambda-1, reason: not valid java name */
    private static final PathProvider m3354_init_$lambda1(f fVar) {
        return (PathProvider) fVar.getValue();
    }

    private final void registerNotifications() {
        ActivityManager.Companion.addLifecycleListener(new ActivityManager.LifeCycleCallback() { // from class: com.vungle.ads.internal.signals.SignalManager.registerNotifications.1
            @Override // com.vungle.ads.internal.util.ActivityManager.LifeCycleCallback
            public void onBackground() {
                Logger.Companion.d(SignalManager.TAG, "SignalManager#onBackground()");
                SignalManager.this.setEnterBackgroundTime(System.currentTimeMillis());
                SignalManager signalManager = SignalManager.this;
                signalManager.setSessionDuration((SignalManager.this.getEnterBackgroundTime() - SignalManager.this.getEnterForegroundTime()) + signalManager.getSessionDuration());
            }

            @Override // com.vungle.ads.internal.util.ActivityManager.LifeCycleCallback
            public void onForeground() {
                Logger.Companion.d(SignalManager.TAG, "SignalManager#onForeground()");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - SignalManager.this.getEnterBackgroundTime() > ConfigManager.INSTANCE.getSignalsSessionTimeout()) {
                    SignalManager.this.createNewSessionData();
                }
                SignalManager.this.setEnterForegroundTime(jCurrentTimeMillis);
                SignalManager.this.setEnterBackgroundTime(0L);
            }
        });
    }

    private final void updateSessionCount() {
        if (this.sessionCount == -1) {
            this.sessionCount = getFilePreferences().getInt(SESSION_COUNT_KEY, 0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.sessionSeriesCreatedTime;
        long j3 = jCurrentTimeMillis - j;
        if (j < 0 || j3 >= TWENTY_FOUR_HOURS_MILLIS) {
            this.sessionCount = 1;
            getFilePreferences().put(SESSION_TIME_KEY, jCurrentTimeMillis);
            this.sessionSeriesCreatedTime = jCurrentTimeMillis;
        } else {
            this.sessionCount++;
        }
        getFilePreferences().put(SESSION_COUNT_KEY, this.sessionCount);
        getFilePreferences().apply();
    }

    private final void updateSessionDuration() {
        this.currentSession.setSessionDuration((System.currentTimeMillis() + this.sessionDuration) - this.enterForegroundTime);
    }

    public final void createNewSessionData() {
        updateSessionCount();
        this.currentSession = new SessionData(this.sessionCount);
    }

    public final String generateSignals() {
        updateSessionDuration();
        try {
            c cVar = this.json;
            return "2:".concat(cVar.b(q.q0(cVar.f11599b, b0.b(SessionData.class)), this.currentSession));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final SessionData getCurrentSession$vungle_ads_release() {
        return this.currentSession;
    }

    public final long getEnterBackgroundTime() {
        return this.enterBackgroundTime;
    }

    public final long getEnterForegroundTime() {
        return this.enterForegroundTime;
    }

    public final FilePreferences getFilePreferences() {
        return (FilePreferences) this.filePreferences$delegate.getValue();
    }

    public final ConcurrentHashMap<String, Long> getMapOfLastLoadTimes() {
        return this.mapOfLastLoadTimes;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public final long getSessionSeriesCreatedTime() {
        return this.sessionSeriesCreatedTime;
    }

    public final synchronized SignaledAd getSignaledAd(String placementId) {
        long jCurrentTimeMillis;
        Long l;
        try {
            k.e(placementId, "placementId");
            jCurrentTimeMillis = System.currentTimeMillis();
            l = this.mapOfLastLoadTimes.containsKey(placementId) ? this.mapOfLastLoadTimes.get(placementId) : null;
            this.mapOfLastLoadTimes.put(placementId, Long.valueOf(jCurrentTimeMillis));
        } catch (Throwable th) {
            throw th;
        }
        return new SignaledAd(l, jCurrentTimeMillis);
    }

    public final String getUuid() {
        return this.currentSession.getSessionId();
    }

    public final synchronized void increaseSessionDepthCounter() {
        SessionData sessionData = this.currentSession;
        sessionData.setSessionDepthCounter(sessionData.getSessionDepthCounter() + 1);
    }

    public final void recordUnclosedAd(UnclosedAd unclosedAd) {
        k.e(unclosedAd, "unclosedAd");
        if (ConfigManager.INSTANCE.signalsDisabled()) {
            return;
        }
        this.unclosedAdDetector.addUnclosedAd(unclosedAd);
    }

    public final void registerSignaledAd(Context context, SignaledAd signaledAd) {
        k.e(signaledAd, "signaledAd");
        this.currentSession.getSignaledAd().clear();
        this.currentSession.getSignaledAd().add(signaledAd);
        this.currentSession.getSignaledAd().get(0).setScreenOrientation(screenOrientation(context));
    }

    public final void removeUnclosedAd(UnclosedAd unclosedAd) {
        k.e(unclosedAd, "unclosedAd");
        if (ConfigManager.INSTANCE.signalsDisabled()) {
            return;
        }
        this.unclosedAdDetector.removeUnclosedAd(unclosedAd);
    }

    public final int screenOrientation(Context context) {
        Configuration configuration;
        if (context == null) {
            context = this.context;
        }
        Resources resources = context.getResources();
        Integer numValueOf = (resources == null || (configuration = resources.getConfiguration()) == null) ? null : Integer.valueOf(configuration.orientation);
        if (numValueOf != null && numValueOf.intValue() == 2) {
            return 2;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            return 1;
        }
        return (numValueOf != null && numValueOf.intValue() == 0) ? 0 : -1;
    }

    public final void setCurrentSession$vungle_ads_release(SessionData sessionData) {
        k.e(sessionData, "<set-?>");
        this.currentSession = sessionData;
    }

    public final void setEnterBackgroundTime(long j) {
        this.enterBackgroundTime = j;
    }

    public final void setEnterForegroundTime(long j) {
        this.enterForegroundTime = j;
    }

    public final void setMapOfLastLoadTimes(ConcurrentHashMap<String, Long> concurrentHashMap) {
        k.e(concurrentHashMap, "<set-?>");
        this.mapOfLastLoadTimes = concurrentHashMap;
    }

    public final void setSessionCount(int i2) {
        this.sessionCount = i2;
    }

    public final void setSessionDuration(long j) {
        this.sessionDuration = j;
    }

    public final void setSessionSeriesCreatedTime(long j) {
        this.sessionSeriesCreatedTime = j;
    }

    public final void updateTemplateSignals(String str) {
        if (str == null || str.length() == 0 || this.currentSession.getSignaledAd().isEmpty()) {
            return;
        }
        this.currentSession.getSignaledAd().get(0).setTemplateSignals(str);
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getCurrentSession$vungle_ads_release$annotations() {
    }
}
