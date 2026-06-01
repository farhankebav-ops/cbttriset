package androidx.room.util;

import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.location.LocationRequestCompat;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FileUtil {
    public static final void copy(ReadableByteChannel input, FileChannel output) throws Throwable {
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        k.e(input, "input");
        k.e(output, "output");
        try {
            try {
                if (Build.VERSION.SDK_INT <= 23) {
                    readableByteChannel = input;
                    fileChannel = output;
                    InputStream inputStreamNewInputStream = Channels.newInputStream(readableByteChannel);
                    OutputStream outputStreamNewOutputStream = Channels.newOutputStream(fileChannel);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = inputStreamNewInputStream.read(bArr);
                        if (i2 <= 0) {
                            break;
                        } else {
                            outputStreamNewOutputStream.write(bArr, 0, i2);
                        }
                    }
                } else {
                    readableByteChannel = input;
                    fileChannel = output;
                    fileChannel.transferFrom(readableByteChannel, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
                }
                fileChannel.force(false);
                readableByteChannel.close();
                fileChannel.close();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                readableByteChannel.close();
                fileChannel.close();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            readableByteChannel = input;
            fileChannel = output;
        }
    }
}
