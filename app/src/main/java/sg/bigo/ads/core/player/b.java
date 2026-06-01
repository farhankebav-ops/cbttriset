package sg.bigo.ads.core.player;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.api.a.h;
import sg.bigo.ads.api.a.i;
import sg.bigo.ads.api.core.o;
import sg.bigo.ads.common.h.b;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.core.player.a;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements b.a, a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f17311a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public Context f17313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<o> f17314d;
    public List<o> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, a> f17315f;
    public sg.bigo.ads.common.h.b g;
    public sg.bigo.ads.core.player.a h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public sg.bigo.ads.common.h.a.a f17316i;
    private sg.bigo.ads.core.player.a.d k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f17312b = new AtomicBoolean(false);
    private long j = 0;

    public interface a {
        void a();

        void a(int i2);

        void a(String str, sg.bigo.ads.common.h.a aVar);

        void b(int i2);
    }

    private b() {
    }

    private static sg.bigo.ads.api.a.d a(@NonNull o oVar) {
        h hVar;
        if (!oVar.aR() || oVar.aS() || (hVar = i.f15457a) == null || hVar.r() == null) {
            return null;
        }
        return hVar.r();
    }

    private static sg.bigo.ads.core.player.a.d d() {
        sg.bigo.ads.common.h.b.a("start HttpProxyCacheServer ServerSocket", (sg.bigo.ads.common.h.a) null);
        return new sg.bigo.ads.core.player.a.d();
    }

    private void e() {
        if (System.currentTimeMillis() - this.j > 3600000) {
            c();
        }
    }

    public final sg.bigo.ads.core.player.a.d b() {
        sg.bigo.ads.core.player.a.d dVar = this.k;
        if (dVar != null) {
            return dVar;
        }
        sg.bigo.ads.core.player.a.d dVarD = d();
        this.k = dVarD;
        return dVarD;
    }

    public final void c() {
        this.j = System.currentTimeMillis();
        sg.bigo.ads.common.h.b.a("start resource delete task", (sg.bigo.ads.common.h.a) null);
        sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.3
            @Override // java.lang.Runnable
            public final void run() {
                b.b(b.this);
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }

    private static sg.bigo.ads.common.h.a a(Context context, String str, String str2, @NonNull o oVar, sg.bigo.ads.api.a.d dVar) {
        if (dVar == null) {
            return new sg.bigo.ads.common.h.a(str, oVar.a(context), str2, oVar.aR(), oVar.al(), oVar.aS(), null);
        }
        return new sg.bigo.ads.common.h.a(str, oVar.a(context), str2, oVar.aR(), oVar.al(), false, new sg.bigo.ads.common.h.c(dVar.a(oVar.v(), oVar.x()), dVar.c(oVar.x()), dVar.a(oVar.x()), dVar.b(oVar.x()), dVar.d(oVar.x())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, @NonNull o oVar, a aVar) {
        String strAP = oVar.aP();
        String strAQ = oVar.aQ();
        sg.bigo.ads.common.h.a aVarA = a(context, strAP, strAQ, oVar, a(oVar));
        if (aVarA.c()) {
            sg.bigo.ads.common.t.a.a(0, 3, "DownloadInfo", "info SupportFillTime: " + aVarA.toString());
            this.e.add(oVar);
        }
        boolean z2 = i.f15457a.n().a(9) && URLUtil.isHttpUrl(strAP);
        if (z2) {
            sg.bigo.ads.core.d.b.a((sg.bigo.ads.api.core.c) oVar, strAP, "Invalid http url", 0L, 0L, 2, "", false);
        }
        if (!z2 && !q.a((CharSequence) strAP) && !q.a((CharSequence) strAQ)) {
            this.f17314d.add(oVar);
            this.f17315f.put(oVar.aJ(), aVar);
            sg.bigo.ads.common.h.b.a("downloadMedia", aVarA);
            this.g.a(aVarA, false);
            this.h.a(aVarA);
            return;
        }
        oVar.i(5);
        if (!aVarA.c()) {
            aVar.b(z2 ? 10118 : 10103);
            return;
        }
        aVar.a();
        this.f17315f.put(oVar.aJ(), aVar);
        this.h.c(aVarA);
    }

    @Override // sg.bigo.ads.core.player.a.c
    public final void c(sg.bigo.ads.common.h.a aVar) {
        sg.bigo.ads.common.h.b.a("callback download check Process source=", aVar);
        int iG = aVar.g();
        long j = aVar.f15732i;
        if (j > 0 && aVar.g * 100 >= j * ((long) iG)) {
            sg.bigo.ads.common.h.b.a("video download process is enough. download percent: " + aVar.g + ", total size:" + aVar.f15732i, aVar);
            return;
        }
        sg.bigo.ads.common.h.b.a("video download process is not enough. download size: " + aVar.g + ", total size:" + aVar.f15732i + ", begin to download backup", aVar);
        boolean zA = q.a((CharSequence) aVar.p);
        for (o oVar : this.f17314d) {
            if (a(oVar, aVar)) {
                if (!zA) {
                    oVar.d(aVar.p);
                }
                a aVar2 = this.f17315f.get(oVar.aJ());
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        }
    }

    @Override // sg.bigo.ads.core.player.a.c
    public final void b(sg.bigo.ads.common.h.a aVar) {
        sg.bigo.ads.common.h.b.a("callback download fill time source=", aVar);
        sg.bigo.ads.common.h.b.a("callback download fill time", aVar);
        Iterator<o> it = this.e.iterator();
        boolean zA = q.a((CharSequence) aVar.p);
        while (it.hasNext()) {
            o next = it.next();
            if (a(next, aVar)) {
                if (!zA) {
                    next.d(aVar.p);
                }
                next.i(2);
                a aVar2 = this.f17315f.get(next.aJ());
                if (aVar2 != null) {
                    aVar2.a("", aVar);
                    if (aVar.f15728b == null) {
                        this.f17315f.remove(next.aJ());
                    }
                }
                it.remove();
            }
        }
        e();
    }

    public static b a() {
        return f17311a;
    }

    public static /* synthetic */ void b(b bVar) {
        bVar.a(new File(sg.bigo.ads.common.o.b(bVar.f17313c)));
        bVar.a(new File(sg.bigo.ads.common.o.c(bVar.f17313c)));
    }

    public final void a(final Context context, @NonNull final o oVar, final a aVar) {
        if (!this.f17312b.get()) {
            sg.bigo.ads.common.h.b.a("please execute initAdResource first", (sg.bigo.ads.common.h.a) null);
        } else if (sg.bigo.ads.common.n.d.a()) {
            b(context, oVar, aVar);
        } else {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(context, oVar, aVar);
                }
            });
        }
    }

    private void a(File file) {
        sg.bigo.ads.common.h.b.a("filterAdFiles dir = " + file.getAbsolutePath(), (sg.bigo.ads.common.h.a) null);
        if (file.exists()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strD = sg.bigo.ads.common.o.d(this.f17313c);
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: sg.bigo.ads.core.player.b.4
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file2, File file3) {
                    long jLastModified = file2.lastModified() - file3.lastModified();
                    if (jLastModified > 0) {
                        return -1;
                    }
                    return jLastModified == 0 ? 0 : 1;
                }
            });
            int i2 = 0;
            while (i2 < fileArrListFiles.length) {
                File file2 = fileArrListFiles[i2];
                sg.bigo.ads.common.h.a.a aVar = this.f17316i;
                long jLastModified = file2.lastModified();
                int iA = aVar.a();
                boolean z2 = aVar.f15743d + jLastModified < jCurrentTimeMillis || i2 >= iA;
                sg.bigo.ads.common.t.a.a(0, 3, "DownloadConfig", "needDelete lastModifiedTs=" + jLastModified + ", numTmp=" + iA);
                if (z2) {
                    sg.bigo.ads.common.h.b.a("delete expired file name = " + file2.getName(), (sg.bigo.ads.common.h.a) null);
                    File file3 = new File(strD, file2.getName());
                    if (file3.exists()) {
                        sg.bigo.ads.common.h.b.a("delete expired cover name = " + file2.getName(), (sg.bigo.ads.common.h.a) null);
                        file3.delete();
                    }
                    file2.delete();
                }
                i2++;
            }
        }
    }

    public final void a(final String str, final ValueCallback<Boolean> valueCallback) {
        if (this.f17312b.get()) {
            sg.bigo.ads.common.n.d.a(1, new Runnable() { // from class: sg.bigo.ads.core.player.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    ValueCallback valueCallback2 = valueCallback;
                    sg.bigo.ads.common.h.b bVar = b.this.g;
                    String str2 = str;
                    valueCallback2.onReceiveValue(Boolean.valueOf(sg.bigo.ads.common.h.b.a(bVar.f15744a, str2) || sg.bigo.ads.common.h.b.a(bVar.f15746c, str2)));
                }
            });
        } else {
            valueCallback.onReceiveValue(Boolean.FALSE);
        }
    }

    @Override // sg.bigo.ads.common.h.b.a
    public final void a(sg.bigo.ads.common.h.a aVar) {
        Iterator<o> it = this.f17314d.iterator();
        boolean zA = q.a((CharSequence) aVar.p);
        while (!zA && it.hasNext()) {
            o next = it.next();
            if (a(next, aVar)) {
                next.d(aVar.p);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0291  */
    @Override // sg.bigo.ads.common.h.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sg.bigo.ads.common.h.a r28, int r29, long r30) {
        /*
            Method dump skipped, instruction units count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.b.a(sg.bigo.ads.common.h.a, int, long):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    @Override // sg.bigo.ads.common.h.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(sg.bigo.ads.common.h.a r17, java.lang.String r18, long r19, long r21) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.core.player.b.a(sg.bigo.ads.common.h.a, java.lang.String, long, long):void");
    }

    private boolean a(o oVar, sg.bigo.ads.common.h.a aVar) {
        return TextUtils.equals(oVar.b(this.f17313c), aVar.a());
    }
}
