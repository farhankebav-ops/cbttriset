package com.onesignal.common.modeling;

import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.modeling.Model;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface IModelStore<TModel extends Model> extends IEventNotifier<IModelStoreChangeHandler<TModel>> {
    void add(int i2, TModel tmodel, String str);

    void add(TModel tmodel, String str);

    void clear(String str);

    TModel create(JSONObject jSONObject);

    TModel get(String str);

    Collection<TModel> list();

    void remove(String str, String str2);

    void replaceAll(List<? extends TModel> list, String str);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class DefaultImpls {
        public static /* synthetic */ void add$default(IModelStore iModelStore, Model model, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
            }
            if ((i2 & 2) != 0) {
                str = ModelChangeTags.NORMAL;
            }
            iModelStore.add(model, str);
        }

        public static /* synthetic */ void clear$default(IModelStore iModelStore, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clear");
            }
            if ((i2 & 1) != 0) {
                str = ModelChangeTags.NORMAL;
            }
            iModelStore.clear(str);
        }

        public static /* synthetic */ Model create$default(IModelStore iModelStore, JSONObject jSONObject, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
            if ((i2 & 1) != 0) {
                jSONObject = null;
            }
            return iModelStore.create(jSONObject);
        }

        public static /* synthetic */ void remove$default(IModelStore iModelStore, String str, String str2, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: remove");
            }
            if ((i2 & 2) != 0) {
                str2 = ModelChangeTags.NORMAL;
            }
            iModelStore.remove(str, str2);
        }

        public static /* synthetic */ void replaceAll$default(IModelStore iModelStore, List list, String str, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceAll");
            }
            if ((i2 & 2) != 0) {
                str = ModelChangeTags.NORMAL;
            }
            iModelStore.replaceAll(list, str);
        }

        public static /* synthetic */ void add$default(IModelStore iModelStore, int i2, Model model, String str, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: add");
            }
            if ((i8 & 4) != 0) {
                str = ModelChangeTags.NORMAL;
            }
            iModelStore.add(i2, model, str);
        }
    }
}
