package com.onesignal.user.internal.subscriptions;

import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import e6.a;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SubscriptionModelStore extends SimpleModelStore<SubscriptionModel> {

    /* JADX INFO: renamed from: com.onesignal.user.internal.subscriptions.SubscriptionModelStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // e6.a
        public final SubscriptionModel invoke() {
            return new SubscriptionModel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionModelStore(IPreferencesService prefs) {
        super(AnonymousClass1.INSTANCE, "subscriptions", prefs);
        k.e(prefs, "prefs");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.onesignal.common.modeling.ModelStore, com.onesignal.common.modeling.IModelStore
    public void replaceAll(List<SubscriptionModel> models, String tag) {
        k.e(models, "models");
        k.e(tag, "tag");
        if (!tag.equals(ModelChangeTags.HYDRATE)) {
            super.replaceAll(models, tag);
            return;
        }
        synchronized (models) {
            try {
                Iterator<SubscriptionModel> it = models.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SubscriptionModel next = it.next();
                    if (next.getType() == SubscriptionType.PUSH) {
                        SubscriptionModel subscriptionModel = (SubscriptionModel) get(next.getId());
                        if (subscriptionModel != null) {
                            next.setSdk(subscriptionModel.getSdk());
                            next.setDeviceOS(subscriptionModel.getDeviceOS());
                            next.setCarrier(subscriptionModel.getCarrier());
                            next.setAppVersion(subscriptionModel.getAppVersion());
                            next.setStatus(subscriptionModel.getStatus());
                        }
                    }
                }
                super.replaceAll(models, tag);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
