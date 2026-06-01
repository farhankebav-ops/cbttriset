package com.onesignal.core.internal.operations.listeners;

import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangeTags;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IBootstrapService;
import java.io.Closeable;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ModelStoreListener<TModel extends Model> implements IModelStoreChangeHandler<TModel>, IBootstrapService, Closeable {
    private final IOperationRepo opRepo;
    private final IModelStore<TModel> store;

    public ModelStoreListener(IModelStore<TModel> store, IOperationRepo opRepo) {
        k.e(store, "store");
        k.e(opRepo, "opRepo");
        this.store = store;
        this.opRepo = opRepo;
    }

    @Override // com.onesignal.core.internal.startup.IBootstrapService
    public void bootstrap() {
        this.store.subscribe(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.store.unsubscribe(this);
    }

    public abstract Operation getAddOperation(TModel tmodel);

    public abstract Operation getRemoveOperation(TModel tmodel);

    public abstract Operation getUpdateOperation(TModel tmodel, String str, String str2, Object obj, Object obj2);

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(TModel model, String tag) {
        Operation addOperation;
        k.e(model, "model");
        k.e(tag, "tag");
        if (tag.equals(ModelChangeTags.NORMAL) && (addOperation = getAddOperation(model)) != null) {
            IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, addOperation, false, 2, null);
        }
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(TModel model, String tag) {
        Operation removeOperation;
        k.e(model, "model");
        k.e(tag, "tag");
        if (tag.equals(ModelChangeTags.NORMAL) && (removeOperation = getRemoveOperation(model)) != null) {
            IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, removeOperation, false, 2, null);
        }
    }

    @Override // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs args, String tag) {
        k.e(args, "args");
        k.e(tag, "tag");
        if (tag.equals(ModelChangeTags.NORMAL)) {
            Model model = args.getModel();
            k.c(model, "null cannot be cast to non-null type TModel of com.onesignal.core.internal.operations.listeners.ModelStoreListener");
            Operation updateOperation = getUpdateOperation(model, args.getPath(), args.getProperty(), args.getOldValue(), args.getNewValue());
            if (updateOperation != null) {
                IOperationRepo.DefaultImpls.enqueue$default(this.opRepo, updateOperation, false, 2, null);
            }
        }
    }
}
