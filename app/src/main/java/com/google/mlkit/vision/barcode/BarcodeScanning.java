package com.google.mlkit.vision.barcode;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.internal.zzg;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class BarcodeScanning {
    private BarcodeScanning() {
    }

    @NonNull
    public static BarcodeScanner getClient() {
        return ((zzg) MlKitContext.getInstance().get(zzg.class)).zza();
    }

    @NonNull
    public static BarcodeScanner getClient(@NonNull BarcodeScannerOptions barcodeScannerOptions) {
        Preconditions.checkNotNull(barcodeScannerOptions, "You must provide a valid BarcodeScannerOptions.");
        return ((zzg) MlKitContext.getInstance().get(zzg.class)).zzb(barcodeScannerOptions);
    }
}
