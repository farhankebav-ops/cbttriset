package com.google.android.gms.internal.mlkit_vision_common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.internal.client.a;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.ironsource.C2300e4;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzak implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName(Key.STRING_CHARSET_NAME);
    private static final FieldDescriptor zzb = a.D(1, FieldDescriptor.builder(C2300e4.h.W));
    private static final FieldDescriptor zzc = a.D(2, FieldDescriptor.builder("value"));
    private static final ObjectEncoder zzd = new ObjectEncoder() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzaj
        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            zzak.zzg((Map.Entry) obj, objectEncoderContext);
        }
    };
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final ObjectEncoder zzh;
    private final zzao zzi = new zzao(this);

    public zzak(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    public static /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzb, entry.getKey());
        objectEncoderContext.add(zzc, entry.getValue());
    }

    private static int zzh(FieldDescriptor fieldDescriptor) {
        zzai zzaiVar = (zzai) fieldDescriptor.getProperty(zzai.class);
        if (zzaiVar != null) {
            return zzaiVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final long zzi(ObjectEncoder objectEncoder, Object obj) throws IOException {
        zzaf zzafVar = new zzaf();
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzafVar;
            try {
                objectEncoder.encode(obj, this);
                this.zze = outputStream;
                long jZza = zzafVar.zza();
                zzafVar.close();
                return jZza;
            } catch (Throwable th) {
                this.zze = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                zzafVar.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    private static zzai zzj(FieldDescriptor fieldDescriptor) {
        zzai zzaiVar = (zzai) fieldDescriptor.getProperty(zzai.class);
        if (zzaiVar != null) {
            return zzaiVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final zzak zzk(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z2) throws IOException {
        long jZzi = zzi(objectEncoder, obj);
        if (z2 && jZzi == 0) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 2);
        zzo(jZzi);
        objectEncoder.encode(obj, this);
        return this;
    }

    private final zzak zzl(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z2) throws IOException {
        this.zzi.zza(fieldDescriptor, z2);
        valueEncoder.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.zze.write((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.zze.write(i2 & 127);
    }

    private final void zzo(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.zze.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.zze.write(((int) j) & 127);
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d8) throws IOException {
        zza(fieldDescriptor, d8, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    public final ObjectEncoderContext zza(@NonNull FieldDescriptor fieldDescriptor, double d8, boolean z2) throws IOException {
        if (z2 && d8 == 0.0d) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d8).array());
        return this;
    }

    public final ObjectEncoderContext zzb(@NonNull FieldDescriptor fieldDescriptor, float f4, boolean z2) throws IOException {
        if (z2 && f4 == 0.0f) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f4).array());
        return this;
    }

    public final ObjectEncoderContext zzc(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj, boolean z2) throws IOException {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z2 || charSequence.length() != 0) {
                    zzn((zzh(fieldDescriptor) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(zza);
                    zzn(bytes.length);
                    this.zze.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    zzc(fieldDescriptor, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    zzk(zzd, fieldDescriptor, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    zza(fieldDescriptor, ((Double) obj).doubleValue(), z2);
                    return this;
                }
                if (obj instanceof Float) {
                    zzb(fieldDescriptor, ((Float) obj).floatValue(), z2);
                    return this;
                }
                if (obj instanceof Number) {
                    zze(fieldDescriptor, ((Number) obj).longValue(), z2);
                    return this;
                }
                if (obj instanceof Boolean) {
                    zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z2);
                    return this;
                }
                if (!(obj instanceof byte[])) {
                    ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
                    if (objectEncoder != null) {
                        zzk(objectEncoder, fieldDescriptor, obj, z2);
                        return this;
                    }
                    ValueEncoder valueEncoder = (ValueEncoder) this.zzg.get(obj.getClass());
                    if (valueEncoder != null) {
                        zzl(valueEncoder, fieldDescriptor, obj, z2);
                        return this;
                    }
                    if (obj instanceof zzag) {
                        zzd(fieldDescriptor, ((zzag) obj).zza(), true);
                        return this;
                    }
                    if (obj instanceof Enum) {
                        zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
                        return this;
                    }
                    zzk(this.zzh, fieldDescriptor, obj, z2);
                    return this;
                }
                byte[] bArr = (byte[]) obj;
                if (!z2 || bArr.length != 0) {
                    zzn((zzh(fieldDescriptor) << 3) | 2);
                    zzn(bArr.length);
                    this.zze.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    public final zzak zzd(@NonNull FieldDescriptor fieldDescriptor, int i2, boolean z2) throws IOException {
        if (!z2 || i2 != 0) {
            zzai zzaiVarZzj = zzj(fieldDescriptor);
            zzah zzahVar = zzah.DEFAULT;
            int iOrdinal = zzaiVarZzj.zzb().ordinal();
            if (iOrdinal == 0) {
                zzn(zzaiVarZzj.zza() << 3);
                zzn(i2);
                return this;
            }
            if (iOrdinal == 1) {
                zzn(zzaiVarZzj.zza() << 3);
                zzn((i2 + i2) ^ (i2 >> 31));
                return this;
            }
            if (iOrdinal == 2) {
                zzn((zzaiVarZzj.zza() << 3) | 5);
                this.zze.write(zzm(4).putInt(i2).array());
                return this;
            }
        }
        return this;
    }

    public final zzak zze(@NonNull FieldDescriptor fieldDescriptor, long j, boolean z2) throws IOException {
        if (!z2 || j != 0) {
            zzai zzaiVarZzj = zzj(fieldDescriptor);
            zzah zzahVar = zzah.DEFAULT;
            int iOrdinal = zzaiVarZzj.zzb().ordinal();
            if (iOrdinal == 0) {
                zzn(zzaiVarZzj.zza() << 3);
                zzo(j);
                return this;
            }
            if (iOrdinal == 1) {
                zzn(zzaiVarZzj.zza() << 3);
                zzo((j >> 63) ^ (j + j));
                return this;
            }
            if (iOrdinal == 2) {
                zzn((zzaiVarZzj.zza() << 3) | 1);
                this.zze.write(zzm(8).putLong(j).array());
                return this;
            }
        }
        return this;
    }

    public final zzak zzf(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder == null) {
            throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        objectEncoder.encode(obj, this);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f4) throws IOException {
        zzb(fieldDescriptor, f4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i2) throws IOException {
        zzd(fieldDescriptor, i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j) throws IOException {
        zze(fieldDescriptor, j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        zzc(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z2) throws IOException {
        zzd(fieldDescriptor, z2 ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, double d8) throws IOException {
        zza(FieldDescriptor.of(str), d8, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, int i2) throws IOException {
        zzd(FieldDescriptor.of(str), i2, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, long j) throws IOException {
        zze(FieldDescriptor.of(str), j, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        zzc(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, boolean z2) throws IOException {
        zzd(FieldDescriptor.of(str), z2 ? 1 : 0, true);
        return this;
    }
}
