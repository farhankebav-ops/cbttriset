package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcd implements SharedPreferences {
    private final Map zza = new HashMap();
    private final Set zzb = new HashSet();

    private final Object zzc(String str, Object obj) {
        Object obj2 = this.zza.get(str);
        return obj2 != null ? obj2 : obj;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return this.zza.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new zzcc(this, null);
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        return this.zza;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z2) {
        return ((Boolean) zzc(str, Boolean.valueOf(z2))).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f4) {
        return ((Float) zzc(str, Float.valueOf(f4))).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i2) {
        return ((Integer) zzc(str, Integer.valueOf(i2))).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        return ((Long) zzc(str, Long.valueOf(j))).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return (String) zzc(str, str2);
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        return (Set) zzc(str, set);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.zzb.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.zzb.remove(onSharedPreferenceChangeListener);
    }

    public final /* synthetic */ Map zza() {
        return this.zza;
    }

    public final /* synthetic */ Set zzb() {
        return this.zzb;
    }
}
