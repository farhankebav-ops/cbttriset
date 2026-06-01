package com.unity3d.ads.core.domain.events;

import android.support.v4.media.g;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.OperativeEventJob;
import com.unity3d.ads.core.domain.work.UniversalRequestWorkerData;
import e6.p;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import java.util.UUID;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import t6.d1;
import t6.q0;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OperativeEventObserver {
    private final BackgroundWorker backgroundWorker;
    private final w defaultDispatcher;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final q0 isRunning;
    private final OperativeEventRepository operativeEventRepository;
    private final UniversalRequestDataSource universalRequestDataSource;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2", f = "OperativeEventObserver.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2", f = "OperativeEventObserver.kt", l = {40, 43}, m = "invokeSuspend")
        public static final class C02152 extends i implements p {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ OperativeEventObserver this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02152(OperativeEventObserver operativeEventObserver, c<? super C02152> cVar) {
                super(2, cVar);
                this.this$0 = operativeEventObserver;
            }

            @Override // x5.a
            public final c<x> create(Object obj, c<?> cVar) {
                C02152 c02152 = new C02152(this.this$0, cVar);
                c02152.L$0 = obj;
                return c02152;
            }

            @Override // e6.p
            public final Object invoke(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest, c<? super x> cVar) {
                return ((C02152) create(operativeEventRequest, cVar)).invokeSuspend(x.f13520a);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                String str;
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest = (OperativeEventRequestOuterClass.OperativeEventRequest) this.L$0;
                    UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                    UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.Companion;
                    UniversalRequestOuterClass.UniversalRequest.Payload.Builder builderNewBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                    k.d(builderNewBuilder, "newBuilder()");
                    UniversalRequestKt.PayloadKt.Dsl dsl_create = companion._create(builderNewBuilder);
                    dsl_create.setOperativeEvent(operativeEventRequest);
                    UniversalRequestOuterClass.UniversalRequest.Payload payload_build = dsl_create._build();
                    GetUniversalRequestForPayLoad getUniversalRequestForPayLoad = this.this$0.getUniversalRequestForPayLoad;
                    this.label = 1;
                    obj = getUniversalRequestForPayLoad.invoke(payload_build, this);
                    if (obj != aVar) {
                    }
                    return aVar;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) this.L$0;
                    q.z0(obj);
                    UniversalRequestWorkerData universalRequestWorkerData = new UniversalRequestWorkerData(str);
                    BackgroundWorker backgroundWorker = this.this$0.backgroundWorker;
                    Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                    k.d(constraintsBuild, "Builder()\n            .s…TED)\n            .build()");
                    OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(OperativeEventJob.class).setConstraints(constraintsBuild).setInputData(universalRequestWorkerData.invoke()).addTag(BackgroundWorker.TAG).build();
                    k.d(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…TAG)\n            .build()");
                    backgroundWorker.getWorkManager().enqueue(oneTimeWorkRequestBuild);
                    return x.f13520a;
                }
                q.z0(obj);
                String string = UUID.randomUUID().toString();
                k.d(string, "randomUUID().toString()");
                UniversalRequestDataSource universalRequestDataSource = this.this$0.universalRequestDataSource;
                byte[] byteArray = ((UniversalRequestOuterClass.UniversalRequest) obj).toByteArray();
                k.d(byteArray, "fullRequest.toByteArray()");
                ByteString byteString = ByteStringsKt.toByteString(byteArray);
                this.L$0 = string;
                this.label = 2;
                if (universalRequestDataSource.set(string, byteString, this) != aVar) {
                    str = string;
                    UniversalRequestWorkerData universalRequestWorkerData2 = new UniversalRequestWorkerData(str);
                    BackgroundWorker backgroundWorker2 = this.this$0.backgroundWorker;
                    Constraints constraintsBuild2 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                    k.d(constraintsBuild2, "Builder()\n            .s…TED)\n            .build()");
                    OneTimeWorkRequest oneTimeWorkRequestBuild2 = new OneTimeWorkRequest.Builder(OperativeEventJob.class).setConstraints(constraintsBuild2).setInputData(universalRequestWorkerData2.invoke()).addTag(BackgroundWorker.TAG).build();
                    k.d(oneTimeWorkRequestBuild2, "OneTimeWorkRequestBuilde…TAG)\n            .build()");
                    backgroundWorker2.getWorkManager().enqueue(oneTimeWorkRequestBuild2);
                    return x.f13520a;
                }
                return aVar;
            }
        }

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OperativeEventObserver.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            d1 d1Var;
            Object value;
            Boolean bool;
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            q0 q0Var = OperativeEventObserver.this.isRunning;
            do {
                d1Var = (d1) q0Var;
                value = d1Var.getValue();
                bool = (Boolean) value;
                bool.getClass();
            } while (!d1Var.g(value, Boolean.TRUE));
            boolean zBooleanValue = bool.booleanValue();
            x xVar = x.f13520a;
            if (zBooleanValue) {
                return xVar;
            }
            x0.o(new g(24, OperativeEventObserver.this.operativeEventRepository.getOperativeEvents(), new C02152(OperativeEventObserver.this, null)), c0.b(OperativeEventObserver.this.defaultDispatcher));
            return xVar;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OperativeEventObserver(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, w defaultDispatcher, OperativeEventRepository operativeEventRepository, UniversalRequestDataSource universalRequestDataSource, BackgroundWorker backgroundWorker) {
        k.e(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        k.e(defaultDispatcher, "defaultDispatcher");
        k.e(operativeEventRepository, "operativeEventRepository");
        k.e(universalRequestDataSource, "universalRequestDataSource");
        k.e(backgroundWorker, "backgroundWorker");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.defaultDispatcher = defaultDispatcher;
        this.operativeEventRepository = operativeEventRepository;
        this.universalRequestDataSource = universalRequestDataSource;
        this.backgroundWorker = backgroundWorker;
        this.isRunning = x0.c(Boolean.FALSE);
    }

    public final Object invoke(c<? super x> cVar) throws Throwable {
        Object objH = c0.H(new AnonymousClass2(null), this.defaultDispatcher, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }
}
