package com.onesignal.user.internal.identity;

import com.onesignal.common.modeling.MapModel;
import com.onesignal.common.modeling.Model;
import com.onesignal.user.internal.backend.IdentityConstants;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class IdentityModel extends MapModel<String> {
    public IdentityModel() {
        super(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.onesignal.common.modeling.MapModel, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof String) {
            return containsValue((String) obj);
        }
        return false;
    }

    @Override // com.onesignal.common.modeling.MapModel, java.util.Map
    public final /* bridge */ String get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public final String getExternalId() {
        return Model.getOptStringProperty$default(this, IdentityConstants.EXTERNAL_ID, null, 2, null);
    }

    public final String getOnesignalId() {
        return Model.getStringProperty$default(this, IdentityConstants.ONESIGNAL_ID, null, 2, null);
    }

    public final /* bridge */ String getOrDefault(Object obj, String str) {
        return !(obj instanceof String) ? str : getOrDefault((String) obj, str);
    }

    @Override // com.onesignal.common.modeling.MapModel, java.util.Map
    public final /* bridge */ String remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    public final void setExternalId(String str) {
        Model.setOptStringProperty$default(this, IdentityConstants.EXTERNAL_ID, str, null, false, 12, null);
    }

    public final void setOnesignalId(String value) {
        k.e(value, "value");
        Model.setStringProperty$default(this, IdentityConstants.ONESIGNAL_ID, value, null, false, 12, null);
    }

    public /* bridge */ boolean containsValue(String str) {
        return super.containsValue(str);
    }

    @Override // com.onesignal.common.modeling.MapModel
    public /* bridge */ String get(String str) {
        return (String) super.get(str);
    }

    public /* bridge */ String getOrDefault(String str, String str2) {
        return (String) super.getOrDefault((Object) str, str2);
    }

    @Override // com.onesignal.common.modeling.MapModel
    public /* bridge */ String remove(String str) {
        return (String) super.remove(str);
    }
}
