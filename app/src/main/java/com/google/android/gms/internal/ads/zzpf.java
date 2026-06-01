package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzpf extends AudioDeviceCallback {
    final /* synthetic */ zzpj zza;

    public /* synthetic */ zzpf(zzpj zzpjVar, byte[] bArr) {
        Objects.requireNonNull(zzpjVar);
        this.zza = zzpjVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpj zzpjVar = this.zza;
        zzpjVar.zzf(zzpe.zza(zzpjVar.zzg(), zzpjVar.zzj(), zzpjVar.zzh()));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        String str = zzep.zza;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            zzpj zzpjVar = this.zza;
            if (Objects.equals(audioDeviceInfoArr[i2], zzpjVar.zzh())) {
                zzpjVar.zzi(null);
                break;
            }
            i2++;
        }
        zzpj zzpjVar2 = this.zza;
        zzpjVar2.zzf(zzpe.zza(zzpjVar2.zzg(), zzpjVar2.zzj(), zzpjVar2.zzh()));
    }
}
