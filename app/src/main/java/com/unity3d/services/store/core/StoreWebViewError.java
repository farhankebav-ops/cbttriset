package com.unity3d.services.store.core;

import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Arrays;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class StoreWebViewError extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreWebViewError(Enum<?> r22, String str, Object... errorArguments) {
        super(r22, str, Arrays.copyOf(errorArguments, errorArguments.length));
        k.e(errorArguments, "errorArguments");
    }

    @Override // com.unity3d.scar.adapter.common.j
    public String getDomain() {
        return WebViewEventCategory.STORE.name();
    }
}
