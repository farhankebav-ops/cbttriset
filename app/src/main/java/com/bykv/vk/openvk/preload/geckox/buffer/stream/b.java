package com.bykv.vk.openvk.preload.geckox.buffer.stream;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends OutputStream {
    public abstract void write(long j, int i2) throws IOException;

    public abstract void write(long j, byte[] bArr) throws IOException;

    public abstract void write(long j, byte[] bArr, int i2, int i8) throws IOException;
}
