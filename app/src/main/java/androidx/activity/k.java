package androidx.activity;

import android.app.Person;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;
import androidx.camera.camera2.impl.FeatureCombinationQueryImpl$Companion$NO_OP_CALLBACK$1;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class k {
    public static /* bridge */ /* synthetic */ Person f(Parcelable parcelable) {
        return (Person) parcelable;
    }

    public static /* bridge */ /* synthetic */ Person g(Object obj) {
        return (Person) obj;
    }

    public static /* synthetic */ SessionConfiguration k(List list, Executor executor, FeatureCombinationQueryImpl$Companion$NO_OP_CALLBACK$1 featureCombinationQueryImpl$Companion$NO_OP_CALLBACK$1) {
        return new SessionConfiguration(0, list, executor, featureCombinationQueryImpl$Companion$NO_OP_CALLBACK$1);
    }

    public static /* synthetic */ PrecomputedText.Params.Builder n(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    public static /* bridge */ /* synthetic */ PrecomputedText q(Object obj) {
        return (PrecomputedText) obj;
    }

    public static /* synthetic */ void t() {
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
