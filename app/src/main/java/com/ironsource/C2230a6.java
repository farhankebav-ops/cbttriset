package com.ironsource;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.ironsource.Y5;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.a6, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2230a6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f7955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2390j5 f7956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Z5 f7957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pb f7958d;
    private final B7 e = Mb.U().i();

    public C2230a6(Context context, C2390j5 c2390j5, Z5 z52, Pb pb) {
        this.f7955a = context;
        this.f7956b = c2390j5;
        this.f7957c = z52;
        this.f7958d = pb;
    }

    public void b(C8 c8) throws Exception {
        if (c8.exists()) {
            ArrayList<C8> filesInFolderRecursive = IronSourceStorageUtils.getFilesInFolderRecursive(c8);
            if (!IronSourceStorageUtils.deleteFolderContentRecursive(c8) || !c8.delete()) {
                throw new Exception("Failed to delete folder");
            }
            this.f7958d.a(filesInFolderRecursive);
        }
    }

    public JSONObject c(C8 c8) throws Exception {
        if (c8.exists()) {
            return IronSourceStorageUtils.buildFilesMapOfDirectory(c8, this.f7958d.b());
        }
        throw new Exception("Folder does not exist");
    }

    public long d(C8 c8) throws Exception {
        if (c8.exists()) {
            return IronSourceStorageUtils.getTotalSizeOfDir(c8);
        }
        throw new Exception("Folder does not exist");
    }

    public void a(C8 c8, String str, int i2, int i8, Pc pc) throws Exception {
        if (TextUtils.isEmpty(str)) {
            throw new Exception(Y5.a.f7830a);
        }
        if (this.e.a(this.f7956b.a()) <= 0) {
            throw new Exception(C2336g4.A);
        }
        if (!C2228a4.h(this.f7955a)) {
            throw new Exception(C2336g4.C);
        }
        this.f7957c.a(c8.getPath(), new a(pc));
        if (!c8.exists()) {
            this.f7956b.a(c8, str, i2, i8, this.f7957c);
            return;
        }
        Message message = new Message();
        message.obj = c8;
        message.what = 1015;
        this.f7957c.sendMessage(message);
    }

    /* JADX INFO: renamed from: com.ironsource.a6$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements Pc {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Pc f7959a;

        /* JADX INFO: renamed from: com.ironsource.a6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class C0167a extends JSONObject {
            public C0167a() throws JSONException {
                put("lastReferencedTime", System.currentTimeMillis());
            }
        }

        public a(Pc pc) {
            this.f7959a = pc;
        }

        @Override // com.ironsource.Pc
        public void a(C8 c8) {
            this.f7959a.a(c8);
            try {
                C2230a6.this.f7958d.a(c8.getName(), new C0167a());
            } catch (Exception e) {
                C2531r4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.ironsource.Pc
        public void a(C8 c8, C2586u8 c2586u8) {
            this.f7959a.a(c8, c2586u8);
        }
    }

    public void a(C8 c8) throws Exception {
        if (c8.exists()) {
            if (c8.delete()) {
                this.f7958d.a(c8.getName());
                return;
            }
            throw new Exception("Failed to delete file");
        }
    }

    public void a(C8 c8, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            if (c8.exists()) {
                if (!this.f7958d.b(c8.getName(), jSONObject)) {
                    throw new Exception("Failed to update attribute");
                }
                return;
            }
            throw new Exception("File does not exist");
        }
        throw new Exception("Missing attributes to update");
    }
}
