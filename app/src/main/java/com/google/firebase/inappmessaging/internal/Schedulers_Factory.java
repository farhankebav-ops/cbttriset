package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"javax.inject.Named"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class Schedulers_Factory implements Factory<Schedulers> {
    private final p5.a computeSchedulerProvider;
    private final p5.a ioSchedulerProvider;
    private final p5.a mainThreadSchedulerProvider;

    public Schedulers_Factory(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        this.ioSchedulerProvider = aVar;
        this.computeSchedulerProvider = aVar2;
        this.mainThreadSchedulerProvider = aVar3;
    }

    public static Schedulers_Factory create(p5.a aVar, p5.a aVar2, p5.a aVar3) {
        return new Schedulers_Factory(aVar, aVar2, aVar3);
    }

    public static Schedulers newInstance(s4.p pVar, s4.p pVar2, s4.p pVar3) {
        return new Schedulers(pVar, pVar2, pVar3);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public Schedulers get() {
        return newInstance((s4.p) this.ioSchedulerProvider.get(), (s4.p) this.computeSchedulerProvider.get(), (s4.p) this.mainThreadSchedulerProvider.get());
    }
}
