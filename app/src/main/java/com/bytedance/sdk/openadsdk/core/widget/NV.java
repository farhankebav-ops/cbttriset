package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.model.oeT;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends Bc {
    private long IlO;
    private long MY;

    public NV(@NonNull Context context) {
        super(context);
        setVisibility(8);
        setClickable(true);
    }

    public void EO() {
        setVisibility(8);
        if (this.IlO != 0) {
            this.MY = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Bc
    public boolean IlO() {
        return false;
    }

    public void MY(oeT oet, int i2) {
        if (isShown()) {
            return;
        }
        MY();
        setVisibility(0);
        this.IlO = SystemClock.elapsedRealtime();
        IlO(oet, i2);
    }

    public long getDisplayDuration() {
        if (this.IlO == 0) {
            return 0L;
        }
        if (this.MY == 0) {
            this.MY = SystemClock.elapsedRealtime();
        }
        return this.MY - this.IlO;
    }

    public boolean tV() {
        return this.IlO > 0 && this.MY > 0;
    }
}
