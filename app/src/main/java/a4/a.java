package a4;

import android.os.ParcelFileDescriptor;
import android.view.View;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.sdk.component.MY.IlO.EO;
import com.bytedance.sdk.component.MY.IlO.MY;
import com.bytedance.sdk.component.MY.IlO.bWL;
import com.bytedance.sdk.component.MY.IlO.ea;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.inappmessaging.internal.InAppMessageStreamManager;
import com.vungle.ads.internal.protos.Sdk;
import e5.h;
import e6.l;
import g7.b0;
import g7.m;
import h7.p;
import i4.a1;
import i4.c1;
import i7.g;
import j4.l1;
import j4.q2;
import j4.x2;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import r2.q;
import s4.j;
import s4.r;
import t6.e;
import w1.f;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements u3.b, OnCompleteListener, EO, OnUserEarnedRewardListener, s4.b, OnApplyWindowInsetsListener, j, x4.c, r, h1.b, g, x2, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f3216b;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f3215a = i2;
        this.f3216b = obj2;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.EO
    public void IlO(MY my, IOException iOException) {
        b0.c.b((b0.c) this.f3216b, 30000, iOException.getMessage());
    }

    @Override // s4.b, s4.j, s4.r
    public void a(u4.b bVar) {
        switch (this.f3215a) {
            case 6:
                ((s4.b) this.f3216b).a(bVar);
                break;
            case 7:
                ((b5.b) ((android.support.v4.media.g) this.f3216b).f3264c).c(bVar);
                break;
            case 8:
            default:
                ((r) this.f3216b).a(bVar);
                break;
            case 9:
                y4.a.e((e5.b) this.f3216b, bVar);
                break;
        }
    }

    @Override // x4.c
    public Object apply(Object obj) {
        Object objApply = ((f) ((h) this.f3216b).f11273c).apply(new Object[]{obj});
        z4.b.a(objApply, "The zipper returned a null value");
        return objApply;
    }

    @Override // i7.g
    public void b(l6.c cVar, b7.c serializer) {
        k.e(serializer, "serializer");
        ((c1) this.f3216b).l(cVar, new i7.a(serializer), true);
    }

    @Override // i7.g
    public void c(l6.c cVar, l lVar) {
        ((c1) this.f3216b).j(cVar, lVar, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fc  */
    /* JADX WARN: Type inference failed for: r9v11, types: [e6.p, x5.i] */
    @Override // t6.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(t6.f r9, v5.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.a.collect(t6.f, v5.c):java.lang.Object");
    }

    @Override // i7.g
    public void f(l6.c cVar, l lVar) {
        ((c1) this.f3216b).i(cVar, lVar, true);
    }

    @Override // i7.g
    public void g(l6.c kClass, l lVar) {
        k.e(kClass, "kClass");
        ((c1) this.f3216b).l(kClass, new i7.b(lVar), true);
    }

    @Override // i7.g
    public void h(l6.c cVar, l6.c cVar2, b7.c cVar3) {
        ((c1) this.f3216b).k(cVar, cVar2, cVar3, true);
    }

    public Object i(d7.g descriptor, p pVar) {
        k.e(descriptor, "descriptor");
        Map map = (Map) ((ConcurrentHashMap) this.f3216b).get(descriptor);
        Object obj = map != null ? map.get(pVar) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public FileChannel j() throws IOException {
        switch (this.f3215a) {
            case 22:
                return new FileInputStream((File) this.f3216b).getChannel();
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) this.f3216b;
                if (parcelFileDescriptor.getStatSize() != -1) {
                    return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor).getChannel();
                }
                parcelFileDescriptor.close();
                throw new IllegalArgumentException("Not a file: " + parcelFileDescriptor);
        }
    }

    public InputStream k() {
        InputStream inputStream = (InputStream) this.f3216b;
        this.f3216b = null;
        return inputStream;
    }

    public m l(String key, b0 element) {
        k.e(key, "key");
        k.e(element, "element");
        return (m) ((LinkedHashMap) this.f3216b).put(key, element);
    }

    public void m(boolean z2) {
        q2 q2Var = (q2) this.f3216b;
        q2Var.Y.c(q2Var.E, z2);
    }

    public void n(a1 a1Var, byte[] bArr) {
        r4.b.c();
        try {
            String str = "/" + ((String) ((k4.k) this.f3216b).j.f11839d);
            if (bArr != null) {
                ((k4.k) this.f3216b).f12654q = true;
                str = str + "?" + g2.e.f11586d.c(bArr);
            }
            synchronized (((k4.k) this.f3216b).f12652n.f12648w) {
                k4.j.k(((k4.k) this.f3216b).f12652n, a1Var, str);
            }
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // u3.b
    public void onAdLoaded() {
        switch (this.f3215a) {
            case 0:
                b bVar = (b) this.f3216b;
                ((d) bVar.f3219c).f3224b.put(((u3.c) bVar.f3218b).f17527a, (c4.f) bVar.f3220d);
                break;
            default:
                b bVar2 = (b) this.f3216b;
                ((d) bVar2.f3219c).f3224b.put(((u3.c) bVar2.f3218b).f17527a, (c4.f) bVar2.f3220d);
                break;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        AppBarLayout appBarLayout = (AppBarLayout) this.f3216b;
        WindowInsetsCompat windowInsetsCompat2 = appBarLayout.getFitsSystemWindows() ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(appBarLayout.g, windowInsetsCompat2)) {
            appBarLayout.g = windowInsetsCompat2;
            appBarLayout.setWillNotDraw(!(appBarLayout.f5235w != null && appBarLayout.getTopInset() > 0));
            appBarLayout.requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // s4.b, s4.j
    public void onComplete() {
        switch (this.f3215a) {
            case 6:
                ((s4.b) this.f3216b).onComplete();
                break;
            case 7:
                ((s4.b) ((android.support.v4.media.g) this.f3216b).f3263b).onComplete();
                break;
            default:
                ((j) ((e5.b) this.f3216b).f11257b).onComplete();
                break;
        }
    }

    @Override // s4.b, s4.j, s4.r
    public void onError(Throwable th) {
        switch (this.f3215a) {
            case 6:
                ((s4.b) this.f3216b).onComplete();
                break;
            case 7:
                ((s4.b) ((android.support.v4.media.g) this.f3216b).f3263b).onError(th);
                break;
            case 8:
            default:
                try {
                    InAppMessageStreamManager.lambda$createFirebaseInAppMessageStream$7(th);
                } catch (Throwable th2) {
                    q.y0(th2);
                    th = new v4.b(th, th2);
                }
                ((r) this.f3216b).onError(th);
                break;
            case 9:
                ((j) ((e5.b) this.f3216b).f11257b).onError(th);
                break;
        }
    }

    @Override // s4.j, s4.r
    public void onSuccess(Object obj) {
        switch (this.f3215a) {
            case 9:
                ((j) ((e5.b) this.f3216b).f11257b).onSuccess(obj);
                break;
            default:
                ((r) this.f3216b).onSuccess(obj);
                break;
        }
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(RewardItem rewardItem) {
        ((c4.k) this.f3216b).f4200c.onUserEarnedReward();
    }

    public String toString() {
        switch (this.f3215a) {
            case 21:
                StringBuilder sb = new StringBuilder();
                String[] strArr = (String[]) this.f3216b;
                int length = strArr.length / 2;
                for (int i2 = 0; i2 < length; i2++) {
                    int i8 = i2 * 2;
                    String str = null;
                    sb.append((i8 < 0 || i8 >= strArr.length) ? null : strArr[i8]);
                    sb.append(": ");
                    int i9 = i8 + 1;
                    if (i9 >= 0 && i9 < strArr.length) {
                        str = strArr[i9];
                    }
                    sb.append(str);
                    sb.append("\n");
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(int i2, boolean z2) {
        this.f3215a = i2;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.EO
    public void IlO(MY my, bWL bwl) {
        ea eaVarVCE;
        Object obj;
        boolean z2;
        if (bwl == null) {
            b0.c.b((b0.c) this.f3216b, Sdk.SDKError.Reason.AD_INTERNAL_INTEGRATION_ERROR_VALUE, "response is empty");
            return;
        }
        InputStream inputStreamEO = null;
        try {
            try {
                ((b0.c) this.f3216b).h = bwl.tV();
                if (((b0.c) this.f3216b).h) {
                    eaVarVCE = bwl.vCE();
                    try {
                        if (((b0.c) this.f3216b).h && eaVarVCE != null) {
                            ((b0.c) this.f3216b).f4120a = eaVarVCE.IlO() + ((b0.c) this.f3216b).e;
                            inputStreamEO = eaVarVCE.EO();
                        }
                        if (inputStreamEO == null) {
                            b0.c.b((b0.c) this.f3216b, Sdk.SDKError.Reason.CONFIG_NOT_FOUND_ERROR_VALUE, "input_stream is empty");
                            if (inputStreamEO != null) {
                                inputStreamEO.close();
                            }
                            if (eaVarVCE != null) {
                                eaVarVCE.close();
                            }
                            bwl.close();
                            if (((b0.c) this.f3216b).h && ((b0.c) this.f3216b).f4122c.length() == ((b0.c) this.f3216b).f4120a) {
                                obj = this.f3216b;
                                b0.c.c((b0.c) obj);
                            }
                            return;
                        }
                        byte[] bArr = new byte[8192];
                        long j = ((b0.c) this.f3216b).e;
                        long j3 = 0;
                        loop0: while (true) {
                            int i2 = 0;
                            do {
                                int i8 = inputStreamEO.read(bArr, i2, 8192 - i2);
                                if (i8 == -1) {
                                    break loop0;
                                }
                                i2 += i8;
                                j3 += (long) i8;
                                z2 = j3 % 8192 == 0 || j3 == ((b0.c) this.f3216b).f4120a - ((b0.c) this.f3216b).e;
                                ((b0.c) this.f3216b).j.cl();
                                ((b0.c) this.f3216b).j.zPa();
                            } while (!z2);
                            synchronized (((b0.c) this.f3216b).f4121b) {
                                RandomAccessFile randomAccessFile = ((b0.c) this.f3216b).f4125i;
                                int iIntValue = Long.valueOf(j).intValue();
                                ((b0.c) this.f3216b).j.cl();
                                try {
                                    randomAccessFile.seek(iIntValue);
                                    randomAccessFile.write(bArr, 0, i2);
                                } catch (Throwable unused) {
                                }
                            }
                            j += (long) i2;
                        }
                        ((b0.c) this.f3216b).j.zPa();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            b0.c.b((b0.c) this.f3216b, Sdk.SDKError.Reason.AD_PUBLISHER_MISMATCH_VALUE, th.getMessage());
                            if (inputStreamEO != null) {
                                inputStreamEO.close();
                            }
                            if (eaVarVCE != null) {
                                eaVarVCE.close();
                            }
                            bwl.close();
                            if (((b0.c) this.f3216b).h && ((b0.c) this.f3216b).f4122c.length() == ((b0.c) this.f3216b).f4120a) {
                                b0.c.c((b0.c) this.f3216b);
                                return;
                            }
                            return;
                        } catch (Throwable th2) {
                            if (inputStreamEO != null) {
                                try {
                                    inputStreamEO.close();
                                } catch (Throwable unused2) {
                                    throw th2;
                                }
                            }
                            if (eaVarVCE != null) {
                                eaVarVCE.close();
                            }
                            bwl.close();
                            if (((b0.c) this.f3216b).h && ((b0.c) this.f3216b).f4122c.length() == ((b0.c) this.f3216b).f4120a) {
                                b0.c.c((b0.c) this.f3216b);
                            }
                            throw th2;
                        }
                    }
                } else {
                    b0.c.b((b0.c) this.f3216b, bwl.EO(), bwl.Cc());
                    eaVarVCE = null;
                }
                if (inputStreamEO != null) {
                    inputStreamEO.close();
                }
                if (eaVarVCE != null) {
                    eaVarVCE.close();
                }
                bwl.close();
                if (((b0.c) this.f3216b).h && ((b0.c) this.f3216b).f4122c.length() == ((b0.c) this.f3216b).f4120a) {
                    obj = this.f3216b;
                    b0.c.c((b0.c) obj);
                }
            } catch (Throwable th3) {
                th = th3;
                eaVarVCE = null;
            }
        } catch (Throwable unused3) {
        }
    }

    public /* synthetic */ a(Object obj, int i2) {
        this.f3215a = i2;
        this.f3216b = obj;
    }

    public a(l1 l1Var) {
        this.f3215a = 21;
        ArrayList arrayList = l1Var.f12300b;
        this.f3216b = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        q6.l lVar = (q6.l) this.f3216b;
        Exception exception = task.getException();
        if (exception == null) {
            if (task.isCanceled()) {
                lVar.e(null);
                return;
            } else {
                lVar.resumeWith(task.getResult());
                return;
            }
        }
        lVar.resumeWith(q.M(exception));
    }

    public a(int i2) {
        this.f3215a = i2;
        switch (i2) {
            case 14:
                this.f3216b = new ConcurrentHashMap(16);
                break;
            default:
                this.f3216b = new LinkedHashMap();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(e6.p pVar) {
        this.f3215a = 27;
        this.f3216b = (i) pVar;
    }
}
