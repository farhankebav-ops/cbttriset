package com.google.firebase.messaging;

import com.google.firebase.Firebase;
import com.google.firebase.messaging.RemoteMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class MessagingKt {
    public static final FirebaseMessaging getMessaging(Firebase firebase) {
        kotlin.jvm.internal.k.e(firebase, "<this>");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        kotlin.jvm.internal.k.d(firebaseMessaging, "getInstance(...)");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(String to, e6.l init) {
        kotlin.jvm.internal.k.e(to, "to");
        kotlin.jvm.internal.k.e(init, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(to);
        init.invoke(builder);
        RemoteMessage remoteMessageBuild = builder.build();
        kotlin.jvm.internal.k.d(remoteMessageBuild, "build(...)");
        return remoteMessageBuild;
    }
}
