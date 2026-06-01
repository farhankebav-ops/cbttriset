package com.onesignal.common.modeling;

import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.Model;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class SingletonModelStore<TModel extends Model> implements ISingletonModelStore<TModel>, IModelStoreChangeHandler<TModel> {
    private final EventProducer<ISingletonModelStoreChangeHandler<TModel>> changeSubscription;
    private final Object replaceLock;
    private final String singletonId;
    private final ModelStore<TModel> store;

    /* JADX INFO: renamed from: com.onesignal.common.modeling.SingletonModelStore$onModelUpdated$1, reason: invalid class name */
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
            invoke((ISingletonModelStoreChangeHandler) obj);
            return x.f13520a;
        }

        public final void invoke(ISingletonModelStoreChangeHandler<TModel> it) {
            k.e(it, "it");
            it.onModelUpdated(this.$args, this.$tag);
        }
    }

    public SingletonModelStore(ModelStore<TModel> store) {
        k.e(store, "store");
        this.store = store;
        this.changeSubscription = new EventProducer<>();
        this.singletonId = "-singleton-";
        this.replaceLock = new Object();
        store.subscribe((IModelStoreChangeHandler) this);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.changeSubscription.getHasSubscribers();
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStore
    public TModel getModel() {
        synchronized (this) {
            TModel tmodel = (TModel) this.store.get(this.singletonId);
            if (tmodel != null) {
                return tmodel;
            }
            TModel tmodel2 = (TModel) IModelStore.DefaultImpls.create$default(this.store, null, 1, null);
            if (tmodel2 != null) {
                tmodel2.setId(this.singletonId);
                IModelStore.DefaultImpls.add$default(this.store, tmodel2, null, 2, null);
                return tmodel2;
            }
            throw new Exception("Unable to initialize model from store " + this.store);
        }
    }

    public final ModelStore<TModel> getStore() {
        return this.store;
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(TModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(TModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
        this.changeSubscription.fire(new AnonymousClass1(args, tag));
    }

    @Override // com.onesignal.common.modeling.ISingletonModelStore
    public void replace(TModel model, String tag) {
        k.e(model, "model");
        k.e(tag, "tag");
        synchronized (this.replaceLock) {
            Model model2 = getModel();
            model2.initializeFromModel(this.singletonId, model);
            this.store.persist();
            this.changeSubscription.fire(new SingletonModelStore$replace$1$1(model2, tag));
        }
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(ISingletonModelStoreChangeHandler<TModel> handler) {
        k.e(handler, "handler");
        this.changeSubscription.subscribe(handler);
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(ISingletonModelStoreChangeHandler<TModel> handler) {
        k.e(handler, "handler");
        this.changeSubscription.unsubscribe(handler);
    }
}
