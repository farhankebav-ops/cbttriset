package com.bytedance.sdk.openadsdk.rp;

import android.content.Context;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.unity3d.services.core.device.MimeTypes;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private final AudioManager IlO;
    private int MY = -1;
    private boolean EO = false;

    public NV(Context context) {
        this.IlO = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public int IlO() {
        return this.MY;
    }

    public void IlO(boolean z2) {
        IlO(z2, false);
    }

    public void IlO(boolean z2, boolean z7) {
        if (this.IlO == null) {
            return;
        }
        int i2 = 0;
        if (z2) {
            int iBc = DeviceUtils.Bc();
            if (iBc != 0) {
                this.MY = iBc;
            } else if (!z7) {
                return;
            }
            IlO(3, 0, 0);
            this.EO = true;
            return;
        }
        int iDmF = this.MY;
        if (iDmF == 0) {
            iDmF = DeviceUtils.DmF() / 15;
        } else {
            if (iDmF == -1) {
                if (!z7) {
                    return;
                } else {
                    iDmF = DeviceUtils.DmF() / 15;
                }
            }
            this.MY = -1;
            IlO(3, iDmF, i2);
            this.EO = true;
        }
        i2 = 1;
        this.MY = -1;
        IlO(3, iDmF, i2);
        this.EO = true;
    }

    private void IlO(int i2, int i8, int i9) {
        try {
            this.IlO.setStreamVolume(i2, i8, i9);
        } catch (Throwable unused) {
        }
    }
}
