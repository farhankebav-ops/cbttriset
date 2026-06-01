package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import a1.a;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcp;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcq;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzcq<MessageType extends zzcq<MessageType, BuilderType>, BuilderType extends zzcp<MessageType, BuilderType>> implements zzfm {
    protected int zza = 0;

    public int zzB(zzge zzgeVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm
    public final zzdf zzC() {
        try {
            int iZzF = zzF();
            zzdf zzdfVar = zzdf.zzb;
            byte[] bArr = new byte[iZzF];
            zzdk zzdkVar = new zzdk(bArr, 0, iZzF);
            zzab(zzdkVar);
            zzdkVar.zzC();
            return new zzde(bArr);
        } catch (IOException e) {
            throw new RuntimeException(a.m("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzD() {
        try {
            int iZzF = zzF();
            byte[] bArr = new byte[iZzF];
            zzdk zzdkVar = new zzdk(bArr, 0, iZzF);
            zzab(zzdkVar);
            zzdkVar.zzC();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(a.m("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
