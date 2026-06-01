package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.events.IEventNotifier;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import okhttp3.internal.url._UrlKt;
import org.json.JSONArray;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ModelStore<TModel extends Model> implements IEventNotifier<IModelStoreChangeHandler<TModel>>, IModelStore<TModel>, IModelChangedHandler {
    private final IPreferencesService _prefs;
    private final EventProducer<IModelStoreChangeHandler<TModel>> changeSubscription;
    private boolean hasLoadedFromCache;
    private final List<TModel> models;
    private final String name;

    /* JADX INFO: renamed from: com.onesignal.common.modeling.ModelStore$addItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 extends l implements e6.l {
        final /* synthetic */ TModel $model;
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TModel tmodel, String str) {
            super(1);
            this.$model = tmodel;
            this.$tag = str;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IModelStoreChangeHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IModelStoreChangeHandler<TModel> it) {
            k.e(it, "it");
            it.onModelAdded(this.$model, this.$tag);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.modeling.ModelStore$clear$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26822 extends l implements e6.l {
        final /* synthetic */ TModel $item;
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26822(TModel tmodel, String str) {
            super(1);
            this.$item = tmodel;
            this.$tag = str;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IModelStoreChangeHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IModelStoreChangeHandler<TModel> it) {
            k.e(it, "it");
            it.onModelRemoved(this.$item, this.$tag);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.modeling.ModelStore$onChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ ModelChangedArgs $args;
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelChangedArgs modelChangedArgs, String str) {
            super(1);
            this.$args = modelChangedArgs;
            this.$tag = str;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IModelStoreChangeHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IModelStoreChangeHandler<TModel> it) {
            k.e(it, "it");
            it.onModelUpdated(this.$args, this.$tag);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.modeling.ModelStore$removeItem$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class C26832 extends l implements e6.l {
        final /* synthetic */ TModel $model;
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26832(TModel tmodel, String str) {
            super(1);
            this.$model = tmodel;
            this.$tag = str;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((IModelStoreChangeHandler) obj);
            return x.f13520a;
        }

        public final void invoke(IModelStoreChangeHandler<TModel> it) {
            k.e(it, "it");
            it.onModelRemoved(this.$model, this.$tag);
        }
    }

    public ModelStore() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final void addItem(TModel tmodel, String str, Integer num) {
        synchronized (this.models) {
            try {
                if (num != null) {
                    this.models.add(num.intValue(), tmodel);
                } else {
                    this.models.add(tmodel);
                }
                tmodel.subscribe(this);
                persist();
            } catch (Throwable th) {
                throw th;
            }
        }
        this.changeSubscription.fire(new AnonymousClass2(tmodel, str));
    }

    public static /* synthetic */ void addItem$default(ModelStore modelStore, Model model, String str, Integer num, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItem");
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        modelStore.addItem(model, str, num);
    }

    private final void removeItem(TModel tmodel, String str) {
        synchronized (this.models) {
            this.models.remove(tmodel);
            tmodel.unsubscribe(this);
            persist();
        }
        this.changeSubscription.fire(new C26832(tmodel, str));
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public void add(TModel model, String tag) {
        Object next;
        k.e(model, "model");
        k.e(tag, "tag");
        synchronized (this.models) {
            try {
                Iterator<T> it = this.models.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (k.a(((Model) next).getId(), model.getId())) {
                            break;
                        }
                    }
                }
                Model model2 = (Model) next;
                if (model2 != null) {
                    removeItem(model2, tag);
                }
                addItem$default(this, model, tag, null, 4, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public void clear(String tag) {
        k.e(tag, "tag");
        List<Model> listN1 = r5.l.n1(this.models);
        synchronized (this.models) {
            this.models.clear();
            persist();
        }
        for (Model model : listN1) {
            model.unsubscribe((IModelChangedHandler) this);
            this.changeSubscription.fire(new C26822(model, tag));
        }
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public TModel get(String id) {
        Object next;
        k.e(id, "id");
        Iterator<T> it = this.models.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (k.a(((Model) next).getId(), id)) {
                break;
            }
        }
        return (TModel) next;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeSubscription.getHasSubscribers();
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public Collection<TModel> list() {
        List listN1;
        synchronized (this.models) {
            listN1 = r5.l.n1(this.models);
        }
        return listN1;
    }

    public final void load() {
        IPreferencesService iPreferencesService;
        if (this.name == null || (iPreferencesService = this._prefs) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray(iPreferencesService.getString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.MODEL_STORE_PREFIX + this.name, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI));
        synchronized (this.models) {
            try {
                boolean zIsEmpty = this.models.isEmpty();
                for (int length = jSONArray.length() - 1; -1 < length; length--) {
                    TModel tmodelCreate = create(jSONArray.getJSONObject(length));
                    if (tmodelCreate != null) {
                        List<TModel> list = this.models;
                        if (!(list != null) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                if (k.a(((Model) it.next()).getId(), tmodelCreate.getId())) {
                                    Logging.debug$default("ModelStore<" + this.name + ">: load - operation.id: " + tmodelCreate.getId() + " already exists in the store.", null, 2, null);
                                    break;
                                }
                            }
                        }
                        this.models.add(0, tmodelCreate);
                        tmodelCreate.subscribe(this);
                    }
                }
                this.hasLoadedFromCache = true;
                if (!zIsEmpty) {
                    persist();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.onesignal.common.modeling.IModelChangedHandler
    public void onChanged(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
        persist();
        this.changeSubscription.fire(new AnonymousClass1(args, tag));
    }

    public final void persist() {
        if (this.name == null || this._prefs == null || !this.hasLoadedFromCache) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        synchronized (this.models) {
            Iterator<TModel> it = this.models.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
        }
        this._prefs.saveString(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.MODEL_STORE_PREFIX + this.name, jSONArray.toString());
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public void remove(String id, String tag) {
        Object next;
        k.e(id, "id");
        k.e(tag, "tag");
        synchronized (this.models) {
            try {
                Iterator<T> it = this.models.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (k.a(((Model) next).getId(), id)) {
                            break;
                        }
                    }
                }
                Model model = (Model) next;
                if (model == null) {
                    return;
                }
                removeItem(model, tag);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public void replaceAll(List<? extends TModel> models, String tag) {
        k.e(models, "models");
        k.e(tag, "tag");
        synchronized (models) {
            clear(tag);
            Iterator<? extends TModel> it = models.iterator();
            while (it.hasNext()) {
                add(it.next(), tag);
            }
        }
    }

    public ModelStore(String str, IPreferencesService iPreferencesService) {
        this.name = str;
        this._prefs = iPreferencesService;
        this.changeSubscription = new EventProducer<>();
        this.models = new ArrayList();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(IModelStoreChangeHandler<TModel> handler) {
        k.e(handler, "handler");
        this.changeSubscription.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(IModelStoreChangeHandler<TModel> handler) {
        k.e(handler, "handler");
        this.changeSubscription.unsubscribe(handler);
    }

    public /* synthetic */ ModelStore(String str, IPreferencesService iPreferencesService, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : iPreferencesService);
    }

    @Override // com.onesignal.common.modeling.IModelStore
    public void add(int i2, TModel model, String tag) {
        Object next;
        k.e(model, "model");
        k.e(tag, "tag");
        synchronized (this.models) {
            try {
                Iterator<T> it = this.models.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (k.a(((Model) next).getId(), model.getId())) {
                            break;
                        }
                    }
                }
                Model model2 = (Model) next;
                if (model2 != null) {
                    removeItem(model2, tag);
                }
                addItem(model, tag, Integer.valueOf(i2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
