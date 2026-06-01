package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhua extends Writer {
    private final Appendable zza;
    private final zzhtz zzb = new zzhtz(null);

    public zzhua(Appendable appendable) {
        this.zza = appendable;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) throws IOException {
        this.zza.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(int i2) throws IOException {
        this.zza.append((char) i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence) throws IOException {
        append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i2, int i8) throws IOException {
        Objects.requireNonNull(str);
        this.zza.append(str, i2, i8 + i2);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i2, int i8) throws IOException {
        this.zza.append(charSequence, i2, i8);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final /* bridge */ /* synthetic */ Appendable append(CharSequence charSequence, int i2, int i8) throws IOException {
        append(charSequence, i2, i8);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i2, int i8) throws IOException {
        zzhtz zzhtzVar = this.zzb;
        zzhtzVar.zza(cArr);
        this.zza.append(zzhtzVar, i2, i8 + i2);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
