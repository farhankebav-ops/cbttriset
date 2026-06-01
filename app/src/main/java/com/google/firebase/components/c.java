package com.google.firebase.components;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5520b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f5519a = i2;
        this.f5520b = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f5519a) {
            case 0:
                return ComponentDiscovery.instantiate((String) this.f5520b);
            default:
                return FirebaseInstallations.lambda$new$0((FirebaseApp) this.f5520b);
        }
    }
}
