package com.bytedance.sdk.component.Cc.EO;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
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
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements DmF {
    private com.bytedance.sdk.component.Cc.Bc AXM;
    private Bitmap.Config Bc;
    private zPa Cc;
    private int DmF;
    private String EO;
    private int EV;
    Future<?> IlO;
    private String MY;
    private lEW NV;
    private int OOq;
    private boolean bWL;
    private Queue<com.bytedance.sdk.component.Cc.Cc.DmF> cL;
    private int cl;
    private bWL dY;
    private boolean ea;
    private final Handler es;
    private volatile boolean hp;
    private com.bytedance.sdk.component.Cc.EO.IlO kBB;
    private int lEW;
    private ExecutorService oc;
    private int oeT;
    private com.bytedance.sdk.component.Cc.MY pP;
    private WeakReference<ImageView> rp;
    private String tV;
    private int tl;
    private vCE vAh;
    private ImageView.ScaleType vCE;
    private boolean vSq;
    private boolean wPn;
    private boolean xF;
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
            if (imageView != null && EO.this.EV != 3 && IlO(imageView) && (ev.MY() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) ev.MY();
                EO.this.es.post(new Runnable() { // from class: com.bytedance.sdk.component.Cc.EO.EO.IlO.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (EO.this.NV != null && (ev.MY() instanceof Bitmap) && (bitmapIlO = EO.this.NV.IlO((Bitmap) ev.MY())) != null) {
                    ev.IlO(bitmapIlO);
                }
            } catch (Throwable unused) {
            }
            if (EO.this.cl == 5) {
                EO.this.es.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.Cc.EO.EO.IlO.2
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
                EO.this.es.post(new Runnable() { // from class: com.bytedance.sdk.component.Cc.EO.EO.IlO.3
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
        private ExecutorService AXM;
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
        private boolean oeT;
        private boolean rp;
        private String tV;
        private bWL vAh;
        private Bitmap.Config vCE;
        private boolean xF;
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
            return new EO(this).vAh();
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public DmF IlO(ImageView imageView) {
            this.MY = imageView;
            return new EO(this).vAh();
        }

        @Override // com.bytedance.sdk.component.Cc.NV
        public NV IlO(lEW lew) {
            this.cl = lew;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DmF vAh() {
        try {
            if (this.vAh == null) {
                zPa zpa = this.Cc;
                if (zpa != null) {
                    zpa.IlO(1005, "not init !", null);
                    return this;
                }
            } else {
                String strIlO = IlO();
                if (TextUtils.isEmpty(strIlO)) {
                    zPa zpa2 = this.Cc;
                    if (zpa2 != null) {
                        zpa2.IlO(2000, "url is empty", null);
                        return this;
                    }
                } else {
                    oeT oetCc = this.vAh.Cc();
                    if (!strIlO.startsWith("http://") && !strIlO.startsWith("https://") && oetCc != null) {
                        oetCc.IlO(1006, "url is not validate ".concat(strIlO));
                    }
                    ExecutorService executorServiceBc = this.oc == null ? this.vAh.Bc() : null;
                    Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.Cc.EO.EO.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.Cc.Cc.DmF dmF;
                            while (!EO.this.hp && (dmF = (com.bytedance.sdk.component.Cc.Cc.DmF) EO.this.cL.poll()) != null) {
                                try {
                                    if (EO.this.zPa != null) {
                                        EO.this.zPa.IlO(dmF.IlO(), EO.this);
                                    }
                                    dmF.IlO(EO.this);
                                    if (EO.this.zPa != null) {
                                        EO.this.zPa.MY(dmF.IlO(), EO.this);
                                    }
                                } catch (Throwable th) {
                                    EO.this.IlO(2000, th.getMessage(), th);
                                    if (EO.this.zPa != null) {
                                        EO.this.zPa.MY("exception", EO.this);
                                        return;
                                    }
                                    return;
                                }
                            }
                            if (EO.this.hp) {
                                EO.this.IlO(1003, "canceled", null);
                            }
                        }
                    };
                    if (this.vSq) {
                        runnable.run();
                        return this;
                    }
                    ExecutorService executorService = this.oc;
                    if (executorService != null) {
                        this.IlO = executorService.submit(runnable);
                        return this;
                    }
                    if (executorServiceBc != null) {
                        this.IlO = executorServiceBc.submit(runnable);
                    }
                }
            }
            return this;
        } catch (Exception e) {
            Log.e("ImageRequest", e.getMessage());
            return this;
        }
    }

    public bWL AXM() {
        return this.dY;
    }

    public Bitmap.Config EV() {
        return this.Bc;
    }

    public boolean bWL() {
        return this.ea;
    }

    public vCE cL() {
        return this.vAh;
    }

    public int cl() {
        return this.oeT;
    }

    public boolean ea() {
        return this.xF;
    }

    public com.bytedance.sdk.component.Cc.MY es() {
        return this.pP;
    }

    public boolean hp() {
        return this.bWL;
    }

    public String oeT() {
        return NV() + rp();
    }

    public int rp() {
        return this.EV;
    }

    public boolean xF() {
        return this.wPn;
    }

    public com.bytedance.sdk.component.Cc.Bc zPa() {
        return this.AXM;
    }

    private EO(MY my) {
        this.cL = new LinkedBlockingQueue();
        this.es = new Handler(Looper.getMainLooper());
        this.xF = true;
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
        this.pP = IlO(my);
        if (!TextUtils.isEmpty(my.EO)) {
            MY(my.EO);
            IlO(my.EO);
        }
        this.bWL = my.rp;
        this.ea = my.hp;
        this.vAh = my.zPa;
        this.NV = my.cl;
        this.OOq = my.es;
        this.tl = my.cL;
        this.oc = my.AXM;
        this.wPn = my.xF;
        this.vSq = my.oeT;
        this.dY = my.vAh;
        this.cL.add(new com.bytedance.sdk.component.Cc.Cc.EO());
    }

    public int Bc() {
        return this.OOq;
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

    public String NV() {
        return this.EO;
    }

    public zPa lEW() {
        return this.Cc;
    }

    @Override // com.bytedance.sdk.component.Cc.DmF
    public ImageView.ScaleType tV() {
        return this.vCE;
    }

    public int vCE() {
        return this.tl;
    }

    private com.bytedance.sdk.component.Cc.MY IlO(MY my) {
        if (my.ea != null) {
            return my.ea;
        }
        if (!TextUtils.isEmpty(my.bWL)) {
            return com.bytedance.sdk.component.Cc.EO.IlO.IlO.IlO(new File(my.bWL));
        }
        return com.bytedance.sdk.component.Cc.EO.IlO.IlO.NV();
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
        this.xF = z2;
    }

    public void IlO(com.bytedance.sdk.component.Cc.Bc bc) {
        this.AXM = bc;
    }

    public void IlO(int i2) {
        this.oeT = i2;
    }

    public void IlO(com.bytedance.sdk.component.Cc.EO.IlO ilO) {
        this.kBB = ilO;
    }

    public boolean IlO(com.bytedance.sdk.component.Cc.Cc.DmF dmF) {
        if (this.hp) {
            return false;
        }
        return this.cL.add(dmF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IlO(int i2, String str, Throwable th) {
        new com.bytedance.sdk.component.Cc.Cc.lEW(i2, str, th).IlO(this);
        this.cL.clear();
    }
}
