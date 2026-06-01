package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class V6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V9 f7730a;

    public V6(V9 globalDataWriter) {
        kotlin.jvm.internal.k.e(globalDataWriter, "globalDataWriter");
        this.f7730a = globalDataWriter;
    }

    public final void a(JSONObject metaDataJson) {
        kotlin.jvm.internal.k.e(metaDataJson, "metaDataJson");
        if (metaDataJson.has(com.ironsource.mediationsdk.metadata.a.f9242i)) {
            try {
                Object objRemove = metaDataJson.remove(com.ironsource.mediationsdk.metadata.a.f9242i);
                kotlin.jvm.internal.k.c(objRemove, "null cannot be cast to non-null type java.util.ArrayList<*>{ kotlin.collections.TypeAliasesKt.ArrayList<*> }");
                ArrayList arrayList = (ArrayList) objRemove;
                if (arrayList.isEmpty()) {
                    return;
                }
                Object obj = arrayList.get(0);
                kotlin.jvm.internal.k.c(obj, "null cannot be cast to non-null type kotlin.String");
                this.f7730a.e((String) obj);
            } catch (ClassCastException e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error("got the following error " + e.getMessage());
            }
        }
    }
}
