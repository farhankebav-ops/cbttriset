package com.onesignal.session.internal.session.impl;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import e6.l;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionListener implements IStartableService, ISessionLifecycleHandler {
    public static final Companion Companion = new Companion(null);
    public static final long SECONDS_IN_A_DAY = 86400;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final IOutcomeEventsController _outcomeEventsController;
    private final ISessionService _sessionService;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.session.impl.SessionListener$onSessionEnded$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.session.internal.session.impl.SessionListener$onSessionEnded$1", f = "SessionListener.kt", l = {62}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ long $durationInSeconds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.$durationInSeconds = j;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return SessionListener.this.new AnonymousClass1(this.$durationInSeconds, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IOutcomeEventsController iOutcomeEventsController = SessionListener.this._outcomeEventsController;
                long j = this.$durationInSeconds;
                this.label = 1;
                if (iOutcomeEventsController.sendSessionEndOutcomeEvent(j, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public SessionListener(IOperationRepo _operationRepo, ISessionService _sessionService, ConfigModelStore _configModelStore, IdentityModelStore _identityModelStore, IOutcomeEventsController _outcomeEventsController) {
        k.e(_operationRepo, "_operationRepo");
        k.e(_sessionService, "_sessionService");
        k.e(_configModelStore, "_configModelStore");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_outcomeEventsController, "_outcomeEventsController");
        this._operationRepo = _operationRepo;
        this._sessionService = _sessionService;
        this._configModelStore = _configModelStore;
        this._identityModelStore = _identityModelStore;
        this._outcomeEventsController = _outcomeEventsController;
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long j) {
        long j3 = j / ((long) 1000);
        if (j3 < 1 || j3 > SECONDS_IN_A_DAY) {
            Logging.error$default("SessionListener.onSessionEnded sending duration of " + j3 + " seconds", null, 2, null);
        }
        IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackSessionEndOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId(), j3), false, 2, null);
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(j3, null), 1, null);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        this._operationRepo.enqueue(new TrackSessionStartOperation(this._configModelStore.getModel().getAppId(), this._identityModelStore.getModel().getOnesignalId()), true);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._sessionService.subscribe(this);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }
}
