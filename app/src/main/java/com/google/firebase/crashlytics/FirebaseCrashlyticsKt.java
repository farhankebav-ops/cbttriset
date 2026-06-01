package com.google.firebase.crashlytics;

import com.google.firebase.Firebase;
import e6.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class FirebaseCrashlyticsKt {
    public static final FirebaseCrashlytics getCrashlytics(Firebase firebase) {
        k.e(firebase, "<this>");
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        k.d(firebaseCrashlytics, "getInstance(...)");
        return firebaseCrashlytics;
    }

    public static final void recordException(FirebaseCrashlytics firebaseCrashlytics, Throwable throwable, l init) {
        k.e(firebaseCrashlytics, "<this>");
        k.e(throwable, "throwable");
        k.e(init, "init");
        KeyValueBuilder keyValueBuilder = new KeyValueBuilder();
        init.invoke(keyValueBuilder);
        firebaseCrashlytics.recordException(throwable, keyValueBuilder.build$com_google_firebase_firebase_crashlytics());
    }

    public static final void setCustomKeys(FirebaseCrashlytics firebaseCrashlytics, l init) {
        k.e(firebaseCrashlytics, "<this>");
        k.e(init, "init");
        KeyValueBuilder keyValueBuilder = new KeyValueBuilder();
        init.invoke(keyValueBuilder);
        firebaseCrashlytics.setCustomKeys(keyValueBuilder.build$com_google_firebase_firebase_crashlytics());
    }
}
