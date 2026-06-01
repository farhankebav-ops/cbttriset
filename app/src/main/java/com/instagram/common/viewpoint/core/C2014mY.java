package com.instagram.common.viewpoint.core;

import android.os.Handler;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2014mY extends Thread implements InterfaceC0638Be {
    public static String[] A09 = {"WULC9DYlvQgZjojDU2bdZ9xs7wQbeGsA", "0RzPpdpgLbDOZ8gUAj9sr", "fywSSsB8oN823aa6hQ2avodpE9Fj6EUo", "rQ4mhJZFramri", "thNzrz2pgMkLR", "sKcdOZc1ZRugYqEHWVRtFgFPdRxve1CE", "006dlWDsgbMi7GTsUIBgGpVxQZYkiOjN", "1EnGqdZRllbwfzBFLuDlK"};
    public long A00;
    public Exception A01;
    public final int A02;
    public final BU A03;
    public final DownloadRequest A04;
    public final InterfaceC0639Bf A05;
    public final boolean A06;
    public volatile BQ A07;
    public volatile boolean A08;

    public C2014mY(DownloadRequest downloadRequest, InterfaceC0639Bf interfaceC0639Bf, BU bu, boolean z2, int i2, BQ bq) {
        this.A04 = downloadRequest;
        this.A05 = interfaceC0639Bf;
        this.A03 = bu;
        this.A06 = z2;
        this.A02 = i2;
        this.A07 = bq;
        this.A00 = -1L;
    }

    public static int A00(int i2) {
        return Math.min((i2 - 1) * 1000, 5000);
    }

    public final void A05(boolean z2) {
        if (z2) {
            this.A07 = null;
        }
        if (!this.A08) {
            this.A08 = true;
            this.A05.cancel();
            if (A09[5].charAt(29) == 'B') {
                throw new RuntimeException();
            }
            A09[5] = "eeNE7Qy6MuAlBYtV44JqSUiJf46fCooo";
            interrupt();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0638Be
    public final void AEo(long j, long j3, float f4) {
        this.A03.A01 = j3;
        this.A03.A00 = f4;
        if (j != this.A00) {
            this.A00 = j;
            BQ bq = this.A07;
            if (bq != null) {
                bq.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (AbstractC1156Vl.A02(this)) {
            return;
        }
        try {
            try {
                if (this.A06) {
                    this.A05.remove();
                } else {
                    int i2 = 0;
                    long j = -1;
                    while (!this.A08) {
                        try {
                            this.A05.A5v(this);
                            break;
                        } catch (IOException e) {
                            if (!this.A08) {
                                long j3 = this.A03.A01;
                                int errorCount = A09[2].charAt(8);
                                if (errorCount != 71) {
                                    String[] strArr = A09;
                                    strArr[0] = "VpOvMV7lY4vr3Fu5UlYiKKcH9ACGqt7g";
                                    strArr[6] = "gAlRMyi1pPzVqBLwURYLCrt7UwpliGsz";
                                    if (j3 != j) {
                                        j = j3;
                                        i2 = 0;
                                    }
                                    i2++;
                                    if (i2 <= this.A02) {
                                        Thread.sleep(A00(i2));
                                    } else {
                                        throw e;
                                    }
                                } else {
                                    throw new RuntimeException();
                                }
                            }
                        }
                    }
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (Exception e4) {
                this.A01 = e4;
            }
            Handler internalHandler = this.A07;
            if (internalHandler != null) {
                internalHandler.obtainMessage(9, this).sendToTarget();
            }
        } catch (Throwable th) {
            AbstractC1156Vl.A00(th, this);
            if (A09[5].charAt(29) == 'B') {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[0] = "35cAsSHzLcpGFjLAU34RIcGdZnNZcSm1";
            strArr2[6] = "9oN8QLA5AyCkKiMzUX6AKpAi6mTPSF3S";
        }
    }
}
