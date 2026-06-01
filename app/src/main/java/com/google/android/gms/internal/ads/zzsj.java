package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzsj implements zzsw {

    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzdf zzg;
    private boolean zzh;

    public zzsj(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzdf zzdfVar = new zzdf(zzdc.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdfVar;
        this.zzf = new AtomicReference();
    }

    private static zzsi zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new zzsi();
                }
                return (zzsi) arrayDeque.removeFirst();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private static int[] zzj(@Nullable int[] iArr, @Nullable int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    @Nullable
    private static byte[] zzk(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zza() {
        if (this.zzh) {
            return;
        }
        HandlerThread handlerThread = this.zzd;
        handlerThread.start();
        this.zze = new zzsh(this, handlerThread.getLooper());
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzb(int i2, int i8, int i9, long j, int i10) {
        zzg();
        zzsi zzsiVarZzi = zzi();
        zzsiVarZzi.zza(i2, 0, i9, j, i10);
        Handler handler = this.zze;
        String str = zzep.zza;
        handler.obtainMessage(1, zzsiVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzc(int i2, int i8, zzhe zzheVar, long j, int i9) {
        zzg();
        zzsi zzsiVarZzi = zzi();
        zzsiVarZzi.zza(i2, 0, 0, j, i9);
        MediaCodec.CryptoInfo cryptoInfo = zzsiVarZzi.zzd;
        cryptoInfo.numSubSamples = zzheVar.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzheVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzheVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzk = zzk(zzheVar.zzb, cryptoInfo.key);
        bArrZzk.getClass();
        cryptoInfo.key = bArrZzk;
        byte[] bArrZzk2 = zzk(zzheVar.zza, cryptoInfo.iv);
        bArrZzk2.getClass();
        cryptoInfo.iv = bArrZzk2;
        cryptoInfo.mode = zzheVar.zzc;
        if (Build.VERSION.SDK_INT >= 24) {
            y.s();
            cryptoInfo.setPattern(y.j(zzheVar.zzg, zzheVar.zzh));
        }
        Handler handler = this.zze;
        String str = zzep.zza;
        handler.obtainMessage(2, zzsiVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzd(Bundle bundle) {
        zzg();
        Handler handler = this.zze;
        String str = zzep.zza;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zze() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                zzdf zzdfVar = this.zzg;
                zzdfVar.zzb();
                Handler handler2 = this.zze;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(3).sendToTarget();
                zzdfVar.zzc();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzf() {
        if (this.zzh) {
            zze();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzsw
    public final void zzg() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    public final /* synthetic */ void zzh(Message message) {
        int i2 = message.what;
        zzsi zzsiVar = null;
        if (i2 == 1) {
            zzsi zzsiVar2 = (zzsi) message.obj;
            try {
                this.zzc.queueInputBuffer(zzsiVar2.zza, 0, zzsiVar2.zzc, zzsiVar2.zze, zzsiVar2.zzf);
            } catch (RuntimeException e) {
                AtomicReference atomicReference = this.zzf;
                while (!atomicReference.compareAndSet(null, e) && atomicReference.get() == null) {
                }
            }
            zzsiVar = zzsiVar2;
        } else if (i2 == 2) {
            zzsi zzsiVar3 = (zzsi) message.obj;
            int i8 = zzsiVar3.zza;
            MediaCodec.CryptoInfo cryptoInfo = zzsiVar3.zzd;
            long j = zzsiVar3.zze;
            int i9 = zzsiVar3.zzf;
            try {
                synchronized (zzb) {
                    this.zzc.queueSecureInputBuffer(i8, 0, cryptoInfo, j, i9);
                }
            } catch (RuntimeException e4) {
                AtomicReference atomicReference2 = this.zzf;
                while (!atomicReference2.compareAndSet(null, e4) && atomicReference2.get() == null) {
                }
            }
            zzsiVar = zzsiVar3;
        } else if (i2 == 3) {
            this.zzg.zza();
        } else if (i2 != 4) {
            AtomicReference atomicReference3 = this.zzf;
            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(message.what));
            while (!atomicReference3.compareAndSet(null, illegalStateException) && atomicReference3.get() == null) {
            }
        } else {
            try {
                this.zzc.setParameters((Bundle) message.obj);
            } catch (RuntimeException e8) {
                AtomicReference atomicReference4 = this.zzf;
                while (!atomicReference4.compareAndSet(null, e8) && atomicReference4.get() == null) {
                }
            }
        }
        if (zzsiVar != null) {
            ArrayDeque arrayDeque = zza;
            synchronized (arrayDeque) {
                arrayDeque.add(zzsiVar);
            }
        }
    }
}
