package com.bykv.vk.openvk.preload.geckox.f.a;

import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public c(File file) {
        super(file);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.f.a.a
    public final InputStream a(File file, String str) throws IOException {
        File file2 = new File(file, a1.a.r(new StringBuilder("res"), File.separator, str));
        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            throw new IOException("file not found");
        }
        GeckoLogger.d("gecko-debug-tag", "NormalFileLoader, file:", file2.getAbsolutePath());
        return new FileInputStream(file2.getCanonicalFile());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.f.a.a
    public final boolean b(File file, String str) throws IOException {
        return new File(file, a1.a.r(new StringBuilder("res"), File.separator, str)).exists();
    }
}
