package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfyy implements zzfys {
    private final ExecutorService zza;
    private final String zzb;
    private final long zzc;

    public zzfyy(ExecutorService executorService, String str, long j) {
        this.zza = executorService;
        this.zzb = str;
        this.zzc = j;
    }

    private final j2.q zze(final String str, final boolean z2, final byte[] bArr, final String str2) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: com.google.android.gms.internal.ads.zzfyv
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final /* synthetic */ Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.zza.zzc(str, z2, str2, bArr, completer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzd(String str, CallbackToFutureAdapter.Completer completer, boolean z2, String str2, byte[] bArr) {
        Throwable th;
        SocketTimeoutException e;
        final HttpURLConnection httpURLConnection;
        int responseCode;
        InputStream inputStream;
        byte[] byteArray;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
            } catch (SocketTimeoutException e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                Objects.requireNonNull(httpURLConnection);
                completer.addCancellationListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfyw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        httpURLConnection.disconnect();
                    }
                }, this.zza);
                httpURLConnection.setRequestProperty("User-Agent", this.zzb);
                int i2 = (int) this.zzc;
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
                if (z2) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty("Content-Type", str2);
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    try {
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.close();
                    } finally {
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
                inputStream = responseCode < 400 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
            } catch (SocketTimeoutException e8) {
                e = e8;
                httpURLConnection2 = httpURLConnection;
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 9);
                sb.append("Timeout: ");
                sb.append(message);
                completer.setException(new TimeoutException(sb.toString()));
                httpURLConnection = httpURLConnection2;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection2 = httpURLConnection;
                completer.setException(th);
                httpURLConnection = httpURLConnection2;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    if (inputStream == null) {
                        byteArray = new byte[0];
                        byteArrayOutputStream.close();
                    } else {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int i8 = inputStream.read(bArr2);
                            if (i8 == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr2, 0, i8);
                            }
                        }
                        byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStream.close();
                    }
                    completer.set(new zzfyx(responseCode, byteArray));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } finally {
                }
            } finally {
            }
        } finally {
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    public final j2.q zza(String str) {
        return zze(str, false, new byte[0], null);
    }

    @Override // com.google.android.gms.internal.ads.zzfys
    public final j2.q zzb(String str, byte[] bArr, String str2) {
        return zze(str, true, bArr, CommonGatewayClient.HEADER_PROTOBUF);
    }

    public final /* synthetic */ Object zzc(final String str, final boolean z2, final String str2, final byte[] bArr, final CallbackToFutureAdapter.Completer completer) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfyu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd(str, completer, z2, str2, bArr);
            }
        });
        return "";
    }
}
