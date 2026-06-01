package com.bykv.vk.openvk.preload.geckox.d;

import android.net.Uri;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.k;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class h extends k<UpdatePackage, Pair<Uri, UpdatePackage>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4987d = 0;

    @Override // com.bykv.vk.openvk.preload.b.k
    public final boolean a(Throwable th) {
        GeckoLogger.w("gecko-debug-tag", "patch update failed", th);
        if (this.f4987d >= g().getPatch().getUrlList().size()) {
            return false;
        }
        return (th instanceof com.bykv.vk.openvk.preload.geckox.b.a) || (th instanceof com.bykv.vk.openvk.preload.geckox.b.b);
    }

    @Override // com.bykv.vk.openvk.preload.b.k
    public final /* synthetic */ Pair<Uri, UpdatePackage> a() {
        UpdatePackage updatePackageG = g();
        List<String> urlList = updatePackageG.getPatch().getUrlList();
        int i2 = this.f4987d;
        this.f4987d = i2 + 1;
        return new Pair<>(Uri.parse(urlList.get(i2)), updatePackageG);
    }
}
