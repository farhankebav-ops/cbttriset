package com.unity3d.ads.core.data.datasource;

import kotlin.jvm.internal.k;
import q5.j;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidFIdExistenceDataSource implements FIdExistenceDataSource {
    private final String className;

    public AndroidFIdExistenceDataSource(String className) {
        k.e(className, "className");
        this.className = className;
    }

    @Override // com.unity3d.ads.core.data.datasource.FIdExistenceDataSource
    public boolean invoke() {
        Object objM;
        try {
            objM = Class.forName(this.className);
        } catch (Throwable th) {
            objM = q.M(th);
        }
        return !(objM instanceof j);
    }
}
