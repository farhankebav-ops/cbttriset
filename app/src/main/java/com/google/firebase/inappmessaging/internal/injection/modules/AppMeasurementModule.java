package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inject.Deferred;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class AppMeasurementModule {
    private final AnalyticsConnector analyticsConnector;
    private final Subscriber firebaseEventsSubscriber;

    public AppMeasurementModule(Deferred<AnalyticsConnector> deferred, Subscriber subscriber) {
        this.analyticsConnector = new ProxyAnalyticsConnector(deferred);
        this.firebaseEventsSubscriber = subscriber;
    }

    @Provides
    public AnalyticsConnector providesAnalyticsConnector() {
        return this.analyticsConnector;
    }

    @Provides
    public Subscriber providesSubsriber() {
        return this.firebaseEventsSubscriber;
    }
}
