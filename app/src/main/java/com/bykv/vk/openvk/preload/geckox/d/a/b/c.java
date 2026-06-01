package com.bykv.vk.openvk.preload.geckox.d.a.b;

import android.net.Uri;
import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends com.bykv.vk.openvk.preload.b.d<Pair<Uri, UpdatePackage>, Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.geckox.b f4975d;
    private File e;

    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        super.a(objArr);
        this.f4975d = (com.bykv.vk.openvk.preload.geckox.b) objArr[0];
        this.e = (File) objArr[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bykv.vk.openvk.preload.b.d
    public Object a(com.bykv.vk.openvk.preload.b.b<Pair<com.bykv.vk.openvk.preload.geckox.buffer.a, UpdatePackage>> bVar, Pair<Uri, UpdatePackage> pair) throws Throwable {
        GeckoLogger.d("gecko-debug-tag", "start download patch single file, channel:", ((UpdatePackage) pair.second).getChannel());
        UpdatePackage updatePackage = (UpdatePackage) pair.second;
        String string = ((Uri) pair.first).toString();
        long length = updatePackage.getPatch().getLength();
        File file = this.e;
        StringBuilder sb = new StringBuilder();
        sb.append(updatePackage.getAccessKey());
        String str = File.separator;
        sb.append(str);
        sb.append(updatePackage.getChannel());
        sb.append(str);
        sb.append(updatePackage.getVersion());
        sb.append("--updating");
        File file2 = new File(file, sb.toString());
        file2.mkdirs();
        File file3 = new File(file2, "patch.tmp");
        this.f4975d.a();
        com.bykv.vk.openvk.preload.geckox.buffer.a aVarA = com.bykv.vk.openvk.preload.geckox.buffer.a.a.a(file3, length);
        try {
            this.f4975d.i().downloadFile(string, length, new BufferOutputStream(aVarA));
            try {
                return bVar.a(new Pair<>(aVarA, updatePackage));
            } finally {
                aVarA.e();
            }
        } catch (Throwable th) {
            aVarA.e();
            StringBuilder sbY = a1.a.y("download patch single file failed, url:", string, ", channel:");
            sbY.append(updatePackage.getChannel());
            sbY.append(", pkg id:");
            sbY.append(updatePackage.getPatch().getId());
            sbY.append(", caused by:");
            sbY.append(th.getMessage());
            throw new com.bykv.vk.openvk.preload.geckox.b.a(sbY.toString(), th);
        }
    }
}
