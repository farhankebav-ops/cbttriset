package com.ironsource;

import android.text.TextUtils;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.ironsource.c6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class CallableC2266c6 implements Callable<C2355h5> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f8112d = "FileWorkerThread";
    private static final String e = "X-Android-Protocols";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8113f = "http/1.1,h2";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2337g5 f8114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8116c;

    public CallableC2266c6(C2337g5 c2337g5, String str, long j) {
        this.f8114a = c2337g5;
        this.f8115b = str;
        this.f8116c = j;
    }

    public int a(byte[] bArr, String str) throws Exception {
        return IronSourceStorageUtils.saveFile(bArr, str);
    }

    public boolean a(String str, String str2) throws Exception {
        return IronSourceStorageUtils.renameFile(str, str2);
    }

    public byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr, 0, 8192);
            if (i2 != -1) {
                byteArrayOutputStream.write(bArr, 0, i2);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C2355h5 call() throws Throwable {
        CallableC2266c6 callableC2266c6;
        if (this.f8116c == 0) {
            this.f8116c = 1L;
        }
        C2355h5 c2355h5A = null;
        int i2 = 0;
        while (true) {
            if (i2 >= this.f8116c) {
                callableC2266c6 = this;
                break;
            }
            callableC2266c6 = this;
            c2355h5A = callableC2266c6.a(this.f8114a.e(), i2, this.f8114a.a(), this.f8114a.c(), this.f8114a.f());
            int iB = c2355h5A.b();
            if (iB != 1008 && iB != 1009) {
                break;
            }
            i2++;
        }
        C2355h5 c2355h5 = c2355h5A;
        if (c2355h5 != null && c2355h5.a() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(callableC2266c6.f8115b);
            String str = File.separator;
            sb.append(str);
            sb.append(callableC2266c6.f8114a.b().getName());
            String string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            androidx.camera.core.processing.util.a.z(sb2, callableC2266c6.f8114a.d(), str, C2336g4.E);
            sb2.append(callableC2266c6.f8114a.b().getName());
            String string2 = sb2.toString();
            try {
                if (a(c2355h5.a(), string2) == 0) {
                    c2355h5.a(1006);
                    return c2355h5;
                }
                if (!a(string2, string)) {
                    c2355h5.a(1014);
                    return c2355h5;
                }
            } catch (FileNotFoundException e4) {
                C2531r4.d().a(e4);
                c2355h5.a(1018);
            } catch (Error e8) {
                C2531r4.d().a(e8);
                if (!TextUtils.isEmpty(e8.getMessage())) {
                    Logger.i(f8112d, e8.getMessage());
                }
                c2355h5.a(1019);
            } catch (Exception e9) {
                C2531r4.d().a(e9);
                if (!TextUtils.isEmpty(e9.getMessage())) {
                    Logger.i(f8112d, e9.getMessage());
                }
                c2355h5.a(1009);
            }
        }
        return c2355h5;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0193 A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #6 {all -> 0x018f, blocks: (B:109:0x018b, B:113:0x0193), top: B:118:0x018b }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x018b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ironsource.C2355h5 a(java.lang.String r8, int r9, int r10, int r11, boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.CallableC2266c6.a(java.lang.String, int, int, int, boolean):com.ironsource.h5");
    }
}
