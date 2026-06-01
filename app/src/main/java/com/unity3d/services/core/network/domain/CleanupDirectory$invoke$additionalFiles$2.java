package com.unity3d.services.core.network.domain;

import e6.p;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CleanupDirectory$invoke$additionalFiles$2 extends l implements p {
    public static final CleanupDirectory$invoke$additionalFiles$2 INSTANCE = new CleanupDirectory$invoke$additionalFiles$2();

    public CleanupDirectory$invoke$additionalFiles$2() {
        super(2);
    }

    @Override // e6.p
    public final i invoke(i iVar, File file) {
        k.e(iVar, "<name for destructuring parameter 0>");
        k.e(file, "file");
        return new i(Long.valueOf(((Number) iVar.f13498a).longValue() - file.length()), r5.l.g1((List) iVar.f13499b, file));
    }
}
