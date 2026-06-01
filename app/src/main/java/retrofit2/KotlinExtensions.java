package retrofit2;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.jvm.internal.k;
import q5.d;
import q5.x;
import q6.l;
import r2.q;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinExtensions {

    /* JADX INFO: renamed from: retrofit2.KotlinExtensions$suspendAndThrow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE}, m = "suspendAndThrow")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinExtensions.suspendAndThrow(null, this);
        }
    }

    public static final <T> Object await(final Call<T> call, v5.c<? super T> cVar) {
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        lVar.t(new e6.l() { // from class: retrofit2.KotlinExtensions$await$2$1
            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return x.f13520a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t3) {
                k.e(call2, "call");
                k.e(t3, "t");
                lVar.resumeWith(q.M(t3));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                k.e(call2, "call");
                k.e(response, "response");
                if (!response.isSuccessful()) {
                    lVar.resumeWith(q.M(new HttpException(response)));
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    lVar.resumeWith(tBody);
                    return;
                }
                Object objTag = call2.request().tag(Invocation.class);
                k.b(objTag);
                Invocation invocation = (Invocation) objTag;
                lVar.resumeWith(q.M(new d("Response from " + invocation.service().getName() + '.' + invocation.method().getName() + " was null but response body type was declared as non-null")));
            }
        });
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    public static final <T> Object awaitNullable(final Call<T> call, v5.c<? super T> cVar) {
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        lVar.t(new e6.l() { // from class: retrofit2.KotlinExtensions$await$4$1
            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return x.f13520a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t3) {
                k.e(call2, "call");
                k.e(t3, "t");
                lVar.resumeWith(q.M(t3));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                k.e(call2, "call");
                k.e(response, "response");
                if (response.isSuccessful()) {
                    lVar.resumeWith(response.body());
                } else {
                    lVar.resumeWith(q.M(new HttpException(response)));
                }
            }
        });
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    public static final <T> Object awaitResponse(final Call<T> call, v5.c<? super Response<T>> cVar) {
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        lVar.t(new e6.l() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$1
            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return x.f13520a;
            }

            public final void invoke(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t3) {
                k.e(call2, "call");
                k.e(t3, "t");
                lVar.resumeWith(q.M(t3));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                k.e(call2, "call");
                k.e(response, "response");
                lVar.resumeWith(response);
            }
        });
        Object objP = lVar.p();
        w5.a aVar = w5.a.f17774a;
        return objP;
    }

    public static final Object awaitUnit(Call<x> call, v5.c<? super x> cVar) {
        k.c(call, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return awaitNullable(call, cVar);
    }

    public static final <T> T create(Retrofit retrofit) {
        k.e(retrofit, "<this>");
        k.k();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object suspendAndThrow(final java.lang.Throwable r4, v5.c<?> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 == r3) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            java.lang.Object r4 = r0.L$0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r2.q.z0(r5)
            e2.s r4 = new e2.s
            r5 = 2
            r4.<init>(r5)
            throw r4
        L39:
            r2.q.z0(r5)
            r0.L$0 = r4
            r0.label = r3
            x6.e r5 = q6.m0.f13566a
            v5.h r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$2$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$2$1
            r3.<init>()
            r5.dispatch(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Throwable, v5.c):java.lang.Object");
    }
}
