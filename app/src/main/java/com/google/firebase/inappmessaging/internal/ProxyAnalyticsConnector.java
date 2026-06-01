package com.google.firebase.inappmessaging.internal;

import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ProxyAnalyticsConnector implements AnalyticsConnector {
    private volatile Object instance;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class ProxyAnalyticsConnectorHandle implements AnalyticsConnector.AnalyticsConnectorHandle {
        private static final Object UNREGISTERED = new Object();

        @GuardedBy("this")
        private Set<String> eventNames;
        private volatile Object instance;

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Provider provider) {
            if (this.instance == UNREGISTERED) {
                return;
            }
            AnalyticsConnector.AnalyticsConnectorHandle analyticsConnectorHandleRegisterAnalyticsConnectorListener = ((AnalyticsConnector) provider.get()).registerAnalyticsConnectorListener(str, analyticsConnectorListener);
            this.instance = analyticsConnectorHandleRegisterAnalyticsConnectorListener;
            synchronized (this) {
                try {
                    if (!this.eventNames.isEmpty()) {
                        analyticsConnectorHandleRegisterAnalyticsConnectorListener.registerEventNames(this.eventNames);
                        this.eventNames = new HashSet();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void registerEventNames(@NonNull Set<String> set) {
            Object obj = this.instance;
            if (obj == UNREGISTERED) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).registerEventNames(set);
            } else {
                synchronized (this) {
                    this.eventNames.addAll(set);
                }
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregister() {
            Object obj = this.instance;
            Object obj2 = UNREGISTERED;
            if (obj == obj2) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregister();
            }
            this.instance = obj2;
            synchronized (this) {
                this.eventNames.clear();
            }
        }

        @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
        public void unregisterEventNames() {
            Object obj = this.instance;
            if (obj == UNREGISTERED) {
                return;
            }
            if (obj != null) {
                ((AnalyticsConnector.AnalyticsConnectorHandle) obj).unregisterEventNames();
            } else {
                synchronized (this) {
                    this.eventNames.clear();
                }
            }
        }

        private ProxyAnalyticsConnectorHandle(String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener, Deferred<AnalyticsConnector> deferred) {
            this.eventNames = new HashSet();
            deferred.whenAvailable(new r(this, str, analyticsConnectorListener, 0));
        }
    }

    public ProxyAnalyticsConnector(Deferred<AnalyticsConnector> deferred) {
        this.instance = deferred;
        deferred.whenAvailable(new androidx.camera.core.impl.b(this, 21));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Provider provider) {
        this.instance = provider.get();
    }

    private AnalyticsConnector safeGet() {
        Object obj = this.instance;
        if (obj instanceof AnalyticsConnector) {
            return (AnalyticsConnector) obj;
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable String str2) {
        return Collections.EMPTY_LIST;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(@NonNull String str) {
        return 0;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    public Map<String, Object> getUserProperties(boolean z2) {
        return Collections.EMPTY_MAP;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) {
        AnalyticsConnector analyticsConnectorSafeGet = safeGet();
        if (analyticsConnectorSafeGet != null) {
            analyticsConnectorSafeGet.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @NonNull
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, @NonNull AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        Object obj = this.instance;
        return obj instanceof AnalyticsConnector ? ((AnalyticsConnector) obj).registerAnalyticsConnectorListener(str, analyticsConnectorListener) : new ProxyAnalyticsConnectorHandle(str, analyticsConnectorListener, (Deferred) obj);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj) {
        AnalyticsConnector analyticsConnectorSafeGet = safeGet();
        if (analyticsConnectorSafeGet != null) {
            analyticsConnectorSafeGet.setUserProperty(str, str2, obj);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(@NonNull AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
    }
}
