package com.bytedance.sdk.component.Cc.tV.EO;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import androidx.webkit.internal.b;
import com.bytedance.sdk.component.Cc.DmF;
import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.NV;
import com.bytedance.sdk.component.Cc.bWL;
import com.bytedance.sdk.component.Cc.lEW;
import com.bytedance.sdk.component.Cc.oeT;
import com.bytedance.sdk.component.Cc.xF;
import com.bytedance.sdk.component.Cc.zPa;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements DmF {
    private int AXM;
    private Bitmap.Config Bc;
    private zPa Cc;
    private int DmF;
    private String EO;
    private int EV;
    Future<?> IlO;
    private String MY;
    private lEW NV;
    private boolean OOq;
    private boolean bWL;
    private final Handler cL;
    private int cl;
    private boolean ea;
    private boolean es;
    private volatile boolean hp;
    private int kBB;
    private int lEW;
    private byte[] oc;
    private vCE oeT;
    private int pP;
    private WeakReference<ImageView> rp;
    private String tV;
    private ExecutorService tl;
    private com.bytedance.sdk.component.Cc.MY vAh;
    private ImageView.ScaleType vCE;
    private bWL wPn;
    private com.bytedance.sdk.component.Cc.Bc xF;
    private xF zPa;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class IlO implements zPa {
        private zPa MY;

        public IlO(zPa zpa) {
            this.MY = zpa;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(final EV ev) {
            Bitmap bitmapIlO;
            final ImageView imageView = (ImageView) EO.this.rp.get();
            if (imageView != null && EO.this.EV != 3 && IlO(imageView)) {
                Object objMY = ev.MY();
                if (objMY instanceof Bitmap) {
                    final Bitmap bitmap = (Bitmap) ev.MY();
                    EO.this.cL.post(new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.EO.EO.IlO.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                } else if (objMY instanceof Drawable) {
                    final Drawable drawable = (Drawable) ev.MY();
                    EO.this.cL.post(new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.EO.EO.IlO.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && b.y(drawable)) {
                                b.h(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            }
            try {
                if (EO.this.NV != null && (ev.MY() instanceof Bitmap) && (bitmapIlO = EO.this.NV.IlO((Bitmap) ev.MY())) != null) {
                    ev.IlO(bitmapIlO);
                }
            } catch (Throwable unused) {
            }
            if (EO.this.cl == 5) {
                EO.this.cL.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.EO.EO.IlO.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (IlO.this.MY != null) {
                            IlO.this.MY.IlO(ev);
                        }
                    }
                });
                return;
            }
            zPa zpa = this.MY;
            if (zpa != null) {
                zpa.IlO(ev);
            }
        }

        private boolean IlO(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(EO.this.EO)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.Cc.zPa
        public void IlO(final int i2, final String str, final Throwable th) {
            if (EO.this.cl == 5) {
                EO.this.cL.post(new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.EO.EO.IlO.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (IlO.this.MY != null) {
                            IlO.this.MY.IlO(i2, str, th);
                        }
                    }
                });
                return;
            }
            zPa zpa = this.MY;
            if (zpa != null) {
                zpa.IlO(i2, str, th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY implements NV {
        private boolean AXM;
        private int Bc;
        private ImageView.ScaleType Cc;
        private String EO;
        private xF EV;
        private zPa IlO;
        private ImageView MY;
        private String bWL;
        private int cL;
        private lEW cl;
        private com.bytedance.sdk.component.Cc.MY ea;
        private int es;
        private boolean hp;
        private int lEW;
        private bWL oeT;
        private boolean rp;
        private String tV;
        private Bitmap.Config vCE;
        private ExecutorService xF;
        private vCE zPa;
        private int DmF = 1;
        private int NV = 5;

        public MY(vCE vce) {
            this.zPa = vce;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV Cc(int i2) {
            this.es = i2;
            return this;
        }

        public NV EO(String str) {
            this.tV = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(String str) {
            this.EO = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV MY(int i2) {
            this.lEW = i2;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV tV(int i2) {
            this.cL = i2;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV EO(int i2) {
            this.DmF = i2;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(ImageView.ScaleType scaleType) {
            this.Cc = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV MY(String str) {
            this.bWL = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(Bitmap.Config config) {
            this.vCE = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(int i2) {
            this.Bc = i2;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(xF xFVar) {
            this.EV = xFVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(boolean z2) {
            this.hp = z2;
            return this;
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public DmF IlO(zPa zpa, int i2) {
            this.NV = i2;
            return IlO(zpa);
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public DmF IlO(zPa zpa) {
            this.IlO = zpa;
            return new EO(this).AXM();
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public DmF IlO(ImageView imageView) {
            this.MY = imageView;
            return new EO(this).AXM();
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(lEW lew) {
            this.cl = lew;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DmF AXM() {
        try {
            if (this.oeT == null) {
                zPa zpa = this.Cc;
                if (zpa != null) {
                    zpa.IlO(1005, "not init !", null);
                    return this;
                }
            } else {
                String strIlO = IlO();
                if (TextUtils.isEmpty(strIlO)) {
                    this.Cc.IlO(2000, "url is empty", null);
                    return this;
                }
                oeT oetVCE = this.oeT.vCE();
                if (!strIlO.startsWith("http://") && !strIlO.startsWith("https://") && oetVCE != null) {
                    oetVCE.IlO(1006, "url is not validate ".concat(strIlO));
                }
                ExecutorService executorServiceCc = this.tl == null ? this.oeT.Cc() : null;
                Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.Cc.tV.EO.EO.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EO eo = EO.this;
                        com.bytedance.sdk.component.Cc.tV.EO.IlO ilO = new com.bytedance.sdk.component.Cc.tV.EO.IlO(eo, eo.zPa);
                        try {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new com.bytedance.sdk.component.Cc.tV.MY.MY());
                            arrayList.add(new com.bytedance.sdk.component.Cc.tV.MY.Cc());
                            arrayList.add(new com.bytedance.sdk.component.Cc.tV.MY.IlO());
                            arrayList.add(new com.bytedance.sdk.component.Cc.tV.MY.EO());
                            arrayList.add(new com.bytedance.sdk.component.Cc.tV.MY.tV());
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                if (EO.this.hp) {
                                    ilO.IlO(1003, "canceled", null);
                                    return;
                                }
                                com.bytedance.sdk.component.Cc.tV.MY.vCE vce = (com.bytedance.sdk.component.Cc.tV.MY.vCE) arrayList.get(i2);
                                if (EO.this.zPa != null && vce != null && !"data_intercept".equals(vce.IlO())) {
                                    EO.this.zPa.IlO(vce.IlO(), EO.this);
                                }
                                EO eo2 = EO.this;
                                boolean zIlO = vce.IlO(eo2, eo2.zPa, ilO);
                                if (EO.this.zPa != null && !"data_intercept".equals(vce.IlO())) {
                                    EO.this.zPa.MY(vce.IlO(), EO.this);
                                }
                                if (!zIlO) {
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            ilO.IlO(2000, th.getMessage(), th);
                        }
                    }
                };
                if (this.OOq) {
                    runnable.run();
                    return this;
                }
                ExecutorService executorService = this.tl;
                if (executorService != null) {
                    this.IlO = executorService.submit(runnable);
                    return this;
                }
                if (executorServiceCc != null) {
                    this.IlO = executorServiceCc.submit(runnable);
                }
            }
            return this;
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
            return this;
        }
    }

    public Bitmap.Config EV() {
        return this.Bc;
    }

    public String NV() {
        return this.EO;
    }

    public byte[] bWL() {
        return this.oc;
    }

    public com.bytedance.sdk.component.Cc.MY cL() {
        return this.vAh;
    }

    public vCE cl() {
        return this.oeT;
    }

    public com.bytedance.sdk.component.Cc.Bc ea() {
        return this.xF;
    }

    public bWL es() {
        return this.wPn;
    }

    public boolean hp() {
        return this.es;
    }

    public int rp() {
        return this.EV;
    }

    public String xF() {
        return NV() + rp();
    }

    public int zPa() {
        return this.AXM;
    }

    private EO(MY my) {
        this.cL = new Handler(Looper.getMainLooper());
        this.es = true;
        this.oc = null;
        this.MY = my.tV;
        this.Cc = new IlO(my.IlO);
        this.rp = new WeakReference<>(my.MY);
        this.vCE = my.Cc;
        this.Bc = my.vCE;
        this.lEW = my.Bc;
        this.DmF = my.lEW;
        this.EV = my.DmF;
        this.cl = my.NV;
        this.zPa = my.EV;
        this.vAh = IlO(my);
        if (!TextUtils.isEmpty(my.EO)) {
            MY(my.EO);
            IlO(my.EO);
        }
        this.bWL = my.rp;
        this.ea = my.hp;
        this.oeT = my.zPa;
        this.NV = my.cl;
        this.pP = my.es;
        this.kBB = my.cL;
        this.tl = my.xF;
        this.OOq = my.AXM;
        this.wPn = my.oeT;
    }

    private com.bytedance.sdk.component.Cc.MY IlO(MY my) {
        return my.ea != null ? my.ea : !TextUtils.isEmpty(my.bWL) ? com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.IlO(new File(my.bWL)) : com.bytedance.sdk.component.Cc.tV.EO.IlO.MY.NV();
    }

    public int Bc() {
        return this.pP;
    }

    @Override // com.bytedance.sdk.component.Cc.DmF
    public Bitmap.Config Cc() {
        return this.Bc;
    }

    public String DmF() {
        return this.tV;
    }

    @Override // com.bytedance.sdk.component.Cc.DmF
    public int EO() {
        return this.DmF;
    }

    public void MY(String str) {
        WeakReference<ImageView> weakReference = this.rp;
        if (weakReference != null && weakReference.get() != null) {
            this.rp.get().setTag(1094453505, str);
        }
        this.EO = str;
    }

    public zPa lEW() {
        return this.Cc;
    }

    @Override // com.bytedance.sdk.component.Cc.DmF
    public ImageView.ScaleType tV() {
        return this.vCE;
    }

    public int vCE() {
        return this.kBB;
    }

    @Override // com.bytedance.sdk.component.Cc.DmF
    public int MY() {
        return this.lEW;
    }

    @Override // com.bytedance.sdk.component.Cc.DmF
    public String IlO() {
        return this.MY;
    }

    public void IlO(String str) {
        this.tV = str;
    }

    public void IlO(boolean z2) {
        this.es = z2;
    }

    public void IlO(byte[] bArr) {
        this.oc = bArr;
    }

    public void IlO(int i2) {
        this.AXM = i2;
    }
}
