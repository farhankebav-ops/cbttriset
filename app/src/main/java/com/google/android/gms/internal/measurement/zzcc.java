package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import f2.r;
import f2.s;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcc implements SharedPreferences.Editor {
    boolean zza;
    final Set zzb;
    final Map zzc;
    final /* synthetic */ zzcd zzd;

    public /* synthetic */ zzcc(zzcd zzcdVar, byte[] bArr) {
        Objects.requireNonNull(zzcdVar);
        this.zzd = zzcdVar;
        this.zza = false;
        this.zzb = new HashSet();
        this.zzc = new HashMap();
    }

    private final void zza(String str, Object obj) {
        if (obj != null) {
            this.zzc.put(str, obj);
        } else {
            remove(str);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.zza = true;
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        if (this.zza) {
            this.zzd.zza().clear();
        }
        zzcd zzcdVar = this.zzd;
        Set set = this.zzb;
        zzcdVar.zza().keySet().removeAll(set);
        Map map = this.zzc;
        for (Map.Entry entry : map.entrySet()) {
            zzcdVar.zza().put((String) entry.getKey(), entry.getValue());
        }
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : zzcdVar.zzb()) {
            Set setKeySet = map.keySet();
            q.D(set, "set1");
            q.D(setKeySet, "set2");
            new s(set, setKeySet);
            r rVar = new r(set, setKeySet);
            while (rVar.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(zzcdVar, (String) rVar.next());
            }
        }
        return (!this.zza && set.isEmpty() && map.isEmpty()) ? false : true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z2) {
        zza(str, Boolean.valueOf(z2));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f4) {
        zza(str, Float.valueOf(f4));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i2) {
        zza(str, Integer.valueOf(i2));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j) {
        zza(str, Long.valueOf(j));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        zza(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        zza(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        this.zzb.add(str);
        return this;
    }
}
