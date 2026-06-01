package z;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.lEW.DmF;
import com.bytedance.sdk.component.lEW.IlO.IlO;
import com.bytedance.sdk.component.utils.oeT;
import com.bytedance.sdk.component.utils.vSq;
import com.bytedance.sdk.openadsdk.core.rp.tV.EO;
import com.vungle.ads.internal.protos.Sdk;
import j4.u;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n implements r.c, a, b, c, d, e, f, g, vSq.IlO {
    private static final SparseIntArray IlO = new SparseIntArray();
    private final Runnable BS;
    private SurfaceTexture Cc;
    private boolean OOq;
    private volatile boolean YA;
    private boolean hp;
    private ArrayList<Runnable> kBB;
    private int lEW;
    private int pP;
    private boolean rp;
    private final m tV;
    private boolean vAh;
    private SurfaceHolder vCE;
    private boolean zLG;
    private vSq zPa;
    private final boolean MY = false;
    private final List<WeakReference<r.b>> EO = new CopyOnWriteArrayList();
    private int Bc = 0;
    private boolean DmF = false;
    private volatile h NV = null;
    private boolean EV = false;
    private volatile int bWL = 201;
    private long ea = -1;
    private boolean cl = false;
    private long cL = 0;
    private long es = Long.MIN_VALUE;
    private long xF = 0;
    private long AXM = 0;
    private long oeT = 0;
    private String tl = "0";
    private com.bykv.vk.openvk.IlO.IlO.IlO.EO.a wPn = null;
    private boolean oc = false;
    private CountDownLatch vSq = new CountDownLatch(1);
    private volatile int dY = 200;
    private AtomicBoolean lMM = new AtomicBoolean(false);
    private Surface nvX = null;
    private long mmj = 0;
    private long DM = 0;

    public n() {
        EO eo = (EO) this;
        this.tV = new m(eo);
        this.pP = 0;
        this.zLG = false;
        this.BS = new a4.c(eo, 22);
        this.pP = 0;
        vSq vsqIlO = IlO.IlO().IlO(this, DmF.THREAD_NAME_PRE.concat("SSMediaPlayerWrapper"));
        this.zPa = vsqIlO;
        this.zLG = true;
        if (vsqIlO != null) {
            vsqIlO.post(new k(this, 0));
        }
    }

    public static void NV(n nVar) {
        vSq vsq = nVar.zPa;
        if (vsq != null) {
            vsq.post(new k(nVar, 0));
        }
    }

    public final void a(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        aVar.zPa();
        j jVar = (j) this.NV;
        synchronized (jVar) {
            a0.a aVar2 = new a0.a(r.a.f13608a, aVar);
            a0.a.e.put(aVar.cl(), aVar2);
            jVar.k = aVar2;
            c0.a.a(aVar);
            jVar.f17882i.setDataSource(jVar.k);
        }
        aVar.zPa();
    }

    public final void b(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar, File file) {
        if (!aVar.IlO()) {
            c(file);
            return;
        }
        try {
            String strB = q.b(file);
            if (aVar.cl().equals(strB)) {
                c(file);
                return;
            }
            JSONObject jSONObjectEO = aVar.EO();
            boolean zMY = aVar.MY();
            if (jSONObjectEO != null) {
                jSONObjectEO.put("file_hash", aVar.cl());
                jSONObjectEO.put("file_real_hash", strB);
                jSONObjectEO.put("is_change_play_type", zMY ? 1 : 0);
                jSONObjectEO.put("error_real_code", 309);
                jSONObjectEO.put("error_real_msg", "md5_not_match");
            }
            if (zMY) {
                boolean zDelete = file.delete();
                if (jSONObjectEO != null) {
                    jSONObjectEO.put("delete_cache_file", zDelete ? 1 : 0);
                }
                if (zDelete) {
                    a(aVar);
                    return;
                }
            }
            c(file);
        } catch (Throwable unused) {
        }
    }

    public long bWL() {
        if (this.cl) {
            long j = this.xF;
            if (j > 0) {
                return this.cL + j;
            }
        }
        return this.cL;
    }

    public final void c(File file) {
        file.getAbsolutePath();
        try {
            if (!r.a.f13610c) {
                ((j) this.NV).b(file.getAbsolutePath());
            } else {
                FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
                h hVar = this.NV;
                ((j) hVar).f17882i.setDataSource(fileInputStream.getFD());
                fileInputStream.close();
            }
        } catch (Throwable unused) {
        }
    }

    public SurfaceHolder cL() {
        return this.vCE;
    }

    public long cl() {
        if (lEW()) {
            return 0L;
        }
        if (this.bWL != 206 && this.bWL != 207) {
            return 0L;
        }
        try {
            ((j) this.NV).getClass();
            return r0.f17882i.getCurrentPosition();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public final void d(Runnable runnable) {
        try {
            if (this.kBB == null) {
                this.kBB = new ArrayList<>();
            }
            this.kBB.add(runnable);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public final void e(int i2) {
        if (i2 == 701) {
            this.mmj = SystemClock.elapsedRealtime();
            this.Bc++;
            for (WeakReference<r.b> weakReference : this.EO) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().IlO(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            return;
        }
        if (i2 != 702) {
            if (this.zLG && i2 == 3) {
                i();
                j();
                MY(this.oc);
                return;
            }
            return;
        }
        if (this.mmj > 0) {
            this.DM = (SystemClock.elapsedRealtime() - this.mmj) + this.DM;
            this.mmj = 0L;
        }
        for (WeakReference<r.b> weakReference2 : this.EO) {
            if (weakReference2 != null && weakReference2.get() != null) {
                weakReference2.get().IlO((r.c) this, Integer.MAX_VALUE);
            }
        }
    }

    public int ea() {
        return this.Bc;
    }

    public SurfaceTexture es() {
        return this.Cc;
    }

    public final void f(long j) {
        m mVar = this.tV;
        mVar.f17889a = j;
        if (this.OOq) {
            g(mVar);
            return;
        }
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar = this.wPn;
        if (aVar == null || !aVar.Bc()) {
            d(this.tV);
        } else {
            g(this.tV);
        }
    }

    public final void g(Runnable runnable) {
        if (runnable == null || lEW()) {
            return;
        }
        if (this.hp) {
            d(runnable);
        } else {
            runnable.run();
        }
    }

    public final void h() {
        vSq vsq = this.zPa;
        if (vsq == null || vsq.getLooper() == null) {
            return;
        }
        this.zPa.post(new k(this, 5));
    }

    public boolean hp() {
        return this.bWL == 205;
    }

    public final void i() {
        ArrayList<Runnable> arrayList = this.kBB;
        if (arrayList == null || arrayList.isEmpty() || this.rp) {
            return;
        }
        this.rp = true;
        ArrayList arrayList2 = new ArrayList(this.kBB);
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            ((Runnable) obj).run();
        }
        this.kBB.clear();
        this.rp = false;
    }

    public final void j() {
        this.DmF = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.oeT;
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().IlO(this, jElapsedRealtime);
            }
        }
    }

    public final void k() {
        if (this.NV == null) {
            return;
        }
        try {
            j jVar = (j) this.NV;
            jVar.getClass();
            try {
                jVar.f17882i.reset();
            } catch (Throwable unused) {
            }
            a0.a aVar = jVar.k;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable unused2) {
                }
                jVar.k = null;
            }
            jVar.c();
            jVar.d();
        } catch (Throwable unused3) {
        }
        ((j) this.NV).f17878b = null;
        ((j) this.NV).e = null;
        ((j) this.NV).f17879c = null;
        ((j) this.NV).g = null;
        ((j) this.NV).f17881f = null;
        ((j) this.NV).f17877a = null;
        ((j) this.NV).f17880d = null;
        try {
            j jVar2 = (j) this.NV;
            synchronized (jVar2.m) {
                try {
                    if (!jVar2.f17883n) {
                        jVar2.f17882i.release();
                        jVar2.f17883n = true;
                        try {
                            Surface surface = jVar2.l;
                            if (surface != null) {
                                surface.release();
                                jVar2.l = null;
                            }
                        } catch (Throwable unused4) {
                        }
                        a0.a aVar2 = jVar2.k;
                        if (aVar2 != null) {
                            try {
                                aVar2.close();
                            } catch (Throwable unused5) {
                            }
                            jVar2.k = null;
                        }
                        jVar2.c();
                        jVar2.d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable unused6) {
        }
    }

    public void rp() {
        if (lEW()) {
            return;
        }
        this.hp = true;
        ArrayList<Runnable> arrayList = this.kBB;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.kBB.clear();
        }
        vSq vsq = this.zPa;
        if (vsq != null) {
            try {
                vsq.removeCallbacksAndMessages(null);
                if (this.NV != null) {
                    this.zPa.sendEmptyMessage(103);
                }
                h();
            } catch (Throwable unused) {
                h();
            }
        }
    }

    public long zPa() {
        long j = this.AXM;
        long duration = 0;
        if (j != 0) {
            return j;
        }
        if (this.bWL == 206 || this.bWL == 207) {
            try {
                j jVar = (j) this.NV;
                jVar.getClass();
                try {
                    duration = jVar.f17882i.getDuration();
                } catch (Throwable unused) {
                }
                this.AXM = duration;
            } catch (Throwable unused2) {
            }
        }
        return this.AXM;
    }

    @Override // r.c
    public boolean Bc() {
        vSq vsq;
        return ((this.bWL != 207 && !this.YA) || (vsq = this.zPa) == null || vsq.hasMessages(100)) ? false : true;
    }

    @Override // r.c
    public int Cc() {
        MediaPlayer mediaPlayer;
        if (this.NV == null || lEW() || (mediaPlayer = ((j) this.NV).f17882i) == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public void DmF() {
        if (lEW() || this.NV == null) {
            return;
        }
        this.lMM.set(true);
        if (this.bWL != 206) {
            this.cL = 0L;
            this.Bc = 0;
            this.xF = 0L;
            this.cl = false;
            this.es = Long.MIN_VALUE;
            this.YA = false;
            this.tV.f17890b = true;
            f(0L);
            vSq vsq = this.zPa;
            if (vsq != null) {
                vsq.removeCallbacks(this.BS);
                this.zPa.postDelayed(this.BS, this.dY);
            }
        }
        this.vSq.countDown();
    }

    public void EV() {
        vSq vsq;
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar;
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar2;
        if (lEW() || (vsq = this.zPa) == null) {
            return;
        }
        vsq.removeMessages(100);
        this.YA = true;
        if (this.zLG) {
            if (!this.DmF && ((aVar = this.wPn) == null || !aVar.Bc())) {
                d(new k(this, 3));
                return;
            }
            vSq vsq2 = this.zPa;
            if (vsq2 != null) {
                vsq2.sendEmptyMessage(101);
                return;
            }
            return;
        }
        if (!this.vAh && ((aVar2 = this.wPn) == null || !aVar2.Bc())) {
            d(new k(this, 2));
            return;
        }
        vSq vsq3 = this.zPa;
        if (vsq3 != null) {
            vsq3.sendEmptyMessage(101);
        }
    }

    @Override // r.c
    public boolean lEW() {
        return this.hp;
    }

    @Override // r.c
    public boolean vCE() {
        vSq vsq;
        return (this.bWL == 206 || ((vsq = this.zPa) != null && vsq.hasMessages(100))) && !this.YA;
    }

    public void NV() {
        if (lEW() || this.zPa == null) {
            return;
        }
        this.lMM.set(true);
        this.zPa.post(new k(this, 1));
    }

    @Override // r.c
    public boolean EO() {
        return hp() || vCE() || Bc();
    }

    @Override // r.c
    public boolean MY() {
        return this.bWL == 209;
    }

    @Override // r.c
    public int tV() {
        MediaPlayer mediaPlayer;
        if (this.NV == null || lEW() || (mediaPlayer = ((j) this.NV).f17882i) == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    @Override // z.g
    public void EO(h hVar) {
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().IlO((r.c) this, true);
            }
        }
    }

    @Override // z.f
    public boolean MY(h hVar, int i2, int i8) {
        if (this.NV != hVar) {
            return false;
        }
        if (i8 == -1004) {
            com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar = new com.bykv.vk.openvk.IlO.IlO.IlO.EO.b(i2, i8);
            for (WeakReference<r.b> weakReference : this.EO) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().IlO(this, bVar);
                }
            }
        }
        e(i2);
        return false;
    }

    public static void IlO(n nVar, long j, long j3) {
        n nVar2;
        long j8;
        long j9;
        for (WeakReference<r.b> weakReference : nVar.EO) {
            if (weakReference == null || weakReference.get() == null) {
                nVar2 = nVar;
                j8 = j;
                j9 = j3;
            } else {
                nVar2 = nVar;
                j8 = j;
                j9 = j3;
                weakReference.get().IlO(nVar2, j8, j9);
            }
            nVar = nVar2;
            j = j8;
            j3 = j9;
        }
    }

    @Override // z.b
    public void MY(h hVar) {
        if (lEW()) {
            return;
        }
        this.bWL = 205;
        try {
            com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar = this.wPn;
            if (aVar != null) {
                float fEa = aVar.ea();
                if (fEa > 0.0f) {
                    MediaPlayer mediaPlayer = ((j) this.NV).f17882i;
                    mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(fEa));
                }
            }
        } catch (Throwable unused) {
        }
        if (this.zPa != null) {
            if (this.YA) {
                vSq vsq = this.zPa;
                if (vsq != null) {
                    vsq.post(new k(this, 6));
                }
            } else {
                vSq vsq2 = this.zPa;
                vsq2.sendMessage(vsq2.obtainMessage(100, -1, -1));
            }
        }
        IlO.delete(this.pP);
        boolean z2 = this.zLG;
        boolean z7 = this.vAh;
        if (!z2 && !z7) {
            j();
            this.vAh = true;
        }
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().MY(this);
            }
        }
    }

    public void IlO(boolean z2) {
        if (lEW()) {
            return;
        }
        this.OOq = z2;
        if (this.NV != null) {
            ((j) this.NV).h = z2;
            return;
        }
        vSq vsq = this.zPa;
        if (vsq != null) {
            vsq.post(new l(this, z2, 1));
        }
    }

    public void IlO(boolean z2, long j, boolean z7) {
        if (lEW()) {
            return;
        }
        vSq vsq = this.zPa;
        if (vsq != null) {
            vsq.post(new k(this, 0));
        }
        this.oc = z7;
        this.lMM.set(true);
        this.YA = false;
        MY(z7);
        if (z2) {
            this.ea = j;
            g(new k(this, 4));
        } else {
            f(j);
        }
        vSq vsq2 = this.zPa;
        if (vsq2 != null) {
            vsq2.removeCallbacks(this.BS);
            this.zPa.postDelayed(this.BS, this.dY);
        }
        this.vSq.countDown();
    }

    public void MY(boolean z2) {
        vSq vsq;
        if (lEW() || (vsq = this.zPa) == null) {
            return;
        }
        vsq.post(new l(this, z2, 0));
    }

    public void IlO(long j) {
        if (lEW()) {
            return;
        }
        if (this.bWL == 207 || this.bWL == 206 || this.bWL == 209) {
            g(new u(this, j, 1));
        }
    }

    public void MY(int i2) {
        this.lEW = i2;
    }

    @Override // r.c
    public boolean IlO() {
        return this.DmF;
    }

    public void IlO(SurfaceTexture surfaceTexture) {
        if (lEW()) {
            return;
        }
        this.Cc = surfaceTexture;
        IlO(true);
        g(new com.unity3d.scar.adapter.common.i(8, this, surfaceTexture));
    }

    public void IlO(SurfaceHolder surfaceHolder) {
        if (lEW()) {
            return;
        }
        this.vCE = surfaceHolder;
        IlO(true);
        g(new com.unity3d.scar.adapter.common.i(9, this, surfaceHolder));
    }

    public void IlO(com.bykv.vk.openvk.IlO.IlO.IlO.EO.a aVar) {
        if (lEW()) {
            return;
        }
        this.wPn = aVar;
        if (aVar != null) {
            this.zLG = this.zLG && !aVar.Bc();
        }
        g(new com.unity3d.scar.adapter.common.i(10, this, aVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.component.utils.vSq.IlO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(android.os.Message r17) {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z.n.IlO(android.os.Message):void");
    }

    @Override // z.d
    public void IlO(h hVar, int i2) {
        if (this.NV != hVar) {
            return;
        }
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().MY(this, i2);
            }
        }
    }

    @Override // z.c
    public boolean IlO(h hVar, int i2, int i8) {
        SparseIntArray sparseIntArray = IlO;
        sparseIntArray.put(this.pP, sparseIntArray.get(this.pP) + 1);
        this.bWL = 200;
        vSq vsq = this.zPa;
        if (vsq != null) {
            vsq.removeCallbacks(this.BS);
        }
        boolean z2 = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i8 == 1 || i8 == 700 || i8 == 800) {
            z2 = true;
        }
        if (z2) {
            h();
        }
        if (!this.lMM.get()) {
            return true;
        }
        this.lMM.set(false);
        com.bykv.vk.openvk.IlO.IlO.IlO.EO.b bVar = new com.bykv.vk.openvk.IlO.IlO.IlO.EO.b(i2, i8);
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().IlO(this, bVar);
            }
        }
        return true;
    }

    @Override // z.e
    public void IlO(h hVar) {
        this.bWL = Sdk.SDKError.Reason.INVALID_JSON_BID_PAYLOAD_VALUE;
        IlO.delete(this.pP);
        vSq vsq = this.zPa;
        if (vsq != null) {
            vsq.removeCallbacks(this.BS);
        }
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().IlO(this);
            }
        }
    }

    @Override // z.a
    public void IlO(h hVar, int i2, int i8, int i9, int i10) {
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().IlO((r.c) this, i2, i8);
            }
        }
    }

    public void IlO(r.b bVar) {
        if (bVar == null) {
            return;
        }
        for (WeakReference<r.b> weakReference : this.EO) {
            if (weakReference != null && weakReference.get() == bVar) {
                return;
            }
        }
        this.EO.add(new WeakReference<>(bVar));
    }

    public void IlO(int i2) {
        if (lEW()) {
            return;
        }
        this.dY = i2;
    }

    public boolean IlO(float f4) {
        PlaybackParams playbackParams;
        if (f4 <= 0.0f) {
            return false;
        }
        try {
            if (this.NV == null || !EO()) {
                return false;
            }
            try {
                playbackParams = ((j) this.NV).f17882i.getPlaybackParams();
            } catch (Throwable th) {
                oeT.EO("CSJ_VIDEO_MEDIA", "getPlaybackParams error:" + th.getMessage());
                playbackParams = null;
            }
            if ((playbackParams != null ? playbackParams.getSpeed() : 0.0f) == f4) {
                return true;
            }
            MediaPlayer mediaPlayer = ((j) this.NV).f17882i;
            mediaPlayer.setPlaybackParams(mediaPlayer.getPlaybackParams().setSpeed(f4));
            return true;
        } catch (Throwable th2) {
            oeT.IlO("CSJ_VIDEO_MEDIA", "setPlaySpeedRatio error: ", th2);
            return false;
        }
    }
}
