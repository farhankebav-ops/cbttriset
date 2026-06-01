package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import kotlin.jvm.internal.k;
import q5.f;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultCallerLauncher<I, O> extends ActivityResultLauncher<x> {
    private final ActivityResultContract<I, O> callerContract;
    private final I callerInput;
    private final ActivityResultContract<x, O> contract;
    private final ActivityResultLauncher<I> launcher;
    private final f resultContract$delegate;

    public ActivityResultCallerLauncher(ActivityResultLauncher<I> launcher, ActivityResultContract<I, O> callerContract, I i2) {
        k.e(launcher, "launcher");
        k.e(callerContract, "callerContract");
        this.launcher = launcher;
        this.callerContract = callerContract;
        this.callerInput = i2;
        this.resultContract$delegate = n7.b.C(new b(this, 0));
        this.contract = getResultContract();
    }

    private final ActivityResultContract<x, O> getResultContract() {
        return (ActivityResultContract) this.resultContract$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityResultCallerLauncher$resultContract$2$1 resultContract_delegate$lambda$0(final ActivityResultCallerLauncher activityResultCallerLauncher) {
        return new ActivityResultContract<x, O>(activityResultCallerLauncher) { // from class: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1
            final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

            {
                this.this$0 = activityResultCallerLauncher;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public O parseResult(int i2, Intent intent) {
                return (O) this.this$0.getCallerContract().parseResult(i2, intent);
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, x input) {
                k.e(context, "context");
                k.e(input, "input");
                return this.this$0.getCallerContract().createIntent(context, this.this$0.getCallerInput());
            }
        };
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    public final I getCallerInput() {
        return this.callerInput;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<x, ?> getContract() {
        return this.contract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void launch(x input, ActivityOptionsCompat activityOptionsCompat) {
        k.e(input, "input");
        this.launcher.launch(this.callerInput, activityOptionsCompat);
    }
}
