package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.df, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1497df extends InputStream {
    public int A00;
    public long A01;
    public InterfaceC2089nl A02;
    public final Uri A03;
    public final InterfaceC04884w A04;
    public final C1451cu A05;
    public final String A06;

    public C1497df(C1451cu c1451cu, Uri uri, InterfaceC04884w interfaceC04884w) throws IOException {
        this.A05 = c1451cu;
        this.A04 = interfaceC04884w;
        this.A03 = uri;
        this.A06 = C1536eJ.A09(this.A05, this.A03);
        A00(0);
    }

    private void A00(int i2) throws IOException {
        if (this.A02 != null) {
            this.A02.close();
        }
        this.A02 = this.A04.A5A();
        this.A01 = (int) this.A02.AFy(new AnonymousClass56(this.A03, i2, -1L, this.A06));
    }

    @Override // java.io.InputStream
    public final int available() {
        return ((int) this.A01) - this.A00;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b8 = new byte[1];
        return read(b8);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = this.A02.read(bArr, i2, i8);
        int read = this.A00;
        this.A00 = read + i9;
        return i9;
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        long j3 = this.A01 - ((long) this.A00);
        if (j3 <= 0) {
            return 0L;
        }
        if (j > j3) {
            j = j3;
        }
        this.A00 = (int) (((long) this.A00) + j);
        A00(this.A00);
        return j;
    }
}
