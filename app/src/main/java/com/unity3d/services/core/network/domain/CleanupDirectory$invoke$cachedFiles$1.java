package com.unity3d.services.core.network.domain;

import e6.l;
import java.io.File;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class CleanupDirectory$invoke$cachedFiles$1 extends j implements l {
    public static final CleanupDirectory$invoke$cachedFiles$1 INSTANCE = new CleanupDirectory$invoke$cachedFiles$1();

    public CleanupDirectory$invoke$cachedFiles$1() {
        super(1, File.class, "isFile", "isFile()Z", 0);
    }

    @Override // e6.l
    public final Boolean invoke(File p02) {
        k.e(p02, "p0");
        return Boolean.valueOf(p02.isFile());
    }
}
