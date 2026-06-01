package com.onesignal.common.modeling;

import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.modeling.Model;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ISingletonModelStore<TModel extends Model> extends IEventNotifier<ISingletonModelStoreChangeHandler<TModel>> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ void replace$default(ISingletonModelStore iSingletonModelStore, Model model, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replace");
            }
            if ((i2 & 2) != 0) {
                str = ModelChangeTags.NORMAL;
            }
            iSingletonModelStore.replace(model, str);
        }
    }

    TModel getModel();

    void replace(TModel tmodel, String str);
}
