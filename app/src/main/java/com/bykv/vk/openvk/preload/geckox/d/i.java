package com.bykv.vk.openvk.preload.geckox.d;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class i extends com.bykv.vk.openvk.preload.b.d<Pair<String, Long>, Pair<String, Long>> {
    @Override // com.bykv.vk.openvk.preload.b.d
    public final /* synthetic */ Object a(com.bykv.vk.openvk.preload.b.b<Pair<String, Long>> bVar, Pair<String, Long> pair) throws Throwable {
        Pair<String, Long> pair2 = pair;
        GeckoLogger.d("gecko-debug-tag", "update success:", pair2);
        return bVar.a(pair2);
    }
}
