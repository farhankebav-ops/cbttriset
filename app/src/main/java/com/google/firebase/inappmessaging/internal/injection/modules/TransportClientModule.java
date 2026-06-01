package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.mimikridev.utilmanager.config.b;
import java.util.concurrent.Executor;
import m0.a;
import m0.c;
import m0.e;
import m0.g;
import m0.h;
import p0.t;
import p0.u;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class TransportClientModule {
    private static final String TRANSPORT_NAME = "FIREBASE_INAPPMESSAGING";

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$providesMetricsLoggerClient$1(g gVar, byte[] bArr) {
        ((u) gVar).a(new a(bArr, e.f12921a, null), new b(10));
    }

    @Provides
    @FirebaseAppScope
    public static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, h hVar, AnalyticsConnector analyticsConnector, FirebaseInstallationsApi firebaseInstallationsApi, Clock clock, DeveloperListenerManager developerListenerManager, @Blocking Executor executor) {
        b bVar = new b(9);
        t tVar = (t) hVar;
        tVar.getClass();
        return new MetricsLoggerClient(new j7.a(tVar.a(TRANSPORT_NAME, new c("proto"), bVar), 5), analyticsConnector, firebaseApp, firebaseInstallationsApi, clock, developerListenerManager, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] lambda$providesMetricsLoggerClient$0(byte[] bArr) {
        return bArr;
    }
}
