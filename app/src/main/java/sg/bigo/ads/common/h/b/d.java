package sg.bigo.ads.common.h.b;

import android.content.Context;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f15766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f15767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f15768c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f15769d;

    public d(Context context, a aVar) {
        this.f15769d = context;
        this.f15766a = aVar;
        sg.bigo.ads.common.h.a aVar2 = aVar.f15761b;
        this.f15768c = new File(aVar2.f15729c, sg.bigo.ads.common.utils.f.c(aVar2.f15730d));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0079, code lost:
    
        if (r14 <= 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0083, code lost:
    
        if (r20.f15768c.length() != r14) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0089, code lost:
    
        if (r20.f15766a.e != r11) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
    
        r0 = r20.f15768c;
        r10 = r20.f15766a.f15761b;
        r0.renameTo(new java.io.File(r10.f15729c, r10.f15730d));
        r20.f15766a.e = sg.bigo.ads.common.h.b.h.f15778f;
        r9 = true;
        sg.bigo.ads.common.h.b.f.a().a(r20.f15766a.f15760a);
        a("download is over.");
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.h.b.d.a():void");
    }

    private void b(String str) {
        StringBuilder sbX = a1.a.x(str, " , ");
        sbX.append(this.f15766a.f15760a);
        sbX.append(" has a error ! ");
        sbX.append(this.f15766a.toString());
        sg.bigo.ads.common.t.a.a(0, "DownloadTask", sbX.toString());
        a aVar = this.f15766a;
        aVar.f15764f = str;
        aVar.e = h.g;
        f.a().a(this.f15766a.f15760a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0102, code lost:
    
        if (sg.bigo.ads.common.utils.f.c(r8.f15768c) != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0104, code lost:
    
        b("Failed to create temp file.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0109, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010a, code lost:
    
        r8.f15766a.e = sg.bigo.ads.common.h.b.h.f15776c;
        sg.bigo.ads.common.h.b.f.a().a(r8.f15766a.f15760a);
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x011e, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.common.h.b.d.run():void");
    }

    private void a(String str) {
        StringBuilder sbX = a1.a.x(str, ",taskId=");
        sbX.append(this.f15766a.f15760a);
        sbX.append(", downloadinfo = ");
        sbX.append(this.f15766a.toString());
        sg.bigo.ads.common.t.a.a(0, 3, "DownloadTask", sbX.toString());
    }
}
