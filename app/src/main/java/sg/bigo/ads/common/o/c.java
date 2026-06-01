package sg.bigo.ads.common.o;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import sg.bigo.ads.common.utils.r;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15841a = true;

    @NonNull
    @WorkerThread
    public static sg.bigo.ads.common.a a(@NonNull Context context) {
        sg.bigo.ads.common.a aVarA;
        boolean z2;
        if (!f15841a) {
            return new sg.bigo.ads.common.a("", true);
        }
        long jA = r.f16034a.a(15);
        try {
            aVarA = d.a(context, jA);
            z2 = true;
        } catch (b unused) {
            aVarA = null;
            z2 = false;
        }
        if (aVarA != null) {
            return aVarA;
        }
        try {
            aVarA = a.a(context, jA);
        } catch (b unused2) {
            if (!z2) {
                f15841a = false;
            }
        }
        return aVarA != null ? aVarA : new sg.bigo.ads.common.a("", true);
    }
}
