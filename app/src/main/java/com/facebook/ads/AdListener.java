package com.facebook.ads;

import androidx.annotation.Keep;
import com.facebook.ads.internal.bench.Benchmark;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public interface AdListener {
    @Benchmark
    void onAdClicked(Ad ad);

    @Benchmark
    void onAdLoaded(Ad ad);

    @Benchmark
    void onError(Ad ad, AdError adError);

    @Benchmark
    void onLoggingImpression(Ad ad);
}
