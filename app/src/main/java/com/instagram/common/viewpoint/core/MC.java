package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization("Exo does not declare this as public but we need to as Hero's CacheDataSink refers to this")
public final class MC extends BufferedOutputStream {
    public boolean A00;

    public MC(OutputStream outputStream) {
        super(outputStream);
    }

    public MC(OutputStream outputStream, int i2) {
        super(outputStream, i2);
    }

    public final void A00(OutputStream outputStream) {
        C3M.A08(this.A00);
        this.out = outputStream;
        this.count = 0;
        this.A00 = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.A00 = true;
        Throwable e = null;
        try {
            flush();
        } catch (Throwable th) {
            e = th;
        }
        try {
            this.out.close();
        } catch (Throwable thrown) {
            if (e == null) {
                e = thrown;
            }
        }
        if (e != null) {
            AbstractC04664a.A11(e);
            throw null;
        }
    }
}
