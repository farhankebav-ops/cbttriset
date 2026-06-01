package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1155Vk {
    public static void A00(AbstractRunnableC1151Vg abstractRunnableC1151Vg) {
        new Handler(Looper.getMainLooper()).post(abstractRunnableC1151Vg);
    }
}
