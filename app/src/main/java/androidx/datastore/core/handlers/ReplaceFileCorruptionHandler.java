package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import e6.l;
import java.io.IOException;
import kotlin.jvm.internal.k;
import v5.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {
    private final l produceNewData;

    public ReplaceFileCorruptionHandler(l produceNewData) {
        k.e(produceNewData, "produceNewData");
        this.produceNewData = produceNewData;
    }

    @Override // androidx.datastore.core.CorruptionHandler
    public Object handleCorruption(CorruptionException corruptionException, c<? super T> cVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
