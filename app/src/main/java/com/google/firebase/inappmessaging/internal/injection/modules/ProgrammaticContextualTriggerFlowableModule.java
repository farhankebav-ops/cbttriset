package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger;
import com.ironsource.adqualitysdk.sdk.i.a0;
import d5.m;
import d5.q0;
import j7.a;
import s4.d;
import s4.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Module
public class ProgrammaticContextualTriggerFlowableModule {
    private ProgramaticContextualTriggers triggers;

    public ProgrammaticContextualTriggerFlowableModule(ProgramaticContextualTriggers programaticContextualTriggers) {
        this.triggers = programaticContextualTriggers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$providesProgramaticContextualTriggerStream$1(e eVar) throws Exception {
        this.triggers.setListener(new a(eVar, 4));
    }

    @Provides
    @ProgrammaticTrigger
    public w4.a providesProgramaticContextualTriggerStream() {
        a aVar = new a(this, 3);
        int i2 = d.f13683a;
        a0.h(3, "mode is null");
        q0 q0VarC = new m(aVar, 0).c();
        q0VarC.f();
        return q0VarC;
    }

    @Provides
    @ProgrammaticTrigger
    public ProgramaticContextualTriggers providesProgramaticContextualTriggers() {
        return this.triggers;
    }
}
