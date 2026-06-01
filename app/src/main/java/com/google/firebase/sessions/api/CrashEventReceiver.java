package com.google.firebase.sessions.api;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.sessions.SharedSessionRepository;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class CrashEventReceiver {
    public static final CrashEventReceiver INSTANCE = new CrashEventReceiver();
    public static SharedSessionRepository sharedSessionRepository;

    private CrashEventReceiver() {
    }

    public static final void notifyCrashOccurred() {
        try {
            if (sharedSessionRepository == null) {
                INSTANCE.setSharedSessionRepository$com_google_firebase_firebase_sessions(SharedSessionRepository.Companion.getInstance());
            }
            CrashEventReceiver crashEventReceiver = INSTANCE;
            if (crashEventReceiver.getSharedSessionRepository$com_google_firebase_firebase_sessions().isInForeground()) {
                crashEventReceiver.getSharedSessionRepository$com_google_firebase_firebase_sessions().appBackground();
            }
        } catch (Exception unused) {
        }
    }

    public final SharedSessionRepository getSharedSessionRepository$com_google_firebase_firebase_sessions() {
        SharedSessionRepository sharedSessionRepository2 = sharedSessionRepository;
        if (sharedSessionRepository2 != null) {
            return sharedSessionRepository2;
        }
        k.l("sharedSessionRepository");
        throw null;
    }

    public final void setSharedSessionRepository$com_google_firebase_firebase_sessions(SharedSessionRepository sharedSessionRepository2) {
        k.e(sharedSessionRepository2, "<set-?>");
        sharedSessionRepository = sharedSessionRepository2;
    }

    @VisibleForTesting
    public static /* synthetic */ void getSharedSessionRepository$com_google_firebase_firebase_sessions$annotations() {
    }
}
