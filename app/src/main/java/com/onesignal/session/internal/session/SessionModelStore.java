package com.onesignal.session.internal.session;

import com.onesignal.common.modeling.SimpleModelStore;
import com.onesignal.common.modeling.SingletonModelStore;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.session.internal.outcomes.impl.OutcomeEventsTable;
import e6.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SessionModelStore extends SingletonModelStore<SessionModel> {

    /* JADX INFO: renamed from: com.onesignal.session.internal.session.SessionModelStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // e6.a
        public final SessionModel invoke() {
            return new SessionModel();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionModelStore(IPreferencesService prefs) {
        super(new SimpleModelStore(AnonymousClass1.INSTANCE, OutcomeEventsTable.COLUMN_NAME_SESSION, prefs));
        k.e(prefs, "prefs");
    }
}
