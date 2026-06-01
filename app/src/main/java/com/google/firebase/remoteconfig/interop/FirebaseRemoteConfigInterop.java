package com.google.firebase.remoteconfig.interop;

import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface FirebaseRemoteConfigInterop {
    void registerRolloutsStateSubscriber(@NonNull String str, @NonNull RolloutsStateSubscriber rolloutsStateSubscriber);
}
