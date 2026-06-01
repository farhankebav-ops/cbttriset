package com.bytedance.sdk.component.Cc.tV.MY;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.Cc.tV.EO.MY.IlO;
import com.bytedance.sdk.component.Cc.xF;
import com.bytedance.sdk.component.utils.EV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV<T> implements vCE {
    private void MY(final com.bytedance.sdk.component.Cc.tV.EO.EO eo, final byte[] bArr, final com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        try {
            new com.bytedance.sdk.component.Cc.tV.EO.MY.IlO().IlO(bArr, eo.cl(), new IlO.InterfaceC0044IlO() { // from class: com.bytedance.sdk.component.Cc.tV.MY.tV.2
                @Override // com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.InterfaceC0044IlO
                public void IlO(Drawable drawable) {
                    ilO.IlO(new com.bytedance.sdk.component.Cc.tV.EO.tV().IlO(eo, drawable, null, true));
                }

                @Override // com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.InterfaceC0044IlO
                public void IlO() {
                    ilO.IlO(1002, "decode gif fail", new Exception("decode gif fail"));
                }

                @Override // com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.InterfaceC0044IlO
                public void IlO(byte[] bArr2) {
                    if (com.bytedance.sdk.component.utils.vCE.IlO(bArr)) {
                        tV.this.IlO(eo, bArr, true, ilO);
                    } else {
                        ilO.IlO(1001, "result type is gif but data not image", new Exception("gif not image format"));
                    }
                }
            });
        } catch (Throwable th) {
            ilO.IlO(2000, "decode gif error", th);
        }
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public boolean IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo, xF xFVar, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        byte[] bArrBWL = eo.bWL();
        if (bArrBWL == null) {
            ilO.IlO(2000, "imageData is empty", new Exception("imageData is empty"));
            return false;
        }
        int iRp = eo.rp();
        eo.IlO(bArrBWL.length);
        if (iRp == 2) {
            boolean z2 = (com.bytedance.sdk.component.utils.vCE.MY(bArrBWL) || EV.IlO(bArrBWL, 0)) ? false : true;
            if (com.bytedance.sdk.component.utils.vCE.IlO(bArrBWL)) {
                IlO(eo, bArrBWL, z2, ilO);
            } else {
                ilO.IlO(1001, "result type is bit but data not image", new Exception("not image format"));
            }
        } else if (iRp == 3) {
            ilO.IlO(new com.bytedance.sdk.component.Cc.tV.EO.tV().IlO(eo, bArrBWL, null, com.bytedance.sdk.component.utils.vCE.MY(bArrBWL)));
        } else if (com.bytedance.sdk.component.utils.vCE.MY(bArrBWL)) {
            MY(eo, bArrBWL, ilO);
        } else if (EV.IlO(bArrBWL, 0)) {
            IlO(eo, bArrBWL, ilO);
        } else if (com.bytedance.sdk.component.utils.vCE.IlO(bArrBWL)) {
            IlO(eo, bArrBWL, true, ilO);
        } else {
            ilO.IlO(1001, "is not supprot image type", new Exception("not supprot image type"));
        }
        return false;
    }

    private void IlO(final com.bytedance.sdk.component.Cc.tV.EO.EO eo, final byte[] bArr, final com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        try {
            new com.bytedance.sdk.component.Cc.tV.EO.MY.IlO().IlO(bArr, new IlO.InterfaceC0044IlO() { // from class: com.bytedance.sdk.component.Cc.tV.MY.tV.1
                @Override // com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.InterfaceC0044IlO
                public void IlO(Drawable drawable) {
                    ilO.IlO(new com.bytedance.sdk.component.Cc.tV.EO.tV().IlO(eo, drawable, null, false));
                }

                @Override // com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.InterfaceC0044IlO
                public void IlO() {
                    ilO.IlO(1002, "decode webp animate fail", new Exception("decode webp animate fail"));
                }

                @Override // com.bytedance.sdk.component.Cc.tV.EO.MY.IlO.InterfaceC0044IlO
                public void IlO(byte[] bArr2) {
                    if (com.bytedance.sdk.component.utils.vCE.IlO(bArr)) {
                        tV.this.IlO(eo, bArr, true, ilO);
                    } else {
                        ilO.IlO(1001, "result type is webp animated but data not image", new Exception("webp animated not image format"));
                    }
                }
            });
        } catch (Throwable th) {
            ilO.IlO(2000, "decode webp animation error", th);
        }
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public String IlO() {
        return "decode";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo, byte[] bArr, boolean z2, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        try {
            com.bytedance.sdk.component.Cc.tV.EO.vCE vceCl = eo.cl();
            Bitmap bitmapIlO = vceCl.IlO(eo).IlO(bArr);
            if (bitmapIlO != null) {
                eo.NV();
                eo.IlO();
                bitmapIlO.getWidth();
                bitmapIlO.getHeight();
                bitmapIlO.getByteCount();
                ilO.IlO(new com.bytedance.sdk.component.Cc.tV.EO.tV().IlO(eo, bitmapIlO, null, false));
                if (z2) {
                    IlO(eo.cL(), vceCl, eo.NV(), bitmapIlO);
                    return;
                }
                return;
            }
            eo.NV();
            eo.IlO();
            ilO.IlO(1002, "decode failed bitmap null", new Exception("decode failed bitmap null"));
        } catch (Throwable th) {
            eo.NV();
            eo.IlO();
            ilO.IlO(1002, "decode failed:" + th.getMessage(), th);
        }
    }

    private void IlO(com.bytedance.sdk.component.Cc.MY my, com.bytedance.sdk.component.Cc.tV.EO.vCE vce, String str, Bitmap bitmap) {
        if (my == null || vce == null || !my.Cc()) {
            return;
        }
        vce.IlO(my).IlO(str, bitmap);
    }
}
