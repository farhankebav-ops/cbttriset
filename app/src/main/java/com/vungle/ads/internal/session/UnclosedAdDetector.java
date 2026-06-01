package com.vungle.ads.internal.session;

import a.a;
import android.content.Context;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.executor.FutureResult;
import com.vungle.ads.internal.model.UnclosedAd;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.Logger;
import com.vungle.ads.internal.util.PathProvider;
import g7.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l6.t;
import n7.b;
import q5.j;
import r2.q;
import r5.r;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnclosedAdDetector {
    private static final String FILENAME = "unclosed_ad";
    private final Context context;
    private final Executors executors;
    private File file;
    private final PathProvider pathProvider;
    private boolean ready;
    private final String sessionId;
    private final CopyOnWriteArrayList<UnclosedAd> unclosedAdList;
    public static final Companion Companion = new Companion(null);
    private static final c json = a.b(UnclosedAdDetector$Companion$json$1.INSTANCE);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    public UnclosedAdDetector(Context context, String sessionId, Executors executors, PathProvider pathProvider) {
        Object objM;
        k.e(context, "context");
        k.e(sessionId, "sessionId");
        k.e(executors, "executors");
        k.e(pathProvider, "pathProvider");
        this.context = context;
        this.sessionId = sessionId;
        this.executors = executors;
        this.pathProvider = pathProvider;
        this.file = pathProvider.getUnclosedAdFile(FILENAME);
        this.unclosedAdList = new CopyOnWriteArrayList<>();
        boolean z2 = true;
        if (!this.file.exists()) {
            try {
                objM = Boolean.valueOf(this.file.createNewFile());
            } catch (Throwable th) {
                objM = q.M(th);
            }
            Throwable thA = q5.k.a(objM);
            if (thA != null) {
                Logger.Companion.e("UnclosedAdDetector", "Fail to create unclosed ad file: " + thA.getMessage());
            }
            z2 = true ^ (objM instanceof j);
        }
        this.ready = z2;
    }

    private final <T> T decodeJson(String str) {
        i7.f fVar = json.f11599b;
        k.k();
        throw null;
    }

    private final List<UnclosedAd> readUnclosedAdFromFile() {
        return !this.ready ? r.f13638a : (List) new FutureResult(this.executors.getIoExecutor().submit(new androidx.webkit.internal.c(this, 8))).get(1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: readUnclosedAdFromFile$lambda-4, reason: not valid java name */
    public static final List m3350readUnclosedAdFromFile$lambda4(UnclosedAdDetector this$0) {
        k.e(this$0, "this$0");
        try {
            String string = FileUtility.INSTANCE.readString(this$0.file);
            if (string != null && string.length() != 0) {
                c cVar = json;
                i7.f fVar = cVar.f11599b;
                int i2 = t.f12828c;
                t tVarZ = b.z(b0.b(UnclosedAd.class));
                c0 c0Var = b0.f12719a;
                e eVarA = b0.a(List.class);
                List listSingletonList = Collections.singletonList(tVarZ);
                c0Var.getClass();
                return (List) cVar.a(q.q0(fVar, c0.b(eVarA, listSingletonList)), string);
            }
            return new ArrayList();
        } catch (Exception e) {
            Logger.Companion.e("UnclosedAdDetector", "Fail to read unclosed ad file " + e.getMessage());
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: retrieveUnclosedAd$lambda-3, reason: not valid java name */
    public static final void m3351retrieveUnclosedAd$lambda3(UnclosedAdDetector this$0) {
        k.e(this$0, "this$0");
        try {
            FileUtility.deleteAndLogIfFailed(this$0.file);
        } catch (Exception e) {
            Logger.Companion.e("UnclosedAdDetector", "Fail to delete file " + e.getMessage());
        }
    }

    private final void writeUnclosedAdToFile(List<UnclosedAd> list) {
        if (this.ready) {
            try {
                c cVar = json;
                i7.f fVar = cVar.f11599b;
                int i2 = t.f12828c;
                t tVarZ = b.z(b0.b(UnclosedAd.class));
                c0 c0Var = b0.f12719a;
                e eVarA = b0.a(List.class);
                List listSingletonList = Collections.singletonList(tVarZ);
                c0Var.getClass();
                this.executors.getIoExecutor().execute(new com.unity3d.services.ads.operation.show.b(6, this, cVar.b(q.q0(fVar, c0.b(eVarA, listSingletonList)), list)));
            } catch (Throwable th) {
                Logger.Companion.e("UnclosedAdDetector", "Fail to write unclosed ad file " + th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: writeUnclosedAdToFile$lambda-5, reason: not valid java name */
    public static final void m3352writeUnclosedAdToFile$lambda5(UnclosedAdDetector this$0, String jsonContent) {
        k.e(this$0, "this$0");
        k.e(jsonContent, "$jsonContent");
        FileUtility.INSTANCE.writeString(this$0.file, jsonContent);
    }

    public final void addUnclosedAd(UnclosedAd ad) {
        k.e(ad, "ad");
        if (this.ready) {
            ad.setSessionId(this.sessionId);
            this.unclosedAdList.add(ad);
            writeUnclosedAdToFile(this.unclosedAdList);
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final Executors getExecutors() {
        return this.executors;
    }

    public final PathProvider getPathProvider() {
        return this.pathProvider;
    }

    public final void removeUnclosedAd(UnclosedAd ad) {
        k.e(ad, "ad");
        if (this.ready && this.unclosedAdList.contains(ad)) {
            this.unclosedAdList.remove(ad);
            writeUnclosedAdToFile(this.unclosedAdList);
        }
    }

    public final List<UnclosedAd> retrieveUnclosedAd() {
        ArrayList arrayList = new ArrayList();
        if (!this.ready) {
            return arrayList;
        }
        List<UnclosedAd> unclosedAdFromFile = readUnclosedAdFromFile();
        if (unclosedAdFromFile != null) {
            arrayList.addAll(unclosedAdFromFile);
        }
        this.executors.getIoExecutor().execute(new com.vungle.ads.internal.omsdk.a(this, 1));
        return arrayList;
    }
}
