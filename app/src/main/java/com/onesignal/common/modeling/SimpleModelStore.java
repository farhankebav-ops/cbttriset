package com.onesignal.common.modeling;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.preferences.IPreferencesService;
import e6.a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SimpleModelStore<TModel extends Model> extends ModelStore<TModel> {
    private final a _create;

    public /* synthetic */ SimpleModelStore(a aVar, String str, IPreferencesService iPreferencesService, int i2, f fVar) {
        this(aVar, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : iPreferencesService);
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public TModel create(JSONObject jSONObject) {
        TModel tmodel = (TModel) this._create.invoke();
        if (jSONObject != null) {
            tmodel.initializeFromJson(jSONObject);
        }
        return tmodel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleModelStore(a _create, String str, IPreferencesService iPreferencesService) {
        super(str, iPreferencesService);
        k.e(_create, "_create");
        this._create = _create;
        load();
    }
}
