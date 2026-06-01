package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4954d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4955f;
    public int g;

    public static com.bykv.vk.openvk.preload.geckox.buffer.a a(File file, long j) throws IOException {
        com.bykv.vk.openvk.preload.geckox.buffer.a aVarB = b(file, j);
        GeckoLogger.d("gecko-debug-tag", "buffer type:" + aVarB.getClass());
        return aVarB;
    }

    private static com.bykv.vk.openvk.preload.geckox.buffer.a b(File file, long j) throws IOException {
        if (j <= 0) {
            try {
                return new b(file);
            } catch (Exception e) {
                throw new IOException("create FileBuffer failed! file:" + file.getAbsolutePath() + " caused by:" + e.getMessage(), e);
            }
        }
        try {
            return new c(j, file);
        } catch (Exception e4) {
            throw new RuntimeException("create random access file failed! file:" + file.getAbsolutePath() + " caused by:" + e4.getMessage(), e4);
        }
    }
}
