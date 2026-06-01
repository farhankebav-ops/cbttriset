package sg.bigo.ads.controller.c;

import android.graphics.Rect;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private Rect f16474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16475b = 2;

    public g(@NonNull JSONObject jSONObject) {
        String strOptString = jSONObject.optString("start_coordinate");
        String strOptString2 = jSONObject.optString("end_coordinate");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return;
        }
        String[] strArrSplit = strOptString.split(",");
        String[] strArrSplit2 = strOptString2.split(",");
        if (strArrSplit.length == 2 && strArrSplit2.length == 2) {
            try {
                int i2 = (int) (Float.parseFloat(strArrSplit[0]) * 1000.0f);
                int i8 = (int) (Float.parseFloat(strArrSplit2[0]) * 1000.0f);
                int i9 = (int) (Float.parseFloat(strArrSplit[1]) * 1000.0f);
                int i10 = (int) (Float.parseFloat(strArrSplit2[1]) * 1000.0f);
                this.f16474a = new Rect(Math.min(i2, i8), Math.min(i9, i10), Math.max(i2, i8), Math.max(i9, i10));
            } catch (NumberFormatException unused) {
            }
        }
    }
}
