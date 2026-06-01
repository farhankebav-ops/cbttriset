package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.DaggerGenerated;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.dagger.internal.QualifierMetadata;
import com.google.firebase.inappmessaging.dagger.internal.ScopeMetadata;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@QualifierMetadata({"com.google.firebase.inappmessaging.internal.injection.qualifiers.ProgrammaticTrigger"})
@ScopeMetadata("javax.inject.Singleton")
@DaggerGenerated
public final class ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory implements Factory<ProgramaticContextualTriggers> {
    private final ProgrammaticContextualTriggerFlowableModule module;

    public ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        this.module = programmaticContextualTriggerFlowableModule;
    }

    public static ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory create(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return new ProgrammaticContextualTriggerFlowableModule_ProvidesProgramaticContextualTriggersFactory(programmaticContextualTriggerFlowableModule);
    }

    public static ProgramaticContextualTriggers providesProgramaticContextualTriggers(ProgrammaticContextualTriggerFlowableModule programmaticContextualTriggerFlowableModule) {
        return (ProgramaticContextualTriggers) Preconditions.checkNotNullFromProvides(programmaticContextualTriggerFlowableModule.providesProgramaticContextualTriggers());
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory, com.google.firebase.inappmessaging.dagger.internal.Provider, p5.a
    public ProgramaticContextualTriggers get() {
        return providesProgramaticContextualTriggers(this.module);
    }
}
