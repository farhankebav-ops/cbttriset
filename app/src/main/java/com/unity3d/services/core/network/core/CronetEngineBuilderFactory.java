package com.unity3d.services.core.network.core;

import android.content.Context;
import kotlin.jvm.internal.k;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CronetEngineBuilderFactory {
    public final CronetEngine.Builder createCronetEngineBuilder(Context context) {
        k.e(context, "context");
        return new CronetEngine.Builder(context);
    }
}
