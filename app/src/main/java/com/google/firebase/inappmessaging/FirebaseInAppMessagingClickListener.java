package com.google.firebase.inappmessaging;

import androidx.annotation.NonNull;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.InAppMessage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface FirebaseInAppMessagingClickListener {
    void messageClicked(@NonNull InAppMessage inAppMessage, @NonNull Action action);
}
