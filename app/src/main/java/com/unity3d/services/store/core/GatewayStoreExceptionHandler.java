package com.unity3d.services.store.core;

import com.unity3d.services.store.StoreEvent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GatewayStoreExceptionHandler implements StoreExceptionHandler {
    @Override // com.unity3d.services.store.core.StoreExceptionHandler
    public void handleStoreException(StoreEvent storeEvent, int i2, Exception exception) throws Exception {
        k.e(storeEvent, "storeEvent");
        k.e(exception, "exception");
        throw exception;
    }
}
