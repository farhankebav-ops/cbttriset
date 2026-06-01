package sg.bigo.ads.common.u.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import sg.bigo.ads.common.utils.h;
import sg.bigo.ads.common.utils.q;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements c<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputStream f15974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final h<List<String>> f15975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15976d;
    private final Closeable e;

    public a(int i2, int i8, @Nullable InputStream inputStream, @NonNull h<List<String>> hVar, @Nullable Closeable closeable) {
        this.f15976d = i2;
        this.f15973a = i8;
        this.f15974b = inputStream;
        this.f15975c = hVar;
        this.e = closeable;
    }

    public final long a() {
        String strA = a("Content-Length");
        if (!q.b((CharSequence) strA)) {
            return -1L;
        }
        try {
            return Long.parseLong(strA);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @Nullable
    public final String a(String str) {
        List<String> listA;
        if (!TextUtils.isEmpty(str) && (listA = this.f15975c.a(str)) != null && !listA.isEmpty()) {
            for (String str2 : listA) {
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        }
        return "";
    }
}
