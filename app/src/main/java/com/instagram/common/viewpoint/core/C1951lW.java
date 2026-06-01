package com.instagram.common.viewpoint.core;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1951lW implements FT, DisplayManager.DisplayListener {
    public static byte[] A02;
    public FS A00;
    public final DisplayManager A01;

    static {
        A03();
    }

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{15, 20, 30, 27, 23, 12, 36};
    }

    public C1951lW(DisplayManager displayManager) {
        this.A01 = displayManager;
    }

    private Display A00() {
        return this.A01.getDisplay(0);
    }

    public static C1951lW A01(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(A02(0, 7, 65));
        if (displayManager != null) {
            return new C1951lW(displayManager);
        }
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.FT
    public final void AGn(FS fs) {
        this.A00 = fs;
        this.A01.registerDisplayListener(this, AbstractC04664a.A0Y());
        fs.ACz(A00());
    }

    @Override // com.instagram.common.viewpoint.core.FT
    public final void AJl() {
        this.A01.unregisterDisplayListener(this);
        this.A00 = null;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i2) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i2) {
        if (this.A00 != null && i2 == 0) {
            this.A00.ACz(A00());
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i2) {
    }
}
