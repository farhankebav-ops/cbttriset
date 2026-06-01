package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface ObjectEncoderContext {
    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d8) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f4) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i2) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z2) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, double d8) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, int i2) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, long j) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException;

    @NonNull
    @Deprecated
    ObjectEncoderContext add(@NonNull String str, boolean z2) throws IOException;

    @NonNull
    ObjectEncoderContext inline(@Nullable Object obj) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException;

    @NonNull
    ObjectEncoderContext nested(@NonNull String str) throws IOException;
}
