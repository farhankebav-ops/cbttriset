package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcfo extends SSLSocketFactory {
    final SSLSocketFactory zza;
    final /* synthetic */ zzcfp zzb;

    public zzcfo(zzcfp zzcfpVar) {
        Objects.requireNonNull(zzcfpVar);
        this.zzb = zzcfpVar;
        this.zza = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }

    private final Socket zza(Socket socket) throws SocketException {
        zzcfp zzcfpVar = this.zzb;
        if (zzcfpVar.zzm() > 0) {
            socket.setReceiveBufferSize(zzcfpVar.zzm());
        }
        zzcfpVar.zzl(socket);
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(str, i2);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i2, InetAddress inetAddress, int i8) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(str, i2, inetAddress, i8);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(inetAddress, i2);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i8) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(inetAddress, i2, inetAddress2, i8);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i2, boolean z2) throws IOException {
        Socket socketCreateSocket = this.zza.createSocket(socket, str, i2, z2);
        zza(socketCreateSocket);
        return socketCreateSocket;
    }
}
