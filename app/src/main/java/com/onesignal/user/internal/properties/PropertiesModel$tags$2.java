package com.onesignal.user.internal.properties;

import com.onesignal.common.modeling.MapModel;
import e6.a;
import kotlin.jvm.internal.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PropertiesModel$tags$2 extends l implements a {
    final /* synthetic */ PropertiesModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PropertiesModel$tags$2(PropertiesModel propertiesModel) {
        super(0);
        this.this$0 = propertiesModel;
    }

    @Override // e6.a
    public final MapModel<String> invoke() {
        return new MapModel<>(this.this$0, "tags");
    }
}
