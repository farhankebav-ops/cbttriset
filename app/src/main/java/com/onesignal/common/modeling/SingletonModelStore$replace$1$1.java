package com.onesignal.common.modeling;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class SingletonModelStore$replace$1$1 extends l implements e6.l {

    /* JADX INFO: Incorrect field signature: TTModel; */
    final /* synthetic */ Model $existingModel;
    final /* synthetic */ String $tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (TTModel;Ljava/lang/String;)V */
    public SingletonModelStore$replace$1$1(Model model, String str) {
        super(1);
        this.$existingModel = model;
        this.$tag = str;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ISingletonModelStoreChangeHandler) obj);
        return x.f13520a;
    }

    public final void invoke(ISingletonModelStoreChangeHandler<TModel> it) {
        k.e(it, "it");
        it.onModelReplaced(this.$existingModel, this.$tag);
    }
}
