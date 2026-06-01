package c0;

import com.bytedance.sdk.component.MY.IlO.EO;
import com.bytedance.sdk.component.MY.IlO.MY;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements EO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4162b;

    public /* synthetic */ b(Object obj, long j) {
        this.f4162b = obj;
        this.f4161a = j;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.EO
    public void IlO(MY my, IOException iOException) {
        c cVar = (c) this.f4162b;
        c.a(cVar, cVar.f4164b, 601, iOException.getMessage());
        a.a(cVar.f4164b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:
    
        r0 = (c0.c) r19.f4162b;
        r3 = r0.f4164b;
        r4 = r21.EO();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        monitor-enter(t.a.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        r0 = r0.f4167f;
        r9 = r0.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d1, code lost:
    
        if (r6 >= r9) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:
    
        r11 = r0.get(r6);
        r6 = r6 + 1;
        r11 = (t.a) r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00db, code lost:
    
        if (r11 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00dd, code lost:
    
        r11.MY(r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
    
        monitor-exit(t.a.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e4, code lost:
    
        c0.c.b((c0.c) r19.f4162b, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f1, code lost:
    
        throw r0;
     */
    @Override // com.bytedance.sdk.component.MY.IlO.EO
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void IlO(com.bytedance.sdk.component.MY.IlO.MY r20, com.bytedance.sdk.component.MY.IlO.bWL r21) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.b.IlO(com.bytedance.sdk.component.MY.IlO.MY, com.bytedance.sdk.component.MY.IlO.bWL):void");
    }
}
