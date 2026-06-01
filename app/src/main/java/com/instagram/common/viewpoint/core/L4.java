package com.instagram.common.viewpoint.core;

import java.io.File;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class L4 implements Callable<Void> {
    public final File A00;
    public final /* synthetic */ AbstractC1831jN A01;

    public L4(AbstractC1831jN abstractC1831jN, File file) {
        this.A01 = abstractC1831jN;
        this.A00 = file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        this.A01.A06(this.A00);
        return null;
    }
}
