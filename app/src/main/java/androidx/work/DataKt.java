package androidx.work;

import androidx.work.Data;
import kotlin.jvm.internal.k;
import q5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataKt {
    public static final <T> boolean hasKeyWithValueOfType(Data data, String key) {
        k.e(data, "<this>");
        k.e(key, "key");
        k.k();
        throw null;
    }

    public static final Data workDataOf(i... pairs) throws Throwable {
        k.e(pairs, "pairs");
        Data.Builder builder = new Data.Builder();
        for (i iVar : pairs) {
            builder.put((String) iVar.f13498a, iVar.f13499b);
        }
        Data dataBuild = builder.build();
        k.d(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
