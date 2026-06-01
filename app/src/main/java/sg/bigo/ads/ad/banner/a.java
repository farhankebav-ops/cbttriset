package sg.bigo.ads.ad.banner;

import androidx.annotation.NonNull;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sg.bigo.ads.api.AdSize;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    @NonNull
    public static JSONArray a(@NonNull List<AdSize> list) {
        JSONArray jSONArray = new JSONArray();
        for (AdSize adSize : list) {
            if (adSize != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("w", adSize.getWidth());
                    jSONObject.put("h", adSize.getHeight());
                    jSONObject.put("t", AdSize.ADAPTIVE.equals(adSize.f15431a) ? 1 : 0);
                } catch (JSONException unused) {
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
