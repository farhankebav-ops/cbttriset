package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application, String str) {
        this.application = application;
        this.fileName = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ AbstractMessageLite lambda$read$1(Parser parser) throws Exception {
        synchronized (this) {
            try {
                FileInputStream fileInputStreamOpenFileInput = this.application.openFileInput(this.fileName);
                try {
                    AbstractMessageLite abstractMessageLite = (AbstractMessageLite) parser.parseFrom(fileInputStreamOpenFileInput);
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return abstractMessageLite;
                } catch (Throwable th) {
                    if (fileInputStreamOpenFileInput != null) {
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException | FileNotFoundException e) {
                Logging.logi("Recoverable exception while reading cache: " + e.getMessage());
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$write$0(AbstractMessageLite abstractMessageLite) throws Exception {
        synchronized (this) {
            FileOutputStream fileOutputStreamOpenFileOutput = this.application.openFileOutput(this.fileName, 0);
            try {
                fileOutputStreamOpenFileOutput.write(abstractMessageLite.toByteArray());
                fileOutputStreamOpenFileOutput.close();
            } finally {
            }
        }
        return abstractMessageLite;
    }

    public <T extends AbstractMessageLite> s4.h read(Parser<T> parser) {
        return new e5.l(new q(this, parser, 1));
    }

    public s4.a write(AbstractMessageLite abstractMessageLite) {
        return new c5.b(new q(this, abstractMessageLite, 0), 2);
    }
}
