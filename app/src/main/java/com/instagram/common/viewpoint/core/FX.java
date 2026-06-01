package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FX implements Choreographer.FrameCallback, Handler.Callback {
    public static byte[] A05;
    public static String[] A06 = {"Ji4vVtod0Ep", "W5pwMDw99nCrpy5B8Iazhudwtzilx0sf", "l9PcuhV5rMDGvrbUwzG7Ad0pcijuAzEV", "FaS8ZCu9j", "WXQRpxbn1d9lZaxATvqBiewtSAO2HDxs", "C8Lc0W9XaE3EYGTHQvU7O2Sqynab", "ekEDpZpPHDqqTKsf7TQP9QgqpYa1Ma72", "eyWJ27kKq0QXLQpZZcF977maBzKu"};
    public static final FX A07;
    public int A00;
    public Choreographer A01;
    public final Handler A02;
    public volatile long A04 = -9223372036854775807L;
    public final HandlerThread A03 = new HandlerThread(A01(0, 26, 52));

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{-109, -72, -65, -62, -75, -65, -73, -62, -79, -64, -72, -75, -62, -97, -57, -66, -75, -62, -118, -104, -79, -66, -76, -68, -75, -62};
        if (A06[0].length() == 21) {
            throw new RuntimeException();
        }
        A06[3] = "MvmtMBVRs";
    }

    static {
        A05();
        A07 = new FX();
    }

    public FX() {
        this.A03.start();
        this.A02 = AbstractC04664a.A0c(this.A03.getLooper(), this);
        this.A02.sendEmptyMessage(0);
    }

    public static FX A00() {
        return A07;
    }

    private void A02() {
        this.A00++;
        if (this.A00 == 1) {
            this.A01.postFrameCallback(this);
        }
    }

    private void A03() {
        this.A01 = Choreographer.getInstance();
    }

    private void A04() {
        this.A00--;
        if (this.A00 == 0) {
            this.A01.removeFrameCallback(this);
            this.A04 = -9223372036854775807L;
        }
    }

    public final void A06() {
        this.A02.sendEmptyMessage(1);
    }

    public final void A07() {
        this.A02.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.A04 = j;
        this.A01.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A03();
                break;
            case 1:
                A02();
                break;
            case 2:
                A04();
                break;
        }
        return true;
    }
}
