package com.bytedance.sdk.openadsdk.component.reward.IlO;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    private boolean EO = true;
    protected int IlO;
    private final com.bytedance.sdk.openadsdk.component.reward.IlO.IlO MY;
    private IlO tV;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class IlO implements View.OnLayoutChangeListener {
        private int IlO;
        private int MY;

        private IlO() {
        }

        public abstract void IlO(int i2, int i8);

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            int i15 = i9 - i2;
            int i16 = i10 - i8;
            if (i15 == this.IlO && i16 == this.MY) {
                return;
            }
            this.IlO = i15;
            this.MY = i16;
            IlO(i15, i16);
        }
    }

    public rp(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        this.IlO = 0;
        this.MY = ilO;
        EO();
        if (ilO.IlO == 2) {
            return;
        }
        try {
            this.IlO = BS.EO(ilO.BS, BS.IlO());
            if (!ilO.BS.getWindow().hasFeature(1)) {
                ilO.BS.requestWindowFeature(1);
            }
            ilO.BS.getWindow().addFlags(16777344);
            if (ilO.fdM != 2 && BS.EO(ilO.BS)) {
                return;
            }
            ilO.BS.getWindow().addFlags(1024);
        } catch (Throwable th) {
            Log.e("TTAD.RFSM", "init: ", th);
        }
    }

    private float Cc() {
        return BS.EO(this.MY.BS, BS.rp(this.MY.BS));
    }

    private void EO() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        ilO.hL = ilO.MY.La();
        if (26 != Build.VERSION.SDK_INT) {
            com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO2 = this.MY;
            ilO2.fdM = ilO2.MY.BES();
        } else if (this.MY.BS.getResources().getConfiguration().orientation == 1) {
            this.MY.fdM = 1;
        } else {
            this.MY.fdM = 2;
        }
    }

    private void tV() {
        com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO = this.MY;
        if (ilO.fdM != 2) {
            IlO(ilO.BS, 1);
        } else if (ilO.nm) {
            IlO(ilO.BS, 8);
        } else {
            IlO(ilO.BS, 0);
        }
    }

    private float vCE() {
        return BS.EO(this.MY.BS, BS.EV(this.MY.BS));
    }

    public void MY(vSq vsq) {
        try {
            com.bytedance.sdk.openadsdk.activity.vCE vce = this.MY.ED;
            if (vce == null || vce.DmF <= 0) {
                final boolean z2 = true;
                final boolean z7 = this.EO && com.bytedance.sdk.openadsdk.core.cl.tV().nvX() == 1;
                if (!this.EO || !BS.EO(this.MY.BS)) {
                    z2 = false;
                }
                if (z2 || z7) {
                    if (this.tV == null) {
                        this.tV = new IlO() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.rp.2
                            boolean IlO;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super();
                            }

                            /* JADX WARN: Removed duplicated region for block: B:28:0x00e9 A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:8:0x006a, B:10:0x0088, B:12:0x0097, B:14:0x00ab, B:15:0x00af, B:26:0x00e3, B:28:0x00e9, B:29:0x00ee, B:31:0x00fc, B:16:0x00b2, B:18:0x00bc, B:20:0x00d0, B:22:0x00d4, B:23:0x00da, B:25:0x00de, B:33:0x0102, B:35:0x0106, B:7:0x0045), top: B:38:0x0000 }] */
                            /* JADX WARN: Removed duplicated region for block: B:31:0x00fc A[Catch: all -> 0x010c, TryCatch #0 {all -> 0x010c, blocks: (B:2:0x0000, B:4:0x000b, B:6:0x001f, B:8:0x006a, B:10:0x0088, B:12:0x0097, B:14:0x00ab, B:15:0x00af, B:26:0x00e3, B:28:0x00e9, B:29:0x00ee, B:31:0x00fc, B:16:0x00b2, B:18:0x00bc, B:20:0x00d0, B:22:0x00d4, B:23:0x00da, B:25:0x00de, B:33:0x0102, B:35:0x0106, B:7:0x0045), top: B:38:0x0000 }] */
                            /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
                            @Override // com.bytedance.sdk.openadsdk.component.reward.IlO.rp.IlO
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public void IlO(int r7, int r8) {
                                /*
                                    Method dump skipped, instruction units count: 269
                                    To view this dump change 'Code comments level' option to 'DEBUG'
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.IlO.rp.AnonymousClass2.IlO(int, int):void");
                            }
                        };
                    }
                    this.MY.BS.getWindow().getDecorView().addOnLayoutChangeListener(this.tV);
                }
                this.EO = false;
            }
        } catch (Exception unused) {
        }
    }

    public void IlO(vSq vsq) {
        if (vsq == null) {
            return;
        }
        vsq.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.rp.1
            @Override // java.lang.Runnable
            public void run() {
                View viewFindViewById;
                try {
                    View decorView = rp.this.MY.BS.getWindow().getDecorView();
                    if (decorView == null || (viewFindViewById = decorView.findViewById(R.id.statusBarBackground)) == null) {
                        return;
                    }
                    viewFindViewById.setVisibility(8);
                } catch (Exception unused) {
                }
            }
        }, 300L);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(boolean r11) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.IlO.rp.IlO(boolean):void");
    }

    private float[] MY(int i2) {
        float fVCE = vCE();
        float fCc = Cc();
        int i8 = this.MY.fdM;
        if ((i8 == 1) != (fVCE > fCc)) {
            float f4 = fVCE + fCc;
            fCc = f4 - fCc;
            fVCE = f4 - fCc;
        }
        if (i8 == 1) {
            fVCE -= i2;
        } else {
            fCc -= i2;
        }
        return new float[]{fCc, fVCE};
    }

    public void MY() {
        if (this.tV != null) {
            this.MY.BS.getWindow().getDecorView().removeOnLayoutChangeListener(this.tV);
            this.tV = null;
        }
    }

    public float[] IlO(int i2) {
        float[] fArrMY = new float[2];
        Activity activity = this.MY.BS;
        View decorView = activity.getWindow().getDecorView();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 35 && this.MY.MY.La() == 100.0f) {
            fArrMY[0] = decorView.getWidth() - decorView.getPaddingLeft();
            fArrMY[1] = decorView.getHeight() - decorView.getPaddingTop();
        } else {
            fArrMY[0] = decorView.getWidth() - (decorView.getPaddingLeft() * 2);
            fArrMY[1] = decorView.getHeight() - (decorView.getPaddingTop() * 2);
        }
        fArrMY[0] = BS.EO(activity, fArrMY[0]);
        float fEO = BS.EO(activity, fArrMY[1]);
        fArrMY[1] = fEO;
        if (fArrMY[0] < 10.0f || fEO < 10.0f) {
            fArrMY = MY(this.IlO);
        }
        if (i8 != 26 && i8 != 27 && activity.getResources() != null && activity.getResources().getConfiguration() != null) {
            if ((activity.getResources().getConfiguration().orientation == 2 ? 2 : 1) != i2) {
                if (i2 == 2) {
                    float f4 = fArrMY[0];
                    float f8 = fArrMY[1];
                    if (f4 < f8) {
                        fArrMY[1] = f4;
                        fArrMY[0] = f8;
                        return fArrMY;
                    }
                } else {
                    float f9 = fArrMY[0];
                    float f10 = fArrMY[1];
                    if (f9 > f10) {
                        fArrMY[1] = f9;
                        fArrMY[0] = f10;
                    }
                }
            }
        }
        return fArrMY;
    }

    public void IlO() {
        BS.IlO(this.MY.BS);
        this.MY.BS.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.rp.3
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public void onSystemUiVisibilityChange(int i2) {
                if (i2 == 0) {
                    try {
                        if (rp.this.MY.BS.isFinishing()) {
                            return;
                        }
                        rp.this.MY.BS.getWindow().getDecorView().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.IlO.rp.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BS.IlO(rp.this.MY.BS);
                            }
                        }, 2500L);
                    } catch (Exception e) {
                        oeT.EO("TTAD.RFSM", e.getMessage());
                    }
                }
            }
        });
    }

    private static void IlO(Activity activity, int i2) {
        if (activity.getRequestedOrientation() == i2) {
            return;
        }
        activity.setRequestedOrientation(i2);
    }
}
