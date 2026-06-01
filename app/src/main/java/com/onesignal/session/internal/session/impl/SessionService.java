package com.onesignal.session.internal.session.impl;

import androidx.camera.core.processing.util.a;
import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IBootstrapService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.session.internal.session.SessionModelStore;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionService implements ISessionService, IBootstrapService, IStartableService, IBackgroundService, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final SessionModelStore _sessionModelStore;
    private final ITime _time;
    private ConfigModel config;
    private boolean hasFocused;
    private SessionModel session;
    private final EventProducer<ISessionLifecycleHandler> sessionLifeCycleNotifier;
    private boolean shouldFireOnSubscribe;

    /* JADX INFO: renamed from: com.onesignal.session.internal.session.impl.SessionService$endSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ long $activeDuration;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$activeDuration = j;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISessionLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISessionLifecycleHandler it) {
            k.e(it, "it");
            it.onSessionEnded(this.$activeDuration);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.session.impl.SessionService$onFocus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C28321 extends l implements e6.l {
        public static final C28321 INSTANCE = new C28321();

        public C28321() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISessionLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISessionLifecycleHandler it) {
            k.e(it, "it");
            it.onSessionStarted();
        }
    }

    /* JADX INFO: renamed from: com.onesignal.session.internal.session.impl.SessionService$onFocus$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISessionLifecycleHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISessionLifecycleHandler it) {
            k.e(it, "it");
            it.onSessionActive();
        }
    }

    public SessionService(IApplicationService _applicationService, ConfigModelStore _configModelStore, SessionModelStore _sessionModelStore, ITime _time) {
        k.e(_applicationService, "_applicationService");
        k.e(_configModelStore, "_configModelStore");
        k.e(_sessionModelStore, "_sessionModelStore");
        k.e(_time, "_time");
        this._applicationService = _applicationService;
        this._configModelStore = _configModelStore;
        this._sessionModelStore = _sessionModelStore;
        this._time = _time;
        this.sessionLifeCycleNotifier = new EventProducer<>();
    }

    private final void endSession() {
        SessionModel sessionModel = this.session;
        k.b(sessionModel);
        if (sessionModel.isValid()) {
            SessionModel sessionModel2 = this.session;
            k.b(sessionModel2);
            long activeDuration = sessionModel2.getActiveDuration();
            Logging.debug$default(a.j("SessionService.backgroundRun: Session ended. activeDuration: ", activeDuration), null, 2, null);
            SessionModel sessionModel3 = this.session;
            k.b(sessionModel3);
            sessionModel3.setValid(false);
            this.sessionLifeCycleNotifier.fire(new AnonymousClass1(activeDuration));
            SessionModel sessionModel4 = this.session;
            k.b(sessionModel4);
            sessionModel4.setActiveDuration(0L);
        }
    }

    @Override // com.onesignal.core.internal.background.IBackgroundService
    public Object backgroundRun(c<? super x> cVar) {
        endSession();
        return x.f13520a;
    }

    @Override // com.onesignal.core.internal.startup.IBootstrapService
    public void bootstrap() {
        this.session = this._sessionModelStore.getModel();
        this.config = this._configModelStore.getModel();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.sessionLifeCycleNotifier.getHasSubscribers();
    }

    @Override // com.onesignal.core.internal.background.IBackgroundService
    public Long getScheduleBackgroundRunIn() {
        SessionModel sessionModel = this.session;
        k.b(sessionModel);
        if (!sessionModel.isValid()) {
            return null;
        }
        ConfigModel configModel = this.config;
        k.b(configModel);
        return Long.valueOf(configModel.getSessionFocusTimeout());
    }

    @Override // com.onesignal.session.internal.session.ISessionService
    public long getStartTime() {
        SessionModel sessionModel = this.session;
        k.b(sessionModel);
        return sessionModel.getStartTime();
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus(boolean z2) {
        Logging.log(LogLevel.DEBUG, "SessionService.onFocus() - fired from start: " + z2);
        if (!this.hasFocused) {
            this.hasFocused = true;
            endSession();
        }
        SessionModel sessionModel = this.session;
        k.b(sessionModel);
        if (sessionModel.isValid()) {
            SessionModel sessionModel2 = this.session;
            k.b(sessionModel2);
            sessionModel2.setFocusTime(this._time.getCurrentTimeMillis());
            this.sessionLifeCycleNotifier.fire(AnonymousClass2.INSTANCE);
            return;
        }
        this.shouldFireOnSubscribe = z2;
        SessionModel sessionModel3 = this.session;
        k.b(sessionModel3);
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        sessionModel3.setSessionId(string);
        SessionModel sessionModel4 = this.session;
        k.b(sessionModel4);
        sessionModel4.setStartTime(this._time.getCurrentTimeMillis());
        SessionModel sessionModel5 = this.session;
        k.b(sessionModel5);
        SessionModel sessionModel6 = this.session;
        k.b(sessionModel6);
        sessionModel5.setFocusTime(sessionModel6.getStartTime());
        SessionModel sessionModel7 = this.session;
        k.b(sessionModel7);
        sessionModel7.setValid(true);
        StringBuilder sb = new StringBuilder("SessionService: New session started at ");
        SessionModel sessionModel8 = this.session;
        k.b(sessionModel8);
        sb.append(sessionModel8.getStartTime());
        Logging.debug$default(sb.toString(), null, 2, null);
        this.sessionLifeCycleNotifier.fire(C28321.INSTANCE);
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
        long currentTimeMillis = this._time.getCurrentTimeMillis();
        SessionModel sessionModel = this.session;
        k.b(sessionModel);
        long focusTime = currentTimeMillis - sessionModel.getFocusTime();
        SessionModel sessionModel2 = this.session;
        k.b(sessionModel2);
        sessionModel2.setActiveDuration(sessionModel2.getActiveDuration() + focusTime);
        LogLevel logLevel = LogLevel.DEBUG;
        StringBuilder sbT = a.t("SessionService.onUnfocused adding time ", focusTime, " for total: ");
        SessionModel sessionModel3 = this.session;
        k.b(sessionModel3);
        sbT.append(sessionModel3.getActiveDuration());
        Logging.log(logLevel, sbT.toString());
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._applicationService.addApplicationLifecycleHandler(this);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ISessionLifecycleHandler handler) {
        k.e(handler, "handler");
        this.sessionLifeCycleNotifier.subscribe(handler);
        if (this.shouldFireOnSubscribe) {
            handler.onSessionStarted();
        }
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ISessionLifecycleHandler handler) {
        k.e(handler, "handler");
        this.sessionLifeCycleNotifier.unsubscribe(handler);
    }
}
