package com.onesignal.session.internal.session;

import com.onesignal.common.modeling.Model;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import e6.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SessionModel extends Model {

    /* JADX INFO: renamed from: com.onesignal.session.internal.session.SessionModel$isValid$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements a {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // e6.a
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    public SessionModel() {
        super(null, null, 3, null);
    }

    public final long getActiveDuration() {
        return getLongProperty("activeDuration", SessionModel$activeDuration$2.INSTANCE);
    }

    public final long getFocusTime() {
        return getLongProperty("focusTime", SessionModel$focusTime$2.INSTANCE);
    }

    public final String getSessionId() {
        return Model.getStringProperty$default(this, JsonStorageKeyNames.SESSION_ID_KEY, null, 2, null);
    }

    public final long getStartTime() {
        return getLongProperty("startTime", SessionModel$startTime$2.INSTANCE);
    }

    public final boolean isValid() {
        return getBooleanProperty("isValid", AnonymousClass2.INSTANCE);
    }

    public final void setActiveDuration(long j) {
        Model.setLongProperty$default(this, "activeDuration", j, null, false, 12, null);
    }

    public final void setFocusTime(long j) {
        Model.setLongProperty$default(this, "focusTime", j, null, false, 12, null);
    }

    public final void setSessionId(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, JsonStorageKeyNames.SESSION_ID_KEY, value, null, false, 12, null);
    }

    public final void setStartTime(long j) {
        Model.setLongProperty$default(this, "startTime", j, null, false, 12, null);
    }

    public final void setValid(boolean z2) {
        Model.setBooleanProperty$default(this, "isValid", z2, null, false, 12, null);
    }
}
