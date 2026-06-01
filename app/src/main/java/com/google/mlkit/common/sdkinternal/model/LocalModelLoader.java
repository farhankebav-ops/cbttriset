package com.google.mlkit.common.sdkinternal.model;

import a1.a;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    @KeepForSdk
    public LocalModelLoader(@NonNull Context context, @NonNull LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    @NonNull
    @KeepForSdk
    public LocalModel getLocalModel() {
        return this.zzc;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public MappedByteBuffer load() throws MlKitException {
        FileChannel channel;
        AssetFileDescriptor assetFileDescriptorZza;
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        LocalModel localModel = this.zzc;
        String absoluteFilePath = localModel.getAbsoluteFilePath();
        String assetFilePath = localModel.getAssetFilePath();
        Uri uri = localModel.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
                try {
                    FileChannel channel2 = randomAccessFile.getChannel();
                    try {
                        this.zza = channel2.map(FileChannel.MapMode.READ_ONLY, 0L, channel2.size());
                        channel2.close();
                        randomAccessFile.close();
                    } finally {
                        throw new MlKitException("Can not open the local file: ".concat(String.valueOf(this.zzc.getAbsoluteFilePath())), 14, e);
                    }
                } finally {
                }
            } catch (IOException e) {
                throw new MlKitException("Can not open the local file: ".concat(String.valueOf(this.zzc.getAbsoluteFilePath())), 14, e);
            }
        } else if (assetFilePath != null) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.zzb.getAssets().openFd(assetFilePath);
                try {
                    channel = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
                        channel.close();
                        assetFileDescriptorOpenFd.close();
                    } finally {
                        if (channel == null) {
                            throw th;
                        }
                        try {
                            channel.close();
                            throw th;
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw new MlKitException(a.m("Can not load the file from asset: ", assetFilePath, ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression"), 14, e);
                    }
                } finally {
                }
            } catch (IOException e4) {
                throw new MlKitException(a.m("Can not load the file from asset: ", assetFilePath, ". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression"), 14, e4);
            }
        } else {
            if (uri == null) {
                throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
            }
            try {
                assetFileDescriptorZza = zzi.zza(this.zzb, uri, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
                try {
                    channel = assetFileDescriptorZza.createInputStream().getChannel();
                } finally {
                }
            } catch (IOException e8) {
                throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e8);
            }
            try {
                this.zza = channel.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorZza.getStartOffset(), assetFileDescriptorZza.getLength());
                channel.close();
                assetFileDescriptorZza.close();
            } finally {
                throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e8);
            }
        }
        return this.zza;
    }
}
