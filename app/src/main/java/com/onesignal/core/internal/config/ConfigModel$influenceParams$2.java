package com.onesignal.core.internal.config;

import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConfigModel$influenceParams$2 extends l implements a {
    final /* synthetic */ ConfigModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigModel$influenceParams$2(ConfigModel configModel) {
        super(0);
        this.this$0 = configModel;
    }

    @Override // e6.a
    public final Object invoke() {
        return new InfluenceConfigModel(this.this$0, "influenceParams");
    }
}
