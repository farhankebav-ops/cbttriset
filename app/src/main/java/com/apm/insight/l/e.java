package com.apm.insight.l;

import androidx.annotation.NonNull;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends PrintWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MessageDigest f4523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Charset f4524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4525c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {
        public boolean a(String str) {
            return true;
        }
    }

    public e(@NonNull OutputStream outputStream, MessageDigest messageDigest, a aVar) {
        super(outputStream);
        this.f4524b = null;
        this.f4523a = messageDigest;
        this.f4525c = aVar;
        if (messageDigest != null) {
            this.f4524b = Charset.defaultCharset();
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(@NonNull char[] cArr, int i2, int i8) {
        super.write(cArr, i2, i8);
        MessageDigest messageDigest = this.f4523a;
        if (messageDigest != null) {
            messageDigest.update(this.f4524b.encode(CharBuffer.wrap(cArr)).array());
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(int i2) {
        super.write(i2);
        MessageDigest messageDigest = this.f4523a;
        if (messageDigest != null) {
            messageDigest.update((byte) i2);
        }
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public final void write(@NonNull String str, int i2, int i8) {
        super.write(str, i2, i8);
        if (this.f4523a != null) {
            a aVar = this.f4525c;
            if (aVar == null || aVar.a(str)) {
                this.f4523a.update(this.f4524b.encode(CharBuffer.wrap(str, i2, i8 + i2)).array());
            }
        }
    }
}
