package org.assistant.qreader.scanner;

import com.github.sarxos.webcam.Webcam;
import org.assistant.qreader.QRDecoder;

import java.awt.image.BufferedImage;

public class ConstantScanner implements Runnable {
    private Webcam webcam;
    private QRDecoder qrDecoder;

    public ConstantScanner(Webcam webcam) {
        this.webcam = webcam;
        qrDecoder = new QRDecoder();
    }

    @Override
    public void run() {
        while (true) {
            if (!webcam.isOpen()) {
                return;
            }

            BufferedImage webCamImg = webcam.getImage();
            String decodedQRCode = qrDecoder.decodeQRCode(webCamImg);
            if (decodedQRCode != null) {
                System.out.println("Code detected: " + decodedQRCode);
            }
        }
    }
}
