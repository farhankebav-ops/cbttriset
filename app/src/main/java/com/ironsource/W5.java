package com.ironsource;

import androidx.lifecycle.ProcessLifecycleOwner;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class W5 implements I7 {
    @Override // com.ironsource.I7
    public boolean a() {
        try {
            ProcessLifecycleOwner.Companion.get();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
