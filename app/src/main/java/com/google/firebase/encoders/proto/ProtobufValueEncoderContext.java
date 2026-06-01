package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class ProtobufValueEncoderContext implements ValueEncoderContext {
    private FieldDescriptor field;
    private final ProtobufDataEncoderContext objEncoderCtx;
    private boolean encoded = false;
    private boolean skipDefault = false;

    public ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    private void checkNotUsed() {
        if (this.encoded) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.encoded = true;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(@Nullable String str) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, str, this.skipDefault);
        return this;
    }

    public void resetContext(FieldDescriptor fieldDescriptor, boolean z2) {
        this.encoded = false;
        this.field = fieldDescriptor;
        this.skipDefault = z2;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(float f4) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, f4, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(double d8) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, d8, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(int i2) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, i2, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(long j) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, j, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(boolean z2) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z2, this.skipDefault);
        return this;
    }

    @Override // com.google.firebase.encoders.ValueEncoderContext
    @NonNull
    public ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, bArr, this.skipDefault);
        return this;
    }
}
