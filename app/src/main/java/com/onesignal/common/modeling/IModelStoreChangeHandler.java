package com.onesignal.common.modeling;

import com.onesignal.common.modeling.Model;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IModelStoreChangeHandler<TModel extends Model> {
    void onModelAdded(TModel tmodel, String str);

    void onModelRemoved(TModel tmodel, String str);

    void onModelUpdated(ModelChangedArgs modelChangedArgs, String str);
}
