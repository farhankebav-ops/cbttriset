package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapq {
    public final int zza;
    public final byte[] zzb;

    @Nullable
    public final Map zzc;

    @Nullable
    public final List zzd;
    public final boolean zze;

    private zzapq(int i2, byte[] bArr, @Nullable Map map, @Nullable List list, boolean z2, long j) {
        this.zza = i2;
        this.zzb = bArr;
        this.zzc = map;
        this.zzd = list == null ? null : Collections.unmodifiableList(list);
        this.zze = z2;
    }

    @Nullable
    private static List zza(@Nullable Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new zzapm((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    @Deprecated
    public zzapq(int i2, byte[] bArr, @Nullable Map map, boolean z2, long j) {
        this(i2, bArr, map, zza(map), z2, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map] */
    public zzapq(int i2, byte[] bArr, boolean z2, long j, @Nullable List list) {
        ?? treeMap;
        if (list == null) {
            treeMap = 0;
        } else if (list.isEmpty()) {
            treeMap = Collections.EMPTY_MAP;
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzapm zzapmVar = (zzapm) it.next();
                treeMap.put(zzapmVar.zza(), zzapmVar.zzb());
            }
        }
        this(i2, bArr, treeMap, list, z2, j);
    }

    @Deprecated
    public zzapq(byte[] bArr, @Nullable Map map) {
        this(200, bArr, map, zza(map), false, 0L);
    }
}
