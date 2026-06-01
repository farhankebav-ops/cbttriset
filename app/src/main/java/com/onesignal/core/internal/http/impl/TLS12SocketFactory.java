package com.onesignal.core.internal.http.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class TLS12SocketFactory extends SSLSocketFactory {
    private SSLSocketFactory sslSocketFactory;

    public TLS12SocketFactory(SSLSocketFactory sslSocketFactory) {
        k.e(sslSocketFactory, "sslSocketFactory");
        this.sslSocketFactory = sslSocketFactory;
    }

    private final Socket enableTLS(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        Socket socketCreateSocket = this.sslSocketFactory.createSocket();
        k.d(socketCreateSocket, "sslSocketFactory.createSocket()");
        return enableTLS(socketCreateSocket);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.sslSocketFactory.getDefaultCipherSuites();
        k.d(defaultCipherSuites, "sslSocketFactory.defaultCipherSuites");
        return defaultCipherSuites;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.sslSocketFactory.getSupportedCipherSuites();
        k.d(supportedCipherSuites, "sslSocketFactory.supportedCipherSuites");
        return supportedCipherSuites;
    }

    public final void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        k.e(sSLSocketFactory, "<set-?>");
        this.sslSocketFactory = sSLSocketFactory;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s7, String host, int i2, boolean z2) throws IOException {
        k.e(s7, "s");
        k.e(host, "host");
        Socket socketCreateSocket = this.sslSocketFactory.createSocket(s7, host, i2, z2);
        k.d(socketCreateSocket, "sslSocketFactory.createS…s, host, port, autoClose)");
        return enableTLS(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int i2) throws IOException {
        k.e(host, "host");
        Socket socketCreateSocket = this.sslSocketFactory.createSocket(host, i2);
        k.d(socketCreateSocket, "sslSocketFactory.createSocket(host, port)");
        return enableTLS(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int i2, InetAddress localHost, int i8) throws IOException {
        k.e(host, "host");
        k.e(localHost, "localHost");
        Socket socketCreateSocket = this.sslSocketFactory.createSocket(host, i2, localHost, i8);
        k.d(socketCreateSocket, "sslSocketFactory.createS…rt, localHost, localPort)");
        return enableTLS(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int i2) throws IOException {
        k.e(host, "host");
        Socket socketCreateSocket = this.sslSocketFactory.createSocket(host, i2);
        k.d(socketCreateSocket, "sslSocketFactory.createSocket(host, port)");
        return enableTLS(socketCreateSocket);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int i2, InetAddress localAddress, int i8) throws IOException {
        k.e(address, "address");
        k.e(localAddress, "localAddress");
        Socket socketCreateSocket = this.sslSocketFactory.createSocket(address, i2, localAddress, i8);
        k.d(socketCreateSocket, "sslSocketFactory.createS… localAddress, localPort)");
        return enableTLS(socketCreateSocket);
    }
}
