package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.core.adview.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a<T extends sg.bigo.ads.core.adview.c> extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f15443a;

    public a(@NonNull Context context) {
        super(context);
    }

    @NonNull
    public abstract T a();

    public final boolean a(int i2, int i8) {
        return getViewImpl().a(i2, i8);
    }

    @NonNull
    public final synchronized T getViewImpl() {
        try {
            if (this.f15443a == null) {
                this.f15443a = (T) a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15443a;
    }

    @Override // android.view.View
    @Deprecated
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
