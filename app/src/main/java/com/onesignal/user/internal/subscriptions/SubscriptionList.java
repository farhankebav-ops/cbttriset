package com.onesignal.user.internal.subscriptions;

import com.onesignal.user.subscriptions.IEmailSubscription;
import com.onesignal.user.subscriptions.IPushSubscription;
import com.onesignal.user.subscriptions.ISmsSubscription;
import com.onesignal.user.subscriptions.ISubscription;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriptionList {
    private final IPushSubscription _fallbackPushSub;
    private final List<ISubscription> collection;

    /* JADX WARN: Multi-variable type inference failed */
    public SubscriptionList(List<? extends ISubscription> collection, IPushSubscription _fallbackPushSub) {
        k.e(collection, "collection");
        k.e(_fallbackPushSub, "_fallbackPushSub");
        this.collection = collection;
        this._fallbackPushSub = _fallbackPushSub;
    }

    public final IEmailSubscription getByEmail(String email) {
        Object next;
        k.e(email, "email");
        Iterator<T> it = getEmails().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (k.a(((IEmailSubscription) next).getEmail(), email)) {
                break;
            }
        }
        return (IEmailSubscription) next;
    }

    public final ISmsSubscription getBySMS(String sms) {
        Object next;
        k.e(sms, "sms");
        Iterator<T> it = getSmss().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (k.a(((ISmsSubscription) next).getNumber(), sms)) {
                break;
            }
        }
        return (ISmsSubscription) next;
    }

    public final List<ISubscription> getCollection() {
        return this.collection;
    }

    public final List<IEmailSubscription> getEmails() {
        List<ISubscription> list = this.collection;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof IEmailSubscription) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final IPushSubscription getPush() {
        List<ISubscription> list = this.collection;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof IPushSubscription) {
                arrayList.add(obj);
            }
        }
        IPushSubscription iPushSubscription = (IPushSubscription) l.Y0(arrayList);
        return iPushSubscription == null ? this._fallbackPushSub : iPushSubscription;
    }

    public final List<ISmsSubscription> getSmss() {
        List<ISubscription> list = this.collection;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ISmsSubscription) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
