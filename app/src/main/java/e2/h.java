package e2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import i4.a1;
import i4.b1;
import i4.m1;
import i4.n1;
import j4.l1;
import j4.t;
import j4.v;
import j4.x;
import j4.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
import javax.net.ssl.SSLSocket;
import t6.d1;
import t6.o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class h implements y, t6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f11231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f11233c;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3) {
        this.f11231a = obj;
        this.f11232b = obj2;
        this.f11233c = obj3;
    }

    public static Method h(Class cls, String str, Class[] clsArr) {
        if (cls != null) {
            try {
                if ((cls.getModifiers() & 1) == 0) {
                    return h(cls.getSuperclass(), str, clsArr);
                }
                Method method = cls.getMethod(str, clsArr);
                try {
                    if ((method.getModifiers() & 1) != 0) {
                        return method;
                    }
                } catch (NoSuchMethodException unused) {
                    return method;
                }
            } catch (NoSuchMethodException unused2) {
                return null;
            }
        }
        return null;
    }

    public void a(n1 n1Var, a1 a1Var) {
        v vVar = (v) this.f11233c;
        i4.r rVar = vVar.k.f11841a;
        vVar.h.getClass();
        if (rVar == null) {
            rVar = null;
        }
        if (n1Var.f11918a == m1.CANCELLED && rVar != null && rVar.isExpired()) {
            l1 l1Var = new l1(0);
            vVar.l.n(l1Var);
            n1Var = n1.h.b("ClientCall was cancelled at or after deadline. " + l1Var);
            a1Var = new a1();
        }
        r4.b.b();
        vVar.e.execute(new j4.s(this, n1Var, a1Var));
    }

    public Method b(Class cls) {
        Class cls2;
        Method methodH = h(cls, (String) this.f11231a, (Class[]) this.f11233c);
        if (methodH == null || (cls2 = (Class) this.f11232b) == null || cls2.isAssignableFrom(methodH.getReturnType())) {
            return methodH;
        }
        return null;
    }

    @Override // j4.y
    public void c(n1 n1Var, x xVar, a1 a1Var) {
        r4.b.c();
        try {
            r4.b.a();
            a(n1Var, a1Var);
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

    /* JADX WARN: Type inference failed for: r1v3, types: [e6.q, x5.i] */
    @Override // t6.e
    public Object collect(t6.f fVar, v5.c cVar) throws Throwable {
        u6.i iVar = new u6.i(new t6.e[]{(t6.e) this.f11231a, (d1) this.f11232b}, new o0((x5.i) this.f11233c, null), fVar, null);
        u6.k kVar = new u6.k(cVar, cVar.getContext());
        Object objQ = n7.b.Q(kVar, kVar, iVar);
        w5.a aVar = w5.a.f17774a;
        q5.x xVar = q5.x.f13520a;
        if (objQ != aVar) {
            objQ = xVar;
        }
        return objQ == aVar ? objQ : xVar;
    }

    @Override // j4.y
    public void f(a1 a1Var) {
        v vVar = (v) this.f11233c;
        r4.b.c();
        try {
            r4.b.a();
            r4.b.b();
            vVar.e.execute(new j4.r(this, a1Var));
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

    @Override // j4.y
    public void g(a4.a aVar) {
        v vVar = (v) this.f11233c;
        r4.b.c();
        try {
            r4.b.a();
            r4.b.b();
            vVar.e.execute(new j4.r(this, aVar));
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

    public Object i(SSLSocket sSLSocket, Object... objArr) {
        Method methodB = b(sSLSocket.getClass());
        if (methodB == null) {
            throw new AssertionError("Method " + ((String) this.f11231a) + " not supported for object " + sSLSocket);
        }
        try {
            return methodB.invoke(sSLSocket, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodB);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    public void j(SSLSocket sSLSocket, Object... objArr) {
        try {
            Method methodB = b(sSLSocket.getClass());
            if (methodB == null) {
                return;
            }
            try {
                methodB.invoke(sSLSocket, objArr);
            } catch (IllegalAccessException unused) {
            }
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public Object k(SSLSocket sSLSocket, Object... objArr) {
        try {
            return i(sSLSocket, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public void l(p0.s sVar, int i2, boolean z2) {
        char c7;
        v0.a aVar = (v0.a) this.f11233c;
        Context context = (Context) this.f11231a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
        p0.k kVar = (p0.k) sVar;
        adler32.update(kVar.f13292a.getBytes(Charset.forName(Key.STRING_CHARSET_NAME)));
        adler32.update(ByteBuffer.allocate(4).putInt(z0.a.a(kVar.f13294c)).array());
        byte[] bArr = kVar.f13293b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z2) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i8 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i8 >= i2) {
                        a.a.t("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", sVar);
                        return;
                    }
                }
            }
        }
        Cursor cursorRawQuery = ((w0.i) ((w0.d) this.f11232b)).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{kVar.f13292a, String.valueOf(z0.a.a(kVar.f13294c))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            p0.k kVar2 = (p0.k) sVar;
            m0.e eVar = kVar2.f13294c;
            builder.setMinimumLatency(aVar.a(eVar, jLongValue, i2));
            Set set = ((v0.b) aVar.f17567b.get(eVar)).f17570c;
            if (set.contains(v0.c.f17571a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(v0.c.f17573c)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(v0.c.f17572b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i2);
            persistableBundle.putString("backendName", kVar2.f13292a);
            persistableBundle.putInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, z0.a.a(eVar));
            byte[] bArr2 = kVar2.f13293b;
            if (bArr2 != null) {
                c7 = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr2, 0));
            } else {
                c7 = 0;
            }
            builder.setExtras(persistableBundle);
            Integer numValueOf = Integer.valueOf(value);
            Long lValueOf2 = Long.valueOf(aVar.a(eVar, jLongValue, i2));
            Integer numValueOf2 = Integer.valueOf(i2);
            Object[] objArr = new Object[5];
            objArr[c7] = sVar;
            objArr[1] = numValueOf;
            objArr[2] = lValueOf2;
            objArr[3] = lValueOf;
            objArr[4] = numValueOf2;
            String strH = a.a.H("JobInfoScheduler");
            if (Log.isLoggable(strH, 3)) {
                Log.d(strH, String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // j4.y
    public void o() {
        v vVar = (v) this.f11233c;
        b1 b1Var = (b1) vVar.f12495d.f11838c;
        b1Var.getClass();
        if (b1Var == b1.f11827a || b1Var == b1.f11828b) {
            return;
        }
        r4.b.c();
        try {
            r4.b.a();
            r4.b.b();
            vVar.e.execute(new t(this));
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

    public h(Class cls, String str, Class... clsArr) {
        this.f11232b = cls;
        this.f11231a = str;
        this.f11233c = clsArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(t6.e eVar, d1 d1Var, e6.q qVar) {
        this.f11231a = eVar;
        this.f11232b = d1Var;
        this.f11233c = (x5.i) qVar;
    }

    public h(URL url, o0.n nVar, String str) {
        this.f11232b = url;
        this.f11233c = nVar;
        this.f11231a = str;
    }
}
