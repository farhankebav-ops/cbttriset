package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzs extends LinkedHashMap {
    final /* synthetic */ zzv zza;

    public zzs(zzv zzvVar) {
        Objects.requireNonNull(zzvVar);
        this.zza = zzvVar;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        zzv zzvVar = this.zza;
        synchronized (zzvVar) {
            try {
                if (size() <= zzvVar.zzg()) {
                    return false;
                }
                zzvVar.zzh().add(new Pair((String) entry.getKey(), ((zzt) entry.getValue()).zzb));
                return size() > zzvVar.zzg();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
