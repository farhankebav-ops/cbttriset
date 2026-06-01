package com.unity3d.services.store.core;

import com.unity3d.services.store.StoreWebViewEventSender;
import com.unity3d.services.store.WebViewStoreEventListener;
import com.unity3d.services.store.gpbl.listeners.StoreEventListener;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class StoreEventListenerFactory {
    private final StoreWebViewEventSender storeWebViewEventSender;

    public StoreEventListenerFactory(StoreWebViewEventSender storeWebViewEventSender) {
        k.e(storeWebViewEventSender, "storeWebViewEventSender");
        this.storeWebViewEventSender = storeWebViewEventSender;
    }

    public static /* synthetic */ StoreEventListener invoke$default(StoreEventListenerFactory storeEventListenerFactory, int i2, boolean z2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = -1;
        }
        if ((i8 & 2) != 0) {
            z2 = false;
        }
        return storeEventListenerFactory.invoke(i2, z2);
    }

    public final StoreEventListener invoke() {
        return invoke$default(this, 0, false, 3, null);
    }

    public final StoreEventListener invoke(int i2) {
        return invoke$default(this, i2, false, 2, null);
    }

    public final StoreEventListener invoke(int i2, boolean z2) {
        return new WebViewStoreEventListener(i2, this.storeWebViewEventSender, z2);
    }
}
