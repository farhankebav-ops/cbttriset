package com.onesignal.internal;

import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.properties.PropertiesModel;
import e6.p;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OneSignalImp$login$1$1 extends l implements p {
    final /* synthetic */ String $externalId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneSignalImp$login$1$1(String str) {
        super(2);
        this.$externalId = str;
    }

    @Override // e6.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((IdentityModel) obj, (PropertiesModel) obj2);
        return x.f13520a;
    }

    public final void invoke(IdentityModel identityModel, PropertiesModel propertiesModel) {
        k.e(identityModel, "identityModel");
        k.e(propertiesModel, "<anonymous parameter 1>");
        identityModel.setExternalId(this.$externalId);
    }
}
