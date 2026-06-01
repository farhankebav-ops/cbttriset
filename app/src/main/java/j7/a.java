package j7;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers;
import com.google.firebase.inappmessaging.internal.injection.modules.ProgrammaticContextualTriggerFlowableModule;
import com.google.firebase.inappmessaging.internal.injection.modules.TransportClientModule;
import com.ironsource.G5;
import e2.h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import n0.c;
import o0.n;
import o0.w;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal._UtilJvmKt;
import p0.s;
import p0.u;
import s4.e;
import s4.f;
import w0.d;
import w0.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements EventListener.Factory, OnCompleteListener, f, ProgramaticContextualTriggers.Listener, MetricsLoggerClient.EngagementMetricsLoggerInterface, x0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12592b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f12591a = i2;
        this.f12592b = obj;
    }

    public n0.b a(h hVar) throws IOException {
        c cVar = (c) this.f12592b;
        URL url = (URL) hVar.f11232b;
        String strH = a.a.H("CctTransportBackend");
        if (Log.isLoggable(strH, 4)) {
            Log.i(strH, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", G5.L);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) hVar.f11231a;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    cVar.f13049a.encode((n) hVar.f11233c, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    String strH2 = a.a.H("CctTransportBackend");
                    if (Log.isLoggable(strH2, 4)) {
                        Log.i(strH2, String.format("Status Code: %d", numValueOf));
                    }
                    a.a.t("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    a.a.t("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new n0.b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new n0.b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            n0.b bVar = new n0.b(responseCode, null, w.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f13181a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (EncodingException e) {
            e = e;
            a.a.w("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new n0.b(400, null, 0L);
        } catch (ConnectException e4) {
            e = e4;
            a.a.w("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new n0.b(500, null, 0L);
        } catch (UnknownHostException e8) {
            e = e8;
            a.a.w("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new n0.b(500, null, 0L);
        } catch (IOException e9) {
            e = e9;
            a.a.w("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new n0.b(400, null, 0L);
        }
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return _UtilJvmKt.asFactory$lambda$9((EventListener) this.f12592b, call);
    }

    @Override // x0.b
    public Object execute() {
        SQLiteDatabase sQLiteDatabaseA;
        int i2 = this.f12591a;
        Object obj = this.f12592b;
        switch (i2) {
            case 6:
                i iVar = (i) ((v0.f) obj).f17586i;
                sQLiteDatabaseA = iVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + iVar.f17671b.getTime()).execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return null;
                } finally {
                }
            case 7:
                i iVar2 = (i) ((w0.c) obj);
                iVar2.getClass();
                int i8 = s0.a.e;
                j4.h hVar = new j4.h();
                hVar.f12231a = null;
                hVar.f12232b = new ArrayList();
                hVar.f12233c = null;
                hVar.f12234d = "";
                HashMap map = new HashMap();
                sQLiteDatabaseA = iVar2.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    s0.a aVar = (s0.a) i.l(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new androidx.camera.core.processing.h(iVar2, map, hVar, 12));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return aVar;
                } finally {
                }
            case 8:
                i iVar3 = (i) ((d) obj);
                long time = iVar3.f17671b.getTime() - iVar3.f17673d.f17659d;
                sQLiteDatabaseA = iVar3.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(time)};
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            iVar3.i(cursorRawQuery.getInt(0), s0.c.MESSAGE_TOO_OLD, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", strArr);
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    return Integer.valueOf(iDelete);
                } finally {
                }
            default:
                j4.h hVar2 = (j4.h) obj;
                sQLiteDatabaseA = ((i) ((d) hVar2.f12232b)).a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    List list = (List) i.l(sQLiteDatabaseA.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new com.mimikridev.utilmanager.config.b(11));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((h) hVar2.f12233c).l((s) it.next(), 1, false);
                    }
                    return null;
                } finally {
                }
        }
    }

    @Override // com.google.firebase.inappmessaging.internal.MetricsLoggerClient.EngagementMetricsLoggerInterface
    public void logEvent(byte[] bArr) {
        TransportClientModule.lambda$providesMetricsLoggerClient$1((u) this.f12592b, bArr);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        ((ImageProxy) this.f12592b).close();
    }

    @Override // com.google.firebase.inappmessaging.internal.ProgramaticContextualTriggers.Listener
    public void onEventTrigger(String str) {
        ((e) this.f12592b).b(str);
    }

    @Override // s4.f
    public void subscribe(e eVar) throws Exception {
        ((ProgrammaticContextualTriggerFlowableModule) this.f12592b).lambda$providesProgramaticContextualTriggerStream$1((d5.i) eVar);
    }
}
