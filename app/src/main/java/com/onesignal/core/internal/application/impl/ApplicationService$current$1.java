package com.onesignal.core.internal.application.impl;

import android.app.Activity;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ApplicationService$current$1 extends l implements e6.l {
    final /* synthetic */ Activity $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationService$current$1(Activity activity) {
        super(1);
        this.$value = activity;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IActivityLifecycleHandler) obj);
        return x.f13520a;
    }

    public final void invoke(IActivityLifecycleHandler it) {
        k.e(it, "it");
        it.onActivityAvailable(this.$value);
    }
}
