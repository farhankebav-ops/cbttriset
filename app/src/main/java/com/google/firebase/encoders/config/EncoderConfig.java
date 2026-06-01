package com.google.firebase.encoders.config;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface EncoderConfig<T extends EncoderConfig<T>> {
    @NonNull
    <U> T registerEncoder(@NonNull Class<U> cls, @NonNull ObjectEncoder<? super U> objectEncoder);

    @NonNull
    <U> T registerEncoder(@NonNull Class<U> cls, @NonNull ValueEncoder<? super U> valueEncoder);
}
