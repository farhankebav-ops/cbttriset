package com.google.android.gms.internal.ads;

import com.ironsource.C2300e4;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzies implements Iterator, Closeable, zzarg {
    private static final zzarf zza = new zzier("eof ");
    protected zzarc zzb;
    protected zziet zzc;
    zzarf zzd = null;
    long zze = 0;
    long zzf = 0;
    private final List zzg = new ArrayList();

    static {
        zziez.zzb(zzies.class);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzarf zzarfVar = this.zzd;
        if (zzarfVar == zza) {
            return false;
        }
        if (zzarfVar != null) {
            return true;
        }
        try {
            this.zzd = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzd = zza;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(C2300e4.i.f8403d);
        int i2 = 0;
        while (true) {
            List list = this.zzg;
            if (i2 >= list.size()) {
                sb.append(C2300e4.i.e);
                return sb.toString();
            }
            if (i2 > 0) {
                sb.append(";");
            }
            sb.append(((zzarf) list.get(i2)).toString());
            i2++;
        }
    }

    public final List zzc() {
        return (this.zzc == null || this.zzd == zza) ? this.zzg : new zziey(this.zzg, this);
    }

    public final void zzd(zziet zzietVar, long j, zzarc zzarcVar) throws IOException {
        this.zzc = zzietVar;
        this.zze = zzietVar.zzc();
        zzietVar.zzd(zzietVar.zzc() + j);
        this.zzf = zzietVar.zzc();
        this.zzb = zzarcVar;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzarf next() {
        zzarf zzarfVarZzb;
        zzarf zzarfVar = this.zzd;
        if (zzarfVar != null && zzarfVar != zza) {
            this.zzd = null;
            return zzarfVar;
        }
        zziet zzietVar = this.zzc;
        if (zzietVar == null || this.zze >= this.zzf) {
            this.zzd = zza;
            throw new NoSuchElementException();
        }
        try {
            synchronized (zzietVar) {
                this.zzc.zzd(this.zze);
                zzarfVarZzb = this.zzb.zzb(this.zzc, this);
                this.zze = this.zzc.zzc();
            }
            return zzarfVarZzb;
        } catch (EOFException unused) {
            throw new NoSuchElementException();
        } catch (IOException unused2) {
            throw new NoSuchElementException();
        }
    }

    public void close() throws IOException {
    }
}
