package sg.bigo.ads.core.d.b;

import androidx.annotation.NonNull;
import com.ironsource.C2300e4;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f16894a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16895b;

    public d(@NonNull String str) {
        this.f16895b = str;
    }

    public final void a(String str, int i2) {
        this.f16894a.put(str, String.valueOf(i2));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("eventId = ");
        sb.append(this.f16895b);
        sb.append(":");
        for (Map.Entry<String, String> entry : this.f16894a.entrySet()) {
            sb.append(entry.getKey());
            sb.append(C2300e4.i.f8399b);
            sb.append(entry.getValue());
            sb.append(",");
        }
        return sb.toString();
    }

    public final void a(String str, long j) {
        this.f16894a.put(str, String.valueOf(j));
    }

    public final void a(String str, String str2) {
        if (q.a((CharSequence) str) || q.a((CharSequence) str2)) {
            return;
        }
        this.f16894a.put(str, str2);
    }

    public final void a(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.f16894a.put(entry.getKey(), entry.getValue());
            }
        }
    }
}
