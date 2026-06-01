package sg.bigo.ads.common.o;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    @Nullable
    public static sg.bigo.ads.common.a a(@NonNull final Context context, long j) throws b {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final sg.bigo.ads.common.a[] aVarArr = new sg.bigo.ads.common.a[1];
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        sg.bigo.ads.common.n.d.a(0, new Runnable() { // from class: sg.bigo.ads.common.o.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object objInvoke = Class.forName("com.huawei.hms.ads.identifier.AdvertisingIdClient").getDeclaredMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
                    String string = objInvoke.getClass().getDeclaredMethod("getId", null).invoke(objInvoke, null).toString();
                    Boolean bool = (Boolean) objInvoke.getClass().getDeclaredMethod(C2300e4.i.M, null).invoke(objInvoke, null);
                    if (string != null && bool != null) {
                        aVarArr[0] = new sg.bigo.ads.common.a(string, bool.booleanValue());
                    }
                } catch (Exception unused) {
                    atomicBoolean.set(false);
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        if (atomicBoolean.get()) {
            return aVarArr[0];
        }
        throw new b();
    }
}
