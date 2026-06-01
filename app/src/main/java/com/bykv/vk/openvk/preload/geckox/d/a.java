package com.bykv.vk.openvk.preload.geckox.d;

import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class a extends com.bykv.vk.openvk.preload.b.a<UpdatePackage, UpdatePackage> {
    @Override // com.bykv.vk.openvk.preload.b.a
    public final /* synthetic */ String a(UpdatePackage updatePackage) {
        int packageType = updatePackage.getPackageType();
        if (packageType == 0) {
            return "branch_zip";
        }
        if (packageType == 1) {
            return "branch_single_file";
        }
        throw new RuntimeException("unknow file type: ".concat(String.valueOf(packageType)));
    }
}
