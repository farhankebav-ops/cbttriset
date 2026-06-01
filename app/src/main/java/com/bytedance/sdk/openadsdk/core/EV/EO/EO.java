package com.bytedance.sdk.openadsdk.core.EV.EO;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {

    @NonNull
    private final List<String> IlO;

    @NonNull
    private final Map<MY, String> MY;

    public EO(@NonNull List<String> list) {
        this.IlO = list;
        HashMap map = new HashMap();
        this.MY = map;
        map.put(MY.CACHEBUSTING, MY());
    }

    @NonNull
    private String MY() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    @NonNull
    public List<String> IlO() {
        ArrayList arrayList = new ArrayList();
        for (String strReplaceAll : this.IlO) {
            if (!TextUtils.isEmpty(strReplaceAll)) {
                for (MY my : MY.values()) {
                    String str = this.MY.get(my);
                    if (str == null) {
                        str = "";
                    }
                    strReplaceAll = strReplaceAll.replaceAll("\\[" + my.name() + "\\]", str);
                }
                arrayList.add(strReplaceAll);
            }
        }
        return arrayList;
    }

    @NonNull
    private String MY(long j) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d:%02d.%03d", Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000));
    }

    @NonNull
    public EO IlO(@Nullable com.bytedance.sdk.openadsdk.core.EV.IlO.IlO ilO) {
        if (ilO != null) {
            this.MY.put(MY.ERRORCODE, ilO.IlO());
        }
        return this;
    }

    @NonNull
    public EO IlO(@Nullable long j) {
        if (j >= 0) {
            String strMY = MY(j);
            if (!TextUtils.isEmpty(strMY)) {
                this.MY.put(MY.CONTENTPLAYHEAD, strMY);
            }
        }
        return this;
    }

    @NonNull
    public EO IlO(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, Key.STRING_CHARSET_NAME);
            } catch (Throwable unused) {
            }
            this.MY.put(MY.ASSETURI, str);
        }
        return this;
    }
}
