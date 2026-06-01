package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzhwi;
import com.google.android.gms.internal.ads.zzhwo;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzhwi<MessageType extends zzhwo<MessageType, BuilderType>, BuilderType extends zzhwi<MessageType, BuilderType>> extends zzhuq<MessageType, BuilderType> {
    protected MessageType zza;
    private final MessageType zzb;

    public zzhwi(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzaX()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
    }

    private MessageType zza() {
        return (MessageType) this.zzb.zzbg();
    }

    private static <MessageType> void zzb(MessageType messagetype, MessageType messagetype2) {
        zzhyj.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    /* JADX INFO: renamed from: zzaE */
    public /* bridge */ /* synthetic */ zzhuq zzbd(zzhvn zzhvnVar, zzhvy zzhvyVar) throws IOException {
        zzbr(zzhvnVar, zzhvyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    /* JADX INFO: renamed from: zzaI */
    public /* bridge */ /* synthetic */ zzhuq zzaZ(byte[] bArr, int i2, int i8) throws zzhxd {
        zzbq(bArr, i2, i8);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    /* JADX INFO: renamed from: zzaK */
    public /* bridge */ /* synthetic */ zzhuq zzaX(byte[] bArr, int i2, int i8, zzhvy zzhvyVar) throws zzhxd {
        zzbp(bArr, i2, i8, zzhvyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    public /* bridge */ /* synthetic */ zzhuq zzaQ(zzhur zzhurVar) {
        zzbn((zzhwo) zzhurVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    public /* bridge */ /* synthetic */ zzhxy zzaX(byte[] bArr, int i2, int i8, zzhvy zzhvyVar) throws zzhxd {
        zzbp(bArr, i2, i8, zzhvyVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    public /* bridge */ /* synthetic */ zzhxy zzaZ(byte[] bArr, int i2, int i8) throws zzhxd {
        zzbq(bArr, i2, i8);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    public /* bridge */ /* synthetic */ zzhxy zzbd(zzhvn zzhvnVar, zzhvy zzhvyVar) throws IOException {
        zzbr(zzhvnVar, zzhvyVar);
        return this;
    }

    public final void zzbg() {
        if (this.zza.zzaX()) {
            return;
        }
        zzbh();
    }

    public void zzbh() {
        MessageType messagetype = (MessageType) zza();
        zzb(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.ads.zzhya
    public final boolean zzbi() {
        return zzhwo.zzg(this.zza, false);
    }

    public final BuilderType zzbj() {
        if (this.zzb.zzaX()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = (MessageType) zza();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzhuq
    /* JADX INFO: renamed from: zzbk, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public BuilderType zzbf() {
        BuilderType buildertype = (BuilderType) zzbw().zzdd();
        buildertype.zza = (MessageType) zzbt();
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzhxy
    /* JADX INFO: renamed from: zzbl, reason: merged with bridge method [inline-methods] */
    public MessageType zzbt() {
        if (!this.zza.zzaX()) {
            return this.zza;
        }
        this.zza.zzbm();
        return this.zza;
    }

    /* JADX INFO: renamed from: zzbm, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbu() {
        MessageType messagetype = (MessageType) zzbt();
        if (messagetype.zzbi()) {
            return messagetype;
        }
        throw zzhuq.zzaR(messagetype);
    }

    public BuilderType zzbn(MessageType messagetype) {
        zzbo(messagetype);
        return this;
    }

    public BuilderType zzbo(MessageType messagetype) {
        if (zzbw().equals(messagetype)) {
            return this;
        }
        zzbg();
        zzb(this.zza, messagetype);
        return this;
    }

    public BuilderType zzbp(byte[] bArr, int i2, int i8, zzhvy zzhvyVar) throws zzhxd {
        zzbg();
        try {
            zzhyj.zza().zzb(this.zza.getClass()).zzj(this.zza, bArr, i2, i2 + i8, new zzhuw(zzhvyVar));
            return this;
        } catch (zzhxd e) {
            throw e;
        } catch (IOException e4) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e4);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public BuilderType zzbq(byte[] bArr, int i2, int i8) throws zzhxd {
        int i9 = zzhvy.zzb;
        int i10 = zzhuv.zza;
        zzbp(bArr, i2, i8, zzhvy.zza);
        return this;
    }

    public BuilderType zzbr(zzhvn zzhvnVar, zzhvy zzhvyVar) throws IOException {
        zzbg();
        try {
            zzhyj.zza().zzb(this.zza.getClass()).zzg(this.zza, zzhvo.zza(zzhvnVar), zzhvyVar);
            return this;
        } catch (RuntimeException e) {
            if (e.getCause() instanceof IOException) {
                throw ((IOException) e.getCause());
            }
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhya
    /* JADX INFO: renamed from: zzbs, reason: merged with bridge method [inline-methods] */
    public MessageType zzbw() {
        return this.zzb;
    }

    public /* bridge */ /* synthetic */ zzhxy zzbv() {
        zzbj();
        return this;
    }
}
