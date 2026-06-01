package sg.bigo.ads.common.l;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.ironsource.C2300e4;

/* JADX INFO: loaded from: classes6.dex */
final class a {
    @Nullable
    public static sg.bigo.ads.common.a a(@NonNull Context context) {
        try {
            Object objInvoke = AdvertisingIdClient.class.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
            Boolean bool = (Boolean) objInvoke.getClass().getMethod(C2300e4.i.M, null).invoke(objInvoke, null);
            String str = (String) objInvoke.getClass().getMethod("getId", null).invoke(objInvoke, null);
            if (str != null && bool != null) {
                return new sg.bigo.ads.common.a(str, bool.booleanValue());
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
