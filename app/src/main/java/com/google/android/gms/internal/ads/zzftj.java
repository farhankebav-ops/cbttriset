package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzftj {
    private static final Object zzf = new Object();
    private final Context zza;
    private final SharedPreferences zzb;
    private final String zzc;
    private final zzfsq zzd;
    private boolean zze;

    public zzftj(@NonNull Context context, @NonNull zzbaa zzbaaVar, @NonNull zzfsq zzfsqVar, boolean z2) {
        this.zze = false;
        this.zza = context;
        this.zzc = Integer.toString(zzbaaVar.zza());
        this.zzb = context.getSharedPreferences("pcvmspf", 0);
        this.zzd = zzfsqVar;
        this.zze = z2;
    }

    private final File zze(@NonNull String str) {
        return new File(new File(this.zza.getDir("pccache", 0), this.zzc), str);
    }

    private final String zzf() {
        return "FBAMTD".concat(String.valueOf(this.zzc));
    }

    private final String zzg() {
        return "LATMTD".concat(String.valueOf(this.zzc));
    }

    private static String zzh(@NonNull zzbac zzbacVar) {
        zzbah zzbahVarZzi = zzbai.zzi();
        zzbahVarZzi.zza(zzbacVar.zza().zza());
        zzbahVarZzi.zzb(zzbacVar.zza().zzb());
        zzbahVarZzi.zzd(zzbacVar.zza().zzd());
        zzbahVarZzi.zze(zzbacVar.zza().zze());
        zzbahVarZzi.zzc(zzbacVar.zza().zzc());
        return Hex.bytesToStringLowercase(((zzbai) zzbahVarZzi.zzbu()).zzaN());
    }

    private final void zzi(int i2, long j) {
        this.zzd.zza(i2, j);
    }

    private final void zzj(int i2, long j, String str) {
        this.zzd.zzb(i2, j, str);
    }

    @Nullable
    private final zzbai zzk(int i2) {
        String string = i2 == 1 ? this.zzb.getString(zzg(), null) : this.zzb.getString(zzf(), null);
        if (string == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzhvi zzhviVar = zzhvi.zzb;
            return zzbai.zzh(zzhvi.zzr(bArrStringToBytes, 0, bArrStringToBytes.length), this.zze ? zzhvy.zza() : zzhvy.zzb());
        } catch (zzhxd unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, jCurrentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, jCurrentTimeMillis);
            return null;
        }
    }

    public final boolean zza(@NonNull zzbac zzbacVar, @Nullable zzfti zzftiVar) {
        boolean z2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            try {
                zzbai zzbaiVarZzk = zzk(1);
                String strZza = zzbacVar.zza().zza();
                if (zzbaiVarZzk != null && zzbaiVarZzk.zza().equals(strZza)) {
                    zzi(4014, jCurrentTimeMillis);
                    return false;
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                File fileZze = zze(strZza);
                if (fileZze.exists()) {
                    String str = true != fileZze.isDirectory() ? "0" : "1";
                    String str2 = true != fileZze.isFile() ? "0" : "1";
                    z2 = false;
                    StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length());
                    sb.append("d:");
                    sb.append(str);
                    sb.append(",f:");
                    sb.append(str2);
                    zzj(4023, jCurrentTimeMillis2, sb.toString());
                    zzi(4015, jCurrentTimeMillis2);
                } else {
                    z2 = false;
                    if (!fileZze.mkdirs()) {
                        zzj(4024, jCurrentTimeMillis2, "cw:".concat(true != fileZze.canWrite() ? "0" : "1"));
                        zzi(4015, jCurrentTimeMillis2);
                        return false;
                    }
                }
                File fileZze2 = zze(strZza);
                File file = new File(fileZze2, "pcam.jar");
                File file2 = new File(fileZze2, "pcbc");
                if (!zzftd.zzb(file, zzbacVar.zzb().zzv())) {
                    zzi(4016, jCurrentTimeMillis);
                    return z2;
                }
                if (!zzftd.zzb(file2, zzbacVar.zzc().zzv())) {
                    zzi(4017, jCurrentTimeMillis);
                    return z2;
                }
                if (zzftiVar != null && !zzftiVar.zza(file)) {
                    zzi(4018, jCurrentTimeMillis);
                    zzftd.zze(fileZze2);
                    return z2;
                }
                String strZzh = zzh(zzbacVar);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                SharedPreferences sharedPreferences = this.zzb;
                String string = sharedPreferences.getString(zzg(), null);
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(zzg(), strZzh);
                if (string != null) {
                    editorEdit.putString(zzf(), string);
                }
                if (!editorEdit.commit()) {
                    zzi(4019, jCurrentTimeMillis3);
                    return z2;
                }
                HashSet hashSet = new HashSet();
                zzbai zzbaiVarZzk2 = zzk(1);
                if (zzbaiVarZzk2 != null) {
                    hashSet.add(zzbaiVarZzk2.zza());
                }
                zzbai zzbaiVarZzk3 = zzk(2);
                if (zzbaiVarZzk3 != null) {
                    hashSet.add(zzbaiVarZzk3.zza());
                }
                boolean z7 = z2;
                File[] fileArrListFiles = new File(this.zza.getDir("pccache", z7 ? 1 : 0), this.zzc).listFiles();
                int length = fileArrListFiles.length;
                for (int i2 = z7 ? 1 : 0; i2 < length; i2++) {
                    File file3 = fileArrListFiles[i2];
                    if (!hashSet.contains(file3.getName())) {
                        zzftd.zze(file3);
                    }
                }
                zzi(5014, jCurrentTimeMillis);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzb(@NonNull zzbac zzbacVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            try {
                if (!zzftd.zzb(new File(zze(zzbacVar.zza().zza()), "pcbc"), zzbacVar.zzc().zzv())) {
                    zzi(4020, jCurrentTimeMillis);
                    return false;
                }
                String strZzh = zzh(zzbacVar);
                SharedPreferences.Editor editorEdit = this.zzb.edit();
                editorEdit.putString(zzg(), strZzh);
                boolean zCommit = editorEdit.commit();
                if (zCommit) {
                    zzi(5015, jCurrentTimeMillis);
                } else {
                    zzi(4021, jCurrentTimeMillis);
                }
                return zCommit;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final zzftb zzc(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            try {
                zzbai zzbaiVarZzk = zzk(1);
                if (zzbaiVarZzk == null) {
                    zzi(4022, jCurrentTimeMillis);
                    return null;
                }
                File fileZze = zze(zzbaiVarZzk.zza());
                File file = new File(fileZze, "pcam.jar");
                if (!file.exists()) {
                    file = new File(fileZze, "pcam");
                }
                File file2 = new File(fileZze, "pcbc");
                File file3 = new File(fileZze, "pcopt");
                zzi(5016, jCurrentTimeMillis);
                return new zzftb(zzbaiVarZzk, file, file2, file3);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzd(int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (zzf) {
            try {
                zzbai zzbaiVarZzk = zzk(1);
                if (zzbaiVarZzk == null) {
                    zzi(4025, jCurrentTimeMillis);
                    return false;
                }
                File fileZze = zze(zzbaiVarZzk.zza());
                if (!new File(fileZze, "pcam.jar").exists()) {
                    zzi(4026, jCurrentTimeMillis);
                    return false;
                }
                if (new File(fileZze, "pcbc").exists()) {
                    zzi(5019, jCurrentTimeMillis);
                    return true;
                }
                zzi(4027, jCurrentTimeMillis);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
