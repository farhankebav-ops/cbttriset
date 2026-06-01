package com.unity3d.services.core.network.domain;

import c6.g;
import c6.i;
import c6.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import m6.f;
import n7.b;
import r2.q;
import r5.l;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CleanupDirectory {
    /* JADX WARN: Type inference failed for: r15v2, types: [com.unity3d.services.core.network.domain.CleanupDirectory$invoke$$inlined$sortedBy$1] */
    public final void invoke(File directory, int i2, long j) {
        k.e(directory, "directory");
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException(("Directory does not exist or is not a directory: " + directory).toString());
        }
        j jVar = j.f4234a;
        f fVarH0 = m6.k.H0(new i(directory), CleanupDirectory$invoke$cachedFiles$1.INSTANCE);
        g gVar = new g(fVarH0);
        long length = 0;
        long length2 = 0;
        while (gVar.hasNext()) {
            length2 += ((File) gVar.next()).length();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        g gVar2 = new g(fVarH0);
        while (gVar2.hasNext()) {
            Object next = gVar2.next();
            if (((File) next).lastModified() + j < jCurrentTimeMillis) {
                arrayList.add(next);
            } else {
                arrayList2.add(next);
            }
        }
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            length += ((File) obj).length();
        }
        long j3 = length2 - length;
        int size2 = arrayList.size();
        while (i8 < size2) {
            Object obj2 = arrayList.get(i8);
            i8++;
            ((File) obj2).delete();
        }
        long j8 = i2 * 1048576;
        if (j3 > j8) {
            i iVar = new i(l.S0(arrayList2), (CleanupDirectory$invoke$$inlined$sortedBy$1) new Comparator() { // from class: com.unity3d.services.core.network.domain.CleanupDirectory$invoke$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t3, T t7) {
                    return b.j(Long.valueOf(((File) t3).lastModified()), Long.valueOf(((File) t7).lastModified()));
                }
            });
            q5.i iVar2 = new q5.i(Long.valueOf(j3), r.f13638a);
            CleanupDirectory$invoke$additionalFiles$2 operation = CleanupDirectory$invoke$additionalFiles$2.INSTANCE;
            k.e(operation, "operation");
            Object obj3 = null;
            m6.i iVarI0 = q.i0(new m6.l(iVar2, iVar, operation, null));
            while (true) {
                if (!iVarI0.hasNext()) {
                    break;
                }
                Object next2 = iVarI0.next();
                if (((Number) ((q5.i) next2).f13498a).longValue() <= j8) {
                    obj3 = next2;
                    break;
                }
            }
            q5.i iVar3 = (q5.i) obj3;
            List list = arrayList2;
            if (iVar3 != null) {
                List list2 = (List) iVar3.f13499b;
                list = arrayList2;
                if (list2 != null) {
                    list = list2;
                }
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((File) it.next()).delete();
            }
        }
    }
}
