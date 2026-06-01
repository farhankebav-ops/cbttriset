package com.google.firebase.remoteconfig;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.CustomSignals;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import e6.l;
import kotlin.jvm.internal.k;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class RemoteConfigKt {
    public static final CustomSignals customSignals(l builder) {
        k.e(builder, "builder");
        CustomSignals.Builder builder2 = new CustomSignals.Builder();
        builder.invoke(builder2);
        CustomSignals customSignalsBuild = builder2.build();
        k.d(customSignalsBuild, "build(...)");
        return customSignalsBuild;
    }

    public static final FirebaseRemoteConfigValue get(FirebaseRemoteConfig firebaseRemoteConfig, String key) {
        k.e(firebaseRemoteConfig, "<this>");
        k.e(key, "key");
        FirebaseRemoteConfigValue value = firebaseRemoteConfig.getValue(key);
        k.d(value, "getValue(...)");
        return value;
    }

    public static final t6.e getConfigUpdates(FirebaseRemoteConfig firebaseRemoteConfig) {
        k.e(firebaseRemoteConfig, "<this>");
        return x0.h(new RemoteConfigKt$configUpdates$1(firebaseRemoteConfig, null));
    }

    public static final FirebaseRemoteConfig getRemoteConfig(Firebase firebase) {
        k.e(firebase, "<this>");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        k.d(firebaseRemoteConfig, "getInstance(...)");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfig remoteConfig(Firebase firebase, FirebaseApp app) {
        k.e(firebase, "<this>");
        k.e(app, "app");
        FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance(app);
        k.d(firebaseRemoteConfig, "getInstance(...)");
        return firebaseRemoteConfig;
    }

    public static final FirebaseRemoteConfigSettings remoteConfigSettings(l init) {
        k.e(init, "init");
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        init.invoke(builder);
        FirebaseRemoteConfigSettings firebaseRemoteConfigSettingsBuild = builder.build();
        k.d(firebaseRemoteConfigSettingsBuild, "build(...)");
        return firebaseRemoteConfigSettingsBuild;
    }
}
