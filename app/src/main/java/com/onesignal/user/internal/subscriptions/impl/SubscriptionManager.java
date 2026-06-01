package com.onesignal.user.internal.subscriptions.impl;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.session.ISessionLifecycleHandler;
import com.onesignal.session.internal.session.ISessionService;
import com.onesignal.user.internal.EmailSubscription;
import com.onesignal.user.internal.PushSubscription;
import com.onesignal.user.internal.SmsSubscription;
import com.onesignal.user.internal.Subscription;
import com.onesignal.user.internal.UninitializedPushSubscription;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.IPushSubscriptionObserver;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import com.onesignal.user.subscriptions.PushSubscriptionChangedState;
import e2.s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriptionManager implements ISubscriptionManager, IModelStoreChangeHandler<SubscriptionModel>, ISessionLifecycleHandler {
    private final IApplicationService _applicationService;
    private final ISessionService _sessionService;
    private final SubscriptionModelStore _subscriptionModelStore;
    private final EventProducer<ISubscriptionChangedHandler> events;
    private SubscriptionList subscriptions;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubscriptionType.values().length];
            iArr[SubscriptionType.SMS.ordinal()] = 1;
            iArr[SubscriptionType.EMAIL.ordinal()] = 2;
            iArr[SubscriptionType.PUSH.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$createSubscriptionAndAddToSubscriptionList$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ ISubscription $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ISubscription iSubscription) {
            super(1);
            this.$subscription = iSubscription;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISubscriptionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISubscriptionChangedHandler it) {
            k.e(it, "it");
            it.onSubscriptionAdded(this.$subscription);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$onModelUpdated$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C28441 extends l implements e6.l {
        final /* synthetic */ ISubscription $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28441(ISubscription iSubscription) {
            super(1);
            this.$subscription = iSubscription;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IPushSubscriptionObserver) obj);
            return x.f13520a;
        }

        public final void invoke(IPushSubscriptionObserver it) {
            k.e(it, "it");
            it.onPushSubscriptionChange(new PushSubscriptionChangedState(((PushSubscription) this.$subscription).getSavedState(), ((PushSubscription) this.$subscription).refreshState()));
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$onModelUpdated$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        final /* synthetic */ ModelChangedArgs $args;
        final /* synthetic */ ISubscription $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ISubscription iSubscription, ModelChangedArgs modelChangedArgs) {
            super(1);
            this.$subscription = iSubscription;
            this.$args = modelChangedArgs;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISubscriptionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISubscriptionChangedHandler it) {
            k.e(it, "it");
            it.onSubscriptionChanged(this.$subscription, this.$args);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.user.internal.subscriptions.impl.SubscriptionManager$removeSubscriptionFromSubscriptionList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C28451 extends l implements e6.l {
        final /* synthetic */ ISubscription $subscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C28451(ISubscription iSubscription) {
            super(1);
            this.$subscription = iSubscription;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ISubscriptionChangedHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISubscriptionChangedHandler it) {
            k.e(it, "it");
            it.onSubscriptionRemoved(this.$subscription);
        }
    }

    public SubscriptionManager(IApplicationService _applicationService, ISessionService _sessionService, SubscriptionModelStore _subscriptionModelStore) {
        k.e(_applicationService, "_applicationService");
        k.e(_sessionService, "_sessionService");
        k.e(_subscriptionModelStore, "_subscriptionModelStore");
        this._applicationService = _applicationService;
        this._sessionService = _sessionService;
        this._subscriptionModelStore = _subscriptionModelStore;
        this.events = new EventProducer<>();
        this.subscriptions = new SubscriptionList(r.f13638a, new UninitializedPushSubscription());
        Iterator it = _subscriptionModelStore.list().iterator();
        while (it.hasNext()) {
            createSubscriptionAndAddToSubscriptionList((SubscriptionModel) it.next());
        }
        this._subscriptionModelStore.subscribe((IModelStoreChangeHandler) this);
        this._sessionService.subscribe(this);
    }

    private final void addSubscriptionToModels(SubscriptionType subscriptionType, String str, SubscriptionStatus subscriptionStatus) {
        Logging.log(LogLevel.DEBUG, "SubscriptionManager.addSubscription(type: " + subscriptionType + ", address: " + str + ')');
        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setId(IDManager.INSTANCE.createLocalId());
        subscriptionModel.setOptedIn(true);
        subscriptionModel.setType(subscriptionType);
        subscriptionModel.setAddress(str);
        if (subscriptionStatus == null) {
            subscriptionStatus = SubscriptionStatus.SUBSCRIBED;
        }
        subscriptionModel.setStatus(subscriptionStatus);
        IModelStore.DefaultImpls.add$default(this._subscriptionModelStore, subscriptionModel, null, 2, null);
    }

    public static /* synthetic */ void addSubscriptionToModels$default(SubscriptionManager subscriptionManager, SubscriptionType subscriptionType, String str, SubscriptionStatus subscriptionStatus, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            subscriptionStatus = null;
        }
        subscriptionManager.addSubscriptionToModels(subscriptionType, str, subscriptionStatus);
    }

    private final void createSubscriptionAndAddToSubscriptionList(SubscriptionModel subscriptionModel) {
        ISubscription iSubscriptionCreateSubscriptionFromModel = createSubscriptionFromModel(subscriptionModel);
        ArrayList arrayListO1 = r5.l.o1(getSubscriptions().getCollection());
        if (subscriptionModel.getType() == SubscriptionType.PUSH) {
            IPushSubscription push = getSubscriptions().getPush();
            k.c(push, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            PushSubscription pushSubscription = (PushSubscription) push;
            k.c(iSubscriptionCreateSubscriptionFromModel, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
            ((PushSubscription) iSubscriptionCreateSubscriptionFromModel).getChangeHandlersNotifier().subscribeAll(pushSubscription.getChangeHandlersNotifier());
            arrayListO1.remove(pushSubscription);
        }
        arrayListO1.add(iSubscriptionCreateSubscriptionFromModel);
        setSubscriptions(new SubscriptionList(arrayListO1, new UninitializedPushSubscription()));
        this.events.fire(new AnonymousClass1(iSubscriptionCreateSubscriptionFromModel));
    }

    private final ISubscription createSubscriptionFromModel(SubscriptionModel subscriptionModel) {
        int i2 = WhenMappings.$EnumSwitchMapping$0[subscriptionModel.getType().ordinal()];
        if (i2 == 1) {
            return new SmsSubscription(subscriptionModel);
        }
        if (i2 == 2) {
            return new EmailSubscription(subscriptionModel);
        }
        if (i2 == 3) {
            return new PushSubscription(subscriptionModel);
        }
        throw new s(3);
    }

    private final void refreshPushSubscriptionState() {
        ISubscription push = getSubscriptions().getPush();
        if (push instanceof UninitializedPushSubscription) {
            return;
        }
        k.c(push, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel model = ((Subscription) push).getModel();
        model.setSdk(OneSignalUtils.SDK_VERSION);
        String RELEASE = Build.VERSION.RELEASE;
        k.d(RELEASE, "RELEASE");
        model.setDeviceOS(RELEASE);
        String carrierName = DeviceUtils.INSTANCE.getCarrierName(this._applicationService.getAppContext());
        if (carrierName != null) {
            model.setCarrier(carrierName);
        }
        String appVersion = AndroidUtils.INSTANCE.getAppVersion(this._applicationService.getAppContext());
        if (appVersion != null) {
            model.setAppVersion(appVersion);
        }
    }

    private final void removeSubscriptionFromModels(ISubscription iSubscription) {
        Logging.log(LogLevel.DEBUG, "SubscriptionManager.removeSubscription(subscription: " + iSubscription + ')');
        IModelStore.DefaultImpls.remove$default(this._subscriptionModelStore, iSubscription.getId(), null, 2, null);
    }

    private final void removeSubscriptionFromSubscriptionList(ISubscription iSubscription) {
        ArrayList arrayListO1 = r5.l.o1(getSubscriptions().getCollection());
        arrayListO1.remove(iSubscription);
        setSubscriptions(new SubscriptionList(arrayListO1, new UninitializedPushSubscription()));
        this.events.fire(new C28451(iSubscription));
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addEmailSubscription(String email) {
        k.e(email, "email");
        addSubscriptionToModels$default(this, SubscriptionType.EMAIL, email, null, 4, null);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addOrUpdatePushSubscriptionToken(String str, SubscriptionStatus pushTokenStatus) {
        k.e(pushTokenStatus, "pushTokenStatus");
        ISubscription push = getSubscriptions().getPush();
        if (push instanceof UninitializedPushSubscription) {
            SubscriptionType subscriptionType = SubscriptionType.PUSH;
            if (str == null) {
                str = "";
            }
            addSubscriptionToModels(subscriptionType, str, pushTokenStatus);
            return;
        }
        k.c(push, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
        SubscriptionModel model = ((Subscription) push).getModel();
        if (str != null) {
            model.setAddress(str);
        }
        model.setStatus(pushTokenStatus);
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void addSmsSubscription(String sms) {
        k.e(sms, "sms");
        addSubscriptionToModels$default(this, SubscriptionType.SMS, sms, null, 4, null);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.events.getHasSubscribers();
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public SubscriptionModel getPushSubscriptionModel() {
        IPushSubscription push = getSubscriptions().getPush();
        k.c(push, "null cannot be cast to non-null type com.onesignal.user.internal.PushSubscription");
        return ((PushSubscription) push).getModel();
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public SubscriptionList getSubscriptions() {
        return this.subscriptions;
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        Object next;
        k.e(args, "args");
        k.e(tag, "tag");
        Iterator<T> it = getSubscriptions().getCollection().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ISubscription iSubscription = (ISubscription) next;
            Model model = args.getModel();
            k.c(iSubscription, "null cannot be cast to non-null type com.onesignal.user.internal.Subscription");
            if (k.a(model, ((Subscription) iSubscription).getModel())) {
                break;
            }
        }
        ISubscription iSubscription2 = (ISubscription) next;
        if (iSubscription2 == null) {
            Model model2 = args.getModel();
            k.c(model2, "null cannot be cast to non-null type com.onesignal.user.internal.subscriptions.SubscriptionModel");
            createSubscriptionAndAddToSubscriptionList((SubscriptionModel) model2);
        } else {
            if (iSubscription2 instanceof PushSubscription) {
                ((PushSubscription) iSubscription2).getChangeHandlersNotifier().fireOnMain(new C28441(iSubscription2));
            }
            this.events.fire(new AnonymousClass2(iSubscription2, args));
        }
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionStarted() {
        refreshPushSubscriptionState();
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void removeEmailSubscription(String email) {
        Object next;
        k.e(email, "email");
        Iterator<T> it = getSubscriptions().getEmails().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            IEmailSubscription iEmailSubscription = (IEmailSubscription) next;
            if ((iEmailSubscription instanceof EmailSubscription) && k.a(iEmailSubscription.getEmail(), email)) {
                break;
            }
        }
        IEmailSubscription iEmailSubscription2 = (IEmailSubscription) next;
        if (iEmailSubscription2 != null) {
            removeSubscriptionFromModels(iEmailSubscription2);
        }
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void removeSmsSubscription(String sms) {
        Object next;
        k.e(sms, "sms");
        Iterator<T> it = getSubscriptions().getSmss().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ISmsSubscription iSmsSubscription = (ISmsSubscription) next;
            if ((iSmsSubscription instanceof SmsSubscription) && k.a(iSmsSubscription.getNumber(), sms)) {
                break;
            }
        }
        ISmsSubscription iSmsSubscription2 = (ISmsSubscription) next;
        if (iSmsSubscription2 != null) {
            removeSubscriptionFromModels(iSmsSubscription2);
        }
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionManager
    public void setSubscriptions(SubscriptionList subscriptionList) {
        k.e(subscriptionList, "<set-?>");
        this.subscriptions = subscriptionList;
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(SubscriptionModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        createSubscriptionAndAddToSubscriptionList(model);
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(SubscriptionModel model, String tag) {
        Object next;
        k.e(model, "model");
        k.e(tag, "tag");
        if (model.getType() == SubscriptionType.PUSH) {
            return;
        }
        Iterator<T> it = getSubscriptions().getCollection().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (k.a(((ISubscription) next).getId(), model.getId())) {
                    break;
                }
            }
        }
        ISubscription iSubscription = (ISubscription) next;
        if (iSubscription != null) {
            removeSubscriptionFromSubscriptionList(iSubscription);
        }
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ISubscriptionChangedHandler handler) {
        k.e(handler, "handler");
        this.events.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ISubscriptionChangedHandler handler) {
        k.e(handler, "handler");
        this.events.unsubscribe(handler);
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionActive() {
    }

    @Override // com.onesignal.session.internal.session.ISessionLifecycleHandler
    public void onSessionEnded(long j) {
    }
}
