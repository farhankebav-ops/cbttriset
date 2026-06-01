package com.onesignal.core.internal.operations;

import com.onesignal.common.modeling.Model;
import java.util.Map;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Operation extends Model {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Operation(String name) {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        k.e(name, "name");
        setName(name);
    }

    private final void setName(String str) {
        Model.setStringProperty$default(this, "name", str, null, false, 12, null);
    }

    public abstract String getApplyToRecordId();

    public abstract boolean getCanStartExecute();

    public abstract String getCreateComparisonKey();

    public abstract GroupComparisonType getGroupComparisonType();

    public abstract String getModifyComparisonKey();

    public final String getName() {
        return Model.getStringProperty$default(this, "name", null, 2, null);
    }

    public String toString() {
        String string = toJSON().toString();
        k.d(string, "toJSON().toString()");
        return string;
    }

    public void translateIds(Map<String, String> map) {
        k.e(map, "map");
    }
}
