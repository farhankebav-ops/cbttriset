package com.google.firebase.installations;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class InstallationsKt {
    public static final FirebaseInstallations getInstallations(Firebase firebase) {
        k.e(firebase, "<this>");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance();
        k.d(firebaseInstallations, "getInstance(...)");
        return firebaseInstallations;
    }

    public static final FirebaseInstallations installations(Firebase firebase, FirebaseApp app) {
        k.e(firebase, "<this>");
        k.e(app, "app");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance(app);
        k.d(firebaseInstallations, "getInstance(...)");
        return firebaseInstallations;
    }
}
