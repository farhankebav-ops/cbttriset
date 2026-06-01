package com.google.android.play.core.review;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ReviewException extends ApiException {
    public ReviewException(int i2) {
        super(new Status(i2, String.format(Locale.getDefault(), "Review Error(%d): %s", Integer.valueOf(i2), com.google.android.play.core.review.model.zza.zza(i2))));
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
