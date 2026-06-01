package sg.bigo.ads.common.o;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes6.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f15843b;

    private d(Context context, long j) {
        this.f15842a = context;
        this.f15843b = j;
    }

    @Nullable
    private synchronized sg.bigo.ads.common.a a() {
        f fVarA;
        e eVarA = a(this.f15842a);
        if (eVarA == null) {
            throw new b();
        }
        fVarA = eVarA.a(this.f15843b, TimeUnit.MILLISECONDS);
        if (fVarA == null) {
            eVarA.a();
            throw new b();
        }
        return new sg.bigo.ads.common.a(fVarA.a(), fVarA.b());
    }

    @Nullable
    public static sg.bigo.ads.common.a a(Context context, long j) {
        try {
            return new d(context, j).a();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    private static e a(Context context) {
        boolean zBindService;
        e eVarA = e.a(context);
        if (eVarA.f15846a.isEmpty()) {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                eVarA.f15847b = true;
                zBindService = context.bindService(intent, eVarA, 1);
            } catch (Exception unused) {
            } catch (Throwable th) {
                eVarA.a();
                throw th;
            }
            if (!zBindService) {
                if (zBindService) {
                    return null;
                }
                eVarA.a();
                return null;
            }
            if (!zBindService) {
                eVarA.a();
            }
        }
        return eVarA;
    }
}
