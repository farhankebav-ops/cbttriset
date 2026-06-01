package com.google.firebase.inappmessaging.internal;

import android.text.TextUtils;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.CommonTypesProto;
import com.ironsource.adqualitysdk.sdk.i.a0;
import d5.q0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class AnalyticsEventsManager {
    static final String TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR = "Too many contextual triggers defined - limiting to 50";
    private final AnalyticsConnector analyticsConnector;
    private final w4.a flowable;
    private AnalyticsConnector.AnalyticsConnectorHandle handle;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class AnalyticsFlowableSubscriber implements s4.f {
        public AnalyticsFlowableSubscriber() {
        }

        @Override // s4.f
        public void subscribe(s4.e eVar) {
            Logging.logd("Subscribing to analytics events.");
            AnalyticsEventsManager analyticsEventsManager = AnalyticsEventsManager.this;
            analyticsEventsManager.handle = analyticsEventsManager.analyticsConnector.registerAnalyticsConnectorListener("fiam", new FiamAnalyticsConnectorListener(eVar));
        }
    }

    public AnalyticsEventsManager(AnalyticsConnector analyticsConnector) {
        this.analyticsConnector = analyticsConnector;
        AnalyticsFlowableSubscriber analyticsFlowableSubscriber = new AnalyticsFlowableSubscriber();
        int i2 = s4.d.f13683a;
        a0.h(3, "mode is null");
        q0 q0VarC = new d5.m(analyticsFlowableSubscriber, 0).c();
        this.flowable = q0VarC;
        q0VarC.f();
    }

    public static Set<String> extractAnalyticsEventNames(r2.o oVar) {
        HashSet hashSet = new HashSet();
        Iterator<E> it = oVar.e().iterator();
        while (it.hasNext()) {
            for (CommonTypesProto.TriggeringCondition triggeringCondition : ((q2.f) it.next()).g()) {
                if (!TextUtils.isEmpty(triggeringCondition.getEvent().getName())) {
                    hashSet.add(triggeringCondition.getEvent().getName());
                }
            }
        }
        if (hashSet.size() > 50) {
            Logging.logi(TOO_MANY_CONTEXTUAL_TRIGGERS_ERROR);
        }
        return hashSet;
    }

    public w4.a getAnalyticsEventsFlowable() {
        return this.flowable;
    }

    public AnalyticsConnector.AnalyticsConnectorHandle getHandle() {
        return this.handle;
    }

    public void updateContextualTriggers(r2.o oVar) {
        Set<String> setExtractAnalyticsEventNames = extractAnalyticsEventNames(oVar);
        Logging.logd("Updating contextual triggers for the following analytics events: " + setExtractAnalyticsEventNames);
        this.handle.registerEventNames(setExtractAnalyticsEventNames);
    }
}
