package com.google.firebase.sessions.settings;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import p5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
public final class LocalOverrideSettings_Factory implements Factory<LocalOverrideSettings> {
    private final a appContextProvider;

    public LocalOverrideSettings_Factory(a aVar) {
        this.appContextProvider = aVar;
    }

    public static LocalOverrideSettings_Factory create(a aVar) {
        return new LocalOverrideSettings_Factory(aVar);
    }

    public static LocalOverrideSettings newInstance(Context context) {
        return new LocalOverrideSettings(context);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, com.google.firebase.sessions.dagger.internal.Provider, p5.a
    public LocalOverrideSettings get() {
        return newInstance((Context) this.appContextProvider.get());
    }
}
