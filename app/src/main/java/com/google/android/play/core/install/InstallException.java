package com.google.android.play.core.install;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.install.model.InstallErrorCode;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class InstallException extends ApiException {
    public InstallException(@InstallErrorCode int i2) {
        super(new Status(i2, String.format(Locale.getDefault(), "Install Error(%d): %s", Integer.valueOf(i2), com.google.android.play.core.install.model.zza.zza(i2))));
        if (i2 == 0) {
            throw new IllegalArgumentException("errorCode should not be 0.");
        }
    }

    @InstallErrorCode
    public int getErrorCode() {
        return super.getStatusCode();
    }
}
