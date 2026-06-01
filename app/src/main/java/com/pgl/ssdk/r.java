package com.pgl.ssdk;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r {
    public static q a(RandomAccessFile randomAccessFile, long j, long j3) {
        return a(randomAccessFile.getChannel(), j, j3);
    }

    public static q a(FileChannel fileChannel, long j, long j3) {
        fileChannel.getClass();
        return new m(fileChannel, j, j3);
    }
}
