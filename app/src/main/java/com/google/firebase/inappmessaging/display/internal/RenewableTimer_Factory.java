package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.display.dagger.internal.Factory;
import com.google.firebase.inappmessaging.display.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.display.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata
@DaggerGenerated
@ScopeMetadata
public final class RenewableTimer_Factory implements Factory<RenewableTimer> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class InstanceHolder {
        private static final RenewableTimer_Factory INSTANCE = new RenewableTimer_Factory();

        private InstanceHolder() {
        }
    }

    public static RenewableTimer_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static RenewableTimer newInstance() {
        return new RenewableTimer();
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory, com.google.firebase.inappmessaging.display.dagger.internal.Provider, p5.a
    public RenewableTimer get() {
        return newInstance();
    }
}
