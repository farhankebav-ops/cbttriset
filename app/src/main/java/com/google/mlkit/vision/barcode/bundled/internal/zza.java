package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbe;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbm;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.MultiScaleDecodingOptions;
import com.google.android.libraries.barhopper.MultiScaleDetectionOptions;
import com.google.android.libraries.barhopper.RecognitionOptions;
import d2.b;
import d2.c;
import d2.d;
import d2.e;
import d2.f;
import d2.g;
import d2.h;
import d2.i;
import d2.j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import s2.a;
import s2.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zza extends zzbm {
    private static final int[] zza = {5, 7, 7, 7, 5, 5};
    private static final double[][] zzb = {new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, new double[]{0.5d, 1.0d}, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    private final Context zzc;
    private final zzba zzd;

    @Nullable
    private BarhopperV3 zze;

    public zza(Context context, zzba zzbaVar) {
        this.zzc = context;
        this.zzd = zzbaVar;
    }

    private final RecognitionOptions zzg() {
        RecognitionOptions recognitionOptions = new RecognitionOptions();
        recognitionOptions.a(this.zzd.zza());
        recognitionOptions.f(this.zzd.zzb());
        recognitionOptions.b();
        recognitionOptions.c();
        return recognitionOptions;
    }

    @Nullable
    private static zzan zzh(@Nullable m mVar, @Nullable String str, String str2) {
        if (mVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzan(mVar.d(), mVar.zzd(), mVar.a(), mVar.b(), mVar.zzc(), mVar.c(), mVar.f(), matcher.find() ? matcher.group(1) : null);
    }

    private final a zzi(ByteBuffer byteBuffer, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperV3 barhopperV3 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
        if (((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).isDirect()) {
            return barhopperV3.b(zzccVar.zzd(), zzccVar.zza(), byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.e(zzccVar.zzd(), zzccVar.zza(), byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.e(zzccVar.zzd(), zzccVar.zza(), bArr, recognitionOptions);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:506)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:509)
        */
    private final java.util.List zzj(com.google.android.gms.dynamic.IObjectWrapper r48, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc r49, com.google.android.libraries.barhopper.RecognitionOptions r50) {
        /*
            Method dump skipped, instruction units count: 1186
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.vision.barcode.bundled.internal.zza.zzj(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc, com.google.android.libraries.barhopper.RecognitionOptions):java.util.List");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzb(IObjectWrapper iObjectWrapper, zzcc zzccVar) {
        return zzj(iObjectWrapper, zzccVar, zzg());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final List zzc(IObjectWrapper iObjectWrapper, zzcc zzccVar, zzbc zzbcVar) {
        RecognitionOptions recognitionOptionsZzg = zzg();
        MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();
        multiScaleDecodingOptions.a(zzbcVar.zza().zzc());
        multiScaleDecodingOptions.b(zzbcVar.zza().zza());
        multiScaleDecodingOptions.c(zzbcVar.zza().zzb());
        recognitionOptionsZzg.d(multiScaleDecodingOptions);
        MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();
        multiScaleDetectionOptions.a(zzbcVar.zza().zzc());
        recognitionOptionsZzg.e(multiScaleDetectionOptions);
        recognitionOptionsZzg.g(zzbcVar.zzb());
        return zzj(iObjectWrapper, zzccVar, recognitionOptionsZzg);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzd() {
        if (this.zze != null) {
            return;
        }
        BarhopperV3 barhopperV3 = new BarhopperV3();
        System.loadLibrary("barhopper_v3");
        this.zze = barhopperV3;
        h hVarA = i.a();
        f fVarA = g.a();
        int i2 = 16;
        int i8 = 0;
        for (int i9 = 0; i9 < 6; i9++) {
            d dVarA = e.a();
            dVarA.c(i2);
            dVarA.d(i2);
            for (int i10 = 0; i10 < zza[i9]; i10++) {
                double[] dArr = zzb[i8];
                double d8 = dArr[0] * 320.0d;
                float fSqrt = (float) Math.sqrt(dArr[1]);
                float f4 = (float) d8;
                dVarA.a(f4 / fSqrt);
                dVarA.b(f4 * fSqrt);
                i8++;
            }
            i2 += i2;
            fVarA.a(dVarA);
        }
        hVarA.a(fVarA);
        try {
            InputStream inputStreamOpen = this.zzc.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream inputStreamOpen2 = this.zzc.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream inputStreamOpen3 = this.zzc.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV32 = (BarhopperV3) Preconditions.checkNotNull(this.zze);
                        j jVarA = d2.a.a();
                        hVarA.b(zzdf.zzs(inputStreamOpen));
                        jVarA.a(hVarA);
                        b bVarA = c.a();
                        bVarA.a(zzdf.zzs(inputStreamOpen2));
                        bVarA.b(zzdf.zzs(inputStreamOpen3));
                        jVarA.b(bVarA);
                        barhopperV32.a((d2.a) jVarA.zzj());
                        if (inputStreamOpen3 != null) {
                            inputStreamOpen3.close();
                        }
                        if (inputStreamOpen2 != null) {
                            inputStreamOpen2.close();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to open Barcode models", e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zze(zzbe zzbeVar) {
        zzd();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn
    public final void zzf() {
        BarhopperV3 barhopperV3 = this.zze;
        if (barhopperV3 != null) {
            barhopperV3.close();
            this.zze = null;
        }
    }
}
