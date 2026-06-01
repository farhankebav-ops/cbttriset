package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DynamicTriggerController$dynamicTriggerShouldFire$1$2$run$1 extends l implements e6.l {
    final /* synthetic */ String $triggerId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicTriggerController$dynamicTriggerShouldFire$1$2$run$1(String str) {
        super(1);
        this.$triggerId = str;
    }

    @Override // e6.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ITriggerHandler) obj);
        return x.f13520a;
    }

    public final void invoke(ITriggerHandler it) {
        k.e(it, "it");
        it.onTriggerConditionChanged(this.$triggerId);
    }
}
