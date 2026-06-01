package com.onesignal.session;

import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.session.internal.SessionManager;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.influence.impl.InfluenceManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.outcomes.impl.IOutcomeEventsBackendService;
import com.onesignal.session.internal.outcomes.impl.IOutcomeEventsPreferences;
import com.onesignal.session.internal.outcomes.impl.IOutcomeEventsRepository;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsBackendService;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsController;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsPreferences;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsRepository;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.session.internal.session.SessionModelStore;
import com.onesignal.session.internal.session.impl.SessionListener;
import com.onesignal.session.internal.session.impl.SessionService;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionModule implements IModule {
    @Override // com.onesignal.common.modules.IModule
    public void register(ServiceBuilder builder) {
        k.e(builder, "builder");
        builder.register(OutcomeEventsPreferences.class).provides(IOutcomeEventsPreferences.class);
        builder.register(OutcomeEventsRepository.class).provides(IOutcomeEventsRepository.class);
        builder.register(OutcomeEventsBackendService.class).provides(IOutcomeEventsBackendService.class);
        builder.register(OutcomeEventsController.class).provides(IOutcomeEventsController.class).provides(IStartableService.class);
        builder.register(InfluenceManager.class).provides(IInfluenceManager.class);
        builder.register(SessionModelStore.class).provides(SessionModelStore.class);
        builder.register(SessionService.class).provides(ISessionService.class).provides(IStartableService.class).provides(IBackgroundService.class).provides(IBootstrapService.class);
        builder.register(SessionListener.class).provides(IStartableService.class);
        builder.register(SessionManager.class).provides(ISessionManager.class);
    }
}
