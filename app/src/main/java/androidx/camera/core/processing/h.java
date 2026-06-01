package androidx.camera.core.processing;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.CancellationSignal;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.ump.ConsentInformation;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import com.mimikridev.ads.gdpr.GoogleMobileAdsConsentManager;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements CallbackToFutureAdapter.Resolver, CancellationSignal.OnCancelListener, Continuation, OnSuccessListener, ConsentInformation.OnConsentInfoUpdateSuccessListener, x0.b, w0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3714d;

    public /* synthetic */ h(Object obj, Object obj2, Object obj3, int i2) {
        this.f3711a = i2;
        this.f3714d = obj;
        this.f3712b = obj2;
        this.f3713c = obj3;
    }

    @Override // w0.g
    public Object apply(Object obj) throws Throwable {
        Cursor cursor;
        String str;
        long jInsert;
        s0.c cVar;
        int i2 = this.f3711a;
        String str2 = "bytes";
        int i8 = 5;
        int i9 = 4;
        int i10 = 3;
        s0.c cVar2 = s0.c.CACHE_FULL;
        int i11 = 2;
        Object obj2 = this.f3713c;
        Object obj3 = this.f3712b;
        int i12 = 0;
        w0.i iVar = (w0.i) this.f3714d;
        switch (i2) {
            case 10:
                ArrayList arrayList = (ArrayList) obj3;
                p0.k kVar = (p0.k) obj2;
                Cursor cursor2 = (Cursor) obj;
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(0);
                    boolean z2 = cursor2.getInt(7) != 0;
                    p0.i iVar2 = new p0.i();
                    iVar2.f13284f = new HashMap();
                    String string = cursor2.getString(1);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    iVar2.f13280a = string;
                    iVar2.f13283d = Long.valueOf(cursor2.getLong(i11));
                    iVar2.e = Long.valueOf(cursor2.getLong(3));
                    if (z2) {
                        String string2 = cursor2.getString(4);
                        iVar2.f13282c = new p0.n(string2 == null ? w0.i.f17669f : new m0.c(string2), cursor2.getBlob(5));
                        str = str2;
                    } else {
                        String string3 = cursor2.getString(4);
                        m0.c cVar3 = string3 == null ? w0.i.f17669f : new m0.c(string3);
                        Cursor cursorQuery = iVar.a().query("event_payloads", new String[]{str2}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList2 = new ArrayList();
                            int length = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList2.add(blob);
                                length += blob.length;
                                break;
                            }
                            byte[] bArr = new byte[length];
                            int i13 = 0;
                            int length2 = 0;
                            while (i13 < arrayList2.size()) {
                                byte[] bArr2 = (byte[]) arrayList2.get(i13);
                                String str3 = str2;
                                cursor = cursorQuery;
                                try {
                                    System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                                    length2 += bArr2.length;
                                    i13++;
                                    cursorQuery = cursor;
                                    str2 = str3;
                                } catch (Throwable th) {
                                    th = th;
                                    cursor.close();
                                    throw th;
                                }
                            }
                            str = str2;
                            cursorQuery.close();
                            iVar2.f13282c = new p0.n(cVar3, bArr);
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                        }
                    }
                    if (!cursor2.isNull(6)) {
                        iVar2.f13281b = Integer.valueOf(cursor2.getInt(6));
                    }
                    if (!cursor2.isNull(8)) {
                        iVar2.g = Integer.valueOf(cursor2.getInt(8));
                    }
                    if (!cursor2.isNull(9)) {
                        iVar2.h = cursor2.getString(9);
                    }
                    if (!cursor2.isNull(10)) {
                        iVar2.f13285i = cursor2.getBlob(10);
                    }
                    if (!cursor2.isNull(11)) {
                        iVar2.j = cursor2.getBlob(11);
                    }
                    arrayList.add(new w0.b(j, kVar, iVar2.b()));
                    str2 = str;
                    i11 = 2;
                }
                return null;
            case 11:
                p0.j jVar = (p0.j) obj3;
                p0.n nVar = jVar.f13288c;
                String str4 = jVar.f13286a;
                p0.k kVar2 = (p0.k) obj2;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                long jSimpleQueryForLong = iVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * iVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                w0.a aVar = iVar.f17673d;
                if (jSimpleQueryForLong >= aVar.f17656a) {
                    iVar.i(1L, cVar2, str4);
                    return -1L;
                }
                Long lB = w0.i.b(sQLiteDatabase, kVar2);
                if (lB != null) {
                    jInsert = lB.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", kVar2.f13292a);
                    contentValues.put(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, Integer.valueOf(z0.a.a(kVar2.f13294c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr3 = kVar2.f13293b;
                    if (bArr3 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr3, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i14 = aVar.e;
                byte[] bArr4 = nVar.f13301b;
                boolean z7 = bArr4.length <= i14;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str4);
                contentValues2.put("timestamp_ms", Long.valueOf(jVar.f13289d));
                contentValues2.put("uptime_ms", Long.valueOf(jVar.e));
                contentValues2.put("payload_encoding", nVar.f13300a.f12920a);
                contentValues2.put("code", jVar.f13287b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z7));
                contentValues2.put("payload", z7 ? bArr4 : new byte[0]);
                contentValues2.put("product_id", jVar.g);
                contentValues2.put("pseudonymous_id", jVar.h);
                contentValues2.put("experiment_ids_clear_blob", jVar.f13291i);
                contentValues2.put("experiment_ids_encrypted_blob", jVar.j);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z7) {
                    int iCeil = (int) Math.ceil(((double) bArr4.length) / ((double) i14));
                    for (int i15 = 1; i15 <= iCeil; i15++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, (i15 - 1) * i14, Math.min(i15 * i14, bArr4.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i15));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(jVar.f13290f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            default:
                HashMap map = (HashMap) obj3;
                j4.h hVar = (j4.h) obj2;
                ArrayList arrayList3 = (ArrayList) hVar.f12232b;
                Cursor cursor3 = (Cursor) obj;
                iVar.getClass();
                while (cursor3.moveToNext()) {
                    String string4 = cursor3.getString(i12);
                    int i16 = cursor3.getInt(1);
                    s0.c cVar4 = s0.c.REASON_UNKNOWN;
                    if (i16 != 0) {
                        if (i16 == 1) {
                            cVar4 = s0.c.MESSAGE_TOO_OLD;
                        } else if (i16 == 2) {
                            cVar = cVar2;
                        } else if (i16 == i10) {
                            cVar4 = s0.c.PAYLOAD_TOO_BIG;
                        } else if (i16 == i9) {
                            cVar4 = s0.c.MAX_RETRIES_REACHED;
                        } else if (i16 == i8) {
                            cVar4 = s0.c.INVALID_PAYLOD;
                        } else if (i16 == 6) {
                            cVar4 = s0.c.SERVER_ERROR;
                        } else {
                            a.a.t("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i16));
                        }
                        cVar = cVar4;
                    } else {
                        cVar = cVar4;
                    }
                    long j3 = cursor3.getLong(2);
                    if (!map.containsKey(string4)) {
                        map.put(string4, new ArrayList());
                    }
                    ((List) map.get(string4)).add(new s0.d(j3, cVar));
                    i12 = 0;
                    i8 = 5;
                    i9 = 4;
                    i10 = 3;
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    int i17 = s0.e.f13668c;
                    new ArrayList();
                    arrayList3.add(new s0.e((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                }
                long time = iVar.f17671b.getTime();
                SQLiteDatabase sQLiteDatabaseA = iVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                    try {
                        cursorRawQuery.moveToNext();
                        s0.g gVar = new s0.g(cursorRawQuery.getLong(0), time);
                        cursorRawQuery.close();
                        sQLiteDatabaseA.setTransactionSuccessful();
                        sQLiteDatabaseA.endTransaction();
                        hVar.f12231a = gVar;
                        hVar.f12233c = new s0.b(new s0.f(iVar.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * iVar.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), w0.a.f17655f.f17656a));
                        hVar.f12234d = (String) iVar.e.get();
                        return new s0.a((s0.g) hVar.f12231a, Collections.unmodifiableList(arrayList3), (s0.b) hVar.f12233c, (String) hVar.f12234d);
                    } catch (Throwable th3) {
                        cursorRawQuery.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    sQLiteDatabaseA.endTransaction();
                    throw th4;
                }
        }
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3711a) {
            case 0:
                return ((DefaultSurfaceProcessor) this.f3714d).lambda$initGlRenderer$10((DynamicRange) this.f3712b, (Map) this.f3713c, completer);
            case 1:
                return ((DualSurfaceProcessor) this.f3714d).lambda$initGlRenderer$6((DynamicRange) this.f3712b, (Map) this.f3713c, completer);
            default:
                return ExtensionsManager.lambda$getInstanceAsync$0((ClientVersion) this.f3714d, (Context) this.f3712b, (CameraProvider) this.f3713c, completer);
        }
    }

    @Override // x0.b
    public Object execute() {
        u0.a aVar = (u0.a) this.f3714d;
        p0.k kVar = (p0.k) this.f3712b;
        p0.j jVar = (p0.j) this.f3713c;
        w0.i iVar = (w0.i) aVar.f17520d;
        iVar.getClass();
        m0.e eVar = kVar.f13294c;
        String str = jVar.f13286a;
        String str2 = kVar.f13292a;
        String strH = a.a.H("SQLiteEventStore");
        if (Log.isLoggable(strH, 3)) {
            Log.d(strH, "Storing event with priority=" + eVar + ", name=" + str + " for destination " + str2);
        }
        ((Long) iVar.e(new h(iVar, jVar, kVar, 11))).longValue();
        aVar.f17517a.l(kVar, 1, false);
        return null;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.f3714d, (Transition) this.f3712b, (Runnable) this.f3713c);
    }

    @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
    public void onConsentInfoUpdateSuccess() {
        ((GoogleMobileAdsConsentManager) this.f3714d).lambda$gatherConsent$0((Activity) this.f3712b, (GoogleMobileAdsConsentManager.OnConsentGatheringCompleteListener) this.f3713c);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((RolloutsStateSubscriptionsHandler) this.f3714d).lambda$registerRolloutsStateSubscriber$1((Task) this.f3712b, (RolloutsStateSubscriber) this.f3713c, (ConfigContainer) obj);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f3711a) {
            case 4:
                return CrashlyticsTasks.lambda$race$0((TaskCompletionSource) this.f3714d, (AtomicBoolean) this.f3712b, (CancellationTokenSource) this.f3713c, task);
            case 5:
                return ((FirebaseRemoteConfig) this.f3714d).lambda$activate$2((Task) this.f3712b, (Task) this.f3713c, task);
            default:
                return ((ConfigRealtimeHttpClient) this.f3714d).lambda$createRealtimeConnection$0((Task) this.f3712b, (Task) this.f3713c, task);
        }
    }
}
