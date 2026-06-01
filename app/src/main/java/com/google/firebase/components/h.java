package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class h implements Provider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5528a;

    public /* synthetic */ h(int i2) {
        this.f5528a = i2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.f5528a) {
            case 0:
                return OptionalProvider.lambda$static$1();
            default:
                return Collections.EMPTY_SET;
        }
    }
}
