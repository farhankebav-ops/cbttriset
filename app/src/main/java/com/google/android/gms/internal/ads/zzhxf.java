package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhxf {
    public static final zzhxf zza;
    public static final zzhxf zzb;
    public static final zzhxf zzc;
    public static final zzhxf zzd;
    public static final zzhxf zze;
    public static final zzhxf zzf;
    public static final zzhxf zzg;
    public static final zzhxf zzh;
    public static final zzhxf zzi;
    public static final zzhxf zzj;
    private static final /* synthetic */ zzhxf[] zzl;
    private final Class zzk;

    static {
        zzhxf zzhxfVar = new zzhxf("VOID", 0, Void.class, Void.class, null);
        zza = zzhxfVar;
        Class cls = Integer.TYPE;
        zzhxf zzhxfVar2 = new zzhxf("INT", 1, cls, Integer.class, 0);
        zzb = zzhxfVar2;
        zzhxf zzhxfVar3 = new zzhxf("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzhxfVar3;
        zzhxf zzhxfVar4 = new zzhxf("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzhxfVar4;
        zzhxf zzhxfVar5 = new zzhxf("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzhxfVar5;
        zzhxf zzhxfVar6 = new zzhxf("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzhxfVar6;
        zzhxf zzhxfVar7 = new zzhxf("STRING", 6, String.class, String.class, "");
        zzg = zzhxfVar7;
        zzhxf zzhxfVar8 = new zzhxf("BYTE_STRING", 7, zzhvi.class, zzhvi.class, zzhvi.zzb);
        zzh = zzhxfVar8;
        zzhxf zzhxfVar9 = new zzhxf("ENUM", 8, cls, Integer.class, null);
        zzi = zzhxfVar9;
        zzhxf zzhxfVar10 = new zzhxf("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzhxfVar10;
        zzl = new zzhxf[]{zzhxfVar, zzhxfVar2, zzhxfVar3, zzhxfVar4, zzhxfVar5, zzhxfVar6, zzhxfVar7, zzhxfVar8, zzhxfVar9, zzhxfVar10};
    }

    private zzhxf(String str, int i2, Class cls, Class cls2, Object obj) {
        this.zzk = cls2;
    }

    public static zzhxf[] values() {
        return (zzhxf[]) zzl.clone();
    }

    public final Class zza() {
        return this.zzk;
    }
}
