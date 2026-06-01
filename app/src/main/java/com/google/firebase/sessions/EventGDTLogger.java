package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.inject.Provider;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import m0.h;
import p0.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventGDTLogger implements EventGDTLoggerInterface {
    private static final String AQS_LOG_SOURCE = "FIREBASE_APPQUALITY_SESSION";
    public static final Companion Companion = new Companion(null);
    private final Provider<h> transportFactoryProvider;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public EventGDTLogger(Provider<h> transportFactoryProvider) {
        k.e(transportFactoryProvider, "transportFactoryProvider");
        this.transportFactoryProvider = transportFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] encode(SessionEvent sessionEvent) {
        String strEncode = SessionEvents.INSTANCE.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions().encode(sessionEvent);
        k.d(strEncode, "encode(...)");
        Log.d(FirebaseSessions.TAG, "Session Event Type: " + sessionEvent.getEventType().name());
        byte[] bytes = strEncode.getBytes(n6.a.f13073a);
        k.d(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public void log(SessionEvent sessionEvent) {
        k.e(sessionEvent, "sessionEvent");
        ((t) this.transportFactoryProvider.get()).a(AQS_LOG_SOURCE, new m0.c("json"), new m0.f() { // from class: com.google.firebase.sessions.a
            @Override // m0.f, x4.c
            public final Object apply(Object obj) {
                return this.f5733a.encode((SessionEvent) obj);
            }
        }).a(new m0.a(sessionEvent, m0.e.f12921a, null), new com.mimikridev.utilmanager.config.b(10));
    }
}
