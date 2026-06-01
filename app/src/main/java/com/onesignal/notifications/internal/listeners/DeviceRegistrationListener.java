package com.onesignal.notifications.internal.listeners;

import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.notifications.internal.channels.INotificationChannelManager;
import com.onesignal.notifications.internal.pushtoken.IPushTokenManager;
import com.onesignal.notifications.internal.pushtoken.PushTokenResponse;
import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.subscriptions.ISubscription;
import e6.l;
import kotlin.jvm.internal.k;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeviceRegistrationListener implements IStartableService, ISingletonModelStoreChangeHandler<ConfigModel>, IPermissionObserver, ISubscriptionChangedHandler {
    private final INotificationChannelManager _channelManager;
    private final ConfigModelStore _configModelStore;
    private final INotificationsManager _notificationsManager;
    private final IPushTokenManager _pushTokenManager;
    private final ISubscriptionManager _subscriptionManager;

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.listeners.DeviceRegistrationListener$onSubscriptionChanged$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.listeners.DeviceRegistrationListener$onSubscriptionChanged$2", f = "DeviceRegistrationListener.kt", l = {92}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements l {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return DeviceRegistrationListener.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                INotificationsManager iNotificationsManager = DeviceRegistrationListener.this._notificationsManager;
                this.label = 1;
                if (iNotificationsManager.requestPermission(true, this) == aVar) {
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
            return ((AnonymousClass2) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.notifications.internal.listeners.DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.notifications.internal.listeners.DeviceRegistrationListener$retrievePushTokenAndUpdateSubscription$1", f = "DeviceRegistrationListener.kt", l = {71}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        int label;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(1, cVar);
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return DeviceRegistrationListener.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                IPushTokenManager iPushTokenManager = DeviceRegistrationListener.this._pushTokenManager;
                this.label = 1;
                obj = iPushTokenManager.retrievePushToken(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            PushTokenResponse pushTokenResponse = (PushTokenResponse) obj;
            DeviceRegistrationListener.this._subscriptionManager.addOrUpdatePushSubscriptionToken(pushTokenResponse.getToken(), DeviceRegistrationListener.this._notificationsManager.mo3168getPermission() ? pushTokenResponse.getStatus() : SubscriptionStatus.NO_PERMISSION);
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    public DeviceRegistrationListener(ConfigModelStore _configModelStore, INotificationChannelManager _channelManager, IPushTokenManager _pushTokenManager, INotificationsManager _notificationsManager, ISubscriptionManager _subscriptionManager) {
        k.e(_configModelStore, "_configModelStore");
        k.e(_channelManager, "_channelManager");
        k.e(_pushTokenManager, "_pushTokenManager");
        k.e(_notificationsManager, "_notificationsManager");
        k.e(_subscriptionManager, "_subscriptionManager");
        this._configModelStore = _configModelStore;
        this._channelManager = _channelManager;
        this._pushTokenManager = _pushTokenManager;
        this._notificationsManager = _notificationsManager;
        this._subscriptionManager = _subscriptionManager;
    }

    private final void retrievePushTokenAndUpdateSubscription() {
        this._subscriptionManager.getSubscriptions().getPush();
        ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass1(null), 1, null);
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
    }

    @Override // com.onesignal.notifications.IPermissionObserver
    public void onNotificationPermissionChange(boolean z2) {
        retrievePushTokenAndUpdateSubscription();
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionAdded(ISubscription subscription) {
        k.e(subscription, "subscription");
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionChanged(ISubscription subscription, ModelChangedArgs args) {
        k.e(subscription, "subscription");
        k.e(args, "args");
        if (k.a(args.getPath(), "optedIn") && k.a(args.getNewValue(), Boolean.TRUE) && !this._notificationsManager.mo3168getPermission()) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new AnonymousClass2(null), 1, null);
        }
    }

    @Override // com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler
    public void onSubscriptionRemoved(ISubscription subscription) {
        k.e(subscription, "subscription");
    }

    @Override // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._configModelStore.subscribe((ISingletonModelStoreChangeHandler) this);
        this._notificationsManager.mo3165addPermissionObserver(this);
        this._subscriptionManager.subscribe(this);
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(ConfigModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        if (tag.equals(ModelChangeTags.HYDRATE)) {
            this._channelManager.processChannelList(model.getNotificationChannels());
            retrievePushTokenAndUpdateSubscription();
        }
    }
}
