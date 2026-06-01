package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t3) {
            this.value = t3;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i2);

    public SynchronousResult<O> getSynchronousResult(Context context, I i2) {
        k.e(context, "context");
        return null;
    }

    public abstract O parseResult(int i2, Intent intent);
}
