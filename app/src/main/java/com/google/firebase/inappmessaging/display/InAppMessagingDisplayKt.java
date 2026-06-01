package com.google.firebase.inappmessaging.display;

import com.google.firebase.Firebase;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class InAppMessagingDisplayKt {
    public static final FirebaseInAppMessagingDisplay getInAppMessagingDisplay(Firebase firebase) {
        k.e(firebase, "<this>");
        FirebaseInAppMessagingDisplay firebaseInAppMessagingDisplay = FirebaseInAppMessagingDisplay.getInstance();
        k.d(firebaseInAppMessagingDisplay, "getInstance(...)");
        return firebaseInAppMessagingDisplay;
    }
}
