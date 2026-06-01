package com.onesignal.inAppMessages.internal.triggers;

import com.ironsource.C2300e4;
import com.onesignal.common.modeling.Model;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TriggerModel extends Model {
    public TriggerModel() {
        super(null, null, 3, null);
    }

    public final String getKey() {
        return getStringProperty(C2300e4.h.W, TriggerModel$key$2.INSTANCE);
    }

    public final Object getValue() {
        return getAnyProperty("value", TriggerModel$value$2.INSTANCE);
    }

    public final void setKey(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, C2300e4.h.W, value, null, false, 12, null);
    }

    public final void setValue(Object value) {
        k.e(value, "value");
        Model.setAnyProperty$default(this, "value", value, null, true, 4, null);
    }
}
