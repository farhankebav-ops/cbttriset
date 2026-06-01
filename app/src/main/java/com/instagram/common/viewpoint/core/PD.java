package com.instagram.common.viewpoint.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class PD {
    public static int A00(boolean a8, boolean b8) {
        if (a8 == b8) {
            return 0;
        }
        return a8 ? 1 : -1;
    }
}
