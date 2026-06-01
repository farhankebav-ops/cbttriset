package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class FakeReviewManager implements ReviewManager {
    private final Context zza;
    private ReviewInfo zzb;
    private int zzc = 0;

    public FakeReviewManager(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    @NonNull
    public Task<Void> launchReviewFlow(@NonNull Activity activity, @NonNull ReviewInfo reviewInfo) {
        if (reviewInfo != this.zzb) {
            return Tasks.forException(new ReviewException(-2));
        }
        this.zzc++;
        return Tasks.forResult(null);
    }

    @Override // com.google.android.play.core.review.ReviewManager
    @NonNull
    public Task<ReviewInfo> requestReviewFlow() {
        ReviewInfo reviewInfoZzc = ReviewInfo.zzc(PendingIntent.getBroadcast(this.zza, 0, new Intent(), AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL), false);
        this.zzb = reviewInfoZzc;
        return Tasks.forResult(reviewInfoZzc);
    }
}
