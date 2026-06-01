package com.onesignal.inAppMessages.internal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.consistency.models.IConsistencyManager;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.inAppMessages.InAppMessageActionUrlType;
import com.onesignal.inAppMessages.R;
import com.onesignal.inAppMessages.internal.backend.IInAppBackendService;
import com.onesignal.inAppMessages.internal.common.InAppHelper;
import com.onesignal.inAppMessages.internal.common.OneSignalChromeTab;
import com.onesignal.inAppMessages.internal.display.IInAppDisplayer;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController;
import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import com.onesignal.inAppMessages.internal.repositories.IInAppRepository;
import com.onesignal.inAppMessages.internal.state.InAppStateService;
import com.onesignal.inAppMessages.internal.triggers.ITriggerController;
import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import com.onesignal.inAppMessages.internal.triggers.TriggerModelStore;
import com.onesignal.session.internal.influence.IInfluenceManager;
import com.onesignal.session.internal.outcomes.IOutcomeEventsController;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.backend.IdentityConstants;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import com.unity3d.mediation.LevelPlayAdError;
import e6.l;
import e6.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;
import q5.x;
import q6.c0;
import q6.m0;
import q6.z0;
import r2.q;
import v6.n;
import x5.c;
import x5.e;
import x5.i;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class InAppMessagesManager implements IInAppMessagesManager, IStartableService, ISubscriptionChangedHandler, ISingletonModelStoreChangeHandler<ConfigModel>, IInAppLifecycleEventHandler, ITriggerHandler, ISessionLifecycleHandler, IApplicationLifecycleHandler {
    private final IApplicationService _applicationService;
    private final IInAppBackendService _backend;
    private final ConfigModelStore _configModelStore;
    private final IConsistencyManager _consistencyManager;
    private final IInAppDisplayer _displayer;
    private final IdentityModelStore _identityModelStore;
    private final IInfluenceManager _influenceManager;
    private final ILanguageContext _languageContext;
    private final IInAppLifecycleService _lifecycle;
    private final IOutcomeEventsController _outcomeEventsController;
    private final IInAppPreferencesController _prefs;
    private final IInAppRepository _repository;
    private final ISessionService _sessionService;
    private final InAppStateService _state;
    private final ISubscriptionManager _subscriptionManager;
    private final ITime _time;
    private final ITriggerController _triggerController;
    private final TriggerModelStore _triggerModelStore;
    private final IUserManager _userManager;
    private final Set<String> clickedClickIds;
    private final Set<String> dismissedMessages;
    private final z6.a fetchIAMMutex;
    private final InAppMessagesManager$identityModelChangeHandler$1 identityModelChangeHandler;
    private final Set<String> impressionedMessages;
    private Long lastTimeFetchedIAMs;
    private final EventProducer<IInAppMessageLifecycleListener> lifecycleCallback;
    private final EventProducer<IInAppMessageClickListener> messageClickCallback;
    private final List<InAppMessage> messageDisplayQueue;
    private final z6.a messageDisplayQueueMutex;
    private List<InAppMessage> messages;
    private final List<InAppMessage> redisplayedInAppMessages;
    private final Set<String> viewedPageIds;

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$attemptToShowInAppMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {TTAdConstant.IMAGE_URL_CODE, 968, 442, 449, 453}, m = "attemptToShowInAppMessage")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.attemptToShowInAppMessage(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {335}, m = "evaluateInAppMessages")
    public static final class C27031 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27031(v5.c<? super C27031> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.evaluateInAppMessages(this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessages$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {968, 308, 312}, m = "fetchMessages")
    public static final class C27041 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C27041(v5.c<? super C27041> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.fetchMessages(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessagesWhenConditionIsMet$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$fetchMessagesWhenConditionIsMet$1", f = "InAppMessagesManager.kt", l = {271, 272, 275}, m = "invokeSuspend")
    public static final class C27051 extends i implements l {
        int label;

        public C27051(v5.c<? super C27051> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27051(cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        
            if (r1.fetchMessages(r7, r6) == r0) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r6.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                r2.q.z0(r7)
                goto L60
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                r2.q.z0(r7)
                goto L51
            L1f:
                r2.q.z0(r7)
                goto L44
            L23:
                r2.q.z0(r7)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r7 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                com.onesignal.user.IUserManager r7 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$get_userManager$p(r7)
                java.lang.String r7 = r7.getOnesignalId()
                com.onesignal.inAppMessages.internal.InAppMessagesManager r1 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                com.onesignal.common.consistency.models.IConsistencyManager r1 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$get_consistencyManager$p(r1)
                com.onesignal.common.consistency.IamFetchReadyCondition r5 = new com.onesignal.common.consistency.IamFetchReadyCondition
                r5.<init>(r7)
                r6.label = r4
                java.lang.Object r7 = r1.getRywDataFromAwaitableCondition(r5, r6)
                if (r7 != r0) goto L44
                goto L5f
            L44:
                q6.q r7 = (q6.q) r7
                r6.label = r3
                q6.r r7 = (q6.r) r7
                java.lang.Object r7 = r7.t(r6)
                if (r7 != r0) goto L51
                goto L5f
            L51:
                com.onesignal.common.consistency.RywData r7 = (com.onesignal.common.consistency.RywData) r7
                if (r7 == 0) goto L60
                com.onesignal.inAppMessages.internal.InAppMessagesManager r1 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                r6.label = r2
                java.lang.Object r7 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fetchMessages(r1, r7, r6)
                if (r7 != r0) goto L60
            L5f:
                return r0
            L60:
                q5.x r7 = q5.x.f13520a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.C27051.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27051) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {773, 775, 777}, m = "fireOutcomesForClick")
    public static final class C27061 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27061(v5.c<? super C27061> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.fireOutcomesForClick(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$firePublicClickHandler$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$firePublicClickHandler$2", f = "InAppMessagesManager.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ InAppMessageClickEvent $result;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(InAppMessageClickEvent inAppMessageClickEvent, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$result = inAppMessageClickEvent;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$result, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // e6.p
        public final Object invoke(IInAppMessageClickListener iInAppMessageClickListener, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(iInAppMessageClickListener, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            ((IInAppMessageClickListener) this.L$0).onClick(this.$result);
            return x.f13520a;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForClick$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {924}, m = "fireRESTCallForClick")
    public static final class C27071 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C27071(v5.c<? super C27071> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.fireRESTCallForClick(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {887}, m = "fireRESTCallForPageChange")
    public static final class C27081 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27081(v5.c<? super C27081> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.fireRESTCallForPageChange(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {475, 501, 504}, m = "messageWasDismissed")
    public static final class C27091 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27091(v5.c<? super C27091> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.messageWasDismissed(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$messageWasDismissed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27102 extends kotlin.jvm.internal.l implements l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27102(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppMessageLifecycleListener) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppMessageLifecycleListener it) {
            k.e(it, "it");
            it.onDidDismiss(new InAppMessageLifecycleEvent(this.$message));
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnMessage$1", f = "InAppMessagesManager.kt", l = {665, TTAdConstant.STYLE_SIZE_RADIO_2_3, 668, 670}, m = "invokeSuspend")
    public static final class C27111 extends i implements l {
        final /* synthetic */ InAppMessageClickResult $action;
        final /* synthetic */ InAppMessage $message;
        int label;
        final /* synthetic */ InAppMessagesManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27111(InAppMessageClickResult inAppMessageClickResult, InAppMessage inAppMessage, InAppMessagesManager inAppMessagesManager, v5.c<? super C27111> cVar) {
            super(1, cVar);
            this.$action = inAppMessageClickResult;
            this.$message = inAppMessage;
            this.this$0 = inAppMessagesManager;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return new C27111(this.$action, this.$message, this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
        
            if (r8.fireOutcomesForClick(r1, r3, r7) != r0) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r7.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2b
                if (r1 == r5) goto L27
                if (r1 == r4) goto L23
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                r2.q.z0(r8)
                goto L8f
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                r2.q.z0(r8)
                goto L71
            L23:
                r2.q.z0(r8)
                goto L5b
            L27:
                r2.q.z0(r8)
                goto L48
            L2b:
                r2.q.z0(r8)
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r8 = r7.$action
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r7.$message
                boolean r1 = r1.takeActionAsUnique()
                r8.setFirstClick(r1)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = r7.this$0
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r7.$message
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r6 = r7.$action
                r7.label = r5
                java.lang.Object r8 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$firePublicClickHandler(r8, r1, r6, r7)
                if (r8 != r0) goto L48
                goto L8e
            L48:
                com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = r7.this$0
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r7.$message
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r5 = r7.$action
                java.util.List r5 = r5.getPrompts()
                r7.label = r4
                java.lang.Object r8 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$beginProcessingPrompts(r8, r1, r5, r7)
                if (r8 != r0) goto L5b
                goto L8e
            L5b:
                com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = r7.this$0
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r1 = r7.$action
                com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fireClickAction(r8, r1)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = r7.this$0
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r7.$message
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r4 = r7.$action
                r7.label = r3
                java.lang.Object r8 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fireRESTCallForClick(r8, r1, r4, r7)
                if (r8 != r0) goto L71
                goto L8e
            L71:
                com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = r7.this$0
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r1 = r7.$action
                com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fireTagCallForClick(r8, r1)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r8 = r7.this$0
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r7.$message
                java.lang.String r1 = r1.getMessageId()
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r3 = r7.$action
                java.util.List r3 = r3.getOutcomes()
                r7.label = r2
                java.lang.Object r8 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fireOutcomesForClick(r8, r1, r3, r7)
                if (r8 != r0) goto L8f
            L8e:
                return r0
            L8f:
                q5.x r8 = q5.x.f13520a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.C27111.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27111) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnPreview$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnPreview$1", f = "InAppMessagesManager.kt", l = {652, 653}, m = "invokeSuspend")
    public static final class C27121 extends i implements l {
        final /* synthetic */ InAppMessageClickResult $action;
        final /* synthetic */ InAppMessage $message;
        int label;
        final /* synthetic */ InAppMessagesManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27121(InAppMessageClickResult inAppMessageClickResult, InAppMessage inAppMessage, InAppMessagesManager inAppMessagesManager, v5.c<? super C27121> cVar) {
            super(1, cVar);
            this.$action = inAppMessageClickResult;
            this.$message = inAppMessage;
            this.this$0 = inAppMessagesManager;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return new C27121(this.$action, this.$message, this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
        
            if (r6.beginProcessingPrompts(r1, r3, r5) == r0) goto L15;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                r2.q.z0(r6)
                goto L4c
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L18:
                r2.q.z0(r6)
                goto L39
            L1c:
                r2.q.z0(r6)
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r6 = r5.$action
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r5.$message
                boolean r1 = r1.takeActionAsUnique()
                r6.setFirstClick(r1)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r5.$message
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r4 = r5.$action
                r5.label = r3
                java.lang.Object r6 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$firePublicClickHandler(r6, r1, r4, r5)
                if (r6 != r0) goto L39
                goto L4b
            L39:
                com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
                com.onesignal.inAppMessages.internal.InAppMessage r1 = r5.$message
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r3 = r5.$action
                java.util.List r3 = r3.getPrompts()
                r5.label = r2
                java.lang.Object r6 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$beginProcessingPrompts(r6, r1, r3, r5)
                if (r6 != r0) goto L4c
            L4b:
                return r0
            L4c:
                com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r0 = r5.$action
                com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fireClickAction(r6, r0)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
                com.onesignal.inAppMessages.internal.InAppMessageClickResult r0 = r5.$action
                com.onesignal.inAppMessages.internal.InAppMessagesManager.access$logInAppMessagePreviewActions(r6, r0)
                q5.x r6 = q5.x.f13520a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.C27121.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27121) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessagePageChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessagePageChanged$1", f = "InAppMessagesManager.kt", l = {683}, m = "invokeSuspend")
    public static final class C27131 extends i implements l {
        final /* synthetic */ InAppMessage $message;
        final /* synthetic */ InAppMessagePage $page;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27131(InAppMessage inAppMessage, InAppMessagePage inAppMessagePage, v5.c<? super C27131> cVar) {
            super(1, cVar);
            this.$message = inAppMessage;
            this.$page = inAppMessagePage;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27131(this.$message, this.$page, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                InAppMessagesManager inAppMessagesManager = InAppMessagesManager.this;
                InAppMessage inAppMessage = this.$message;
                InAppMessagePage inAppMessagePage = this.$page;
                this.label = 1;
                if (inAppMessagesManager.fireRESTCallForPageChange(inAppMessage, inAppMessagePage, this) == aVar) {
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
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27131) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDismissed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDismissed$1", f = "InAppMessagesManager.kt", l = {697}, m = "invokeSuspend")
    public static final class C27141 extends i implements l {
        final /* synthetic */ InAppMessage $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27141(InAppMessage inAppMessage, v5.c<? super C27141> cVar) {
            super(1, cVar);
            this.$message = inAppMessage;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27141(this.$message, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                InAppMessagesManager inAppMessagesManager = InAppMessagesManager.this;
                InAppMessage inAppMessage = this.$message;
                this.label = 1;
                if (InAppMessagesManager.messageWasDismissed$default(inAppMessagesManager, inAppMessage, false, this, 2, null) == aVar) {
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
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27141) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDisplayed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27151 extends kotlin.jvm.internal.l implements l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27151(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppMessageLifecycleListener) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppMessageLifecycleListener it) {
            k.e(it, "it");
            it.onDidDisplay(new InAppMessageLifecycleEvent(this.$message));
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDisplayed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDisplayed$2", f = "InAppMessagesManager.kt", l = {LevelPlayAdError.ERROR_CODE_SHOW_WHILE_SHOW}, m = "invokeSuspend")
    public static final class C27162 extends i implements l {
        final /* synthetic */ InAppMessage $message;
        final /* synthetic */ String $variantId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27162(String str, InAppMessage inAppMessage, v5.c<? super C27162> cVar) {
            super(1, cVar);
            this.$variantId = str;
            this.$message = inAppMessage;
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27162(this.$variantId, this.$message, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            C27162 c27162;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    IInAppBackendService iInAppBackendService = InAppMessagesManager.this._backend;
                    String appId = InAppMessagesManager.this._configModelStore.getModel().getAppId();
                    String id = InAppMessagesManager.this._subscriptionManager.getSubscriptions().getPush().getId();
                    String str = this.$variantId;
                    String messageId = this.$message.getMessageId();
                    this.label = 1;
                    c27162 = this;
                    try {
                        if (iInAppBackendService.sendIAMImpression(appId, id, str, messageId, c27162) == aVar) {
                            return aVar;
                        }
                    } catch (BackendException unused) {
                        InAppMessagesManager.this.impressionedMessages.remove(c27162.$message.getMessageId());
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                    c27162 = this;
                }
                InAppMessagesManager.this._prefs.setImpressionesMessagesId(InAppMessagesManager.this.impressionedMessages);
            } catch (BackendException unused2) {
                c27162 = this;
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27162) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWillDismiss$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27171 extends kotlin.jvm.internal.l implements l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27171(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppMessageLifecycleListener) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppMessageLifecycleListener it) {
            k.e(it, "it");
            it.onWillDismiss(new InAppMessageLifecycleEvent(this.$message));
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWillDisplay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C27181 extends kotlin.jvm.internal.l implements l {
        final /* synthetic */ InAppMessage $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C27181(InAppMessage inAppMessage) {
            super(1);
            this.$message = inAppMessage;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IInAppMessageLifecycleListener) obj);
            return x.f13520a;
        }

        public final void invoke(IInAppMessageLifecycleListener it) {
            k.e(it, "it");
            it.onWillDisplay(new InAppMessageLifecycleEvent(this.$message));
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onTriggerChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onTriggerChanged$1", f = "InAppMessagesManager.kt", l = {745}, m = "invokeSuspend")
    public static final class C27191 extends i implements l {
        int label;

        public C27191(v5.c<? super C27191> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27191(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                InAppMessagesManager inAppMessagesManager = InAppMessagesManager.this;
                this.label = 1;
                if (inAppMessagesManager.evaluateInAppMessages(this) == aVar) {
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
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27191) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$onTriggerConditionChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onTriggerConditionChanged$1", f = "InAppMessagesManager.kt", l = {733}, m = "invokeSuspend")
    public static final class C27201 extends i implements l {
        int label;

        public C27201(v5.c<? super C27201> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27201(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                InAppMessagesManager inAppMessagesManager = InAppMessagesManager.this;
                this.label = 1;
                if (inAppMessagesManager.evaluateInAppMessages(this) == aVar) {
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
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27201) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {542}, m = "persistInAppMessage")
    public static final class C27211 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C27211(v5.c<? super C27211> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.persistInAppMessage(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {968, 407}, m = "queueMessageForDisplay")
    public static final class C27221 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C27221(v5.c<? super C27221> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.queueMessageForDisplay(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$showMultiplePrompts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", l = {808, 822}, m = "showMultiplePrompts")
    public static final class C27231 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C27231(v5.c<? super C27231> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InAppMessagesManager.this.showMultiplePrompts(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.InAppMessagesManager$start$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$start$1", f = "InAppMessagesManager.kt", l = {190, 193}, m = "invokeSuspend")
    public static final class C27241 extends i implements l {
        Object L$0;
        int label;

        public C27241(v5.c<? super C27241> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(v5.c<?> cVar) {
            return InAppMessagesManager.this.new C27241(cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0060 A[LOOP:0: B:18:0x005a->B:20:0x0060, LOOP_END] */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r0 = r4.L$0
                java.util.List r0 = (java.util.List) r0
                r2.q.z0(r5)
                goto L4b
            L14:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1c:
                r2.q.z0(r5)
                goto L32
            L20:
                r2.q.z0(r5)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r5 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                com.onesignal.inAppMessages.internal.repositories.IInAppRepository r5 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$get_repository$p(r5)
                r4.label = r3
                java.lang.Object r5 = r5.cleanCachedInAppMessages(r4)
                if (r5 != r0) goto L32
                goto L48
            L32:
                com.onesignal.inAppMessages.internal.InAppMessagesManager r5 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                java.util.List r5 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$getRedisplayedInAppMessages$p(r5)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r1 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                com.onesignal.inAppMessages.internal.repositories.IInAppRepository r1 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$get_repository$p(r1)
                r4.L$0 = r5
                r4.label = r2
                java.lang.Object r1 = r1.listInAppMessages(r4)
                if (r1 != r0) goto L49
            L48:
                return r0
            L49:
                r0 = r5
                r5 = r1
            L4b:
                java.util.Collection r5 = (java.util.Collection) r5
                r0.addAll(r5)
                com.onesignal.inAppMessages.internal.InAppMessagesManager r5 = com.onesignal.inAppMessages.internal.InAppMessagesManager.this
                java.util.List r5 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$getRedisplayedInAppMessages$p(r5)
                java.util.Iterator r5 = r5.iterator()
            L5a:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L6b
                java.lang.Object r0 = r5.next()
                com.onesignal.inAppMessages.internal.InAppMessage r0 = (com.onesignal.inAppMessages.internal.InAppMessage) r0
                r1 = 0
                r0.setDisplayedInSession(r1)
                goto L5a
            L6b:
                q5.x r5 = q5.x.f13520a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.C27241.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.l
        public final Object invoke(v5.c<? super x> cVar) {
            return ((C27241) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX WARN: Type inference failed for: r1v16, types: [com.onesignal.inAppMessages.internal.InAppMessagesManager$identityModelChangeHandler$1] */
    public InAppMessagesManager(IApplicationService _applicationService, ISessionService _sessionService, IInfluenceManager _influenceManager, ConfigModelStore _configModelStore, IUserManager _userManager, IdentityModelStore _identityModelStore, ISubscriptionManager _subscriptionManager, IOutcomeEventsController _outcomeEventsController, InAppStateService _state, IInAppPreferencesController _prefs, IInAppRepository _repository, IInAppBackendService _backend, ITriggerController _triggerController, TriggerModelStore _triggerModelStore, IInAppDisplayer _displayer, IInAppLifecycleService _lifecycle, ILanguageContext _languageContext, ITime _time, IConsistencyManager _consistencyManager) {
        k.e(_applicationService, "_applicationService");
        k.e(_sessionService, "_sessionService");
        k.e(_influenceManager, "_influenceManager");
        k.e(_configModelStore, "_configModelStore");
        k.e(_userManager, "_userManager");
        k.e(_identityModelStore, "_identityModelStore");
        k.e(_subscriptionManager, "_subscriptionManager");
        k.e(_outcomeEventsController, "_outcomeEventsController");
        k.e(_state, "_state");
        k.e(_prefs, "_prefs");
        k.e(_repository, "_repository");
        k.e(_backend, "_backend");
        k.e(_triggerController, "_triggerController");
        k.e(_triggerModelStore, "_triggerModelStore");
        k.e(_displayer, "_displayer");
        k.e(_lifecycle, "_lifecycle");
        k.e(_languageContext, "_languageContext");
        k.e(_time, "_time");
        k.e(_consistencyManager, "_consistencyManager");
        this._applicationService = _applicationService;
        this._sessionService = _sessionService;
        this._influenceManager = _influenceManager;
        this._configModelStore = _configModelStore;
        this._userManager = _userManager;
        this._identityModelStore = _identityModelStore;
        this._subscriptionManager = _subscriptionManager;
        this._outcomeEventsController = _outcomeEventsController;
        this._state = _state;
        this._prefs = _prefs;
        this._repository = _repository;
        this._backend = _backend;
        this._triggerController = _triggerController;
        this._triggerModelStore = _triggerModelStore;
        this._displayer = _displayer;
        this._lifecycle = _lifecycle;
        this._languageContext = _languageContext;
        this._time = _time;
        this._consistencyManager = _consistencyManager;
        this.lifecycleCallback = new EventProducer<>();
        this.messageClickCallback = new EventProducer<>();
        this.messages = new ArrayList();
        this.dismissedMessages = new LinkedHashSet();
        this.impressionedMessages = new LinkedHashSet();
        this.viewedPageIds = new LinkedHashSet();
        this.clickedClickIds = new LinkedHashSet();
        this.messageDisplayQueue = new ArrayList();
        this.messageDisplayQueueMutex = d.a();
        this.redisplayedInAppMessages = new ArrayList();
        this.fetchIAMMutex = d.a();
        this.identityModelChangeHandler = new ISingletonModelStoreChangeHandler<IdentityModel>() { // from class: com.onesignal.inAppMessages.internal.InAppMessagesManager$identityModelChangeHandler$1
            @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
            public void onModelReplaced(IdentityModel model, String tag) {
                k.e(model, "model");
                k.e(tag, "tag");
            }

            @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
            public void onModelUpdated(ModelChangedArgs args, String tag) {
                k.e(args, "args");
                k.e(tag, "tag");
                if (k.a(args.getProperty(), IdentityConstants.ONESIGNAL_ID)) {
                    Object oldValue = args.getOldValue();
                    k.c(oldValue, "null cannot be cast to non-null type kotlin.String");
                    Object newValue = args.getNewValue();
                    k.c(newValue, "null cannot be cast to non-null type kotlin.String");
                    String str = (String) newValue;
                    IDManager iDManager = IDManager.INSTANCE;
                    if (!iDManager.isLocalId((String) oldValue) || iDManager.isLocalId(str)) {
                        return;
                    }
                    ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1(this.this$0, str, null), 1, null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bc A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:35:0x00a5, B:37:0x00bc, B:40:0x00c5, B:42:0x00cd, B:43:0x00d3, B:45:0x00db, B:46:0x00e1), top: B:66:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c5 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:35:0x00a5, B:37:0x00bc, B:40:0x00c5, B:42:0x00cd, B:43:0x00d3, B:45:0x00db, B:46:0x00e1), top: B:66:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0163 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object attemptToShowInAppMessage(v5.c<? super q5.x> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.attemptToShowInAppMessage(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object beginProcessingPrompts(InAppMessage inAppMessage, List<? extends InAppMessagePrompt> list, v5.c<? super x> cVar) throws Throwable {
        boolean zIsEmpty = list.isEmpty();
        x xVar = x.f13520a;
        if (!zIsEmpty) {
            Logging.debug$default("InAppMessagesManager.beginProcessingPrompts: IAM showing prompts from IAM: " + inAppMessage, null, 2, null);
            this._displayer.dismissCurrentInAppMessage();
            Object objShowMultiplePrompts = showMultiplePrompts(inAppMessage, list, cVar);
            if (objShowMultiplePrompts == w5.a.f17774a) {
                return objShowMultiplePrompts;
            }
        }
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object evaluateInAppMessages(v5.c<? super q5.x> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.C27031
            if (r0 == 0) goto L13
            r0 = r9
            com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.C27031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$evaluateInAppMessages$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r4 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r4
            r2.q.z0(r9)
            goto L85
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L37:
            r2.q.z0(r9)
            java.lang.String r9 = "InAppMessagesManager.evaluateInAppMessages()"
            r2 = 2
            r4 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r4, r2, r4)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r2 = r8.messages
            monitor-enter(r2)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r4 = r8.messages     // Catch: java.lang.Throwable -> L7c
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L7c
        L4f:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L7c
            if (r5 == 0) goto L7e
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L7c
            com.onesignal.inAppMessages.internal.InAppMessage r5 = (com.onesignal.inAppMessages.internal.InAppMessage) r5     // Catch: java.lang.Throwable -> L7c
            com.onesignal.inAppMessages.internal.triggers.ITriggerController r6 = r8._triggerController     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.evaluateMessageTriggers(r5)     // Catch: java.lang.Throwable -> L7c
            if (r6 == 0) goto L4f
            r8.setDataForRedisplay(r5)     // Catch: java.lang.Throwable -> L7c
            java.util.Set<java.lang.String> r6 = r8.dismissedMessages     // Catch: java.lang.Throwable -> L7c
            java.lang.String r7 = r5.getMessageId()     // Catch: java.lang.Throwable -> L7c
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L4f
            boolean r6 = r5.isFinished()     // Catch: java.lang.Throwable -> L7c
            if (r6 != 0) goto L4f
            r9.add(r5)     // Catch: java.lang.Throwable -> L7c
            goto L4f
        L7c:
            r9 = move-exception
            goto La1
        L7e:
            monitor-exit(r2)
            java.util.Iterator r9 = r9.iterator()
            r4 = r8
            r2 = r9
        L85:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L9e
            java.lang.Object r9 = r2.next()
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r4.queueMessageForDisplay(r9, r0)
            if (r9 != r1) goto L85
            return r1
        L9e:
            q5.x r9 = q5.x.f13520a
            return r9
        La1:
            monitor-exit(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.evaluateInAppMessages(v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchMessages(com.onesignal.common.consistency.RywData r20, v5.c<? super q5.x> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fetchMessages(com.onesignal.common.consistency.RywData, v5.c):java.lang.Object");
    }

    private final void fetchMessagesWhenConditionIsMet() {
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27051(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fireClickAction(InAppMessageClickResult inAppMessageClickResult) {
        if (inAppMessageClickResult.getUrl() == null || inAppMessageClickResult.getUrl().length() <= 0) {
            return;
        }
        if (inAppMessageClickResult.getUrlTarget() == InAppMessageActionUrlType.BROWSER) {
            AndroidUtils.INSTANCE.openURLInBrowser(this._applicationService.getAppContext(), inAppMessageClickResult.getUrl());
        } else if (inAppMessageClickResult.getUrlTarget() == InAppMessageActionUrlType.IN_APP_WEBVIEW) {
            OneSignalChromeTab.INSTANCE.open$com_onesignal_inAppMessages(inAppMessageClickResult.getUrl(), true, this._applicationService.getAppContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fireOutcomesForClick(java.lang.String r9, java.util.List<com.onesignal.inAppMessages.internal.InAppMessageOutcome> r10, v5.c<? super q5.x> r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.C27061
            if (r0 == 0) goto L13
            r0 = r11
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.C27061) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireOutcomesForClick$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L32
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L32:
            java.lang.Object r9 = r0.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r10 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r10
            r2.q.z0(r11)
            goto L4b
        L3e:
            r2.q.z0(r11)
            com.onesignal.session.internal.influence.IInfluenceManager r11 = r8._influenceManager
            r11.onDirectInfluenceFromIAM(r9)
            java.util.Iterator r9 = r10.iterator()
            r10 = r8
        L4b:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L9b
            java.lang.Object r11 = r9.next()
            com.onesignal.inAppMessages.internal.InAppMessageOutcome r11 = (com.onesignal.inAppMessages.internal.InAppMessageOutcome) r11
            java.lang.String r2 = r11.getName()
            boolean r6 = r11.isUnique()
            if (r6 == 0) goto L70
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r11 = r10._outcomeEventsController
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r11 = r11.sendUniqueOutcomeEvent(r2, r0)
            if (r11 != r1) goto L4b
            goto L9a
        L70:
            float r6 = r11.getWeight()
            r7 = 0
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L8c
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r6 = r10._outcomeEventsController
            float r11 = r11.getWeight()
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r11 = r6.sendOutcomeEventWithValue(r2, r11, r0)
            if (r11 != r1) goto L4b
            goto L9a
        L8c:
            com.onesignal.session.internal.outcomes.IOutcomeEventsController r11 = r10._outcomeEventsController
            r0.L$0 = r10
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r11 = r11.sendOutcomeEvent(r2, r0)
            if (r11 != r1) goto L4b
        L9a:
            return r1
        L9b:
            q5.x r9 = q5.x.f13520a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireOutcomesForClick(java.lang.String, java.util.List, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object firePublicClickHandler(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult, v5.c<? super x> cVar) throws Throwable {
        boolean hasSubscribers = this.messageClickCallback.getHasSubscribers();
        x xVar = x.f13520a;
        if (!hasSubscribers) {
            return xVar;
        }
        this._influenceManager.onDirectInfluenceFromIAM(inAppMessage.getMessageId());
        Object objSuspendingFireOnMain = this.messageClickCallback.suspendingFireOnMain(new AnonymousClass2(new InAppMessageClickEvent(inAppMessage, inAppMessageClickResult), null), cVar);
        return objSuspendingFireOnMain == w5.a.f17774a ? objSuspendingFireOnMain : xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fireRESTCallForClick(com.onesignal.inAppMessages.internal.InAppMessage r11, com.onesignal.inAppMessages.internal.InAppMessageClickResult r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForClick(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessageClickResult, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fireRESTCallForPageChange(com.onesignal.inAppMessages.internal.InAppMessage r10, com.onesignal.inAppMessages.internal.InAppMessagePage r11, v5.c<? super q5.x> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.C27081
            if (r0 == 0) goto L14
            r0 = r12
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.C27081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$fireRESTCallForPageChange$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r7.result
            w5.a r0 = w5.a.f17774a
            int r1 = r7.label
            r2 = 1
            q5.x r8 = q5.x.f13520a
            if (r1 == 0) goto L3c
            if (r1 != r2) goto L34
            java.lang.Object r10 = r7.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r7.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r11 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r11
            r2.q.z0(r12)     // Catch: com.onesignal.common.exceptions.BackendException -> Lbc
            goto Lb2
        L34:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3c:
            r2.q.z0(r12)
            com.onesignal.inAppMessages.internal.common.InAppHelper r12 = com.onesignal.inAppMessages.internal.common.InAppHelper.INSTANCE
            com.onesignal.core.internal.language.ILanguageContext r1 = r9._languageContext
            java.lang.String r4 = r12.variantIdForMessage(r10, r1)
            if (r4 != 0) goto L4a
            return r8
        L4a:
            java.lang.String r6 = r11.getPageId()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r10.getMessageId()
            r11.append(r12)
            r11.append(r6)
            java.lang.String r11 = r11.toString()
            java.util.Set<java.lang.String> r12 = r9.viewedPageIds
            boolean r12 = r12.contains(r11)
            if (r12 == 0) goto L7d
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "InAppMessagesManager: Already sent page impression for id: "
            r10.<init>(r11)
            r10.append(r6)
            java.lang.String r10 = r10.toString()
            r11 = 2
            r12 = 0
            com.onesignal.debug.internal.logging.Logging.verbose$default(r10, r12, r11, r12)
            return r8
        L7d:
            java.util.Set<java.lang.String> r12 = r9.viewedPageIds
            r12.add(r11)
            com.onesignal.inAppMessages.internal.backend.IInAppBackendService r1 = r9._backend     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            com.onesignal.core.internal.config.ConfigModelStore r12 = r9._configModelStore     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            com.onesignal.common.modeling.Model r12 = r12.getModel()     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            com.onesignal.core.internal.config.ConfigModel r12 = (com.onesignal.core.internal.config.ConfigModel) r12     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            java.lang.String r12 = r12.getAppId()     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r3 = r9._subscriptionManager     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            com.onesignal.user.internal.subscriptions.SubscriptionList r3 = r3.getSubscriptions()     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            com.onesignal.user.subscriptions.IPushSubscription r3 = r3.getPush()     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            java.lang.String r3 = r3.getId()     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            java.lang.String r5 = r10.getMessageId()     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            r7.L$0 = r9     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            r7.L$1 = r11     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            r7.label = r2     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            r2 = r12
            java.lang.Object r10 = r1.sendIAMPageImpression(r2, r3, r4, r5, r6, r7)     // Catch: com.onesignal.common.exceptions.BackendException -> Lba
            if (r10 != r0) goto Lb0
            return r0
        Lb0:
            r10 = r11
            r11 = r9
        Lb2:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r12 = r11._prefs     // Catch: com.onesignal.common.exceptions.BackendException -> Lbc
            java.util.Set<java.lang.String> r0 = r11.viewedPageIds     // Catch: com.onesignal.common.exceptions.BackendException -> Lbc
            r12.setViewPageImpressionedIds(r0)     // Catch: com.onesignal.common.exceptions.BackendException -> Lbc
            goto Lc1
        Lba:
            r10 = r11
            r11 = r9
        Lbc:
            java.util.Set<java.lang.String> r11 = r11.viewedPageIds
            r11.remove(r10)
        Lc1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.fireRESTCallForPageChange(com.onesignal.inAppMessages.internal.InAppMessage, com.onesignal.inAppMessages.internal.InAppMessagePage, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fireTagCallForClick(InAppMessageClickResult inAppMessageClickResult) {
        if (inAppMessageClickResult.getTags() != null) {
            InAppMessageTag tags = inAppMessageClickResult.getTags();
            if ((tags != null ? tags.getTagsToAdd() : null) != null) {
                JSONUtils jSONUtils = JSONUtils.INSTANCE;
                JSONObject tagsToAdd = tags.getTagsToAdd();
                k.b(tagsToAdd);
                this._userManager.addTags(jSONUtils.newStringMapFromJSONObject(tagsToAdd));
            }
            if ((tags != null ? tags.getTagsToRemove() : null) != null) {
                JSONUtils jSONUtils2 = JSONUtils.INSTANCE;
                JSONArray tagsToRemove = tags != null ? tags.getTagsToRemove() : null;
                k.b(tagsToRemove);
                this._userManager.removeTags(jSONUtils2.newStringSetFromJSONArray(tagsToRemove));
            }
        }
    }

    private final boolean hasMessageTriggerChanged(InAppMessage inAppMessage) {
        if (this._triggerController.messageHasOnlyDynamicTriggers(inAppMessage)) {
            return !inAppMessage.isDisplayedInSession();
        }
        return inAppMessage.isTriggerChanged() || (!inAppMessage.isDisplayedInSession() && inAppMessage.getTriggers().isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logInAppMessagePreviewActions(InAppMessageClickResult inAppMessageClickResult) {
        if (inAppMessageClickResult.getTags() != null) {
            Logging.debug$default("InAppMessagesManager.logInAppMessagePreviewActions: Tags detected inside of the action click payload, ignoring because action came from IAM preview:: " + inAppMessageClickResult.getTags(), null, 2, null);
        }
        if (inAppMessageClickResult.getOutcomes().size() > 0) {
            Logging.debug$default("InAppMessagesManager.logInAppMessagePreviewActions: Outcomes detected inside of the action click payload, ignoring because action came from IAM preview: " + inAppMessageClickResult.getOutcomes(), null, 2, null);
        }
    }

    private final void makeRedisplayMessagesAvailableWithTriggers(Collection<String> collection, boolean z2) {
        synchronized (this.messages) {
            for (InAppMessage inAppMessage : this.messages) {
                boolean zContains = this.redisplayedInAppMessages.contains(inAppMessage);
                boolean zIsTriggerOnMessage = this._triggerController.isTriggerOnMessage(inAppMessage, collection);
                boolean zMessageHasOnlyDynamicTriggers = this._triggerController.messageHasOnlyDynamicTriggers(inAppMessage);
                if (!inAppMessage.isTriggerChanged() && zContains && (zIsTriggerOnMessage || (z2 && zMessageHasOnlyDynamicTriggers))) {
                    Logging.debug$default("InAppMessagesManager.makeRedisplayMessagesAvailableWithTriggers: Trigger changed for message: " + inAppMessage, null, 2, null);
                    inAppMessage.setTriggerChanged(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        if (persistInAppMessage(r11, r0) == r1) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object messageWasDismissed(com.onesignal.inAppMessages.internal.InAppMessage r11, boolean r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.messageWasDismissed(com.onesignal.inAppMessages.internal.InAppMessage, boolean, v5.c):java.lang.Object");
    }

    public static /* synthetic */ Object messageWasDismissed$default(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, boolean z2, v5.c cVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return inAppMessagesManager.messageWasDismissed(inAppMessage, z2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object persistInAppMessage(com.onesignal.inAppMessages.internal.InAppMessage r9, v5.c<? super q5.x> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.C27211
            if (r0 == 0) goto L13
            r0 = r10
            com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1 r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.C27211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1 r0 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$persistInAppMessage$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r9 = r0.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r9 = (com.onesignal.inAppMessages.internal.InAppMessage) r9
            java.lang.Object r0 = r0.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r0 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r0
            r2.q.z0(r10)
            goto L69
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            r2.q.z0(r10)
            com.onesignal.core.internal.time.ITime r10 = r8._time
            long r4 = r10.getCurrentTimeMillis()
            r10 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r10
            long r4 = r4 / r6
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r10 = r9.getRedisplayStats()
            r10.setLastDisplayTime(r4)
            com.onesignal.inAppMessages.internal.InAppMessageRedisplayStats r10 = r9.getRedisplayStats()
            r10.incrementDisplayQuantity()
            r10 = 0
            r9.setTriggerChanged(r10)
            r9.setDisplayedInSession(r3)
            com.onesignal.inAppMessages.internal.repositories.IInAppRepository r10 = r8._repository
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r10 = r10.saveInAppMessage(r9, r0)
            if (r10 != r1) goto L68
            return r1
        L68:
            r0 = r8
        L69:
            com.onesignal.inAppMessages.internal.preferences.IInAppPreferencesController r10 = r0._prefs
            com.onesignal.inAppMessages.internal.state.InAppStateService r1 = r0._state
            java.lang.Long r1 = r1.getLastTimeInAppDismissed()
            r10.setLastTimeInAppDismissed(r1)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r0.redisplayedInAppMessages
            int r10 = r10.indexOf(r9)
            r1 = -1
            if (r10 == r1) goto L83
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r1 = r0.redisplayedInAppMessages
            r1.set(r10, r9)
            goto L88
        L83:
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r10 = r0.redisplayedInAppMessages
            r10.add(r9)
        L88:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r1 = "InAppMessagesManager.persistInAppMessage: "
            r10.<init>(r1)
            r10.append(r9)
            java.lang.String r9 = " with msg array data: "
            r10.append(r9)
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r9 = r0.redisplayedInAppMessages
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r10 = 2
            r0 = 0
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r0, r10, r0)
            q5.x r9 = q5.x.f13520a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.persistInAppMessage(com.onesignal.inAppMessages.internal.InAppMessage, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a8, code lost:
    
        if (r4.attemptToShowInAppMessage(r1) == r2) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object queueMessageForDisplay(com.onesignal.inAppMessages.internal.InAppMessage r9, v5.c<? super q5.x> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "InAppMessagesManager.queueMessageForDisplay: In app message with id: "
            boolean r1 = r10 instanceof com.onesignal.inAppMessages.internal.InAppMessagesManager.C27221
            if (r1 == 0) goto L15
            r1 = r10
            com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1 r1 = (com.onesignal.inAppMessages.internal.InAppMessagesManager.C27221) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1 r1 = new com.onesignal.inAppMessages.internal.InAppMessagesManager$queueMessageForDisplay$1
            r1.<init>(r10)
        L1a:
            java.lang.Object r10 = r1.result
            w5.a r2 = w5.a.f17774a
            int r3 = r1.label
            r4 = 1
            r5 = 2
            if (r3 == 0) goto L47
            if (r3 == r4) goto L35
            if (r3 != r5) goto L2d
            r2.q.z0(r10)
            goto Lab
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            java.lang.Object r9 = r1.L$2
            z6.a r9 = (z6.a) r9
            java.lang.Object r3 = r1.L$1
            com.onesignal.inAppMessages.internal.InAppMessage r3 = (com.onesignal.inAppMessages.internal.InAppMessage) r3
            java.lang.Object r4 = r1.L$0
            com.onesignal.inAppMessages.internal.InAppMessagesManager r4 = (com.onesignal.inAppMessages.internal.InAppMessagesManager) r4
            r2.q.z0(r10)
            r10 = r9
            r9 = r3
            goto L5e
        L47:
            r2.q.z0(r10)
            z6.a r10 = r8.messageDisplayQueueMutex
            r1.L$0 = r8
            r1.L$1 = r9
            r1.L$2 = r10
            r1.label = r4
            z6.c r10 = (z6.c) r10
            java.lang.Object r3 = r10.d(r1)
            if (r3 != r2) goto L5d
            goto Laa
        L5d:
            r4 = r8
        L5e:
            r3 = 0
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r6 = r4.messageDisplayQueue     // Catch: java.lang.Throwable -> L95
            boolean r6 = r6.contains(r9)     // Catch: java.lang.Throwable -> L95
            if (r6 != 0) goto L97
            com.onesignal.inAppMessages.internal.state.InAppStateService r6 = r4._state     // Catch: java.lang.Throwable -> L95
            java.lang.String r6 = r6.getInAppMessageIdShowing()     // Catch: java.lang.Throwable -> L95
            java.lang.String r7 = r9.getMessageId()     // Catch: java.lang.Throwable -> L95
            boolean r6 = kotlin.jvm.internal.k.a(r6, r7)     // Catch: java.lang.Throwable -> L95
            if (r6 != 0) goto L97
            java.util.List<com.onesignal.inAppMessages.internal.InAppMessage> r6 = r4.messageDisplayQueue     // Catch: java.lang.Throwable -> L95
            r6.add(r9)     // Catch: java.lang.Throwable -> L95
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L95
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L95
            java.lang.String r9 = r9.getMessageId()     // Catch: java.lang.Throwable -> L95
            r6.append(r9)     // Catch: java.lang.Throwable -> L95
            java.lang.String r9 = ", added to the queue"
            r6.append(r9)     // Catch: java.lang.Throwable -> L95
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L95
            com.onesignal.debug.internal.logging.Logging.debug$default(r9, r3, r5, r3)     // Catch: java.lang.Throwable -> L95
            goto L97
        L95:
            r9 = move-exception
            goto Lae
        L97:
            z6.c r10 = (z6.c) r10
            r10.f(r3)
            r1.L$0 = r3
            r1.L$1 = r3
            r1.L$2 = r3
            r1.label = r5
            java.lang.Object r9 = r4.attemptToShowInAppMessage(r1)
            if (r9 != r2) goto Lab
        Laa:
            return r2
        Lab:
            q5.x r9 = q5.x.f13520a
            return r9
        Lae:
            z6.c r10 = (z6.c) r10
            r10.f(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.queueMessageForDisplay(com.onesignal.inAppMessages.internal.InAppMessage, v5.c):java.lang.Object");
    }

    private final void setDataForRedisplay(InAppMessage inAppMessage) {
        boolean zContains = this.dismissedMessages.contains(inAppMessage.getMessageId());
        int iIndexOf = this.redisplayedInAppMessages.indexOf(inAppMessage);
        if (!zContains || iIndexOf == -1) {
            return;
        }
        InAppMessage inAppMessage2 = this.redisplayedInAppMessages.get(iIndexOf);
        inAppMessage.getRedisplayStats().setDisplayStats(inAppMessage2.getRedisplayStats());
        inAppMessage.setDisplayedInSession(inAppMessage2.isDisplayedInSession());
        boolean zHasMessageTriggerChanged = hasMessageTriggerChanged(inAppMessage);
        Logging.debug$default("InAppMessagesManager.setDataForRedisplay: " + inAppMessage + " triggerHasChanged: " + zHasMessageTriggerChanged, null, 2, null);
        if (zHasMessageTriggerChanged && inAppMessage.getRedisplayStats().isDelayTimeSatisfied() && inAppMessage.getRedisplayStats().shouldDisplayAgain()) {
            Logging.debug$default("InAppMessagesManager.setDataForRedisplay message available for redisplay: " + inAppMessage.getMessageId(), null, 2, null);
            this.dismissedMessages.remove(inAppMessage.getMessageId());
            this.impressionedMessages.remove(inAppMessage.getMessageId());
            this.viewedPageIds.clear();
            this._prefs.setViewPageImpressionedIds(this.viewedPageIds);
            inAppMessage.clearClickIds();
        }
    }

    private final void showAlertDialogMessage(final InAppMessage inAppMessage, final List<? extends InAppMessagePrompt> list) {
        String string = this._applicationService.getAppContext().getString(R.string.location_permission_missing_title);
        k.d(string, "_applicationService.appC…permission_missing_title)");
        String string2 = this._applicationService.getAppContext().getString(R.string.location_permission_missing_message);
        k.d(string2, "_applicationService.appC…rmission_missing_message)");
        new AlertDialog.Builder(this._applicationService.getCurrent()).setTitle(string).setMessage(string2).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.onesignal.inAppMessages.internal.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                InAppMessagesManager.m3145showAlertDialogMessage$lambda7(this.f10699a, inAppMessage, list, dialogInterface, i2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: showAlertDialogMessage$lambda-7, reason: not valid java name */
    public static final void m3145showAlertDialogMessage$lambda7(InAppMessagesManager this$0, InAppMessage inAppMessage, List prompts, DialogInterface dialogInterface, int i2) {
        k.e(this$0, "this$0");
        k.e(inAppMessage, "$inAppMessage");
        k.e(prompts, "$prompts");
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$showAlertDialogMessage$1$1(this$0, inAppMessage, prompts, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00b8 -> B:25:0x00bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showMultiplePrompts(com.onesignal.inAppMessages.internal.InAppMessage r21, java.util.List<? extends com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt> r22, v5.c<? super q5.x> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager.showMultiplePrompts(com.onesignal.inAppMessages.internal.InAppMessage, java.util.List, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addClickListener */
    public void mo3146addClickListener(IInAppMessageClickListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("InAppMessagesManager.addClickListener(listener: " + listener + ')', null, 2, null);
        this.messageClickCallback.subscribe(listener);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addLifecycleListener */
    public void mo3147addLifecycleListener(IInAppMessageLifecycleListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("InAppMessagesManager.addLifecycleListener(listener: " + listener + ')', null, 2, null);
        this.lifecycleCallback.subscribe(listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addTrigger */
    public void mo3148addTrigger(String key, String value) {
        k.e(key, "key");
        k.e(value, "value");
        Logging.debug$default("InAppMessagesManager.addTrigger(key: " + key + ", value: " + value + ')', null, 2, null);
        TriggerModel triggerModel = (TriggerModel) this._triggerModelStore.get(key);
        if (triggerModel != null) {
            triggerModel.setValue(value);
            return;
        }
        TriggerModel triggerModel2 = new TriggerModel();
        triggerModel2.setId(key);
        triggerModel2.setKey(key);
        triggerModel2.setValue(value);
        IModelStore.DefaultImpls.add$default(this._triggerModelStore, triggerModel2, null, 2, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: addTriggers */
    public void mo3149addTriggers(Map<String, String> triggers) {
        k.e(triggers, "triggers");
        Logging.debug$default("InAppMessagesManager.addTriggers(triggers: " + triggers + ')', null, 2, null);
        for (Map.Entry<String, String> entry : triggers.entrySet()) {
            mo3148addTrigger(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: clearTriggers */
    public void mo3150clearTriggers() {
        Logging.debug$default("InAppMessagesManager.clearTriggers()", null, 2, null);
        IModelStore.DefaultImpls.clear$default(this._triggerModelStore, null, 1, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() {
        return this._state.getPaused();
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageActionOccurredOnMessage(InAppMessage message, InAppMessageClickResult action) {
        k.e(message, "message");
        k.e(action, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27111(action, message, this, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageActionOccurredOnPreview(InAppMessage message, InAppMessageClickResult action) {
        k.e(message, "message");
        k.e(action, "action");
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27121(action, message, this, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessagePageChanged(InAppMessage message, InAppMessagePage page) {
        k.e(message, "message");
        k.e(page, "page");
        if (message.isPreview()) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27131(message, page, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWasDismissed(InAppMessage message) {
        k.e(message, "message");
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27141(message, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWasDisplayed(InAppMessage message) {
        k.e(message, "message");
        if (this.lifecycleCallback.getHasSubscribers()) {
            this.lifecycleCallback.fireOnMain(new C27151(message));
        } else {
            Logging.verbose$default("InAppMessagesManager.onMessageWasDisplayed: inAppMessageLifecycleHandler is null", null, 2, null);
        }
        if (message.isPreview() || this.impressionedMessages.contains(message.getMessageId())) {
            return;
        }
        this.impressionedMessages.add(message.getMessageId());
        String strVariantIdForMessage = InAppHelper.INSTANCE.variantIdForMessage(message, this._languageContext);
        if (strVariantIdForMessage == null) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27162(strVariantIdForMessage, message, null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWillDismiss(InAppMessage message) {
        k.e(message, "message");
        if (this.lifecycleCallback.getHasSubscribers()) {
            this.lifecycleCallback.fireOnMain(new C27171(message));
        } else {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDismiss: inAppMessageLifecycleHandler is null", null, 2, null);
        }
    }

    @Override // com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler
    public void onMessageWillDisplay(InAppMessage message) {
        k.e(message, "message");
        if (this.lifecycleCallback.getHasSubscribers()) {
            this.lifecycleCallback.fireOnMain(new C27181(message));
        } else {
            Logging.verbose$default("InAppMessagesManager.onMessageWillDisplay: inAppMessageLifecycleHandler is null", null, 2, null);
        }
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
        if (k.a(args.getProperty(), RemoteConfigConstants.RequestFieldKey.APP_ID)) {
            fetchMessagesWhenConditionIsMet();
        }
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        Iterator<InAppMessage> it = this.redisplayedInAppMessages.iterator();
        while (it.hasNext()) {
            it.next().setDisplayedInSession(false);
        }
        fetchMessagesWhenConditionIsMet();
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionAdded(ISubscription subscription) {
        k.e(subscription, "subscription");
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionChanged(ISubscription subscription, ModelChangedArgs args) {
        k.e(subscription, "subscription");
        k.e(args, "args");
        if ((subscription instanceof IPushSubscription) && k.a(args.getPath(), "id")) {
            fetchMessagesWhenConditionIsMet();
        }
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionRemoved(ISubscription subscription) {
        k.e(subscription, "subscription");
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerChanged(String newTriggerKey) {
        k.e(newTriggerKey, "newTriggerKey");
        Logging.debug$default("InAppMessagesManager.onTriggerChanged(newTriggerKey: " + newTriggerKey + ')', null, 2, null);
        makeRedisplayMessagesAvailableWithTriggers(q.j0(newTriggerKey), true);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27191(null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerCompleted(String triggerId) {
        k.e(triggerId, "triggerId");
        Logging.debug$default("InAppMessagesManager.onTriggerCompleted: called with triggerId: ".concat(triggerId), null, 2, null);
        new HashSet().add(triggerId);
    }

    @Override // com.onesignal.inAppMessages.internal.triggers.ITriggerHandler
    public void onTriggerConditionChanged(String triggerId) {
        k.e(triggerId, "triggerId");
        Logging.debug$default("InAppMessagesManager.onTriggerConditionChanged()", null, 2, null);
        makeRedisplayMessagesAvailableWithTriggers(q.j0(triggerId), false);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27201(null), 1, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeClickListener */
    public void mo3151removeClickListener(IInAppMessageClickListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("InAppMessagesManager.removeClickListener(listener: " + listener + ')', null, 2, null);
        this.messageClickCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeLifecycleListener */
    public void mo3152removeLifecycleListener(IInAppMessageLifecycleListener listener) {
        k.e(listener, "listener");
        Logging.debug$default("InAppMessagesManager.removeLifecycleListener(listener: " + listener + ')', null, 2, null);
        this.lifecycleCallback.unsubscribe(listener);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeTrigger */
    public void mo3153removeTrigger(String key) {
        k.e(key, "key");
        Logging.debug$default("InAppMessagesManager.removeTrigger(key: " + key + ')', null, 2, null);
        IModelStore.DefaultImpls.remove$default(this._triggerModelStore, key, null, 2, null);
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    /* JADX INFO: renamed from: removeTriggers */
    public void mo3154removeTriggers(Collection<String> keys) {
        k.e(keys, "keys");
        Logging.debug$default("InAppMessagesManager.removeTriggers(keys: " + keys + ')', null, 2, null);
        Iterator<T> it = keys.iterator();
        while (it.hasNext()) {
            mo3153removeTrigger((String) it.next());
        }
    }

    @Override // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z2) {
        Logging.debug$default("InAppMessagesManager.setPaused(value: " + z2 + ')', null, 2, null);
        this._state.setPaused(z2);
        if (z2 && this._state.getInAppMessageIdShowing() != null) {
            x6.e eVar = m0.f13566a;
            c0.u(z0.f13606a, n.f17641a, new InAppMessagesManager$paused$1(this, null), 2);
        }
        if (z2) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessagesManager$paused$2(this, null), 1, null);
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        Set<String> dismissedMessagesId = this._prefs.getDismissedMessagesId();
        if (dismissedMessagesId != null) {
            this.dismissedMessages.addAll(dismissedMessagesId);
        }
        Long lastTimeInAppDismissed = this._prefs.getLastTimeInAppDismissed();
        if (lastTimeInAppDismissed != null) {
            this._state.setLastTimeInAppDismissed(lastTimeInAppDismissed);
        }
        this._subscriptionManager.subscribe(this);
        this._configModelStore.subscribe((ISingletonModelStoreChangeHandler) this);
        this._lifecycle.subscribe(this);
        this._triggerController.subscribe(this);
        this._sessionService.subscribe(this);
        this._applicationService.addApplicationLifecycleHandler(this);
        this._identityModelStore.subscribe((ISingletonModelStoreChangeHandler) this.identityModelChangeHandler);
        ThreadUtilsKt.suspendifyOnThread$default(0, new C27241(null), 1, null);
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(ConfigModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        fetchMessagesWhenConditionIsMet();
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onUnfocused() {
    }

    @Override // com.onesignal.core.internal.application.IApplicationLifecycleHandler
    public void onFocus(boolean z2) {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long j) {
    }
}
