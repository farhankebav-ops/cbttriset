package com.unity3d.ads.core.domain.om;

import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.jvm.internal.k;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class AndroidOmStartSession extends AndroidOmInteraction {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.om.AndroidOmStartSession", f = "AndroidOmStartSession.kt", l = {18}, m = "invoke")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidOmStartSession.this.invoke(null, null, this);
        }
    }

    public AndroidOmStartSession(OpenMeasurementRepository openMeasurementRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        k.e(openMeasurementRepository, "openMeasurementRepository");
        k.e(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.openMeasurementRepository = openMeasurementRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.om.OmInteraction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object invoke(com.unity3d.ads.core.data.model.AdObject r12, org.json.JSONObject r13, v5.c<? super q5.x> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.om.AndroidOmStartSession.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r14
            com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1 r0 = (com.unity3d.ads.core.domain.om.AndroidOmStartSession.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1 r0 = new com.unity3d.ads.core.domain.om.AndroidOmStartSession$invoke$1
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r12 = r0.L$1
            com.unity3d.ads.core.data.model.AdObject r12 = (com.unity3d.ads.core.data.model.AdObject) r12
            java.lang.Object r13 = r0.L$0
            com.unity3d.ads.core.domain.om.AndroidOmStartSession r13 = (com.unity3d.ads.core.domain.om.AndroidOmStartSession) r13
            r2.q.z0(r14)
        L2e:
            r7 = r12
            goto L58
        L30:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L38:
            r2.q.z0(r14)
            com.unity3d.ads.core.data.repository.OpenMeasurementRepository r14 = r11.openMeasurementRepository
            com.google.protobuf.ByteString r2 = r12.getOpportunityId()
            android.webkit.WebView r4 = r11.getWebview(r12)
            com.unity3d.ads.core.data.model.OmidOptions r13 = r11.getOMidOptions(r13)
            r0.L$0 = r11
            r0.L$1 = r12
            r0.label = r3
            java.lang.Object r14 = r14.startSession(r2, r4, r13, r0)
            if (r14 != r1) goto L56
            return r1
        L56:
            r13 = r11
            goto L2e
        L58:
            com.unity3d.ads.core.data.model.OMResult r14 = (com.unity3d.ads.core.data.model.OMResult) r14
            boolean r12 = r14 instanceof com.unity3d.ads.core.data.model.OMResult.Success
            if (r12 == 0) goto L6d
            com.unity3d.ads.core.domain.SendDiagnosticEvent r2 = r13.sendDiagnosticEvent
            r9 = 46
            r10 = 0
            java.lang.String r3 = "om_session_start_success"
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto La1
        L6d:
            boolean r12 = r14 instanceof com.unity3d.ads.core.data.model.OMResult.Failure
            if (r12 == 0) goto La1
            com.unity3d.ads.core.domain.SendDiagnosticEvent r2 = r13.sendDiagnosticEvent
            s5.f r12 = new s5.f
            r12.<init>()
            com.unity3d.ads.core.data.model.OMResult$Failure r14 = (com.unity3d.ads.core.data.model.OMResult.Failure) r14
            java.lang.String r13 = r14.getReason()
            java.lang.String r0 = "reason"
            r12.put(r0, r13)
            java.lang.String r13 = r14.getReasonDebug()
            if (r13 == 0) goto L92
            java.lang.String r13 = "reason_debug"
            java.lang.String r14 = r14.getReasonDebug()
            r12.put(r13, r14)
        L92:
            s5.f r5 = r12.b()
            r9 = 42
            r10 = 0
            java.lang.String r3 = "om_session_start_failure"
            r4 = 0
            r6 = 0
            r8 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        La1:
            q5.x r12 = q5.x.f13520a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.om.AndroidOmStartSession.invoke(com.unity3d.ads.core.data.model.AdObject, org.json.JSONObject, v5.c):java.lang.Object");
    }
}
