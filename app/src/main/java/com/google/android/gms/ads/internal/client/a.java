package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzhvt;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.gms.measurement.internal.zzic;
import com.google.firebase.encoders.FieldDescriptor;
import com.ironsource.D5;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static void A(int i2, FieldDescriptor.Builder builder) {
        com.google.android.gms.internal.mlkit_vision_barcode.zzfa zzfaVar = new com.google.android.gms.internal.mlkit_vision_barcode.zzfa();
        zzfaVar.zza(i2);
        builder.withProperty(zzfaVar.zzb()).build();
    }

    public static void B(zzic zzicVar, String str) {
        zzicVar.zzaV().zze().zza(str);
    }

    public static int C(int i2, int i8, int i9) {
        return com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn.zzA(i2) + i8 + i9;
    }

    public static FieldDescriptor D(int i2, FieldDescriptor.Builder builder) {
        com.google.android.gms.internal.mlkit_vision_common.zzae zzaeVar = new com.google.android.gms.internal.mlkit_vision_common.zzae();
        zzaeVar.zza(i2);
        return builder.withProperty(zzaeVar.zzb()).build();
    }

    public static int a(int i2, int i8) {
        return String.valueOf(i2).length() + i8;
    }

    public static int b(int i2, int i8, int i9) {
        return zzhvt.zzA(i2) + i8 + i9;
    }

    public static int c(int i2, int i8, int i9, int i10) {
        return ((i2 + i8) - i9) + i10;
    }

    public static /* synthetic */ int d(long j) {
        int i2 = (int) j;
        if (j == i2) {
            return i2;
        }
        throw new ArithmeticException();
    }

    public static IObjectWrapper e(Parcel parcel) {
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapperAsInterface;
    }

    public static FieldDescriptor.Builder f(int i2, FieldDescriptor.Builder builder, String str) {
        com.google.android.gms.internal.mlkit_common.zzay zzayVar = new com.google.android.gms.internal.mlkit_common.zzay();
        zzayVar.zza(i2);
        builder.withProperty(zzayVar.zzb()).build();
        return FieldDescriptor.builder(str);
    }

    public static FieldDescriptor g(int i2, FieldDescriptor.Builder builder) {
        com.google.android.gms.internal.mlkit_common.zzay zzayVar = new com.google.android.gms.internal.mlkit_common.zzay();
        zzayVar.zza(i2);
        return builder.withProperty(zzayVar.zzb()).build();
    }

    public static Object h(com.google.android.gms.internal.measurement.zzbk zzbkVar, int i2, List list, int i8) {
        com.google.android.gms.internal.measurement.zzh.zza(zzbkVar.name(), i2, list);
        return list.get(i8);
    }

    public static String i(StringBuilder sb, String str) {
        return str + ((Object) sb);
    }

    public static String j(StringBuilder sb, String str, int i2, String str2) {
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb.toString();
    }

    public static void k(int i2, int i8, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i8);
    }

    public static void l(int i2, FieldDescriptor.Builder builder) {
        com.google.android.gms.internal.mlkit_common.zzay zzayVar = new com.google.android.gms.internal.mlkit_common.zzay();
        zzayVar.zza(i2);
        builder.withProperty(zzayVar.zzb()).build();
    }

    public static void m(Bundle bundle, String str) {
        bundle.putLong(str, com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
    }

    public static void n(zzic zzicVar, String str) {
        zzicVar.zzaV().zzb().zza(str);
    }

    public static void o(D5 d52, Set set) {
        set.add(Integer.valueOf(d52.b()));
    }

    public static void p(String str, String str2, IronLog ironLog) {
        ironLog.verbose(str + str2);
    }

    public static void q(String str, String str2, String str3) {
        com.google.android.gms.internal.ads.zzdt.zzc(str3, str2.concat(String.valueOf(str)));
    }

    public static void r(String str, String str2, String str3, String str4, IronLog ironLog) {
        ironLog.verbose(str + str2 + str3 + str4);
    }

    public static void s(StringBuilder sb, String str, int i2, String str2) {
        sb.append(str);
        sb.append(i2);
        com.google.android.gms.internal.ads.zzdt.zzc(str2, sb.toString());
    }

    public static void t(StringBuilder sb, String str, IronLog ironLog) {
        sb.append(str);
        ironLog.verbose(sb.toString());
    }

    public static void u(StringBuilder sb, String str, String str2, IronLog ironLog) {
        sb.append(str);
        sb.append(str2);
        ironLog.verbose(sb.toString());
    }

    public static int v(int i2, int i8, int i9) {
        return zzlm.zzz(i2) + i8 + i9;
    }

    public static int w(int i2, int i8, int i9, int i10) {
        return ((i2 * i8) + i9) / i10;
    }

    public static FieldDescriptor.Builder x(int i2, FieldDescriptor.Builder builder, String str) {
        com.google.android.gms.internal.mlkit_vision_barcode.zzfa zzfaVar = new com.google.android.gms.internal.mlkit_vision_barcode.zzfa();
        zzfaVar.zza(i2);
        builder.withProperty(zzfaVar.zzb()).build();
        return FieldDescriptor.builder(str);
    }

    public static FieldDescriptor y(int i2, FieldDescriptor.Builder builder) {
        com.google.android.gms.internal.mlkit_vision_barcode.zzfa zzfaVar = new com.google.android.gms.internal.mlkit_vision_barcode.zzfa();
        zzfaVar.zza(i2);
        return builder.withProperty(zzfaVar.zzb()).build();
    }

    public static String z(StringBuilder sb, String str) {
        sb.append(str.intern());
        return sb.toString();
    }
}
