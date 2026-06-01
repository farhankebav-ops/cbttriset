package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface ValueEncoderContext {
    @NonNull
    ValueEncoderContext add(double d8) throws IOException;

    @NonNull
    ValueEncoderContext add(float f4) throws IOException;

    @NonNull
    ValueEncoderContext add(int i2) throws IOException;

    @NonNull
    ValueEncoderContext add(long j) throws IOException;

    @NonNull
    ValueEncoderContext add(@Nullable String str) throws IOException;

    @NonNull
    ValueEncoderContext add(boolean z2) throws IOException;

    @NonNull
    ValueEncoderContext add(@NonNull byte[] bArr) throws IOException;
}
