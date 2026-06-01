package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.modeling.SimpleModelStore;
import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class TriggerModelStore extends SimpleModelStore<TriggerModel> {

    /* JADX INFO: renamed from: com.onesignal.inAppMessages.internal.triggers.TriggerModelStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // e6.a
        public final TriggerModel invoke() {
            return new TriggerModel();
        }
    }

    public TriggerModelStore() {
        super(AnonymousClass1.INSTANCE, null, null, 6, null);
    }
}
